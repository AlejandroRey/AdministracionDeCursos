package persistencia.controlador;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.conexion.Conexion;

public class BaseDeDatosVistaControlador {

	private JFrame frame;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnbackup;
	private javax.swing.JButton btnchoose;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField txtbackuppath;
	private javax.swing.JTextField txtdatabase;
	private javax.swing.JTextField txtpassword;
	private javax.swing.JTextField txtusername;
	private static String accion;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BaseDeDatosVistaControlador window = new BaseDeDatosVistaControlador(accion);
//					window.frame.setVisible(true);
//					window.frame.setLocationRelativeTo(null);
//					window.frame.getContentPane().setLayout(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public BaseDeDatosVistaControlador(String string) {
		this.accion = string;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 248);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

//		frame.setBounds(new Rectangle(0, 0, 418, 240));
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBounds(0, 0, 418, 211);
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(15, 26, 60, 20);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(15, 62, 85, 20);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(15, 98, 105, 20);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(15, 132, 85, 20);
		txtusername = new javax.swing.JTextField();
		txtusername.setBounds(125, 23, 160, 26);
		txtusername.setText("root");
		txtbackuppath = new javax.swing.JTextField();
		txtbackuppath.setBounds(125, 129, 160, 26);
		txtdatabase = new javax.swing.JTextField();
		txtdatabase.setBounds(125, 95, 160, 26);
		txtdatabase.setText("gestiondecursos");
		txtpassword = new javax.swing.JTextField();
		txtpassword.setBounds(125, 59, 160, 26);
		txtpassword.setText("Accenture");
		btnchoose = new javax.swing.JButton();
		btnchoose.setBounds(300, 132, 73, 29);
		btnbackup = new javax.swing.JButton();
		btnbackup.setBounds(135, 171, 149, 29);

		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		if(accion.equals("Exportar")) {
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exportar",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Agency FB", 1, 10)));
		} else {
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importar",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Agency FB", 1, 10)));
		}
		
		jLabel1.setText("Usuario:");
		jLabel2.setText("Contraseña:");
		jLabel3.setText("Base de Datos:");
		if(accion.equals("Exportar")) {
			jLabel4.setText("Guardar en:");
		} else {
			jLabel4.setText("Obtener de:");
		}
		btnchoose.setText("Elegir");
		btnchoose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnchooseActionPerformed(evt);
			}
		});
		
		if(accion.equals("Exportar")) {
			btnbackup.setText("Realizar Backup");
		} else {
			btnbackup.setText("Importar Backup");
		}
		btnbackup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnbackupActionPerformed(evt);
			}
		});
		frame.getContentPane().setLayout(null);
		jPanel1.setLayout(null);
		jPanel1.add(jLabel4);
		jPanel1.add(txtbackuppath);
		jPanel1.add(btnchoose);
		jPanel1.add(jLabel1);
		jPanel1.add(txtusername);
		jPanel1.add(jLabel2);
		jPanel1.add(txtpassword);
		jPanel1.add(jLabel3);
		jPanel1.add(txtdatabase);
		jPanel1.add(btnbackup);
		frame.getContentPane().add(jPanel1);

	}

	private void btnchooseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnchooseActionPerformed
		txtbackuppath.setText(getBackUpPath());
	}

	private void btnbackupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnbackupActionPerformed
		
		if(accion.equals("Exportar")) {
			String backuppath = txtbackuppath.getText();
			String Database = txtdatabase.getText();
			String Password = txtpassword.getText();
			String user = txtusername.getText();
			try {
				byte[] data = Conexion.obtenerDatos("localhost", "3306", user, Password, Database).getBytes();
				File filedst = new File(backuppath + ".sql");
				FileOutputStream dest = new FileOutputStream(filedst);
				dest.write(data);
				dest.close();
				JOptionPane.showMessageDialog(null, "Backup exitoso!" + "\n" + "Para la base: " + Database + "\n"
						+ "Realizado: " + stringDateFormatter(LocalDateTime.now()), "Backup", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Fallo!" + "\n" + "Para la base: " + Database + "\n " + "Realizado: " + stringDateFormatter(LocalDateTime.now()),
						"Backup", JOptionPane.INFORMATION_MESSAGE);
				ex.printStackTrace();
			}
		} else if(accion.equals("Importar")) {
			Conexion.Restoredbfromsql("C:\\Users\\jgpao\\Desktop\\Gestion de Cursos - 27-11-2018.sql");
			//JOptionPane.showMessageDialog(null, "Se va a cerrar la aplicacion, por favor abrala nuevamente.", "Importar Base de Datos", JOptionPane.INFORMATION_MESSAGE);
			//System.exit(1);
		}

	}

	public static String getBackUpPath() {

		String backUpPath = "";
		JFileChooser fc = null;
		if (fc == null) {
			fc = new JFileChooser();
			if(accion.equals("Exportar")) {
				fc.setSelectedFile(new File("Gestion de Cursos " + stringDateFormatter(LocalDateTime.now())));
			} else {
				fc.setSelectedFile(new File(""));
			}
			
		}
		int returnVal = fc.showDialog(null, "Seleccionar");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			backUpPath = file.getAbsolutePath();
		}
		return backUpPath;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private static String stringDateFormatter(LocalDateTime fecha) {
		String formatDateTime = "";
		if (fecha != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			formatDateTime = fecha.format(formatter);
		}
		return formatDateTime;
	}

}
