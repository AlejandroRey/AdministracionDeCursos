package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoDTO;
import dto.AlumnoHistorialCursadaDTO;
import dto.AlumnoHistorialNotaDTO;
import dto.AlumnoHistorialNotasReporteDTO;
import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.AlumnoHistorialCursadasDAOSQL;
import persistencia.dao.mysql.AlumnoHistorialNotasReporteDAOSQL;
import presentacion.reportes.ReporteAnaliticoAlumno;
import presentacion.vista.AlumnoHistorialNotaPanel;

public class AlumnoHistorialNotaControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private AlumnoHistorialNotaPanel vista;
	private AlumnoDTO alumnoDTO;
	
	private List<AlumnoHistorialCursadaDTO> alumnoHistorialCursadasLista;
	private List<AlumnoHistorialNotaDTO> alumnoHistorialNotasLista;
	private AlumnoHistorialCursadasDAOSQL mySql;
	private AlumnoHistorialNotasReporteDAOSQL mySqlReporte;
	
	public AlumnoHistorialNotaControlador(AdministracionDeCursos modelo, AlumnoHistorialNotaPanel vista, AlumnoDTO alumnoDTO) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.alumnoDTO = alumnoDTO;
		
		mySql = new AlumnoHistorialCursadasDAOSQL();
		mySqlReporte = new AlumnoHistorialNotasReporteDAOSQL();
		
		this.vista.getBtnImprimirHistorial().addActionListener(this);
	}

	public void inicializar() {
		llenarTablaCursadas();
	}
	
	private void llenarTablaCursadas() {
		
		this.vista.getModelCursadas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelCursadas().setColumnCount(0);
		this.vista.getModelCursadas().setColumnIdentifiers(this.vista.getNombreColumnasCursadas());

		this.alumnoHistorialCursadasLista = mySql.readAllCursada(alumnoDTO);
		for (AlumnoHistorialCursadaDTO alumnoHistorialCursadaDTO : alumnoHistorialCursadasLista) {
			Object[] fila = {alumnoHistorialCursadaDTO.getIdCurso(),
							 alumnoHistorialCursadaDTO.getIdCursada(),
							 alumnoHistorialCursadaDTO.getIdAlumno(),
							 alumnoHistorialCursadaDTO.getNombre(),
							 alumnoHistorialCursadaDTO.getApellido(),
							 alumnoHistorialCursadaDTO.getTelefono(),
							 alumnoHistorialCursadaDTO.getEmail(),
							 alumnoHistorialCursadaDTO.getCurso(),
							 alumnoHistorialCursadaDTO.getTema(),
							 alumnoHistorialCursadaDTO.getFechaInicioCursada()};
			this.vista.getModelCursadas().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTablaCursadas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(0).setMaxWidth(0);		
		this.vista.getTablaCursadas().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(1).setMaxWidth(0);		
		this.vista.getTablaCursadas().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(2).setMaxWidth(0);		
		this.vista.getTablaCursadas().getColumnModel().getColumn(5).setWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(5).setMinWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(5).setMaxWidth(0);		
		this.vista.getTablaCursadas().getColumnModel().getColumn(6).setWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(6).setMinWidth(0);
		this.vista.getTablaCursadas().getColumnModel().getColumn(6).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTablaCursadas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTablaCursadas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTablaCursadas().getSelectedRow() >= 0) {
					//idCurso, idCursada, 
					//idAlumno, nombre, apellido, telefono, email, curso, tema, fechaInicioCursada)
					Object idCurso = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 0);
					Object idCursada = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 1);
					Object idAlumno = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 2);
					Object nombre = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 3);
					Object apellido = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 4);
					Object telefono = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 5);
					Object email = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 6);
					Object curso = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 7);
					Object tema = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 8);
					Object fechaInicioCursada = this.vista.getTablaCursadas().getValueAt(this.vista.getTablaCursadas().getSelectedRow(), 9);
					
					this.alumnoHistorialNotasLista = mySql.readAllNota(Long.parseLong(idAlumno.toString()), Long.parseLong(idCursada.toString()));

					double promedio = 0;
					for (AlumnoHistorialNotaDTO alumnoHistorialNotaDTO : alumnoHistorialNotasLista) {
						System.out.println("Alumno Historial Nota: " + alumnoHistorialNotaDTO.toString());
						promedio = promedio + alumnoHistorialNotaDTO.getNota();
					}

					this.vista.getLblPromedio().setText("" + promedio / alumnoHistorialNotasLista.size());
					llenarTablaNotas();
					
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaCursadas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private void llenarTablaNotas() {
		this.vista.getModelEvaluaciones().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelEvaluaciones().setColumnCount(0);
		this.vista.getModelEvaluaciones().setColumnIdentifiers(this.vista.getNombreColumnasEvaluaciones());
		
		for (AlumnoHistorialNotaDTO alumnoHistorialNotaDTO : this.alumnoHistorialNotasLista) {
			Object[] fila = {alumnoHistorialNotaDTO.getIdAlumno(),
							 alumnoHistorialNotaDTO.getIdEvaluacion(),
							 alumnoHistorialNotaDTO.getIdCursada(),
							 alumnoHistorialNotaDTO.getIdEvaluacionTipo(),
							 alumnoHistorialNotaDTO.getParcial(),
							 alumnoHistorialNotaDTO.getTema(),
							 alumnoHistorialNotaDTO.getFecha(),
							 alumnoHistorialNotaDTO.getNota()};
			this.vista.getModelEvaluaciones().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setMaxWidth(0);		
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(1).setMaxWidth(0);		
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(2).setMaxWidth(0);		
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(3).setWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(3).setMinWidth(0);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(3).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTablaEvaluaciones().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTablaEvaluaciones().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTablaEvaluaciones().getSelectedRow() >= 0) {					
					Object idAlumno = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 0);
					Object nombre = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 1);
					Object apellido = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 2);
					Object telefono = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 3);
					Object email = this.vista.getTablaEvaluaciones().getValueAt(this.vista.getTablaEvaluaciones().getSelectedRow(), 4);
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTablaEvaluaciones().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.getBtnImprimirHistorial()) {
			for (AlumnoHistorialNotasReporteDTO alumnoHistorialNotaDTO : mySqlReporte.readAll(alumnoDTO.getIdAlumno())) {
				System.out.println(alumnoHistorialNotaDTO.toString());
			}
			ReporteAnaliticoAlumno reporte = new ReporteAnaliticoAlumno(mySqlReporte.readAll(alumnoDTO.getIdAlumno()));
			reporte.mostrar();
		}	
	}
	
}
