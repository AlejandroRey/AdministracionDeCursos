package main;

import dto.InstructorDTO;
import modelo.GestionCursos;
import persistencia.dao.mysql.DAOSQLFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionCursos modelo = new GestionCursos(new DAOSQLFactory());
		for (InstructorDTO i : modelo.obtenerInstructores()) {
			System.out.println(i.toString());
		}
	}

}
