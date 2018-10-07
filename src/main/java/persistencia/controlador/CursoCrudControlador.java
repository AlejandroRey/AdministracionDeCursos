package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CursoDTO;
import dto.CursoTipoDTO;
import modelo.AdministracionDeCursos;
import persistencia.conexion.Conexion;
import presentacion.vista.CursoCrudVista;

public class CursoCrudControlador implements ActionListener {

	private CursoCrudVista vista;
	private AdministracionDeCursos modelo;
	private List<CursoDTO> cursosLista;
	List<CursoTipoDTO> cursoTipoLista;

	public CursoCrudControlador(CursoCrudVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.cursosLista = null;
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
		for (CursoTipoDTO cursoTipoDTO : cursoTipoLista) {
			this.vista.getCbxCursoTipo().addItem(cursoTipoDTO);
		}
	}

	private void llenarTabla() {
		this.vista.getModelCursos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelCursos().setColumnCount(0);
		this.vista.getModelCursos().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.cursosLista = modelo.obtenerCursos();
		for (CursoDTO cursoDTO : cursosLista) {
			Object[] fila = { cursoDTO.getIdCurso(), cursoDTO.getIdCursoTipo(),
					getCursoTipoString(cursoDTO.getIdCursoTipo()), cursoDTO.getNombre(), cursoDTO.getTema(),
					cursoDTO.getTemario() };
			this.vista.getModelCursos().addRow(fila);
		}

//		// Oculto los id del Objeto
//		this.vista.getTblCursos().getColumnModel().getColumn(0).setWidth(0);
//		this.vista.getTblCursos().getColumnModel().getColumn(0).setMinWidth(0);
//		this.vista.getTblCursos().getColumnModel().getColumn(0).setMaxWidth(0);
//		this.vista.getTblCursos().getColumnModel().getColumn(0).setWidth(1);
//		this.vista.getTblCursos().getColumnModel().getColumn(0).setMinWidth(1);
//		this.vista.getTblCursos().getColumnModel().getColumn(0).setMaxWidth(1);

		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblCursos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblCursos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblCursos().getSelectedRow() >= 0) {
					if (this.vista.getCbxCursoTipo().getItemCount() == 0) {
						this.vista.getCbxCursoTipo().addItem(new CursoTipoDTO(0, ""));
						for (CursoTipoDTO cursoTipoDTO : cursoTipoLista) {
							this.vista.getCbxCursoTipo().addItem(cursoTipoDTO);
						}
					}
					Object idCurso = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(),
							0);
					Object idCursoTipo = this.vista.getTblCursos()
							.getValueAt(this.vista.getTblCursos().getSelectedRow(), 1);
					Object cursoTipo = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(),
							2);
					Object nombre = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 3);
					Object tema = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 4);
					Object temario = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(),
							5);
					System.out.println("LLLLLLegue");
					this.vista.getTextIdCurso().setText(idCurso.toString());
					this.vista.getCbxCursoTipo().setSelectedItem(
							new CursoTipoDTO(Long.parseLong(idCursoTipo.toString()), cursoTipo.toString()));
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextTema().setText(tema.toString());
					this.vista.getTextTemario().setText(temario.toString());
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblCursos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

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
			actualizarCurso();
		} else if (e.getSource() == this.vista.getBtnAgregar()) {
			agregarCurso();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			eliminarCurso();
		} else if (e.getSource() == this.vista.getBtnCerrar()) {
			cerrarVistaCurso();
		}
	}

	private void cerrarVistaCurso() {
		int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de curso!?", "Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			Conexion.getConexion().cerrarConexion();
			System.exit(0);
		}
	}

	private void eliminarCurso() {
		CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
		if (cursoTipo.getIdCursoTipo() > 0) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Se va a Eliminar el Curso seleccionado!",
					"Confirma Eliminar Registro?", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				try {
					CursoDTO curso = new CursoDTO(Long.parseLong(this.vista.getTextIdCurso().getText()),
							cursoTipo.getIdCursoTipo(), this.vista.getTextNombre().getText(),
							this.vista.getTextTema().getText(), this.vista.getTextTemario().getText());
					this.modelo.borrarCurso(curso);
					llenarTabla();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Seleccione el curso a eliminar!", "Informacion: " + "Curso Tipo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void agregarCurso() {
		if (validarCamposCurso()) {
			CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
			if (cursoTipo.getIdCursoTipo() > 0) {
				CursoDTO curso = new CursoDTO(0, cursoTipo.getIdCursoTipo(), this.vista.getTextNombre().getText(),
						this.vista.getTextTema().getText(), this.vista.getTextTemario().getText());
				this.modelo.agregarCurso(curso);
				llenarTabla();
			}
		}
	}

	private void actualizarCurso() {
		
		try {
			CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
			if (validarCamposCurso()) {
				CursoDTO curso = new CursoDTO(Long.parseLong(this.vista.getTextIdCurso().getText()),
						cursoTipo.getIdCursoTipo(), this.vista.getTextNombre().getText(),
						this.vista.getTextTema().getText(), this.vista.getTextTemario().getText());
				this.modelo.actualizarCurso(curso);
				llenarTabla();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Agregar curso antes de actualizarlo!",
					"Informacion: " + "Curso", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	private boolean validarCamposCurso() {
		CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
		if (cursoTipo.getIdCursoTipo() != 1) {
			if (!this.vista.getTextNombre().getText().toString().equals("")) {
				if (!this.vista.getTextTema().getText().toString().equals("")) {
					if (!this.vista.getTextTemario().getText().toString().equals("")) {
						return true;
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione Temario correctamente!",
								"Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Seleccione Tema correctamente!",
							"Informacion: " + "Nombre", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Seleccione Nombre correctamente!", "Informacion: " + "Tema",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Temario",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}

	private void clearTextInputsBox() {
		this.vista.getTextIdCurso().setText("");
		this.vista.getCbxCursoTipo().setSelectedItem(new CursoTipoDTO(1, ""));
		this.vista.getTextNombre().setText("");
		this.vista.getTextTema().setText("");
		this.vista.getTextTemario().setText("");
	}

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

}
