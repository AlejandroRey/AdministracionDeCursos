package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InstructorVista {

	//-------JFrame-------
	private JFrame frmInstructor;
	
	//-------JLabel-------
	private JLabel lblSeleccionesLaOpcin;
	
	//------JButton-------
	private JButton btnRegistrar;
	private JButton btnNotificaciones;
	private JButton btnRecados;
	private JButton btnCerrarSesion;	
	private JButton buttonCambiarContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorVista window = new InstructorVista();
					window.frmInstructor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstructorVista() {
		initialize();
		cargarContenido();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInstructor = new JFrame();
		frmInstructor.setTitle("Instructor");
		frmInstructor.setBounds(100, 100, 450, 335);
		frmInstructor.setLocationRelativeTo(null);
		frmInstructor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstructor.getContentPane().setLayout(null);
		frmInstructor.setVisible(true);
	}
	
	private void cargarContenido() {
		lblSeleccionesLaOpcin = new JLabel("Selecciones la opción deseada:");
		lblSeleccionesLaOpcin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeleccionesLaOpcin.setBounds(92, 11, 277, 22);
		frmInstructor.getContentPane().add(lblSeleccionesLaOpcin);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.setBounds(46, 44, 323, 36);
		frmInstructor.getContentPane().add(btnRegistrar);
		
		btnNotificaciones = new JButton("Notificaciones");
		btnNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNotificaciones.setBounds(46, 91, 323, 36);
		frmInstructor.getContentPane().add(btnNotificaciones);
		
		btnRecados = new JButton("Recados");
		btnRecados.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecados.setBounds(46, 138, 323, 36);
		frmInstructor.getContentPane().add(btnRecados);
		
		btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrarSesion.setBounds(46, 242, 323, 36);
		frmInstructor.getContentPane().add(btnCerrarSesion);
		
		buttonCambiarContrasenia = new JButton("Cambiar Contraseña");
		buttonCambiarContrasenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonCambiarContrasenia.setBounds(46, 190, 323, 36);
		frmInstructor.getContentPane().add(buttonCambiarContrasenia);
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnNotificaciones() {
		return btnNotificaciones;
	}

	public JButton getBtnRecados() {
		return btnRecados;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public JFrame getFrmInstructor() {
		return frmInstructor;
	}

	public JButton getButtonCambiarContrasenia() {
		return buttonCambiarContrasenia;
	}

	public void setButtonCambiarContrasenia(JButton buttonCambiarContrasenia) {
		this.buttonCambiarContrasenia = buttonCambiarContrasenia;
	}
	
	
}