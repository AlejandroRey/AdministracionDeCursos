package persistencia.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoABMPanel;
import presentacion.vista.AlumnoABMVistaPrincipal;

public class AlumnoABMVistaPrincipalControlador {

	private AdministracionDeCursos modelo;
	private AlumnoABMVistaPrincipal vista;
	
	private AlumnoABMControlador alumnoABMControlador;
	private AlumnoABMPanel alumnoABM;

	public AlumnoABMVistaPrincipalControlador(AdministracionDeCursos modelo, AlumnoABMVistaPrincipal vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;

		this.vista.getBtnVer().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnSeleccionar_MousePressed(evt);
			}
		});

		this.vista.getBtnAgregar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnAgregar_MousePressed(evt);
			}
		});

		this.vista.getBtnActualizar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnActualizar_MousePressed(evt);
			}
		});

		this.vista.getBtnEliminar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEliminar_MousePressed(evt);
			}
		});

	}

	private void btnSeleccionar_MousePressed(MouseEvent evt) {
        setColor(this.vista.getBtnVer()); 
        resetColor(new JPanel[]{this.vista.getBtnAgregar(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar()});
        
        this.vista.getMainPanel().repaint();
	}

	private void btnAgregar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAgregar());
		resetColor(new JPanel[] { this.vista.getBtnVer(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (alumnoABMControlador == null) {
			alumnoABM = new AlumnoABMPanel();
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
			alumnoABMControlador.inicializar();
			alumnoABMControlador.setVisibleBtnAgregar();

			this.vista.getMainPanel().add(alumnoABM);
		} else {
			alumnoABMControlador.setVisibleBtnAgregar();
		}

		this.vista.getMainPanel().repaint();
	}

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		resetColor(new JPanel[] { this.vista.getBtnVer(), this.vista.getBtnAgregar(), this.vista.getBtnEliminar() });

		if (alumnoABMControlador == null) {
			alumnoABM = new AlumnoABMPanel();
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
			alumnoABMControlador.inicializar();
			alumnoABMControlador.setVisibleBtnActualizar();

			this.vista.getMainPanel().add(alumnoABM);
		} else {
			alumnoABMControlador.setVisibleBtnActualizar();
		}

		this.vista.getMainPanel().repaint();
	}

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		resetColor(new JPanel[] { this.vista.getBtnVer(), this.vista.getBtnActualizar(), this.vista.getBtnAgregar() });

		if (alumnoABMControlador == null) {
			alumnoABM = new AlumnoABMPanel();
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, modelo);
			alumnoABMControlador.inicializar();
			alumnoABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(alumnoABM);
		} else {
			alumnoABMControlador.setVisibleBtnEliminar();
		}

		this.vista.getMainPanel().repaint();
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 80));
	}
	
	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(23, 35, 51));
		}
	}

}
