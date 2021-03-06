package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public AlumnoDAO createAlumnoDAO();
	
	public ContactoDAO createContactoDAO();
	
	public ContactoCompletoDAO createContactoCompletoDAO();
	
	public UsuarioDAO createUsuarioDAO();

	public CategoriaDAO createCategoriaDAO();

	public CursoTipoDAO createCursoTipoDAO();

	public ClaseDAO createClaseDAO();
	
	public CursoDAO createCursoDAO();
	
	public EstadoDeCursoDAO createEstadoDeCursoDAO();
	
	public EmpresaDAO createEmpresaDAO();
	
	public SalaDAO createSalaDAO();
	
	public SalaDisponibilidadDAO createSalaDisponibilidadDAO();
	
	public CursadaDAO createCursadaDAO();

	public CursadaCompletaDAO createCursadaCompletaDAO();
	
	public AlumnoInscriptoDAO createAlumnoInscriptoDAO();
	
	public InscriptoDAO createInscriptoDAO();

	public DiaCursadaClaseDAO createDiaCursadaClaseDAO();

	public FechaCursadaClaseDAO createFechaCursadaClaseDAO();
	
	public TareaDAO createTareaDAO();

	public SalaDisponibleDAO createSalaDisponibleDAO();

	public FeriadoDAO createFeriadoDAO();

	public AsistenciaDAO createAsistenciaDAO();

	public AlumnoAsistenciaQtyDAO createAlumnoAsistenciaQtyDAO();

	public EvaluacionDAO createEvaluacionDAO();

	public EvaluacionTipoDAO createEvaluacionTipoDAO();

	public EvaluacionCursadaDAO createEvaluacionCursadaDAO();

	public NotaDAO createNotaDAO();
	
	public NotificacionDAO createNotificacionDAO();
	
	public RecadoDAO createRecadoDAO();
	
	public ContactoTareaDAO createContactoTareaDAO();
}
