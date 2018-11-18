package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoDTO;
import dto.AlumnoHistorialCursadaDTO;
import dto.AlumnoHistorialNotaDTO;
import dto.EmpresaDTO;
import persistencia.conexion.Conexion;

public class AlumnoHistorialCursadasDAOSQL {
	
	private static final String readAllCursadas = "SELECT T2.idCurso, T2.idCursada, T1.idAlumno, T1.nombre, T1.apellido, T1.telefono, " + 
							                      "T1.email, T2.curso, T2.tema, T2.fechaInicioCursada " + 
												  "FROM (SELECT T2.idCursada, T1.idAlumno, T1.nombre, T1.apellido, T1.telefono, T1.email " + 
												  "FROM alumno AS T1 " + 
												  "INNER JOIN inscripto AS T2 " + 
												  "ON T1.idAlumno = T2.idAlumno) AS T1 " + 
												  "INNER JOIN " + 
												  "(SELECT T1.idCurso, T1.idCursada, T2.nombre AS curso, T2.tema, T1.fechaInicioCursada " + 
												  "FROM cursada AS T1 " + 
												  "INNER JOIN curso AS T2 " + 
												  "ON T1.idCurso = T2.idCurso) AS T2 " + 
												  "ON T1.idCursada = T2.idCursada " + 
												  "WHERE T1.idAlumno = ? " + 
												  "ORDER BY T2.fechaInicioCursada ASC, " + 
												  "T1.apellido ASC, " + 
												  "T2.idCurso";
	
	private static final String readAllNotas = "SELECT T1.idAlumno, T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, " + 
											   "T2.parcial, T2.tema, T2.fecha, T1.nota " + 
											   "FROM nota AS T1 " + 
											   "INNER JOIN " + 
											   "(SELECT T2.idEvaluacion, T2.idCursada, T2.idEvaluacionTipo, " + 
											   "T1.nombre AS parcial, T2.nombre as tema, T2.fecha " + 
											   "FROM evaluaciontipo AS T1 " + 
											   "INNER JOIN evaluacion AS T2 " + 
											   "ON T1.idEvaluacionTipo = T2.idEvaluacionTipo " + 
											   "ORDER BY T2.idCursada, T2.fecha ASC) AS T2 " + 
											   "ON T1.idEvaluacion = T2.idEvaluacion " + 
											   "WHERE T1.idAlumno = ? AND T2.idCursada = ? " + 
											   "ORDER BY T1.idAlumno ASC";
	
	public List<AlumnoHistorialCursadaDTO> readAllCursada(AlumnoDTO alumnoDTO) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AlumnoHistorialCursadaDTO> alumnosHistorialCursadasList = new ArrayList<AlumnoHistorialCursadaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAllCursadas);
			statement.setLong(1, alumnoDTO.getIdAlumno());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnosHistorialCursadasList.add(new AlumnoHistorialCursadaDTO(resultSet.getLong("idCurso"), 
																			   resultSet.getLong("idCursada"), 
																			   resultSet.getLong("idAlumno"), 
																			   resultSet.getString("nombre"), 
																			   resultSet.getString("apellido"), 
																			   resultSet.getString("telefono"), 
																			   resultSet.getString("email"), 
																			   resultSet.getString("curso"), 
																			   resultSet.getString("tema"), 
																			   resultSet.getTimestamp("fechaInicioCursada").toLocalDateTime()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnosHistorialCursadasList;
	}
	
	public List<AlumnoHistorialNotaDTO> readAllNota(long idAlumno, long idCursada){
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AlumnoHistorialNotaDTO> alumnoHistorialNotas = new ArrayList<AlumnoHistorialNotaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAllNotas);
			statement.setLong(1, idAlumno);
			statement.setLong(2, idCursada);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnoHistorialNotas.add(new AlumnoHistorialNotaDTO(resultSet.getLong("idAlumno"), 
																	resultSet.getLong("idEvaluacion"), 
																	resultSet.getLong("idCursada"), 
																	resultSet.getLong("idEvaluacionTipo"), 
																	resultSet.getString("parcial"), 
																	resultSet.getString("tema"), 
																	resultSet.getDate("fecha").toLocalDate(), 
																	Integer.parseInt(resultSet.getString("nota"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnoHistorialNotas;
	}
	

}
