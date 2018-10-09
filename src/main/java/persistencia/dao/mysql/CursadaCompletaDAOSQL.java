package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.CursadaCompletaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CursadaCompletaDAO;

public class CursadaCompletaDAOSQL implements CursadaCompletaDAO {
	
	private static final String readall = "SELECT T1.idCursada, T1.idEmpresa, T1.idCurso, T1.idSala, T1.idEstadoCurso, T1.fechaInicioInscripcion, T1.fechaFinInscripcion, T1.vacantes, T1.empresa, T1.curso, T1.estadoCurso, T2.nombre AS sala " 
										+ "FROM (SELECT T1.idCursada, T1.idEmpresa, T1.idCurso, T1.idSala, T1.idEstadoCurso, T1.fechaInicioInscripcion, T1.fechaFinInscripcion, T1.vacantes, T1.empresa, T1.curso, T2.nombre AS estadoCurso "
										+ "FROM (SELECT T1.idCursada, T1.idEmpresa, T1.idCurso, T1.idSala, T1.idEstadoCurso, T1.fechaInicioInscripcion, T1.fechaFinInscripcion, T1.vacantes, T1.nombre AS empresa, T2.nombre AS curso "
										+ "FROM (SELECT T1.idCursada, T1.idEmpresa, T1.idCurso, T1.idSala, T1.idEstadoCurso, T1.fechaInicioInscripcion, T1.fechaFinInscripcion, T1.vacantes, T2.nombre FROM cursada AS T1 "
										+ "INNER JOIN empresa AS T2 ON T1.idEmpresa = T2.idEmpresa) AS T1 "
										+ "INNER JOIN curso AS T2 ON T1.idCurso = T2.idCurso) AS T1 "
										+ "INNER JOIN estadocurso AS T2 ON T1.idEstadoCurso = T2.idEstadoCurso) AS T1 "
										+ "INNER JOIN sala AS T2 ON T1.idSala = T2.idSala ORDER BY T1.fechaInicioInscripcion DESC";
	@Override
	public List<CursadaCompletaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<CursadaCompletaDTO> cursadas = new ArrayList<CursadaCompletaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaInicioInscripcion = resultSet.getTimestamp("fechaInicioInscripcion").toLocalDateTime();
				LocalDateTime fechaFinInscripcion = resultSet.getTimestamp("fechaFinInscripcion").toLocalDateTime();
				cursadas.add(new CursadaCompletaDTO(resultSet.getLong("idCursada"), 
													resultSet.getLong("idEmpresa"), 
													resultSet.getLong("idCurso"), 
													resultSet.getLong("idSala"), 
													resultSet.getLong("idEstadoCurso"), 
													fechaInicioInscripcion, 
													fechaFinInscripcion, 
													resultSet.getString("vacantes"), 
													resultSet.getString("empresa"), 
													resultSet.getString("curso"), 
													resultSet.getString("estadoCurso"), 
													resultSet.getString("sala")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursadas;
	}

}
