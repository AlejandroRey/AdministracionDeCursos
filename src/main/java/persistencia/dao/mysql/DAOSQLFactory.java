package persistencia.dao.mysql;

import persistencia.dao.interfaz.CursoTipoDAO;
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
	public CursoTipoDAO createCursoTipoDAO() {
		return new CursoTipoDAOSQL();
	}
}
