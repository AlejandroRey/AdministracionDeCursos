package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CategoriaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CategoriaDAO;

public class CategoriaDAOSQL implements CategoriaDAO {

	private static final String readall = "SELECT * FROM categoria";
	
	public List<CategoriaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<CategoriaDTO> instructores = new ArrayList<CategoriaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				instructores.add(new CategoriaDTO(resultSet.getLong("idCategoria"),
												  resultSet.getString("nombre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return instructores;
	}
}
