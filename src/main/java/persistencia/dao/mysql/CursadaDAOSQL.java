package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.CursadaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CursadaDAO;

public class CursadaDAOSQL implements CursadaDAO{
	
	private static final String insert = "INSERT INTO cursada (idEmpresa, idCurso, idSala, idEstadoCurso, fechaInicioInscripcion, fechaFinInscripcion, vacantes) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM cursada WHERE idCursada = ?";
	private static final String update = "UPDATE cursada SET idEmpresa = ?, idCurso = ?, idSala = ?, idEstadoCurso = ?, fechaInicioInscripcion = ?, fechaFinInscripcion = ?, vacantes = ? WHERE idCursada = ?";
	private static final String readall = "SELECT * FROM cursada";

	@Override
	public boolean insert(CursadaDTO cursada) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, cursada.getIdEmpresa());
			statement.setLong(2, cursada.getIdCurso());
			statement.setLong(3, cursada.getIdSala());
			statement.setLong(4, cursada.getIdEstadoCurso());
			statement.setTimestamp(5, convertToTimeStamp(cursada.getFechaInicioInscripcion()));
			statement.setTimestamp(6, convertToTimeStamp(cursada.getFechaFinInscripcion()));
			statement.setString(7, cursada.getVacantes());
			
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
	public boolean delete(CursadaDTO cursada) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(cursada.getIdCursada()));
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
	public boolean update(CursadaDTO cursada) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		System.out.println("AWWWWWWWWWWWWWWWWWWWWWWWWWW");
		System.out.println(cursada.toString());
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setLong(1, cursada.getIdEmpresa());
			statement.setLong(2, cursada.getIdCurso());
			statement.setLong(3, cursada.getIdSala());
			statement.setLong(4, cursada.getIdEstadoCurso());
			statement.setTimestamp(5, convertToTimeStamp(cursada.getFechaInicioInscripcion()));
			statement.setTimestamp(6, convertToTimeStamp(cursada.getFechaFinInscripcion()));
			statement.setString(7, cursada.getVacantes());
			statement.setLong(8, cursada.getIdCursada());
			
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
	public List<CursadaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<CursadaDTO> cursadas = new ArrayList<CursadaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaInicio = resultSet.getTimestamp("fechaInicioInscripcion").toLocalDateTime();
				LocalDateTime fechaFin = resultSet.getTimestamp("fechaFinInscripcion").toLocalDateTime();
				cursadas.add(new CursadaDTO(resultSet.getLong("idCursada"),
											resultSet.getLong("idEmpresa"),
											resultSet.getLong("idCurso"),
											resultSet.getLong("idSala"),
											resultSet.getLong("idEstadoCurso"),
											fechaInicio,
											fechaFin,
											resultSet.getString("vacantes")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cursadas;
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
