package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EstadoDeCursoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EstadoDeCursoDAO;

public class EstadoDeCursoDAOSQL implements EstadoDeCursoDAO{
	
	private static final String readall = "SELECT * FROM EstadoDeCurso";

	@Override
	public boolean insert(EstadoDeCursoDTO nuevoEstadoDeCurso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoDeCursoDTO estadoDeCurso_a_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoDeCursoDTO estadoDeCurso_a_actualizar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EstadoDeCursoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<EstadoDeCursoDTO> cursadas = new ArrayList<EstadoDeCursoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cursadas.add(new EstadoDeCursoDTO(resultSet.getLong("idEstadoDeCurso"), 
											      resultSet.getString("nombre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cursadas;
	}

}
