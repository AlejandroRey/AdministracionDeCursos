package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CursadaCompletaDTO;
import dto.CursadaDTO;
import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CursadaABMPanel;

public class CursadaABMControlador implements ActionListener {
	
	private CursadaABMPanel vista;
	private CursadaABMVistaPrincipalControlador vistaPrincipalControlador;
	private AdministracionDeCursos modelo;
	
	private List<CursadaCompletaDTO> cursadasLista;
	
	private List<EmpresaDTO> empresasLista;
	private List<CursoDTO> cursosLista;
	private List<EstadoDeCursoDTO> estadosCurso;
	
	public CursadaABMControlador(CursadaABMPanel vista, CursadaABMVistaPrincipalControlador vistaPrincipalControlador, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.vistaPrincipalControlador = vistaPrincipalControlador;
		this.modelo = modelo;
		
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
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
					         stringToLocalDateFormatter(cursadaCompletaDTO.getFechaInicioInscripcion()),
					         stringToLocalDateFormatter(cursadaCompletaDTO.getFechaFinInscripcion()),
					         cursadaCompletaDTO.getEstadoCurso(),
							 cursadaCompletaDTO.getVacantes(),
							 stringToLocalDateFormatter(cursadaCompletaDTO.getFechaInicioCursada()),
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
	
	public void setEstadoCurso() {
		this.vista.getCbxEstado().setSelectedItem(selectEstadoDeCurso(1));
	}
		
	private String stringToLocalDateFormatter(LocalDateTime fecha) {
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
	
	private CursadaDTO getCursadaDTO() {

		EmpresaDTO empresa = (EmpresaDTO) this.vista.getCbxEmpresa().getSelectedItem();
		CursoDTO curso = (CursoDTO) this.vista.getCbxCurso().getSelectedItem();
		EstadoDeCursoDTO estadoDeCurso = (EstadoDeCursoDTO) this.vista.getCbxEstado().getSelectedItem();
		
		LocalDateTime fechaInicioInscripcion = StringToLocalDateTime(this.vista.getTextFechaInicioInsc().getText());
		LocalDateTime fechaFinInscripcion = StringToLocalDateTime(this.vista.getTextFechaFinInsc().getText());
		LocalDateTime fechaInicioCursada = StringToLocalDateTime(this.vista.getTextFechaInicioCursada().getText());
		
		long idTemp = 0;
		if (!this.vista.getTextIdCursada().getText().toString().equals("")) {
			System.out.println(this.vista.getTextIdCursada().getText().toString());
			idTemp = Long.parseLong(this.vista.getTextIdCursada().getText().toString());
		}
		
		CursadaDTO cursadaDTO = new CursadaDTO(idTemp, 
											   empresa.getIdEmpresa(), 
											   curso.getIdCurso(), 
											   estadoDeCurso.getIdEstadoDeCurso(), 
											   fechaInicioInscripcion, 
											   fechaFinInscripcion, 
											   this.vista.getTextVacantes().getText(), 
											   fechaInicioCursada, 
											   Integer.parseInt(this.vista.getTextDiasDeClase().getText()));
	
		
		return cursadaDTO;
	}
	
	private String cursadaDTOToString(CursadaDTO cursadaDTO) {
		EmpresaDTO empresa = selectEmpresa(cursadaDTO.getIdEmpresa());
		CursoDTO curso = selectCurso(cursadaDTO.getIdCurso());
		EstadoDeCursoDTO estadoCurso = selectEstadoDeCurso(cursadaDTO.getIdEstadoCurso());
		
		String strCursadaDTO = "Curso: " + curso.getNombre() + System.lineSeparator()
							 + "Empresa: " + empresa.getNombre() + System.lineSeparator()
							 + "Ini Insc: " + stringToLocalDateFormatter(cursadaDTO.getFechaInicioInscripcion()) + System.lineSeparator()
							 + "Fin Insc: " + stringToLocalDateFormatter(cursadaDTO.getFechaFinInscripcion()) + System.lineSeparator()
							 + "Ini Cursada" + stringToLocalDateFormatter(cursadaDTO.getFechaInicioCursada()) + System.lineSeparator()
							 + "Vacantes: " + cursadaDTO.getVacantes() + System.lineSeparator()
							 + "Dias de Clase: " + cursadaDTO.getDiasDeClase() + System.lineSeparator()
							 + "Estado: " + estadoCurso.getNombre();
		
		return strCursadaDTO;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CursadaDTO cursadaDTO = getCursadaDTO();
		String strCursadaDTO = cursadaDTOToString(cursadaDTO);
		
		if (e.getSource()== this.vista.getBtnSeleccionar() ) {
			this.vistaPrincipalControlador.getVista().getButtonPanel().setVisible(false);
			this.vistaPrincipalControlador.getVista().getButtonPanelExtends().setVisible(true);
			this.vistaPrincipalControlador.getVista().getTextAreaCursadaSeleccionada().setText(strCursadaDTO);
			this.vistaPrincipalControlador.setCursadaDTO(cursadaDTO);
			
			this.vistaPrincipalControlador.getVista().getMainPanel().removeAll();
			this.vistaPrincipalControlador.getVista().getMainPanel().repaint();
			this.vistaPrincipalControlador.getVista().repaint();
		} else if (e.getSource() == this.vista.getBtnAgregar()) {
			CursadaDTO cursadaNuevaDTO = getCursadaDTO();
			modelo.agregarCursada(cursadaNuevaDTO);
			llenarTablaCursadas();
		} else if (e.getSource() == this.vista.getBtnActualizar()) {
			CursadaDTO cursadaActualizarDTO = getCursadaDTO();
			modelo.actualizarCursada(cursadaActualizarDTO);
			llenarTablaCursadas();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			CursadaDTO cursadaEliminarDTO = getCursadaDTO();
			modelo.borrarCursada(cursadaEliminarDTO);
			llenarTablaCursadas();
		}
		
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTblCursadas().setEnabled(true);
		clearTextBoxPanelCursadas();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTblCursadas().setEnabled(false);
		clearTextBoxPanelCursadas();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTblCursadas().setEnabled(true);
		clearTextBoxPanelCursadas();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	public void setVisibleBtnSeleccionar() {
		this.vista.getTblCursadas().setEnabled(true);
		clearTextBoxPanelCursadas();
		setBtnNotVisible();
		this.vista.getBtnSeleccionar().setVisible(true);		
	}
	
	public void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
		this.vista.getBtnSeleccionar().setVisible(false);
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
