package main;

import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;

public class Main {

	public static void main(String[] args) {
		
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		
		for (InstructorDTO i : modelo.obtenerInstructores()) {
			System.out.println(i.toString());
		}		
	}
}
