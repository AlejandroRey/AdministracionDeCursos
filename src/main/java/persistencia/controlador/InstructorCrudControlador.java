package persistencia.controlador;

import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.InstructorCrudVista;

public class InstructorCrudControlador {
	
	private InstructorCrudVista vista;
	private AdministracionDeCursos modelo;
	
	public InstructorCrudControlador(InstructorCrudVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	public void inicializar() {
		this.vista.show();
	}
	
	private void agregarInstructor() {
		InstructorDTO instructor = null;
		this.modelo.agregarInstructor(instructor);
	}
	
	private void actualizarInstructor() {
		
	}

}
