package persistencia.controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import dto.AlumnoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoABMPanel;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.AlumnoHistorialNotaPanel;
import presentacion.vista.CursadaABMPanel;

public class AlumnoABMVistaPrincipalControlador {

	private AdministracionDeCursos modelo;
	private AlumnoABMVistaPrincipal vista;
	
	private AlumnoABMControlador alumnoABMControlador;
	private AlumnoABMPanel alumnoABM;
	
	private AlumnoHistorialNotaControlador alumnoHistorialNotaControlador;
	private AlumnoHistorialNotaPanel alumnoHistorialNota;
	
	private AlumnoDTO alumnoDTO;

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

		this.vista.getBtnNotas().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnNotas_MousePressed(evt);
			}
		});
		
		this.vista.getBtnAsistencias().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnAsistencias_MousePressed(evt);
			}
		});
		
		this.vista.getBtnPagos().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnPagos_MousePressed(evt);
			}
		});
		
		this.vista.getBtnContactos().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnContactos_MousePressed(evt);
			}
		});
		
		this.vista.getBtnHomeI().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHomeI_MousePressed(evt);
			}
		});
		
		this.vista.getBtnHomeII().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHomeII_MousePressed(evt);
			}
		});
	}
	
	public void inicializar() {
		setSeleccionarAlumnoVistaInicial();
	}

	private void btnHomeI_MousePressed(MouseEvent evt) {
		setVisiblePanelHistorial();
	}
	
	public void setVisiblePanelHistorial() {
		this.vista.getPanelAbm().setVisible(false);
		this.vista.getPanelHistorial().setVisible(true);
	}
	
	public void btnHomeII_MousePressed(MouseEvent evt) {
		setVisiblePanelAbm();
		clearMainPanel();
		refreshVistas();
		setSeleccionarAlumnoVistaInicial();
	}

	private void setVisiblePanelAbm() {
		this.vista.getPanelAbm().setVisible(true);
		this.vista.getPanelHistorial().setVisible(false);
	}

	private void btnSeleccionar_MousePressed(MouseEvent evt) {
		setSeleccionarAlumnoVistaInicial();
	}
	
	private void setSeleccionarAlumnoVistaInicial() {
        setColor(this.vista.getBtnVer()); 
        resetColor(new JPanel[]{this.vista.getBtnAgregar(), 
        						this.vista.getBtnActualizar(), 
        						this.vista.getBtnEliminar()});

		if (alumnoABMControlador == null) {
			alumnoABM = new AlumnoABMPanel();
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, this, modelo);
			alumnoABMControlador.inicializar();
			alumnoABMControlador.setVisibleBtnSeleccionar();

			this.vista.getMainPanel().add(alumnoABM);
		} else {
			alumnoABMControlador.setVisibleBtnSeleccionar();
			alumnoABMControlador.inicializar();
		}

		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}
	
	

	private void btnAgregar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAgregar());
		resetColor(new JPanel[] { this.vista.getBtnVer(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (alumnoABMControlador == null) {
			alumnoABM = new AlumnoABMPanel();
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, this, modelo);
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
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, this, modelo);
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
			alumnoABMControlador = new AlumnoABMControlador(alumnoABM, this, modelo);
			alumnoABMControlador.inicializar();
			alumnoABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(alumnoABM);
		} else {
			alumnoABMControlador.setVisibleBtnEliminar();
		}

		this.vista.getMainPanel().repaint();
	}
	
	private void btnNotas_MousePressed(MouseEvent evt) {		
		setColor(this.vista.getBtnNotas());
		resetColor(new JPanel[] { this.vista.getBtnAsistencias(),
								  this.vista.getBtnPagos(), 
								  this.vista.getBtnContactos()});
		
		clearMainPanel();
		
		if (alumnoHistorialNota == null && alumnoDTO != null) {
			alumnoHistorialNota = new AlumnoHistorialNotaPanel();
			alumnoHistorialNotaControlador = new AlumnoHistorialNotaControlador(modelo, alumnoHistorialNota);
			alumnoHistorialNotaControlador.inicializar();
			
			this.vista.getMainPanel().add(alumnoHistorialNota);
		}

		refreshVistas();
	}
	
	private void btnAsistencias_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAsistencias());
		resetColor(new JPanel[] { this.vista.getBtnNotas(),
								  this.vista.getBtnPagos(), 
								  this.vista.getBtnContactos()});
		
		clearMainPanel();
		refreshVistas();
	}
	
	private void btnPagos_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnPagos());
		resetColor(new JPanel[] { this.vista.getBtnNotas(),
								  this.vista.getBtnAsistencias(),
								  this.vista.getBtnContactos()});
		
		clearMainPanel();
		refreshVistas();		
	}
	
	private void btnContactos_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnContactos());
		resetColor(new JPanel[] { this.vista.getBtnNotas(),
								  this.vista.getBtnAsistencias(), 
								  this.vista.getBtnPagos()});
		
		clearMainPanel();
		refreshVistas();
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 80));
	}
	
	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(23, 35, 51));
		}
	}
	
	private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
		panel.setEnabled(isEnabled);

		Component[] components = panel.getComponents();

		for (int i = 0; i < components.length; i++) {
			if (components[i].getClass().getName() == "javax.swing.JPanel") {
				setPanelEnabled((JPanel) components[i], isEnabled);
			}

			components[i].setEnabled(isEnabled);
		}
	}

	public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
		this.alumnoDTO = alumnoDTO;
	}

	public void setLabelAlumno() {
		if (alumnoDTO != null) {
			this.vista.getLblAlumnoActual().setText(alumnoDTO.getNombre() + " " + alumnoDTO.getApellido());
		}
	}
	
	public void clearMainPanel() {
		if (alumnoABM != null) {
			alumnoABM = null;
			alumnoABMControlador = null;
		}
		if (alumnoHistorialNota != null) {
			alumnoHistorialNotaControlador = null;
			alumnoHistorialNota = null;
		}

		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
	}

	public void refreshVistas() {
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
	}
	
	public JPanel getMainPanel() {
		return this.vista.getMainPanel();
	}
	
}
