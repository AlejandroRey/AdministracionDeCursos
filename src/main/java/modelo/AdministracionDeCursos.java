package modelo;

import java.util.List;

import dto.AlumnoDTO;
import dto.AlumnoEventoDTO;
import dto.AlumnoInscriptoDTO;
import dto.CategoriaDTO;
import dto.CursadaDTO;
import dto.CursoDTO;
import dto.ClaseDTO;
import dto.ContactoDTO;
import dto.CursadaCompletaDTO;
import dto.CursoTipoDTO;
import dto.DiaCursadaClaseDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import dto.FechaCursadaClaseDTO;
import dto.InscriptoDTO;
import dto.SalaDTO;
import dto.SalaDisponibleDTO;
import dto.TareaDTO;
import dto.UsuarioDTO;
import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.AlumnoEventoDAO;
import persistencia.dao.interfaz.AlumnoInscriptoDAO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.CursoDAO;
import persistencia.dao.interfaz.ClaseDAO;
import persistencia.dao.interfaz.ContactoDAO;
import persistencia.dao.interfaz.CursadaCompletaDAO;
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DiaCursadaClaseDAO;
import persistencia.dao.interfaz.UsuarioDAO;
import persistencia.dao.interfaz.EmpresaDAO;
import persistencia.dao.interfaz.SalaDAO;
import persistencia.dao.interfaz.SalaDisponibleDAO;
import persistencia.dao.interfaz.EstadoDeCursoDAO;
import persistencia.dao.interfaz.FechaCursadaClaseDAO;
import persistencia.dao.interfaz.CursadaDAO;
import persistencia.dao.interfaz.InscriptoDAO;
import persistencia.dao.interfaz.TareaDAO;

public class AdministracionDeCursos {

	private AlumnoDAO alumno;
	private AlumnoEventoDAO alumnoEvento;
	private UsuarioDAO usuario;
	private CategoriaDAO categoria;
	private ContactoDAO contacto;
	private CursoTipoDAO cursoTipo;
	private CursoDAO curso;
	private ClaseDAO clase;
	private DiaCursadaClaseDAO diaCursadaClase;
	private EmpresaDAO empresa;
	private SalaDAO sala;
	private EstadoDeCursoDAO estadoDeCurso;
	private CursadaDAO cursada;
	private CursadaCompletaDAO cursadaCompleta;
	private AlumnoInscriptoDAO alumnoInscripto;
	private InscriptoDAO inscripto;
	private FechaCursadaClaseDAO fechaCursadaClase;
	private TareaDAO tarea;
	private SalaDisponibleDAO salaDisponible;

	public AdministracionDeCursos(DAOAbstractFactory metodo_persistencia) {
		
		this.alumno = metodo_persistencia.createAlumnoDAO();
		this.alumnoEvento = metodo_persistencia.createAlumnoEventoDAO();
		this.usuario = metodo_persistencia.createUsuarioDAO();		
		this.categoria = metodo_persistencia.createCategoriaDAO();
		this.contacto = metodo_persistencia.createContactoDAO();
		this.cursoTipo = metodo_persistencia.createCursoTipoDAO();
		this.curso = metodo_persistencia.createCursoDAO();
		this.clase = metodo_persistencia.createClaseDAO();
		this.diaCursadaClase = metodo_persistencia.createDiaCursadaClaseDAO();
		this.empresa = metodo_persistencia.createEmpresaDAO();
		this.estadoDeCurso = metodo_persistencia.createEstadoDeCursoDAO();
		this.sala = metodo_persistencia.createSalaDAO();
		this.cursada = metodo_persistencia.createCursadaDAO();
		this.cursadaCompleta = metodo_persistencia.createCursadaCompletaDAO();
		this.alumnoInscripto = metodo_persistencia.createAlumnoInscriptoDAO();
		this.inscripto = metodo_persistencia.createInscriptoDAO();
		this.fechaCursadaClase = metodo_persistencia.createFechaCursadaClaseDAO();
		this.tarea = metodo_persistencia.createTareaDAO();
		this.salaDisponible = metodo_persistencia.createSalaDisponibleDAO();
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
	 *                         AlumnoEvento
	 * ****************************************************************
	 */
	public void agregarAlumnoEvento(AlumnoEventoDTO nuevoAlumnoEvento) {
		this.alumnoEvento.insert(nuevoAlumnoEvento);
	}

	public void borrarAlumno(AlumnoEventoDTO alumnoEvento_a_eliminar) {
		this.alumnoEvento.delete(alumnoEvento_a_eliminar);
	}
	
	public void actualizarAlumnoEvento(AlumnoEventoDTO alumnoEvento_a_actualizar) {
		this.alumnoEvento.update(alumnoEvento_a_actualizar);
	}
	
	public List<AlumnoEventoDTO> obtenerAlumnoEventos() {
		return this.alumnoEvento.readAll();
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
	 *                         Contacto
	 * ****************************************************************
	 */
	public void agregarContacto(ContactoDTO nuevoContacto) {
		this.contacto.insert(nuevoContacto);
	}

	public void borrarContacto(ContactoDTO contacto_a_eliminar) {
		this.contacto.delete(contacto_a_eliminar);
	}
	
	public void actualizarContacto(ContactoDTO contacto_a_actualizar) {
		this.contacto.update(contacto_a_actualizar);
	}
	
	public List<ContactoDTO> obtenerContactos() {
		return this.contacto.readAll();
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
	
	/* ****************************************************************
	 *                         Clase
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
		System.out.println("MODELO");
		this.cursada.update(cursada_a_actualizar);
	}
	
	public List<CursadaDTO> obtenerCursadas() {
		return this.cursada.readAll();
	}
	
	/* ****************************************************************
	 *                         CursadaCompleta
	 * ****************************************************************
	 */
	
	public List<CursadaCompletaDTO> obtenerCursadasCompletas() {
		return this.cursadaCompleta.readAll();
	}
	
	/* ****************************************************************
	 *                         AlumnoInscripto
	 * ****************************************************************
	 */
	
	public List<AlumnoInscriptoDTO> obtenerAlumnosInscriptos(CursadaDTO cursada) {
		return this.alumnoInscripto.readAll(cursada);
	}
	
	/* ****************************************************************
	 *                         Inscripto
	 * ****************************************************************
	 */
	public void agregarInscripto(InscriptoDTO nuevoInscripto) {
		this.inscripto.insert(nuevoInscripto);
	}

	public void borrarInscripto(InscriptoDTO inscripto_a_eliminar) {
		this.inscripto.delete(inscripto_a_eliminar);
	}
	
	public void actualizarInscripto(InscriptoDTO inscripto_a_actualizar) {
		this.inscripto.update(inscripto_a_actualizar);
	}
	
	public List<InscriptoDTO> obtenerInscriptos() {
		return this.inscripto.readAll();
	}
	
	/* ****************************************************************
	 *                         DiaCursadaClase
	 * ****************************************************************
	 */
	public void agregarDiaCursadaClase(DiaCursadaClaseDTO nuevoDiaCursadaClaseDTO) {
		this.diaCursadaClase.insert(nuevoDiaCursadaClaseDTO);
	}	

	public void borrarDiaCursadaClase(DiaCursadaClaseDTO dia_a_eliminar) {
		this.diaCursadaClase.delete(dia_a_eliminar);
	}
	
	public void actualizarDiaCursadaClase(DiaCursadaClaseDTO diaCursadaClaseDTO_a_actualizar) {
		this.diaCursadaClase.update(diaCursadaClaseDTO_a_actualizar);
	}
	
	public List<DiaCursadaClaseDTO> obtenerDiaCursadaClase(CursadaDTO cursada) {
		return this.diaCursadaClase.readAll(cursada);
	}
	
	/* ****************************************************************
	 *                         FechaCursadaClase
	 * ****************************************************************
	 */
	public void agregarFechaCursadaClase(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		this.fechaCursadaClase.insert(fechaCursadaClaseDTO);
	}

	public void borrarFechaCursadaClase(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		this.fechaCursadaClase.delete(fechaCursadaClaseDTO);
	}
	
	public void actualizarFechaCursadaClase(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		this.fechaCursadaClase.update(fechaCursadaClaseDTO);
	}
	
	public List<FechaCursadaClaseDTO> obtenerFechaCursadaClase(CursadaDTO cursadaDTO) {
		return this.fechaCursadaClase.readAll(cursadaDTO);
	}
	
	/* ****************************************************************
	 *                         Tarea
	 * ****************************************************************
	 */
	public void agregarTarea(TareaDTO tareaDTO) {
		this.tarea.insert(tareaDTO);
	}

	public void borrarTarea(TareaDTO tareaDTO) {
		this.tarea.delete(tareaDTO);
	}
	
	public void actualizarTarea(TareaDTO tareaDTO) {
		this.tarea.update(tareaDTO);
	}
	
	public List<TareaDTO> obtenerTareas() {
		return this.tarea.readAll();
	}
	
	/* ****************************************************************
	 *                         Sala Disponible
	 * ****************************************************************
	 */
	
	public List<SalaDisponibleDTO> obtenerSalaDisponible(FechaCursadaClaseDTO fechaCursadaDTO, SalaDTO salaDTO) {
		return this.salaDisponible.readAll(fechaCursadaDTO, salaDTO);
	}
	
}
