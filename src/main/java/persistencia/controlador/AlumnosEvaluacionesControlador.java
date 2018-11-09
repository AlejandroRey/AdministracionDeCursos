package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoInscriptoDTO;
import dto.CursadaDTO;
import dto.EvaluacionDTO;
import dto.InscriptoDTO;
import dto.NotaDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnosEvaluacionesPanel;
import presentacion.vista.EvaluacionModalPanel;

public class AlumnosEvaluacionesControlador implements ActionListener {
	
	private AlumnosEvaluacionesPanel vista;
	private AdministracionDeCursos modelo;
	
	private CursadaDTO cursadaDTO;
	
	private List<AlumnoInscriptoDTO> alumnosInscriptosLista;
	private List<EvaluacionDTO> evaluacionesCursadaLista;
	private List<NotaDTO> notasEvaluacionActual;
	
	private EvaluacionDTO evaluacionActualDTO;
	private AlumnoInscriptoDTO alumnoActualDTO;
	private String notaActual;
	
	private EvaluacionModalPanel evaluacionModalPanel;
	private EvaluacionModalControlador evaluacionModalControlador;

	public AlumnosEvaluacionesControlador(AlumnosEvaluacionesPanel vista,
										  AdministracionDeCursos modelo, 
										  CursadaDTO cursadaDTO) {
		this.vista = vista;
		this.modelo = modelo;
		this.cursadaDTO = cursadaDTO;
		
		this.alumnosInscriptosLista = new ArrayList<AlumnoInscriptoDTO>();
		this.evaluacionesCursadaLista = new ArrayList<EvaluacionDTO>();
		this.notasEvaluacionActual = new ArrayList<NotaDTO>();
		
		this.vista.getBtnAgregarEvaluacion().addActionListener(this);
		this.vista.getBtnEliminarEvaluacion().addActionListener(this);
		this.vista.getBtnActualizarNota().addActionListener(this);
		
		inicializar();
	}

	public void inicializar() {
		
		llenarTablaEvaluaciones();
		llenarTablaAlumnosInscriptos();
	}

	public void llenarTablaEvaluaciones() {
		this.vista.getModelEvaluaciones().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelEvaluaciones().setColumnCount(0);
		this.vista.getModelEvaluaciones().setColumnIdentifiers(this.vista.getNombreColumnasEvaluaciones());
		clearComponents();
		
		this.evaluacionesCursadaLista = modelo.obtenerEvaluacionCursada(cursadaDTO);
		if (this.evaluacionesCursadaLista.size() > 0) {
			for (EvaluacionDTO evaluacionDTO : evaluacionesCursadaLista) {
				Object[] fila = {evaluacionDTO.getIdEvaluacion(),
								 evaluacionDTO.getIdCursada(),
								 evaluacionDTO.getIdEvaluacionTipo(),
								 evaluacionDTO.getDescripcion(),
								 evaluacionDTO.getTipoParcial(),
								 localDateFormatterFecha(evaluacionDTO.getFecha())};						 
				this.vista.getModelEvaluaciones().addRow(fila);
			}
			// Oculto los id del Objeto
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setWidth(0);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setMinWidth(0);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setMaxWidth(0);			
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(1).setWidth(0);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(1).setMinWidth(0);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(1).setMaxWidth(0);			
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(2).setWidth(0);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(2).setMinWidth(0);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(2).setMaxWidth(0);		
			
			//{"idEvaluacion", "idCursada", "idEvaluacionTipo", "Descripcion", "Tipo Parcial"};
			// Agrego listener para obtener los valores de la fila seleccionada
			this.vista.getTablaEvaluaciones().setSelectionModel(new ListSelectionModelCstm());
			this.vista.getTablaEvaluaciones().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
				try {
					if (this.vista.getTablaEvaluaciones().getSelectedRow() >= 0) {	
						this.vista.getLblEvaluacionSeleccionada().setText("");
						Object idEvaluacion = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 0);
						Object idCursada = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 1);
						Object idEvaluacionTipo = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 2);
						Object descripcion = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 3);
						Object tipoParcial = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 4);
						Object fecha = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 5);
						
						evaluacionActualDTO = new EvaluacionDTO(Long.parseLong(idEvaluacion.toString()), 
																Long.parseLong(idCursada.toString()), 
																Long.parseLong(idEvaluacionTipo.toString()), 
																descripcion.toString(), 
																tipoParcial.toString(), 
																StringToLocalDate(fecha.toString()));
						this.vista.getLblEvaluacionSeleccionada().setText(evaluacionActualDTO.getDescripcion() 
																	    + " - " 
																	    + evaluacionActualDTO.getTipoParcial() 
																	    + System.lineSeparator());	
						this.vista.getLblEvaluacionSeleccionadaFecha().setText(localDateFormatterFecha(evaluacionActualDTO.getFecha()));
						llenarTablaAlumnosInscriptos();
					}
				} catch (Exception ex) {
					System.out.println("Error Tabla Evaluacion: " + ex.getMessage());
				}
			});

			DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
			leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		} else {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Evaluaciones Asignadas para la Cursada seleccionada!",
				    "Evaluaciones",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));
		}
	}

	private void clearComponents() {

		evaluacionesCursadaLista.clear();
		alumnosInscriptosLista.clear();
		this.vista.getLblAlumnoSeleccionado().setText("");
		this.vista.getLblEvaluacionSeleccionada().setText("");	
		this.vista.getTextNota().setText("");
	}
	
	private void clearAfterUpdateNota() {
		alumnoActualDTO = null;
		alumnosInscriptosLista.clear();
		this.vista.getLblAlumnoSeleccionado().setText("");
		this.vista.getTextNota().setText("");
	}

	public void llenarTablaAlumnosInscriptos() {
		
		this.vista.getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAlumnos().setColumnCount(0);
		this.vista.getModelAlumnos().setColumnIdentifiers(this.vista.getNombreColumnasAlumnos());
		
		if (evaluacionActualDTO != null) {
			this.notasEvaluacionActual.clear();
			this.notasEvaluacionActual = modelo.obtenerNotas(evaluacionActualDTO);
		}

		this.alumnosInscriptosLista = modelo.obtenerAlumnosInscriptos(cursadaDTO);
		if (this.alumnosInscriptosLista.size() > 0) {
			for (AlumnoInscriptoDTO alumnoInscriptoDTO : alumnosInscriptosLista) {
				Object[] fila = {alumnoInscriptoDTO.getIdAlumno(),
								 alumnoInscriptoDTO.getIdCursada(),
								 alumnoInscriptoDTO.getNombre(),
								 alumnoInscriptoDTO.getApellido(),
								 alumnoInscriptoDTO.getTelefono(),
								 alumnoInscriptoDTO.getEmail(),
								 localDateTimeToStringFormatter(alumnoInscriptoDTO.getFecha()),
								 "N/A",
								 getNotaAlumno(alumnoInscriptoDTO.getIdAlumno()),
								 getEstadoInscripcionAlumno(alumnoInscriptoDTO.getIdAlumno())};						 
				this.vista.getModelAlumnos().addRow(fila);
			}

			// Oculto los id del Objeto
			this.vista.getTablaAlumnos().getColumnModel().getColumn(0).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(0).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(0).setMaxWidth(0);			
			this.vista.getTablaAlumnos().getColumnModel().getColumn(1).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(1).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(1).setMaxWidth(0);		
			this.vista.getTablaAlumnos().getColumnModel().getColumn(1).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(1).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(1).setMaxWidth(0);		
			this.vista.getTablaAlumnos().getColumnModel().getColumn(4).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(4).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(4).setMaxWidth(0);		
			this.vista.getTablaAlumnos().getColumnModel().getColumn(5).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(5).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(5).setMaxWidth(0);		
			this.vista.getTablaAlumnos().getColumnModel().getColumn(6).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(6).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(6).setMaxWidth(0);		
			this.vista.getTablaAlumnos().getColumnModel().getColumn(7).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(7).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(7).setMaxWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(9).setWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(9).setMinWidth(0);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(9).setMaxWidth(0);
			
			//{"idAlumno", "idCursada", "Nombre", "Apellido", "Telefono", "Email", "Fecha", "Estado", "Nota"};
			// Agrego listener para obtener los valores de la fila seleccionada
			this.vista.getTablaAlumnos().setSelectionModel(new ListSelectionModelCstm());
			this.vista.getTablaAlumnos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
				try {
					if (this.vista.getTablaAlumnos().getSelectedRow() >= 0) {	
						this.vista.getLblAlumnoSeleccionado().setText("");
						Object idAlumno = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 0);
						Object idCursada = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 1);
						Object nombre = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 2);
						Object apellido = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 3);
						Object telefono = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 4);
						Object email = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 5);
						Object fecha = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 6);
						Object estado = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 7);
						Object nota = this.vista.getTablaAlumnos().getValueAt(this.vista.getTablaAlumnos().getSelectedRow(), 8);
						
						this.alumnoActualDTO = new AlumnoInscriptoDTO(Long.parseLong(idAlumno.toString()), 
																	  Long.parseLong(idCursada.toString()), 
																	  nombre.toString(), 
																	  apellido.toString(), 
																	  telefono.toString(), 
																	  email.toString(), 
																	  LocalDateTime.now(), 
																	  Boolean.parseBoolean(estado.toString()));
						this.notaActual = nota.toString();
						this.vista.getTextNota().setText(this.notaActual);
						this.vista.getLblAlumnoSeleccionado().setText(this.alumnoActualDTO.getNombre() + " " + this.alumnoActualDTO.getApellido());
					}
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			});

			DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
			leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			this.vista.getTablaAlumnos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		} else {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Alumnos Inscriptos para la Cursada seleccionada!",
				    "Alumnos Inscriptos",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));
		}
	}
	
	private boolean getEstadoInscripcionAlumno(long idAlumno) {
		for (InscriptoDTO alumnoInscriptoDTO : modelo.obtenerInscriptos()) {
			if (alumnoInscriptoDTO.getIdAlumno() == idAlumno) {
				return alumnoInscriptoDTO.isEstado();
			}
		}
		return false;
	}

	private String getNotaAlumno(long idAlumno) {
		if (notasEvaluacionActual.size() > 0) {
			for (NotaDTO notaDTO : notasEvaluacionActual) {
				if (notaDTO.getIdAlumno() == idAlumno) {
					return notaDTO.getNota();
				}
			}
		}
		return "N/A";
	}

	private String localDateFormatterFecha(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatDateTime = date.format(formatter);
        return formatDateTime;
	}
	
	private String localDateTimeFormatterHora(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatDateTime = dateTime.format(formatter);
        return formatDateTime;
	}
	
	private LocalDate StringToLocalDate(String fecha) {
		
		String date = fecha;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateTime = LocalDate.parse(date, format);
		return dateTime;
	}
	
	private String localDateTimeToStringFormatter(LocalDateTime fecha) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}
	
	private LocalDateTime stringToLocalDateTime(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
		return dateTime;
	}
	
	@SuppressWarnings("serial")
	public class ListSelectionModelCstm extends DefaultListSelectionModel {

	    public ListSelectionModelCstm () {
	        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    }

	    @Override
	    public void clearSelection() {
	    }

	    @Override
	    public void removeSelectionInterval(int index0, int index1) {
	    }

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getBtnAgregarEvaluacion()) {
			if (evaluacionModalPanel != null) {
				evaluacionModalPanel.dispose();
				evaluacionModalControlador = null;
			}			
			evaluacionModalPanel = new EvaluacionModalPanel();
			evaluacionModalControlador = new EvaluacionModalControlador(modelo, evaluacionModalPanel, this);
			evaluacionModalControlador.inicializar();
		} else if (e.getSource() == this.vista.getBtnActualizarNota()) {
			try {
				NotaDTO notaDTO = new NotaDTO(alumnoActualDTO.getIdAlumno(), 
											  evaluacionActualDTO.getIdEvaluacion(), 
											  this.vista.getTextNota().getText().toString());
				if (notaActual.equals("N/A")) {
					//modelo.borrarNota(notaDTO);
					modelo.agregarNota(notaDTO);
				} else {
					modelo.actualizarNota(notaDTO);
				}
				clearAfterUpdateNota();
				llenarTablaAlumnosInscriptos();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
					    "No se pudo actualizar la Nota del Alumno!",
					    "Nota Alumno",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));
			}
		}
		
	}

	/**
	 * @return the cursadaDTO
	 */
	public CursadaDTO getCursadaDTO() {
		return cursadaDTO;
	}

	/**
	 * @return the evaluacionModalPanel
	 */
	public EvaluacionModalPanel getEvaluacionModalPanel() {
		return evaluacionModalPanel;
	}

	/**
	 * @param evaluacionModalPanel the evaluacionModalPanel to set
	 */
	public void setEvaluacionModalPanel(EvaluacionModalPanel evaluacionModalPanel) {
		this.evaluacionModalPanel = evaluacionModalPanel;
	}

	/**
	 * @return the evaluacionModalControlador
	 */
	public EvaluacionModalControlador getEvaluacionModalControlador() {
		return evaluacionModalControlador;
	}

	/**
	 * @param evaluacionModalControlador the evaluacionModalControlador to set
	 */
	public void setEvaluacionModalControlador(EvaluacionModalControlador evaluacionModalControlador) {
		this.evaluacionModalControlador = evaluacionModalControlador;
	}

}
