package main;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.AdministracionDeCursos;
import persistencia.controlador.AdministracionDeCursosControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;

public class Main {

	public static void main(String[] args) {
		
        try {     	
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");        	
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		}
        
        AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
        AdministracionDeCursosVista vista = new AdministracionDeCursosVista();
        AdministracionDeCursosControlador controlador = new AdministracionDeCursosControlador(vista, modelo);
        //controlador.inicializar();
        
//        for (EmpresaDTO empresa : modelo.obtenerEmpresas()) {
//        	System.out.println("Empresa:");
//        	System.out.println(empresa.toString());
//		}
//        
//        for (CursadaCompletaDTO cursada : modelo.obtenerCursadasCompletas()) {
//			System.out.println(cursada.toString());
//		}   
//        
//        for (CursadaDTO	cursada : modelo.obtenerCursadas()) {
//			System.out.println(cursada.toString());
//		}
//        
//        for (AlumnoInscriptoDTO alumno : modelo.obtenerAlumnosInscriptos(new CursadaDTO(8, 1, 1, 1, 1, LocalDateTime.now(), LocalDateTime.now(), "44"))) {
//			System.out.println(alumno.toString());
//		}
//        
//        for (InscriptoDTO i : modelo.obtenerInscriptos()) {
//        	System.out.println(i.toString());
//		}
//        //modelo.actualizarInscripto(new InscriptoDTO(1, 1, LocalDateTime.now()));
//        
//      CursadaFullVista vista = new CursadaFullVista();
//      CursadaFullControlador c = new CursadaFullControlador(vista, modelo);
//      c.inicializar();
//
//		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
//		CursoCrudVista vista = new CursoCrudVista();
//		CursoCrudControlador ctrl = new CursoCrudControlador(vista, modelo);		
//		for (ClaseDTO	clase : modelo.obtenerClases()) {
//			System.out.println(clase.toString());
//		}
//		
//		AlumnoCrudVista vista = new AlumnoCrudVista();
//		AlumnoCrudControlador ctrl = new AlumnoCrudControlador(vista, modelo);	
//		
//		UsuarioCrudVista vista = new UsuarioCrudVista();
//		UsuarioCrudControlador ctrl =  new UsuarioCrudControlador(vista, modelo);
//		
//		TestTimePicker t = new TestTimePicker();
//
//		ctrl.inicializar();
//		
//		for (AlumnoDTO alumno : modelo.obtenerAlumnos()) {
//			System.out.println(alumno.toString());
//		}
//		
//		for (UsuarioDTO usuario : modelo.obtenerUsuarios()) {
//			System.out.println(usuario.toString());
//		}
//		
//		for (CategoriaDTO categoria : modelo.obtenerCategorias()) {
//			System.out.println(categoria.toString());
//		}
//		
//		InstructorCrudVista vista = new InstructorCrudVista();
//
//		InstructorCrudControlador controlador = new InstructorCrudControlador(vista, modelo);
//		controlador.inicializar();
//
//		for (InstructorDTO i : modelo.obtenerInstructores()) {
//			System.out.println(i.toString());
//		}
//		
//      MainVista mainVista = new MainVista();
//      mainVista.show();
        }
}
