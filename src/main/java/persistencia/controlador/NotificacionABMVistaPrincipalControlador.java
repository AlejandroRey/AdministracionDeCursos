package persistencia.controlador;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.InstructorVista;
import presentacion.vista.NotificacionABMVistaPrincipal;
import presentacion.vista.SupervisorAdministracionVista;
import presentacion.vista.SupervisorVista;

public class NotificacionABMVistaPrincipalControlador {

	private NotificacionABMVistaPrincipal vista;
	private AdministracionDeCursos modelo;
	private AdministracionDeCursosVista administracionVista;
	private AdministrativoVista administrativoVista;
	private AdministrativoVistaControlador administrativoVistaControlador;
	private SupervisorAdministracionVista supervisorAdministracionVista;
	private SupervisorVista supervisorVista;
	private SupervisorVistaControlador supervisorVistaControlador;
	private InstructorAdministracionVista instructorAdministracionVista;
	private InstructorVista instructorVista;
	private InstructorVistaControlador instructorVistaControlador;

	public NotificacionABMVistaPrincipalControlador(AdministracionDeCursos modelo, NotificacionABMVistaPrincipal vista, AdministracionDeCursosVista administracionVista, SupervisorAdministracionVista supervisorAdministracionVista, InstructorAdministracionVista instructorAdministracionVista) {
		this.vista = vista;
		this.modelo = modelo;
		this.administracionVista = administracionVista;
		this.supervisorAdministracionVista = supervisorAdministracionVista;
		this.instructorAdministracionVista = instructorAdministracionVista;
		
		this.vista.getLblHome().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHome_MousePressed(evt);
			}
		});
	}

	public void btnHome_MousePressed(MouseEvent evt) {
		
		if(this.administracionVista != null) {
			this.administracionVista.getFrame().dispose();
			administrativoVista = new AdministrativoVista();
			administrativoVistaControlador = new AdministrativoVistaControlador(administrativoVista,
					modelo);
			administrativoVistaControlador.inicializar();
		} else if (this.supervisorAdministracionVista != null) {
			this.supervisorAdministracionVista.getFrame().dispose();
			supervisorVista = new SupervisorVista();
			supervisorVistaControlador = new SupervisorVistaControlador(supervisorVista,
			modelo);
			supervisorVistaControlador.inicializar();
		} else if (this.instructorAdministracionVista != null) {
			this.instructorAdministracionVista.getFrame().dispose();
			instructorVista = new InstructorVista();
			instructorVistaControlador = new InstructorVistaControlador(instructorVista,
			modelo);
			instructorVistaControlador.inicializar();
		}
		
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(23, 35, 51));
	}

	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(0, 0, 0));
		}
	}
	
	private void setBounds(JPanel panel, int x, int y) {
		Rectangle bounds = panel.getBounds();
		bounds.translate(x, y);
		panel.setBounds(bounds);		
	}

	public void clearMainPanel() {
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
	}

}
