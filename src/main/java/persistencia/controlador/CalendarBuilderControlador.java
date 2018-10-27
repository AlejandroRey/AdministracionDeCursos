package persistencia.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CursadaDTO;
import dto.DiaCursadaClaseDTO;
import dto.DiasDTO;
import dto.EstadoSalaDTO;
import dto.FechaCursadaClaseDTO;
import dto.FeriadoDTO;
import dto.SalaDTO;
import dto.SalaDisponibleDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CalendarioBuilderPanel;

public class CalendarBuilderControlador implements ActionListener {
	
	private CursadaDTO cursadaDTO;
	private AdministracionDeCursos modelo;
	private CalendarioBuilderPanel vista;
	
	private List<DiaCursadaClaseDTO> diasDeCursadaList;
	private DiaCursadaClaseDTO diaDeCursadaDTO;
	
	private List<FechaCursadaClaseDTO> fechasDeCursadaList;
	private List<FeriadoDTO> feriadosList;
	
	private List<SalaDTO> salasList;
	private List<SalaDisponibleDTO> salasDisponiblesList;	

	public CalendarBuilderControlador(CursadaDTO cursadaDTO, CalendarioBuilderPanel vista, AdministracionDeCursos modelo) {
		super();
		this.cursadaDTO = cursadaDTO;
		this.vista = vista;
		this.modelo = modelo;

		this.fechasDeCursadaList = new ArrayList<FechaCursadaClaseDTO>();
		this.salasDisponiblesList = new ArrayList<SalaDisponibleDTO>();
		
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnGenerarHorario().addActionListener(this);
		this.vista.getBtnAsignarSala().addActionListener(this);
		this.vista.getBtnGuardarCambios().addActionListener(this);
		
		this.vista.getBtnGuardarCambios().setVisible(false);
		
		this.salasList = modelo.obtenerSalas();
		this.feriadosList = modelo.obtenerFeriados(cursadaDTO.getFechaInicioCursada().getYear());
		
		this.vista.getTextHoraInicio().setText("00:00");
		this.vista.getTextHoraFin().setText("00:00");
	}

	public void inicializar() {
		this.vista.getTextFechaInicio().setText(stringDateFormatter(this.cursadaDTO.getFechaInicioCursada().toLocalDate()));
		this.vista.getTextCantidadDeDias().setText(String.valueOf(this.cursadaDTO.getDiasDeClase()));
		
		if (getDiasDeCursada()) {
			llenarTablaDiasDeCursada();
		}
		if (getFechaDeCursada()) {
			llenarTablaFechasDeCursada();
		}
	}

	private boolean getDiasDeCursada() {
		diasDeCursadaList = modelo.obtenerDiaCursadaClase(cursadaDTO);

		if (diasDeCursadaList.size() > 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Dias de Clases para la Cursada seleccionada!",
				    "Dias de Cursadas",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));
			return false;
		}
	}
	
	private boolean getFechaDeCursada() {
		List<FechaCursadaClaseDTO> fechaCursadasClases = modelo.obtenerFechaCursadaClase(cursadaDTO);

		if (fechaCursadasClases.size() > 0) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechaCursadasClases) {
				fechasDeCursadaList.add(fechaCursadaClaseDTO);
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Fechas de Clases para la Cursada seleccionada!",
				    "Fechas de Cursadas",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));
			return false;
		}
	}
	
	private void llenarTablaDiasDeCursada() {
		this.vista.getModelDiasDeCursada().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelDiasDeCursada().setColumnCount(0);
		this.vista.getModelDiasDeCursada().setColumnIdentifiers(this.vista.getNombreColumnasDiasDeCursada());

		 
		DefaultComboBoxModel<SalaDTO> comboModel = new DefaultComboBoxModel<SalaDTO>();
		for (SalaDTO salaDTO : salasList) {
			comboModel.addElement(salaDTO);
		}
		JComboBox<SalaDTO> combo = new JComboBox<SalaDTO>();
		combo.setModel(comboModel);
		TableColumn col = this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(5);
		col.setCellEditor(new DefaultCellEditor(combo));
		combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    SalaDTO s = (SalaDTO) e.getItem();
                    diaDeCursadaDTO.setIdSala(s.getIdSala());
                    modelo.actualizarDiaCursadaClase(diaDeCursadaDTO);
                }
            }
        });		
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Haga Click aqui para elegir SALA!");
		col.setCellRenderer(renderer);
		
		for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeCursadaList) {
			Object[] fila = {diaCursadaClaseDTO.getIdCursada(),
							 diaCursadaClaseDTO.getIdDia(),
							 diaCursadaClaseDTO.getNombreDia(),
							 diaCursadaClaseDTO.getHoraInicio(),
							 diaCursadaClaseDTO.getHoraFin(),
							 getSalaDTO(diaCursadaClaseDTO.getIdSala())};
			this.vista.getModelDiasDeCursada().addRow(fila);
		}
		
		// Oculto los id del Objeto
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(1).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTablaDiasDeCursada().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTablaDiasDeCursada().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTablaDiasDeCursada().getSelectedRow() >= 0) {	
					Object idCursada = this.vista.getTablaDiasDeCursada().getValueAt(this.vista.getTablaDiasDeCursada().getSelectedRow(), 0);
					Object numeroDia = this.vista.getTablaDiasDeCursada().getValueAt(this.vista.getTablaDiasDeCursada().getSelectedRow(), 1);
					Object nombreDia = this.vista.getTablaDiasDeCursada().getValueAt(this.vista.getTablaDiasDeCursada().getSelectedRow(), 2);
					Object horaInicio = this.vista.getTablaDiasDeCursada().getValueAt(this.vista.getTablaDiasDeCursada().getSelectedRow(), 3);
					Object horaFin = this.vista.getTablaDiasDeCursada().getValueAt(this.vista.getTablaDiasDeCursada().getSelectedRow(), 4);
					Object sala = this.vista.getTablaDiasDeCursada().getValueAt(this.vista.getTablaDiasDeCursada().getSelectedRow(), 5);
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");	
					SalaDTO salaDTO = (SalaDTO) sala;
					//System.out.println("SalaDTO: "+salaDTO.getIdSala());
					diaDeCursadaDTO = new DiaCursadaClaseDTO(Long.parseLong(idCursada.toString()),
																Integer.parseInt(numeroDia.toString()),
																nombreDia.toString(), 
																LocalTime.parse(horaInicio.toString(), formatter),
																LocalTime.parse(horaFin.toString(), formatter),
																salaDTO.getIdSala());
					//System.out.println(diaDeCursadaDTO.toString());
					this.vista.revalidate();
					this.vista.repaint();
				}
			} catch (Exception ex) {
				//System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);		
	}
	
	private SalaDTO getSalaDTO(long idSala) {
		for (SalaDTO salaDTO : salasList) {
			if (salaDTO.getIdSala() == idSala) {
				return salaDTO;
			}
		}
		return null;
	}

	private void llenarTablaFechasDeCursada() {
		this.vista.getModelFechasDeCursada().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelFechasDeCursada().setColumnCount(0);
		this.vista.getModelFechasDeCursada().setColumnIdentifiers(this.vista.getNombreColumnasFechasDeCursada());

		//this.fechasDeClasesCursadaList = new ArrayList<FechaCursadaClaseDTO>(mapFechaDeClasesCursada.values());
		if (this.fechasDeCursadaList.size() > 0) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeCursadaList) {
				String diaDeLaSemana = getDiaDelaSemana(fechaCursadaClaseDTO.getFechaInicio().toLocalDate());		
				Object[] fila = {fechaCursadaClaseDTO.getIdFechaCursadaClase(),
								 fechaCursadaClaseDTO.getIdCursada(), 
								 fechaCursadaClaseDTO.getIdSala(),
								 (diaDeLaSemana.substring(0,1).toUpperCase() + diaDeLaSemana.substring(1).toLowerCase()),
								 localDateTimeFormatterFecha(fechaCursadaClaseDTO.getFechaInicio()),
								 localDateTimeFormatterHora(fechaCursadaClaseDTO.getFechaInicio()),
								 localDateTimeFormatterHora(fechaCursadaClaseDTO.getFechaFin()),
								 getNombreSala(fechaCursadaClaseDTO.getIdSala()),
								 localDateTimeFormatter(fechaCursadaClaseDTO.getFechaInicio()),
								 localDateTimeFormatter(fechaCursadaClaseDTO.getFechaFin()),
								 getEstadoSalaDTO(fechaCursadaClaseDTO.getEstadoSala()).getEstadoSala()};
				this.vista.getModelFechasDeCursada().addRow(fila);
			}
		}

		// Oculto los id del Objeto
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(1).setMaxWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(2).setMaxWidth(0);		
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(8).setWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(8).setMinWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(8).setMaxWidth(0);		
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(9).setWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(9).setMinWidth(0);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(9).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTablaFechasDeCursada().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTablaFechasDeCursada().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTablaFechasDeCursada().getSelectedRow() >= 0) {					
					Object idFechaCursadaClase = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 0);
					//Object idCursada = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 1);
					Object idSala = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 2);
					Object dia = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 3);
					Object fechaInicio = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 8);
					Object fechaFin = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 9);
					Object sala = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 7);

					this.vista.getTextSalaIdFechaCursada().setText(idFechaCursadaClase.toString());
					this.vista.getTextSalaId().setText(idSala.toString());
					this.vista.getTextSalaDia().setText(dia.toString());
					this.vista.getTextSalaFechaInicio().setText(fechaInicio.toString());
					this.vista.getTextSalaFechaFin().setText(fechaFin.toString());
					this.vista.getTextSalaNombre().setText(sala.toString());
					
					llenarTablaSalasDisponibles();
				}
			} catch (Exception ex) {
				//System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		
		this.vista.getTablaFechasDeCursada().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		for (int column = 0; column < this.vista.getTablaFechasDeCursada().getColumnCount(); column++) {
			TableColumn tableColumn = this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < this.vista.getTablaFechasDeCursada().getRowCount(); row++) {
				TableCellRenderer cellRenderer = this.vista.getTablaFechasDeCursada().getCellRenderer(row, column);
				Component c = this.vista.getTablaFechasDeCursada().prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + this.vista.getTablaFechasDeCursada().getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);

				// We've exceeded the maximum width, no need to check other rows

				if (preferredWidth >= maxWidth) {
					preferredWidth = maxWidth;
					break;
				}
			}

			tableColumn.setPreferredWidth(preferredWidth);
		}		
	}

	private void llenarTablaSalasDisponibles() {
		this.vista.getModelSalas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelSalas().setColumnCount(0);
		this.vista.getModelSalas().setColumnIdentifiers(this.vista.getNombreColumnasSalas());
		this.salasDisponiblesList.clear();

		for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeCursadaList) {
			if (fechaCursadaClaseDTO.getIdFechaCursadaClase() == Long.parseLong(this.vista.getTextSalaIdFechaCursada().getText().toString())) {
				for (SalaDTO salaDTO : salasList) {
					for (SalaDisponibleDTO salaDisponibleDTO : modelo.obtenerSalaDisponible(fechaCursadaClaseDTO, salaDTO)) {						
						if (salaDisponibleDTO.getDispDesde().isBefore(fechaCursadaClaseDTO.getFechaInicio())
								&& fechaCursadaClaseDTO.getFechaFin().isBefore(salaDisponibleDTO.getDispHasta())) {
							this.salasDisponiblesList.add(salaDisponibleDTO);
						}						
					}
				}
			}
		}
 
		for (SalaDisponibleDTO salaDisponibleDTO : salasDisponiblesList) {
			if (salaDisponibleDTO.getIdSala() != 1) {
				Object[] fila = {salaDisponibleDTO.getIdSala(),
						 getNombreSala(salaDisponibleDTO.getIdSala()),
						 salaDisponibleDTO.getDispDesde(),
						 salaDisponibleDTO.getDispHasta(),
						 salaDisponibleDTO.getEstado()};
						 this.vista.getModelSalas().addRow(fila);
			}
		}
		// Oculto los id del Objeto
		this.vista.getTablaSalas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTablaSalas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTablaSalas().getColumnModel().getColumn(0).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTablaSalas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTablaSalas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTablaSalas().getSelectedRow() >= 0) {
					Object idSala = this.vista.getTablaSalas().getValueAt(this.vista.getTablaSalas().getSelectedRow(), 0);
					Object nombreSala = this.vista.getTablaSalas().getValueAt(this.vista.getTablaSalas().getSelectedRow(), 1);

					this.vista.getTextSalaId().setText(idSala.toString());
					this.vista.getTextSalaNombre().setText(nombreSala.toString());
				}
			} catch (Exception ex) {
				//System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaSalas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private String getNombreSala(long idSala) {
		for (SalaDTO salaDTO : salasList) {
			if (salaDTO.getIdSala() == idSala) {
				return salaDTO.getNombre();
			}
		}
		return null;
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getBtnSeleccionar()) {
			if (!this.vista.getTextHoraInicio().getText().equals(null) && this.vista.getTextHoraFin() != null) {
				DiasDTO diaSeleccionado = (DiasDTO) this.vista.getCbxDias().getSelectedItem();
				diaDeCursadaDTO = new DiaCursadaClaseDTO(cursadaDTO.getIdCursada(), 
															  diaSeleccionado.getNumeroDia(), 
															  diaSeleccionado.getNombreDia(), 
															  this.vista.getTextHoraInicio().getTime(), 
															  this.vista.getTextHoraFin().getTime(),
															  1);
	
				modelo.agregarDiaCursadaClase(diaDeCursadaDTO);
				
				diasDeCursadaList.clear();
				diasDeCursadaList = modelo.obtenerDiaCursadaClase(cursadaDTO);
				llenarTablaDiasDeCursada();
			}			
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			if (diaDeCursadaDTO != null) {
				modelo.borrarDiaCursadaClase(diaDeCursadaDTO);				
				diaDeCursadaDTO = null;
				
				diasDeCursadaList.clear();
				diasDeCursadaList = modelo.obtenerDiaCursadaClase(cursadaDTO);
				llenarTablaDiasDeCursada();
			}else {
				JOptionPane.showMessageDialog(null,
					    "No se encontro Dia de Clase para eliminar!",
					    "Dia de Cursada",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));
			}
		} else if (e.getSource() == this.vista.getBtnGenerarHorario()) {
			
			buildCalendarioFechaDeCursada();
			
		} else if (e.getSource() == this.vista.getBtnAsignarSala()) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeCursadaList) {
				long idFechacursada = Long.parseLong(this.vista.getTextSalaIdFechaCursada().getText().toString());
				long idSala = Long.parseLong(this.vista.getTextSalaId().getText().toString());
				if (idFechacursada == fechaCursadaClaseDTO.getIdFechaCursadaClase()) {
					fechaCursadaClaseDTO.setIdSala(idSala);
					modelo.actualizarFechaCursadaClase(fechaCursadaClaseDTO);
				}
			}
			llenarTablaFechasDeCursada();
		} else if (e.getSource() == this.vista.getBtnGuardarCambios()) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeCursadaList) {
				modelo.actualizarFechaCursadaClase(fechaCursadaClaseDTO);
			}
		}		
	}
	
	private void buildCalendarioFechaDeCursada() {

		diasDeCursadaList.clear();
		diasDeCursadaList = modelo.obtenerDiaCursadaClase(cursadaDTO);
		llenarTablaDiasDeCursada();
		
		if (diasDeCursadaList.size()>0) {

			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeCursadaList) {
				modelo.borrarFechaCursadaClase(fechaCursadaClaseDTO);
			}				
			fechasDeCursadaList.clear();
			
			LocalDate date = StringToLocalDate(this.vista.getTextFechaInicio().getText());
			int incDia= 0;
			int contador =Integer.parseInt(this.vista.getTextCantidadDeDias().getText());
			do {
				String nombreDia = getDiaDelaSemana(date.plusDays(incDia));
				if (!isFeriado(date.plusDays(incDia))) {
					for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeCursadaList) {
						
						if (contador > 0 && diaCursadaClaseDTO.getNombreDia().toLowerCase().equals(nombreDia)) {
							LocalDateTime fechaInicio = LocalDateTime.of(date.plusDays(incDia), diaCursadaClaseDTO.getHoraInicio());
							LocalDateTime fechaFin = LocalDateTime.of(date.plusDays(incDia), diaCursadaClaseDTO.getHoraFin());
							FechaCursadaClaseDTO fechaSeleccionada = new FechaCursadaClaseDTO(contador, 
																							  cursadaDTO.getIdCursada(), 
																							  diaCursadaClaseDTO.getIdSala(), 
																							  fechaInicio, 
																							  fechaFin,
																							  0);							
							fechasDeCursadaList.add(fechaSeleccionada);
							contador -= 1;
						}
					}
				}				
				incDia += 1;				
			} while (contador > 0);
			
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeCursadaList) {	
				for (SalaDTO salaDTO : salasList) {
					for (SalaDisponibleDTO salaDisponibleDTO : modelo.obtenerSalaDisponible(fechaCursadaClaseDTO, salaDTO)) {						
						if (salaDisponibleDTO.getDispDesde().isEqual((fechaCursadaClaseDTO.getFechaInicio())) 
							&& fechaCursadaClaseDTO.getFechaFin().isEqual(salaDisponibleDTO.getDispHasta())) {
							salasDisponiblesList.add(salaDisponibleDTO);
						} else if (salaDisponibleDTO.getDispDesde().isBefore(fechaCursadaClaseDTO.getFechaInicio()) && 
								   fechaCursadaClaseDTO.getFechaFin().isBefore(salaDisponibleDTO.getDispHasta())) {
							salasDisponiblesList.add(salaDisponibleDTO);								
						} else if (salaDisponibleDTO.getDispDesde().isEqual((fechaCursadaClaseDTO.getFechaInicio())) && 
								   fechaCursadaClaseDTO.getFechaFin().isBefore(salaDisponibleDTO.getDispHasta())) {
							salasDisponiblesList.add(salaDisponibleDTO);
						} else if (salaDisponibleDTO.getDispDesde().isBefore(fechaCursadaClaseDTO.getFechaInicio()) &&
								   fechaCursadaClaseDTO.getFechaFin().isEqual(salaDisponibleDTO.getDispHasta())) {
							salasDisponiblesList.add(salaDisponibleDTO);
						}					
					}
				}
				
				
				int size = salasDisponiblesList.size();
				int loopValue = 0;
				for (SalaDisponibleDTO salaDTO : salasDisponiblesList) {
					System.out.println("SALAALALALALALAL----->>>>>>>>>>: "+salaDTO);
				}
				for (SalaDisponibleDTO salaDisponibleDTO : salasDisponiblesList) {
					System.out.println("Loop: Estado SALA " + salaDisponibleDTO.getEstadoSala());
					if (salaDisponibleDTO.getEstadoSala() != 1 
						&& salaDisponibleDTO.getIdSala() == fechaCursadaClaseDTO.getIdSala()) {
						if (salaDisponibleDTO.getEstadoSala() == 3) {
							fechaCursadaClaseDTO.setEstadoSala(3);
						} else if (salaDisponibleDTO.getEstadoSala() == 2) {
							fechaCursadaClaseDTO.setEstadoSala(3);
						} else if (salaDisponibleDTO.getEstadoSala() == 0) {
							fechaCursadaClaseDTO.setEstadoSala(2);
						}
						System.out.println("BREAK " + salaDisponibleDTO.getEstado() + "" + getSalaDTO(salaDisponibleDTO.getIdSala()));
						break;
					}
					loopValue += 1;
				}
				salasDisponiblesList.clear();
				if (size > 0 && loopValue == size) {
					fechaCursadaClaseDTO.setIdSala(1);
				}
				modelo.agregarFechaCursadaClase(fechaCursadaClaseDTO);
			}
			
			
			fechasDeCursadaList.clear();
			fechasDeCursadaList = modelo.obtenerFechaCursadaClase(cursadaDTO);				
			llenarTablaFechasDeCursada();
			
			JOptionPane.showMessageDialog(null,
				    "Se actualizaron las Fechas de Cursadas  las asignaciones de Salas!",
				    "Fecha de Cursada",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/information_64.png"));
			
		} else {
			JOptionPane.showMessageDialog(null,
				    "Seleccione Dias de Cursada!",
				    "Dias de Cursada",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("imagenes/warning_64.png"));	
		}
	}

	private boolean isFeriado(LocalDate date) {
		for (FeriadoDTO feriadoDTO : feriadosList) {
			if (feriadoDTO.getFeriado().equals(date)) {
				return true;
			}
		}
		return false;
	}

	private EstadoSalaDTO getEstadoSalaDTO(int idEstadoSala) {
		switch (idEstadoSala) {			
		case 0:
			return EstadoSalaDTO.LIBRE;
		case 1:
			return EstadoSalaDTO.OCUPADA;
		case 2:
			return EstadoSalaDTO.PRIORIDAD;
		case 3:
			return EstadoSalaDTO.CONDICIONAL;
		default:
			return null;
		}		
	}
	
	private String getDiaDelaSemana(LocalDate date) {
	    Locale spanishLocale = new Locale("es", "ES");
	    String dateInSpanish = date.format(DateTimeFormatter.ofPattern("EEEE",spanishLocale));
	    ////System.out.println("En Espanol: "+dateInSpanish);
	    return dateInSpanish;
	}
	
	private String stringDateFormatter(LocalDate dateTime) {		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatDateTime = dateTime.format(formatter);
        return formatDateTime;
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
	
	private LocalDate StringToLocalDate(String fecha) {
		
		String date = fecha;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTime = LocalDate.parse(date, format);
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
	
}

