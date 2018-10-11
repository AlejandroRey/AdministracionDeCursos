package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AlumnoCrudVista;

public class AdministracionDeCursosControlador implements ActionListener {
	
	private AdministracionDeCursosVista vista;
	private AdministracionDeCursos modelo;
	
	private AlumnoCrudVista alumnoABM;
	private AlumnoCrudControlador alumnoABMControlador;
	
	public AdministracionDeCursosControlador(AdministracionDeCursosVista vista, AdministracionDeCursos modelo) {
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
				alumnoABM = new AlumnoCrudVista();
				alumnoABMControlador = new AlumnoCrudControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnActualizar();
				
				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnActualizar();
			}
		} else if (e.getSource() == this.vista.getMenuItemAgregarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoCrudVista();
				alumnoABMControlador = new AlumnoCrudControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnAgregar();

				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnAgregar();
			}
		} else if (e.getSource() == this.vista.getMenuItemEliminarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoCrudVista();
				alumnoABMControlador = new AlumnoCrudControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnEliminar();

				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnEliminar();
			}
		} else if (e.getSource() == this.vista.getMenuItemSeleccionarAlumno()) {
			if (alumnoABMControlador == null) {
				alumnoABM = new AlumnoCrudVista();
				alumnoABMControlador = new AlumnoCrudControlador(alumnoABM, modelo);
				alumnoABMControlador.inicializar();
				alumnoABMControlador.setVisibleBtnSeleccionar();

				this.vista.getMainPanel().add(alumnoABM);
			} else {
				alumnoABMControlador.setVisibleBtnSeleccionar();
			}
		}
		this.vista.getFrame().repaint();
	}
	
}
