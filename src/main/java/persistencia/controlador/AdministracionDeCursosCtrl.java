package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import dto.InstructorDTO;
import herramientas.ButtonColumn;
import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosView;

public class AdministracionDeCursosCtrl implements ActionListener {

	private AdministracionDeCursosView vista;
	private List<InstructorDTO> instructores_en_tabla;
	private AdministracionDeCursos modelo;

	public AdministracionDeCursosCtrl(AdministracionDeCursosView vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnLlenarTabla().addActionListener(this);
		this.instructores_en_tabla = null;
	}

	public void inicializar() {
		this.llenarTabla();
		this.vista.show();
	}

	private void llenarTabla() {
		this.vista.getModelInstructores().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelInstructores().setColumnCount(0);
		this.vista.getModelInstructores().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.instructores_en_tabla = modelo.obtenerInstructores();
		for (int i = 0; i < this.instructores_en_tabla.size(); i++) {
			Object[] fila = { this.instructores_en_tabla.get(i).getIdInstructor(),
							  this.instructores_en_tabla.get(i).getIdCursoTipo(),
							  this.instructores_en_tabla.get(i).getNombre(),
							  this.instructores_en_tabla.get(i).getApellido(),
							  this.instructores_en_tabla.get(i).getTelefono(),
							  this.instructores_en_tabla.get(i).getEmail(),
							  "Editar",
					          "Eliminar"};
			this.vista.getModelInstructores().addRow(fila);
		}
		this.vista.getTablaInstructores().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ButtonColumn btnEditar = new ButtonColumn(this.vista.getTablaInstructores(), null, 7);
		ButtonColumn btnEliminar = new ButtonColumn(this.vista.getTablaInstructores(), null, 8);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnLlenarTabla()) {
			llenarTabla();
		}
	}

}
