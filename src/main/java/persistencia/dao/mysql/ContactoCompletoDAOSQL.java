package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoDTO;
import dto.ContactoCompletoDTO;
import dto.ContactoDTO;
import dto.CursoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ContactoCompletoDAO;

public class ContactoCompletoDAOSQL implements ContactoCompletoDAO {

	private static final String readall = "SELECT T1.idContacto, T1.idAlumno, T1.idAdministrativo, T1.idTarea, T1.idCurso, "
			+ "T1.descripcion, T1.fechaContactar, T1.fechaCreacion, T1.estado, T2.nombre, T2.apellido, T2.telefono, T2.email, "
			+ "T3.apellido as apellidoAdministrativo, T3.nombre as nombreAdministrativo, T4.nombre as nombreCurso "
			+ "FROM contacto as T1 "
			+ "INNER JOIN alumno as T2 on T1.idAlumno = T2.idAlumno "
			+ "INNER JOIN usuario as T3 on T3.idUsuario = T1.idAdministrativo "
			+ "INNER JOIN curso as T4 on T4.idCurso = T1.idCurso "
			+ "GROUP BY T1.idContacto;";
	
	private static final String readAllInteresados = "SELECT distinct (contactos.idAlumno), contactos.idContacto, contactos.idAdministrativo, "
			+ "contactos.idTarea, contactos.idCurso, contactos.descripcion, contactos.fechaContactar, contactos.fechaCreacion, contactos.estado, "
			+ "contactos.nombre, contactos.apellido, contactos.telefono, contactos.email, contactos.apellidoAdministrativo,contactos.nombreAdministrativo, "
			+ "contactos.nombreCurso "
			+ "FROM (SELECT * FROM (SELECT T1.idContacto, T1.idAlumno, T1.idAdministrativo, T1.idTarea, T1.idCurso, T1.descripcion, "
			+ "T1.fechaContactar, T1.fechaCreacion, T1.estado, T2.nombre, T2.apellido, T2.telefono, T2.email, T3.apellido AS apellidoAdministrativo, "
			+ "T3.nombre AS nombreAdministrativo, T4.nombre AS nombreCurso "
			+ "FROM contacto AS T1 INNER JOIN alumno AS T2 ON T1.idAlumno = T2.idAlumno "
			+ "INNER JOIN usuario AS T3 ON T3.idUsuario = T1.idAdministrativo "
			+ "INNER JOIN curso AS T4 ON T4.idCurso = T1.idCurso "
			+ "GROUP BY T1.idContacto) AS contactosCompletos WHERE contactosCompletos.idCurso = ? "
			+ "ORDER BY contactosCompletos.fechaCreacion DESC) AS contactos "
			+ "GROUP BY contactos.idAlumno "
			+ "ORDER BY contactos.fechaCreacion";
	
	@Override
	public List<ContactoCompletoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<ContactoCompletoDTO> alumnoEventos = new ArrayList<ContactoCompletoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ContactoDTO contacto = getContacto(resultSet);
				AlumnoDTO alumno = getAlumno(resultSet);
				alumnoEventos.add(new ContactoCompletoDTO(contacto,
						alumno,
						resultSet.getString("nombreCurso"),
						resultSet.getString("nombreAdministrativo"),
						resultSet.getString("apellidoAdministrativo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnoEventos;
	}
	
	@Override
	public List<ContactoCompletoDTO> readAllInteresados(CursoDTO curso) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<ContactoCompletoDTO> alumnoEventos = new ArrayList<ContactoCompletoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAllInteresados);
			statement.setLong(1, curso.getIdCurso());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ContactoDTO contacto = getContacto(resultSet);
				AlumnoDTO alumno = getAlumno(resultSet);
				alumnoEventos.add(new ContactoCompletoDTO(contacto,
						alumno,
						resultSet.getString("nombreCurso"),
						resultSet.getString("nombreAdministrativo"),
						resultSet.getString("apellidoAdministrativo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnoEventos;
	}

	private ContactoDTO getContacto(ResultSet resultSet) throws SQLException {
		LocalDateTime fechaContactar = resultSet.getTimestamp("fechaContactar").toLocalDateTime();
		LocalDateTime fechaCreacion = resultSet.getTimestamp("fechaCreacion").toLocalDateTime();
		ContactoDTO contacto = new ContactoDTO(resultSet.getLong("idContacto"), 
				resultSet.getLong("idAlumno"),
				resultSet.getLong("idAdministrativo"), 
				resultSet.getLong("idTarea"),
				resultSet.getLong("idCurso"),
				resultSet.getString("descripcion"), 
				fechaContactar,
				fechaCreacion, 
				resultSet.getInt("estado"));
		return contacto;
	}
	
	private AlumnoDTO getAlumno(ResultSet resultSet) throws SQLException {
		AlumnoDTO alumno = new AlumnoDTO(resultSet.getLong("idAlumno"), 
				  resultSet.getString("nombre"),
				  resultSet.getString("apellido"), 
				  resultSet.getString("telefono"),
				  resultSet.getString("email"));
		return alumno;
	}

	public Timestamp convertToTimeStamp(LocalDateTime ldt) {
		return ldt != null ? Timestamp.valueOf(ldt) : null;
	}

	public LocalDateTime convertToLocalDateTime(Timestamp ts) {
		return ts != null ? ts.toLocalDateTime() : null;
	}
}
