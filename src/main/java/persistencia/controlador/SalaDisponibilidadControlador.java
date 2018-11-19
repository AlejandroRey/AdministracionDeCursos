package persistencia.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import presentacion.vista.SalaDisponibilidadDialog;
import herramientas.HighlightEvaluator;

public class SalaDisponibilidadControlador implements PropertyChangeListener, ActionListener{
	
	private HighlightEvaluator highlightGreen;
	private HighlightEvaluator highlightYellow;
	private HighlightEvaluator highlightRed;
	private SalaDisponibilidadDialog vista;
	private HashMap<LocalDate, ArrayList<DisponibilidadControlador>> hashHorarios;
	
	public SalaDisponibilidadControlador(SalaDisponibilidadDialog vista) {
		this.vista = vista;
		this.hashHorarios = null;
	}	
	
	public void inicializar() {
		addActionBtn();
		this.vista.showDialog();
	}
	
	private void addActionBtn() {
		this.vista.getBtnCerrar().addActionListener(this);
		this.vista.getBtnCerrar().setActionCommand("Cerrar");
		this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addPropertyChangeListener(this);
	}

	public void createHighlights(List<DisponibilidadControlador> fechas) {
		HashMap<LocalDate,Integer> horariosFecha = new HashMap<>();
		evaluarFechas(fechas,horariosFecha);
		addDatesToHighlight(horariosFecha);
		addCalendar();
	}

	private void addCalendar() {
		this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().removeDateEvaluator(highlightGreen);
		this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().removeDateEvaluator(highlightYellow);
		this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().removeDateEvaluator(highlightRed);
		this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addDateEvaluator(highlightGreen);
        this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addDateEvaluator(highlightYellow);
        this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addDateEvaluator(highlightRed);
        this.vista.getDisponibilidadPanel().getCalendar().setCalendar(vista.getDisponibilidadPanel().getCalendar()
        		.getCalendar());
	}
	
	private void addDatesToHighlight(HashMap<LocalDate, Integer> horariosFecha) {
		Map<LocalDate, Integer> fechasGreen = horariosFecha.entrySet().stream()
              .filter(map -> map.getValue() <= 4 )
              .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		System.out.println("Green: "+ fechasGreen.toString());
		Set<LocalDate> green = fechasGreen.keySet();
		
		Map<LocalDate, Integer> fechasYellow = horariosFecha.entrySet().stream()
	              .filter(map -> map.getValue() > 4 && map.getValue() <= 10)
	              .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		System.out.println("Yellow: "+ fechasYellow.toString());
		Set<LocalDate> yellow = fechasYellow.keySet();
		
		Map<LocalDate, Integer> fechasRed = horariosFecha.entrySet().stream()
	              .filter(map -> map.getValue() > 10)
	              .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		System.out.println("Red: "+ fechasRed.toString());
		Set<LocalDate> red = fechasRed.keySet();
		
		loadHighlightEvaluatorGreen(green);
		loadHighlightEvaluatorYellow(yellow);
		loadHighlightEvaluatorRed(red);
	}

	private void loadHighlightEvaluatorGreen(Set<LocalDate> fechas) {
		highlightGreen = new HighlightEvaluator(Color.GREEN);
		for(LocalDate date : fechas) {
			int day = date.getDayOfMonth();
			int month = date.getMonthValue();
			highlightGreen.add(highlightGreen.createDate(day,month - 1, 0, 0, 0));
		}
	}
	
	private void loadHighlightEvaluatorYellow(Set<LocalDate> fechas) {
		highlightYellow = new HighlightEvaluator(Color.YELLOW);
		for(LocalDate date : fechas) {
			int day = date.getDayOfMonth();
			int month = date.getMonthValue();
			highlightYellow.add(highlightYellow.createDate(day,month - 1, 0, 0, 0));
		}
	}
	
	private void loadHighlightEvaluatorRed(Set<LocalDate> fechas) {
		highlightRed = new HighlightEvaluator(Color.RED);
		for(LocalDate date : fechas) {
			int day = date.getDayOfMonth();
			int month = date.getMonthValue();
			highlightRed.add(highlightRed.createDate(day,month - 1, 0, 0, 0));
		}
	}
	
	private void evaluarFechas(List<DisponibilidadControlador> fechas, HashMap<LocalDate,Integer> horariosFecha) {
		hashHorarios = new HashMap<LocalDate, ArrayList<DisponibilidadControlador>>();
		for (DisponibilidadControlador dato : fechas) {
			LocalDate fecha = dato.getFecha();
			calculateHours(horariosFecha, dato, fecha);
			addToHashHorarios(dato, fecha);
		}
	}

	private void calculateHours(HashMap<LocalDate, Integer> horariosFecha, DisponibilidadControlador dato, LocalDate fecha) {
		LocalDateTime horaInicio = dato.getHoraInicio();
		LocalDateTime horaFin = dato.getHoraFin();
		boolean containsDate = horariosFecha.containsKey(fecha);
		Integer horas = (int) horaInicio.until(horaFin, ChronoUnit.HOURS);
		System.out.println("fei:" + horaInicio);
		System.out.println("fei:" + horaFin);
		System.out.println("Horas: " + horas);
		if(!containsDate){
			horariosFecha.put(fecha, horas);
			System.out.println("Horas totales: " + horariosFecha.get(fecha));}
		else {
			horas = horariosFecha.get(fecha) + horas;
			horariosFecha.put(fecha, horas);
			System.out.println("Horas totales con suma: " + horas);
		}
	}

	private void addToHashHorarios(DisponibilidadControlador dato, LocalDate fecha) {
		if(!hashHorarios.containsKey(fecha)){
			hashHorarios.put(fecha, new ArrayList<DisponibilidadControlador> ());
			hashHorarios.get(fecha).add(dato);
		} else {
			ArrayList<DisponibilidadControlador> listTemp = hashHorarios.get(fecha);
			listTemp.add(dato);
			hashHorarios.put(fecha, listTemp);
		}
	}
	
	private String stringDate(LocalDateTime fecha, String pattern) {
		String formatDateTime = "";
		if ( fecha != null){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			formatDateTime = fecha.format(formatter);
		}
		return formatDateTime;
	}

	private void loadTableWithHours(ArrayList<DisponibilidadControlador> disponibilidades) {
		this.vista.getDisponibilidadPanel().getModelHorarios().setRowCount(0); // Para vaciar la tabla
		this.vista.getDisponibilidadPanel().getModelHorarios().setColumnCount(0);
		this.vista.getDisponibilidadPanel().getModelHorarios().setColumnIdentifiers(this.vista
															  .getDisponibilidadPanel().getNombreColumnasHorarios());

		for (DisponibilidadControlador disponibilidad : disponibilidades) {
			Object[] fila = {this.stringDate(disponibilidad.getHoraInicio(), "HH:mm"),
							 this.stringDate(disponibilidad.getHoraFin(), "HH:mm"), 
							 disponibilidad.getNombreCurso()};
			this.vista.getDisponibilidadPanel().getModelHorarios().addRow(fila);
		}
		
		// Agrego listener para obtener los valores de la fila seleccionada
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getDisponibilidadPanel().getTableHorarios().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private void paintCalendar() {
		vista.getDisponibilidadPanel().getCalendar().setCalendar(vista.getDisponibilidadPanel().getCalendar().getCalendar());
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getPropertyName().compareTo("day") == 0) {
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = formatoDeFecha.format(vista.getDisponibilidadPanel().getCalendar().getDate());
            LocalDate date = LocalDate.parse(currentDate);
            ArrayList<DisponibilidadControlador> disponibilidades = hashHorarios.get(date);
            paintCalendar();
            try {
            	loadTableWithHours(disponibilidades);
			} catch (Exception e) {
				System.out.println(e + "La sala no tiene asignaciones ese dia");
			}
        }
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.vista.getBtnCerrar())
			this.vista.dispose();
	}
	
	public static void main(String args[]) {
	}
}
