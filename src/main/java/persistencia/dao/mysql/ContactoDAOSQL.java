package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.ContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ContactoDAO;

public class ContactoDAOSQL implements ContactoDAO {
	private static final String insert = "INSERT INTO alumnoevento (idAlumnoEvento, idAlumno, idUsuario, idCurso, descripcion, fechaContactar, fechaCreacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM alumnoevento WHERE idAlumnoEvento = ?";
	private static final String update = "UPDATE alumnoevento SET idAlumno = ?, idUsuario = ?, idCurso = ?, descripcion = ?, fechaContactar = ?, fechaCreacion = ?, estado = ?  WHERE idAlumnoEvento = ?";
	private static final String readall = "SELECT * FROM alumnoevento";

	@Override
	public boolean insert(ContactoDTO alumnoEvento) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, alumnoEvento.getIdAlumnoEvento());
			statement.setLong(2, alumnoEvento.getIdAlumno());
			statement.setLong(3, alumnoEvento.getIdCurso());
			statement.setLong(4, alumnoEvento.getIdCurso());
			statement.setString(5, alumnoEvento.getDescripcion());
			statement.setTimestamp(6, convertToTimeStamp(alumnoEvento.getFechaContactar()));
			statement.setTimestamp(7, convertToTimeStamp(alumnoEvento.getFechaCreacion()));
			statement.setInt(8, alumnoEvento.isEstado());
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
	public boolean delete(ContactoDTO curso_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(curso_a_eliminar.getIdCurso()));
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
	public boolean update(ContactoDTO curso_a_actualizar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setLong(1, curso_a_actualizar.getIdAlumno());
			statement.setLong(2, curso_a_actualizar.getIdCurso());
			statement.setLong(3, curso_a_actualizar.getIdCurso());
			statement.setString(4, curso_a_actualizar.getDescripcion());
			statement.setTimestamp(6, convertToTimeStamp(curso_a_actualizar.getFechaContactar()));
			statement.setTimestamp(7, convertToTimeStamp(curso_a_actualizar.getFechaCreacion()));
			statement.setInt(7, curso_a_actualizar.isEstado());
			statement.setLong(8, curso_a_actualizar.getIdAlumnoEvento());
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
	public List<ContactoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<ContactoDTO> alumnoEventos = new ArrayList<ContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaContactar = resultSet.getTimestamp("fechaContactar").toLocalDateTime();
				LocalDateTime fechaCreacion = resultSet.getTimestamp("fechaCracion").toLocalDateTime();
				alumnoEventos.add(new ContactoDTO(resultSet.getLong("idAlumnoEvento"), 
								resultSet.getLong("idAlumno"),
								resultSet.getLong("idUsuario"), 
								resultSet.getLong("idCurso"),
								resultSet.getString("descripcion"), 
								fechaContactar,
								fechaCreacion, 
								resultSet.getInt("estado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnoEventos;
	}
	
	public Timestamp convertToTimeStamp(LocalDateTime ldt) {
		return ldt != null ? Timestamp.valueOf(ldt) : null;
	}

	public LocalDateTime convertToLocalDateTime(Timestamp ts) {
		return ts != null ? ts.toLocalDateTime() : null;
	}

}
