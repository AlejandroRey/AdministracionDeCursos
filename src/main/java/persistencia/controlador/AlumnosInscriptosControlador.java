package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoDTO;
import dto.AlumnoInscriptoDTO;
import dto.CursadaDTO;
import dto.InscriptoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoModalPanel;
import presentacion.vista.AlumnosInscriptosPanel;

public class AlumnosInscriptosControlador implements ActionListener {
	
	private AlumnosInscriptosPanel vista;
	private AdministracionDeCursos modelo;
	private List<AlumnoInscriptoDTO> alumnosInscriptosLista;
	
	private CursadaDTO cursadaDTO;
	
	private AlumnoModalPanel alumnoModalPanel;
	private AlumnoModalControlador alumnoModalControlador;
	

	public AlumnosInscriptosControlador(AlumnosInscriptosPanel vista, AdministracionDeCursos modelo, CursadaDTO cursadaDTO) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.cursadaDTO = cursadaDTO;
		
		this.alumnosInscriptosLista = null;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
	}

	public void inicializar() {
		llenarTabla();
	}

	public void llenarTabla() {
		this.vista.getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAlumnos().setColumnCount(0);
		this.vista.getModelAlumnos().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.alumnosInscriptosLista = modelo.obtenerAlumnosInscriptos(cursadaDTO);
		for (AlumnoInscriptoDTO alumnoInscriptoDTO : alumnosInscriptosLista) {
			if (alumnoInscriptoDTO.isEstado()) {
				Object[] fila = {alumnoInscriptoDTO.getIdAlumno(),
						 alumnoInscriptoDTO.getIdCursada(),
						 alumnoInscriptoDTO.getNombre(), 
						 alumnoInscriptoDTO.getApellido(),
						 alumnoInscriptoDTO.getTelefono(),
						 alumnoInscriptoDTO.getEmail(),
						 stringToLocalDateFormatter(alumnoInscriptoDTO.getFecha())};
				this.vista.getModelAlumnos().addRow(fila);
			}
		}
		// Oculto los id del Objeto
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(1).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblAlumnos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblAlumnos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblAlumnos().getSelectedRow() >= 0) {					
					Object idAlumno = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 0);
					Object idCursada = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 1);
					Object nombre = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 2);
					Object apellido = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 3);
					Object telefono = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 4);
					Object email = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 5);
					Object fecha = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 6);
					
					this.vista.getTextIdAlumno().setText(idAlumno.toString());
					this.vista.getTextIdCursada().setText(idCursada.toString());
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextApellido().setText(apellido.toString());
					this.vista.getTextTelefono().setText(telefono.toString());
					this.vista.getTextEmail().setText(email.toString());
					this.vista.getTextFecha().setText(fecha.toString());
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getBtnAgregar()) {
			
			int qtyInscriptos = alumnosInscriptosLista.size();
			int vacantes =Integer.parseInt(cursadaDTO.getVacantes());
			if ( qtyInscriptos >= vacantes) {
				JOptionPane.showMessageDialog(null,
					    "La cantidad de Inscriptos supera la cantidad de Vacantes!",
					    "Inscripcion Alumnos:",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));
			}
			
			if (alumnoModalPanel != null) {
				alumnoModalPanel.dispose();
				alumnoModalControlador = null;
			}			
			alumnoModalPanel = new AlumnoModalPanel();
			alumnoModalControlador = new AlumnoModalControlador(modelo, this);
			alumnoModalControlador.inicializar();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			try {
				InscriptoDTO inscriptoDTO = new InscriptoDTO(Long.parseLong(this.vista.getTextIdAlumno().getText().toString()), 
															 Long.parseLong(this.vista.getTextIdCursada().getText().toString()), 
															 LocalDateTime.now(),
															 false);
				modelo.actualizarInscripto(inscriptoDTO);
				llenarTabla();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
					    "Seleccione Alumno a Eliminar!",
					    "Error:",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("imagenes/warning_64.png"));
			}
		}
	}

	private AlumnoInscriptoDTO getAlumnoInscripto() {
		AlumnoInscriptoDTO alumnoInscriptoDTO = new AlumnoInscriptoDTO(Long.parseLong(this.vista.getTextIdAlumno().getText().toString()), 
														   Long.parseLong(this.vista.getTextIdCursada().getText().toString()), 
														   this.vista.getTextNombre().getText().toString(), 
														   this.vista.getTextApellido().getText().toString(), 
														   this.vista.getTextTelefono().getText().toString(), 
														   this.vista.getTextEmail().getText().toString(), 
														   LocalDateTime.now(),
														   true);
		
		return alumnoInscriptoDTO;
	}

	private void eliminarAlumno() {        
    	int dialogResult = JOptionPane.showConfirmDialog(null, "Se va a Eliminar el Alumno seleccionado!", "Confirma Eliminar Registro?", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
        		AlumnoDTO alumno = new AlumnoDTO(Long.parseLong(this.vista.getTextIdAlumno().getText()),
						   this.vista.getTextNombre().getText(),
						   this.vista.getTextApellido().getText(),
						   this.vista.getTextTelefono().getText(),
						   this.vista.getTextEmail().getText());
				this.modelo.borrarAlumno(alumno);
				llenarTabla();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
	}
	
	private String stringToLocalDateFormatter(LocalDateTime fecha) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}
	
	private void clearTextInputsBox() {
		this.vista.getTextIdAlumno().setText("");
		this.vista.getTextIdCursada().setText("");
		this.vista.getTextNombre().setText("");
		this.vista.getTextApellido().setText("");
		this.vista.getTextTelefono().setText("");
		this.vista.getTextEmail().setText("");
		this.vista.getTextFecha().setText("");
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

	/**
	 * @return the vista
	 */
	public AlumnosInscriptosPanel getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(AlumnosInscriptosPanel vista) {
		this.vista = vista;
	}

	/**
	 * @return the modelo
	 */
	public AdministracionDeCursos getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(AdministracionDeCursos modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the alumnosInscriptosLista
	 */
	public List<AlumnoInscriptoDTO> getAlumnosInscriptosLista() {
		return alumnosInscriptosLista;
	}

	/**
	 * @param alumnosInscriptosLista the alumnosInscriptosLista to set
	 */
	public void setAlumnosInscriptosLista(List<AlumnoInscriptoDTO> alumnosInscriptosLista) {
		this.alumnosInscriptosLista = alumnosInscriptosLista;
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

	/**
	 * @return the alumnoModalPanel
	 */
	public AlumnoModalPanel getAlumnoModalPanel() {
		return alumnoModalPanel;
	}

	/**
	 * @param alumnoModalPanel the alumnoModalPanel to set
	 */
	public void setAlumnoModalPanel(AlumnoModalPanel alumnoModalPanel) {
		this.alumnoModalPanel = alumnoModalPanel;
	}

}
