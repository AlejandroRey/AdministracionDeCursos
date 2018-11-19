package persistencia.controlador;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoTareaPanel;
import dto.AlumnoDTO;
import dto.CategoriaDTO;
import dto.TareaDTO;
import dto.UsuarioDTO;

public class AlumnoTareaControlador implements ActionListener {
	
	private AlumnoTareaPanel vista;
	private AdministracionDeCursos modelo;
	private List<TareaDTO> tareasLista;
	private List<UsuarioDTO> administrativosLista;
	private List<CategoriaDTO> categoriasLista;
	private UsuarioDTO currentAdministrativo;
	private AlumnoDTO alumno;
	
	public AlumnoTareaControlador(AdministracionDeCursos modelo,AlumnoTareaPanel vista, AlumnoDTO alumno) {
		this.administrativosLista = null;
		this.categoriasLista = null;
		this.vista = vista;
		this.modelo = modelo;
		this.alumno = alumno;
		this.currentAdministrativo = null;
		this.vista.getCboxEstado().addActionListener(this);
	}
	
	public void inicializar() {
		llenarTabla();
	}
	
	public void llenarTabla() {
		clearTableTareas();
		this.tareasLista = modelo.obtenerTareas();
		this.administrativosLista = modelo.obtenerUsuarios();
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
		this.tareasLista =  this.tareasLista.stream().filter(tarea -> tarea.getIdAlumno() == this.alumno.getIdAlumno()).collect(Collectors.toList());
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
 	//************************Filtros*************************//
	
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
	
	private String getAdministrativoString(Long idAdministrativo) {
		String administrativoNombre = "";
		for (UsuarioDTO usuarioDTO : this.administrativosLista) {
			if (usuarioDTO.getIdUsuario() == idAdministrativo) {
				administrativoNombre = usuarioDTO.getNombre() + " " + usuarioDTO.getApellido();
			}
		}
		return administrativoNombre;
	}
 	
	private void filtrarPorTareas() {
		llenarTabla();
	}
 	private void filtrarPorEstado() {
		llenarTabla();
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
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.vista.getCboxEstado()) {
			filtrarPorEstado();
		}
		else if (event.getSource() == this.vista.getCboxTareas()) {
			filtrarPorTareas();
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