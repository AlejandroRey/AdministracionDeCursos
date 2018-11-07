package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.AlumnoDTO;
import dto.ContactoDTO;
import dto.CursoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.ContactoABMPanel;
import presentacion.vista.TareaABMPanel;
import presentacion.vista.TareaABMVistaPrincipal;

public class ContactoABMControlador implements ActionListener {
	private ContactoABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<ContactoDTO> contactosLista;
	List<CursoDTO> cursoLista;
	List<AlumnoDTO> alumnoLista;
	private TareaABMVistaPrincipal tareaABM;
	private TareaABMVistaPrincipalControlador tareaABMControlador;
	private AdministracionDeCursosVista administracionVista;
	private AdministracionDeCursosControlador administracionControlador;
	private TareaABMControlador tareaPanelABMControlador;
	private TareaABMPanel tareaPanelABM;
	
	public ContactoABMControlador(ContactoABMPanel vista, AdministracionDeCursos modelo) {
		
		this.vista = vista;
		this.modelo = modelo;
		this.contactosLista = null;
		cursoLista = modelo.obtenerCursos();
		alumnoLista = modelo.obtenerAlumnos();
		
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnSeleccionar().addActionListener(this);
		this.vista.getBtnAgregarYTareas().addActionListener(this);
	}

	public void inicializar() {
		//setCategorias();
		llenarTabla();
		//loadCategorias();
	}
	/*
	private void setCategorias() {		
		categoriaLista = modelo.obtenerCategorias();
		for (CategoriaDTO categoriaFiltroDTO : categoriaLista) {
			this.vista.getCbxCategoriaFiltro().addItem(categoriaFiltroDTO);
		}
	}
	
	private void loadCategorias() {
		this.vista.getCbxCategoria().addItem(new CategoriaDTO(0, ""));
		for (CategoriaDTO categoriaFiltroDTO : categoriaLista) {
			this.vista.getCbxCategoria().addItem(categoriaFiltroDTO);
		}
	}*/

	private void llenarTabla() {
		//categoriaLista = modelo.obtenerCategorias();
		this.vista.getModelContactos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelContactos().setColumnCount(0);
		this.vista.getModelContactos().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();
		
		long a = 0;
		this.vista.getComboBoxCursoDeInteres().addItem(new CursoDTO(a, a, "", "", ""));
		for (CursoDTO cursoDTO : cursoLista) {
			this.vista.getComboBoxCursoDeInteres().addItem(cursoDTO);
		}

		this.contactosLista = modelo.obtenerContactos();
		for (ContactoDTO contactoDTO : contactosLista) {
			Object[] fila = {contactoDTO.getIdContacto(),
							 getCursoString(contactoDTO.getIdCurso()),
							 contactoDTO.getIdAlumno(),
							 contactoDTO.getNombre(), 
							 contactoDTO.getApellido(),
							 contactoDTO.getDescripcion(),
							 contactoDTO.getTelefono(),
							 contactoDTO.getEmail(),
							 stringToLocalDateFormatter(contactoDTO.getFechaCreacion()),
							stringToLocalDateFormatter(contactoDTO.getFechaAccion())};
			this.vista.getModelContactos().addRow(fila);
			//filtro para obterner solo los instructores
			//if (contactoDTO.getIdCategoria() == 3) {
				//this.vista.getModelContactos().addRow(fila);
			//}
		}
		// Oculto los id del Objeto
		this.vista.getTblContactos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(1).setMaxWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTblContactos().getColumnModel().getColumn(2).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblContactos().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblContactos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblContactos().getSelectedRow() >= 0) {
					/*if (this.vista.getCbxCategoria().getItemCount() == 0) {
						this.vista.getCbxCategoria().addItem(new CategoriaDTO(0, ""));
						for (CategoriaDTO categoriaDTO : categoriaLista) {
							this.vista.getCbxCategoria().addItem(categoriaDTO);
						}
					}*/					
				
					Object idCurso = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 1);
					Object nombre = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 3);
					Object apellido = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 4);
					Object descripcion = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 5);
					Object telefono = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 6);
					Object email = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 7);
					Object fechaCreacion = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 8);
					Object fechaAccion = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 9);

					this.vista.getNombreField().setText(nombre.toString());
					this.vista.getApellidoField().setText(apellido.toString());
					this.vista.getDescripcionField().setText(descripcion.toString());
					this.vista.getTelefonoField().setText(telefono.toString());
					this.vista.getEmailField().setText(email.toString());
					this.vista.getFechaInteraccionField().setText(fechaCreacion.toString());
					this.vista.getProximoContactoField().setText(fechaAccion.toString());
					//this.vista.getComboBoxCursoDeInteres().setSelectedIndex(Integer.parseInt(String.valueOf(idCurso)));
					//this.vista.getComboBoxCursoDeInteres().setSelectedItem(idCurso);
					//this.vista.getComboBoxCursoDeInteres().setSelectedItem(selectCurso(idCurso));
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblContactos().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	private String getCursoString(long idCurso) {
		String cursoNombre = "";
		for (CursoDTO cursoDTO : cursoLista) {
			if (cursoDTO.getIdCurso() == idCurso) {
				cursoNombre = cursoDTO.getNombre();
			}
		}
		return cursoNombre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnActualizar()) {
			actualizarContacto();
		} else if (e.getSource() == this.vista.getBtnAgregar()) {
			agregarContacto();
		} else if (e.getSource() == this.vista.getBtnEliminar()) {
			eliminarContacto();
		} else if (e.getSource() == this.vista.getBtnSeleccionar()) {
			llenarTabla();
		} else if (e.getSource() == this.vista.getBtnAgregarYTareas()) {
			agregarContactoyGenerarTarea();
		}
	}

	private void actualizarContacto() {
		CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();
		Object idContacto = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 0);
		Object idAlumno = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 2);
		if (curso.getIdCurso() > 0) {
			AlumnoDTO alumno = new AlumnoDTO(Long.valueOf(0),
					this.vista.getNombreField().getText(),
					this.vista.getApellidoField().getText(),
					this.vista.getTelefonoField().getText(),
					this.vista.getEmailField().getText());
			ContactoDTO contacto = new ContactoDTO(Long.parseLong(idContacto.toString()),
					   curso.getIdCurso(),
					   Long.parseLong(idAlumno.toString()),
					   this.vista.getNombreField().getText(),
					   this.vista.getApellidoField().getText(),
					   this.vista.getDescripcionField().getText(),
					   this.vista.getTelefonoField().getText(),
					   this.vista.getEmailField().getText(),
					   StringToLocalDateTime(this.vista.getFechaInteraccionField().getText()),
					   StringToLocalDateTime(this.vista.getProximoContactoField().getText()));
			this.modelo.actualizarAlumno(alumno);
			this.modelo.actualizarContacto(contacto);
			llenarTabla();
		} else {
        	JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
        }
	}

	private void eliminarContacto() {        
        CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();
        Object idContacto = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 0);
        Object idAlumno = this.vista.getTblContactos().getValueAt(this.vista.getTblContactos().getSelectedRow(), 2);
        if (curso.getIdCurso() > 0) {
        	int dialogResult = JOptionPane.showConfirmDialog(null, "Se va a eliminar el contacto seleccionado", "Confirma eliminar registro?", JOptionPane.YES_NO_OPTION);
	        if (dialogResult == JOptionPane.YES_OPTION) {
	            try {
	        		ContactoDTO contacto = new ContactoDTO(Long.parseLong(idContacto.toString()),
							   curso.getIdCurso(),
							   Long.parseLong(idAlumno.toString()),
							   this.vista.getNombreField().getText(),
							   this.vista.getApellidoField().getText(),
							   this.vista.getDescripcionField().getText(),
							   this.vista.getTelefonoField().getText(),
							   this.vista.getEmailField().getText(),
							   StringToLocalDateTime(this.vista.getFechaInteraccionField().getText()),
							   StringToLocalDateTime(this.vista.getProximoContactoField().getText()));
					this.modelo.borrarContacto(contacto);
					llenarTabla();
	            } catch (Exception ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
        } else {
        	JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
        }
	}

	private void agregarContacto() {
		//CategoriaDTO categoria = (CategoriaDTO) this.vista.getCbxCategoria().getSelectedItem();
		//if (categoria.getIdCategoria() > 0) {
		CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();
		AlumnoDTO alumno = new AlumnoDTO(Long.valueOf(0),
				this.vista.getNombreField().getText(),
				this.vista.getApellidoField().getText(),
				this.vista.getTelefonoField().getText(),
				this.vista.getEmailField().getText());
			ContactoDTO contacto = new ContactoDTO(Long.valueOf(0),
						curso.getIdCurso(),
						alumno.getIdAlumno(),
					   this.vista.getNombreField().getText(),
					   this.vista.getApellidoField().getText(),
					   this.vista.getDescripcionField().getText(),
					   this.vista.getTelefonoField().getText(),
					   this.vista.getEmailField().getText(),
					   StringToLocalDateTime(this.vista.getFechaInteraccionField().getText()),
					   StringToLocalDateTime(this.vista.getProximoContactoField().getText()));		
			this.modelo.agregarContacto(contacto);
			this.modelo.agregarAlumno(alumno);
			llenarTabla();
		//} else {
		//	JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
		//}
	}
	
	private void agregarContactoyGenerarTarea() {
		//CategoriaDTO categoria = (CategoriaDTO) this.vista.getCbxCategoria().getSelectedItem();
		//if (categoria.getIdCategoria() > 0) {
		CursoDTO curso = (CursoDTO) this.vista.getComboBoxCursoDeInteres().getSelectedItem();
		AlumnoDTO alumno = new AlumnoDTO(Long.valueOf(0),
				this.vista.getNombreField().getText(),
				this.vista.getApellidoField().getText(),
				this.vista.getTelefonoField().getText(),
				this.vista.getEmailField().getText());
		ContactoDTO contacto = new ContactoDTO(Long.valueOf(0),
				curso.getIdCurso(),
				alumno.getIdAlumno(),
			   this.vista.getNombreField().getText(),
			   this.vista.getApellidoField().getText(),
			   this.vista.getDescripcionField().getText(),
			   this.vista.getTelefonoField().getText(),
			   this.vista.getEmailField().getText(),
			   StringToLocalDateTime(this.vista.getFechaInteraccionField().getText()),
			   StringToLocalDateTime(this.vista.getProximoContactoField().getText()));		
		this.modelo.agregarContacto(contacto);
		this.modelo.agregarAlumno(alumno);
		llenarTabla();
		administracionVista = new AdministracionDeCursosVista();
		administracionControlador = new AdministracionDeCursosControlador(modelo, administracionVista);
		tareaABM = new TareaABMVistaPrincipal();
		tareaABMControlador = new TareaABMVistaPrincipalControlador(modelo, tareaABM);
		tareaPanelABM = new TareaABMPanel();
		tareaPanelABMControlador = new TareaABMControlador(tareaPanelABM, modelo);
		
		this.administracionVista.getMainPanel().add(tareaABM);
		tareaPanelABMControlador.inicializar();
		tareaPanelABMControlador.setVisibleBtnAgregar();

		this.tareaABM.getMainPanel().add(tareaPanelABM);
		//this.vistaPrincipal.getMainPanel().add(tareaABM);
		//} else {
		//	JOptionPane.showMessageDialog(null, "Seleccione Curso Tipo correctamente!", "Informacion: " + "Curso Tipo", JOptionPane.INFORMATION_MESSAGE);
		//}
	}
	
	private void clearTextInputsBox() {
		this.vista.getNombreField().setText("");
		//this.vista.getComboBoxCursoDeInteres().setSelectedItem(0);
		this.vista.getComboBoxCursoDeInteres().setSelectedItem(new CursoDTO(0, 0, "", "", ""));
		this.vista.getApellidoField().setText("");
		this.vista.getTelefonoField().setText("");
		this.vista.getDescripcionField().setText("");
		this.vista.getEmailField().setText("");
		this.vista.getFechaInteraccionField().setText("");
		this.vista.getProximoContactoField().setText("");
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTblContactos().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTblContactos().setEnabled(false);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
	}
	
	public void setVisibleBtnAgregarYTareas() {
		this.vista.getTblContactos().setEnabled(false);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
		this.vista.getBtnAgregarYTareas().setVisible(true);
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTblContactos().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	public void setVisibleBtnSeleccionar() {
		this.vista.getTblContactos().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnSeleccionar().setVisible(true);		
	}	
	
	public void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
		this.vista.getBtnSeleccionar().setVisible(false);
		this.vista.getBtnAgregarYTareas().setVisible(false);
	}
	
	private String stringToLocalDateFormatter(LocalDateTime fecha) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}
	
private LocalDateTime StringToLocalDateTime(String fecha) {
		
		String date = fecha + " 00:00:00";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format);
		return dateTime;
	}
	
	private CursoDTO selectCurso(Object idCurso) {
		CursoDTO cursoDTO = null;
		for (CursoDTO curso : cursoLista) {
			if (curso.getIdCurso() == Long.parseLong(idCurso.toString())) {
				System.out.println(idCurso.toString());
				System.out.println(curso.getIdCurso());
				cursoDTO = curso;
			}
		}
		return cursoDTO;
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
