package persistencia.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import dto.CursadaDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CalendarioBuilderPanel;
import presentacion.vista.CursadaABMPanel;
import presentacion.vista.CursadaABMVistaPrincipal;

public class CursadaABMVistaPrincipalControlador {
	
	private AdministracionDeCursos modelo;
	private CursadaABMVistaPrincipal vista;
	
	private CursadaABMControlador cursadaABMControlador;
	private CursadaABMPanel cursadaABM;
	
	private CursadaDTO cursadaDTO;
	
	private CalendarBuilderControlador calendarioControlador;
	private CalendarioBuilderPanel calendario;
	
	public CursadaABMVistaPrincipalControlador(AdministracionDeCursos modelo, CursadaABMVistaPrincipal vista) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getButtonPanelExtends().setVisible(false);
		
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
		
		
		this.vista.getBtnAsistencias().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnAsistencias_MousePressed(evt);
			}
		});
		
		this.vista.getBtnCalendario().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnCalendario_MousePressed(evt);
			}
		});		
		
		this.vista.getBtnEvaluaciones().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEvaluaciones_MousePressed(evt);
			}
		});
		
		this.vista.getBtnInscriptos().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnInscriptos_MousePressed(evt);
			}
		});
		
		this.vista.getBtnPagos().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnPagos_MousePressed(evt);
			}
		});	
		
		this.vista.getBtnHome().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHome_MousePressed(evt);
			}
		});	
		
		this.vista.getBtnHomeII().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnHomeII_MousePressed(evt);
			}
		});	
	}	

	private void btnHome_MousePressed(MouseEvent evt) {
		resetVistas();
		
	}

	private void btnHomeII_MousePressed(MouseEvent evt) {
		resetVistas();
		
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		
		this.vista.getButtonPanelExtends().setVisible(false);
		this.vista.getButtonPanel().setVisible(true);
	}
	
	private void btnAsistencias_MousePressed(MouseEvent evt) {
		resetVistas();
		
		setColor(this.vista.getBtnAsistencias());
		resetColor(new JPanel[] { this.vista.getBtnCalendario(),
								  this.vista.getBtnEvaluaciones(),
								  this.vista.getBtnInscriptos(),
								  this.vista.getBtnPagos()});
		
	}

	private void btnCalendario_MousePressed(MouseEvent evt) {
		resetVistas();
		
		setColor(this.vista.getBtnCalendario());
		resetColor(new JPanel[] { this.vista.getBtnAsistencias(), 
								  this.vista.getBtnEvaluaciones(),
								  this.vista.getBtnInscriptos(),
								  this.vista.getBtnPagos()});
		
		if (calendario == null && cursadaDTO != null) {
			calendario = new CalendarioBuilderPanel();
			calendarioControlador = new CalendarBuilderControlador(cursadaDTO, calendario, modelo);
			calendarioControlador.inicializar();
			
			this.vista.getMainPanel().add(calendario);
		}
		
		refreshVistas();
	}	

	private void btnEvaluaciones_MousePressed(MouseEvent evt) {
		resetVistas();
		
		setColor(this.vista.getBtnEvaluaciones());
		resetColor(new JPanel[] { this.vista.getBtnAsistencias(), 
								  this.vista.getBtnCalendario(),
								  this.vista.getBtnInscriptos(),
								  this.vista.getBtnPagos()});		
	}

	private void btnInscriptos_MousePressed(MouseEvent evt) {
		resetVistas();
		
		setColor(this.vista.getBtnInscriptos());
		resetColor(new JPanel[] { this.vista.getBtnAsistencias(), 
								  this.vista.getBtnCalendario(),
								  this.vista.getBtnEvaluaciones(),
								  this.vista.getBtnPagos()});		
	}	

	private void btnPagos_MousePressed(MouseEvent evt) {
		resetVistas();
		
		setColor(this.vista.getBtnPagos());
		resetColor(new JPanel[] { this.vista.getBtnAsistencias(), 
								  this.vista.getBtnCalendario(),
								  this.vista.getBtnEvaluaciones(),
								  this.vista.getBtnInscriptos()});		
	}

	private void btnSeleccionar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnSeleccionar());
		resetColor(new JPanel[] { this.vista.getBtnAgregar(), 
								  this.vista.getBtnActualizar(), 
								  this.vista.getBtnEliminar() });

		if (cursadaABMControlador == null) {
			cursadaABM = new CursadaABMPanel();
			cursadaABMControlador = new CursadaABMControlador(cursadaABM, this, modelo);
			cursadaABMControlador.inicializar();
			cursadaABMControlador.setVisibleBtnSeleccionar();

			this.vista.getMainPanel().add(cursadaABM);
		} else {
			cursadaABMControlador.setVisibleBtnSeleccionar();
		}

		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();	
	}

	private void btnAgregar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnAgregar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), 
								  this.vista.getBtnActualizar(), 
								  this.vista.getBtnEliminar() });
		
		if (cursadaABMControlador == null) {
			cursadaABM = new CursadaABMPanel();
			cursadaABMControlador = new CursadaABMControlador(cursadaABM, this, modelo);
			cursadaABMControlador.inicializar();			
			cursadaABMControlador.setVisibleBtnAgregar();
			cursadaABMControlador.setEstadoCurso();

			this.vista.getMainPanel().add(cursadaABM);
		} else {			
			cursadaABMControlador.setVisibleBtnAgregar();
			cursadaABMControlador.setEstadoCurso();
		}

		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}	

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), 
								  this.vista.getBtnAgregar(), 
								  this.vista.getBtnEliminar() });
		
		if (cursadaABMControlador == null) {
			cursadaABM = new CursadaABMPanel();
			cursadaABMControlador = new CursadaABMControlador(cursadaABM, this, modelo);
			cursadaABMControlador.inicializar();
			cursadaABMControlador.setVisibleBtnActualizar();

			this.vista.getMainPanel().add(cursadaABM);
		} else {
			cursadaABMControlador.setVisibleBtnActualizar();
		}

		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), 
								  this.vista.getBtnActualizar(), 
								  this.vista.getBtnAgregar() });
		
		if (cursadaABMControlador == null) {
			cursadaABM = new CursadaABMPanel();
			cursadaABMControlador = new CursadaABMControlador(cursadaABM, this, modelo);
			cursadaABMControlador.inicializar();
			cursadaABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(cursadaABM);
		} else {
			cursadaABMControlador.setVisibleBtnEliminar();
		}

		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
	}
	

	private void refreshVistas() {
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
	}
	
	private void resetVistas() {
		if (cursadaABM != null) {
			cursadaABM = null;
			cursadaABMControlador = null;
		}
		if (calendario != null) {
			calendario = null;
			calendarioControlador = null;
		}
		
		this.vista.getMainPanel().removeAll();
		
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 80));
	}
	
	private void resetColor(JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(Color.DARK_GRAY);

		}
	}

	/**
	 * @return the vista
	 */
	public CursadaABMVistaPrincipal getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(CursadaABMVistaPrincipal vista) {
		this.vista = vista;
	}

	/**
	 * @return the cursadaDTO
	 */
	public CursadaDTO getCursadaDTO() {
		return cursadaDTO;
	}

	/**
	 * @param cursadaDTO the cursadaDTO to set
	 */
	public void setCursadaDTO(CursadaDTO cursadaDTO) {
		this.cursadaDTO = cursadaDTO;
	}

}
