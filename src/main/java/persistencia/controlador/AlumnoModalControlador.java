package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dto.AlumnoDTO;
import dto.AlumnoInscriptoDTO;
import dto.CursadaDTO;
import dto.InscriptoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoABMPanel;

public class AlumnoModalControlador implements ActionListener {
	
	private AlumnoABMControlador alumnoABMControlador;
	private AlumnoABMPanel alumnoABM;
	private AdministracionDeCursos modelo;
	
	private AlumnosInscriptosControlador alumnosInscriptosControlador;
	private CursadaDTO cursadaDTO;

	public AlumnoModalControlador(AdministracionDeCursos modelo, AlumnosInscriptosControlador alumnosInscriptosControlador) {
		super();
		
		this.modelo = modelo;
		this.alumnosInscriptosControlador = alumnosInscriptosControlador;
		
		this.cursadaDTO = this.alumnosInscriptosControlador.getCursadaDTO();
		
		alumnoABM = new AlumnoABMPanel();		
		alumnoABMControlador = new AlumnoABMControlador(alumnoABM, this.modelo);
		alumnoABMControlador.inicializar();
		alumnoABMControlador.setDisableTextFields();
		alumnoABMControlador.setBtnNotVisible();
		alumnoABMControlador.setVisibleBtnInscribir();
		alumnoABMControlador.getVista().getBtnInscribir().addActionListener(this);		
	}
	
	public void inicializar() {
		
		this.alumnosInscriptosControlador.getAlumnoModalPanel().setAlumnoAbmPanel(alumnoABM);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == alumnoABM.getBtnInscribir()) {
			try {
				AlumnoDTO alumnoDTO = alumnoABMControlador.getAlumnoDTO();
				InscriptoDTO inscriptoDTO = new InscriptoDTO(alumnoDTO.getIdAlumno(), 
															 cursadaDTO.getIdCursada(),
															 LocalDateTime.now(),
															 true);
				int flag = 0;
				for (AlumnoInscriptoDTO inscripto : modelo.obtenerAlumnosInscriptos(cursadaDTO)) {
					if (inscripto.getIdAlumno() == inscriptoDTO.getIdAlumno()) {
						flag = 1;
						if (inscripto.isEstado()) {
							JOptionPane.showMessageDialog(null,
								    "El Alumno ya se encuentra en la Lista!",
								    "Advertencia",
								    JOptionPane.INFORMATION_MESSAGE,
								    new ImageIcon("imagenes/warning_64.png"));	
							break;
						}else {
							int optionResult = JOptionPane.showConfirmDialog(null, 
																			 "El Alumno se encuentra con la inscripcion dada de baja!"
																		   + System.lineSeparator()
																		   + "Desea renovar la inscripcion?", 
																		     "ADVERTENCIA", 
																		     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
																		     new ImageIcon("imagenes/warning_64.png"));
							
							if (optionResult == 0) {
							    InscriptoDTO i = new InscriptoDTO(inscriptoDTO.getIdAlumno(), 
							    								  inscriptoDTO.getIdCursada(), 
							    								  LocalDateTime.now(), 
							    								  true);
																  modelo.actualizarInscripto(i);
																  alumnosInscriptosControlador.llenarTabla();
																  break;
							}
						}
					}
				}
				if (flag == 0) {
					modelo.agregarInscripto(inscriptoDTO);
					alumnosInscriptosControlador.llenarTabla();
					System.out.println(alumnoDTO.toString());
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
					    "Seleccione Alumno!",
					    "Error:",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));
			}
		}		
	}

}
