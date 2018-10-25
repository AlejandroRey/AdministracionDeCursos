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

import dto.AlumnoInscriptoDTO;
import dto.AsistenciaDTO;
import dto.CursadaDTO;
import dto.FechaCursadaClaseDTO;
import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.AsistenciaDAOSQL;
import presentacion.vista.AlumnosAsistenciaPanel;

public class AlumnosAsistenciaControlador implements ActionListener {
	
	private AlumnosAsistenciaPanel vista;
	private AdministracionDeCursos modelo;
	
	private List<FechaCursadaClaseDTO> fechaCursadaClaseList;
	private List<AlumnoInscriptoDTO> alumnosInscriptosList;
	private List<AsistenciaDTO> asistenciaFechaCursadaList;
	private CursadaDTO cursadaDTO;
	
	private AsistenciaDAOSQL mySql;
	

	public AlumnosAsistenciaControlador(AlumnosAsistenciaPanel vista, AdministracionDeCursos modelo, CursadaDTO cursadaDTO) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.cursadaDTO = cursadaDTO;
		
		this.vista.setVisible(false);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		
		mySql = new AsistenciaDAOSQL();
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
	
	public void llenarTablaFechasDeCursada() {
	this.vista.getModelFechasDeCursada().setRowCount(0); // Para vaciar la tabla
	this.vista.getModelFechasDeCursada().setColumnCount(0);
	this.vista.getModelFechasDeCursada().setColumnIdentifiers(this.vista.getNombreColumnasFechasDeCursada());
	clearTextInputsBox();

	for (FechaCursadaClaseDTO fechaCursadaClaseDTO : fechaCursadaClaseList) {
		Object[] fila = {fechaCursadaClaseDTO.getIdFechaCursadaClase(),
						 fechaCursadaClaseDTO.getIdCursada(),
						 fechaCursadaClaseDTO.getIdSala(),
						 stringToLocalDateFormatter(fechaCursadaClaseDTO.getFechaInicio()),
						 stringToLocalDateFormatter(fechaCursadaClaseDTO.getFechaFin())};
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
	
	// Agrego listener para obtener los valores de la fila seleccionada
	this.vista.getTblFechasDeCursada().setSelectionModel(new ListSelectionModelCstm());
	this.vista.getTblFechasDeCursada().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
		try {
			if (this.vista.getTblFechasDeCursada().getSelectedRow() >= 0) {	
				Object id = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 0);
//				Object idFechaCursadaClase = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 1);
//				Object idCursada = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 2);
//				Object idSala = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 3);
//				Object fechaInicio = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 4);
//				Object fechaFin = this.vista.getTblFechasDeCursada().getValueAt(this.vista.getTblFechasDeCursada().getSelectedRow(), 5);
				System.out.println("11111");
				FechaCursadaClaseDTO f = new FechaCursadaClaseDTO(Long.parseLong(id.toString()), 
																  1, 
																  1, 
    															  LocalDateTime.now(), 
																  LocalDateTime.now(),
																  false);
				
				System.out.println("2222");
				asistenciaFechaCursadaList = mySql.readAll(f);
				if (asistenciaFechaCursadaList.size() > 0) {
					System.out.println("Llenaaaaaaaaaa");
					llenarTablaAsistenciaAlumnos();
				} else {
					for (AlumnoInscriptoDTO	alumnoInscriptoDTO : alumnosInscriptosList) {
						AsistenciaDTO a = new AsistenciaDTO(alumnoInscriptoDTO.getIdAlumno(), 
															f.getIdFechaCursadaClase(), 
															false, 
															"");
						mySql.insert(a);
						asistenciaFechaCursadaList = mySql.readAll(f);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	});

	DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
	leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
	this.vista.getTblFechasDeCursada().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
}	

	public void llenarTablaAsistenciaAlumnos() {
		this.vista.getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAlumnos().setColumnCount(0);
		this.vista.getModelAlumnos().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		for (AlumnoInscriptoDTO alumnoInscriptoDTO : alumnosInscriptosList) {
			for (AsistenciaDTO alumnoAsistenciaDTO : asistenciaFechaCursadaList) {
				if (alumnoInscriptoDTO.getIdAlumno() == alumnoAsistenciaDTO.getIdAlumno()) {
					Object[] fila = {alumnoInscriptoDTO.getIdAlumno(),
							 alumnoAsistenciaDTO.getIdFechaCursadaClase(),
							 alumnoInscriptoDTO.getNombre(), 
							 alumnoInscriptoDTO.getApellido(),
							 alumnoInscriptoDTO.getTelefono(),
							 alumnoInscriptoDTO.getEmail(),
							 stringToLocalDateFormatter(alumnoInscriptoDTO.getFecha()),
							 alumnoAsistenciaDTO.isTipoAsistencia()};
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
					boolean asistencia = ((Boolean) this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 7)).booleanValue();;
					
					this.vista.getTextIdAlumno().setText(idAlumno.toString());
					this.vista.getTextIdCursada().setText(idFechaCursada.toString());
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextApellido().setText(apellido.toString());
					this.vista.getTextTelefono().setText(telefono.toString());
					this.vista.getTextEmail().setText(email.toString());
					this.vista.getTextFecha().setText(fecha.toString());
					
					AsistenciaDTO asistenciaDTO =  new AsistenciaDTO(Long.parseLong(idAlumno.toString()), 
							                             Long.parseLong(idFechaCursada.toString()), 
							                             asistencia, 
							                             "");
					mySql.update(asistenciaDTO);
					System.out.println("UPDATE");
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

		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			
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
	
}
