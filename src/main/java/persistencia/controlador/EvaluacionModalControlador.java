package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dto.CursadaDTO;
import dto.EvaluacionCursadaDTO;
import dto.EvaluacionTipoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.EvaluacionABMPanel;
import presentacion.vista.EvaluacionModalPanel;

public class EvaluacionModalControlador implements ActionListener {
	
	private EvaluacionABMControlador evaluacionABMControlador;
	private EvaluacionABMPanel evaluacionABM;
	private AdministracionDeCursos modelo;
	
	private EvaluacionModalPanel evaluacionModalPanel;
	
	private AlumnosEvaluacionesControlador alumnosEvaluacionesControlador;
	private CursadaDTO cursadaDTO;
	
	
	public EvaluacionModalControlador(AdministracionDeCursos modelo,
									  EvaluacionModalPanel evaluacionModalPanel, 
									  AlumnosEvaluacionesControlador alumnosEvaluacionesControlador) {
		super();
		this.modelo = modelo;
		this.alumnosEvaluacionesControlador = alumnosEvaluacionesControlador;
		
		this.cursadaDTO = this.alumnosEvaluacionesControlador.getCursadaDTO();
		this.evaluacionABM = new EvaluacionABMPanel();
		this.evaluacionABMControlador = new EvaluacionABMControlador(evaluacionABM, this.modelo);
		this.evaluacionABMControlador.inicializar();
		
		this.evaluacionModalPanel = evaluacionModalPanel;
		
		this.evaluacionABM.getBtnAgregarEvaluacion().addActionListener(this);
	}


	public void inicializar() {	
		this.alumnosEvaluacionesControlador.getEvaluacionModalPanel().
											setEvaluacionABMPanel(evaluacionABM);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.evaluacionABM.getBtnAgregarEvaluacion()) {			
			try {
				EvaluacionTipoDTO evaluacionTipoDTO = (EvaluacionTipoDTO) this.evaluacionABM.getCbxEvaluacionTipo().getSelectedItem();
				EvaluacionCursadaDTO evaluacionCursadaDTO = new EvaluacionCursadaDTO(0, 
																					 cursadaDTO.getIdCursada(),
																					 evaluacionTipoDTO.getIdEvaluacionTipo(), 
																					 this.evaluacionABM.getTextTema().getText(), 
																					 StringToLocalDate(this.evaluacionABM.getTextFecha().getText()));
				//System.out.println("Evauacion: " + evaluacionCursadaDTO.toString());
				modelo.agregarEvaluacionCursada(evaluacionCursadaDTO);
				alumnosEvaluacionesControlador.llenarTablaEvaluaciones();
				alumnosEvaluacionesControlador.llenarTablaAlumnosInscriptos();
				evaluacionModalPanel.dispose();
			} catch (Exception ex) {
				System.out.println("Error Windows Modal: " + ex);
				JOptionPane.showMessageDialog(null,
					    "Controle Tema de Parcial y Formato de Fechas!",
					    "Evaluacion:",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));
			}
		}
		
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

}
