package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public InstructorDAO createInstructorDAO();

	public ClienteDAO createClienteDAO();

}
