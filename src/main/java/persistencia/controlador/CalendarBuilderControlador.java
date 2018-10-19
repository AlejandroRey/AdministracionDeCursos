package persistencia.controlador;

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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CursadaDTO;
import dto.DiaCursadaClaseDTO;
import dto.DiasDTO;
import dto.FechaCursadaClaseDTO;
import modelo.AdministracionDeCursos;
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
	

	public CalendarBuilderControlador(CursadaDTO cursadaDTO, CalendarioBuilderPanel vista, AdministracionDeCursos modelo) {
		super();
		this.cursadaDTO = cursadaDTO;
		this.vista = vista;
		this.modelo = modelo;

		mapDiasDeClaseCursada = new HashMap<Integer, DiaCursadaClaseDTO>();
		this.fechasDeClasesCursadaList = new ArrayList<FechaCursadaClaseDTO>();
		
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnGenerarHorario().addActionListener(this);
	}

	public void inicializar() {
		this.vista.getTextFechaInicio().setText(stringDateFormatter(this.cursadaDTO.getFechaInicioCursada().toLocalDate()));
		this.vista.getTextCantidadDeDias().setText(String.valueOf(this.cursadaDTO.getDiasDeClase()));
		
		llenarTablaDiasDeCursada();
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
								 localDateTimeFormatter(fechaCursadaClaseDTO.getFechaFin())};
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
//				if (this.vista.getTablaFechasDeCursada().getSelectedRow() >= 0) {					
//					Object idFechaCursadaClase = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 0);
//					Object idCursada = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 1);
//					Object idSala = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 2);
//					Object fechaInicio = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 3);
//					Object fechaFin = this.vista.getTablaFechasDeCursada().getValueAt(this.vista.getTablaFechasDeCursada().getSelectedRow(), 4);
//
//				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaFechasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getBtnSeleccionar()) {
			if (!this.vista.getTextHoraInicio().getText().equals(null) && this.vista.getTextHoraFin() != null) {
				System.out.println("Dia Seleccionado: " + this.vista.getCbxDias().getSelectedItem().toString());
				DiasDTO diaSeleccionado = (DiasDTO) this.vista.getCbxDias().getSelectedItem();
				DiaCursadaClaseDTO d = new DiaCursadaClaseDTO(0, 
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
			for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeClaseCursadaList) {
				System.out.println("DIAS A PROGRAMAR: " + diaCursadaClaseDTO.getNombreDia());
			}
			
			LocalDate date = StringToLocalDate(this.vista.getTextFechaInicio().getText());
			int incDia= 0;
			int contador =Integer.parseInt(this.vista.getTextCantidadDeDias().getText());
			do {				
				for (DiaCursadaClaseDTO diaCursadaClaseDTO : diasDeClaseCursadaList) {
					String nombreDia = getDiaDelaSemana(date.plusDays(incDia));
					if (diaCursadaClaseDTO.getNombreDia().toLowerCase().equals(nombreDia)) {
						int id = 1;
						LocalDateTime fechaInicio = LocalDateTime.of(date.plusDays(incDia), diaCursadaClaseDTO.getHoraInicio());
						LocalDateTime fechaFin = LocalDateTime.of(date.plusDays(incDia), diaCursadaClaseDTO.getHoraFin());
						FechaCursadaClaseDTO fechaSeleccionada = new FechaCursadaClaseDTO(id, id, id, fechaInicio, fechaFin);
						
						fechasDeClasesCursadaList.add(fechaSeleccionada);
						contador -= 1;
					}
				}				
				incDia += 1;				
			} while (contador > 0);
			llenarTablaFechasDeCursada();
			fechasDeClasesCursadaList.clear();
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

