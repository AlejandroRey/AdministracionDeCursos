package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import presentacion.vista.UsuarioCambioContraseñaVista;

public class UsuarioCambioContraseñaVistaControlador implements ActionListener{

	private UsuarioCambioContraseñaVista vista;
	private AdministracionDeCursos modelo;
	
	public UsuarioCambioContraseñaVistaControlador(UsuarioCambioContraseñaVista vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnAceptar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnAceptar()) {
			if(this.vista.getContraseniaField().getText().toString().length() != 0) {
				this.modelo.getUsuarioLogueado().setPassword(this.vista.getContraseniaField().getText().toString());
				this.modelo.actualizarUsuario(this.modelo.getUsuarioLogueado());
				JOptionPane.showMessageDialog(null, "Se ha realizado el cambio de contraseña exitosamente!", "Cambio de Contraseña", JOptionPane.INFORMATION_MESSAGE);
				this.vista.getCambioContraseñaFrame().dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Ingresa al menos un digito", "Cambio de Contraseña", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	public void inicializar() {
		
	}	
	
}
