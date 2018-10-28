package persistencia.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import modelo.AdministracionDeCursos;
import presentacion.vista.SalaDisponibilidadDialog;
import herramientas.HighlightEvaluator;

public class SalaDisponibilidadControlador implements PropertyChangeListener, ActionListener{
	
	private HighlightEvaluator highlightGreen;
	private HighlightEvaluator highlightYellow;
	private HighlightEvaluator highlightRed;
	private List<Date> datesSala;
	private List<Date> dateGreen;
	private List<Date> dateYellow;
	private List<Date> dateRed;
	private SalaDisponibilidadDialog vista;
	private AdministracionDeCursos modelo;
	
	public SalaDisponibilidadControlador(SalaDisponibilidadDialog vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.datesSala = null;
		this.dateGreen = null;
		this.dateYellow = null;
		this.dateRed = null;
	}	
	
	public void inicializar() {
		addCalendar();
		addActionBtn();
		this.vista.showDialog();
	}
	
	private void addActionBtn() {
		this.vista.getBtnCerrar().addActionListener(this);
	}

	private void addCalendar() {
		this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addPropertyChangeListener(this);
		addHighlightGreen();
        addHighlightYellow();
        addHighlightRed();
        
        this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addDateEvaluator(highlightGreen);
        this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addDateEvaluator(highlightYellow);
        this.vista.getDisponibilidadPanel().getCalendar().getDayChooser().addDateEvaluator(highlightRed);
        this.vista.getDisponibilidadPanel().getCalendar().setCalendar(vista.getDisponibilidadPanel().getCalendar().getCalendar());
	}

	private void addHighlightRed() {
		highlightRed = new HighlightEvaluator(Color.YELLOW);
        highlightRed.add(highlightRed.createDate(17,10));
        highlightRed.add(highlightRed.createDate(16,10));
	}

	private void addHighlightYellow() {
		highlightYellow = new HighlightEvaluator(Color.RED);
        highlightYellow.add(highlightYellow.createDate(13,11));
        highlightYellow.add(highlightYellow.createDate(12,11));
	}

	private void addHighlightGreen() {
		highlightGreen = new HighlightEvaluator(Color.GREEN);
        highlightGreen.add(highlightGreen.createDate(14,11));
        highlightGreen.add(highlightGreen.createDate(15,11));
	}
	
	public static void main(String args[]) {
		System.out.println("Hola");
		AdministracionDeCursos modelo = null ;
		SalaDisponibilidadDialog dialog = new SalaDisponibilidadDialog();
		SalaDisponibilidadControlador ctr = new SalaDisponibilidadControlador(dialog, modelo);
		ctr.inicializar();
		System.out.println("Sali");
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getPropertyName().compareTo("day") == 0) {
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(formatoDeFecha.format(vista.getDisponibilidadPanel().getCalendar().getDate()));
            vista.getDisponibilidadPanel().getCalendar().setCalendar(vista.getDisponibilidadPanel().getCalendar().getCalendar());
        }		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.vista.getBtnCerrar())
			this.vista.dispose();
	}
}
