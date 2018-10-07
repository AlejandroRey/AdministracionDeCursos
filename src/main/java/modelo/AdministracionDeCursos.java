package modelo;

import java.util.List;

import dto.AlumnoDTO;
import dto.CategoriaDTO;
<<<<<<< HEAD
import dto.CursoDTO;
=======
import dto.ClaseDTO;
>>>>>>> alejandro
import dto.CursoTipoDTO;
import dto.UsuarioDTO;
import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.CategoriaDAO;
<<<<<<< HEAD
import persistencia.dao.interfaz.CursoDAO;
=======
import persistencia.dao.interfaz.ClaseDAO;
>>>>>>> alejandro
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.UsuarioDAO;

public class AdministracionDeCursos {

	private AlumnoDAO alumno;
	private UsuarioDAO usuario;
	private CategoriaDAO categoria;
	private CursoTipoDAO cursoTipo;
<<<<<<< HEAD
	private CursoDAO curso;
=======
	private ClaseDAO clase;
>>>>>>> alejandro

	public AdministracionDeCursos(DAOAbstractFactory metodo_persistencia) {
		
		this.alumno = metodo_persistencia.createAlumnoDAO();
		this.usuario = metodo_persistencia.createUsuarioDAO();		
		this.categoria = metodo_persistencia.createCategoriaDAO();
		this.cursoTipo = metodo_persistencia.createCursoTipoDAO();
<<<<<<< HEAD
		this.curso = metodo_persistencia.createCursoDAO();
=======
		this.clase = metodo_persistencia.createClaseDAO();
>>>>>>> alejandro
	}
	
	/* ****************************************************************
	 *                         Alumno
	 * ****************************************************************
	 */
	public void agregarAlumno(AlumnoDTO nuevoAlumno) {
		this.alumno.insert(nuevoAlumno);
	}

	public void borrarAlumno(AlumnoDTO alumno_a_eliminar) {
		this.alumno.delete(alumno_a_eliminar);
	}
	
	public void actualizarAlumno(AlumnoDTO alumno_a_actualizar) {
		this.alumno.update(alumno_a_actualizar);
	}
	
	public List<AlumnoDTO> obtenerAlumnos() {
		return this.alumno.readAll();
	}
	
	/* ****************************************************************
	 *                         Usuario
	 * ****************************************************************
	 */
	public void agregarUsuario(UsuarioDTO nuevoUsuario) {
		this.usuario.insert(nuevoUsuario);
	}

	public void borrarUsuario(UsuarioDTO usuario_a_eliminar) {
		this.usuario.delete(usuario_a_eliminar);
	}
	
	public void actualizarUsuario(UsuarioDTO usuario_a_actualizar) {
		this.usuario.update(usuario_a_actualizar);
	}
	
	public List<UsuarioDTO> obtenerUsuarios() {
		return this.usuario.readAll();
	}
	
	/* ****************************************************************
	 *                         Categoria
	 * ****************************************************************
	 */
	public List<CategoriaDTO> obtenerCategorias() {
		return this.categoria.readAll();
	}
	
	/* ****************************************************************
	 *                         CursoTipo
	 * ****************************************************************
	 */
	public List<CursoTipoDTO> obtenerCursoTipos() {
		return this.cursoTipo.readAll();
	}
	
	/* ****************************************************************
<<<<<<< HEAD
	 *                         Curso
	 * ****************************************************************
	 */
	public void agregarCurso(CursoDTO nuevoCurso) {
		this.curso.insert(nuevoCurso);
	}

	public void borrarCurso(CursoDTO curso_a_eliminar) {
		this.curso.delete(curso_a_eliminar);
	}
	
	public void actualizarCurso(CursoDTO curso_a_actualizar) {
		this.curso.update(curso_a_actualizar);
	}
	
	public List<CursoDTO> obtenerCursos() {
		return this.curso.readAll();
=======
	 *                         Clase
	 * ****************************************************************
	 */
	public List<ClaseDTO> obtenerClases() {
		return this.clase.readAll();
>>>>>>> alejandro
	}
	
}
