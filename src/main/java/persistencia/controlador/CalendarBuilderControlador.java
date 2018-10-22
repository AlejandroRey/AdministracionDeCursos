package persistencia.controlador;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CursadaDTO;
import dto.DiaCursadaClaseDTO;
import dto.DiasDTO;
import dto.FechaCursadaClaseDTO;
import dto.SalaDTO;
import dto.SalaDisponibleDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.SalaABMControlador.ListSelectionModelCstm;
import presentacion.vista.CalendarioBuilderPanel;

public class CalendarBuilderControlador implements ActionListener {
	
	private CursadaDTO cursadaDTO;
	private AdministracionDeCursos modelo;
	private CalendarioBuilderPanel vista;
	
	private Map<Integer, DiaCursadaClaseDTO> mapDiasDeClaseCursada;
	private List<DiaCursadaClaseDTO> diasDeClaseCursadaList;
	private DiaCursadaClaseDTO diaDeClaseCursadaDTO;
	
	//private Map<Integer, FechaCursadaClaseDTO> mapFechaDeClasesCursada;
	private List<FechaCursadaClaseDTO> fechasDeClasesCursadaList;
	private FechaCursadaClaseDTO fechaCursadaClaseDTO;
	private List<SalaDisponibleDTO> salasDisponiblesList;
	private List<SalaDTO> salasList;
	

	public CalendarBuilderControlador(CursadaDTO cursadaDTO, CalendarioBuilderPanel vista, AdministracionDeCursos modelo) {
		super();
		this.cursadaDTO = cursadaDTO;
		this.vista = vista;
		this.modelo = modelo;

		this.mapDiasDeClaseCursada = new HashMap<Integer, DiaCursadaClaseDTO>();
		this.fechasDeClasesCursadaList = new ArrayList<FechaCursadaClaseDTO>();
		this.salasDisponiblesList = new ArrayList<SalaDisponibleDTO>();
		
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnGenerarHorario().addActionListener(this);
		this.vista.getBtnAsignarSala().addActionListener(this);
		this.vista.getBtnGuardarCambios().addActionListener(this);
		
		this.salasList = modelo.obtenerSalas();
		for (SalaDTO salaDTO : salasList) {
			System.out.println("Sala: "+salaDTO.toString());
		}
		
		
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
		List<DiaCursadaClaseDTO> diasCursadasClasesList = modelo.obtenerDiaCursadaClase(cursadaDTO);

		if (diasCursadasClasesList.size() > 0) {
			for (DiaCursadaClaseDTO diaCursadaClaseDTO : modelo.obtenerDiaCursadaClase(cursadaDTO)) {
				mapDiasDeClaseCursada.put(diaCursadaClaseDTO.getIdDia(), diaCursadaClaseDTO);
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
				    "No se encontraron Dias de Clases para la Cursada seleccionada!",
				    "Dias de Cursadas",
				    JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	private boolean getFechaDeCursada() {
		List<FechaCursadaClaseDTO> fechaCursadasClases = modelo.obtenerFechaCursadaClase(cursadaDTO);

		if (fechaCursadasClases.size() > 0) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechaCursadasClases) {
				fechasDeClasesCursadaList.add(fechaCursadaClaseDTO);
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
		//clearTextBoxPanelInscriptos();

		diasDeClaseCursadaList = new ArrayList<DiaCursadaClaseDTO>(mapDiasDeClaseCursada.values());
		for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeClaseCursadaList) {
			Object[] fila = {diaCursadaClaseDTO.getIdCursada(),
							 diaCursadaClaseDTO.getIdDia(),
							 diaCursadaClaseDTO.getNombreDia(),
							 diaCursadaClaseDTO.getHoraInicio(),
							 diaCursadaClaseDTO.getHoraFin()};
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
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");					
					diaDeClaseCursadaDTO = new DiaCursadaClaseDTO(Long.parseLong(idCursada.toString()),
																Integer.parseInt(numeroDia.toString()),
																nombreDia.toString(), 
																LocalTime.parse(horaInicio.toString(), formatter),
																LocalTime.parse(horaFin.toString(), formatter));
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaDiasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);		
	}
	
	private void llenarTablaFechasDeCursada() {
		this.vista.getModelFechasDeCursada().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelFechasDeCursada().setColumnCount(0);
		this.vista.getModelFechasDeCursada().setColumnIdentifiers(this.vista.getNombreColumnasFechasDeCursada());

		//this.fechasDeClasesCursadaList = new ArrayList<FechaCursadaClaseDTO>(mapFechaDeClasesCursada.values());
		if (this.fechasDeClasesCursadaList.size() > 0) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeClasesCursadaList) {
				String diaDeLaSemana = getDiaDelaSemana(fechaCursadaClaseDTO.getFechaInicio().toLocalDate());		
				Object[] fila = {fechaCursadaClaseDTO.getIdFechaCursadaClase(),
								 fechaCursadaClaseDTO.getIdCursada(), 
								 fechaCursadaClaseDTO.getIdSala(),
								 (diaDeLaSemana.substring(0,1).toUpperCase() + diaDeLaSemana.substring(1).toLowerCase()),
								 localDateTimeFormatter(fechaCursadaClaseDTO.getFechaInicio()),
								 localDateTimeFormatter(fechaCursadaClaseDTO.getFechaFin()),
								 getNombreSala(fechaCursadaClaseDTO.getIdSala())};
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
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTablaFechasDeCursada().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTablaFechasDeCursada().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTablaFechasDeCursada().getSelectedRow() >= 0) {					
					Object idFechaCursadaClase = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 0);
					//Object idCursada = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 1);
					Object idSala = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 2);
					Object dia = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 3);
					Object fechaInicio = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 4);
					Object fechaFin = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 5);
					Object sala = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 6);

					this.vista.getTextSalaIdFechaCursada().setText(idFechaCursadaClase.toString());
					this.vista.getTextSalaId().setText(idSala.toString());
					this.vista.getTextSalaDia().setText(dia.toString());
					this.vista.getTextSalaFechaInicio().setText(fechaInicio.toString());
					this.vista.getTextSalaFechaFin().setText(fechaFin.toString());
					this.vista.getTextSalaNombre().setText(sala.toString());
					
					llenarTablaSalasDisponibles();
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private void llenarTablaSalasDisponibles() {
		this.vista.getModelSalas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelSalas().setColumnCount(0);
		this.vista.getModelSalas().setColumnIdentifiers(this.vista.getNombreColumnasSalas());
		this.salasDisponiblesList.clear();
		
		System.out.println("idFechaCursada: " + this.vista.getTextSalaIdFechaCursada().getText().toString());
		
		for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeClasesCursadaList) {
			System.out.println(fechaCursadaClaseDTO.toString());
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
				System.out.println("Error: " + ex.getMessage());
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
				System.out.println("Dia Seleccionado: " + this.vista.getCbxDias().getSelectedItem().toString());
				DiasDTO diaSeleccionado = (DiasDTO) this.vista.getCbxDias().getSelectedItem();
				DiaCursadaClaseDTO d = new DiaCursadaClaseDTO(cursadaDTO.getIdCursada(), 
															  diaSeleccionado.getNumeroDia(), 
															  diaSeleccionado.getNombreDia(), 
															  this.vista.getTextHoraInicio().getTime(), 
															  this.vista.getTextHoraFin().getTime());
						
				mapDiasDeClaseCursada.put(diaSeleccionado.getNumeroDia(), d);	
				llenarTablaDiasDeCursada();
			}			
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			if (diaDeClaseCursadaDTO != null) {
				mapDiasDeClaseCursada.remove(diaDeClaseCursadaDTO.getIdDia());
				diaDeClaseCursadaDTO = null;
				llenarTablaDiasDeCursada();
			}else {
				System.out.println("NADA PARA ELIMINAR");
			}
		} else if (e.getSource() == this.vista.getBtnGenerarHorario()) {
			if (diasDeClaseCursadaList.size()>0) {
				fechasDeClasesCursadaList.clear();
				LocalDate date = StringToLocalDate(this.vista.getTextFechaInicio().getText());
				int incDia= 0;
				int contador =Integer.parseInt(this.vista.getTextCantidadDeDias().getText());
				do {				
					for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeClaseCursadaList) {
						String nombreDia = getDiaDelaSemana(date.plusDays(incDia));
						if (diaCursadaClaseDTO.getNombreDia().toLowerCase().equals(nombreDia)) {
							LocalDateTime fechaInicio = LocalDateTime.of(date.plusDays(incDia), diaCursadaClaseDTO.getHoraInicio());
							LocalDateTime fechaFin = LocalDateTime.of(date.plusDays(incDia), diaCursadaClaseDTO.getHoraFin());
							FechaCursadaClaseDTO fechaSeleccionada = new FechaCursadaClaseDTO(contador, 
																							  cursadaDTO.getIdCursada(), 
																							  salasList.get(0).getIdSala(), 
																							  fechaInicio, 
																							  fechaFin);							
							fechasDeClasesCursadaList.add(fechaSeleccionada);
							contador -= 1;
						}
					}				
					incDia += 1;				
				} while (contador > 0);
				llenarTablaFechasDeCursada();				
				
				modelo.borrarDiaCursadaClase(cursadaDTO);
				for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeClaseCursadaList) {
					modelo.agregarDiaCursadaClase(diaCursadaClaseDTO);
				}	
			} else {
				JOptionPane.showMessageDialog(null,
					    "Seleccione Dias de Cursada!",
					    "Dias de Cursada",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));	
			}
		} else if (e.getSource() == this.vista.getBtnAsignarSala()) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeClasesCursadaList) {
				long idFechacursada = Long.parseLong(this.vista.getTextSalaIdFechaCursada().getText().toString());
				long idSala = Long.parseLong(this.vista.getTextSalaId().getText().toString());
				if (idFechacursada == fechaCursadaClaseDTO.getIdFechaCursadaClase()) {
					fechaCursadaClaseDTO.setIdSala(idSala);
				}
			}
			llenarTablaFechasDeCursada();
		} else if (e.getSource() == this.vista.getBtnGuardarCambios()) {
			for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechasDeClasesCursadaList) {
				modelo.agregarFechaCursadaClase(fechaCursadaClaseDTO);
			}
		}		
	}
	
	private String getDiaDelaSemana(LocalDate date) {
	    Locale spanishLocale = new Locale("es", "ES");
	    String dateInSpanish = date.format(DateTimeFormatter.ofPattern("EEEE",spanishLocale));
	    //System.out.println("En Espanol: "+dateInSpanish);
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

