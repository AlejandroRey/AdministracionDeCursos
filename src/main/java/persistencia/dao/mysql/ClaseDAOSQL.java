package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.ClaseDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ClaseDAO;

public class ClaseDAOSQL implements ClaseDAO {

	private static final String readall = "SELECT * FROM clase";

	@Override
	public List<ClaseDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<ClaseDTO> clases = new ArrayList<ClaseDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaInicio = resultSet.getTimestamp("fechaInicio").toLocalDateTime();
				LocalDateTime fechaFin = resultSet.getTimestamp("fechaInicio").toLocalDateTime();
				clases.add(new ClaseDTO(resultSet.getLong("idClase"), 
										resultSet.getLong("idCursada"), 
										fechaInicio,
										fechaFin, 
										resultSet.getBoolean("esFeriado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return clases;
	}

}
