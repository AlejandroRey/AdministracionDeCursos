package main;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.NotificacionDTO;
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
			
			Thread thread = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while(this!=null) {
	                    List<NotificacionDTO>notificaciones = modelo.obtenerNotificaciones();
	                    boolean result = false;
	            		for(NotificacionDTO notificacion : notificaciones) {
	            			if(modelo.getUsuarioLogueado()!=null) {
	            				if (!notificacion.isVisto()==true && notificacion.getIdUsuario()==modelo.getUsuarioLogueado().getIdUsuario()) {
	            					result = true;
	            				}
	            			}
	            		}
	            		if (result) {
	            			JOptionPane.showMessageDialog(null, "Tienes nuevas notificaciones, revisa la sección.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
	            		}
	                    try {
	                        Thread.sleep(300000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });
			thread.start();
		}
	}
}
