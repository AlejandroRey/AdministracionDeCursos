package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import presentacion.vista.InstructorVista;

public class InstructorVistaControlador implements ActionListener {
	
	private InstructorVista vista;
	
	public InstructorVistaControlador (InstructorVista vista) {
		super();
		this.vista = vista;
		
		this.vista.getBtnCerrarSesion().addActionListener(this);
		this.vista.getBtnConsultarAsignaciones().addActionListener(this);
		this.vista.getBtnRecados().addActionListener(this);
		this.vista.getBtnRegistrar().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnCerrarSesion()) {
			this.vista.getFrmInstructor().dispose();
		}
		
		if (e.getSource() == this.vista.getBtnRecados()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no esta desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == this.vista.getBtnConsultarAsignaciones()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no esta desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == this.vista.getBtnRegistrar()) {
			
		}
	}

}
