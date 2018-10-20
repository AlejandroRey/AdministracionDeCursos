package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosControlador;
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
//			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
//			AdministracionDeCursosVista vista = new AdministracionDeCursosVista();
//			AdministracionDeCursosControlador controlador = new AdministracionDeCursosControlador(vista, modelo);
//			controlador.inicializar();
		}
		
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		AdministracionDeCursosVista vista = new AdministracionDeCursosVista();
		AdministracionDeCursosControlador controlador = new AdministracionDeCursosControlador(modelo, vista);
		controlador.inicializar();		
	}
}
