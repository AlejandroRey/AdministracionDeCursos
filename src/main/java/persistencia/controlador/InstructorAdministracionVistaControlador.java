package persistencia.controlador;

import modelo.AdministracionDeCursos;
import presentacion.vista.InstructorAdministracionVista;

public class InstructorAdministracionVistaControlador {

	private AdministracionDeCursos modelo;
	private InstructorAdministracionVista vista;
	
	public InstructorAdministracionVistaControlador(AdministracionDeCursos modelo, InstructorAdministracionVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
	}
	
	public void inicializar() {
		
	}
}
