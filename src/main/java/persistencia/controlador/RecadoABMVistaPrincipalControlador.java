package persistencia.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.RecadoABMPanel;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.RecadoEnviarPanel;

public class RecadoABMVistaPrincipalControlador {

	private RecadoABMVistaPrincipal vista;
	private AdministracionDeCursos modelo;
	private RecadoEnviarPanel recadoEnviarPanel;
	private RecadoEnviarPanelControlador recadoEnviarPanelControlador;
	private RecadoABMPanel recadoABMPanelEnviados;
	private RecadoABMPanel recadoABMPanelRecibidos;
	private RecadoABMPanel recadoABMPanelEliminados;
	private RecadoABMPanelControlador recadoABMPanelEnviadosControlador;
	private RecadoABMPanelControlador recadoABMPanelRecibidosControlador;
	private RecadoABMPanelControlador recadoABMPanelEliminadosControlador;

	public RecadoABMVistaPrincipalControlador(AdministracionDeCursos modelo, RecadoABMVistaPrincipal vista) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnNuevo();
		this.vista.getBtnEnviados();
		this.vista.getBtnEliminados();
		this.vista.getBtnRecibidos();

		this.vista.getBtnNuevo().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				getBtnNuevo(evt);
			}
		});

		this.vista.getBtnEnviados().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				getBtnEnviados(evt);
			}
		});

		this.vista.getBtnEliminados().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				getBtnEliminados(evt);
			}
		});

		this.vista.getBtnRecibidos().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				getBtnRecibidos(evt);
			}
		});

	}

	private void getBtnNuevo(MouseEvent evt) {
		setColor(this.vista.getBtnNuevo());
		resetColor(new JPanel[] { this.vista.getBtnEliminados(), this.vista.getBtnRecibidos(),
				this.vista.getBtnEnviados() });
		clearMainPanel();
		if (recadoEnviarPanelControlador == null) {
			recadoEnviarPanel = new RecadoEnviarPanel();
			recadoEnviarPanelControlador = new RecadoEnviarPanelControlador(modelo, recadoEnviarPanel);
			recadoEnviarPanelControlador.limpiarInputs();
			this.vista.getMainPanel().add(recadoEnviarPanel);
		} else {
			recadoEnviarPanelControlador.limpiarInputs();
			this.vista.getMainPanel().add(recadoEnviarPanel);
		}
		this.vista.getMainPanel().repaint();
		this.vista.getMainPanel().revalidate();
	}

	private void getBtnRecibidos(MouseEvent evt) {
		setColor(this.vista.getBtnRecibidos());
		resetColor(
				new JPanel[] { this.vista.getBtnEliminados(), this.vista.getBtnNuevo(), this.vista.getBtnEnviados() });
		clearMainPanel();
		if (recadoABMPanelRecibidos == null) {
			recadoABMPanelRecibidos = new RecadoABMPanel("Recibidos");
			recadoABMPanelRecibidos.setBtnRestaurarVisible(false);
			recadoABMPanelRecibidosControlador = new RecadoABMPanelControlador(modelo, recadoABMPanelRecibidos,
					"Recibidos");
			recadoABMPanelRecibidosControlador.inicializar();
			this.vista.getMainPanel().add(recadoABMPanelRecibidos);
		} else {
			recadoABMPanelRecibidosControlador.inicializar();
			this.vista.getMainPanel().add(recadoABMPanelRecibidos);
		}
		this.vista.getMainPanel().repaint();
		this.vista.getMainPanel().revalidate();
	}

	private void getBtnEliminados(MouseEvent evt) {
		setColor(this.vista.getBtnEliminados());
		resetColor(
				new JPanel[] { this.vista.getBtnEnviados(), this.vista.getBtnNuevo(), this.vista.getBtnRecibidos() });
		clearMainPanel();
		if (recadoABMPanelEliminados == null) {
			recadoABMPanelEliminados = new RecadoABMPanel("Eliminados");
			recadoABMPanelEliminadosControlador = new RecadoABMPanelControlador(modelo, recadoABMPanelEliminados,
					"Eliminados");
			recadoABMPanelEliminadosControlador.inicializar();
			this.vista.getMainPanel().add(recadoABMPanelEliminados);
		} else {
			recadoABMPanelEliminadosControlador.inicializar();
			this.vista.getMainPanel().add(recadoABMPanelEliminados);
		}
		this.vista.getMainPanel().repaint();
		this.vista.getMainPanel().revalidate();
	}

	private void getBtnEnviados(MouseEvent evt) {
		setColor(this.vista.getBtnEnviados());
		resetColor(
				new JPanel[] { this.vista.getBtnEliminados(), this.vista.getBtnNuevo(), this.vista.getBtnRecibidos() });
		clearMainPanel();
		if (recadoABMPanelEnviados == null) {
			recadoABMPanelEnviados = new RecadoABMPanel("Enviados");
			recadoABMPanelEnviados.setBtnRestaurarVisible(false);
			recadoABMPanelEnviadosControlador = new RecadoABMPanelControlador(modelo, recadoABMPanelEnviados,
					"Enviados");
			recadoABMPanelEnviadosControlador.inicializar();
			this.vista.getMainPanel().add(recadoABMPanelEnviados);
		} else {
			recadoABMPanelEnviadosControlador.inicializar();
			this.vista.getMainPanel().add(recadoABMPanelEnviados);
		}
		this.vista.getMainPanel().repaint();
		this.vista.getMainPanel().revalidate();
	}

	private void setColor(JPanel pane) {
		pane.setBackground(new Color(0, 0, 0));
	}

	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(47, 79, 79));
		}
	}

	public void clearMainPanel() {
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
	}

}