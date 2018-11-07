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
	
	private static final String insert = "INSERT INTO contacto (idCurso, idAlumno, nombre, apellido, descripcion, telefono, email, fechaCreacion, fechaAccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM contacto WHERE idContacto = ?";
	private static final String update = "UPDATE contacto SET idCurso = ?, idAlumno = ?, nombre = ?, apellido = ?, descripcion = ?, telefono = ?, email = ?, fechaCreacion = ?, fechaAccion = ? WHERE idContacto = ?";
	private static final String readall = "SELECT * FROM contacto";

	@Override
	public boolean insert(ContactoDTO contacto) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, contacto.getIdCurso());
			statement.setLong(2, contacto.getIdAlumno());
			statement.setString(3, contacto.getNombre());
			statement.setString(4, contacto.getApellido());
			statement.setString(5, contacto.getDescripcion());
			statement.setString(6, contacto.getTelefono());
			statement.setString(7, contacto.getEmail());
			statement.setTimestamp(8, convertToTimeStamp(contacto.getFechaCreacion()));
			statement.setTimestamp(9, convertToTimeStamp(contacto.getFechaAccion()));
			//statement.setLong(10, contacto.getIdContacto());
			
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
	public boolean delete(ContactoDTO contacto) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(contacto.getIdContacto()));
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
	public boolean update(ContactoDTO contacto) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setLong(1, contacto.getIdCurso());
			statement.setLong(2, contacto.getIdAlumno());
			statement.setString(3, contacto.getNombre());
			statement.setString(4, contacto.getApellido());
			statement.setString(5, contacto.getDescripcion());
			statement.setString(6, contacto.getTelefono());
			statement.setString(7, contacto.getEmail());
			statement.setTimestamp(8, convertToTimeStamp(contacto.getFechaCreacion()));
			statement.setTimestamp(9, convertToTimeStamp(contacto.getFechaAccion()));
			statement.setLong(10, contacto.getIdContacto());
			
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
		ArrayList<ContactoDTO> contactos = new ArrayList<ContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaCreacion = resultSet.getTimestamp("fechaCreacion").toLocalDateTime();
				LocalDateTime fechaAccion = resultSet.getTimestamp("fechaAccion").toLocalDateTime();
				contactos.add(new ContactoDTO(resultSet.getLong("idContacto"),
											resultSet.getLong("idCurso"),
											resultSet.getLong("idAlumno"),
											resultSet.getString("nombre"),
											resultSet.getString("apellido"),
											resultSet.getString("descripcion"),
											resultSet.getString("telefono"),
											resultSet.getString("email"),
											fechaCreacion,
											fechaAccion));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return contactos;
	}

	public Timestamp convertToTimeStamp(LocalDateTime ldt) {
		return Timestamp.valueOf(ldt);
	}

	public LocalDateTime convertToLocalDateTime(Timestamp ts) {
		if (ts != null) {
			return ts.toLocalDateTime();
		}
		return null;
	}
}