package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.ContactoVistaPrincipal;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.CursoABMVistaPrincipal;
import presentacion.vista.LoginVista;
import presentacion.vista.NotificacionPanel;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.SalaABMVistaPrincipal;
import presentacion.vista.TareaABMVistaPrincipal;
import presentacion.vista.UsuarioCambioContraseñaVista;
import presentacion.vista.UsuarionABMVistaPrincipal;
import presentacion.vista.VistaInicial;

public class AdministrativoVistaControlador implements ActionListener {
	
	private AdministrativoVista vista;
	private AdministracionDeCursos modelo;
	private AdministracionDeCursosVista administracionVista;
	private RecadoABMVistaPrincipal recadoABMVistaPrincipal;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	private AdministracionDeCursosControlador controlador;
	private AlumnoABMVistaPrincipal alumnoABM;
	private AlumnoABMVistaPrincipalControlador alumnoABMControlador;
	private CursoABMVistaPrincipal cursoABM;
	private CursoABMVistaPrincipalControlador cursoABMControlador;
	private CursadaABMVistaPrincipal cursadaABM;
	private CursadaABMVistaPrincipalControlador cursadaABMControlador;
	private TareaABMVistaPrincipal tareaABM;
	private TareaABMVistaPrincipalControlador tareaABMControlador;
	private SalaABMVistaPrincipal salaABM;
	private SalaABMVistaPrincipalControlador salaABMControlador;
	private VistaInicial vistaInicial;
	private VistaInicialControlador vistaInicialControlador;
	private ContactoVistaPrincipal contactoABM;
	private ContactoABMVistaPrincipalControlador contactoABMControlador;
	private UsuarionABMVistaPrincipal instructorABM;
	private UsuarioABMVistaPrincipalControlador instructorABMControlador;
	private NotificacionPanel notificacionVista;
	private NotificacionControlador notificacionControlador;
	
	public AdministrativoVistaControlador(AdministrativoVista vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnAlumnos().addActionListener(this);
		this.vista.getBtnCambiarContrasena().addActionListener(this);
		this.vista.getBtnCerrarSesion().addActionListener(this);
		this.vista.getBtnContactos().addActionListener(this);
		this.vista.getBtnCursadas().addActionListener(this);
		this.vista.getBtnCursos().addActionListener(this);
		this.vista.getBtnEmpresas().addActionListener(this);
		this.vista.getBtnFeriados().addActionListener(this);
		this.vista.getBtnInstructores().addActionListener(this);
		this.vista.getBtnNotificaciones().addActionListener(this);
		this.vista.getBtnRecados().addActionListener(this);
		this.vista.getBtnSalas().addActionListener(this);
		this.vista.getBtnTareas().addActionListener(this);
	}
	
	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnAlumnos()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (alumnoABM == null) {
				alumnoABM = new AlumnoABMVistaPrincipal();
				alumnoABMControlador = new AlumnoABMVistaPrincipalControlador(modelo, alumnoABM);
				
				this.administracionVista.getMainPanel().add(alumnoABM);
			}	
		}
		if (e.getSource() == this.vista.getBtnCambiarContrasena()) {
			UsuarioCambioContraseñaVista usuarioCambioContraseñaVista = new UsuarioCambioContraseñaVista();
			UsuarioCambioContraseñaVistaControlador usuarioCambioContraseñaVistaControlador = new UsuarioCambioContraseñaVistaControlador(modelo,usuarioCambioContraseñaVista);
			usuarioCambioContraseñaVistaControlador.inicializar();
		}
		if (e.getSource() == this.vista.getBtnCerrarSesion()) {
			this.vista.getFrmAdministrativo().dispose();
			LoginVista vista = new LoginVista();
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		if (e.getSource() == this.vista.getBtnContactos()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (contactoABM == null) {
				contactoABM = new ContactoVistaPrincipal();
				contactoABMControlador = new ContactoABMVistaPrincipalControlador(modelo, contactoABM, administracionVista);
				
				this.administracionVista.getMainPanel().add(contactoABM);
			}	
		}
		if (e.getSource() == this.vista.getBtnCursadas()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (cursadaABM == null) {
				cursadaABM = new CursadaABMVistaPrincipal();
				cursadaABMControlador = new CursadaABMVistaPrincipalControlador(modelo, cursadaABM);
				
				this.administracionVista.getMainPanel().add(cursadaABM);
			}
		}
		if (e.getSource() == this.vista.getBtnCursos()) {
			// TODO
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (cursoABM == null) {
				cursoABM = new CursoABMVistaPrincipal();
				cursoABMControlador = new CursoABMVistaPrincipalControlador(modelo , cursoABM,administracionVista);
				
				this.administracionVista.getMainPanel().add(cursoABM);
			}
		}
		if (e.getSource() == this.vista.getBtnEmpresas()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no está desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnFeriados()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no está desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnInstructores()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (instructorABM == null) {
				instructorABM = new UsuarionABMVistaPrincipal();
				instructorABMControlador = new UsuarioABMVistaPrincipalControlador(modelo, instructorABM);
				
				this.administracionVista.getMainPanel().add(instructorABM);
			}
		}
		if (e.getSource() == this.vista.getBtnNotificaciones()) {
			this.vista.getFrmAdministrativo().dispose();
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();			
			if(notificacionVista == null) {
				notificacionVista = new NotificacionPanel();
				administracionVista.getMainPanel().add(notificacionVista);
				notificacionControlador = new NotificacionControlador(modelo, notificacionVista, administracionVista, controlador);
				notificacionControlador.inicializar();
			}
		}
		if (e.getSource() == this.vista.getBtnRecados()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (recadoABMVistaPrincipal == null) {
				recadoABMVistaPrincipal = new RecadoABMVistaPrincipal();
				recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABMVistaPrincipal, administracionVista);
				
				this.administracionVista.getMainPanel().add(recadoABMVistaPrincipal);
			}
		}
		if (e.getSource() == this.vista.getBtnSalas()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (salaABM == null) {
				salaABM = new SalaABMVistaPrincipal();
				salaABMControlador = new SalaABMVistaPrincipalControlador(modelo, salaABM);
				
				this.administracionVista.getMainPanel().add(salaABM);
			}
		}
		if (e.getSource() == this.vista.getBtnTareas()) {
			this.vista.getFrmAdministrativo().dispose();
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (tareaABM == null) {
				tareaABM = new TareaABMVistaPrincipal();
				tareaABMControlador = new TareaABMVistaPrincipalControlador(modelo, tareaABM);
				
				this.administracionVista.getMainPanel().add(tareaABM);
			}
		}
	}
}