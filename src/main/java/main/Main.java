package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.InstructorCrudControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.InstructorCrudVista;

public class Main {

	public static void main(String[] args) {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		}

		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		InstructorCrudVista vista = new InstructorCrudVista();

		InstructorCrudControlador controlador = new InstructorCrudControlador(vista, modelo);
		controlador.inicializar();

		for (InstructorDTO i : modelo.obtenerInstructores()) {
			System.out.println(i.toString());
		}
	}
}
