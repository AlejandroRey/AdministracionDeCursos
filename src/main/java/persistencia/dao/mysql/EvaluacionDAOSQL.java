package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CursadaDTO;
import dto.EvaluacionDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EvaluacionDAO;

public class EvaluacionDAOSQL implements EvaluacionDAO {

	private static final String readall = "SELECT T1.idEvaluacion, T1.idCursada, T2.idEvaluacionTipo, " + 
										  "T1.nombre AS descripcion, T2.nombre AS tipoParcial, T1.fecha " + 
										  "FROM evaluacion AS T1 " + 
										  "INNER JOIN evaluaciontipo AS T2 " + 
										  "ON T1.idEvaluacionTipo = T2.idEvaluacionTipo " + 
										  "WHERE T1.idCursada = ?";
	
	@Override
	public List<EvaluacionDTO> readAll(CursadaDTO cursadaDTO) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<EvaluacionDTO> salas = new ArrayList<EvaluacionDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, cursadaDTO.getIdCursada());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				salas.add(new EvaluacionDTO(resultSet.getLong("idEvaluacion"), 
										 	resultSet.getLong("idCursada"), 
										 	resultSet.getLong("idEvaluacionTipo"), 
											resultSet.getString("descripcion"), 
											resultSet.getString("tipoParcial"), 
											resultSet.getDate("fecha").toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return salas;
	}
	
}
