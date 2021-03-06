package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.TareaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TareaDAO;

public class TareaDAOSQL implements TareaDAO{
	private static final String insert = "INSERT INTO tarea (idAdministrativo, idAlumno, nombre, descripcion, estado, fechaCreacion, fechaRealizar, fechaCierre) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String insertNoAlumno = "INSERT INTO tarea (idAdministrativo, nombre, descripcion, estado, fechaCreacion, fechaRealizar, fechaCierre) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM tarea WHERE idTarea = ?";
	private static final String update = "UPDATE tarea SET idAdministrativo = ?, idAlumno = ?, nombre = ?, descripcion = ?, estado = ?, fechaCreacion = ?, fechaRealizar = ?, fechaCierre = ? WHERE idTarea = ?";
	private static final String updateNoAlumno = "UPDATE tarea SET idAdministrativo = ?, nombre = ?, descripcion = ?, estado = ?, fechaCreacion = ?, fechaRealizar = ?, fechaCierre = ? WHERE idTarea = ?";
	private static final String readall = "SELECT * FROM tarea";

	@Override
	public boolean insert(TareaDTO tarea) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			if(tarea.getIdAlumno() != 0){
				statement = conexion.getSQLConexion().prepareStatement(insert);
				statement.setLong(1, tarea.getIdUsuario());
				statement.setLong(2, tarea.getIdAlumno());
				statement.setString(3, tarea.getNombre());
				statement.setString(4, tarea.getDescripcion());
				statement.setString(5, tarea.getEstado());
				statement.setTimestamp(6, convertToTimeStamp(tarea.getFechaCreacion()));
				statement.setTimestamp(7, convertToTimeStamp(tarea.getFechaRealizar()));
				statement.setTimestamp(8, convertToTimeStamp(tarea.getFechaCierre()));
			} else {
				statement = conexion.getSQLConexion().prepareStatement(insertNoAlumno);
				statement.setLong(1, tarea.getIdUsuario());
				statement.setString(2, tarea.getNombre());
				statement.setString(3, tarea.getDescripcion());
				statement.setString(4, tarea.getEstado());
				statement.setTimestamp(5, convertToTimeStamp(tarea.getFechaCreacion()));
				statement.setTimestamp(6, convertToTimeStamp(tarea.getFechaRealizar()));
				statement.setTimestamp(7, convertToTimeStamp(tarea.getFechaCierre()));
			}
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
	public boolean delete(TareaDTO tarea) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(tarea.getIdTarea()));
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
	public boolean update(TareaDTO tarea) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			if(tarea.getIdAlumno() != 0){
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, Long.toString(tarea.getIdUsuario()));
			statement.setLong(2, getID(tarea.getIdAlumno()));
			statement.setString(3, tarea.getNombre());
			statement.setString(4, tarea.getDescripcion());
			statement.setString(5, tarea.getEstado());
			statement.setTimestamp(6, convertToTimeStamp(tarea.getFechaCreacion()));
			statement.setTimestamp(7, convertToTimeStamp(tarea.getFechaRealizar()));
			statement.setTimestamp(8, convertToTimeStamp(tarea.getFechaCierre()));
			statement.setLong(9, tarea.getIdTarea());
		} else {
			statement = conexion.getSQLConexion().prepareStatement(updateNoAlumno);
			statement.setString(1, Long.toString(tarea.getIdUsuario()));
			statement.setString(2, tarea.getNombre());
			statement.setString(3, tarea.getDescripcion());
			statement.setString(4, tarea.getEstado());
			statement.setTimestamp(5, convertToTimeStamp(tarea.getFechaCreacion()));
			statement.setTimestamp(6, convertToTimeStamp(tarea.getFechaRealizar()));
			statement.setTimestamp(7, convertToTimeStamp(tarea.getFechaCierre()));
			statement.setLong(8, tarea.getIdTarea());
		}
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
	public List<TareaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<TareaDTO> tareas = new ArrayList<TareaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaCreacion = resultSet.getTimestamp("fechaCreacion").toLocalDateTime();
				LocalDateTime fechaRealizar = resultSet.getTimestamp("fechaRealizar").toLocalDateTime();
				LocalDateTime fechaCierre = convertToLocalDateTime(resultSet.getTimestamp("fechaCierre"));
				tareas.add(new TareaDTO(resultSet.getLong("idTarea"), 
											resultSet.getLong("idAdministrativo"),
											resultSet.getLong("idAlumno"),
											resultSet.getString("nombre"), 
											resultSet.getString("descripcion"),
											resultSet.getString("estado"),
											fechaCreacion,
											fechaRealizar,
											fechaCierre));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return tareas;
	}
	
	public Timestamp convertToTimeStamp(LocalDateTime ldt) {
		return ldt != null ? Timestamp.valueOf(ldt) : null;
	}

	public LocalDateTime convertToLocalDateTime(Timestamp ts) {
		return ts != null ? ts.toLocalDateTime() : null;
	}
	
	public Long getID(Long id) {
		return id!= null ? id : null;
	}
	

	public static void main (String[] args) {
		Long l = null;
		System.out.println(l);
	}
}
