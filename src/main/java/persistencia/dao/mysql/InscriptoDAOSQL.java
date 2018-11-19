package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.InscriptoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.InscriptoDAO;

public class InscriptoDAOSQL implements InscriptoDAO {

	private static final String insert = "INSERT INTO inscripto (idAlumno, idCursada, fecha, estado) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM inscripto WHERE idAlumno = ? AND idCursada = ?";
	private static final String update = "UPDATE inscripto SET fecha = ?, estado = ? WHERE idAlumno = ? AND idCursada = ?";
	//private static final String readall = "SELECT * FROM inscripto WHERE idCursada = ?";
	private static final String readall = "SELECT * FROM inscripto";
	
	@Override
	public boolean insert(InscriptoDTO inscriptoDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, inscriptoDTO.getIdAlumno());
			statement.setLong(2, inscriptoDTO.getIdCursada());
			statement.setTimestamp(3, convertToTimeStamp(inscriptoDTO.getFecha()));
			statement.setBoolean(4, inscriptoDTO.isEstado());
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
	public boolean delete(InscriptoDTO inscriptoDTO) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setLong(1, inscriptoDTO.getIdAlumno());
			statement.setLong(2, inscriptoDTO.getIdCursada());
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
	public boolean update(InscriptoDTO inscriptoDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setTimestamp(1, convertToTimeStamp(inscriptoDTO.getFecha()));
			statement.setBoolean(2, inscriptoDTO.isEstado());
			statement.setLong(3, inscriptoDTO.getIdAlumno());
			statement.setLong(4, inscriptoDTO.getIdCursada());
			
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
	public List<InscriptoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<InscriptoDTO> inscripto = new ArrayList<InscriptoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				inscripto.add(new InscriptoDTO(resultSet.getLong("idAlumno"), 
											   resultSet.getLong("idCursada"), 
											   resultSet.getTimestamp("fecha").toLocalDateTime(),
											   resultSet.getBoolean("estado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return inscripto;
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
