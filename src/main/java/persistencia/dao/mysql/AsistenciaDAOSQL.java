package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AsistenciaDTO;
import dto.FechaCursadaClaseDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.AsistenciaDAO;

public class AsistenciaDAOSQL implements AsistenciaDAO {
	
	private static final String insert = "INSERT INTO asistencia (idAlumno, idFechaCursadaClase, tipoAsistencia, comentario) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM asistencia WHERE idAlumno = ? AND idFechaCursadaClase = ?";
	private static final String update = "UPDATE asistencia SET tipoAsistencia = ?, comentario = ? WHERE idAlumno = ? AND idFechaCursadaClase = ?";
	private static final String readall = "SELECT * FROM asistencia WHERE idFechaCursadaClase = ?";
	
	public boolean insert(AsistenciaDTO asistenciaDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, asistenciaDTO.getIdAlumno());
			statement.setLong(2, asistenciaDTO.getIdFechaCursadaClase());
			statement.setInt(3, asistenciaDTO.getTipoAsistencia());
			statement.setString(4, asistenciaDTO.getComentario());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}
	
	public boolean update(AsistenciaDTO asistenciaDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setInt(1, asistenciaDTO.getTipoAsistencia());
			statement.setString(2, asistenciaDTO.getComentario());
			statement.setLong(3, asistenciaDTO.getIdAlumno());
			statement.setLong(4, asistenciaDTO.getIdFechaCursadaClase());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}
	
	public boolean delete(AsistenciaDTO asistenciaDTO) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(asistenciaDTO.getIdAlumno()));
			statement.setString(2, Long.toString(asistenciaDTO.getIdFechaCursadaClase()));
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
	
	public List<AsistenciaDTO> readAll(FechaCursadaClaseDTO fechaCursadaClaseDTO) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AsistenciaDTO> asistenciaList = new ArrayList<AsistenciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, fechaCursadaClaseDTO.getIdFechaCursadaClase());
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				asistenciaList.add(new AsistenciaDTO(resultSet.getLong("idAlumno"), 
													 resultSet.getLong("idFechaCursadaClase"), 
													 resultSet.getInt("tipoAsistencia"), 
													 resultSet.getString("comentario")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return asistenciaList;
	}

}
