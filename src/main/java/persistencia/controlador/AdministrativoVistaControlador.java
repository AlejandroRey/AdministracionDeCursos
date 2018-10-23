package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.CursoABMVistaPrincipal;
import presentacion.vista.SalaABMVistaPrincipal;
import presentacion.vista.TareaABMVistaPrincipal;
import presentacion.vista.VistaInicial;

public class AdministrativoVistaControlador implements ActionListener {
	
	private AdministrativoVista vista;
	private AdministracionDeCursos modelo;
	private AdministracionDeCursosVista administracionVista;
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
	
	public AdministrativoVistaControlador(AdministrativoVista vista) {
		super();
		this.vista = vista;
		
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
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
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
			JOptionPane.showMessageDialog(null, "Esta función todavía no está desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnCerrarSesion()) {
			this.vista.getFrmAdministrativo().dispose();
			this.vistaInicial = new VistaInicial();
			this.vistaInicialControlador = new VistaInicialControlador(vistaInicial);
		}
		if (e.getSource() == this.vista.getBtnContactos()) {
		
		}
		if (e.getSource() == this.vista.getBtnCursadas()) {
			this.vista.getFrmAdministrativo().dispose();
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
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
			this.vista.getFrmAdministrativo().dispose();
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
			administracionVista = new AdministracionDeCursosVista();
			controlador = new AdministracionDeCursosControlador(modelo, administracionVista);
			controlador.inicializar();
			
			if (cursoABM == null) {
				cursoABM = new CursoABMVistaPrincipal();
				cursoABMControlador = new CursoABMVistaPrincipalControlador(modelo , cursoABM);
				
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
			
		}
		if (e.getSource() == this.vista.getBtnNotificaciones()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no está desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnRecados()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no está desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnSalas()) {
			this.vista.getFrmAdministrativo().dispose();
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
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
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
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