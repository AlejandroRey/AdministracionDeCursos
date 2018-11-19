package persistencia.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministrativoABMPanel;
import presentacion.vista.AdministrativoABMVistaPrincipal;
import presentacion.vista.UsuarioABMPanel;

public class AdministrativoABMVistaPrincipalControlador {
	
	private AdministracionDeCursos modelo;
	private AdministrativoABMVistaPrincipal vista;
	
	private AdministrativoABMControlador administrativoABMControlador;
	private AdministrativoABMPanel administrativoABMVista;
	
	public AdministrativoABMVistaPrincipalControlador(AdministracionDeCursos modelo, AdministrativoABMVistaPrincipal vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.modelo = modelo;
		this.vista = vista;

		this.vista.getBtnSeleccionar().addMouseListener(new java.awt.event.MouseAdapter() {
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
		setColor(this.vista.getBtnSeleccionar());
		resetColor(new JPanel[] { this.vista.getBtnAgregar(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (administrativoABMControlador == null) {
			administrativoABMVista = new AdministrativoABMPanel();
			administrativoABMControlador = new AdministrativoABMControlador(administrativoABMVista, modelo);
			administrativoABMControlador.inicializar();
			administrativoABMControlador.setVisibleBtnSeleccionar();

			this.vista.getMainPanel().add(administrativoABMVista);
		} else {
			administrativoABMControlador.setVisibleBtnSeleccionar();
		}

		this.vista.getMainPanel().repaint();		
	}	

	private void btnAgregar_MousePressed(MouseEvent evt) {		
		setColor(this.vista.getBtnAgregar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (administrativoABMControlador == null) {
			administrativoABMVista = new AdministrativoABMPanel();
			administrativoABMControlador = new AdministrativoABMControlador(administrativoABMVista, modelo);
			administrativoABMControlador.inicializar();
			administrativoABMControlador.setVisibleBtnAgregar();

			this.vista.getMainPanel().add(administrativoABMVista);
		} else {
			administrativoABMControlador.setVisibleBtnAgregar();
		}

		this.vista.getMainPanel().repaint();	
	}	

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnAgregar(), this.vista.getBtnEliminar() });

		if (administrativoABMControlador == null) {
			administrativoABMVista = new AdministrativoABMPanel();
			administrativoABMControlador = new AdministrativoABMControlador(administrativoABMVista, modelo);
			administrativoABMControlador.inicializar();
			administrativoABMControlador.setVisibleBtnActualizar();

			this.vista.getMainPanel().add(administrativoABMVista);
		} else {
			administrativoABMControlador.setVisibleBtnActualizar();
		}

		this.vista.getMainPanel().repaint();	
	}	

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnActualizar(), this.vista.getBtnAgregar() });

		if (administrativoABMControlador == null) {
			administrativoABMVista = new AdministrativoABMPanel();
			administrativoABMControlador = new AdministrativoABMControlador(administrativoABMVista, modelo);
			administrativoABMControlador.inicializar();
			administrativoABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(administrativoABMVista);
		} else {
			administrativoABMControlador.setVisibleBtnEliminar();
		}

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