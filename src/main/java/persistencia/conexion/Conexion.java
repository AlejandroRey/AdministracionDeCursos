package persistencia.conexion;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class Conexion {
	public static Conexion instancia;
	private static ResultSet res;
	private static Connection con;
	private static Statement st;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);

	private Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gestiondecursos?autoReconnect=true&useSSL=false", "root", "root");
			log.info("Conexión exitosa");
		} catch (Exception e) {
			log.error("Conexión fallida", e);
		}
	}

	public static Conexion getConexion() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() {
		return this.connection;
	}

	public void cerrarConexion() {
		try {
			this.connection.close();
			log.info("Conexion cerrada");
		} catch (SQLException e) {
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}

	public static String obtenerDatos(String host, String port, String user, String password, String db) {
		int BUFFER = 99999;

		String Mysqlpath = getMysqlBinPath(user, password, db);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Mysqlpath);
		Process run = null;
		try {
			System.out.println(Mysqlpath + "mysqldump --host=" + host + " --port=" + port + " --user=" + user
					+ " --password=" + password + " --compact --complete-insert --extended-insert "
					+ "--skip-comments --skip-triggers " + db);
			run = Runtime.getRuntime().exec(Mysqlpath + "mysqldump --host=" + host + " --port=" + port + " --user="
					+ user + " --password=" + password + "  " + "--skip-comments --skip-triggers " + db);
		} catch (IOException ex) {
		}

		InputStream in = run.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuffer temp = new StringBuffer();

		int count;
		char[] cbuf = new char[BUFFER];

		try {

			while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
				temp.append(cbuf, 0, count);
			}
		} catch (IOException ex) {
		}
		try {
			br.close();
			in.close();
		} catch (IOException ex) {
		}
		return temp.toString();
	}

	public static String getMysqlBinPath(String user, String password, String db) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("yaha dekho");
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String a = "";

		try {
			res = st.executeQuery("select @@basedir");
			while (res.next()) {
				a = res.getString(1);
			}
		} catch (Exception eee) {
			eee.printStackTrace();
		}
		a = a + "bin\\";
		System.err.println("Mysql path is :" + a);
		return a;

	}

	public static void Restoredbfromsql(String s) {
		try {
			/* NOTE: String s is the mysql file name including the .sql in its name */
			/* NOTE: Getting path to the Jar file being executed */
			/* NOTE: YourImplementingClass-> replace with the class executing the code */
			CodeSource codeSource = Conexion.class.getProtectionDomain().getCodeSource();
			File jarFile = new File(codeSource.getLocation().toURI().getPath());
			String jarDir = jarFile.getParentFile().getPath();

			/* NOTE: Creating Database Constraints */
			String dbName = "gestiondecursos";
			String dbUser = "root";
			String dbPass = "root";

			/* NOTE: Creating Path Constraints for restoring */
			String restorePath = jarDir + "\\backup" + "\\" + s;

			System.out.println(restorePath);

			/* NOTE: Used to create a cmd command */
			/*
			 * NOTE: Do not create a single large string, this will cause buffer locking,
			 * use string array
			 */
			// String[] executeCmd = new String[]{"mysql", dbName, "-u" + dbUser, "-p" +
			// dbPass, "-e", " source " + restorePath};
			String executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u" + dbUser + " -p"
					+ dbPass + " --database " + dbName + " -r " + s;

			/*
			 * NOTE: processComplete=0 if correctly executed, will contain other values if
			 * not
			 */
			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			/*
			 * NOTE: processComplete=0 if correctly executed, will contain other values if
			 * not
			 */
			if (processComplete == 0) {
				JOptionPane.showMessageDialog(null, "Successfully restored from SQL : " + s);
			} else {
				JOptionPane.showMessageDialog(null, "Error at restoring, " + processComplete);
			}

		} catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
		}

	}

}
