package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginVista {

	private JFrame loginFrame;
	private JTextField usuarioField;
	private JPasswordField contraseniaField;
	private JLabel lblCompletaTusDatos;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVista window = new LoginVista();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginVista() {
		initialize();
		cargarContenido();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setTitle("Bienvenido al sistema");
		loginFrame.setBounds(100, 100, 450, 208);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setVisible(true);
	}
	
	private void cargarContenido() {
		lblCompletaTusDatos = new JLabel("Completa tus datos para comenzar");
		lblCompletaTusDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompletaTusDatos.setBounds(86, 11, 260, 30);
		loginFrame.getContentPane().add(lblCompletaTusDatos);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(61, 53, 46, 14);
		loginFrame.getContentPane().add(lblUsuario);
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(61, 90, 85, 14);
		loginFrame.getContentPane().add(lblContrasenia);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(156, 52, 178, 20);
		loginFrame.getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		contraseniaField = new JPasswordField();
		contraseniaField.setBounds(156, 89, 178, 20);
		loginFrame.getContentPane().add(contraseniaField);
		contraseniaField.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSesion.setBounds(286, 128, 122, 23);
		loginFrame.getContentPane().add(btnIniciarSesion);
	}

	public JTextField getUsuarioField() {
		return usuarioField;
	}

	public JTextField getContraseniaField() {
		return contraseniaField;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}
}
