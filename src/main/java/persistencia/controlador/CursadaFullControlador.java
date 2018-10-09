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

import dto.AlumnoDTO;
import dto.AlumnoInscriptoDTO;
import dto.CursadaCompletaDTO;
import dto.CursadaDTO;
import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import dto.InscriptoDTO;
import dto.SalaDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoParaInscribirModalPanel;
import presentacion.vista.CursadaFullVista;

public class CursadaFullControlador implements ActionListener {
	
	private CursadaFullVista vista;
	private AdministracionDeCursos modelo;
	private List<CursadaCompletaDTO> cursadasLista;
	private CursadaDTO cursadaActual;
	private List<AlumnoInscriptoDTO> inscriptosLista;
	
	private List<EmpresaDTO> empresasLista;
	private List<CursoDTO> cursosLista;
	private List<SalaDTO> salasLista;
	private List<EstadoDeCursoDTO> estadosCurso;
	
	private AlumnoParaInscribirModalPanel panel;
	private AlumnoParaInscribirControlador addAlumno;
	
	public CursadaFullControlador(CursadaFullVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.cursadasLista = null;
		
		this.vista.getPanelCursada().getBtnActualizar().addActionListener(this);
		this.vista.getPanelCursada().getBtnAgregar().addActionListener(this);
		this.vista.getPanelCursada().getBtnEliminar().addActionListener(this);
		this.vista.getPanelCursada().getBtnAddAlumnos().addActionListener(this);
		this.vista.getPanelCursada().getBtnAddPagos().addActionListener(this);
		this.vista.getPanelCursada().getBtnAddHorariosCursada().addActionListener(this);
		
		this.vista.getPanelInscriptos().getBtnEliminar().addActionListener(this);
	}

	public void inicializar() {
		empresasLista = modelo.obtenerEmpresas();
		cursosLista = modelo.obtenerCursos();
		salasLista = modelo.obtenerSalas();
		estadosCurso = modelo.obtenerEstadosDeCurso();
		
		initComboBox();
		
		llenarTablaCursadas();
		this.vista.show();
	}

	private void llenarTablaInscriptos() {
		this.vista.getPanelInscriptos().getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vista.getPanelInscriptos().getModelAlumnos().setColumnCount(0);
		this.vista.getPanelInscriptos().getModelAlumnos().setColumnIdentifiers(this.vista.getPanelInscriptos().getNombreColumnas());
		clearTextBoxPanelInscriptos();

		this.inscriptosLista = modelo.obtenerAlumnosInscriptos(cursadaActual);
		for (AlumnoInscriptoDTO alumnoInscriptoDTO : inscriptosLista) {
			Object[] fila = {alumnoInscriptoDTO.getIdAlumno(),
							 alumnoInscriptoDTO.getIdCursada(),
					         alumnoInscriptoDTO.getNombre(),
					         alumnoInscriptoDTO.getApellido(),
					         alumnoInscriptoDTO.getTelefono(),
					         alumnoInscriptoDTO.getEmail(),
					         stringDateFormatter(alumnoInscriptoDTO.getFecha())};
			this.vista.getPanelInscriptos().getModelAlumnos().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(0).setMaxWidth(0);			
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(1).setMaxWidth(0);			

		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getPanelInscriptos().getTblAlumnos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getPanelInscriptos().getTblAlumnos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow() >= 0) {					
					Object idAlumno = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 0);
					Object idCursada = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 1);
					Object nombre = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 2);
					Object apellido = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 3);
					Object telefono = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 4);					
					Object email = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 5);
					Object fecha = this.vista.getPanelInscriptos().getTblAlumnos().getValueAt(this.vista.getPanelInscriptos().getTblAlumnos().getSelectedRow(), 6);
					
					this.vista.getPanelInscriptos().getTextIdAlumno().setText(idAlumno.toString());
					this.vista.getPanelInscriptos().getTextIdCursada().setText(idCursada.toString());
					this.vista.getPanelInscriptos().getTextNombre().setText(nombre.toString());
					this.vista.getPanelInscriptos().getTextApellido().setText(apellido.toString());
					this.vista.getPanelInscriptos().getTextTelefono().setText(telefono.toString());
					this.vista.getPanelInscriptos().getTextEmail().setText(email.toString());
					this.vista.getPanelInscriptos().getTextFecha().setText(fecha.toString());
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getPanelInscriptos().getTblAlumnos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private void llenarTablaCursadas() {
		this.vista.getPanelCursada().getModelCursadas().setRowCount(0); // Para vaciar la tabla
		this.vista.getPanelCursada().getModelCursadas().setColumnCount(0);
		this.vista.getPanelCursada().getModelCursadas().setColumnIdentifiers(this.vista.getPanelCursada().getNombreColumnas());
		clearTextBoxPanelCursadas();

		this.cursadasLista = modelo.obtenerCursadasCompletas();
		for (CursadaCompletaDTO cursadaCompletaDTO : cursadasLista) {
			Object[] fila = {cursadaCompletaDTO.getIdCursada(),
							 cursadaCompletaDTO.getIdEmpresa(),
					         cursadaCompletaDTO.getIdCurso(),
					         cursadaCompletaDTO.getIdSala(),
					         cursadaCompletaDTO.getIdEstadoCurso(),
					         cursadaCompletaDTO.getCurso(),
					         cursadaCompletaDTO.getEmpresa(),
					         stringDateFormatter(cursadaCompletaDTO.getFechaInicioInscripcion()),
					         stringDateFormatter(cursadaCompletaDTO.getFechaFinInscripcion()),
					         cursadaCompletaDTO.getEstadoCurso(),
							 cursadaCompletaDTO.getVacantes(),							 
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
					Object fechaInicioInscripcion = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 7);
					Object fechaFinInscripcion = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 8);
					Object vacantes = this.vista.getPanelCursada().getTblCursadas().getValueAt(this.vista.getPanelCursada().getTblCursadas().getSelectedRow(), 10);
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
					
					actualizarTablaAlumnosInscriptos();
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getPanelCursada().getTblCursadas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	private void clearTextBoxPanelCursadas() {
		this.vista.getPanelCursada().getCbxEmpresa().setSelectedItem(new EmpresaDTO(0, "", "", ""));
		this.vista.getPanelCursada().getCbxCurso().setSelectedItem(new CursoDTO(0, 0, "", "", ""));
		this.vista.getPanelCursada().getCbxSala().setSelectedItem(new SalaDTO(0, "", 0, 0, ""));
		this.vista.getPanelCursada().getCbxEstado().setSelectedItem(new EstadoDeCursoDTO(0, ""));
		this.vista.getPanelCursada().getTextFechaInicioInsc().setText("");
		this.vista.getPanelCursada().getTextFechaFinInsc().setText("");
		this.vista.getPanelCursada().getTextVacantes().setText("");
		this.vista.getPanelCursada().getTextIdCursada().setText("");
	}
	
	private void clearTextBoxPanelInscriptos() {
		this.vista.getPanelInscriptos().getTextIdAlumno().setText("");
		this.vista.getPanelInscriptos().getTextIdCursada().setText("");
		this.vista.getPanelInscriptos().getTextNombre().setText("");
		this.vista.getPanelInscriptos().getTextApellido().setText("");
		this.vista.getPanelInscriptos().getTextTelefono().setText("");
		this.vista.getPanelInscriptos().getTextEmail().setText("");
		this.vista.getPanelInscriptos().getTextFecha().setText("");
	}
	
	private String stringDateFormatter(LocalDateTime fecha) {		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatDateTime = fecha.format(formatter);
        return formatDateTime;
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
		if (e.getSource() == this.vista.getPanelCursada().getBtnAgregar()) {
			agregarCursada();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnActualizar()) {
			editarCursada();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnEliminar()) {
			eliminarCursada();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnAddAlumnos()) {
			try {
				panel = new AlumnoParaInscribirModalPanel();
				addAlumno =new AlumnoParaInscribirControlador(panel, modelo);
				addAlumno.getBtnAddAlumno().addActionListener(this);
				addAlumno.inicializar();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnAddPagos()) {
			clearTextBoxPanelCursadas();
		} else if (e.getSource() == this.vista.getPanelCursada().getBtnAddHorariosCursada()) {			
			
		} else if (e.getSource() == this.vista.getPanelInscriptos().getBtnEliminar()) {
			eliminarAlumnoInscripto();
		} else if (e.getSource() == addAlumno.getBtnAddAlumno()) {
			inscribirAlumnoCursada();
		}
	}
	
	private void inscribirAlumnoCursada() {
		AlumnoDTO alumno = addAlumno.getAlumnoParaInscrir();
		    //Long.parseLong(this.vista.getPanelCursada().getTextIdCursada().getText().toString()
		System.out.println(this.vista.getPanelCursada().getTextIdCursada().getText().toString()+" IDDDDDDDDDDDD");
		InscriptoDTO inscriptoDTO = new InscriptoDTO(alumno.getIdAlumno(), 
													 Long.parseLong(this.vista.getPanelCursada().getTextIdCursada().getText().toString()), 
													 LocalDateTime.now());
		modelo.agregarInscripto(inscriptoDTO);
		llenarTablaInscriptos();
	}

	private void eliminarAlumnoInscripto() {
		LocalDateTime fechaInscripcion = StringToLocalDateTime(this.vista.getPanelInscriptos().getTextFecha().getText());
		InscriptoDTO inscripto = new InscriptoDTO(Long.parseLong(this.vista.getPanelInscriptos().getTextIdAlumno().getText().toString()), 
												  Long.parseLong(this.vista.getPanelInscriptos().getTextIdCursada().getText().toString()), 
												  fechaInscripcion);
		modelo.borrarInscripto(inscripto);
		actualizarTablaAlumnosInscriptos();
	}

	private void actualizarTablaAlumnosInscriptos() {
		EmpresaDTO empresa = (EmpresaDTO) this.vista.getPanelCursada().getCbxEmpresa().getSelectedItem();
		CursoDTO curso = (CursoDTO) this.vista.getPanelCursada().getCbxCurso().getSelectedItem();
		SalaDTO sala = (SalaDTO) this.vista.getPanelCursada().getCbxSala().getSelectedItem();
		EstadoDeCursoDTO estadoDeCurso = (EstadoDeCursoDTO) this.vista.getPanelCursada().getCbxEstado().getSelectedItem();

		
		LocalDateTime fechaInicioInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaInicioInsc().getText());
		LocalDateTime fechaFinInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaFinInsc().getText());
		cursadaActual = new CursadaDTO(Long.parseLong(this.vista.getPanelCursada().getTextIdCursada().getText().toString()),
								empresa.getIdEmpresa(), 
								curso.getIdCurso(), 
								sala.getIdSala(), 
								estadoDeCurso.getIdEstadoDeCurso(),
								fechaInicioInscripcion, 
								fechaFinInscripcion, 
								this.vista.getPanelCursada().getTextVacantes().getText());

		llenarTablaInscriptos();
	}

	private void agregarCursada() {

		EmpresaDTO empresa = (EmpresaDTO) this.vista.getPanelCursada().getCbxEmpresa().getSelectedItem();
		CursoDTO curso = (CursoDTO) this.vista.getPanelCursada().getCbxCurso().getSelectedItem();
		SalaDTO sala = (SalaDTO) this.vista.getPanelCursada().getCbxSala().getSelectedItem();
		EstadoDeCursoDTO estadoDeCurso = (EstadoDeCursoDTO) this.vista.getPanelCursada().getCbxEstado().getSelectedItem();

		LocalDateTime fechaInicioInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaInicioInsc().getText());
		LocalDateTime fechaFinInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaFinInsc().getText());
		CursadaDTO cursadaDTO = new CursadaDTO(0, 
											   empresa.getIdEmpresa(), 
											   curso.getIdCurso(), 
											   sala.getIdSala(), 
											   estadoDeCurso.getIdEstadoDeCurso(), 
											   fechaInicioInscripcion,
											   fechaFinInscripcion,
											   this.vista.getPanelCursada().getTextVacantes().getText());
		this.modelo.agregarCursada(cursadaDTO);
		llenarTablaCursadas();
	}
	
	private void editarCursada() {
		
		EmpresaDTO empresa = (EmpresaDTO) this.vista.getPanelCursada().getCbxEmpresa().getSelectedItem();
		CursoDTO curso = (CursoDTO) this.vista.getPanelCursada().getCbxCurso().getSelectedItem();
		SalaDTO sala = (SalaDTO) this.vista.getPanelCursada().getCbxSala().getSelectedItem();
		EstadoDeCursoDTO estadoDeCurso = (EstadoDeCursoDTO) this.vista.getPanelCursada().getCbxEstado().getSelectedItem();

		LocalDateTime fechaInicioInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaInicioInsc().getText());
		LocalDateTime fechaFinInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaFinInsc().getText());
		CursadaDTO cursadaDTO = new CursadaDTO(Long.parseLong(this.vista.getPanelCursada().getTextIdCursada().getText().toString()), 
											   empresa.getIdEmpresa(), 
											   curso.getIdCurso(), 
											   sala.getIdSala(), 
											   estadoDeCurso.getIdEstadoDeCurso(), 
											   fechaInicioInscripcion,
											   fechaFinInscripcion,
											   this.vista.getPanelCursada().getTextVacantes().getText());
		this.modelo.actualizarCursada(cursadaDTO);
		llenarTablaCursadas();
	}
	
	private void eliminarCursada() {
		
		EmpresaDTO empresa = (EmpresaDTO) this.vista.getPanelCursada().getCbxEmpresa().getSelectedItem();
		CursoDTO curso = (CursoDTO) this.vista.getPanelCursada().getCbxCurso().getSelectedItem();
		SalaDTO sala = (SalaDTO) this.vista.getPanelCursada().getCbxSala().getSelectedItem();
		EstadoDeCursoDTO estadoDeCurso = (EstadoDeCursoDTO) this.vista.getPanelCursada().getCbxEstado().getSelectedItem();

		LocalDateTime fechaInicioInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaInicioInsc().getText());
		LocalDateTime fechaFinInscripcion = StringToLocalDateTime(this.vista.getPanelCursada().getTextFechaFinInsc().getText());
		CursadaDTO cursadaDTO = new CursadaDTO(Long.parseLong(this.vista.getPanelCursada().getTextIdCursada().getText().toString()), 
											   empresa.getIdEmpresa(), 
											   curso.getIdCurso(), 
											   sala.getIdSala(), 
											   estadoDeCurso.getIdEstadoDeCurso(), 
											   fechaInicioInscripcion,
											   fechaFinInscripcion,
											   this.vista.getPanelCursada().getTextVacantes().getText());
		this.modelo.borrarCursada(cursadaDTO);
		llenarTablaCursadas();
	}

	private LocalDateTime StringToLocalDateTime(String fecha) {
		String date = fecha + " 00:00:00";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format);
		return dateTime;
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
