package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.AdministracionDeCursos;
import persistencia.controlador.LoginVistaControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.LoginVista;


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
		LoginVista vista = new LoginVista();
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
		controlador.inicializar();
		}
	}
}
