package persistencia.controlador;

import herramientas.OptionPanel;
import herramientas.Validator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.AdministracionDeCursos;
import presentacion.vista.ContactoTareaDialog;
import presentacion.vista.TareaABMPanel;
import dto.CategoriaDTO;
import dto.ContactoDTO;
import dto.TareaDTO;
import dto.UsuarioDTO;

public class ContactoTareaControlador implements ActionListener{

	private ContactoTareaDialog dialog;
	private TareaABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<TareaDTO> tareasLista;
	private List<UsuarioDTO> administrativosLista;
	private List<CategoriaDTO> categoriasLista;
	private UsuarioDTO currentAdministrativo;
	private ContactoDTO contacto;
	private ContactoABMControlador controladorParent;
	private Validator validator;
	
	public ContactoTareaControlador(ContactoTareaDialog vista, AdministracionDeCursos modelo, ContactoABMControlador controladorParent) {
		this.administrativosLista = null;
		this.categoriasLista = null;
		this.dialog = vista;
		this.vista = (TareaABMPanel) dialog.getContactoTareaPanel();
		this.modelo = modelo;
		this.contacto = null;
		this.currentAdministrativo = null;
		this.controladorParent = controladorParent;
		this.validator = new Validator();
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnSelecionarResponsable().addActionListener(this);
		this.vista.getCboxEstado().addActionListener(this);
		this.dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) { close();}});
	}
	
	public void inicializar() {
		loadAdministrativosData();
		generarTablas();
		setVisibleBtnAgregar();
		setDataContacto();
		dialog.showDialog();
	}
	
	private void close() {
		if(OptionPanel.confimarcion("¿Desea descartar la tarea?", "") == 0)
			dialog.dispose();
	}
	
	public void llenarTabla() {
		clearTableTareas();
		clearTextInputsBox();
		this.tareasLista = modelo.obtenerTareas();
		loadDataRowsTbTareas();
		ocultarColumnasTbTareas();
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
							 StringToLocalDateFormatter(tareaDTO.getFechaCreacion(), "dd/MM/yyyy"),
							 StringToLocalDateFormatter(tareaDTO.getFechaCierre(),"dd/MM/yyyy")};
			this.vista.getModelTareas().addRow(fila);
		}
	}
	
	public void setContacto(ContactoDTO contacto) {
		this.contacto = contacto;
	}
	
	private void setDataContacto() {
		this.vista.getTxtFecha().setEditable(false);
		this.vista.getTxtFecha().setText(StringToLocalDateFormatter(contacto.getFechaContactar(),"dd/MM/yyyy"));
		this.vista.getTxtResponsable().setEditable(false);
		Optional<UsuarioDTO> filtro = this.administrativosLista.stream()
				.filter(administrativo -> administrativo.getIdUsuario() == contacto.getIdAdministrativo()).findFirst();
		this.vista.getTxtResponsable().setText(filtro.get().getNombre() + " " + filtro.get().getApellido());
		this.vista.getTxtIDResponsable().setText(Long.toString(contacto.getIdAdministrativo()));
	}

	private void llenarTablaAdministrativos() {
		clearTableAdministrativos();
		clearTextInputsBox();
		loadAdministrativosData();
		loadDataRowsTbAdministrativos();
		ocultarColumnasTbAdministrativos();
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
        if(this.vista.getCboxEstado().getSelectedItem().toString() == "Pendientes")
        	this.vista.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("Pendiente", 3));
        else if(this.vista.getCboxEstado().getSelectedItem().toString() == "Realizadas")
        	this.vista.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("Realizada", 3));
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
					this.contacto.getIdAlumno(),
					this.vista.getTxtNombre().getText(),
					this.vista.getTxtAreaDescripcion().getText(),
					"Pendiente",
					this.contacto.getFechaCreacion(),
					this.contacto.getFechaContactar(),
					null);
			this.modelo.agregarTarea(tarea);
			OptionPanel.mensaje("La tarea ha sido agregada correctamente", "Tarea");
			generarTablas();
			long idTarea = this.tareasLista.get(this.tareasLista.size() -1 ).getIdTarea();
			this.contacto.setIdTarea(idTarea);
			this.controladorParent.setCurrentContacto(this.contacto);
			dialog.dispose();
		}
		System.out.println("Agrego una tarea");
	}
	
	private void filtrarPorTareas() {
		generarTablas();
	}

	private void filtrarPorEstado() {
		generarTablas();
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
//		this.setVisibleBtnSeleccionarResponsable();
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
		else if (event.getSource() == this.vista.getCboxEstado()) {
			filtrarPorEstado();
		}
		else if (event.getSource() == this.vista.getCboxTareas()) {
			filtrarPorTareas();
		}
	}

}
