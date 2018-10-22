package persistencia.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.AdministracionDeCursos;
import dto.CategoriaDTO;
import dto.TareaDTO;
import dto.UsuarioDTO;
import presentacion.vista.TareaABMPanel;

public class TareaABMControlador implements ActionListener{

	private TareaABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<TareaDTO> tareasLista;
	private List<UsuarioDTO> administrativosLista;
	private List<CategoriaDTO> categoriasLista;
	
	public TareaABMControlador(TareaABMPanel vista, AdministracionDeCursos modelo) {
		this.tareasLista = null;
		this.administrativosLista = null;
		this.categoriasLista = null;
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnSelecionarResponsable().addActionListener(this);
	}
	
	public void inicializar() {
		loadAdministrativosData();
		llenarTabla();
		llenarTablaAdministrativos();
	}
	
	public void llenarTabla() {
		clearTableTareas();
		clearTextInputsBox();

		this.tareasLista = modelo.obtenerTareas();
		loadDataRowsTbTareas();
		// Oculto los id del Objeto
		ocultarColumnasTbTareas();
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTableTareas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTableTareas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {seleccionarFila();});
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTableTareas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
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
							 stringDateFormatter(tareaDTO.getFechaCreacion()),
							 stringDateFormatter(tareaDTO.getFechaCierre())};
			this.vista.getModelTareas().addRow(fila);
		}
	}

	private void llenarTablaAdministrativos() {
		clearTableAdministrativos();
		clearTextInputsBox();
//		loadAdministrativosData();
		loadDataRowsTbAdministrativos();
		// Oculto los id del Objeto
		ocultarColumnasTbAdministrativos();
//		// Agrego listener para obtener los valores de la fila seleccionada
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

	private void filtrarAdministrativos() {
		this.administrativosLista = this.administrativosLista.stream()
				                    .filter(usuario -> usuario.getIdCategoria() == 2)//2 es administrativo
				                    .collect(Collectors.toList());
	}
	
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

		
	public boolean datosValidos() {
		return false;
	}

	public void agregarTarea() {
		TareaDTO tarea = new TareaDTO(0,
				Long.parseLong(this.vista.getTxtIDResponsable().getText()),
				this.vista.getTxtNombre().getText(),
				this.vista.getTxtAreaDescripcion().getText(),
				"Pendiente",
				StringToLocalDateTime(this.vista.getTxtFecha().getText()),null);
		this.modelo.agregarTarea(tarea);
		llenarTabla();
	}

	public void modificarTarea() {
		TareaDTO tarea = new TareaDTO(Long.parseLong(this.vista.getTxtID().getText()),
				Long.parseLong(this.vista.getTxtIDResponsable().getText()),
				this.vista.getTxtNombre().getText(),
				this.vista.getTxtAreaDescripcion().getText(),
				"Pendiente",
				StringToLocalDateTime(this.vista.getTxtFecha().getText()),
				null);
		this.modelo.actualizarTarea(tarea);
		llenarTabla();
	}

	public void eliminarTarea() {
		TareaDTO tarea = new TareaDTO(Long.parseLong(this.vista.getTxtID().getText()),
									  Long.parseLong(this.vista.getTxtIDResponsable().getText()),
									  this.vista.getTxtNombre().getText(),
									  this.vista.getTxtAreaDescripcion().getText(),
									  "Pendiente",
									  StringToLocalDateTime(this.vista.getTxtFecha().getText()),null);
		this.modelo.borrarTarea(tarea);
		llenarTabla();
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTableTareas().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTableTareas().setEnabled(false);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTableTareas().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	private void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
	}

	private void clearTextInputsBox() {
		this.vista.getTxtNombre().setText("");
		this.vista.getTxtResponsable().setText("");
		this.vista.getTxtAreaDescripcion().setText("");
		this.vista.getTxtFecha().setText("");
		this.clearTextInputsBoxAux();
	}

	private void clearTextInputsBoxAux() {
		this.vista.getTxtID().setText("");
		this.vista.getTxtIDResponsable().setText("");
		this.deshabilitarTablaAdministrativos();
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
	
	private String stringDateFormatter(LocalDateTime fecha) {
		String formatDateTime = "";
		if ( fecha != null){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			formatDateTime = fecha.format(formatter);
		}
		return formatDateTime;
	}

	private LocalDateTime StringToLocalDateTime(String fecha) {
		String date = fecha + " 00:00:00";
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
				Object responsable = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 4);
				Object idResponsable = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 5);
				Object fechaCreacion = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 6);
				
				this.vista.getTxtID().setText(idTarea.toString());
				this.vista.getTxtNombre().setText(nombre.toString());
				this.vista.getTxtAreaDescripcion().setText(descripcion.toString());
				this.vista.getTxtResponsable().setText(responsable.toString());
				this.vista.getTxtIDResponsable().setText(idResponsable.toString());
				this.vista.getTxtFecha().setText(fechaCreacion.toString());
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
