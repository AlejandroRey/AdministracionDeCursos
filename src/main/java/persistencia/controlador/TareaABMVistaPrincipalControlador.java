package persistencia.controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.InstructorVista;
import presentacion.vista.SupervisorAdministracionVista;
import presentacion.vista.SupervisorVista;
import presentacion.vista.TareaABMPanel;
import presentacion.vista.TareaABMVistaPrincipal;

public class TareaABMVistaPrincipalControlador {

	private AdministracionDeCursos modelo;
	private TareaABMVistaPrincipal vista;
	
	private TareaABMControlador tareaABMControlador;
	private TareaABMPanel tareaABM;
	
	private AdministracionDeCursosVista administracionVista;
	private AdministrativoVista administrativoVista;
	private AdministrativoVistaControlador administrativoVistaControlador;
	
	private SupervisorAdministracionVista supervisorAdministracionVista;
	private SupervisorVista supervisorVista;
	private SupervisorVistaControlador supervisorVistaControlador;
	
	private InstructorAdministracionVista instructorAdministracionVista;
	private InstructorVista instructorVista;
	private InstructorVistaControlador instructorVistaControlador;

	public TareaABMVistaPrincipalControlador(AdministracionDeCursos modelo, TareaABMVistaPrincipal vista, AdministracionDeCursosVista administracionVista, SupervisorAdministracionVista supervisorAdministracionVista, InstructorAdministracionVista instructorAdministracionVista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.administracionVista = administracionVista;
		this.supervisorAdministracionVista = supervisorAdministracionVista;
		this.instructorAdministracionVista = instructorAdministracionVista;
		
		this.vista.getBtnAgregar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnAgregar_MousePressed(evt);
			}
		});

		this.vista.getBtnActualizar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnActualizar_MousePressed(evt);
			}
		});

		this.vista.getBtnEliminar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEliminar_MousePressed(evt);
			}
		});
		
		this.vista.getLblHome().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHome_MousePressed(evt);
			}
		});

	}
	
	private void btnHome_MousePressed(MouseEvent evt) {
		if(this.administracionVista != null) {
			this.administracionVista.getFrame().dispose();
			administrativoVista = new AdministrativoVista();
			administrativoVistaControlador = new AdministrativoVistaControlador(administrativoVista, modelo);
			administrativoVistaControlador.inicializar();
		} else if (this.supervisorAdministracionVista != null) {
			this.supervisorAdministracionVista.getFrame().dispose();
			supervisorVista = new SupervisorVista();
			supervisorVistaControlador = new SupervisorVistaControlador(supervisorVista, modelo);
			supervisorVistaControlador.inicializar();
		} else if (this.instructorAdministracionVista != null) {
			this.instructorAdministracionVista.getFrame().dispose();
			instructorVista = new InstructorVista();
			instructorVistaControlador = new InstructorVistaControlador(instructorVista, modelo);
			instructorVistaControlador.inicializar();
		}
	}

	private void btnAgregar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAgregar());
		resetColor(new JPanel[] {this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (tareaABMControlador == null) {
			tareaABM = new TareaABMPanel();
			tareaABMControlador = new TareaABMControlador(tareaABM, modelo);
			tareaABMControlador.inicializar();
			tareaABMControlador.setVisibleBtnAgregar();
			this.vista.getMainPanel().add(tareaABM);
		} else {
			tareaABMControlador.setVisibleBtnAgregar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		resetColor(new JPanel[] {this.vista.getBtnAgregar(), this.vista.getBtnEliminar() });

		if (tareaABMControlador == null) {
			tareaABM = new TareaABMPanel();
			tareaABMControlador = new TareaABMControlador(tareaABM, modelo);
			tareaABMControlador.inicializar();
			tareaABMControlador.setVisibleBtnActualizar();
			this.vista.getMainPanel().add(tareaABM,BorderLayout.CENTER);
		} else {
			tareaABMControlador.setVisibleBtnActualizar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		resetColor(new JPanel[] {this.vista.getBtnActualizar(), this.vista.getBtnAgregar() });

		if (tareaABMControlador == null) {
			tareaABM = new TareaABMPanel();
			tareaABMControlador = new TareaABMControlador(tareaABM, modelo);
			tareaABMControlador.inicializar();
			tareaABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(tareaABM);
		} else {
			tareaABMControlador.setVisibleBtnEliminar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 80));
	}
	
	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(23, 35, 51));
		}
	}

}
