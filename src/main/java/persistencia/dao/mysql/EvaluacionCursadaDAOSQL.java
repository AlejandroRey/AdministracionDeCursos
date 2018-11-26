package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.EvaluacionCursadaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EvaluacionCursadaDAO;

public class EvaluacionCursadaDAOSQL implements EvaluacionCursadaDAO {
	
	private static final String insert = "INSERT INTO evaluacion (idCursada, idEvaluacionTipo, nombre, fecha) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM evaluacion WHERE idEvaluacion= ?";
	private static final String update = "UPDATE evaluacion SET idCursada = ?, idEvaluacionTipo = ?, nombre = ?, fecha = ? WHERE idEvaluacion = ?";
	//private static final String readall = "";

	@Override
	public boolean insert(EvaluacionCursadaDTO evaluacionCursadaDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);		
			statement.setLong(1, evaluacionCursadaDTO.getIdCursada());
			statement.setLong(2, evaluacionCursadaDTO.getIdEvaluacionTipo());
			statement.setString(3, evaluacionCursadaDTO.getTema());
			statement.setDate(4, java.sql.Date.valueOf(evaluacionCursadaDTO.getFecha()));
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean delete(EvaluacionCursadaDTO evaluacionCursadaDTO) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(evaluacionCursadaDTO.getIdEvaluacion()));
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean update(EvaluacionCursadaDTO evaluacionCursadaDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setLong(1, evaluacionCursadaDTO.getIdCursada());
			statement.setLong(2, evaluacionCursadaDTO.getIdEvaluacionTipo());
			statement.setString(3, evaluacionCursadaDTO.getTema());
			statement.setDate(4, java.sql.Date.valueOf(evaluacionCursadaDTO.getFecha()));
			statement.setLong(5, evaluacionCursadaDTO.getIdEvaluacion());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}

}
