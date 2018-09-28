package main;

import dto.ClienteDTO;
import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosCtrl;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosView;

public class Main {

	public static void main(String[] args) {
		
		AdministracionDeCursosView vista = new AdministracionDeCursosView();
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		AdministracionDeCursosCtrl controlador = new AdministracionDeCursosCtrl(vista, modelo);
		controlador.inicializar();
		
		for (InstructorDTO i : modelo.obtenerInstructores()) {
			System.out.println(i.toString());
		}
		for (ClienteDTO c : modelo.obtenerClientes()) {
			System.out.println(c.toString());
		}
		
	}
}
