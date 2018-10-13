package persistencia.controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CursadaCompletaDTO;
import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CursadaABMPanel;

public class CursadaABMControlador {
	
	private CursadaABMPanel vista;
	private AdministracionDeCursos modelo;
	
	private List<CursadaCompletaDTO> cursadasLista;
	
	private List<EmpresaDTO> empresasLista;
	private List<CursoDTO> cursosLista;
	private List<EstadoDeCursoDTO> estadosCurso;
	
	public CursadaABMControlador(CursadaABMPanel vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		inicializar();
	}	
	
	public void inicializar() {
		empresasLista = modelo.obtenerEmpresas();
		cursosLista = modelo.obtenerCursos();
		estadosCurso = modelo.obtenerEstadosDeCurso();
		
		initComboBox();
		
		llenarTablaCursadas();
	}

	private void llenarTablaCursadas() {
		this.vista.getModelCursadas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelCursadas().setColumnCount(0);
		this.vista.getModelCursadas().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextBoxPanelCursadas();

		this.cursadasLista = modelo.obtenerCursadasCompletas();
		for (CursadaCompletaDTO cursadaCompletaDTO : cursadasLista) {
			Object[] fila = {cursadaCompletaDTO.getIdCursada(),
							 cursadaCompletaDTO.getIdEmpresa(),
					         cursadaCompletaDTO.getIdCurso(),
					         cursadaCompletaDTO.getIdEstadoCurso(),
					         cursadaCompletaDTO.getCurso(),
					         cursadaCompletaDTO.getEmpresa(),
					         stringDateFormatter(cursadaCompletaDTO.getFechaInicioInscripcion()),
					         stringDateFormatter(cursadaCompletaDTO.getFechaFinInscripcion()),
					         cursadaCompletaDTO.getEstadoCurso(),
							 cursadaCompletaDTO.getVacantes(),
							 stringDateFormatter(cursadaCompletaDTO.getFechaInicioCursada()),
							 cursadaCompletaDTO.getDiasDeClase()};						 
			this.vista.getModelCursadas().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTblCursadas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(0).setMaxWidth(0);			
		this.vista.getTblCursadas().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(1).setMaxWidth(0);			
		this.vista.getTblCursadas().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(2).setMaxWidth(0);			
		this.vista.getTblCursadas().getColumnModel().getColumn(3).setWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(3).setMinWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(3).setMaxWidth(0);			
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblCursadas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblCursadas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblCursadas().getSelectedRow() >= 0) {					
					Object idCursada = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 0);
					Object idEmpresa = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 1);
					Object idCurso = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 2);
					Object idEstadoCurso = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 3);					
					Object fechaInicioInscripcion = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 6);
					Object fechaFinInscripcion = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 7);
					Object vacantes = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 9);
					Object fechaInicioCursada = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 10);
					Object diasDeClase = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 11);					
					
					this.vista.getCbxEmpresa().setSelectedItem(selectEmpresa(idEmpresa));
					this.vista.getCbxCurso().setSelectedItem(selectCurso(idCurso));
					this.vista.getCbxEstado().setSelectedItem(selectEstadoDeCurso(idEstadoCurso));
					this.vista.getTextVacantes().setText(vacantes.toString());
					this.vista.getTextFechaInicioInsc().setText(fechaInicioInscripcion.toString());
					this.vista.getTextFechaFinInsc().setText(fechaFinInscripcion.toString());
					this.vista.getTextFechaInicioCursada().setText(fechaInicioCursada.toString());
					this.vista.getTextDiasDeClase().setText(diasDeClase.toString());
					this.vista.getTextIdCursada().setText(idCursada.toString());
					
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblCursadas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	private void clearTextBoxPanelCursadas() {
		this.vista.getCbxEmpresa().setSelectedItem(new EmpresaDTO(0, "", "", ""));
		this.vista.getCbxCurso().setSelectedItem(new CursoDTO(0, 0, "", "", ""));
		this.vista.getCbxEstado().setSelectedItem(new EstadoDeCursoDTO(0, ""));
		this.vista.getTextFechaInicioInsc().setText("");
		this.vista.getTextFechaFinInsc().setText("");
		this.vista.getTextVacantes().setText("");
		this.vista.getTextFechaInicioCursada().setText("");
		this.vista.getTextDiasDeClase().setText("");
		this.vista.getTextIdCursada().setText("");
	}

	private void initComboBox() {

		if (this.vista.getCbxEmpresa().getItemCount() == 0) {
			this.vista.getCbxEmpresa().addItem(new EmpresaDTO(0, "", "", ""));
			for (EmpresaDTO empresaDTO : empresasLista) {
				this.vista.getCbxEmpresa().addItem(empresaDTO);
			}
		}

		if (this.vista.getCbxCurso().getItemCount() == 0) {
			this.vista.getCbxCurso().addItem(new CursoDTO(0, 0, "", "", ""));
			for (CursoDTO cursoDTO : cursosLista) {
				this.vista.getCbxCurso().addItem(cursoDTO);
			}
		}

		if (this.vista.getCbxEstado().getItemCount() == 0) {
			this.vista.getCbxEstado().addItem(new EstadoDeCursoDTO(0, ""));
			for (EstadoDeCursoDTO estadoDTO : estadosCurso) {
				this.vista.getCbxEstado().addItem(estadoDTO);
			}
		}
	}

	private EmpresaDTO selectEmpresa(Object idEmpresa) {
		EmpresaDTO empresa = null;
		for (EmpresaDTO empresaDTO : empresasLista) {
			if (empresaDTO.getIdEmpresa() == Long.parseLong(idEmpresa.toString())) {
				empresa = empresaDTO;
			}
		}
		return empresa;
	}
	
	private CursoDTO selectCurso(Object idCurso) {
		CursoDTO cursoDTO = null;
		for (CursoDTO curso : cursosLista) {
			if (curso.getIdCurso() == Long.parseLong(idCurso.toString())) {
				cursoDTO = curso;
			}
		}
		return cursoDTO;
	}

	private EstadoDeCursoDTO selectEstadoDeCurso(Object idEstadoDeCurso) {
		EstadoDeCursoDTO estadoDeCursoDTO = null;
		for (EstadoDeCursoDTO estadoDeCurso : estadosCurso) {
			if (estadoDeCurso.getIdEstadoDeCurso() == Long.parseLong(idEstadoDeCurso.toString())) {
				estadoDeCursoDTO = estadoDeCurso;
			}
		}
		return estadoDeCursoDTO;
	}
		
	private String stringDateFormatter(LocalDateTime fecha) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}

	private LocalDateTime StringToLocalDateTime(String fecha) {
		
		String date = fecha + " 00:00:00";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format);
		return dateTime;
	}

	@SuppressWarnings("serial")
	public class ListSelectionModelCstm extends DefaultListSelectionModel {

		public ListSelectionModelCstm() {
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
