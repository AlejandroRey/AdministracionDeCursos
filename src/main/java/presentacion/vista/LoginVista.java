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
import javax.swing.JPanel;

public class LoginVista {

	private JFrame loginFrame;
	private JTextField usuarioField;
	private JPasswordField contraseniaField;
	private JLabel lblCompletaTusDatos;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	private JLabel lblLogin;
	private JPanel panel;
	
	public LoginVista() {
		initialize();
	}

	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setTitle("Bienvenido al sistema");
		loginFrame.setBounds(100, 100, 497, 296);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.getContentPane().setLayout(null);
		cargarContenido();
		loginFrame.setVisible(true);
	}
	
	private void cargarContenido() {
		panel = new JPanel();
		panel.setBounds(0, 0, 481, 257);
		panel.setLayout(null);
		loginFrame.getContentPane().add(panel);
		
		lblCompletaTusDatos = new JLabel("Completa tus datos para comenzar");
		lblCompletaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompletaTusDatos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCompletaTusDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompletaTusDatos.setBounds(147, 10, 252, 84);
		panel.add(lblCompletaTusDatos);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(69, 106, 46, 14);
		panel.add(lblUsuario);
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(69, 143, 85, 14);
		panel.add(lblContrasenia);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(164, 105, 245, 20);
		panel.add(usuarioField);
		usuarioField.setColumns(10);
		
		contraseniaField = new JPasswordField();
		contraseniaField.setBounds(164, 142, 245, 20);
		panel.add(contraseniaField);
		contraseniaField.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSesion.setBounds(299, 194, 130, 31);
		panel.add(btnIniciarSesion);
		
		lblLogin = new JLabel("");
		lblLogin.setBounds(67, 25, 70, 60);
		lblLogin.setIcon(new ImageIcon(LoginVista.class.getResource("/presentacion/imagenes/Login.png")));
		panel.add(lblLogin);
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
