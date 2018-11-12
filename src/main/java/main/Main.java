package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.AlumnoDTO;
import dto.AlumnoHistorialCursadaDTO;
import dto.AlumnoHistorialNotaDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosControlador;
import persistencia.controlador.LoginVistaControlador;
//import dto.CursadaDTO;
//import modelo.AdministracionDeCursos;
//import persistencia.controlador.AdministracionDeCursosControlador;
//import persistencia.controlador.AlumnosAsistenciaControlador;
//import persistencia.controlador.VistaInicialControlador;
import persistencia.dao.mysql.AlumnoHistorialCursadasDAOSQL;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.LoginVista;
//import persistencia.dao.mysql.DAOSQLFactory;
//import presentacion.vista.AdministracionDeCursosVista;
//import presentacion.vista.AlumnosAsistenciaPanel;
//import presentacion.vista.TestFrame;
//import presentacion.vista.VistaInicial;


public class Main {

	public static void main(String[] args) {
//
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
		
//		String str = "2017-10-01 01:00:00";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//		
//		String strStart = "2017-10-01 08:00:00";
//		DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		LocalDateTime dateTimeStart = LocalDateTime.parse(strStart, formatter);
//		
//		LocalDate d = dateTime.toLocalDate();
//		System.out.println(d.toString());
//		System.out.println(LocalDateTime.of(d, LocalTime.MIN));
//		
//		
//		System.out.println(dateTime.toString());
//		System.out.println(dateTime.plusDays(1).toString());
//		
//		FechaCursadaClaseDTO f = new FechaCursadaClaseDTO(1, 1, 1, dateTime, dateTimeStart);
//		SalaDisponibleDAOSQL sql = new SalaDisponibleDAOSQL();
//		
//		List<SalaDisponibleDTO> salasList = sql.readAll(f);
//		for (SalaDisponibleDTO salaDisponibleDTO : salasList) {
//			System.out.println(salaDisponibleDTO.toString());
//		}

//		AlumnoHistorialCursadasDAOSQL mySql = new AlumnoHistorialCursadasDAOSQL();
//		AlumnoDTO alumnoDTO = new AlumnoDTO(1, "", "", "", "");
//		
//		for (AlumnoHistorialCursadaDTO	alumno : mySql.readAllCursada(alumnoDTO)) {
//			System.out.println(alumno.toString());
//		}
//		
//		for (AlumnoHistorialNotaDTO	nota : mySql.readAllNota(1, 1)) {
//			System.out.println(nota.toString());
//		}
//
//		LoginVista vista = new LoginVista();
//		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
//		LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
//		controlador.inicializar();
//		}
	}
}
