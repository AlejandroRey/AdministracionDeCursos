package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.ContactoVistaPrincipal;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.CursoABMVistaPrincipal;
import presentacion.vista.LoginVista;
import presentacion.vista.NotificacionABMVistaPrincipal;
import presentacion.vista.NotificacionPanel;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.SalaABMVistaPrincipal;
import presentacion.vista.TareaABMVistaPrincipal;
import presentacion.vista.UsuarionABMVistaPrincipal;

public class AdministracionDeCursosControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private AdministracionDeCursosVista vista;
	
	private ContactoVistaPrincipal contactoABM;
	private ContactoABMVistaPrincipalControlador contactoABMControlador;
	
	private AlumnoABMVistaPrincipal alumnoABM;
	private AlumnoABMVistaPrincipalControlador alumnoABMControlador;
	
	private UsuarionABMVistaPrincipal usuarioABM;
	private UsuarioABMVistaPrincipalControlador usuarioABMControlador;
	
	private CursoABMVistaPrincipal cursoABM;
	private CursoABMVistaPrincipalControlador cursoABMControlador;
	
	private CursadaABMVistaPrincipal cursadaABM;
	private CursadaABMVistaPrincipalControlador cursadaABMControlador;
	
	private TareaABMVistaPrincipal tareaABM;
	private TareaABMVistaPrincipalControlador tareaABMControlador;
	
	private SalaABMVistaPrincipal salaABM;
	private SalaABMVistaPrincipalControlador salaABMControlador;
	
	private RecadoABMVistaPrincipal recadoABM;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	
	private NotificacionABMVistaPrincipal notificacionABM;
	private NotificacionABMVistaPrincipalControlador notificacionABMControlador;
	private NotificacionPanel notificacionPanel;
	private NotificacionControlador notificacionPanelControlador;
	
	public AdministracionDeCursosControlador(AdministracionDeCursos modelo, AdministracionDeCursosVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getMenuItemAlumnoVer().addActionListener(this);		
		this.vista.getMenuItemUsuarioVer().addActionListener(this);
		this.vista.getMenuItemCursoVer().addActionListener(this);
		this.vista.getMenuItemCursadaVer().addActionListener(this);
		this.vista.getMenuItemTareaVer().addActionListener(this);
		this.vista.getMenuItemSalaVer().addActionListener(this);
		this.vista.getMenuItemLogin().addActionListener(this);
		this.vista.getMenuItemLogout().addActionListener(this);
		this.vista.getMenuItemContactoVer().addActionListener(this);
		this.vista.getMenuItemRecadosVer().addActionListener(this);
		this.vista.getMenuItemNotificacionesVer().addActionListener(this);
	}
	

	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		resetVistas();
		
		if (e.getSource() == this.vista.getMenuItemAlumnoVer()) {
			if (alumnoABM == null) {
				alumnoABM = new AlumnoABMVistaPrincipal();
				alumnoABMControlador = new AlumnoABMVistaPrincipalControlador(modelo, alumnoABM, vista);
				alumnoABMControlador.inicializar();

				this.vista.getMainPanel().add(alumnoABM);
			}
		}
		if (e.getSource() == this.vista.getMenuItemContactoVer()) {
			if (contactoABM == null) {
				contactoABM = new ContactoVistaPrincipal();
				contactoABMControlador = new ContactoABMVistaPrincipalControlador(modelo, contactoABM, vista);
				
				this.vista.getMainPanel().add(contactoABM);
			}	
		} else if (e.getSource()== this.vista.getMenuItemUsuarioVer()) {
			if (usuarioABM == null) {
				usuarioABM = new UsuarionABMVistaPrincipal();
				usuarioABMControlador = new UsuarioABMVistaPrincipalControlador(modelo, usuarioABM, vista);
				
				this.vista.getMainPanel().add(usuarioABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemCursoVer()) {
			if (cursoABM == null) {
				cursoABM = new CursoABMVistaPrincipal();
				cursoABMControlador = new CursoABMVistaPrincipalControlador(modelo , cursoABM, vista);
				
				this.vista.getMainPanel().add(cursoABM);
			}			
		} else if (e.getSource()== this.vista.getMenuItemCursadaVer()) {
			if (cursadaABM == null) {
				cursadaABM = new CursadaABMVistaPrincipal();
				cursadaABMControlador = new CursadaABMVistaPrincipalControlador(modelo, cursadaABM, vista, null);
				cursadaABMControlador.inicialiar();
				
				this.vista.getMainPanel().add(cursadaABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemTareaVer()) {
			if (tareaABM == null) {
				tareaABM = new TareaABMVistaPrincipal();
				tareaABMControlador = new TareaABMVistaPrincipalControlador(modelo, tareaABM, vista,null,null);
				this.vista.getMainPanel().add(tareaABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemSalaVer()) {
			if (salaABM == null) {
				salaABM = new SalaABMVistaPrincipal();
				salaABMControlador = new SalaABMVistaPrincipalControlador(modelo, salaABM, vista);
				
				this.vista.getMainPanel().add(salaABM);
			}
		}
		else if (e.getSource()== this.vista.getMenuItemLogout()) {
			System.out.println("Salir del sistema");
			int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir?", "Salir del sistema", JOptionPane.YES_NO_OPTION);
		    if (respuesta == JOptionPane.YES_OPTION)
		    {
		    	this.vista.getFrame().dispose();
		    }
			}
		else if (e.getSource()==this.vista.getMenuItemLogin()) {
			System.out.println("Cambiar de usuario");
			this.vista.getFrame().dispose();
			LoginVista vista = new LoginVista();
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		else if (e.getSource()==this.vista.getMenuItemRecadosVer()) {
				recadoABM = new RecadoABMVistaPrincipal();
				recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABM, vista, null, null);
				
				this.vista.getMainPanel().add(recadoABM);
		}
		else if (e.getSource()==this.vista.getMenuItemNotificacionesVer()) {
				notificacionABM = new NotificacionABMVistaPrincipal();
				notificacionABMControlador = new NotificacionABMVistaPrincipalControlador(modelo, notificacionABM, vista, null, null);
				notificacionPanel = new NotificacionPanel();
				notificacionPanelControlador = new NotificacionControlador(modelo, notificacionPanel, vista, null, null);
				notificacionPanelControlador.inicializar();
				this.vista.getMainPanel().add(notificacionABM);
				notificacionABM.getMainPanel().add(notificacionPanel);
		}
		this.vista.getFrame().repaint();		
	}
	
	private void resetVistas() {
		if (cursoABMControlador != null) {
			cursoABM = null;
			cursoABMControlador = null;
		}
		if (usuarioABMControlador != null) {
			usuarioABM = null;
			usuarioABMControlador = null;
		}
		if (alumnoABMControlador != null) {
			alumnoABM = null;
			alumnoABMControlador = null;
		}
		if (cursadaABMControlador != null) {
			cursadaABM = null;
			cursadaABMControlador = null;
		}
		if (tareaABMControlador != null) {
			tareaABM = null;
			tareaABMControlador = null;
		}
		if (salaABMControlador != null) {
			salaABM = null;
			salaABMControlador = null;
		}
		if (contactoABMControlador != null) {
			contactoABM = null;
			contactoABMControlador = null;
		}
		
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().repaint();
		this.vista.getFrame().repaint();
	}
}