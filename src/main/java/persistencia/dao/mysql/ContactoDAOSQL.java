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
	private static final String insert = "INSERT INTO contacto (idAlumno, idAdministrativo, idCurso, descripcion, fechaContactar, fechaCreacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String insertWithTarea = "INSERT INTO contacto (idAlumno, idAdministrativo, idTarea, idCurso, descripcion, fechaContactar, fechaCreacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM contacto WHERE idContacto = ?";
	private static final String update = "UPDATE contacto SET idAlumno = ?, idAdministrativo = ?, idCurso = ?, descripcion = ?, fechaContactar = ?, fechaCreacion = ?, estado = ?  WHERE idContacto = ?";
	private static final String updateWithTarea = "UPDATE contacto SET idAlumno = ?, idAdministrativo = ?, idTarea = ?, idCurso = ?, descripcion = ?, fechaContactar = ?, fechaCreacion = ?, estado = ?  WHERE idContacto = ?";
	private static final String readall = "SELECT * FROM contacto";

	@Override
	public boolean insert(ContactoDTO contacto) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			if(contacto.getIdTarea() <= 0){
				statement = conexion.getSQLConexion().prepareStatement(insert);
				statement.setLong(1, contacto.getIdAlumno());
				statement.setLong(2, contacto.getIdAdministrativo());
				statement.setLong(3, contacto.getIdCurso());
				statement.setString(4, contacto.getDescripcion());
				statement.setTimestamp(5, convertToTimeStamp(contacto.getFechaContactar()));
				statement.setTimestamp(6, convertToTimeStamp(contacto.getFechaCreacion()));
				statement.setInt(7, contacto.isEstado());
		} else{
			statement = conexion.getSQLConexion().prepareStatement(insertWithTarea);
			statement.setLong(1, contacto.getIdAlumno());
			statement.setLong(2, contacto.getIdAdministrativo());
			statement.setLong(3, contacto.getIdTarea());
			statement.setLong(4, contacto.getIdCurso());
			statement.setString(5, contacto.getDescripcion());
			statement.setTimestamp(6, convertToTimeStamp(contacto.getFechaContactar()));
			statement.setTimestamp(7, convertToTimeStamp(contacto.getFechaCreacion()));
			statement.setInt(8, contacto.isEstado());
		}
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
	public boolean delete(ContactoDTO contacto_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(contacto_a_eliminar.getIdContacto()));
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
	public boolean update(ContactoDTO contacto_a_actualizar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			if(contacto_a_actualizar.getIdTarea() <= 0) {
				statement = conexion.getSQLConexion().prepareStatement(update);
				statement.setLong(1, contacto_a_actualizar.getIdAlumno());
				statement.setLong(2, contacto_a_actualizar.getIdAdministrativo());
				statement.setLong(3, contacto_a_actualizar.getIdCurso());
				statement.setString(4, contacto_a_actualizar.getDescripcion());
				statement.setTimestamp(5, convertToTimeStamp(contacto_a_actualizar.getFechaContactar()));
				statement.setTimestamp(6, convertToTimeStamp(contacto_a_actualizar.getFechaCreacion()));
				statement.setInt(7, contacto_a_actualizar.isEstado());
				statement.setLong(8, contacto_a_actualizar.getIdContacto());
			}else{
				statement = conexion.getSQLConexion().prepareStatement(updateWithTarea);
				statement.setLong(1, contacto_a_actualizar.getIdAlumno());
				statement.setLong(2, contacto_a_actualizar.getIdAdministrativo());
				statement.setLong(3, contacto_a_actualizar.getIdTarea());
				statement.setLong(4, contacto_a_actualizar.getIdCurso());
				statement.setString(5, contacto_a_actualizar.getDescripcion());
				statement.setTimestamp(6, convertToTimeStamp(contacto_a_actualizar.getFechaContactar()));
				statement.setTimestamp(7, convertToTimeStamp(contacto_a_actualizar.getFechaCreacion()));
				statement.setInt(8, contacto_a_actualizar.isEstado());
				statement.setLong(9, contacto_a_actualizar.getIdContacto());
			}
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
				LocalDateTime fechaCreacion = resultSet.getTimestamp("fechaCreacion").toLocalDateTime();
				alumnoEventos.add(new ContactoDTO(resultSet.getLong("idContacto"), 
								resultSet.getLong("idAlumno"),
								resultSet.getLong("idAdministrativo"),
								resultSet.getLong("idTarea"),
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
