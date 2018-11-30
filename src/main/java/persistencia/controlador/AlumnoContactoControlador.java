package persistencia.controlador;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoContactoPanel;
import dto.AlumnoDTO;
import dto.ContactoCompletoDTO;
import dto.ContactoDTO;
import dto.CursoDTO;
import dto.UsuarioDTO;

 public class AlumnoContactoControlador implements ActionListener{
	private AlumnoContactoPanel vista;
	private AdministracionDeCursos modelo;
	private List<ContactoCompletoDTO> contactosLista;
	private ContactoDTO currentContacto;
	private ContactoCompletoDTO currentContactoCompleto;
	private UsuarioDTO currentAdministrativo;
	private AlumnoDTO alumno;
	
	
	public AlumnoContactoControlador(AlumnoContactoPanel vista, AdministracionDeCursos modelo, AlumnoDTO alumno) {
		this.vista = vista;
		this.modelo = modelo;
		this.contactosLista = null;
		this.currentContacto = null;
		this.currentContactoCompleto = null;
		this.alumno = alumno;
		this.currentAdministrativo = this.modelo.getUsuarioLogueado();
	}
	
	public void inicializar() {
		llenarTabla();
	}
 	private void llenarTabla() {
		clearTable();
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
		this.contactosLista = this.contactosLista.stream()
				.filter(contacto -> contacto.getAlumno().getIdAlumno() == alumno.getIdAlumno())
				.collect(Collectors.toList());
		for (ContactoCompletoDTO contactoDTO : contactosLista) {
			Object[] fila = {contactoDTO.getContacto().getIdContacto(),
							 contactoDTO.getContacto().getIdAlumno(),
							 contactoDTO.getContacto().getIdAdministrativo(),
							 contactoDTO.getContacto().getIdCurso(),
							 contactoDTO.getCurso(),
							 contactoDTO.getAlumno().getNombre(),
							 contactoDTO.getAlumno().getApellido(),
							 contactoDTO.getContacto().getDescripcion(),
							 contactoDTO.getAlumno().getTelefono(),
							 contactoDTO.getAlumno().getEmail(),
							 StringToLocalDateFormatter(contactoDTO.getContacto().getFechaCreacion(), "dd/MM/yyyy"),
							 StringToLocalDateFormatter(contactoDTO.getContacto().getFechaCreacion(), "HH:mm:ss"),
							 StringToLocalDateFormatter(contactoDTO.getContacto().getFechaContactar(), "dd/MM/yyyy"),
							 StringToLocalDateFormatter(contactoDTO.getContacto().getFechaContactar(), "HH:mm:ss"),
							 contactoDTO.getApellidoAdministrativo(),
							 contactoDTO.getNombreAdministrativo(),
							 contactoDTO.getContacto().getEstado(),
							 contactoDTO.getContacto().getIdTarea()};
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
	
	private void ocultarColumna(JTable table, int column){
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
				
					Object idContacto = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 0);
					Object idAlumno = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 1);
					Object idAdministrativo = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 2);
					Object idCurso = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 3);
					Object curso = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 4);
					Object nombre = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 5);
					Object apellido = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 6);
					Object descripcion = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 7);
					Object telefono = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 8);
					Object email = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 9);
					Object fechaCreacion = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 10);
					Object horaContacto = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 11);
					Object fechaAccion = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 12);
					Object horaProximoContacto = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 13);
					Object apellidoAdmin = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 14);
					Object nombreAdmin = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 15);
					Object estado = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 16);
					Object idTarea = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 17);
 					ContactoDTO contacto = new ContactoDTO(Long.parseLong(idContacto.toString()),
							Long.parseLong(idAlumno.toString()),
							Long.parseLong(idAdministrativo.toString()),
							Long.parseLong(idTarea.toString()),
							Long.parseLong(idCurso.toString()),
							descripcion.toString(),
							StringToLocalDateTime(fechaAccion.toString(), horaProximoContacto.toString()),
							StringToLocalDateTime(fechaCreacion.toString(), horaContacto.toString()),
							Integer.parseInt(estado.toString()));
					setCurrentContacto(contacto);
					this.currentContactoCompleto = null;
					this.currentContactoCompleto = new ContactoCompletoDTO(this.currentContacto, this.alumno, 
							curso.toString(),nombre.toString(),apellido.toString());
					mostrarDetalleContacto();
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});
	}
 	
	private void mostrarDetalleContacto() {
		ContactoCompletoDTO contacto = this.currentContactoCompleto; 
		String detalle = getDetalle(contacto);
		this.vista.getTextDetalle().setText(detalle);
	}

	private String getDetalle(ContactoCompletoDTO contacto) {
		String administrativo = "Administrativo: " + contacto.getNombreAdministrativo() + " " + contacto.getApellidoAdministrativo();
		String alumno = "Alumno: " + contacto.getAlumno().getNombre() + " " + contacto.getAlumno().getApellido();
		String fecha = "Fecha del contacto: " + StringToLocalDateFormatter(contacto.getContacto().getFechaCreacion(), "dd/MM/yyyy");
		String proximoContacto = "Fecha del proximo contacto: " + StringToLocalDateFormatter(contacto.getContacto().getFechaContactar(), "dd/MM/yyyy");
		String descripcion = contacto.getContacto().getDescripcion();
		String detalle = fecha + "\n\n" + administrativo + "\n\n" + alumno + "\n\n" + descripcion + "\n\n" + proximoContacto;  
		return detalle;
	}
	
 	public void setCurrentContacto(ContactoDTO contacto) {
		this.currentContacto = null;
		this.currentContacto = contacto;
	}
	
 	private String StringToLocalDateFormatter(LocalDateTime fecha,
			String pattern) {
		String formatDateTime = "";
		if (fecha != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			formatDateTime = fecha.format(formatter);
		}
		return formatDateTime;
	}

	private LocalDateTime StringToLocalDateTime(String fecha, String hora) {
		LocalDateTime dateTime = null;
		if (!estaVacio(fecha)) {
			String date = fecha + " " + hora;
			DateTimeFormatter format = DateTimeFormatter
					.ofPattern("dd/MM/yyyy HH:mm:ss");
			dateTime = LocalDateTime.parse(date, format);
		}
		return dateTime;
	}
	
	public boolean estaVacio(String valor) {
		return valor.trim().equals("");
	}

	
	//******************************LISTENERS******************************//
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
