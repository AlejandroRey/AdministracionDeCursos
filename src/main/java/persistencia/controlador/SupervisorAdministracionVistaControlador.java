package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoABMVistaPrincipal;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.CursoABMVistaPrincipal;
import presentacion.vista.LoginVista;
import presentacion.vista.NotificacionABMVistaPrincipal;
import presentacion.vista.NotificacionPanel;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.SalaABMVistaPrincipal;
import presentacion.vista.SupervisorAdministracionVista;
import presentacion.vista.TareaABMVistaPrincipal;
import presentacion.vista.UsuarionABMVistaPrincipal;

public class SupervisorAdministracionVistaControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private SupervisorAdministracionVista vista;
	
	private AdministrativoABMVistaPrincipal administrativoABM;
	private AdministrativoABMVistaPrincipalControlador administrativoABMControlador;
	
	private RecadoABMVistaPrincipal recadoABM;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	
	private TareaABMVistaPrincipal tareaABM;
	private TareaABMVistaPrincipalControlador tareaABMControlador;
	
	private NotificacionABMVistaPrincipal notificacionABM;
	private NotificacionABMVistaPrincipalControlador notificacionABMControlador;
	private NotificacionPanel notificacionPanel;
	private NotificacionControlador notificacionPanelControlador;
	
	public SupervisorAdministracionVistaControlador(AdministracionDeCursos modelo, SupervisorAdministracionVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.vista.getMenuItemAdministrativosVer().addActionListener(this);
		this.vista.getMenuItemSalirDelSistema().addActionListener(this);
		this.vista.getMenuItemCambiarDeUsuario().addActionListener(this);
		this.vista.getMenuItemExportarBaseDeDatos().addActionListener(this);
		this.vista.getMenuItemImportarBaseDeDatos().addActionListener(this);
		this.vista.getMenuItemRecadosVer().addActionListener(this);
		this.vista.getMenuItemTareasVer().addActionListener(this);
		this.vista.getMenuItemNotificacionesVer().addActionListener(this);
	}
	
	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		resetVistas();
		
		if (e.getSource() == this.vista.getMenuItemAdministrativosVer()) {
			if (administrativoABM == null) {
				administrativoABM = new AdministrativoABMVistaPrincipal();
				administrativoABMControlador = new AdministrativoABMVistaPrincipalControlador(modelo, administrativoABM, vista);
				this.vista.getMainPanel().add(administrativoABM);
			}
		} 
		else if (e.getSource()==this.vista.getMenuItemExportarBaseDeDatos()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource()==this.vista.getMenuItemImportarBaseDeDatos()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource()==this.vista.getMenuItemRecadosVer()) {
				recadoABM = new RecadoABMVistaPrincipal();
				recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABM, null, this.vista, null);			
				this.vista.getMainPanel().add(recadoABM);
		}
		else if (e.getSource()== this.vista.getMenuItemSalirDelSistema()) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir?", "Salir del sistema", JOptionPane.YES_NO_OPTION);
		    if (respuesta == JOptionPane.YES_OPTION)
		    {
		    	this.vista.getFrame().dispose();
		    }
			
		}
		else if (e.getSource()==this.vista.getMenuItemCambiarDeUsuario()) {
			this.vista.getFrame().dispose();
			LoginVista vista = new LoginVista();
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		else if (e.getSource()==this.vista.getMenuItemTareasVer()){
			tareaABM = new TareaABMVistaPrincipal();
			tareaABMControlador = new TareaABMVistaPrincipalControlador(modelo,tareaABM,null,vista,null);
			this.vista.getMainPanel().add(tareaABM);
		}
		else if (e.getSource()==this.vista.getMenuItemNotificacionesVer()) {
			notificacionABM = new NotificacionABMVistaPrincipal();
			notificacionABMControlador = new NotificacionABMVistaPrincipalControlador(modelo, notificacionABM, null, vista, null);
			notificacionPanel = new NotificacionPanel();
			notificacionPanelControlador = new NotificacionControlador(modelo, notificacionPanel, null, vista, null);
			notificacionPanelControlador.inicializar();
			this.vista.getMainPanel().add(notificacionABM);
			notificacionABM.getMainPanel().add(notificacionPanel);
		}
		this.vista.getFrame().repaint();
	}
	
	private void resetVistas() {
		if (administrativoABMControlador != null) {
			administrativoABM = null;
			administrativoABMControlador = null;
		}
		
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().repaint();
		this.vista.getFrame().repaint();
	}
}