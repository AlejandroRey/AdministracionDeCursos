package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.NotificacionDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.NotificacionDAO;

public class NotificacionDAOSQL implements NotificacionDAO {
	
	private static final String insert = "INSERT INTO notificacion (idUsuario, tipoNotificacion, mensaje, visto, fechaHora) VALUES (?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM notificacion WHERE idNotificacion = ?";
	private static final String update = "UPDATE notificacion SET idUsuario = ?, tipoNotificacion = ?, mensaje = ?, visto = ?, fechaHora = ? WHERE idNotificacion = ?";
	private static final String readall = "SELECT * FROM notificacion";
	
	@Override
	public boolean insert(NotificacionDTO notificacion) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, notificacion.getIdUsuario());
			statement.setLong(2, notificacion.getTipoNotificacion());
			statement.setString(3, notificacion.getMensaje());
			statement.setBoolean(4, notificacion.isVisto());
			statement.setTimestamp(5, convertToTimeStamp(notificacion.getFechaHora()));
			
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
	public boolean delete(NotificacionDTO notificacion) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(notificacion.getIdNotificacion()));
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
	public boolean update(NotificacionDTO notificacion) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setLong(1, notificacion.getIdUsuario());
			statement.setLong(2, notificacion.getTipoNotificacion());
			statement.setString(3, notificacion.getMensaje());
			statement.setBoolean(4, notificacion.isVisto());
			statement.setTimestamp(5, convertToTimeStamp(notificacion.getFechaHora()));
			statement.setLong(6, notificacion.getIdNotificacion());
			
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
	public List<NotificacionDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<NotificacionDTO> notificaciones = new ArrayList<NotificacionDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaHora = resultSet.getTimestamp("fechaHora").toLocalDateTime();
				notificaciones.add(new NotificacionDTO(resultSet.getLong("idNotificacion"),
											resultSet.getLong("idUsuario"),
											resultSet.getLong("tipoNotificacion"),
											resultSet.getString("mensaje"),
											resultSet.getBoolean("visto"),
											fechaHora));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return notificaciones;
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
