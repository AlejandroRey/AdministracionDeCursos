package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public AlumnoDAO createAlumnoDAO();
	
	public UsuarioDAO createUsuarioDAO();

	public CategoriaDAO createCategoriaDAO();

	public CursoTipoDAO createCursoTipoDAO();

	public ClaseDAO createClaseDAO();
	
}
