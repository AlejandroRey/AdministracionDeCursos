package persistencia.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.AlumnoAsistenciaQtyDTO;
import dto.AlumnoInscriptoDTO;
import dto.AsistenciaDTO;
import dto.CursadaDTO;
import dto.FechaCursadaClaseDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnosAsistenciaPanel;

public class AlumnosAsistenciaControlador implements ActionListener {
	
	private AlumnosAsistenciaPanel vista;
	private AdministracionDeCursos modelo;
	
	private List<FechaCursadaClaseDTO> fechaCursadaClaseList;
	private List<AlumnoInscriptoDTO> alumnosInscriptosList;
	private List<AsistenciaDTO> asistenciaAlumnoFechaCursadaList;
	private List<AlumnoAsistenciaQtyDTO> alumnosAsistenciasList;
	
	private CursadaDTO cursadaDTO;
	private FechaCursadaClaseDTO currentFechaCursadaClaseDTO;
	private AsistenciaDTO asistenciaChangeDTO;	

	public AlumnosAsistenciaControlador(AlumnosAsistenciaPanel vista, AdministracionDeCursos modelo, CursadaDTO cursadaDTO) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.cursadaDTO = cursadaDTO;
		
		this.vista.setVisible(false);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		
		this.vista.getRbtnPresente().addActionListener(this);
		this.vista.getRbtnAusente().addActionListener(this);
	}

	public void inicializar() {
		if (getAlumnosInscriptos() && getFechasDeCursada()) {
			this.vista.setVisible(true);
			llenarTablaFechasDeCursada();
		}
	}

	private boolean getFechasDeCursada() {

		fechaCursadaClaseList = modelo.obtenerFechaCursadaClase(cursadaDTO);
		
		this.alumnosInscriptosList = modelo.obtenerAlumnosInscriptos(cursadaDTO);
		if (alumnosInscriptosList.size() == 0) {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Fechas de Asistencia para la Cursada seleccionada!",
				    "Alumnos Inscriptos",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));
			return false;
		}
		return true;
	}

	private boolean getAlumnosInscriptos() {
		
		this.alumnosInscriptosList = modelo.obtenerAlumnosInscriptos(cursadaDTO);
		if (alumnosInscriptosList.size() == 0) {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Alumnos Inscriptos para la Cursada seleccionada!",
				    "Alumnos Inscriptos",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));
			return false;
		}
		return true;
	}	
	
	//https://stackoverflow.com/questions/17585112/calculate-the-subtotal-while-every-time-adding-a-new-row-in-jtable
	public void llenarTablaFechasDeCursada() {
		
		this.vista.getModelFechasDeCursada().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelFechasDeCursada().setColumnCount(0);
		this.vista.getModelFechasDeCursada().setColumnIdentifiers(this.vista.getNombreColumnasFechasDeCursada());
		
		for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechaCursadaClaseList) {
			
			int qtyPresentes = 0;
			int qtyAusentes = 0;
			List<AsistenciaDTO> asistenciaList = modelo.obtenerAsistencia(fechaCursadaClaseDTO);
			if (asistenciaList.size() > 0) {
				for (AsistenciaDTO asistenciaDTO : asistenciaList) {
					if (asistenciaDTO.getTipoAsistencia() == 1) {
						qtyPresentes += 1;
					} else if (asistenciaDTO.getTipoAsistencia() == 0) {
						qtyAusentes += 1;
					}
				}
			}
			
			Object[] fila = { fechaCursadaClaseDTO.getIdFechaCursadaClase(), fechaCursadaClaseDTO.getIdCursada(),
					fechaCursadaClaseDTO.getIdSala(), localDateTimeFormatter(fechaCursadaClaseDTO.getFechaInicio()),
					localDateTimeFormatter(fechaCursadaClaseDTO.getFechaFin()),
					localDateTimeFormatterFecha((fechaCursadaClaseDTO.getFechaInicio())),
					localDateTimeFormatterHora((fechaCursadaClaseDTO.getFechaInicio())),
					localDateTimeFormatterHora(fechaCursadaClaseDTO.getFechaFin()),
				    qtyPresentes,
					qtyAusentes};
			this.vista.getModelFechasDeCursada().addRow(fila);
		}

		// Oculto los id del Objeto
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(1).setMaxWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(2).setMaxWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(3).setWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(3).setMinWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(3).setMaxWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(4).setWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(4).setMinWidth(0);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(4).setMaxWidth(0);

		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblFechasDeCursada().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblFechasDeCursada().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblFechasDeCursada().getSelectedRow() >= 0) {
					Object id = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 0);
					// Object idFechaCursadaClase = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 1);
					// Object idCursada = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 2);
					// Object idSala = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 3);
					Object fechaInicio = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 5);
					// Object fechaFin = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 5);
					currentFechaCursadaClaseDTO = new FechaCursadaClaseDTO(Long.parseLong(id.toString()),	
																						 1, 
																						 1, 
																						 LocalDateTime.now(), 
																						 LocalDateTime.now(), 
																						 0);

					asistenciaAlumnoFechaCursadaList = modelo.obtenerAsistencia(currentFechaCursadaClaseDTO);
					if (asistenciaAlumnoFechaCursadaList.size() > 0) {
						llenarTablaAsistenciaAlumnos();
					} else {
						for (AlumnoInscriptoDTO alumnoInscriptoDTO : alumnosInscriptosList) {
							AsistenciaDTO asistenciaDTO = new AsistenciaDTO(alumnoInscriptoDTO.getIdAlumno(),
																		 	currentFechaCursadaClaseDTO.getIdFechaCursadaClase(), 
																		 	-1, 
																		 	"");
							modelo.agregarAsistencia(asistenciaDTO);
							asistenciaAlumnoFechaCursadaList = modelo.obtenerAsistencia(currentFechaCursadaClaseDTO);
						}
					}
					this.vista.getLblFechaCursadaSeleccionada().setText(fechaInicio.toString());
				}
			} catch (Exception ex) {
				//System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblFechasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

		this.vista.getTblFechasDeCursada().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		for (int column = 0; column < this.vista.getTblFechasDeCursada().getColumnCount(); column++) {
			TableColumn tableColumn = this.vista.getTblFechasDeCursada().getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < this.vista.getTblFechasDeCursada().getRowCount(); row++) {
				TableCellRenderer cellRenderer = this.vista.getTblFechasDeCursada().getCellRenderer(row, column);
				Component c = this.vista.getTblFechasDeCursada().prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + this.vista.getTblFechasDeCursada().getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);
				if (preferredWidth >= maxWidth) {
					preferredWidth = maxWidth;
					break;
				}
			}
			tableColumn.setPreferredWidth(preferredWidth);
		}
	}

	public void llenarTablaAsistenciaAlumnos() {
		
		this.vista.getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAlumnos().setColumnCount(0);
		this.vista.getModelAlumnos().setColumnIdentifiers(this.vista.getNombreColumnas());
		
		checkAlumnosInscriptosList();
		setCountAlumnoAsistenciaQty();
		
		for (AlumnoInscriptoDTO alumnoInscriptoDTO : alumnosInscriptosList) {
			for (AsistenciaDTO alumnoAsistenciaDTO : asistenciaAlumnoFechaCursadaList) {
				if (alumnoInscriptoDTO.getIdAlumno() == alumnoAsistenciaDTO.getIdAlumno()) {
					Object[] fila = {alumnoInscriptoDTO.getIdAlumno(),
							 alumnoAsistenciaDTO.getIdFechaCursadaClase(),
							 alumnoInscriptoDTO.getNombre(), 
							 alumnoInscriptoDTO.getApellido(),
							 alumnoInscriptoDTO.getTelefono(),
							 alumnoInscriptoDTO.getEmail(),
							 localDateTimeFormatterFecha(alumnoInscriptoDTO.getFecha()),
							 getTipoDeAsistencia(alumnoAsistenciaDTO.getTipoAsistencia()),
							 getAlumnoAsistenciaPresenteFechaCursada(alumnoInscriptoDTO.getIdAlumno()),
							 getAlumnoAsistenciaAusenteFechaCursada(alumnoInscriptoDTO.getIdAlumno()),
							 alumnoInscriptoDTO.isEstado()};
					this.vista.getModelAlumnos().addRow(fila);
				}				
			}
		}
		
		// Oculto los id del Objeto
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(1).setMaxWidth(0);		
		this.vista.getTblAlumnos().getColumnModel().getColumn(4).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(4).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(4).setMaxWidth(0);		
		this.vista.getTblAlumnos().getColumnModel().getColumn(5).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(5).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(5).setMaxWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(10).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(10).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(10).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblAlumnos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblAlumnos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblAlumnos().getSelectedRow() >= 0) {					
					Object idAlumno = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 0);
					Object idFechaCursada = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 1);
					Object nombre = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 2);
					Object apellido = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 3);
					Object telefono = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 4);
					Object email = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 5);
					Object fecha = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 6);
					Object presente = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 7);
					Object qtyPresente = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 8);
					Object qtyAusente = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 9);
					Object inscriptoEstado = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 10);
					
					this.vista.getTextIdAlumno().setText(idAlumno.toString());
					this.vista.getTextIdCursada().setText(idFechaCursada.toString());
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextApellido().setText(apellido.toString());
					this.vista.getTextTelefono().setText(telefono.toString());
					this.vista.getTextEmail().setText(email.toString());
					this.vista.getTextFecha().setText(fecha.toString());
					this.vista.getTextPresente().setText(qtyPresente.toString());
					this.vista.getTextAusente().setText(qtyAusente.toString());
					
					int presenteInt = -1;
					if (presente.toString().equals("Sin Asignar")) {
						//System.out.println("SIN ASIGNAR........");
						this.vista.getRbtnGroup().clearSelection();
						presenteInt = -1;
					} else if (presente.toString().equals("Ausente")) {
						this.vista.getRbtnAusente().setSelected(true);
						presenteInt = 0;
					}else if (presente.toString().equals("Presente")) {
						this.vista.getRbtnPresente().setSelected(true);
						presenteInt = 1;
					}
					
					asistenciaChangeDTO =  new AsistenciaDTO(Long.parseLong(idAlumno.toString()), 
							                             Long.parseLong(idFechaCursada.toString()), 
							                             presenteInt, 
							                             "");
					//System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
					
					boolean status = Boolean.parseBoolean(inscriptoEstado.toString());
					if (status == false) {
						this.vista.getPanelAlumnoDTO().setVisible(false);
					}else {
						this.vista.getPanelAlumnoDTO().setVisible(true);
					}
					
				}
			} catch (Exception ex) {
				//System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	private int getAlumnoAsistenciaAusenteFechaCursada(long idAlumno) {
		int qty = 0;
		for (AlumnoAsistenciaQtyDTO alumnoAsistenciaQtyDTO : alumnosAsistenciasList) {
			//System.out.println("IDALUMNO"+alumnoAsistenciaQtyDTO);
			if (alumnoAsistenciaQtyDTO.getIdAlumno() == idAlumno) {
				qty = alumnoAsistenciaQtyDTO.getAusente();
			}else if (alumnoAsistenciaQtyDTO.getIdAlumno() == 0) {
				this.vista.getTextAusenteTotal().setText(Integer.toString(alumnoAsistenciaQtyDTO.getAusente()));
			}
		}
		return qty;
	}

	private int getAlumnoAsistenciaPresenteFechaCursada(long idAlumno) {
		int qty = 0;
		for (AlumnoAsistenciaQtyDTO alumnoAsistenciaQtyDTO : alumnosAsistenciasList) {
			//System.out.println("IDALUMNO"+alumnoAsistenciaQtyDTO);
			if (alumnoAsistenciaQtyDTO.getIdAlumno() == idAlumno) {
				qty = alumnoAsistenciaQtyDTO.getPresente();
			} else if (alumnoAsistenciaQtyDTO.getIdAlumno() == 0) {
				this.vista.getTextPresenteTotal().setText(Integer.toString(alumnoAsistenciaQtyDTO.getPresente()));
			}
		}
		return qty;
	}

	private void checkAlumnosInscriptosList() {

		if (alumnosInscriptosList.size() > asistenciaAlumnoFechaCursadaList.size()) {
			for (AlumnoInscriptoDTO alumnoInscriptoDTO : alumnosInscriptosList) {
				int contador = 1;
				for (AsistenciaDTO asistenciaDTO : asistenciaAlumnoFechaCursadaList) {
					if (asistenciaDTO.getIdAlumno()==alumnoInscriptoDTO.getIdAlumno()) {
						break;
					}
					if (contador == asistenciaAlumnoFechaCursadaList.size()) {
						AsistenciaDTO newAsistenciaDTO = new AsistenciaDTO(alumnoInscriptoDTO.getIdAlumno(), 
																		   asistenciaDTO.getIdFechaCursadaClase(), 
																		   -1, 
																		   "");
						modelo.agregarAsistencia(newAsistenciaDTO);
					}
					contador += 1;
				}
			}
		}		
	}

	private String getTipoDeAsistencia(int tipoAsistencia) {
		if (tipoAsistencia == -1) {
			return "Sin Asignar";
		} else if (tipoAsistencia == 0) {
			return "Ausente";
		} else if (tipoAsistencia == 1) {
			return "Presente";
		}
		return "Sin Asignar";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getRbtnPresente()) {
			//System.out.println("PRESENTE");
			asistenciaChangeDTO.setTipoAsistencia(1);
			modelo.actualizarAsistencia(asistenciaChangeDTO);
			clearTextInputsBox();
			asistenciaAlumnoFechaCursadaList.clear();
			asistenciaAlumnoFechaCursadaList = modelo.obtenerAsistencia(currentFechaCursadaClaseDTO);
			llenarTablaFechasDeCursada();
			llenarTablaAsistenciaAlumnos();
			setCountAlumnoAsistenciaQty();
		} else if (e.getSource() == this.vista.getRbtnAusente()) {
			//System.out.println("AUSENTE");
			asistenciaChangeDTO.setTipoAsistencia(0);
			modelo.actualizarAsistencia(asistenciaChangeDTO);
			clearTextInputsBox();
			asistenciaAlumnoFechaCursadaList.clear();
			asistenciaAlumnoFechaCursadaList = modelo.obtenerAsistencia(currentFechaCursadaClaseDTO);
			llenarTablaFechasDeCursada();
			llenarTablaAsistenciaAlumnos();
			setCountAlumnoAsistenciaQty();
		}
	}
	
	private String localDateTimeFormatter(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = dateTime.format(formatter);
        return formatDateTime;
	}
	
	private String localDateTimeFormatterFecha(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatDateTime = dateTime.format(formatter);
        return formatDateTime;
	}
	
	private String localDateTimeFormatterHora(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatDateTime = dateTime.format(formatter);
        return formatDateTime;
	}
	
	private void setCountAlumnoAsistenciaQty() {
		
		if (fechaCursadaClaseList.size() > 0 && asistenciaAlumnoFechaCursadaList.size() > 0) {
			alumnosAsistenciasList = modelo.obtenerAlumnosAsistenciasQty(cursadaDTO);
		}
	}
	
	private void clearTextInputsBox() {
		this.vista.getTextIdAlumno().setText("");
		this.vista.getTextIdCursada().setText("");
		this.vista.getTextNombre().setText("");
		this.vista.getTextApellido().setText("");
		this.vista.getTextTelefono().setText("");
		this.vista.getTextEmail().setText("");
		this.vista.getTextFecha().setText("");
		this.vista.getTextPresente().setText("");
		this.vista.getTextAusente().setText("");
		this.vista.getRbtnGroup().clearSelection();
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
	
}
