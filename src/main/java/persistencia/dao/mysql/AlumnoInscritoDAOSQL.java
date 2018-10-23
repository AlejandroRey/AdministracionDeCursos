package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoInscriptoDTO;
import dto.CursadaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.AlumnoInscriptoDAO;

public class AlumnoInscritoDAOSQL implements AlumnoInscriptoDAO {
	
	private static final String readall = "SELECT T1.idAlumno, T1.idCursada, T2.nombre, T2.apellido, T2.telefono, T2.email, T1.fecha, T1.estado FROM " + 
										  "(SELECT T1.idCursada, T2.idAlumno, T2.fecha, T2.estado FROM cursada AS T1 " + 
										  "INNER JOIN inscripto AS T2 ON T1.idCursada = T2.idCursada) AS T1 " + 
										  "INNER JOIN alumno AS T2 ON T1.idAlumno = T2.idAlumno WHERE T1.idCursada = ?";

	@Override
	public List<AlumnoInscriptoDTO> readAll(CursadaDTO cursada) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AlumnoInscriptoDTO> alumnosInscriptos = new ArrayList<AlumnoInscriptoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, cursada.getIdCursada());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnosInscriptos.add(new AlumnoInscriptoDTO(resultSet.getLong("idAlumno"), 
												   resultSet.getLong("idCursada"), 
												   resultSet.getString("nombre"), 
										           resultSet.getString("apellido"), 
												   resultSet.getString("telefono"), 
												   resultSet.getString("email"), 
												   resultSet.getTimestamp("fecha").toLocalDateTime(),
												   resultSet.getBoolean("estado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnosInscriptos;
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
