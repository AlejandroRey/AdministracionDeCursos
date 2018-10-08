package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dto.SalaDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CursadaFullVista;

public class CursadaFullControlador implements ActionListener {
	
	private CursadaFullVista vista;
	private AdministracionDeCursos modelo;
	private List<CursadaCompletaDTO> cursadasLista;
	
	private List<EmpresaDTO> empresasLista;
	private List<CursoDTO> cursosLista;
	private List<SalaDTO> salasLista;
	private List<EstadoDeCursoDTO> estadosCurso;
	
	public CursadaFullControlador(CursadaFullVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.cursadasLista = null;
		this.vista.getPanelCursada().getBtnActualizar().addActionListener(this);
		this.vista.getPanelCursada().getBtnAgregar().addActionListener(this);
		this.vista.getPanelCursada().getBtnEliminar().addActionListener(this);
		this.vista.getPanelCursada().getBtnCerrar().addActionListener(this);
	}

	public void inicializar() {
		empresasLista = modelo.obtenerEmpresas();
		cursosLista = modelo.obtenerCursos();
		salasLista = modelo.obtenerSalas();
		estadosCurso = modelo.obtenerEstadosDeCurso();
		
		initComboBox();
		
		llenarTabla();
		this.vista.show();
	}

	private void llenarTabla() {
		this.vista.getPanelCursada().getModelCursadas().setRowCount(0); // Para vaciar la tabla
		this.vista.getPanelCursada().getModelCursadas().setColumnCount(0);
		this.vista.getPanelCursada().getModelCursadas().setColumnIdentifiers(this.vista.getPanelCursada().getNombreColumnas());
		clearTextInputsBox();

		this.cursadasLista = modelo.obtenerCursadasCompletas();
		for (CursadaCompletaDTO cursadaCompletaDTO : cursadasLista) {
			Object[] fila = {cursadaCompletaDTO.getIdCursada(),
							 cursadaCompletaDTO.getIdEmpresa(),
					         cursadaCompletaDTO.getIdCurso(),
					         cursadaCompletaDTO.getIdSala(),
					         cursadaCompletaDTO.getIdEstadoCurso(),
					         cursadaCompletaDTO.getFechaInicioInscripcion(),
							 cursadaCompletaDTO.getFechaFinInscripcion(),
							 cursadaCompletaDTO.getVacantes(),
							 cursadaCompletaDTO.getEmpresa(),
							 cursadaCompletaDTO.getCurso(),
							 cursadaCompletaDTO.getEstadoCurso(),
							 cursadaCompletaDTO.getSala()};
			this.vista.getPanelCursada().getModelCursadas().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(0).setMaxWidth(0);			
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(1).setMaxWidth(0);			
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(2).setMaxWidth(0);			
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(3).setWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(3).setMinWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(3).setMaxWidth(0);			
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(4).setWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(4).setMinWidth(0);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(4).setMaxWidth(0);	
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getPanelCursada().getTblCursadas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getPanelCursada().getTblCursadas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getPanelCursada().getTblCursadas().getSelectedRow() >= 0) {					
					Object idCursada = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 0);
					Object idEmpresa = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 1);
					Object idCurso = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 2);
					Object idSala = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 3);
					Object idEstadoCurso = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 4);					
					Object fechaInicioInscripcion = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 5);
					Object fechaFinInscripcion = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 6);
					Object vacantes = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 7);
//					Object empresa = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 8);
//					Object curso = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 9);
//					Object estadoCurso = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 10);
//					Object sala = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 11);
					
					this.vista.getPanelCursada().getCbxEmpresa().setSelectedItem(selectEmpresa(idEmpresa));
					this.vista.getPanelCursada().getCbxCurso().setSelectedItem(selectCurso(idCurso));
					this.vista.getPanelCursada().getCbxSala().setSelectedItem(selectSala(idSala));
					this.vista.getPanelCursada().getCbxEstado().setSelectedItem(selectEstadoDeCurso(idEstadoCurso));
					this.vista.getPanelCursada().getTextVacantes().setText(vacantes.toString());
					this.vista.getPanelCursada().getTextFechaInicioInsc().setText(fechaInicioInscripcion.toString());
					this.vista.getPanelCursada().getTextFechaFinInsc().setText(fechaFinInscripcion.toString());
					this.vista.getPanelCursada().getTextIdCursada().setText(idCursada.toString());
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	private void clearTextInputsBox() {
		this.vista.getPanelCursada().getCbxEmpresa().setSelectedItem(new EmpresaDTO(0, "", "", ""));
		this.vista.getPanelCursada().getCbxCurso().setSelectedItem(new CursoDTO(0, 0, "", "", ""));
		this.vista.getPanelCursada().getCbxSala().setSelectedItem(new SalaDTO(0, "", 0, 0, ""));
		this.vista.getPanelCursada().getCbxEstado().setSelectedItem(new EstadoDeCursoDTO(0, ""));
		this.vista.getPanelCursada().getTextFechaInicioInsc().setText("");
		this.vista.getPanelCursada().getTextFechaFinInsc().setText("");
		this.vista.getPanelCursada().getTextVacantes().setText("");
	}

	private void initComboBox() {
		if (this.vista.getPanelCursada().getCbxEmpresa().getItemCount() == 0) {
			this.vista.getPanelCursada().getCbxEmpresa().addItem(new EmpresaDTO(0, "", "", ""));
			for (EmpresaDTO empresaDTO : empresasLista) {
				this.vista.getPanelCursada().getCbxEmpresa().addItem(empresaDTO);
			}
		}

		if (this.vista.getPanelCursada().getCbxCurso().getItemCount() == 0) {
			this.vista.getPanelCursada().getCbxCurso().addItem(new CursoDTO(0, 0, "", "", ""));
			for (CursoDTO cursoDTO : cursosLista) {
				this.vista.getPanelCursada().getCbxCurso().addItem(cursoDTO);
			}
		}

		if (this.vista.getPanelCursada().getCbxSala().getItemCount() == 0) {
			this.vista.getPanelCursada().getCbxSala().addItem(new SalaDTO(0, "", 0, 0, ""));
			for (SalaDTO salaDTO : salasLista) {
				this.vista.getPanelCursada().getCbxSala().addItem(salaDTO);
			}
		}

		if (this.vista.getPanelCursada().getCbxEstado().getItemCount() == 0) {
			this.vista.getPanelCursada().getCbxEstado().addItem(new EstadoDeCursoDTO(0, ""));
			for (EstadoDeCursoDTO estadoDTO : estadosCurso) {
				this.vista.getPanelCursada().getCbxEstado().addItem(estadoDTO);
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

	private SalaDTO selectSala(Object idSala) {
		SalaDTO salaDTO = null;
		for (SalaDTO sala : salasLista) {
			if (sala.getIdSala() == Long.parseLong(idSala.toString())) {
				salaDTO = sala;
			}
		}
		return salaDTO;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getPanelCursada().getBtnActualizar()) {
			//actualizarAlumno();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnAgregar()) {
			//agregarAlumno();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnEliminar()) {
			//eliminarAlumno();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnCerrar()) {
			//cerrarVistaAlumno();
		}
	}

//	private void actualizarAlumno() {
//		CursadaDTO acursada = new CursadaDTO(idCursada,
//				this.vista.getPanelCursada().getCbxEmpresa().getSelectedItem(), idCurso, idUsuario, idSala, idEstadoCurso, vacantes);
//		this.modelo.actualizarCursada(cursada);
//		llenarTabla();
//	}
//
//	private void eliminarAlumno() {        
//    	int dialogResult = JOptionPane.showConfirmDialog(null, "Se va a Eliminar el Alumno seleccionado!", "Confirma Eliminar Registro?", JOptionPane.YES_NO_OPTION);
//        if (dialogResult == JOptionPane.YES_OPTION) {
//            try {
//        		AlumnoDTO alumno = new AlumnoDTO(Long.parseLong(this.vista.getPanelCursada().getTextIdAlumno().getText()),
//						   this.vista.getPanelCursada().getTextNombre().getText(),
//						   this.vista.getPanelCursada().getTextApellido().getText(),
//						   this.vista.getPanelCursada().getTextTelefono().getText(),
//						   this.vista.getPanelCursada().getTextEmail().getText());
//				this.modelo.borrarAlumno(alumno);
//				llenarTabla();
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//	}
//
//	private void agregarAlumno() {
//		AlumnoDTO alumno = new AlumnoDTO(0,
//									   this.vista.getPanelCursada().getTextNombre().getText(),
//									   this.vista.getPanelCursada().getTextApellido().getText(),
//									   this.vista.getPanelCursada().getTextTelefono().getText(),
//									   this.vista.getPanelCursada().getTextEmail().getText());		
//		this.modelo.agregarAlumno(alumno);
//		llenarTabla();
//	}
//	
//	private void clearTextInputsBox() {
//		this.vista.getPanelCursada().getTextIdAlumno().setText("");
//		this.vista.getPanelCursada().getTextNombre().setText("");
//		this.vista.getPanelCursada().getTextApellido().setText("");
//		this.vista.getPanelCursada().getTextTelefono().setText("");
//		this.vista.getPanelCursada().getTextEmail().setText("");
//	}
	
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
