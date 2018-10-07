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

import dto.CategoriaDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import persistencia.conexion.Conexion;
import presentacion.vista.UsuarioCrudVista;

public class UsuarioCrudControlador implements ActionListener {
	
	private UsuarioCrudVista vista;
	private AdministracionDeCursos modelo;
	private List<UsuarioDTO> usuariosLista;
	List<CategoriaDTO> categoriaLista;
	
	public UsuarioCrudControlador(UsuarioCrudVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuariosLista = null;
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
		categoriaLista = modelo.obtenerCategorias();
		for (CategoriaDTO categoriaFiltroDTO : categoriaLista) {
			this.vista.getCbxCategoriaFiltro().addItem(categoriaFiltroDTO);
		}
	}

	private void llenarTabla() {
		this.vista.getModelUsuarios().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelUsuarios().setColumnCount(0);
		this.vista.getModelUsuarios().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.usuariosLista = modelo.obtenerUsuarios();
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			Object[] fila = {usuarioDTO.getIdUsuario(),
							 usuarioDTO.getIdCategoria(),
							 getCategoriaString(usuarioDTO.getIdCategoria()),
							 usuarioDTO.getNombre(), 
							 usuarioDTO.getApellido(),
							 usuarioDTO.getTelefono(),
							 usuarioDTO.getEmail(),
							 usuarioDTO.getUsuario(),
							 usuarioDTO.getPassword()};
			this.vista.getModelUsuarios().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTblUsuarios().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblUsuarios().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblUsuarios().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblUsuarios().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblUsuarios().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblUsuarios().getColumnModel().getColumn(1).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblUsuarios().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblUsuarios().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblUsuarios().getSelectedRow() >= 0) {
					if (this.vista.getCbxCategoria().getItemCount() == 0) {
						this.vista.getCbxCategoria().addItem(new CategoriaDTO(0, ""));
						for (CategoriaDTO categoriaDTO : categoriaLista) {
							this.vista.getCbxCategoria().addItem(categoriaDTO);
						}
					}					
					Object idUsuario = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 0);
					Object idCategoria = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 1);
					Object categoria = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 2);
					Object nombre = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 3);
					Object apellido = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 4);
					Object telefono = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 5);
					Object email = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 6);
					Object usuario = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 7);
					Object password = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 8);
					System.out.println("LLLLLLegue");
					this.vista.getTextIdUsuario().setText(idUsuario.toString());
					this.vista.getCbxCategoria().setSelectedItem(new CategoriaDTO(Long.parseLong(idCategoria.toString()), categoria.toString()));
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextApellido().setText(apellido.toString());
					this.vista.getTextTelefono().setText(telefono.toString());
					this.vista.getTextEmail().setText(email.toString());
					this.vista.getTextUsuario().setText(usuario.toString());
					this.vista.getTextPassword().setText(password.toString());
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblUsuarios().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private String getCategoriaString(long idCategoria) {
		String categoriaNombre = "";
		for (CategoriaDTO categoriaDTO : categoriaLista) {
			if (categoriaDTO.getIdCategoria() == idCategoria) {
				categoriaNombre = categoriaDTO.getNombre();
			}
		}
		return categoriaNombre;
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
			cerrarUsuarioVista();
		}
	}
	
	private void cerrarUsuarioVista() {
		int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de curso!?", "Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			Conexion.getConexion().cerrarConexion();
			this.vista.getFrame().dispose();
		}
	}

	private void actualizarInstructor() {
		CategoriaDTO categoria = (CategoriaDTO) this.vista.getCbxCategoria().getSelectedItem();
		if (categoria.getIdCategoria() > 0) {
			UsuarioDTO usuario = new UsuarioDTO(Long.parseLong(this.vista.getTextIdUsuario().getText()), 
												categoria.getIdCategoria(), 
												   this.vista.getTextNombre().getText(),
												   this.vista.getTextApellido().getText(),
												   this.vista.getTextTelefono().getText(),
												   this.vista.getTextEmail().getText(),
												   this.vista.getTextUsuario().getText(),
												   String.valueOf(this.vista.getTextPassword().getPassword()));
			this.modelo.actualizarUsuario(usuario);
			llenarTabla();
		} else {
        	JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
        }
	}

	private void eliminarInstructor() {        
        CategoriaDTO categoria = (CategoriaDTO) this.vista.getCbxCategoria().getSelectedItem();
        if (categoria.getIdCategoria() > 0) {
        	int dialogResult = JOptionPane.showConfirmDialog(null, "Se va a Eliminar el Instructor seleccionado!", "Confirma Eliminar Registro?", JOptionPane.YES_NO_OPTION);
	        if (dialogResult == JOptionPane.YES_OPTION) {
	            try {
	        		UsuarioDTO usuario = new UsuarioDTO(Long.parseLong(this.vista.getTextIdUsuario().getText()),
							   categoria.getIdCategoria(),
							   this.vista.getTextNombre().getText(),
							   this.vista.getTextApellido().getText(),
							   this.vista.getTextTelefono().getText(),
							   this.vista.getTextEmail().getText(),
							   this.vista.getTextUsuario().getText(),
							   String.valueOf(this.vista.getTextPassword().getPassword()));
					this.modelo.borrarUsuario(usuario);
					llenarTabla();
	            } catch (Exception ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
        } else {
        	JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
        }
	}

	private void agregarInstructor() {
		CategoriaDTO categoria = (CategoriaDTO) this.vista.getCbxCategoria().getSelectedItem();
		if (categoria.getIdCategoria() > 0) {
			UsuarioDTO usuario = new UsuarioDTO(0,
					   categoria.getIdCategoria(),
					   this.vista.getTextNombre().getText(),
					   this.vista.getTextApellido().getText(),
					   this.vista.getTextTelefono().getText(),
					   this.vista.getTextEmail().getText(),
					   this.vista.getTextUsuario().getText(),
					   String.valueOf(this.vista.getTextPassword().getPassword()));		
			this.modelo.agregarUsuario(usuario);
			llenarTabla();
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void clearTextInputsBox() {
		this.vista.getTextIdUsuario().setText("");
		this.vista.getCbxCategoria().setSelectedItem(new CategoriaDTO(0, ""));
		this.vista.getTextNombre().setText("");
		this.vista.getTextApellido().setText("");
		this.vista.getTextTelefono().setText("");
		this.vista.getTextEmail().setText("");
		this.vista.getTextUsuario().setText("");
		this.vista.getTextPassword().setText("");
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
