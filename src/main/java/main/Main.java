package main;

import java.time.LocalDateTime;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.CursadaDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosControlador;
import persistencia.controlador.AlumnosEvaluacionesControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AlumnosEvaluacionesPanel;
import presentacion.vista.TestFrame;

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
//			AdministracionDeCursosControlador controlador = new AdministracionDeCursosControlador(modelo, vista);
//			controlador.inicializar();
//			vista.getFrame().revalidate();
//			vista.getFrame().repaint();
		}
		
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		TestFrame vistaPrincipal = new TestFrame();
		CursadaDTO cursadaDTO = new CursadaDTO(1, 
											   1, 
											   1, 
											   1, 
											   LocalDateTime.now(), 
											   LocalDateTime.now(), 
											   "5", 
											   LocalDateTime.now(), 
											   15);
		
		AlumnosEvaluacionesControlador controlador = new AlumnosEvaluacionesControlador(vistaPrincipal.getAlumnosEvaluacionesPanel(), modelo, cursadaDTO);
		controlador.inicializar();
	}
}
