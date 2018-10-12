package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.CursadaCompletaDTO;
import dto.CursadaDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosControlador;
import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.AlumnoEventoDAO;
import persistencia.dao.interfaz.AlumnoInscriptoDAO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.ClaseDAO;
import persistencia.dao.interfaz.CursadaCompletaDAO;
import persistencia.dao.interfaz.CursadaDAO;
import persistencia.dao.interfaz.CursoDAO;
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.EmpresaDAO;
import persistencia.dao.interfaz.EstadoDeCursoDAO;
import persistencia.dao.interfaz.InscriptoDAO;
import persistencia.dao.interfaz.SalaDAO;
import persistencia.dao.interfaz.UsuarioDAO;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;

public class Main {

	public static void main(String[] args) {

//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		} finally {
//			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
//			AdministracionDeCursosVista vista = new AdministracionDeCursosVista();
//			AdministracionDeCursosControlador controlador = new AdministracionDeCursosControlador(vista, modelo);
//			controlador.inicializar();
//		}
		
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		for (CursadaDTO cursada	: modelo.obtenerCursadas()) {
			System.out.println(cursada.toString());
		}
		
		for (CursadaCompletaDTO	cursada	: modelo.obtenerCursadasCompletas()) {
			System.out.println(cursada.toString());
		}

	}
}
