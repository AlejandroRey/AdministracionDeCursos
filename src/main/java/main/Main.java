package main;

import java.time.LocalDateTime;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import dto.AlumnoInscriptoDTO;
import dto.CursadaCompletaDTO;
import dto.CursadaDTO;
import dto.EmpresaDTO;
import dto.InscriptoDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.CursadaFullControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.CursadaFullVista;

public class Main {

	public static void main(String[] args) {
		
        try {     	
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");      	
        	UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        	for (LookAndFeelInfo lookAndFeelInfo : lafInfo) {
				System.out.println(lookAndFeelInfo.toString());
			}
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		}
        
        AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
        
        for (EmpresaDTO empresa : modelo.obtenerEmpresas()) {
        	System.out.println("Empresa:");
        	System.out.println(empresa.toString());
		}
        
        for (CursadaCompletaDTO cursada : modelo.obtenerCursadasCompletas()) {
			System.out.println(cursada.toString());
		}   
        
        for (CursadaDTO	cursada : modelo.obtenerCursadas()) {
			System.out.println(cursada.toString());
		}
        
        for (AlumnoInscriptoDTO alumno : modelo.obtenerAlumnosInscriptos(new CursadaDTO(8, 1, 1, 1, 1, LocalDateTime.now(), LocalDateTime.now(), "44"))) {
			System.out.println(alumno.toString());
		}
        
        for (InscriptoDTO i : modelo.obtenerInscriptos()) {
        	System.out.println(i.toString());
		}
        //modelo.actualizarInscripto(new InscriptoDTO(1, 1, LocalDateTime.now()));
        
      CursadaFullVista vista = new CursadaFullVista();
      CursadaFullControlador c = new CursadaFullControlador(vista, modelo);
      c.inicializar();

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
