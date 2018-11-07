package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.FeriadoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.FeriadoDAO;

public class FeriadoDAOSQL implements FeriadoDAO {
	
	private static final String readall = "SELECT * FROM feriado WHERE YEAR(feriado) = ?";

	@Override
	public List<FeriadoDTO> readAll(int year) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<FeriadoDTO> feriados = new ArrayList<FeriadoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setInt(1, year);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				feriados.add(new FeriadoDTO(resultSet.getLong("idFeriado"), 
											resultSet.getTimestamp("feriado").toLocalDateTime().toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return feriados;
	}

}
