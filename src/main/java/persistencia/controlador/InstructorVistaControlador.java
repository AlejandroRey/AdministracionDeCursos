package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AsignacionesDeInstructorVista;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.InstructorVista;
import presentacion.vista.LoginVista;
import presentacion.vista.NotificacionABMVistaPrincipal;
import presentacion.vista.NotificacionPanel;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.UsuarioCambioContraseñaVista;

public class InstructorVistaControlador implements ActionListener {
	
	private InstructorVista vista;
	private AdministracionDeCursos modelo;
	private InstructorAdministracionVista instructorAdministracionVista;
	private InstructorAdministracionVistaControlador instructorAdministracionVistaControlador;
	private RecadoABMVistaPrincipal recadoABMVistaPrincipal;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	private CursadaABMVistaPrincipal cursadaABM;
	private CursadaABMVistaPrincipalControlador cursadaABMControlador;
	private AsignacionesDeInstructorVista asignacionesDeInstructorVista;
	private AsignacionesDeInstructorControlador asignacionesDeInstructorControlador;
	private NotificacionABMVistaPrincipal notificacionABM;
	private NotificacionABMVistaPrincipalControlador notificacionABMControlador;
	private NotificacionPanel notificacionPanel;
	private NotificacionControlador notificacionPanelControlador;
	
	public InstructorVistaControlador (InstructorVista vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnCerrarSesion().addActionListener(this);
		this.vista.getBtnNotificaciones().addActionListener(this);
		this.vista.getBtnRecados().addActionListener(this);
		this.vista.getBtnRegistrar().addActionListener(this);
		this.vista.getButtonCambiarContrasenia().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnCerrarSesion()) {
			this.vista.getFrmInstructor().dispose();
			LoginVista vista = new LoginVista();
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		} else if (e.getSource() == this.vista.getBtnRecados()) {
			this.vista.getFrmInstructor().dispose();
			instructorAdministracionVista = new InstructorAdministracionVista();
			instructorAdministracionVistaControlador = new InstructorAdministracionVistaControlador(modelo, instructorAdministracionVista);
			instructorAdministracionVistaControlador.inicializar();
			if (recadoABMVistaPrincipal == null) {
				recadoABMVistaPrincipal = new RecadoABMVistaPrincipal();
				recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABMVistaPrincipal, null, null, instructorAdministracionVista);				
				this.instructorAdministracionVista.getMainPanel().add(recadoABMVistaPrincipal);
			}
		} else if (e.getSource() == this.vista.getBtnNotificaciones()) {
			this.vista.getFrmInstructor().dispose();
			instructorAdministracionVista = new InstructorAdministracionVista();
			instructorAdministracionVistaControlador = new InstructorAdministracionVistaControlador(modelo, instructorAdministracionVista);
			instructorAdministracionVistaControlador.inicializar();
			
			instructorAdministracionVista.getMainPanel().removeAll();
			notificacionABM = new NotificacionABMVistaPrincipal();
			notificacionABMControlador = new NotificacionABMVistaPrincipalControlador(modelo, notificacionABM, null, null, instructorAdministracionVista);
			notificacionPanel = new NotificacionPanel();
			notificacionPanelControlador = new NotificacionControlador(modelo, notificacionPanel, null, null, instructorAdministracionVista);
			notificacionPanelControlador.inicializar();
			instructorAdministracionVista.getMainPanel().add(notificacionABM);
			notificacionABM.getMainPanel().add(notificacionPanel);
		} else if (e.getSource() == this.vista.getBtnRegistrar()) {
			this.vista.getFrmInstructor().dispose();
			instructorAdministracionVista = new InstructorAdministracionVista();
			instructorAdministracionVistaControlador = new InstructorAdministracionVistaControlador(modelo, instructorAdministracionVista);
			instructorAdministracionVistaControlador.inicializar();
			cursadaABM = new CursadaABMVistaPrincipal();
			cursadaABMControlador = new CursadaABMVistaPrincipalControlador(modelo,cursadaABM,null, instructorAdministracionVista);
			cursadaABM.getBtnActualizar().setVisible(false);
			cursadaABM.getBtnAgregar().setVisible(false);
			cursadaABM.getBtnEliminar().setVisible(false);
//			cursadaABM.getBtnPagos().setVisible(false);
			instructorAdministracionVista.getMainPanel().add(cursadaABM);
		} else if (e.getSource() == this.vista.getButtonCambiarContrasenia()) {
			UsuarioCambioContraseñaVista vista = new UsuarioCambioContraseñaVista();
			UsuarioCambioContraseñaVistaControlador controlador = new UsuarioCambioContraseñaVistaControlador(vista, modelo);
			controlador.inicializar();
		}
	}

}
