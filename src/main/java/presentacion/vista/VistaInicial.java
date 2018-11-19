package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VistaInicial {

	private JFrame frmBienvenidoAlSistema;
	private JLabel lblMensajePrincipal;
	private JButton btnSupervisor;
	private JButton btnAdministrativo;
	private JButton btnInstructor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicial window = new VistaInicial();
					window.frmBienvenidoAlSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBienvenidoAlSistema = new JFrame();
		frmBienvenidoAlSistema.setTitle("Bienvenido al sistema");
		frmBienvenidoAlSistema.setBounds(100, 100, 451, 229);
		frmBienvenidoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBienvenidoAlSistema.getContentPane().setLayout(null);
		frmBienvenidoAlSistema.setVisible(true);
		
		lblMensajePrincipal = new JLabel("Iniciar sesión como:");
		lblMensajePrincipal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensajePrincipal.setBounds(157, 11, 129, 17);
		frmBienvenidoAlSistema.getContentPane().add(lblMensajePrincipal);
		
		btnSupervisor = new JButton("Supervisor");
		btnSupervisor.setBounds(45, 39, 344, 37);
		frmBienvenidoAlSistema.getContentPane().add(btnSupervisor);
		
		btnAdministrativo = new JButton("Administrativo");
		btnAdministrativo.setBounds(45, 87, 344, 37);
		frmBienvenidoAlSistema.getContentPane().add(btnAdministrativo);
		
		btnInstructor = new JButton("Instructor");
		btnInstructor.setBounds(45, 135, 344, 37);
		frmBienvenidoAlSistema.getContentPane().add(btnInstructor);
	}

	public JButton getBtnSupervisor() {
		return btnSupervisor;
	}

	public JButton getBtnAdministrativo() {
		return btnAdministrativo;
	}

	public JButton getBtnInstructor() {
		return btnInstructor;
	}

	public JFrame getFrmBienvenidoAlSistema() {
		return frmBienvenidoAlSistema;
	}
}
