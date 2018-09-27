package persistencia.dao.mysql;

import persistencia.dao.interfaz.ClienteDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.InstructorDAO;

public class DAOSQLFactory implements DAOAbstractFactory {
	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	@Override
	public InstructorDAO createInstructorDAO() {
		return new InstructorDAOSQL();
	}

	@Override
	public ClienteDAO createClienteDAO() {
		// TODO Auto-generated method stub
		return new ClienteDAOSQL();
	}

}
