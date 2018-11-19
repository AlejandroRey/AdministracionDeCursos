package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JLabel;

public class SupervisorVista {

	private JFrame frmSupervisor;
	private JButton btnRecados;
	private JLabel lblMensajePrincipal;
	private JButton btnAdministrativos;
	private JButton btnTareas;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenu mnBaseDeDatos;
	private JMenuItem mntmImportar;
	private JMenuItem mntmExportar;
	private JMenuItem mntmCambiarContrasena;
	private JMenuItem mntmCerrarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisorVista window = new SupervisorVista();
					window.frmSupervisor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupervisorVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSupervisor = new JFrame();
		frmSupervisor.setTitle("Supervisor");
		frmSupervisor.setBounds(100, 100, 449, 259);
		frmSupervisor.setLocationRelativeTo(null);
		frmSupervisor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSupervisor.getContentPane().setLayout(null);
		frmSupervisor.setVisible(true);
		
		btnRecados = new JButton("Recados");
		btnRecados.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecados.setBounds(58, 140, 301, 36);
		frmSupervisor.getContentPane().add(btnRecados);
		
		lblMensajePrincipal = new JLabel("Seleccione la opción que desea administrar");
		lblMensajePrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMensajePrincipal.setBounds(48, 11, 341, 23);
		frmSupervisor.getContentPane().add(lblMensajePrincipal);
		
		btnAdministrativos = new JButton("Personal administrativo");
		btnAdministrativos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdministrativos.setBounds(58, 46, 301, 36);
		frmSupervisor.getContentPane().add(btnAdministrativos);
		
		btnTareas = new JButton("Tareas");
		btnTareas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTareas.setBounds(58, 93, 301, 36);
		frmSupervisor.getContentPane().add(btnTareas);
		
		menuBar = new JMenuBar();
		frmSupervisor.setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mnBaseDeDatos = new JMenu("Base de datos");
		mnMenu.add(mnBaseDeDatos);
		
		mntmImportar = new JMenuItem("Importar");
		mnBaseDeDatos.add(mntmImportar);
		
		mntmExportar = new JMenuItem("Exportar");
		mnBaseDeDatos.add(mntmExportar);
		
		mntmCambiarContrasena = new JMenuItem("Cambiar contraseña");
		mnMenu.add(mntmCambiarContrasena);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mnMenu.add(mntmCerrarSesion);
	}

	public JButton getBtnRecados() {
		return btnRecados;
	}

	public JButton getBtnAdministrativos() {
		return btnAdministrativos;
	}

	public JButton getBtnTareas() {
		return btnTareas;
	}

	public JMenu getMnMenu() {
		return mnMenu;
	}

	public JMenu getMnBaseDeDatos() {
		return mnBaseDeDatos;
	}

	public JMenuItem getMntmImportar() {
		return mntmImportar;
	}

	public JMenuItem getMntmExportar() {
		return mntmExportar;
	}

	public JMenuItem getMntmCambiarContrasena() {
		return mntmCambiarContrasena;
	}

	public JMenuItem getMntmCerrarSesion() {
		return mntmCerrarSesion;
	}

	public JFrame getFrmSupervisor() {
		return frmSupervisor;
	}

}
