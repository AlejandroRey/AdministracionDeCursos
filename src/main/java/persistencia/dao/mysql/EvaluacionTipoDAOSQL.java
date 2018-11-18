package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EvaluacionTipoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EvaluacionTipoDAO;

public class EvaluacionTipoDAOSQL implements EvaluacionTipoDAO {
	
	private static final String readall = "SELECT * FROM evaluaciontipo";

	@Override
	public List<EvaluacionTipoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<EvaluacionTipoDTO> evaluacionTiposList = new ArrayList<EvaluacionTipoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				evaluacionTiposList.add(new EvaluacionTipoDTO(resultSet.getLong("idEvaluacionTipo"), 
															  resultSet.getString("nombre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return evaluacionTiposList;
	}

}
