package persistencia.controlador;

import modelo.AdministracionDeCursos;
import presentacion.vista.InstructorCrudVista;

public class InstructorCrudControlador {
	
	private InstructorCrudVista vista;
	private AdministracionDeCursos modelo;
	
	public InstructorCrudControlador(InstructorCrudVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	

}
