package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosTestVista;
import presentacion.vista.AlumnoABMVistaPrincipal;

public class AdministracionDeCursosTestControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private AdministracionDeCursosTestVista vista;
	
	private AlumnoABMVistaPrincipal alumnoABM;
	private AlumnoABMVistaPrincipalControlador alumnoABMControlador;
	
	public AdministracionDeCursosTestControlador(AdministracionDeCursos modelo, AdministracionDeCursosTestVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getMenuItemAlumnoVer().addActionListener(this);		
	}
	

	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getMenuItemAlumnoVer()) {
			if (alumnoABM == null) {
				alumnoABM = new AlumnoABMVistaPrincipal();
				alumnoABMControlador = new AlumnoABMVistaPrincipalControlador(modelo, alumnoABM);

				this.vista.getMainPanel().add(alumnoABM);
			} 
		}
		
		this.vista.getFrame().repaint();		
	}

}
