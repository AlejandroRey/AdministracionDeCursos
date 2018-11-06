package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.AlumnoDTO;
import dto.AlumnoHistorialCursadaDTO;
import dto.AlumnoHistorialNotaDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosControlador;
import persistencia.dao.mysql.AlumnoHistorialCursadasDAOSQL;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;


public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} finally {
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			AdministracionDeCursosVista vista = new AdministracionDeCursosVista();
			AdministracionDeCursosControlador controlador = new AdministracionDeCursosControlador(modelo, vista);
			controlador.inicializar();
			vista.getFrame().revalidate();
			vista.getFrame().repaint();
		}
		
		AlumnoHistorialCursadasDAOSQL mySql = new AlumnoHistorialCursadasDAOSQL();
		AlumnoDTO alumnoDTO = new AlumnoDTO(1, "", "", "", "");
		
		for (AlumnoHistorialCursadaDTO	alumno : mySql.readAllCursada(alumnoDTO)) {
			System.out.println(alumno.toString());
		}
		
		for (AlumnoHistorialNotaDTO	nota : mySql.readAllNota(1, 1)) {
			System.out.println(nota.toString());
		}

//		LoginVista vista = new LoginVista();
//		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
//		LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
//		controlador.inicializar();

	}
}