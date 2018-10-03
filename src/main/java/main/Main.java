package main;

import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.InstructorCrudControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.InstructorCrudVista;

public class Main {

	public static void main(String[] args) {
		
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		InstructorCrudVista vista = new InstructorCrudVista();
		
		InstructorCrudControlador controlador = new InstructorCrudControlador(vista, modelo);
		
		for (InstructorDTO i : modelo.obtenerInstructores()) {
			System.out.println(i.toString());
		}		
	}
}
