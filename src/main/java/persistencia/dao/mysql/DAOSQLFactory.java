package persistencia.dao.mysql;

import persistencia.dao.interfaz.AlumnoAsistenciaQtyDAO;
import persistencia.dao.interfaz.AlumnoDAO;
import persistencia.dao.interfaz.AlumnoEventoDAO;
import persistencia.dao.interfaz.AlumnoInscriptoDAO;
import persistencia.dao.interfaz.AsistenciaDAO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.ClaseDAO;
import persistencia.dao.interfaz.ContactoDAO;
import persistencia.dao.interfaz.CursadaCompletaDAO;
import persistencia.dao.interfaz.CursadaDAO;
import persistencia.dao.interfaz.CursoDAO;
import persistencia.dao.interfaz.CursoTipoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DiaCursadaClaseDAO;
import persistencia.dao.interfaz.EmpresaDAO;
import persistencia.dao.interfaz.EstadoDeCursoDAO;
import persistencia.dao.interfaz.EvaluacionCursadaDAO;
import persistencia.dao.interfaz.EvaluacionDAO;
import persistencia.dao.interfaz.EvaluacionTipoDAO;
import persistencia.dao.interfaz.FechaCursadaClaseDAO;
import persistencia.dao.interfaz.FeriadoDAO;
import persistencia.dao.interfaz.InscriptoDAO;
import persistencia.dao.interfaz.NotaDAO;
import persistencia.dao.interfaz.NotificacionDAO;
import persistencia.dao.interfaz.SalaDAO;
import persistencia.dao.interfaz.SalaDisponibilidadDAO;
import persistencia.dao.interfaz.SalaDisponibleDAO;
import persistencia.dao.interfaz.UsuarioDAO;
import persistencia.dao.interfaz.TareaDAO;

public class DAOSQLFactory implements DAOAbstractFactory {
	
	@Override
	public ContactoDAO createContactoDAO() {
		return new ContactoDAOSQL();
	}
	
	@Override
	public NotificacionDAO createNotificacionDAO() {
		return new NotificacionDAOSQL();
	}
	
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

	@Override
	public AlumnoInscriptoDAO createAlumnoInscriptoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoInscritoDAOSQL();
	}

	@Override
	public InscriptoDAO createInscriptoDAO() {
		// TODO Auto-generated method stub
		return new InscriptoDAOSQL();
	}

	@Override
	public DiaCursadaClaseDAO createDiaCursadaClaseDAO() {
		// TODO Auto-generated method stub
		return new DiaCursadaClaseDAOSQL();
	}

	@Override
	public FechaCursadaClaseDAO createFechaCursadaClaseDAO() {
		// TODO Auto-generated method stub
		return new FechaCursadaClaseDAOSQL();
	}

	@Override
	public TareaDAO createTareaDAO() {
		// TODO Auto-generated method stub
		return new TareaDAOSQL();
	}

	@Override
	public SalaDisponibilidadDAO createSalaDisponibilidadDAO() {
		// TODO Auto-generated method stub
		return new SalaDisponibilidadDAOSQL();
	}

	@Override
	public SalaDisponibleDAO createSalaDisponibleDAO() {
		// TODO Auto-generated method stub
		return new SalaDisponibleDAOSQL();
	}

	@Override
	public FeriadoDAO createFeriadoDAO() {
		// TODO Auto-generated method stub
		return new FeriadoDAOSQL();
	}

	@Override
	public AsistenciaDAO createAsistenciaDAO() {
		// TODO Auto-generated method stub
		return new AsistenciaDAOSQL();
	}

	@Override
	public AlumnoAsistenciaQtyDAO createAlumnoAsistenciaQtyDAO() {
		// TODO Auto-generated method stub
		return new AlumnoAsistenciaQtyDAOSQL();
	}

	@Override
	public EvaluacionDAO createEvaluacionDAO() {
		// TODO Auto-generated method stub
		return new EvaluacionDAOSQL();
	}

	@Override
	public EvaluacionTipoDAO createEvaluacionTipoDAO() {
		// TODO Auto-generated method stub
		return new EvaluacionTipoDAOSQL();
	}

	@Override
	public EvaluacionCursadaDAO createEvaluacionCursadaDAO() {
		// TODO Auto-generated method stub
		return new EvaluacionCursadaDAOSQL();
	}

	@Override
	public NotaDAO createNotaDAO() {
		// TODO Auto-generated method stub
		return new NotaDAOSQL();
	}
	
	
}
