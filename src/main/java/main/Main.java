package main;

import dto.ClienteDTO;
import dto.InstructorDTO;
import modelo.GestionCursos;
import persistencia.dao.mysql.DAOSQLFactory;

public class Main {

	public static void main(String[] args) {
		GestionCursos modelo = new GestionCursos(new DAOSQLFactory());
		for (InstructorDTO i : modelo.obtenerInstructores()) {
			System.out.println(i.toString());
		}
		for (ClienteDTO c : modelo.obtenerClientes()) {
			System.out.println(c.toString());
		}
	}

}
