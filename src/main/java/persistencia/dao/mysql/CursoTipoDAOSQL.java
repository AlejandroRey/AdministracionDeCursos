package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CursoTipoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CursoTipoDAO;

public class CursoTipoDAOSQL implements CursoTipoDAO {

	private static final String readall = "SELECT * FROM cursotipo";
	
	public List<CursoTipoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<CursoTipoDTO> instructores = new ArrayList<CursoTipoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				instructores.add(new CursoTipoDTO(resultSet.getLong("idCursoTipo"),
												  resultSet.getString("nombre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instructores;
	}
}
