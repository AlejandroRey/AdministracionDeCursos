package presentacion.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.SwingConstants;

public class LoginVista {

	private JFrame loginFrame;
	private JTextField usuarioField;
	private JPasswordField contraseniaField;
	private JLabel lblCompletaTusDatos;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	
	public LoginVista() {
		initialize();
	}

	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setTitle("Bienvenido al sistema");
		loginFrame.setBounds(100, 100, 497, 304);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.getContentPane().setLayout(null);
		cargarContenido();
		loginFrame.setVisible(true);
	}
	
	private void cargarContenido() {
		lblCompletaTusDatos = new JLabel("Completa tus datos para comenzar");
		lblCompletaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompletaTusDatos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCompletaTusDatos.setIcon(new ImageIcon(LoginVista.class.getResource("/presentacion/imagenes/login.png")));
		lblCompletaTusDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompletaTusDatos.setBounds(51, 11, 378, 84);
		loginFrame.getContentPane().add(lblCompletaTusDatos);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(69, 106, 46, 14);
		loginFrame.getContentPane().add(lblUsuario);
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(69, 143, 85, 14);
		loginFrame.getContentPane().add(lblContrasenia);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(164, 105, 245, 20);
		loginFrame.getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		contraseniaField = new JPasswordField();
		contraseniaField.setBounds(164, 142, 245, 20);
		loginFrame.getContentPane().add(contraseniaField);
		contraseniaField.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSesion.setBounds(299, 194, 130, 31);
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
