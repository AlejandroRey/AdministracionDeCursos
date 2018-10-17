package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.AdministracionDeCursos;
import presentacion.vista.ADescarteAdministracionDeCursosVista;
import presentacion.vista.AlumnoABMPanel;
import presentacion.vista.CursadaABMPanel;

public class ADescarteAdministracionDeCursosControlador implements ActionListener {
	
	private ADescarteAdministracionDeCursosVista vista;
	private AdministracionDeCursos modelo;
	
	private AlumnoABMPanel alumnoABM;
	private AlumnoABMControlador alumnoABMControlador;
	
	private CursadaABMPanel cursadaABM;
	private CursadaABMControlador cursadaABMControlador;
	
	public ADescarteAdministracionDeCursosControlador(ADescarteAdministracionDeCursosVista vista, AdministracionDeCursos modelo) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getMenuItemLogin().addActionListener(this);
		this.vista.getMenuItemLogout().addActionListener(this);
		
		this.vista.getMenuItemActualizarUsuario().addActionListener(this);
		this.vista.getMenuItemAgregarUsuario().addActionListener(this);
		this.vista.getMenuItemEliminarUsuario().addActionListener(this);
		
		this.vista.getMenuItemActualizarAlumno().addActionListener(this);
		this.vista.getMenuItemAgregarAlumno().addActionListener(this);
		this.vista.getMenuItemEliminarAlumno().addActionListener(this);
		this.vista.getMenuItemSeleccionarAlumno().addActionListener(this);
		
		this.vista.getMenuItemActualizarCursada().addActionListener(this);
		this.vista.getMenuItemAgregarCursada().addActionListener(this);
		this.vista.getMenuItemEliminarCursada().addActionListener(this);		
	}

	public void inicializar() {
		//this.vista.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vista.getMenuItemActualizarUsuario()) {

		} else if (e.getSource() == this.vista.getMenuItemAgregarUsuario()) {

		} else if (e.getSource() == this.vista.getMenuItemEliminarUsuario()) {

		} else if (e.getSource() == this.vista.getMenuItemActualizarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoABMPanel();
				alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnActualizar();
				
				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnActualizar();
			}
		} else if (e.getSource() == this.vista.getMenuItemAgregarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoABMPanel();
				alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnAgregar();

				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnAgregar();
			}
		} else if (e.getSource() == this.vista.getMenuItemEliminarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoABMPanel();
				alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnEliminar();

				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnEliminar();
			}
		} else if (e.getSource() == this.vista.getMenuItemSeleccionarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoABMPanel();
				alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnSeleccionar();

				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnSeleccionar();
			}
		} else if (e.getSource() == this.vista.getMenuItemActualizarCursada()) {
		} else if (e.getSource() == this.vista.getMenuItemAgregarCursada()) {
			if (cursadaABMControlador == null) {
				cursadaABM = new CursadaABMPanel();
				cursadaABMControlador = new CursadaABMControlador(cursadaABM, modelo);
				cursadaABMControlador.inicializar();
				
				this.vista.getMainPanel().add(cursadaABM);
			}else{
				
			}
		} else if (e.getSource() == this.vista.getMenuItemEliminarCursada()) {
		}
		
		
		this.vista.getFrame().repaint();
	}
	
}
