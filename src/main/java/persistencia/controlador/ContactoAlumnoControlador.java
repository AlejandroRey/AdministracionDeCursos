package persistencia.controlador;

import herramientas.OptionPanel;
import herramientas.Validator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.ContactoAlumnoDialog;
import presentacion.vista.ContactoAlumnoNuevoDialog;
import presentacion.vista.ContactoAlumnoNuevoPanel;

public class ContactoAlumnoControlador implements ActionListener{
	
	private ContactoAlumnoDialog vistaContactoAlumno;
	private AdministracionDeCursos modelo;
	private List<AlumnoDTO> alumnosLista;
	private AlumnoDTO currentAlumno;
	private ContactoABMControlador parentControlador;
	private ContactoAlumnoNuevoDialog vistaAgregarAlumno;
	private Validator validator;
	
	public ContactoAlumnoControlador(ContactoAlumnoDialog dialog, AdministracionDeCursos modelo, ContactoABMControlador parentControlador) {
		this.vistaContactoAlumno = dialog;
		this.modelo = modelo;
		this.parentControlador = parentControlador;
		this.vistaAgregarAlumno = null;
		this.alumnosLista = null;
		this.currentAlumno = null;
		this.validator = new Validator();
		
		this.vistaAgregarAlumno = new ContactoAlumnoNuevoDialog();
		this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getBtnAgregar().addActionListener(this);
		
		this.vistaContactoAlumno.getBtnSeleccionarNuevo().addActionListener(this);
		this.vistaContactoAlumno.getBtnSeleccionar().addActionListener(this);
	}
	
	public void inicializar() {
		llenarTabla();
		this.vistaContactoAlumno.showDialog();
	}
	
	private void llenarTabla() {
		this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().setColumnCount(0);
		this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().setColumnIdentifiers(this.vistaContactoAlumno.getContactoAlumnoPanel().getNombreColumnas());
		this.alumnosLista = modelo.obtenerAlumnos();
		for (AlumnoDTO alumnoDTO : alumnosLista) {
			Object[] fila = {alumnoDTO.getIdAlumno(),
							 alumnoDTO.getNombre(), 
							 alumnoDTO.getApellido(),
							 alumnoDTO.getTelefono(),
							 alumnoDTO.getEmail()};
			this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getColumnModel().getColumn(0).setWidth(0);
		this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getColumnModel().getColumn(0).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().setSelectionModel(new ListSelectionModelCstm());
		this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectedRow() >= 0) {		
					Object idAlumno = this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getValueAt(this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectedRow(), 0);
					Object nombre = this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getValueAt(this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectedRow(), 1);
					Object apellido = this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getValueAt(this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectedRow(), 2);
					Object telefono = this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getValueAt(this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectedRow(), 3);
					Object email = this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getValueAt(this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getSelectedRow(), 4);
					AlumnoDTO alumno = new AlumnoDTO(Long.parseLong(idAlumno.toString()),
							nombre.toString(),
							apellido.toString(),
							telefono.toString(),
							email.toString());
					setCurrentAlumno(alumno);
					viazualizarCurrentAlumno();
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vistaContactoAlumno.getContactoAlumnoPanel().getTblAlumnos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		
	}

	private void viazualizarCurrentAlumno() {
		this.vistaContactoAlumno.getContactoAlumnoPanel().getLblAlumno().setText(currentAlumno.getNombre() + " " + currentAlumno.getApellido());
	}

	private void setCurrentAlumno(AlumnoDTO alumno) {
		currentAlumno = null;
		currentAlumno = alumno;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vistaContactoAlumno.getBtnSeleccionarNuevo()) {
			abrirSeleccionarNuevoAlumno();
		} else if (e.getSource() == this.vistaContactoAlumno.getBtnSeleccionar()) {
			seleccionarAlumno();
		}
		else if (this.vistaAgregarAlumno != null && e.getSource() == this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getBtnAgregar()) {
			agregarAlumno();
		}
	}

	private void abrirSeleccionarNuevoAlumno() {
		vistaAgregarAlumno.showDialog();
	}

	private void seleccionarAlumno() {
		this.parentControlador.setAlumnoSeleccionado(currentAlumno);
		this.vistaContactoAlumno.dispose();
	}

	private void agregarAlumno() {
		if(datosValidos()) {
			AlumnoDTO alumno = new AlumnoDTO(0,
					this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextNombre().getText(),
					this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextApellido().getText(),
					this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextTelefono().getText(),
					this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextEmail().getText());
			this.modelo.agregarAlumno(alumno);
			this.vistaAgregarAlumno.dispose();
			clearTextInputsBox();
			this.llenarTabla();
			int seleccionar = OptionPanel.confimarcion("Desea seleccionar el nuevo alumno?", "Seleccionar Nuevo Alumno");
			if(seleccionar == 0	) {
				obtenerUltimo();
				seleccionarAlumno();
			} else {
				
			}
		}
	}

	private void obtenerUltimo() {
		int indiceUltimaFila = this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().getRowCount() - 1;
		Object idAlumno = this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().getValueAt(indiceUltimaFila, 0);
		Object nombre = this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().getValueAt(indiceUltimaFila, 1);
		Object apellido = this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().getValueAt(indiceUltimaFila, 2);
		Object telefono = this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().getValueAt(indiceUltimaFila, 3);
		Object email = this.vistaContactoAlumno.getContactoAlumnoPanel().getModelAlumnos().getValueAt(indiceUltimaFila, 4);
		AlumnoDTO ultimoAlumno = new AlumnoDTO(Long.parseLong(idAlumno.toString()), 
				nombre.toString(), 
				apellido.toString(),
				telefono.toString(), 
				email.toString());
		this.setCurrentAlumno(ultimoAlumno);
	}
	
	private void clearTextInputsBox() {
		this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextNombre().setText("");
		this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextApellido().setText("");
		this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextTelefono().setText("");
		this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel().getTextEmail().setText("");
	}

	private boolean datosValidos() {
		boolean camposValidos = true;
		ContactoAlumnoNuevoPanel vista = this.vistaAgregarAlumno.getContactoAlumnoNuevoPanel();
		
		String nombre = vista.getTextNombre().getText();
		String apellido = vista.getTextApellido().getText();
		String telefono = vista.getTextTelefono().getText();
		String email = vista.getTextEmail().getText();

		if(estaVacio(nombre) & estaVacio(apellido) & estaVacio(telefono) & estaVacio(email)) {
			OptionPanel.error("Los campos estan vacios", "Campos vacios");
			camposValidos = false;
		}
		else if(estaVacio(nombre)) {
			OptionPanel.error("El nombre esta vacio. Por favor, completar el campo", "Error");
			camposValidos = false;
		}
		else if(estaVacio(apellido)) {
			OptionPanel.error("El apellido esta vacio. Por favor, completar el campo", "Error");
			camposValidos = false;
		}
		else if(estaVacio(telefono)) {
			OptionPanel.error("El telefono esta vacio. Por favor, completar el campo", "Error");
			camposValidos = false;
		}
		else if(!validator.mailValido(email)) {
			OptionPanel.error("Debe ingresar un mail valido.", "Error");
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
