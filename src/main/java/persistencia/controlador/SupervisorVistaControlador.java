package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import presentacion.vista.SupervisorVista;
import presentacion.vista.VistaInicial;

public class SupervisorVistaControlador implements ActionListener {

	private SupervisorVista vista;
	private VistaInicial vistaInicial;
	private VistaInicialControlador vistaInicialControlador;
	
	public SupervisorVistaControlador(SupervisorVista vista) {
		super();
		this.vista = vista;
		
		this.vista.getBtnAdministrativos().addActionListener(this);
		this.vista.getBtnRecados().addActionListener(this);
		this.vista.getBtnTareas().addActionListener(this);
		this.vista.getMntmCambiarContrasena().addActionListener(this);
		this.vista.getMntmCerrarSesion().addActionListener(this);
		this.vista.getMntmExportar().addActionListener(this);
		this.vista.getMntmImportar().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getMntmCerrarSesion()) {
			this.vista.getFrmSupervisor().dispose();
			this.vistaInicial = new VistaInicial();
			this.vistaInicialControlador = new VistaInicialControlador(vistaInicial);
			vistaInicialControlador.inicializar();
		}
	
		if (e.getSource() == this.vista.getMntmImportar()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getMntmExportar()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getMntmCambiarContrasena()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnRecados()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnAdministrativos()) {
			
		}
		if (e.getSource() == this.vista.getBtnTareas()) {
			
		}
	}
}
