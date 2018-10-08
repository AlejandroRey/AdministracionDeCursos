package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoEventoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.AlumnoEventoDAO;

public class AlumnoEventoDAOSQL implements AlumnoEventoDAO {
	private static final String insert = "INSERT INTO alumnoevento (idAlumnoEvento, idAlumno, idUsuario, cursosDeInteres, descripcion, fechaContactar, fechaCreacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String readall = "SELECT * FROM alumnoevento";

	@Override
	public boolean insert(AlumnoEventoDTO alumnoEvento) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, alumnoEvento.getIdAlumnoEvento());
			statement.setLong(2, alumnoEvento.getIdAlumno());
			statement.setLong(3, alumnoEvento.getIdCurso());
			statement.setLong(4, alumnoEvento.getIdCurso());
			statement.setString(5, alumnoEvento.getDescripcion());
			statement.setDate(6, alumnoEvento.getFechaContactar());
			statement.setDate(7, alumnoEvento.getFechaCreacion());
			statement.setBoolean(8, alumnoEvento.isEstado());
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
	public List<AlumnoEventoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AlumnoEventoDTO> alumnoEventos = new ArrayList<AlumnoEventoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnoEventos.add(new AlumnoEventoDTO(resultSet.getLong("idAlumnoEvento"),
											resultSet.getLong("idAlumno"),
											resultSet.getLong("idUsuario"),
											resultSet.getLong("cursosDeInteres"),
										  resultSet.getString("descripcion"),
										  resultSet.getDate("fechaContactar"), 
										 resultSet.getDate("fechaCreacion"),
										 resultSet.getBoolean("estado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnoEventos;
	}
}
