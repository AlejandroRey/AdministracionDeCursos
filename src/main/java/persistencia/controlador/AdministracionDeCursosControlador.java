package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.CursoABMPanel;
import presentacion.vista.CursoABMVistaPrincipal;
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
	
	public AdministracionDeCursosControlador(AdministracionDeCursos modelo, AdministracionDeCursosVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getMenuItemAlumnoVer().addActionListener(this);		
		this.vista.getMenuItemUsuarioVer().addActionListener(this);
		this.vista.getMenuItemCursoVer().addActionListener(this);
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
		
		this.vista.getMainPanel().removeAll();
		this.vista.getFrame().repaint();
	}

}
