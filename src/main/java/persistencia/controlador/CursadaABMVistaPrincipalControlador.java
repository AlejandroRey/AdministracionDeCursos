package persistencia.controlador;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import dto.CursadaDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.AlumnosAsistenciaPanel;
import presentacion.vista.AlumnosEvaluacionesPanel;
import presentacion.vista.AlumnosInscriptosPanel;
import presentacion.vista.CalendarioBuilderPanel;
import presentacion.vista.CursadaABMPanel;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.InstructorVista;

public class CursadaABMVistaPrincipalControlador {
	
	private AdministracionDeCursos modelo;
	private CursadaABMVistaPrincipal vista;
	
	private CursadaABMControlador cursadaABMControlador;
	private CursadaABMPanel cursadaABM;
	
	private CursadaDTO cursadaDTO;
	
	private CalendarBuilderControlador calendarioControlador;
	private CalendarioBuilderPanel calendario;
	
	private AlumnosInscriptosControlador alumnosInscriptosControlador;
	private AlumnosInscriptosPanel alumnosInscriptos;	
	
	private AlumnosAsistenciaControlador alumnosAsistenciaControlador;
	private AlumnosAsistenciaPanel alumnosAsistencia;
	
	private AlumnosEvaluacionesControlador alumnosEvaluacionesControlador;
	private AlumnosEvaluacionesPanel alumnosEvaluaciones;
	
	private AdministracionDeCursosVista administracionVista;
	private AdministrativoVista administrativoVista;
	private AdministrativoVistaControlador administrativoVistaControlador;
	private InstructorAdministracionVista instructorAdministracionVista;
	private InstructorVista instructorVista;
	private InstructorVistaControlador instructorVistaControlador;
	
	public CursadaABMVistaPrincipalControlador(AdministracionDeCursos modelo, CursadaABMVistaPrincipal vista, AdministracionDeCursosVista administracionVista, InstructorAdministracionVista instructorAdministracionVista) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.administracionVista = administracionVista;
		this.instructorAdministracionVista = instructorAdministracionVista;
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

	public void inicialiar() {
		setSeleccionarCursadaVistaInicial();
	}

	private void btnHome_MousePressed(MouseEvent evt) {
		resetVistas();
		if(this.modelo.getUsuarioLogueado().getIdCategoria()==2) {
		try{this.administracionVista.getFrame().dispose();
		administrativoVista = new AdministrativoVista();
		administrativoVistaControlador = new AdministrativoVistaControlador(administrativoVista,
				modelo);
		administrativoVistaControlador.inicializar();}
		catch(Exception ex){
			
		}
		}
		else {
			instructorAdministracionVista.getFrame().dispose();
			instructorVista = new InstructorVista();
			instructorVistaControlador = new InstructorVistaControlador(instructorVista, modelo);
			instructorVistaControlador.inicializar();
			
		}
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

		if (alumnosAsistencia == null && cursadaDTO != null) {
			alumnosAsistencia = new AlumnosAsistenciaPanel();
			alumnosAsistenciaControlador = new AlumnosAsistenciaControlador(alumnosAsistencia, modelo, cursadaDTO);
			alumnosAsistenciaControlador.inicializar();

			this.vista.getMainPanel().add(alumnosAsistencia);
			setBounds(alumnosAsistencia,90,70);
		}
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
			setBounds(calendario,40,80);
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
		
		if (alumnosEvaluaciones == null && cursadaDTO != null) {
			alumnosEvaluaciones = new AlumnosEvaluacionesPanel();
			alumnosEvaluacionesControlador = new AlumnosEvaluacionesControlador(alumnosEvaluaciones, modelo, cursadaDTO);
			alumnosEvaluacionesControlador.inicializar();
			
			this.vista.getMainPanel().add(alumnosEvaluaciones);
			setBounds(alumnosEvaluaciones,250,50);
		}
		refreshVistas();
	}

	private void btnInscriptos_MousePressed(MouseEvent evt) {
		resetVistas();
		
		setColor(this.vista.getBtnInscriptos());
		resetColor(new JPanel[] { this.vista.getBtnAsistencias(), 
								  this.vista.getBtnCalendario(),
								  this.vista.getBtnEvaluaciones(),
								  this.vista.getBtnPagos()});
		
		if (alumnosInscriptos == null && cursadaDTO != null) {
			alumnosInscriptos =  new AlumnosInscriptosPanel();
			alumnosInscriptosControlador = new AlumnosInscriptosControlador(alumnosInscriptos, modelo, cursadaDTO);
			alumnosInscriptosControlador.inicializar();
			
			this.vista.getMainPanel().add(alumnosInscriptos);
			setBounds(alumnosInscriptos,258,45);
		}
		
		refreshVistas();
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
		setSeleccionarCursadaVistaInicial();	
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
			cursadaABMControlador.inicializar();
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
			cursadaABMControlador.inicializar();
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
			cursadaABMControlador.inicializar();
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
		if (alumnosInscriptos != null) {
			alumnosInscriptos = null;
			alumnosInscriptosControlador = null;
		}
		if (alumnosAsistencia != null) {
			alumnosAsistencia = null;
			alumnosAsistenciaControlador = null;
		}
		if (alumnosEvaluaciones != null) {
			alumnosEvaluaciones = null;
			alumnosEvaluacionesControlador = null;
		}
		
		this.vista.getMainPanel().removeAll();
		
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
		this.vista.revalidate();
		this.vista.repaint();
		
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

	private void setSeleccionarCursadaVistaInicial() {
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
			cursadaABMControlador.inicializar();
		}

		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();
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
