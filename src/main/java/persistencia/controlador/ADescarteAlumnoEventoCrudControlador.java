package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;


import dto.AlumnoDTO;
import dto.AlumnoEventoDTO;
import dto.CursoDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoEventoCrudVista;

public class ADescarteAlumnoEventoCrudControlador implements ActionListener {

	private AlumnoEventoCrudVista vista;
	private AdministracionDeCursos modelo;
	private List<AlumnoEventoDTO> alumnoEventosLista;
	private List<AlumnoDTO> alumnosLista;
	private List<UsuarioDTO> usuariosLista;
	private List<CursoDTO> cursosLista;

	public ADescarteAlumnoEventoCrudControlador(AlumnoEventoCrudVista vista, AdministracionDeCursos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.alumnoEventosLista = null;
		this.alumnosLista = null;
		this.usuariosLista = null;
		this.cursosLista = null;
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnCerrar().addActionListener(this);
	}

	public void inicializar() {
		setAlumnos();
		setUsuarios();
		setCursos();
		llenarTabla();
		this.vista.show();
	}
	
	private void setCursos() {
		cursosLista = modelo.obtenerCursos();
		for (CursoDTO cursoDTO : cursosLista) {
			this.vista.getCbxIdCurso().addItem(cursoDTO);
		}
	}

	private void setUsuarios() {
		usuariosLista = modelo.obtenerUsuarios();
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			this.vista.getCbxIdUsuario().addItem(usuarioDTO);
		}
	}

	private void setAlumnos() {
		alumnosLista = modelo.obtenerAlumnos();
		for (AlumnoDTO alumnoDTO : alumnosLista) {
			this.vista.getCbxIdAlumno().addItem(alumnoDTO);
		}
	}
	
	private void llenarTabla() {
		this.vista.getModelAlumnoEventos().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelAlumnoEventos().setColumnCount(0);
		this.vista.getModelAlumnoEventos().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();
				
		this.alumnoEventosLista = modelo.obtenerAlumnoEventos();
		for (AlumnoEventoDTO alumnoEventoDTO : alumnoEventosLista) {
			Object[] fila = 
					{alumnoEventoDTO.getIdAlumnoEvento(), 
					getAlumnoNombre(alumnoEventoDTO.getIdAlumno()),
					getUsuarioNombre(alumnoEventoDTO.getIdUsuario()), 
					getCursoNombre(alumnoEventoDTO.getIdCurso()), 
					alumnoEventoDTO.getDescripcion(),
					alumnoEventoDTO.getFechaContactar(),
					alumnoEventoDTO.getFechaCreacion(),
					alumnoEventoDTO.isEstado()};
			this.vista.getModelAlumnoEventos().addRow(fila);
		}
		
		// Oculto los id del Objeto
		this.vista.getTblAlumnoEventos().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblAlumnoEventos().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblAlumnoEventos().getColumnModel().getColumn(0).setMaxWidth(0);
		
	}
	
	private String getCursoNombre(long idCurso) {
		String cursoNombre = "";
		for (CursoDTO cursoDTO : cursosLista) {
			if (cursoDTO.getIdCurso() == idCurso) {
				cursoNombre = cursoDTO.getNombre();
			}
		}
		return cursoNombre;
	}
	
	private String getUsuarioNombre(long idUsuario) {
		String usuarioNombre = "";
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			if (usuarioDTO.getIdUsuario() == idUsuario) {
				usuarioNombre = usuarioDTO.getNombre();
			}
		}
		return usuarioNombre;
	}
	
	private String getAlumnoNombre(long idAlumno) {
		String alumnoNombre = "";
		for (AlumnoDTO alumnoDTO : alumnosLista) {
			if (alumnoDTO.getIdAlumno() == idAlumno) {
				alumnoNombre = alumnoDTO.getNombre();
			}
		}
		return alumnoNombre;
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
		// TODO Auto-generated method stub
		
	}

	private void eliminarCurso() {
		// TODO Auto-generated method stub
		
	}

	private void agregarCurso() {
		// TODO Auto-generated method stub
		
	}

	private void actualizarCurso() {
		// TODO Auto-generated method stub
		
	}

	private void clearTextInputsBox() {
		this.vista.getTextIdAlumnoEvento().setText("");
		this.vista.getCbxIdAlumno().setSelectedItem(new AlumnoDTO(1, "", null, null, null));
		this.vista.getCbxIdUsuario().setSelectedItem(new UsuarioDTO(1, 0, "", null, null, null, null, null));
		this.vista.getCbxIdCurso().setSelectedItem(new CursoDTO(1, 0, "", null, null));
		this.vista.getTextDescripcion().setText("");
		this.vista.getRdbtnAbierto().setSelected(false);
		this.vista.getRdbtnCerrado().setSelected(false);
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
