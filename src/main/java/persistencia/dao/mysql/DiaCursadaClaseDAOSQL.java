package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dto.CursadaDTO;
import dto.DiaCursadaClaseDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DiaCursadaClaseDAO;

public class DiaCursadaClaseDAOSQL implements DiaCursadaClaseDAO {
	
	private static final String insert = "INSERT INTO diacursadaclase (idCursada, idDia, nombreDia, horaInicio, horaFin) VALUES (?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM diacursadaclase WHERE idCursada = ?";
	private static final String update = "UPDATE diacursadaclase SET idDia = ?, nombreDia = ?, horaInicio = ?, horaFin = ? WHERE idCursada = ? AND idDia = ?";
	private static final String readall = "SELECT * FROM diacursadaclase WHERE idCursada = ?";	

	@Override
	public boolean insert(DiaCursadaClaseDTO diaCursadaClaseDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, diaCursadaClaseDTO.getIdCursada());
			statement.setLong(2, diaCursadaClaseDTO.getIdDia());
			statement.setString(3, diaCursadaClaseDTO.getNombreDia());
			statement.setTimestamp(4, convert(diaCursadaClaseDTO.getHoraInicio()));
			statement.setTimestamp(5, convert(diaCursadaClaseDTO.getHoraFin()));
			
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
	public boolean delete(CursadaDTO cursadaDTO) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(cursadaDTO.getIdCursada()));
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
	public boolean update(DiaCursadaClaseDTO diaCursadaClaseDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			//statement.setString(1, sala.getNombre());
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
	public List<DiaCursadaClaseDTO> readAll(CursadaDTO cursada) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<DiaCursadaClaseDTO> diasCursadasClases = new ArrayList<DiaCursadaClaseDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, cursada.getIdCursada());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				diasCursadasClases.add(new DiaCursadaClaseDTO(resultSet.getLong("idCursada"), 
															  resultSet.getInt("idDia"), 
															  resultSet.getString("nombreDia"), 
															  resultSet.getTime("horaInicio").toLocalTime(), 
															  resultSet.getTime("horaFin").toLocalTime()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return diasCursadasClases;
	}
//
//	/**
//	 * Convert a LocalDateTime to a Timestamp using the system timezone.
//	 */
//	private Timestamp convert(LocalDateTime localDateTime) {
//		return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
//	}
//
//	private Date convert(LocalDate localDate) {
//		return localDate == null ? null : Date.valueOf(localDate);
//	}

	/**
	 * Convert a LocalTime to a Timestamp. The LocalTime can't be converted to a
	 * java.sql.Time because the nanoseconds will be lost.
	 */
	private Timestamp convert(LocalTime localTime) {
		return localTime == null ? null : Timestamp.valueOf(localTime.atDate(LocalDate.ofEpochDay(0)));
	}

}
