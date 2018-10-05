package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CursoTipoDTO;
import dto.InstructorDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.InstructorCrudVista;

public class InstructorCrudControlador implements ActionListener {
	
	private InstructorCrudVista vista;
	private AdministracionDeCursos modelo;
	private List<InstructorDTO> instructoresLista;
	List<CursoTipoDTO> cursoTipoLista;
	
	public InstructorCrudControlador(InstructorCrudVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.instructoresLista = null;
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnCerrar().addActionListener(this);
	}

	public void inicializar() {
		setCategorias();
		llenarTabla();
		this.vista.show();
	}
	
	private void setCategorias() {		
		cursoTipoLista = modelo.obtenerCursoTipos();
		for (CursoTipoDTO cursoTipoFiltroDTO : cursoTipoLista) {
			this.vista.getCbxCursoTipoFiltro().addItem(cursoTipoFiltroDTO);
		}
	}

	private void llenarTabla() {
		this.vista.getModelInstructores().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelInstructores().setColumnCount(0);
		this.vista.getModelInstructores().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.instructoresLista = modelo.obtenerInstructores();
		for (InstructorDTO instructorDTO : instructoresLista) {
			Object[] fila = {instructorDTO.getIdInstructor(),
							 instructorDTO.getIdCursoTipo(),
							 getCursoTipoString(instructorDTO.getIdCursoTipo()),
							 instructorDTO.getNombre(), 
							 instructorDTO.getApellido(),
							 instructorDTO.getTelefono(),
							 instructorDTO.getEmail()};
			this.vista.getModelInstructores().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTblInstructores().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblInstructores().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblInstructores().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblInstructores().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblInstructores().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblInstructores().getColumnModel().getColumn(1).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblInstructores().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblInstructores().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblInstructores().getSelectedRow() >= 0) {
					if (this.vista.getCbxCursoTipo().getItemCount() == 0) {
						this.vista.getCbxCursoTipo().addItem(new CursoTipoDTO(0, ""));
						for (CursoTipoDTO cursoTipoDTO : cursoTipoLista) {
							this.vista.getCbxCursoTipo().addItem(cursoTipoDTO);
						}
					}					
					Object idInstructor = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 0);
					Object idCursoTipo = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 1);
					Object cursoTipo = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 2);
					Object nombre = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 3);
					Object apellido = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 4);
					Object telefono = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 5);
					Object email = this.vista.getTblInstructores().getValueAt(this.vista.getTblInstructores().getSelectedRow(), 6);

					this.vista.getTextIdInstructor().setText(idInstructor.toString());
					this.vista.getCbxCursoTipo().setSelectedItem(new CursoTipoDTO(Long.parseLong(idCursoTipo.toString()), cursoTipo.toString()));
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextApellido().setText(apellido.toString());
					this.vista.getTextTelefono().setText(telefono.toString());
					this.vista.getTextEmail().setText(email.toString());
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblInstructores().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private String getCursoTipoString(long idCursoTipo) {
		String cursoTipoNombre = "";
		for (CursoTipoDTO cursoTipoDTO : cursoTipoLista) {
			if (cursoTipoDTO.getIdCursoTipo() == idCursoTipo) {
				cursoTipoNombre = cursoTipoDTO.getNombre();
			}
		}
		return cursoTipoNombre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnActualizar()) {
			actualizarInstructor();
		} else if (e.getSource() == this.vista.getBtnAgregar()) {
			agregarInstructor();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			eliminarInstructor();
		} else if (e.getSource() == this.vista.getBtnCerrar()) {
		}
	}
	
	private void actualizarInstructor() {
		CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
		InstructorDTO instructor = new InstructorDTO(Long.parseLong(this.vista.getTextIdInstructor().getText()),
									   cursoTipo.getIdCursoTipo(),
									   this.vista.getTextNombre().getText(),
									   this.vista.getTextApellido().getText(),
									   this.vista.getTextTelefono().getText(),
									   this.vista.getTextEmail().getText());
		this.modelo.actualizarInstructor(instructor);
		llenarTabla();	
	}

	private void eliminarInstructor() {
		CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
		InstructorDTO instructor = new InstructorDTO(Long.parseLong(this.vista.getTextIdInstructor().getText()),
									   cursoTipo.getIdCursoTipo(),
									   this.vista.getTextNombre().getText(),
									   this.vista.getTextApellido().getText(),
									   this.vista.getTextTelefono().getText(),
									   this.vista.getTextEmail().getText());
		this.modelo.borrarInstructor(instructor);
		llenarTabla();
	}

	private void agregarInstructor() {
		CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
		InstructorDTO instructor = new InstructorDTO(0,
									   cursoTipo.getIdCursoTipo(),
									   this.vista.getTextNombre().getText(),
									   this.vista.getTextApellido().getText(),
									   this.vista.getTextTelefono().getText(),
									   this.vista.getTextEmail().getText());		
		this.modelo.agregarInstructor(instructor);
		llenarTabla();
	}
	
	private void clearTextInputsBox() {
		this.vista.getTextIdInstructor().setText("");
		this.vista.getCbxCursoTipo().setSelectedItem(new CursoTipoDTO(0, ""));
		this.vista.getTextNombre().setText("");
		this.vista.getTextApellido().setText("");
		this.vista.getTextTelefono().setText("");
		this.vista.getTextEmail().setText("");
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
