package persistencia.dao.mysql;

import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.AlumnoEventoDAO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.CursoDAO;
import persistencia.dao.interfaz.ClaseDAO;
import persistencia.dao.interfaz.CursadaCompletaDAO;
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.UsuarioDAO;
import persistencia.dao.interfaz.EstadoDeCursoDAO;
import persistencia.dao.interfaz.EmpresaDAO;
import persistencia.dao.interfaz.SalaDAO;
import persistencia.dao.interfaz.CursadaDAO;

public class DAOSQLFactory implements DAOAbstractFactory {
	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	@Override
	public CursoTipoDAO createCursoTipoDAO() {
		return new CursoTipoDAOSQL();
	}

	@Override
	public UsuarioDAO createUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioDAOSQL();
	}

	@Override
	public CategoriaDAO createCategoriaDAO() {
		// TODO Auto-generated method stub
		return new CategoriaDAOSQL();
	}

	@Override
	public AlumnoDAO createAlumnoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoDAOSQL();
	}

	@Override
	public CursoDAO createCursoDAO() {
		// TODO Auto-generated method stub
		return new CursoDAOSQL();
	}

	@Override
	public ClaseDAO createClaseDAO() {
		// TODO Auto-generated method stub
		return new ClaseDAOSQL();
	}

	@Override
	public EstadoDeCursoDAO createEstadoDeCursoDAO() {
		return new EstadoDeCursoDAOSQL();
	}

	@Override
	public EmpresaDAO createEmpresaDAO() {
		return new EmpresaDAOSQL();
	}

	@Override
	public SalaDAO createSalaDAO() {
		return new SalaDAOSQL();
	}

	@Override
	public CursadaDAO createCursadaDAO() {
		return new CursadaDAOSQL();
	}
	
	@Override
	public CursadaCompletaDAO createCursadaCompletaDAO() {
		return new CursadaCompletaDAOSQL();
	}
	
	public AlumnoEventoDAO createAlumnoEventoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoEventoDAOSQL();
	}
}
