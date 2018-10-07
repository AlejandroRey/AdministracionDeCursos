package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public AlumnoDAO createAlumnoDAO();
	
	public UsuarioDAO createUsuarioDAO();

	public CategoriaDAO createCategoriaDAO();
	
	public InstructorDAO createInstructorDAO();

	public CursoTipoDAO createCursoTipoDAO();
	
}
