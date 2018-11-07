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

import dto.ContactoDTO;
import dto.CursoDTO;
import dto.CursoTipoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.CursoABMPanel;

public class CursoABMControlador implements ActionListener {

	private CursoABMPanel vista;
	private AdministracionDeCursos modelo;
	
	private List<CursoDTO> cursosLista;
	private List<CursoTipoDTO> cursoTipoLista;
	
	private List<ContactoDTO> contactosLista;

	public CursoABMControlador(CursoABMPanel vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.cursosLista = null;
		this.contactosLista = null;
		
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnConsultarInteresados().addActionListener(this);
	}

	public void inicializar() {
		setCursos();
		llenarTabla();
	}

	private void setCursos() {
		cursoTipoLista = modelo.obtenerCursoTipos();
		CursoTipoDTO c = new CursoTipoDTO(0, "");
		this.vista.getCbxCursoTipo().addItem(c);
		
		for (CursoTipoDTO cursoTipoDTO : cursoTipoLista) {
			this.vista.getCbxCursoTipo().addItem(cursoTipoDTO);
		}
	}
	
	private void vaciarTablaInteresados() {
		this.vista.getModelInteresados().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelInteresados().setColumnCount(0);
		this.vista.getModelInteresados().setColumnIdentifiers(this.vista.getNombreColumnasInteresados());
		
		/*this.vista.getTableInteresados().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTableInteresados().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTableInteresados().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTableInteresados().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTableInteresados().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTableInteresados().getColumnModel().getColumn(1).setMaxWidth(0);*/
	}
	
	private void llenarTablaInteresados() {
		this.contactosLista = modelo.obtenerContactos();
		for (ContactoDTO contactoDTO : contactosLista) {
			Object[] fila = {contactoDTO.getNombre(), contactoDTO.getApellido(), 
					contactoDTO.getEmail(), contactoDTO.getFechaCreacion()};
			if (contactoDTO.getIdCurso() == Long.parseLong(this.vista.getTextIdCurso().getText())) {
				this.vista.getModelInteresados().addRow(fila);
			}
		}
	}

	private void llenarTabla() {
		this.vista.getModelCursos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelCursos().setColumnCount(0);
		this.vista.getModelCursos().setColumnIdentifiers(this.vista.getNombreColumnas());
		vaciarTablaInteresados();
		
		clearTextInputsBox();

		this.cursosLista = modelo.obtenerCursos();
		for (CursoDTO cursoDTO : cursosLista) {
			Object[] fila = { cursoDTO.getIdCurso(), cursoDTO.getIdCursoTipo(),
					getCursoTipoString(cursoDTO.getIdCursoTipo()), cursoDTO.getNombre(), cursoDTO.getTema(),
					cursoDTO.getTemario() };
			this.vista.getModelCursos().addRow(fila);
		}

		// Oculto los id del Objeto
		this.vista.getTblCursos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(1).setMaxWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(5).setWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(5).setMinWidth(0);
		this.vista.getTblCursos().getColumnModel().getColumn(5).setMaxWidth(0);

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
					Object idCurso = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 0);
					Object idCursoTipo = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 1);
					Object cursoTipo = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(),	2);
					Object nombre = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 3);
					Object tema = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 4);
					Object temario = this.vista.getTblCursos().getValueAt(this.vista.getTblCursos().getSelectedRow(), 5);
					this.vista.getTextIdCurso().setText(idCurso.toString());
					this.vista.getCbxCursoTipo().setSelectedItem(
							new CursoTipoDTO(Long.parseLong(idCursoTipo.toString()), cursoTipo.toString()));
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextTema().setText(tema.toString());
					this.vista.getTextAreaTemario().setText(temario.toString());
					vaciarTablaInteresados();
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
		} else if (e.getSource() == this.vista.getBtnSeleccionar()) {
			llenarTabla();
		} else if (e.getSource() == this.vista.getBtnConsultarInteresados()) {
			llenarTablaInteresados();
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
							this.vista.getTextTema().getText(), this.vista.getTextAreaTemario().getText());
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
//		if (validarCamposCurso()) {
			CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
			if (cursoTipo.getIdCursoTipo() > 0) {
				CursoDTO curso = new CursoDTO(0, cursoTipo.getIdCursoTipo(), this.vista.getTextNombre().getText(),
						this.vista.getTextTema().getText(), this.vista.getTextAreaTemario().getText());
				this.modelo.agregarCurso(curso);
				llenarTabla();
//s			}
		}
	}

	private void actualizarCurso() {
		
		try {
			CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
//			if (validarCamposCurso()) {
				CursoDTO curso = new CursoDTO(Long.parseLong(this.vista.getTextIdCurso().getText()),
						cursoTipo.getIdCursoTipo(), this.vista.getTextNombre().getText(),
						this.vista.getTextTema().getText(), this.vista.getTextAreaTemario().getText());
				this.modelo.actualizarCurso(curso);
				llenarTabla();
//			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Agregar curso antes de actualizarlo!",
					"Informacion: " + "Curso", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

//	private boolean validarCamposCurso() {
//		CursoTipoDTO cursoTipo = (CursoTipoDTO) this.vista.getCbxCursoTipo().getSelectedItem();
//		if (cursoTipo.getIdCursoTipo() != 1) {
//			if (!this.vista.getTextNombre().getText().toString().equals("")) {
//				if (!this.vista.getTextTema().getText().toString().equals("")) {
//					if (!this.vista.getTextAreaTemario().getText().toString().equals("")) {
//						return true;
//					} else {
//						JOptionPane.showMessageDialog(null, "Seleccione Temario correctamente!",
//								"Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
//					}
//
//				} else {
//					JOptionPane.showMessageDialog(null, "Seleccione Tema correctamente!",
//							"Informacion: " + "Nombre", JOptionPane.INFORMATION_MESSAGE);
//				}
//
//			} else {
//				JOptionPane.showMessageDialog(null, "Seleccione Nombre correctamente!", "Informacion: " + "Tema",
//						JOptionPane.INFORMATION_MESSAGE);
//			}
//
//		} else {
//			JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Temario",
//					JOptionPane.INFORMATION_MESSAGE);
//		}
//		return false;
//	}

	private void clearTextInputsBox() {
		this.vista.getTextIdCurso().setText("");
		this.vista.getCbxCursoTipo().setSelectedItem(new CursoTipoDTO(0, ""));
		this.vista.getTextNombre().setText("");
		this.vista.getTextTema().setText("");
		this.vista.getTextAreaTemario().setText("");
		vaciarTablaInteresados();
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTblCursos().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTblCursos().setEnabled(false);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTblCursos().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	public void setVisibleBtnSeleccionar() {
		this.vista.getTblCursos().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnSeleccionar().setVisible(true);
		this.vista.getBtnConsultarInteresados().setVisible(true);
	}
	
	public void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
		this.vista.getBtnSeleccionar().setVisible(false);
		this.vista.getBtnConsultarInteresados().setVisible(false);
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
