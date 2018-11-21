package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import com.mxrck.autocompleter.TextAutoCompleter;

import dto.CursadaCompletaDTO;
import dto.CursadaDTO;
import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CursadaABMPanel;
import presentacion.vista.UsuarioModalPanel;

public class CursadaABMControlador implements ActionListener {
	
	private CursadaABMPanel vista;
	private CursadaABMVistaPrincipalControlador vistaPrincipalControlador;
	private AdministracionDeCursos modelo;
	
	private List<CursadaCompletaDTO> cursadasLista;
	
	private List<EmpresaDTO> empresasLista;
	private List<CursoDTO> cursosLista;
	private List<EstadoDeCursoDTO> estadosCurso;
	private List<UsuarioDTO> usuariosLista;
	private List<UsuarioDTO> listaTemporalUsuarios;
	
	private UsuarioModalPanel usuarioModalPanel;
	private UsuarioModalControlador usuarioModalControlador;
	
	public CursadaABMControlador(CursadaABMPanel vista, CursadaABMVistaPrincipalControlador vistaPrincipalControlador, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.vistaPrincipalControlador = vistaPrincipalControlador;
		this.modelo = modelo;
		this.usuariosLista = modelo.obtenerUsuarios();
		
		
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnAgregarAdministrativo().addActionListener(this);
		this.vista.getTextFieldInstructor().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				listaTemporalUsuarios = new ArrayList<UsuarioDTO>();
//				usuariosLista.stream()
//						.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTextFieldInstructor().getText()))
//						.filter(UsuarioDTO -> UsuarioDTO.getIdCategoria() == 3)
//						.collect(Collectors.toList());
				
				try {
					listaTemporalUsuarios.add(usuariosLista.stream()
							.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTextFieldInstructor().getText()) && UsuarioDTO.getIdCategoria() == 3)
							.collect(Collectors.toList()).get(0));
					System.out.println(usuariosLista.stream()
					.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTextFieldInstructor().getText()) && UsuarioDTO.getIdCategoria() == 3)
					.collect(Collectors.toList()).get(0));
					listaTemporalUsuarios.add(usuariosLista.stream()
							.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTextFieldInstructor().getText()) && UsuarioDTO.getIdCategoria() == 3)
							.collect(Collectors.toList()).get(1));
					listaTemporalUsuarios.add(usuariosLista.stream()
							.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTextFieldInstructor().getText()) && UsuarioDTO.getIdCategoria() == 3)
							.collect(Collectors.toList()).get(2));
				} catch (Exception e2) {
				}

		//		 System.out.println(listaTemporalUsuarios.toString());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
						
		});
		
		TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(this.vista.getTextFieldInstructor());
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			textAutoAcompleter.addItem(usuarioDTO.getUsuario());
		}
		
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
		filtrarPorInstructor();
//		for (CursadaCompletaDTO cursadaCompletaDTO : cursadasLista) {
//			controlarEstadoCursada(cursadaCompletaDTO);
//		}
		
		//this.cursadasLista = modelo.obtenerCursadasCompletas();
		for (CursadaCompletaDTO cursadaCompletaDTO : cursadasLista) {
			Object[] fila = {cursadaCompletaDTO.getIdCursada(),
							 cursadaCompletaDTO.getIdEmpresa(),
					         cursadaCompletaDTO.getIdCurso(),
					         cursadaCompletaDTO.getIdEstadoCurso(),
					         cursadaCompletaDTO.getIdAdministrativo(),
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
		this.vista.getTblCursadas().getColumnModel().getColumn(4).setWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(4).setMinWidth(0);
		this.vista.getTblCursadas().getColumnModel().getColumn(4).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblCursadas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblCursadas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblCursadas().getSelectedRow() >= 0) {	
//					"idCursada", "idEmpresa", "idCurso", "idEstadoCurso", "idAdministrativo","Curso", 
//					"Empresa", "Ini Inscrip", "Fin Inscrip", "EstadoCurso", "Vacantes", "Ini Cursada", "DiasDeClase"};
					
					Object idCursada = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 0);
					Object idEmpresa = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 1);
					Object idCurso = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 2);
					Object idEstadoCurso = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 3);
					Object idAdministrativo = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 4);
					Object curso = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 5);
					Object empresa = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 6);
					Object fechaInicioInscripcion = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 7);
					Object fechaFinInscripcion = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 8);
					Object esatdoCurso = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 9);
					Object vacantes = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 10);
					Object fechaInicioCursada = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 11);
					Object diasDeClase = this.vista.getTblCursadas().getValueAt(this.vista.getTblCursadas().getSelectedRow(), 12);
					
					
					this.vista.getCbxEmpresa().setSelectedItem(selectEmpresa(idEmpresa));
					this.vista.getCbxCurso().setSelectedItem(selectCurso(idCurso));
					this.vista.getCbxEstado().setSelectedItem(selectEstadoDeCurso(idEstadoCurso));
					this.vista.getTextVacantes().setText(vacantes.toString());
					this.vista.getTextFechaInicioInsc().setText(fechaInicioInscripcion.toString());
					this.vista.getTextFechaFinInsc().setText(fechaFinInscripcion.toString());
					this.vista.getTextFechaInicioCursada().setText(fechaInicioCursada.toString());
					this.vista.getTextDiasDeClase().setText(diasDeClase.toString());
					this.vista.getTextIdCursada().setText(idCursada.toString());
					this.vista.getTextAdministrativo().setText(obtenerAdministrativo(Long.parseLong(idAdministrativo.toString())));
					this.vista.getTextidAdministrativo().setText(idAdministrativo.toString());
					
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblCursadas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		filtrarPorInstructor();
	}
	
	private void filtrarPorInstructor() {
		if(this.modelo.getUsuarioLogueado().getIdCategoria()==3) {
			this.cursadasLista = cursadasLista.stream().filter(cursada -> cursada.getIdInstructor()==this.modelo.getUsuarioLogueado().getIdUsuario()).collect(Collectors.toList());
		}
	}
	
	private String obtenerAdministrativo(long idUsuario) {
		String strUsuario = "";
		for (UsuarioDTO usuarioDTO : modelo.obtenerUsuarios()) {
			if (idUsuario == usuarioDTO.getIdUsuario()) {
				strUsuario = usuarioDTO.getNombre() + " " + usuarioDTO.getApellido();
				return strUsuario;
			}
		}
		return strUsuario;
	}

	private boolean controlarEstadoCursada(CursadaCompletaDTO cursadaCompletaDTO) {
		LocalDate fechaActual = LocalDateTime.now().toLocalDate();
		LocalDate fechaInicioInscripcion = cursadaCompletaDTO.getFechaInicioInscripcion().toLocalDate();
		LocalDate fechaFinInscripcion = cursadaCompletaDTO.getFechaFinInscripcion().toLocalDate();
		LocalDate fechaInicioCursada = cursadaCompletaDTO.getFechaInicioCursada().toLocalDate();
		
		System.out.println(fechaActual);
		System.out.println(fechaInicioInscripcion);
		System.out.println(fechaFinInscripcion);
		System.out.println(fechaInicioCursada);
		
		System.out.println("Dif1 = " + fechaActual.compareTo(fechaInicioInscripcion));
		System.out.println("Dif2 = " + fechaActual.compareTo(fechaFinInscripcion));
		
		System.out.println("Dif3 = " + fechaActual.compareTo(fechaInicioCursada));
		System.out.println("Dif4 = " + fechaActual.compareTo(fechaInicioCursada));
		
		CursadaDTO cursadaDTO = new CursadaDTO(cursadaCompletaDTO.getIdCursada(), 
				cursadaCompletaDTO.getIdEmpresa(), 
				cursadaCompletaDTO.getIdCurso(), 
				cursadaCompletaDTO.getIdEstadoCurso(), 
				cursadaCompletaDTO.getIdAdministrativo(),
				cursadaCompletaDTO.getIdInstructor(),
				cursadaCompletaDTO.getFechaInicioInscripcion(), 
				cursadaCompletaDTO.getFechaFinInscripcion(), 
				cursadaCompletaDTO.getVacantes(), 
				cursadaCompletaDTO.getFechaInicioCursada(), 
				cursadaCompletaDTO.getDiasDeClase());
		
        if (fechaActual.compareTo(fechaInicioInscripcion) >= 0 && fechaActual.compareTo(fechaFinInscripcion) <= 0) {
            System.out.println("Periodo De Inscripcion Abierto");
            cursadaDTO.setIdEstadoCurso(1);
            modelo.actualizarCursada(cursadaDTO);
        } else if (fechaActual.compareTo(fechaInicioCursada) >= 0 && cursadaCompletaDTO.getIdEstadoCurso() != 3) {
        	System.out.println("Inicio laa Cursada!!!");
        	cursadaDTO.setIdEstadoCurso(2);
        	modelo.actualizarCursada(cursadaDTO);
        }		
		
		return false;
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
		this.vista.getTextAdministrativo().setText("");
		this.vista.getTextFieldInstructor().setText("");
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
		
		//TODO EL 4 ES UN INSTRUCTOR, AGREGARLO A LA VISTA Y OBTENERLO
		CursadaDTO cursadaDTO = new CursadaDTO(idTemp, 
											   empresa.getIdEmpresa(), 
											   curso.getIdCurso(), 
											   estadoDeCurso.getIdEstadoDeCurso(), 
											   Long.parseLong(this.vista.getTextidAdministrativo().getText()),
											   getIdUsuarioPara(this.vista.getTextFieldInstructor().getText()), fechaInicioInscripcion, 
											   fechaFinInscripcion, 
											   this.vista.getTextVacantes().getText(), 
											   fechaInicioCursada, 
											   Integer.parseInt(this.vista.getTextDiasDeClase().getText()));
	
		
		return cursadaDTO;
	}
	
	private long getIdUsuarioPara(String usuario) {
		long idUsuarioPara = 0;
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			if (usuarioDTO.getUsuario().equals(usuario)) {
				idUsuarioPara = usuarioDTO.getIdUsuario();
			}
		}
		return idUsuarioPara;
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
		
		if (e.getSource()== this.vista.getBtnSeleccionar() ) {
			CursadaDTO cursadaDTO = getCursadaDTO();
			String strCursadaDTO = cursadaDTOToString(cursadaDTO);
			
			//if(this.modelo.getUsuarioLogueado().getIdCategoria()==3) {
				//cursadaDTO.
			//}
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
		} else if (e.getSource() == this.vista.getBtnAgregarAdministrativo()) {
			if (usuarioModalPanel != null) {
				usuarioModalPanel = null;
				usuarioModalControlador = null;
			}

			usuarioModalPanel = new UsuarioModalPanel();
			usuarioModalControlador = new UsuarioModalControlador(modelo, this);
			usuarioModalControlador.inicializar();
		}
		
	}
	
	public void setAdminNoVisible() {
		this.vista.getLblAdmisitrativo().setVisible(false);
		this.vista.getTextAdministrativo().setVisible(false);
		this.vista.getBtnAgregarAdministrativo().setVisible(false);
	}
	
	public void setAdminVisible() {
		this.vista.getLblAdmisitrativo().setVisible(true);
		this.vista.getTextAdministrativo().setVisible(true);
		this.vista.getBtnAgregarAdministrativo().setVisible(true);
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
	
	@FunctionalInterface
	public interface SimpleDocumentListener extends DocumentListener {
	    void update(DocumentEvent e);

	    @Override
	    default void insertUpdate(DocumentEvent e) {
	        update(e);
	    }
	    @Override
	    default void removeUpdate(DocumentEvent e) {
	        update(e);
	    }
	    @Override
	    default void changedUpdate(DocumentEvent e) {
	        update(e);
	    }
	}

	/**
	 * @return the vista
	 */
	public CursadaABMPanel getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(CursadaABMPanel vista) {
		this.vista = vista;
	}

	/**
	 * @return the vistaPrincipalControlador
	 */
	public CursadaABMVistaPrincipalControlador getVistaPrincipalControlador() {
		return vistaPrincipalControlador;
	}

	/**
	 * @param vistaPrincipalControlador the vistaPrincipalControlador to set
	 */
	public void setVistaPrincipalControlador(CursadaABMVistaPrincipalControlador vistaPrincipalControlador) {
		this.vistaPrincipalControlador = vistaPrincipalControlador;
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
	 * @return the cursadasLista
	 */
	public List<CursadaCompletaDTO> getCursadasLista() {
		return cursadasLista;
	}

	/**
	 * @param cursadasLista the cursadasLista to set
	 */
	public void setCursadasLista(List<CursadaCompletaDTO> cursadasLista) {
		this.cursadasLista = cursadasLista;
	}

	/**
	 * @return the empresasLista
	 */
	public List<EmpresaDTO> getEmpresasLista() {
		return empresasLista;
	}

	/**
	 * @param empresasLista the empresasLista to set
	 */
	public void setEmpresasLista(List<EmpresaDTO> empresasLista) {
		this.empresasLista = empresasLista;
	}

	/**
	 * @return the cursosLista
	 */
	public List<CursoDTO> getCursosLista() {
		return cursosLista;
	}

	/**
	 * @param cursosLista the cursosLista to set
	 */
	public void setCursosLista(List<CursoDTO> cursosLista) {
		this.cursosLista = cursosLista;
	}

	/**
	 * @return the estadosCurso
	 */
	public List<EstadoDeCursoDTO> getEstadosCurso() {
		return estadosCurso;
	}

	/**
	 * @param estadosCurso the estadosCurso to set
	 */
	public void setEstadosCurso(List<EstadoDeCursoDTO> estadosCurso) {
		this.estadosCurso = estadosCurso;
	}

	/**
	 * @return the usuarioModalPanel
	 */
	public UsuarioModalPanel getUsuarioModalPanel() {
		return usuarioModalPanel;
	}

	/**
	 * @param usuarioModalPanel the usuarioModalPanel to set
	 */
	public void setUsuarioModalPanel(UsuarioModalPanel usuarioModalPanel) {
		this.usuarioModalPanel = usuarioModalPanel;
	}

	/**
	 * @return the usuarioModalControlador
	 */
	public UsuarioModalControlador getUsuarioModalControlador() {
		return usuarioModalControlador;
	}

	/**
	 * @param usuarioModalControlador the usuarioModalControlador to set
	 */
	public void setUsuarioModalControlador(UsuarioModalControlador usuarioModalControlador) {
		this.usuarioModalControlador = usuarioModalControlador;
	}

}
