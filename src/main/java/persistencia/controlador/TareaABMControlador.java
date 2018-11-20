package persistencia.controlador;
import herramientas.OptionPanel;
import herramientas.Validator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import modelo.AdministracionDeCursos;
import dto.CategoriaDTO;
import dto.NotificacionDTO;
import dto.TareaDTO;
import dto.UsuarioDTO;
import presentacion.vista.ContactoABMPanel;
import presentacion.vista.ContactoTareaDialog;
import presentacion.vista.TareaABMPanel;

public class TareaABMControlador implements ActionListener{

	private TareaABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<TareaDTO> tareasLista;
	private List<UsuarioDTO> administrativosLista;
	private List<CategoriaDTO> categoriasLista;
	private UsuarioDTO currentAdministrativo;
	private Validator validator;
	private ContactoABMPanel panelContacto;
	private ContactoTareaDialog dialog;
	private TareaContactoControlador ctr;
	
	public TareaABMControlador(TareaABMPanel vista, AdministracionDeCursos modelo) {
		this.administrativosLista = null;
		this.categoriasLista = null;
		this.vista = vista;
		this.modelo = modelo;
		this.panelContacto = null;
		this.dialog = null;
		this.ctr = null;
		this.currentAdministrativo = this.modelo.getUsuarioLogueado();
		
		this.validator = new Validator();
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnSelecionarResponsable().addActionListener(this);
		this.vista.getBtnMarcarComoRealizada().addActionListener(this);
		this.vista.getCboxEstado().addActionListener(this);
		this.vista.getCboxTareas().addActionListener(this);

	}
	
	public void inicializar() {
		loadAdministrativosData();
		generarTablas();
	}
	
	public void llenarTabla() {
		clearTableTareas();
		clearTextInputsBox();
		this.tareasLista = modelo.obtenerTareas();
		loadDataRowsTbTareas();
		ocultarColumnasTbTareas();
		this.vista.getTableTareas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTableTareas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {seleccionarFila();});
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTableTareas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		filtro();
	}

	private void clearTableTareas() {
		this.vista.getModelTareas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelTareas().setColumnCount(0);
		this.vista.getModelTareas().setColumnIdentifiers(this.vista.getNombreColumnas());
	}

	private void loadDataRowsTbTareas() {
		for (TareaDTO tareaDTO : tareasLista) {
			Object[] fila = {tareaDTO.getIdTarea(),
							 tareaDTO.getNombre(),
							 tareaDTO.getDescripcion(),
							 tareaDTO.getEstado(),
							 getAdministrativoString(tareaDTO.getIdUsuario()), 
							 tareaDTO.getIdUsuario(),
							 StringToLocalDateFormatter(tareaDTO.getFechaCreacion(),"dd/MM/yyyy"),
							 StringToLocalDateFormatter(tareaDTO.getFechaCierre(),"dd/MM/yyyy"),
							 tareaDTO.getIdAlumno()};
			this.vista.getModelTareas().addRow(fila);
		}
	}

	private void llenarTablaAdministrativos() {
		clearTableAdministrativos();
		clearTextInputsBox();
		loadAdministrativosData();
		loadDataRowsTbAdministrativos();
		ocultarColumnasTbAdministrativos();
		this.vista.getTableAdministrativos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTableAdministrativos().getSelectionModel()
					                        .addListSelectionListener((ListSelectionEvent event) -> {seleccionarFilaAdministrativos();});
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTableAdministrativos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		this.deshabilitarTablaAdministrativos();
	}

	private void loadAdministrativosData() {
		this.administrativosLista = modelo.obtenerUsuarios();
		this.categoriasLista = modelo.obtenerCategorias();
		filtrarAdministrativos();
	}

	private void clearTableAdministrativos() {
		this.vista.getModelAdministrativos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAdministrativos().setColumnCount(0);
		this.vista.getModelAdministrativos().setColumnIdentifiers(this.vista.getNombreColumnasAdministrativos());
	}

	private void loadDataRowsTbAdministrativos() {
		for (UsuarioDTO usuarioDTO : administrativosLista) {
			Object[] fila = {usuarioDTO.getIdUsuario(),
							 usuarioDTO.getIdCategoria(),
							 getCategoriaString(usuarioDTO.getIdCategoria()),
							 usuarioDTO.getNombre(), 
							 usuarioDTO.getApellido(),
							 usuarioDTO.getTelefono(),
							 usuarioDTO.getEmail(),
							 usuarioDTO.getUsuario(),
							 usuarioDTO.getPassword()};
			this.vista.getModelAdministrativos().addRow(fila);
		}
	}
	
	private void ocultarColumnasTbTareas() {
		ocultarColumnaTbTareas(0);
		ocultarColumnaTbTareas(5);
		ocultarColumnaTbTareas(8);
	}
	
	private void ocultarColumnaTbTareas(int column) {
		this.vista.getTableTareas().getColumnModel().getColumn(column).setWidth(0);
		this.vista.getTableTareas().getColumnModel().getColumn(column).setMinWidth(0);
		this.vista.getTableTareas().getColumnModel().getColumn(column).setMaxWidth(0);
	}

	private void ocultarColumnasTbAdministrativos() {
		ocultarColumnaTbAdministrativos(1);
		ocultarColumnaTbAdministrativos(2);
		ocultarColumnaTbAdministrativos(5);
		ocultarColumnaTbAdministrativos(6);
		ocultarColumnaTbAdministrativos(7);
		ocultarColumnaTbAdministrativos(8);
	}
	
	private void ocultarColumnaTbAdministrativos(int column) {
		this.vista.getTableAdministrativos().getColumnModel().getColumn(column).setWidth(0);
		this.vista.getTableAdministrativos().getColumnModel().getColumn(column).setMinWidth(0);
		this.vista.getTableAdministrativos().getColumnModel().getColumn(column).setMaxWidth(0);
	}

	//************************Filtros*************************//
	
	private void filtrarAdministrativos() {
		this.administrativosLista = this.administrativosLista.stream()
				                    .filter(usuario -> usuario.getIdCategoria() == 2)//2 es administrativo
				                    .collect(Collectors.toList());
	}
	
	public void filtro() {
//		List<RowFilter> pendientesAndTodas = new LinkedList<RowFilter>();
//		List<RowFilter> realizadasAndTodas = new LinkedList<RowFilter>();
//		List<RowFilter> todasAndMisTareas = new LinkedList<RowFilter>();
		List<RowFilter<TableModel,Integer>> pendientesAndMisTareas = new LinkedList<RowFilter<TableModel,Integer>>();
		List<RowFilter<TableModel,Integer>> realizadasAndMisTareas = new LinkedList<RowFilter<TableModel,Integer>>();
		
		pendientesAndMisTareas.add(RowFilter.regexFilter("Pendiente", 3));
		pendientesAndMisTareas.add(RowFilter.regexFilter(Long.toString(this.currentAdministrativo.getIdUsuario(), 6)));
		
		realizadasAndMisTareas.add(RowFilter.regexFilter("Realizada", 3));
		realizadasAndMisTareas.add(RowFilter.regexFilter(Long.toString(this.currentAdministrativo.getIdUsuario(), 6)));
		
		RowFilter<TableModel, Integer> filtroPendientes = RowFilter.andFilter(pendientesAndMisTareas);
		RowFilter<TableModel,Integer> filtroRealizadas = RowFilter.andFilter(realizadasAndMisTareas);
		
        if(this.vista.getCboxEstado().getSelectedItem().toString() == "Pendientes" && this.vista.getCboxTareas().getSelectedItem().toString() == "Todas"){
        	this.vista.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("Pendiente", 3));
        }
        else if(this.vista.getCboxEstado().getSelectedItem().toString() == "Realizadas" && this.vista.getCboxTareas().getSelectedItem().toString() == "Todas"){
        	this.vista.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("Realizada", 3));
        }
        else if(this.vista.getCboxEstado().getSelectedItem().toString() == "Pendientes" && this.vista.getCboxTareas().getSelectedItem().toString() == "Mis tareas"){
        	this.vista.getModeloOrdenado().setRowFilter(filtroPendientes);
        }
        else if(this.vista.getCboxEstado().getSelectedItem().toString() == "Realizadas" && this.vista.getCboxTareas().getSelectedItem().toString() == "Mis tareas"){
        	this.vista.getModeloOrdenado().setRowFilter(filtroRealizadas);
        }
        else if(this.vista.getCboxEstado().getSelectedItem().toString() == "Todas" && this.vista.getCboxTareas().getSelectedItem().toString() == "Mis tareas"){
        	this.vista.getModeloOrdenado().setRowFilter(RowFilter.regexFilter(Long.toString(this.currentAdministrativo.getIdUsuario(), 6)));
        }
        else 
        	this.vista.getModeloOrdenado().setRowFilter(null);
    }

	
	//*********************************************************//
	
	private String getCategoriaString(long idCategoria) {
		String categoriaNombre = "";
		for (CategoriaDTO categoriaDTO : this.categoriasLista) {
			if (categoriaDTO.getIdCategoria() == idCategoria) {
				categoriaNombre = categoriaDTO.getNombre();
			}
		}
		return categoriaNombre;
	}
	
	private String getAdministrativoString(Long idAdministrativo) {
		String administrativoNombre = "";
		for (UsuarioDTO usuarioDTO : this.administrativosLista) {
			if (usuarioDTO.getIdUsuario() == idAdministrativo) {
				administrativoNombre = usuarioDTO.getNombre() + " " + usuarioDTO.getApellido();
			}
		}
		return administrativoNombre;
	}

	public void agregarTarea() {
		if(datosValidos()){
			TareaDTO tarea = new TareaDTO(0,
					Long.parseLong(this.vista.getTxtIDResponsable().getText()),
					Long.parseLong(this.vista.getTxtIDAlumno().getText()),
					this.vista.getTxtNombre().getText(),
					this.vista.getTxtAreaDescripcion().getText(),
					"Pendiente",
					LocalDateTime.now(),
					StringToLocalDateTime(this.vista.getTxtFecha().getText(),"00:00:00"),
					null);
			this.modelo.agregarTarea(tarea);
			NotificacionDTO notificacion = new NotificacionDTO(0, Long.parseLong(this.vista.getTxtIDResponsable().getText()),
					2, "Se te ha asignado una tarea. Revisa la sección Tareas", false, LocalDateTime.now());
			this.modelo.agregarNotificacion(notificacion);
			OptionPanel.mensaje("La tarea ha sido agregada correctamente", "Tarea");
			generarTablas();
		}
	}

	public void modificarTarea() {
		if(hayTareaSeleccionada()){
			if(datosValidos()){
				int actualizar = OptionPanel.confimarcion("Esta seguro que desea actualizar los datos de esta tarea?", "Actualizar tarea");
				if(actualizar == 0){
					TareaDTO tarea = new TareaDTO(Long.parseLong(this.vista.getTxtID().getText()),
							Long.parseLong(this.vista.getTxtIDResponsable().getText()),
							Long.parseLong(this.vista.getTxtIDAlumno().getText()),
							this.vista.getTxtNombre().getText(),
							this.vista.getTxtAreaDescripcion().getText(),
							this.vista.getTxtEstado().getText(),
							LocalDateTime.now(),
							StringToLocalDateTime(this.vista.getTxtFecha().getText(),"00:00:00"),
							null);
					this.modelo.actualizarTarea(tarea);
					NotificacionDTO notificacion = new NotificacionDTO(0, Long.parseLong(this.vista.getTxtIDResponsable().getText()),
							2, "Se te ha asignado una tarea. Revisa la sección Tareas", false, LocalDateTime.now());
					this.modelo.agregarNotificacion(notificacion);
					OptionPanel.mensaje("La tarea ha sido modificada correctamente", "Tarea");
					generarTablas();
				}
			}
		}
	}

	public void eliminarTarea() {
		if(hayTareaSeleccionada()){
			if(datosValidos()){
				int eliminar = OptionPanel.confimarcion("Esta seguro que desea eliminar esta tarea?", "Eliminar tarea");
				if(eliminar == 0){
					TareaDTO tarea = new TareaDTO(Long.parseLong(this.vista.getTxtID().getText()),
							Long.parseLong(this.vista.getTxtIDResponsable().getText()),
							Long.parseLong(null),
							this.vista.getTxtNombre().getText(),
							this.vista.getTxtAreaDescripcion().getText(),
							this.vista.getTxtEstado().getText(),
							LocalDateTime.now(),
							StringToLocalDateTime(this.vista.getTxtFecha().getText(),"00:00:00"),
							null);
					this.modelo.borrarTarea(tarea);
					OptionPanel.mensaje("La tarea ha sido eliminada correctamente", "Tarea");
					generarTablas();
				}
			}
		}
	}
	
	private void cerrarTarea() {
		if(hayTareaSeleccionada()){
			if(datosValidos()){
				int cerrar = OptionPanel.confimarcion("Esta seguro que desea cerrar esta tarea?", "Cerrar tarea");
				if(cerrar == 0){
					TareaDTO tarea = new TareaDTO(Long.parseLong(this.vista.getTxtID().getText()),
							Long.parseLong(this.vista.getTxtIDResponsable().getText()),
							Long.parseLong(this.vista.getTxtIDAlumno().getText()),
							this.vista.getTxtNombre().getText(),
							this.vista.getTxtAreaDescripcion().getText(),
							"Realizada",
							LocalDateTime.now(),
							StringToLocalDateTime(this.vista.getTxtFecha().getText(),"00:00:00"),
							LocalDateTime.now());
					this.modelo.actualizarTarea(tarea);
					OptionPanel.mensaje("La tarea ha sido cerrada correctamente", "Tarea");
					generarTablas();
					if(tarea.getIdTarea() > 0){
						if(OptionPanel.confimarcion("¿Desea generar un nuevo contacto?", "Generar Contacto") == 0){
							panelContacto = new ContactoABMPanel();
							dialog = new ContactoTareaDialog();
							dialog.setContactoTareaPanel(panelContacto);
							dialog.setContactoTareaPanel(panelContacto);
							dialog.setSize(1100, 700);
							ctr = new TareaContactoControlador(dialog, modelo,this);
							ctr.setTarea(tarea);
							ctr.inicializar();
						}
					}
				}
			}
		}
	}

	private void generarTablas() {
		llenarTabla();
		llenarTablaAdministrativos();
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTableTareas().setEnabled(true);
		generarTablas();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
		this.setVisibleBtnSeleccionarResponsable();
		this.setVisibleBtnMarcarComoRealizada();
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTableTareas().setEnabled(false);
		generarTablas();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
		this.setVisibleBtnSeleccionarResponsable();
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTableTareas().setEnabled(true);
		generarTablas();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	public void setVisibleBtnSeleccionarResponsable() {
		this.vista.getBtnSelecionarResponsable().setVisible(true);
	}
	
	public void setVisibleBtnMarcarComoRealizada() {
		this.vista.getBtnMarcarComoRealizada().setVisible(true);
	}
	
	private void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
		this.vista.getBtnSelecionarResponsable().setVisible(false);
		this.vista.getBtnMarcarComoRealizada().setVisible(false);
	}

	private void clearTextInputsBox() {
		this.vista.getTxtNombre().setText("");
		this.vista.getTxtResponsable().setText("");
		this.vista.getTxtAreaDescripcion().setText("");
		this.vista.getTxtFecha().setText("");
		this.vista.getTxtEstado().setText("");
		this.clearTextInputsBoxAux();
	}

	private void clearTextInputsBoxAux() {
		this.vista.getTxtID().setText("");
		this.vista.getTxtIDResponsable().setText("");
		this.vista.getTxtIDAlumno().setText("0");
	}
	
	public void clickSeleccionResponsable() {
		habilitarTablaAdministrativos();
	}
	
	public void habilitarTablaAdministrativos(){
		this.vista.getSpAdministrativos().setEnabled(true);
		this.vista.getSpAdministrativos().setOpaque(true);
		this.vista.getTableAdministrativos().setEnabled(true);
		this.vista.getTableAdministrativos().setOpaque(true);
	}
	
	public void deshabilitarTablaAdministrativos() {
		this.vista.getSpAdministrativos().setEnabled(false);
		this.vista.getSpAdministrativos().setOpaque(false);
		this.vista.getTableAdministrativos().setEnabled(false);
		this.vista.getTableAdministrativos().setOpaque(true);
	}
	
	private String StringToLocalDateFormatter(LocalDateTime fecha, String pattern) {
		String formatDateTime = "";
		if(fecha!=null){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			formatDateTime = fecha.format(formatter);
		}
		return formatDateTime;
	}
	
	private LocalDateTime StringToLocalDateTime(String fecha, String hora) {
		String date = fecha + " " + hora;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format); 
		return dateTime;
	}

	private void seleccionarFila() {
		try {
			if (this.vista.getTableTareas().getSelectedRow() >= 0) {					
				Object idTarea = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 0);
				Object nombre = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 1);
				Object descripcion = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 2);
				Object estado = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 3);
				Object responsable = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 4);
				Object idResponsable = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 5);
				Object fechaCreacion = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 6);
//				Object fechaCierre = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(),7);
				Object idAlumno = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(),8);
				
				this.vista.getTxtID().setText(idTarea.toString());
				this.vista.getTxtNombre().setText(nombre.toString());
				this.vista.getTxtAreaDescripcion().setText(descripcion.toString());
				this.vista.getTxtEstado().setText(estado.toString());
				this.vista.getTxtResponsable().setText(responsable.toString());
				this.vista.getTxtIDResponsable().setText(idResponsable.toString());
				this.vista.getTxtFecha().setText(fechaCreacion.toString());
				this.vista.getTxtIDAlumno().setText(idAlumno.toString());
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	private void seleccionarFilaAdministrativos() {
		try {
			if (this.vista.getTableAdministrativos().getSelectedRow() >= 0) {					
				Object idUsuario = this.vista.getTableAdministrativos().getValueAt(this.vista.getTableAdministrativos().getSelectedRow(), 0);
				Object nombre = this.vista.getTableAdministrativos().getValueAt(this.vista.getTableAdministrativos().getSelectedRow(), 3);
				Object apellido = this.vista.getTableAdministrativos().getValueAt(this.vista.getTableAdministrativos().getSelectedRow(), 4);

				this.vista.getTxtIDResponsable().setText(idUsuario.toString());
				this.vista.getTxtResponsable().setText(nombre.toString() + " " + apellido.toString());
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	private boolean hayTareaSeleccionada() {
		boolean tareaSeleccionada = true;
		String tarea = this.vista.getTxtID().getText();
		if(estaVacio(tarea)){
			OptionPanel.error("No hay ninguna tarea seleccionada", "Seleccionar tarea");
			tareaSeleccionada = false;
		}
		return tareaSeleccionada;
	}
	
	private boolean datosValidos() {
		boolean camposValidos = true;
		
		String nombre = this.vista.getTxtNombre().getText();
		String fecha = this.vista.getTxtFecha().getText();
		String responsable = this.vista.getTxtResponsable().getText();
		String descripcion = this.vista.getTxtAreaDescripcion().getText();

		if(estaVacio(nombre) & estaVacio(fecha) & estaVacio(responsable) & estaVacio(descripcion)) {
			OptionPanel.error("Los campos estan vacios", "Campos vacios");
			camposValidos = false;
		}
		else if(estaVacio(nombre)) {
			OptionPanel.error("El nombre esta vacio. Por favor, completar el campo", "Error");
			camposValidos = false;
		}
		else if(!validator.fechaValida(fecha)) {
			OptionPanel.error("Fecha incorrecta. Por favor, completar correctamente la fecha", "Error");
			camposValidos = false;
		}
		else if(estaVacio(responsable)) {
			OptionPanel.error("No ha seleccionado un reponsable.", "Error");
			camposValidos = false;
		}
		else if(estaVacio(descripcion)) {
			OptionPanel.error("Debe ingresar una descripcion.", "Error");
			camposValidos = false;
		}
		else {
			camposValidos = true;
		}
		return camposValidos;
	}

	public boolean estaVacio(String valor) {
		return valor.trim().equals("");
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.vista.getBtnAgregar()) {
			agregarTarea();
		}
		else if (event.getSource() == this.vista.getBtnActualizar()) {
			modificarTarea();
		}
		else if (event.getSource() == this.vista.getBtnEliminar()) {
			eliminarTarea();
		}
		else if (event.getSource() == this.vista.getBtnSelecionarResponsable()) {
			clickSeleccionResponsable();
		}
		else if (event.getSource() == this.vista.getBtnMarcarComoRealizada()) {
			cerrarTarea();
		}
		else if (event.getSource() == this.vista.getCboxEstado()) {
			filtrarPorEstado();
		}
		else if (event.getSource() == this.vista.getCboxTareas()) {
			filtrarPorTareas();
		}
	}
	
	private void filtrarPorTareas() {
		generarTablas();
	}

	private void filtrarPorEstado() {
		generarTablas();
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
