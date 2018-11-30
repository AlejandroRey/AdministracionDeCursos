package persistencia.controlador;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.UsuarioABMPanel;
import presentacion.vista.UsuarionABMVistaPrincipal;

public class UsuarioABMVistaPrincipalControlador {

	private AdministracionDeCursos modelo;
	private UsuarionABMVistaPrincipal vista;

	private UsuarioABMControlador usuarioABMControlador;
	private UsuarioABMPanel usuarioABM;
	private AdministracionDeCursosVista administracionVista;
	private AdministrativoVista administrativoVista;
	private AdministrativoVistaControlador administrativoVistaControlador;

	public UsuarioABMVistaPrincipalControlador(AdministracionDeCursos modelo, UsuarionABMVistaPrincipal vista,
			AdministracionDeCursosVista administracionVista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.administracionVista = administracionVista;

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

		this.vista.getLblHome().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHome_MousePressed(evt);
			}
		});

	}

	private void btnHome_MousePressed(MouseEvent evt) {
		this.administracionVista.getFrame().dispose();
		administrativoVista = new AdministrativoVista();
		administrativoVistaControlador = new AdministrativoVistaControlador(administrativoVista, modelo);
		administrativoVistaControlador.inicializar();
	}

	private void btnSeleccionar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnSeleccionar());
		resetColor(new JPanel[] { this.vista.getBtnAgregar(), this.vista.getBtnActualizar(),
				this.vista.getBtnEliminar() });

		if (usuarioABMControlador == null) {
			usuarioABM = new UsuarioABMPanel();
			usuarioABMControlador = new UsuarioABMControlador(usuarioABM, modelo);
			usuarioABMControlador.inicializar();
			usuarioABMControlador.setVisibleBtnSeleccionar();

			this.vista.getMainPanel().add(usuarioABM);
			setBounds(usuarioABM, 140, 45);
		} else {
			usuarioABMControlador.setVisibleBtnSeleccionar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnAgregar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAgregar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnActualizar(),
				this.vista.getBtnEliminar() });

		if (usuarioABMControlador == null) {
			usuarioABM = new UsuarioABMPanel();
			usuarioABMControlador = new UsuarioABMControlador(usuarioABM, modelo);
			usuarioABMControlador.inicializar();
			usuarioABMControlador.setVisibleBtnAgregar();

			this.vista.getMainPanel().add(usuarioABM);
			setBounds(usuarioABM, 140, 45);
		} else {
			usuarioABMControlador.setVisibleBtnAgregar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnAgregar(),
				this.vista.getBtnEliminar() });

		if (usuarioABMControlador == null) {
			usuarioABM = new UsuarioABMPanel();
			usuarioABMControlador = new UsuarioABMControlador(usuarioABM, modelo);
			usuarioABMControlador.inicializar();
			usuarioABMControlador.setVisibleBtnActualizar();

			this.vista.getMainPanel().add(usuarioABM);
			setBounds(usuarioABM, 140, 45);
			} else {
			usuarioABMControlador.setVisibleBtnActualizar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnActualizar(),
				this.vista.getBtnAgregar() });

		if (usuarioABMControlador == null) {
			usuarioABM = new UsuarioABMPanel();
			usuarioABMControlador = new UsuarioABMControlador(usuarioABM, modelo);
			usuarioABMControlador.inicializar();
			usuarioABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(usuarioABM);
			setBounds(usuarioABM, 140, 45);
		} else {
			usuarioABMControlador.setVisibleBtnEliminar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void setColor(JPanel pane) {
		pane.setBackground(new Color(23, 35, 51));
	}

	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(0, 0, 0));

		}
	}
	private void setBounds(JPanel panel, int x, int y) {
		Rectangle bounds = panel.getBounds();
		bounds.translate(x, y);
		panel.setBounds(bounds);		
	}

}
