package modelo;

import java.util.List;

import dto.AlumnoAsistenciaQtyDTO;
import dto.AlumnoDTO;
import dto.ContactoCompletoDTO;
import dto.ContactoDTO;
import dto.AlumnoInscriptoDTO;
import dto.AsistenciaDTO;
import dto.CategoriaDTO;
import dto.ContactoTareaDTO;
import dto.CursadaDTO;
import dto.CursoDTO;
import dto.ClaseDTO;
import dto.CursadaCompletaDTO;
import dto.CursoTipoDTO;
import dto.DiaCursadaClaseDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import dto.EvaluacionCursadaDTO;
import dto.EvaluacionDTO;
import dto.EvaluacionTipoDTO;
import dto.FechaCursadaClaseDTO;
import dto.FeriadoDTO;
import dto.InscriptoDTO;
import dto.NotaDTO;
import dto.NotificacionDTO;
import dto.RecadoDTO;
import dto.SalaDTO;
import dto.SalaDisponibilidadDTO;
import dto.SalaDisponibleDTO;
import dto.TareaDTO;
import dto.UsuarioDTO;
import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.AlumnoInscriptoDAO;
import persistencia.dao.interfaz.AsistenciaDAO;
import persistencia.dao.interfaz.AlumnoAsistenciaQtyDAO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.CursoDAO;
import persistencia.dao.interfaz.ClaseDAO;
import persistencia.dao.interfaz.ContactoDAO;
import persistencia.dao.interfaz.ContactoCompletoDAO;
import persistencia.dao.interfaz.CursadaCompletaDAO;
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DiaCursadaClaseDAO;
import persistencia.dao.interfaz.UsuarioDAO;
import persistencia.dao.interfaz.EmpresaDAO;
import persistencia.dao.interfaz.SalaDAO;
import persistencia.dao.interfaz.SalaDisponibleDAO;
import persistencia.dao.interfaz.SalaDisponibilidadDAO;
import persistencia.dao.interfaz.EstadoDeCursoDAO;
import persistencia.dao.interfaz.FechaCursadaClaseDAO;
import persistencia.dao.interfaz.FeriadoDAO;
import persistencia.dao.interfaz.CursadaDAO;
import persistencia.dao.interfaz.InscriptoDAO;
import persistencia.dao.interfaz.TareaDAO;
import persistencia.dao.interfaz.EvaluacionDAO;
import persistencia.dao.interfaz.EvaluacionTipoDAO;
import persistencia.dao.interfaz.EvaluacionCursadaDAO;
import persistencia.dao.interfaz.NotaDAO;
import persistencia.dao.interfaz.NotificacionDAO;
import persistencia.dao.interfaz.RecadoDAO;
import persistencia.dao.interfaz.ContactoTareaDAO;

public class AdministracionDeCursos {

	private AlumnoDAO alumno;
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
	private SalaDisponibilidadDAO salaDisponibilidad;
	private FeriadoDAO feriado;
	private AsistenciaDAO asistencia;
	private AlumnoAsistenciaQtyDAO alumnoAsistenciaQty;
	private EvaluacionDAO evaluacionDAO;
	private EvaluacionTipoDAO evaluacionTipoDAO;
	private EvaluacionCursadaDAO evaluacionCursadaDAO;
	private NotaDAO notaDAO;
	private NotificacionDAO notificacion;
	private RecadoDAO recadoDAO;
	private ContactoCompletoDAO contactoCompleto;
	private UsuarioDTO usuarioLogueado;
	private ContactoTareaDAO contactoTareaDAO;

	public AdministracionDeCursos(DAOAbstractFactory metodo_persistencia) {
		this.usuarioLogueado = null;
		this.alumno = metodo_persistencia.createAlumnoDAO();
		this.usuario = metodo_persistencia.createUsuarioDAO();		
		this.categoria = metodo_persistencia.createCategoriaDAO();
		this.contacto = metodo_persistencia.createContactoDAO();
		this.contactoCompleto = metodo_persistencia.createContactoCompletoDAO();
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
		this.salaDisponibilidad = metodo_persistencia.createSalaDisponibilidadDAO();
		this.feriado = metodo_persistencia.createFeriadoDAO();
		this.asistencia = metodo_persistencia.createAsistenciaDAO();
		this.alumnoAsistenciaQty = metodo_persistencia.createAlumnoAsistenciaQtyDAO();
		this.evaluacionDAO = metodo_persistencia.createEvaluacionDAO();
		this.evaluacionTipoDAO = metodo_persistencia.createEvaluacionTipoDAO();
		this.evaluacionCursadaDAO = metodo_persistencia.createEvaluacionCursadaDAO();
		this.notaDAO = metodo_persistencia.createNotaDAO();
		this.notificacion = metodo_persistencia.createNotificacionDAO();
		this.recadoDAO = metodo_persistencia.createRecadoDAO();
		this.contactoTareaDAO = metodo_persistencia.createContactoTareaDAO();
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
	 *                         Notificacion
	 * ****************************************************************
	 */
	public void agregarNotificacion(NotificacionDTO nuevaNotificacion) {
		this.notificacion.insert(nuevaNotificacion);
	}

	public void borrarNotificacion(NotificacionDTO notificacion_a_eliminar) {
		this.notificacion.delete(notificacion_a_eliminar);
	}
	
	public void actualizarNotificacion(NotificacionDTO notificacion_a_actualizar) {
		this.notificacion.update(notificacion_a_actualizar);
	}
	
	public List<NotificacionDTO> obtenerNotificaciones() {
		return this.notificacion.readAll();
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
	
	public List<ContactoCompletoDTO> obtenerContactosCompletos() {
		return this.contactoCompleto.readAll();
	}
	
	public List<ContactoCompletoDTO> obtenerContactosInteresados(CursoDTO curso) {
		return this.contactoCompleto.readAllInteresados(curso);
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
	
	public CursoDTO obtenerCurso(long id) {
		return this.curso.obtenerCurso(id);
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
		this.cursada.update(cursada_a_actualizar);
	}
	
	public List<CursadaDTO> obtenerCursadas() {
		return this.cursada.readAll();
	}
	
	public CursadaDTO obtenerCursadasPorId(long idCursada) {
		return this.cursada.readAllById(idCursada);
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
	
	public List<FechaCursadaClaseDTO> obtenerFechaCursadaClase(SalaDTO salaDTO) {
		return this.fechaCursadaClase.readAll(salaDTO);
	}
	
	public FechaCursadaClaseDTO obtenerFechaCursadaClase(long idFechaCursadaClase) {
		return this.fechaCursadaClase.getFechaCursadaClase(idFechaCursadaClase);
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
	
	/* ****************************************************************
	 *                         Sala Disponibilidad
	 * ****************************************************************
	 */
	
	public List<SalaDisponibilidadDTO> obtenerSalaDisponibilidad(SalaDTO salaDTO) {
		return this.salaDisponibilidad.readAll(salaDTO);
	}
	/*                         Feriados
	 * ****************************************************************
	 */
	public List<FeriadoDTO> obtenerFeriados(int year) {
		return this.feriado.readAll(year);
	}
	
	/* ****************************************************************
	 *                         Asistencia
	 * ****************************************************************
	 */
	public void agregarAsistencia(AsistenciaDTO	asistenciaDTO) {
		this.asistencia.insert(asistenciaDTO);
	}

	public void borrarAsistencia(AsistenciaDTO asistenciaDTO) {
		this.asistencia.delete(asistenciaDTO);
	}
	
	public void actualizarAsistencia(AsistenciaDTO	asistenciaDTO) {
		this.asistencia.update(asistenciaDTO);
	}
	
	public List<AsistenciaDTO> obtenerAsistencia(FechaCursadaClaseDTO fechaCursadaDTO){
		return this.asistencia.readAll(fechaCursadaDTO);
	}
	
	/* ****************************************************************
	 *                         AsistenciaAlumno
	 * ****************************************************************
	 */
	public List<AlumnoAsistenciaQtyDTO> obtenerAlumnosAsistenciasQty(CursadaDTO cursadaDTO) {
		return this.alumnoAsistenciaQty.readAll(cursadaDTO);
	}
	
	/* ****************************************************************
	 *                         Evaluacion
	 * ****************************************************************
	 */
	public List<EvaluacionDTO> obtenerEvaluacionCursada(CursadaDTO cursadaDTO){
		return this.evaluacionDAO.readAll(cursadaDTO);
	}
	
	/* ****************************************************************
	 *                         EvaluacionTipo
	 * ****************************************************************
	 */
	public List<EvaluacionTipoDTO> obtenerEvaluacionTipo(){
		return this.evaluacionTipoDAO.readAll();
	}
	
	/* ****************************************************************
	 *                         EvaluacionCursadaDTO
	 * ****************************************************************
	 */	
	public void agregarEvaluacionCursada(EvaluacionCursadaDTO evaluacionCursadaDTO) {
		this.evaluacionCursadaDAO.insert(evaluacionCursadaDTO);
	}

	public void borrarEvaluacionCursada(EvaluacionCursadaDTO evaluacionCursadaDTO) {
		this.evaluacionCursadaDAO.delete(evaluacionCursadaDTO);
	}
	
	public void actualizarEvaluacionCursada(EvaluacionCursadaDTO evaluacionCursadaDTO) {
		this.evaluacionCursadaDAO.update(evaluacionCursadaDTO);
	}
	
	/* ****************************************************************
	 *                         EvaluacionCursadaDTO
	 * ****************************************************************
	 */
	public void agregarNota(NotaDTO notaDTO) {
		this.notaDAO.insert(notaDTO);
	}

	public void borrarNota(NotaDTO notaDTO) {
		this.notaDAO.delete(notaDTO);
	}

	public void actualizarNota(NotaDTO notaDTO) {
		this.notaDAO.update(notaDTO);
	}

	public List<NotaDTO> obtenerNotas(EvaluacionDTO evaluacionDTO) {
		return this.notaDAO.readAll(evaluacionDTO);
	}
	
	/* ****************************************************************
	 *                         Recado
	 * ****************************************************************
	 */
	public void agregarRecado(RecadoDTO nuevoRecado) {
		this.recadoDAO.insert(nuevoRecado);
	}

	public void borrarRecado(RecadoDTO recado_a_eliminar) {
		this.recadoDAO.delete(recado_a_eliminar);
	}
	
	public void actualizarRecado(RecadoDTO recado_a_actualizar) {
		this.recadoDAO.update(recado_a_actualizar);
	}
	
	public List<RecadoDTO> obtenerRecados() {
		return this.recadoDAO.readAll();
	}
	
	public List<RecadoDTO> obtenerRecadosEnviados(long idUsuarioDe){
		return this.recadoDAO.readAllEnviados(idUsuarioDe);
	}
	
	public List<RecadoDTO> obtenerRecadosRecibidos(long idUsuarioPara){
		return this.recadoDAO.readAllRecibidos(idUsuarioPara);
	}
	
	public List<RecadoDTO> obtenerRecadosEliminados(){
		return this.recadoDAO.readAllEliminados();
	}

	public UsuarioDTO getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(UsuarioDTO usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
}
