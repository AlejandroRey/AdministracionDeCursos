package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.CursadaDTO;
import dto.FechaCursadaClaseDTO;
import dto.SalaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.FechaCursadaClaseDAO;

public class FechaCursadaClaseDAOSQL implements FechaCursadaClaseDAO {
	
	private static final String insert = "INSERT INTO fechacursadaclase (idCursada, idSala, fechaInicio, fechaFin, estadoSala) VALUES (?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM fechacursadaclase WHERE idFechaCursadaClase = ?";
	private static final String update = "UPDATE fechacursadaclase SET idCursada = ?, idSala = ?, fechaInicio = ?, fechaFin = ?, estadoSala = ? WHERE idFechaCursadaClase = ?";
	private static final String readall = "SELECT * FROM fechacursadaclase WHERE idCursada = ?";
	private static final String readallBySala = "SELECT * FROM fechacursadaclase WHERE idSala = ?";

	@Override
	public boolean insert(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, fechaCursadaClaseDTO.getIdCursada());
			statement.setLong(2, fechaCursadaClaseDTO.getIdSala());
			statement.setTimestamp(3, convertToTimeStamp(fechaCursadaClaseDTO.getFechaInicio()));
			statement.setTimestamp(4, convertToTimeStamp(fechaCursadaClaseDTO.getFechaFin()));
			statement.setInt(5, fechaCursadaClaseDTO.getEstadoSala());
			
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
	public boolean delete(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(fechaCursadaClaseDTO.getIdFechaCursadaClase()));
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
	public boolean update(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setLong(1, fechaCursadaClaseDTO.getIdCursada());
			statement.setLong(2, fechaCursadaClaseDTO.getIdSala());
			statement.setTimestamp(3, convertToTimeStamp(fechaCursadaClaseDTO.getFechaInicio()));
			statement.setTimestamp(4, convertToTimeStamp(fechaCursadaClaseDTO.getFechaFin()));
			statement.setInt(5, fechaCursadaClaseDTO.getEstadoSala());
			statement.setLong(6, fechaCursadaClaseDTO.getIdFechaCursadaClase());
			
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
	public List<FechaCursadaClaseDTO> readAll(CursadaDTO cursadaDTO) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<FechaCursadaClaseDTO> fechasCursadasClases = new ArrayList<FechaCursadaClaseDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, cursadaDTO.getIdCursada());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				fechasCursadasClases.add(new FechaCursadaClaseDTO(resultSet.getLong("idFechaCursadaClase"), 
																  resultSet.getLong("idCursada"), 
																  resultSet.getLong("idSala"), 
																  resultSet.getTimestamp("fechaInicio").toLocalDateTime(), 
																  resultSet.getTimestamp("fechaFin").toLocalDateTime(),
																  resultSet.getInt("estadoSala")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return fechasCursadasClases;
	}
	
	@Override
	public List<FechaCursadaClaseDTO> readAll(SalaDTO salaDTO) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<FechaCursadaClaseDTO> fechasCursadasClases = new ArrayList<FechaCursadaClaseDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readallBySala);
			statement.setLong(1, salaDTO.getIdSala());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				fechasCursadasClases.add(new FechaCursadaClaseDTO(resultSet.getLong("idFechaCursadaClase"), 
																  resultSet.getLong("idCursada"), 
																  resultSet.getLong("idSala"), 
																  resultSet.getTimestamp("fechaInicio").toLocalDateTime(), 
																  resultSet.getTimestamp("fechaFin").toLocalDateTime(),
																  resultSet.getInt("estadoSala")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return fechasCursadasClases;
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
