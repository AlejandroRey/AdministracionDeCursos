package main;

import java.util.Iterator;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.InstructorCrudControlador;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.InstructorCrudVista;

public class Main {

	public static void main(String[] args) {
		
        try {
            // Selecciono el Look and Feel HiFiLookAndFeel        	
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.LunaLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.TextureLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.AluminiumLookAndFeel");        	
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); 
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");	
        	
        	UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        	for (LookAndFeelInfo lookAndFeelInfo : lafInfo) {
				System.out.println(lookAndFeelInfo.toString());
			}
        	//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");        	
        	//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        	//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
