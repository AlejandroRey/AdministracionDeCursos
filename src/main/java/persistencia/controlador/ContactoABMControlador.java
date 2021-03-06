package persistencia.controlador;

import herramientas.OptionPanel;
import herramientas.Validator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoDTO;
import dto.ContactoCompletoDTO;
import dto.ContactoDTO;
import dto.CursoDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.ContactoABMPanel;
import presentacion.vista.ContactoAlumnoDialog;
import presentacion.vista.ContactoTareaDialog;
import presentacion.vista.TareaABMPanel;

public class ContactoABMControlador implements ActionListener {
	private ContactoABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<ContactoCompletoDTO> contactosLista;
	private List<CursoDTO> cursoLista;
	private AlumnoDTO alumnoSeleccionado;
	private ContactoDTO currentContacto;
	private UsuarioDTO currentAdministrativo;
	private Validator validator;
	private TareaABMPanel panelTarea;
	private ContactoTareaDialog dialog;
	private ContactoTareaControlador ctr;

	public ContactoABMControlador(ContactoABMPanel vista, AdministracionDeCursos modelo) {

		this.vista = vista;
		this.modelo = modelo;
		this.contactosLista = null;
		this.cursoLista = null;
		this.alumnoSeleccionado = null;
		this.currentContacto = null;
		this.validator = new Validator();
		this.panelTarea = null;
		this.dialog = null;
		this.ctr = null;
		this.currentAdministrativo = modelo.getUsuarioLogueado();
		
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnSeleccionarAlumno().addActionListener(this);
	}

	public void inicializar() {
		loadComboBoxCursos();
		llenarTabla();
	}

	private void llenarTabla() {
		clearTable();
		clearTextInputsBox();
		cargarDatos();
		agregarListener();
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblContactos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private void clearTable() {
		this.vista.getModelContactos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelContactos().setColumnCount(0);
		this.vista.getModelContactos().setColumnIdentifiers(this.vista.getNombreColumnas());
	}

	private void cargarDatos() {
		this.contactosLista = modelo.obtenerContactosCompletos();
		for (ContactoCompletoDTO contactoDTO : contactosLista) {
			Object[] fila = { contactoDTO.getContacto().getIdContacto(), contactoDTO.getContacto().getIdAlumno(),
					contactoDTO.getContacto().getIdAdministrativo(), contactoDTO.getContacto().getIdCurso(),
					contactoDTO.getCurso(), contactoDTO.getAlumno().getNombre(), contactoDTO.getAlumno().getApellido(),
					contactoDTO.getContacto().getDescripcion(), contactoDTO.getAlumno().getTelefono(),
					contactoDTO.getAlumno().getEmail(),
					stringToLocalDateFormatter(contactoDTO.getContacto().getFechaCreacion(), "dd/MM/yyyy"),
					stringToLocalDateFormatter(contactoDTO.getContacto().getFechaCreacion(), "HH:mm:ss"),
					stringToLocalDateFormatter(contactoDTO.getContacto().getFechaContactar(), "dd/MM/yyyy"),
					stringToLocalDateFormatter(contactoDTO.getContacto().getFechaContactar(), "HH:mm:ss"),
					contactoDTO.getApellidoAdministrativo(), contactoDTO.getNombreAdministrativo(),
					contactoDTO.getContacto().getEstado(), contactoDTO.getContacto().getIdTarea() };
			this.vista.getModelContactos().addRow(fila);
		}
		ocultarColumnas();
	}

	private void ocultarColumnas() {
		ocultarColumna(this.vista.getTblContactos(), 0);
		ocultarColumna(this.vista.getTblContactos(), 1);
		ocultarColumna(this.vista.getTblContactos(), 2);
		ocultarColumna(this.vista.getTblContactos(), 3);
		ocultarColumna(this.vista.getTblContactos(), 11);
		ocultarColumna(this.vista.getTblContactos(), 13);
		ocultarColumna(this.vista.getTblContactos(), 14);
		ocultarColumna(this.vista.getTblContactos(), 15);
		ocultarColumna(this.vista.getTblContactos(), 16);
		ocultarColumna(this.vista.getTblContactos(), 17);
	}

	private void ocultarColumna(JTable table, int column) {
		table.getColumnModel().getColumn(column).setWidth(0);
		table.getColumnModel().getColumn(column).setMinWidth(0);
		table.getColumnModel().getColumn(column).setMaxWidth(0);
	}

	private void agregarListener() {
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblContactos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblContactos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblContactos().getSelectedRow() >= 0) {

					Object idContacto = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 0);
					Object idAlumno = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 1);
					Object idAdministrativo = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 2);
					Object idCurso = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 3);
					Object nombre = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 5);
					Object apellido = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 6);
					Object descripcion = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 7);
					Object telefono = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 8);
					Object email = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 9);
					Object fechaCreacion = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 10);
					Object horaContacto = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 11);
					Object fechaAccion = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 12);
					Object horaProximoContacto = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 13);
					Object estado = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 16);
					Object idTarea = this.vista.getTblContactos()
							.getValueAt(this.vista.getTblContactos().getSelectedRow(), 17);

					this.vista.getTxtIDContacto().setText(idContacto.toString());
					this.vista.getTxtIDAlumno().setText(idAlumno.toString());
					this.vista.getTxtIDAdministrativo().setText(idAdministrativo.toString());
					this.vista.getTxtIDCurso().setText(idCurso.toString());
					this.vista.getTxtNombre().setText(nombre.toString());
					this.vista.getTxtApellido().setText(apellido.toString());
					;
					this.vista.getTxtDescripcion().setText(descripcion.toString());
					this.vista.getTxtTelefono().setText(telefono.toString());
					this.vista.getTxtEmail().setText(email.toString());
					this.vista.getTxtProximoContacto().setText(fechaAccion.toString());
					selectCurso(Long.parseLong(idCurso.toString()));
					this.vista.getTxtIDTarea().setText(idTarea.toString());
					ContactoDTO contacto = new ContactoDTO(Long.parseLong(idContacto.toString()),
							Long.parseLong(idAlumno.toString()), Long.parseLong(idAdministrativo.toString()),
							Long.parseLong(idTarea.toString()), Long.parseLong(idCurso.toString()),
							descripcion.toString(),
							StringToLocalDateTime(fechaAccion.toString(), horaProximoContacto.toString()),
							StringToLocalDateTime(fechaCreacion.toString(), horaContacto.toString()),
							Integer.parseInt(estado.toString()));
					setCurrentContacto(contacto);
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});
	}

	private void selectCurso(long idCurso) {
		List<CursoDTO> cursos = this.cursoLista.stream().filter(curso -> curso.getIdCurso() == idCurso)
				.collect(Collectors.toList());
		this.vista.getComboBoxCursoDeInteres().setSelectedItem(cursos.get(0));
	}

	private void loadComboBoxCursos() {
		this.cursoLista = modelo.obtenerCursos();
		this.vista.getComboBoxCursoDeInteres().addItem(new CursoDTO(0, 0, "", "", ""));
		for (CursoDTO cursoDTO : cursoLista) {
			this.vista.getComboBoxCursoDeInteres().addItem(cursoDTO);
		}
	}

	private void clearTextInputsBox() {
		this.vista.getTxtIDContacto().setText("");
		this.vista.getTxtIDAlumno().setText("");
		this.vista.getTxtIDAdministrativo().setText("");
		this.vista.getTxtIDTarea().setText("");
		this.vista.getTxtIDCurso().setText("");
		this.vista.getTxtNombre().setText("");
		this.vista.getTxtApellido().setText("");
		this.vista.getTxtDescripcion().setText("");
		this.vista.getTxtTelefono().setText("");
		this.vista.getTxtEmail().setText("");
		this.vista.getTxtProximoContacto().setText("");
		this.vista.getComboBoxCursoDeInteres().setSelectedItem(new CursoDTO(0, 0, "", "", ""));
	}

	public void setCurrentContacto(ContactoDTO contacto) {
		this.currentContacto = null;
		this.currentContacto = contacto;
	}

	public void setVisibleBtnActualizar() {
		this.vista.getTblContactos().setEnabled(true);
		llenarTabla();
		setBtnNotVisible();
		setDataAlumnoNotEnabled();
		setDateEnabled();
		this.vista.getBtnActualizar().setVisible(true);
		this.vista.getBtnSeleccionarAlumno().setVisible(true);
	}

	public void setVisibleBtnAgregar() {
		this.vista.getTblContactos().setEnabled(false);
		llenarTabla();
		setBtnNotVisible();
		setDataAlumnoNotEnabled();
		setDateEnabled();
		this.vista.getBtnAgregar().setVisible(true);
		this.vista.getBtnSeleccionarAlumno().setVisible(true);
	}

	public void setVisibleBtnEliminar() {
		this.vista.getTblContactos().setEnabled(true);
		llenarTabla();
		setBtnNotVisible();
		setDataAlumnoNotEnabled();
		setDateNotEnabled();
		this.vista.getBtnEliminar().setVisible(true);
	}

	public void setVisibleBtnSeleccionar() {
		this.vista.getTblContactos().setEnabled(true);
		llenarTabla();
		setBtnNotVisible();
		setDataAlumnoNotEnabled();
		setDateNotEnabled();
		this.vista.getBtnSeleccionar().setVisible(true);
	}

	private void setDataAlumnoNotEnabled() {
		this.vista.getTxtNombre().setEditable(false);
		this.vista.getTxtApellido().setEditable(false);
		this.vista.getTxtTelefono().setEditable(false);
		this.vista.getTxtEmail().setEditable(false);
	}

	private void setDateNotEnabled() {
		this.vista.getTxtDescripcion().setEditable(false);
		this.vista.getTxtProximoContacto().setEditable(false);
		this.vista.getComboBoxCursoDeInteres().setEnabled(false);
	}

	private void setDateEnabled() {
		this.vista.getTxtDescripcion().setEditable(true);
		this.vista.getTxtProximoContacto().setEditable(true);
		this.vista.getComboBoxCursoDeInteres().setEnabled(true);
	}

	public void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
		this.vista.getBtnSeleccionar().setVisible(false);
		this.vista.getBtnSeleccionarAlumno().setVisible(false);
	}

	public void setAlumnoSeleccionado(AlumnoDTO alumno) {
		alumnoSeleccionado = alumno;
		if (alumnoSeleccionado != null) {
			this.vista.getTxtNombre().setText(alumnoSeleccionado.getNombre());
			this.vista.getTxtApellido().setText(alumnoSeleccionado.getApellido());
			this.vista.getTxtTelefono().setText(alumnoSeleccionado.getTelefono());
			this.vista.getTxtEmail().setText(alumnoSeleccionado.getEmail());
			this.vista.getTxtIDAlumno().setText(Long.toString(alumnoSeleccionado.getIdAlumno()));
		}
	}

	private String stringToLocalDateFormatter(LocalDateTime fecha, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}

	private LocalDateTime StringToLocalDateTime(String fecha, String hora) {
		String date = fecha + " " + hora;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format);
		return dateTime;
	}

	private void resetContactoTarea() {
		this.panelTarea = null;
		this.dialog = null;
		this.ctr = null;

	}

	// ********************************ACCIONES***************************************//
	private void abrirSeleccionarAlumno() {
		ContactoAlumnoDialog contactoAlumnodialog = new ContactoAlumnoDialog();
		ContactoAlumnoControlador ctr = new ContactoAlumnoControlador(contactoAlumnodialog, modelo, this);
		ctr.inicializar();
	}

	private void agregarContacto() {
		if (datosValidos()) {
			CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();
			System.out.println(Long.parseLong(vista.getTxtIDAlumno().getText()));
			ContactoDTO contacto = new ContactoDTO(0, Long.parseLong(vista.getTxtIDAlumno().getText()), 
					currentAdministrativo.getIdUsuario(),
					curso.getIdCurso(), this.vista.getTxtDescripcion().getText(),
					StringToLocalDateTime(this.vista.getTxtProximoContacto().getText(), "00:00:00"),
					LocalDateTime.now(), 1);
			this.setCurrentContacto(contacto);
			OptionPanel.mensaje("El contacto se creado correctamente", "Contacto creado");
			int generarTarea = OptionPanel.confimarcion("¿Desea generar una tarea en base a este contacto?",
					"Generar Tarea");
			if (generarTarea == 0) {
				panelTarea = new TareaABMPanel();
				dialog = new ContactoTareaDialog();
				dialog.setContactoTareaPanel(panelTarea);
				ctr = new ContactoTareaControlador(dialog, modelo, this);
				ctr.setContacto(contacto);
				ctr.inicializar();
			}
			resetContactoTarea();
			this.modelo.agregarContacto(this.currentContacto);
			llenarTabla();
		}
	}

	private void eliminarContacto() {
		if (hayTareaSeleccionada()) {
			if (datosValidos()) {
				int eliminar = OptionPanel.confimarcion("¿Estas seguro que deseas eliminar el contacto?",
						"Eliminar contacto");
				if (eliminar == 0) {
					ContactoDTO contacto = currentContacto;
					System.out.println(contacto.getIdContacto());
					this.modelo.borrarContacto(contacto);
					llenarTabla();
					OptionPanel.mensaje("Los cambios se han realizado correctamente", "Actualizar contacto");
				}
			}
		}
	}

	private void actualizarContacto() {
		if (hayTareaSeleccionada()) {
			if (datosValidos()) {
				int actualizar = OptionPanel.confimarcion("¿Estas seguro que deseas cambiar los datos del contacto?",
						"Cambiar datos del contacto");
				if (actualizar == 0) {
					CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();
					ContactoDTO contacto = new ContactoDTO(Long.parseLong(vista.getTxtIDContacto().getText()),
							Long.parseLong(vista.getTxtIDAlumno().getText()), currentContacto.getIdAdministrativo(),
							curso.getIdCurso(), this.vista.getTxtDescripcion().getText(),
							StringToLocalDateTime(this.vista.getTxtProximoContacto().getText(), "00:00:00"),
							currentContacto.getFechaCreacion(), currentContacto.getEstado());
					this.modelo.actualizarContacto(contacto);
					llenarTabla();
					OptionPanel.mensaje("Los cambios se han realizado correctamente", "Actualizar contacto");
				}
			}
		}
	}

	// ******************************VALIDACIONES*********************************************//

	private boolean hayTareaSeleccionada() {
		boolean tareaSeleccionada = true;
		String tarea = this.vista.getTxtIDContacto().getText();
		if (estaVacio(tarea)) {
			OptionPanel.error("No hay ningun contacto seleccionado", "Seleccionar contacto");
			tareaSeleccionada = false;
		}
		return tareaSeleccionada;
	}

	private boolean datosValidos() {
		boolean camposValidos = true;

		String idAlumno = this.vista.getTxtIDAlumno().getText();
		String fecha = this.vista.getTxtProximoContacto().getText();
		String descripcion = this.vista.getTxtDescripcion().getText();
		CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();

		if (estaVacio(idAlumno) & estaVacio(fecha) & estaVacio(descripcion)) {
			OptionPanel.error("Los campos estan vacios", "Campos vacios");
			camposValidos = false;
		} else if (estaVacio(idAlumno)) {
			OptionPanel.error("Usted no ha seleccionado un alumno, por favor, agregue uno", "Error");
			camposValidos = false;
		} else if (!validator.fechaValida(fecha)) {
			OptionPanel.error("Fecha incorrecta. Por favor, completar correctamente la fecha", "Error");
			camposValidos = false;
		} else if (estaVacio(descripcion)) {
			OptionPanel.error("Por favor, agregue una descripcion.", "Error");
			camposValidos = false;
		} else if (curso.getIdCurso() <= 0) {
			OptionPanel.error("Por favor, seleccione curso de interes.", "Error");
			camposValidos = false;
		} else {
			camposValidos = true;
		}

		return camposValidos;
	}

	public boolean estaVacio(String valor) {
		return valor.trim().equals("");
	}

	// ******************************LISTENERS******************************//

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnActualizar()) {
			actualizarContacto();
		} else if (e.getSource() == this.vista.getBtnAgregar()) {
			agregarContacto();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			eliminarContacto();
		} else if (e.getSource() == this.vista.getBtnSeleccionar()) {
			llenarTabla();
		} else if (e.getSource() == this.vista.getBtnSeleccionarAlumno()) {
			abrirSeleccionarAlumno();
		}
	}
}
