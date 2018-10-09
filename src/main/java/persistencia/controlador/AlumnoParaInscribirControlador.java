package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoDTO;
import modelo.AdministracionDeCursos;
import persistencia.conexion.Conexion;
import presentacion.vista.AlumnoCrudVista;
import presentacion.vista.AlumnoParaInscribirModalPanel;

public class AlumnoParaInscribirControlador implements ActionListener {
	
	private AlumnoParaInscribirModalPanel vista;
	private AdministracionDeCursos modelo;
	private List<AlumnoDTO> alumnosLista;
	
	public AlumnoParaInscribirControlador(AlumnoParaInscribirModalPanel vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.alumnosLista = null;
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnCerrar().addActionListener(this);
	}

	public void inicializar() {
		llenarTabla();
		this.vista.setModal(true);
		this.vista.setVisible(true);
		this.vista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private void llenarTabla() {
		this.vista.getModelAlumnos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAlumnos().setColumnCount(0);
		this.vista.getModelAlumnos().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.alumnosLista = modelo.obtenerAlumnos();
		for (AlumnoDTO alumnoDTO : alumnosLista) {
			Object[] fila = {alumnoDTO.getIdAlumno(),
							 alumnoDTO.getNombre(), 
							 alumnoDTO.getApellido(),
							 alumnoDTO.getTelefono(),
							 alumnoDTO.getEmail()};
			this.vista.getModelAlumnos().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblAlumnos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblAlumnos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblAlumnos().getSelectedRow() >= 0) {					
					Object idAlumno = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 0);
					Object nombre = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 1);
					Object apellido = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 2);
					Object telefono = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 3);
					Object email = this.vista.getTblAlumnos().getValueAt(this.vista.getTblAlumnos().getSelectedRow(), 4);

					this.vista.getTextIdAlumno().setText(idAlumno.toString());
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
		this.vista.getTblAlumnos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnActualizar()) {
			actualizarAlumno();
		} else if (e.getSource() == this.vista.getBtnAgregar()) {
			agregarAlumno();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			eliminarAlumno();
		} else if (e.getSource() == this.vista.getBtnCerrar()) {
			//cerrarVistaAlumno();
		}
	}
	
	public JButton getBtnAddAlumno() {
		return this.vista.getBtnCerrar();
	}
	
	public AlumnoDTO getAlumnoParaInscrir() {
		AlumnoDTO alumno = new AlumnoDTO(Long.parseLong(this.vista.getTextIdAlumno().getText()),
										 this.vista.getTextNombre().getText(), 
										 this.vista.getTextApellido().getText(),
										 this.vista.getTextTelefono().getText(), 
										 this.vista.getTextEmail().getText());
		return alumno;
	}
	
//	private void cerrarVistaAlumno() {
//		int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de curso!?", "Confirmacion",
//				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//		if (confirm == 0) {
//			Conexion.getConexion().cerrarConexion();
//			this.vista.getFrame().dispose();
//		}
//		
//	}

	private void actualizarAlumno() {
		AlumnoDTO alumno = new AlumnoDTO(Long.parseLong(this.vista.getTextIdAlumno().getText()),
				   this.vista.getTextNombre().getText(),
				   this.vista.getTextApellido().getText(),
				   this.vista.getTextTelefono().getText(),
				   this.vista.getTextEmail().getText());
		this.modelo.actualizarAlumno(alumno);
		llenarTabla();
	}

	private void eliminarAlumno() {        
    	int dialogResult = JOptionPane.showConfirmDialog(null, "Se va a Eliminar el Alumno seleccionado!", "Confirma Eliminar Registro?", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
        		AlumnoDTO alumno = new AlumnoDTO(Long.parseLong(this.vista.getTextIdAlumno().getText()),
						   this.vista.getTextNombre().getText(),
						   this.vista.getTextApellido().getText(),
						   this.vista.getTextTelefono().getText(),
						   this.vista.getTextEmail().getText());
				this.modelo.borrarAlumno(alumno);
				llenarTabla();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
	}

	private void agregarAlumno() {
		AlumnoDTO alumno = new AlumnoDTO(0,
									   this.vista.getTextNombre().getText(),
									   this.vista.getTextApellido().getText(),
									   this.vista.getTextTelefono().getText(),
									   this.vista.getTextEmail().getText());		
		this.modelo.agregarAlumno(alumno);
		llenarTabla();
	}
	
	private void clearTextInputsBox() {
		this.vista.getTextIdAlumno().setText("");
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
