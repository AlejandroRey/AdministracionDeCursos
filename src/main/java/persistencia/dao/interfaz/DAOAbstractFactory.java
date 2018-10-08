package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public AlumnoDAO createAlumnoDAO();
	
	public UsuarioDAO createUsuarioDAO();

	public CategoriaDAO createCategoriaDAO();

	public CursoTipoDAO createCursoTipoDAO();

	public ClaseDAO createClaseDAO();
	
	public CursoDAO createCursoDAO();
	
	public EstadoDeCursoDAO createEstadoDeCursoDAO();
	
	public EmpresaDAO createEmpresaDAO();
	
	public SalaDAO createSalaDAO();
	
	public CursadaDAO createCursadaDAO();
	
}
