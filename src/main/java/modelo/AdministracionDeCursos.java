package modelo;

import java.util.List;

import dto.AlumnoDTO;
import dto.CategoriaDTO;
import dto.CursadaDTO;
import dto.CursoDTO;
import dto.ClaseDTO;
import dto.CursoTipoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import dto.SalaDTO;
import dto.UsuarioDTO;
import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.CursoDAO;
import persistencia.dao.interfaz.ClaseDAO;
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.UsuarioDAO;
import persistencia.dao.interfaz.EmpresaDAO;
import persistencia.dao.interfaz.SalaDAO;
import persistencia.dao.interfaz.EstadoDeCursoDAO;
import persistencia.dao.interfaz.CursadaDAO;

public class AdministracionDeCursos {

	private AlumnoDAO alumno;
	private UsuarioDAO usuario;
	private CategoriaDAO categoria;
	private CursoTipoDAO cursoTipo;
	private CursoDAO curso;
	private ClaseDAO clase;
	private EmpresaDAO empresa;
	private SalaDAO sala;
	private EstadoDeCursoDAO estadoDeCurso;
	private CursadaDAO cursada;

	public AdministracionDeCursos(DAOAbstractFactory metodo_persistencia) {
		
		this.alumno = metodo_persistencia.createAlumnoDAO();
		this.usuario = metodo_persistencia.createUsuarioDAO();		
		this.categoria = metodo_persistencia.createCategoriaDAO();
		this.cursoTipo = metodo_persistencia.createCursoTipoDAO();
		this.curso = metodo_persistencia.createCursoDAO();
		this.clase = metodo_persistencia.createClaseDAO();
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
	}
	
	/*                        Clase
	 * ****************************************************************
	 */
	public List<ClaseDTO> obtenerClases() {
		return this.clase.readAll();
	}

	/* ****************************************************************
	 *                         Estado De Curso
	 * ****************************************************************
	 */
	public List<EstadoDeCursoDTO> obtenerEstadosDeCurso() {
		return this.estadoDeCurso.readAll();
	}

	/* ****************************************************************
	 *                         Sala
	 * ****************************************************************
	 */
	public void agregarSala(SalaDTO nuevaSala) {
		this.sala.insert(nuevaSala);
	}

	public void borrarSala(SalaDTO sala_a_eliminar) {
		this.sala.delete(sala_a_eliminar);
	}
	
	public void actualizarSala(SalaDTO sala_a_actualizar) {
		this.sala.update(sala_a_actualizar);
	}
	
	public List<SalaDTO> obtenerSalas() {
		return this.sala.readAll();
	}

	/* ****************************************************************
	 *                         Empresa
	 * ****************************************************************
	 */
	public void agregarEmpresa(EmpresaDTO nuevaEmpresa) {
		this.empresa.insert(nuevaEmpresa);
	}

	public void borrarEmpresa(EmpresaDTO empresa_a_eliminar) {
		this.empresa.delete(empresa_a_eliminar);
	}
	
	public void actualizarEmpresa(EmpresaDTO empresa_a_actualizar) {
		this.empresa.update(empresa_a_actualizar);
	}
	
	public List<EmpresaDTO> obtenerEmpresas() {
		return this.empresa.readAll();
	}

	/* ****************************************************************
	 *                         Cursada
	 * ****************************************************************
	 */
	public void agregarCursada(CursadaDTO nuevaCursada) {
		this.cursada.insert(nuevaCursada);
	}

	public void borrarCursada(CursadaDTO cursada_a_eliminar) {
		this.cursada.delete(cursada_a_eliminar);
	}
	
	public void actualizarCursada(CursadaDTO cursada_a_actualizar) {
		this.cursada.update(cursada_a_actualizar);
	}
	
	public List<CursadaDTO> obtenerCursadas() {
		return this.cursada.readAll();
	}
	
}
