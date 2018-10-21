package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.CursoABMVistaPrincipal;
import presentacion.vista.SalaABMVistaPrincipal;
import presentacion.vista.TareaABMVistaPrincipal;
import presentacion.vista.UsuarionABMVistaPrincipal;

public class AdministracionDeCursosControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private AdministracionDeCursosVista vista;
	
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
	}
	

	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		resetVistas();
		
		if (e.getSource() == this.vista.getMenuItemAlumnoVer()) {
			if (alumnoABM == null) {
				alumnoABM = new AlumnoABMVistaPrincipal();
				alumnoABMControlador = new AlumnoABMVistaPrincipalControlador(modelo, alumnoABM);

				this.vista.getMainPanel().add(alumnoABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemUsuarioVer()) {
			if (usuarioABM == null) {
				usuarioABM = new UsuarionABMVistaPrincipal();
				usuarioABMControlador = new UsuarioABMVistaPrincipalControlador(modelo, usuarioABM);
				
				this.vista.getMainPanel().add(usuarioABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemCursoVer()) {
			if (cursoABM == null) {
				cursoABM = new CursoABMVistaPrincipal();
				cursoABMControlador = new CursoABMVistaPrincipalControlador(modelo , cursoABM);
				
				this.vista.getMainPanel().add(cursoABM);
			}			
		} else if (e.getSource()== this.vista.getMenuItemCursadaVer()) {
			if (cursadaABM == null) {
				cursadaABM = new CursadaABMVistaPrincipal();
				cursadaABMControlador = new CursadaABMVistaPrincipalControlador(modelo, cursadaABM);
				
				this.vista.getMainPanel().add(cursadaABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemTareaVer()) {
			if (tareaABM == null) {
				tareaABM = new TareaABMVistaPrincipal();
				tareaABMControlador = new TareaABMVistaPrincipalControlador(modelo, tareaABM);
				
				this.vista.getMainPanel().add(tareaABM);
			}
		} else if (e.getSource()== this.vista.getMenuItemSalaVer()) {
			if (salaABM == null) {
				salaABM = new SalaABMVistaPrincipal();
				salaABMControlador = new SalaABMVistaPrincipalControlador(modelo, salaABM);
				
				this.vista.getMainPanel().add(salaABM);
			}
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
		
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().repaint();
		this.vista.getFrame().repaint();
	}

}
