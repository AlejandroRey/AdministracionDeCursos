package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class UsuarioCambioContraseñaVista {

	private JFrame cambioContraseñaFrame;
	private JPasswordField contraseniaField;
	private JLabel lblCambioContraseña;
	private JLabel lblNuevaContrasenia;
	private JButton btnAceptar;
	
	public UsuarioCambioContraseñaVista() {
		initialize();
	}

	private void initialize() {
		cambioContraseñaFrame = new JFrame();
		cambioContraseñaFrame.setTitle("Cambiar contraseña");
		cambioContraseñaFrame.setBounds(100, 100, 438, 185);
		cambioContraseñaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cambioContraseñaFrame.setLocationRelativeTo(null);
		cambioContraseñaFrame.getContentPane().setLayout(null);
		cargarContenido();
		cambioContraseñaFrame.setVisible(true);
	}
	
	private void cargarContenido() {
		lblCambioContraseña = new JLabel("Ingresar la nueva contraseña");
		lblCambioContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCambioContraseña.setBounds(86, 11, 260, 30);
		cambioContraseñaFrame.getContentPane().add(lblCambioContraseña);
		
		lblNuevaContrasenia = new JLabel("Nueva contraseña:");
		lblNuevaContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNuevaContrasenia.setBounds(26, 57, 116, 14);
		cambioContraseñaFrame.getContentPane().add(lblNuevaContrasenia);
		
		contraseniaField = new JPasswordField();
		contraseniaField.setBounds(157, 57, 178, 20);
		cambioContraseñaFrame.getContentPane().add(contraseniaField);
		contraseniaField.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(291, 106, 122, 23);
		cambioContraseñaFrame.getContentPane().add(btnAceptar);
	}

	public JPasswordField getContraseniaField() {
		return contraseniaField;
	}

	public void setContraseniaField(JPasswordField contraseniaField) {
		this.contraseniaField = contraseniaField;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JFrame getCambioContraseñaFrame() {
		return cambioContraseñaFrame;
	}

	public void setCambioContraseñaFrame(JFrame cambioContraseñaFrame) {
		this.cambioContraseñaFrame = cambioContraseñaFrame;
	}

}
