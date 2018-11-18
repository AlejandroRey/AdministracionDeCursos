package persistencia.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.SalaABMPanel;
import presentacion.vista.SalaABMVistaPrincipal;

public class SalaABMVistaPrincipalControlador {
	
	private AdministracionDeCursos modelo;
	private SalaABMVistaPrincipal vista;
	
	private SalaABMControlador salaABMControlador;
	private SalaABMPanel salaABM;

	public SalaABMVistaPrincipalControlador(AdministracionDeCursos modelo, SalaABMVistaPrincipal vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;

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

	private void btnAgregar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAgregar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] {this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (salaABMControlador == null) {
			salaABM = new SalaABMPanel();
			salaABMControlador = new SalaABMControlador(salaABM, modelo);
			salaABMControlador.inicializar();
			salaABMControlador.setVisibleBtnAgregar();

			this.vista.getMainPanel().add(salaABM);
		} else {
			salaABMControlador.setVisibleBtnAgregar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] {this.vista.getBtnAgregar(), this.vista.getBtnEliminar() });

		if (salaABMControlador == null) {
			salaABM = new SalaABMPanel();
			salaABMControlador = new SalaABMControlador(salaABM, modelo);
			salaABMControlador.inicializar();
			salaABMControlador.setVisibleBtnActualizar();

			this.vista.getMainPanel().add(salaABM);
		} else {
			salaABMControlador.setVisibleBtnActualizar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] {this.vista.getBtnActualizar(), this.vista.getBtnAgregar() });

		if (salaABMControlador == null) {
			salaABM = new SalaABMPanel();
			salaABMControlador = new SalaABMControlador(salaABM, modelo);
			salaABMControlador.inicializar();
			salaABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(salaABM);
		} else {
			salaABMControlador.setVisibleBtnEliminar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 80));
	}
	
	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(0, 0, 0));
		}
	}
}
