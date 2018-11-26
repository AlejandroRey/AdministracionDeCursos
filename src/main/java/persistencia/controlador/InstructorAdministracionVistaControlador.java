package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.LoginVista;
import presentacion.vista.NotificacionABMVistaPrincipal;
import presentacion.vista.NotificacionPanel;
import presentacion.vista.RecadoABMVistaPrincipal;

public class InstructorAdministracionVistaControlador implements ActionListener {

	private AdministracionDeCursos modelo;
	private InstructorAdministracionVista vista;
	
	private NotificacionABMVistaPrincipal notificacionABM;
	private NotificacionABMVistaPrincipalControlador notificacionABMControlador;
	private NotificacionPanel notificacionPanel;
	private NotificacionControlador notificacionPanelControlador;
	
	private RecadoABMVistaPrincipal recadoABM;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	
	private CursadaABMVistaPrincipal cursadaABM;
	private CursadaABMVistaPrincipalControlador cursadaABMControlador;
	
	public InstructorAdministracionVistaControlador(AdministracionDeCursos modelo, InstructorAdministracionVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getMenuItemCambiarDeUsuario().addActionListener(this);
		this.vista.getMenuItemCursadasVer().addActionListener(this);
		this.vista.getMenuItemNotificacionesVer().addActionListener(this);
		this.vista.getMenuItemRecadosVer().addActionListener(this);
		this.vista.getMenuItemSalirDelSistema().addActionListener(this);
	}
	
	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getMenuItemCambiarDeUsuario()) {
			this.vista.getFrame().dispose();
			this.vista = null;
			LoginVista vista = new LoginVista();
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		else if (e.getSource() == this.vista.getMenuItemCursadasVer()) {
			this.vista.getMainPanel().removeAll();
			cursadaABM = new CursadaABMVistaPrincipal();
			cursadaABMControlador = new CursadaABMVistaPrincipalControlador(modelo,cursadaABM,null, vista);
			cursadaABM.getBtnActualizar().setVisible(false);
			cursadaABM.getBtnAgregar().setVisible(false);
			cursadaABM.getBtnEliminar().setVisible(false);
			cursadaABM.getBtnPagos().setVisible(false);
			this.vista.getMainPanel().add(cursadaABM);
		}
		else if (e.getSource() == this.vista.getMenuItemNotificacionesVer()) {
			this.vista.getMainPanel().removeAll();
			notificacionABM = new NotificacionABMVistaPrincipal();
			notificacionABMControlador = new NotificacionABMVistaPrincipalControlador(modelo, notificacionABM, null, null, vista);
			notificacionPanel = new NotificacionPanel();
			notificacionPanelControlador = new NotificacionControlador(modelo, notificacionPanel, null, null, vista);
			notificacionPanelControlador.inicializar();
			this.vista.getMainPanel().add(notificacionABM);
			notificacionABM.getMainPanel().add(notificacionPanel);
		}
		else if (e.getSource() == this.vista.getMenuItemRecadosVer()) {
			this.vista.getMainPanel().removeAll();
			recadoABM = new RecadoABMVistaPrincipal();
			recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABM, null, null, this.vista);			
			this.vista.getMainPanel().add(recadoABM);
		}
		else if (e.getSource() == this.vista.getMenuItemSalirDelSistema()) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir?", "Salir del sistema", JOptionPane.YES_NO_OPTION);
		    if (respuesta == JOptionPane.YES_OPTION)
		    {
		    	this.vista.getFrame().dispose();
		    }
		}
		try{this.vista.getFrame().repaint();} catch (Exception ex) {}
	}
}
