package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoHistorialNotasReporteDTO;
import persistencia.conexion.Conexion;

public class AlumnoHistorialNotasReporteDAOSQL {
	
	private static final String readall = "SELECT T2.idAlumno, T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, T2.idEmpresa, T2.idCurso, T2.idEstadoCurso, T1.nombre AS curso, T1.tema AS temaCurso, " + 
			"T2.empresa, T2.fechaInicioCursada, T2.nombre, T2.apellido, T2.telefono, T2.email, T2.tema AS temaEvaluacion, T2.fechaEvaluacion, T2.evaluacion, T2.nota " + 
			"FROM curso AS T1 " + 
			"INNER JOIN (SELECT T2.fechaInicioCursada, T2.idAlumno, T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, T2.idEmpresa, T2.idCurso, T2.idEstadoCurso, T1.nombre AS empresa, T2.nombre, T2.apellido, T2.telefono, T2.email, T2.tema, T2.fechaEvaluacion, T2.evaluacion, T2.nota " + 
			"FROM empresa AS T1 " + 
			"INNER JOIN (SELECT T1.fechaInicioCursada, T2.idAlumno, T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, T1.idEmpresa, T1.idCurso, T1.idEstadoCurso, T2.nombre, T2.apellido, T2.telefono, T2.email, T2.tema, T2.fechaEvaluacion, T2.evaluacion, T2.nota " + 
			"FROM cursada AS T1 " + 
			"INNER JOIN (SELECT T2.idAlumno, T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, T1.nombre, T1.apellido, T1.telefono, T1.email, T2.tema, T2.fechaEvaluacion, T2.evaluacion, T2.nota " + 
			"FROM alumno AS T1 " + 
			"INNER JOIN " + 
			"(SELECT T1.idAlumno, T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, T2.tema, T2.fecha AS fechaEvaluacion, T2.evaluacion, T1.nota " + 
			"FROM nota AS T1 " + 
			"INNER JOIN " + 
			"(SELECT T1.idEvaluacion, T1.idCursada, T2.idEvaluacionTipo, T1.nombre AS tema, T1.fecha, T2.nombre AS evaluacion " + 
			"FROM evaluacion AS T1 " + 
			"INNER JOIN evaluaciontipo AS T2 " + 
			"ON T1.idEvaluacionTipo = T2.idEvaluacionTipo) AS T2 " + 
			"ON T1.idEvaluacion = T2.idEvaluacion) AS T2 " + 
			"ON T1.idAlumno = T2.idAlumno) AS T2 " + 
			"ON T1.idCursada = T2.idCursada) AS T2 " + 
			"ON T1.idEmpresa = T2.idEmpresa) AS T2 " + 
			"ON T1.idCurso = T2.idCurso " + 
			"WHERE T2.idAlumno = ? AND T2.idEstadoCurso = 2 " + 
			"ORDER BY T2.idAlumno, T2.idCursada, T2.idEvaluacionTipo";
	
	public List<AlumnoHistorialNotasReporteDTO> readAll(long idAlumno) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<AlumnoHistorialNotasReporteDTO> alumnoHistorialNotasReporteList = new ArrayList<AlumnoHistorialNotasReporteDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, idAlumno);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnoHistorialNotasReporteList.add(new AlumnoHistorialNotasReporteDTO(resultSet.getLong("idAlumno"), 
																					   resultSet.getLong("idEvaluacion"), 
																					   resultSet.getLong("idCursada"), 
																					   resultSet.getLong("idEvaluacionTipo"), 
																					   resultSet.getLong("idEmpresa"), 
																					   resultSet.getLong("idCurso"), 
																					   resultSet.getLong("idEstadoCurso"), 
																					   resultSet.getString("curso"), 
																					   resultSet.getString("temaCurso"), 
																					   resultSet.getString("empresa"), 
																					   stringToLocalDateFormatter(resultSet.getTimestamp("fechaInicioCursada").toLocalDateTime()),
																					   resultSet.getString("nombre"), 
																					   resultSet.getString("apellido"), 
																					   resultSet.getString("telefono"), 
																					   resultSet.getString("email"), 
																					   resultSet.getString("evaluacion"), 
																					   resultSet.getString("temaEvaluacion"), 
																					   resultSet.getDate("fechaEvaluacion").toLocalDate(), 
																					   Long.parseLong(resultSet.getString("nota"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnoHistorialNotasReporteList;
	}
	
	private String stringToLocalDateFormatter(LocalDateTime fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}

}
