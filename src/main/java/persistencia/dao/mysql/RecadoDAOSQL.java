package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.RecadoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.RecadoDAO;

public class RecadoDAOSQL implements RecadoDAO {

	private static final String insert = "INSERT INTO recado (idUsuarioDe, idUsuarioPara, asunto, mensaje, visto, eliminado) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM recado WHERE idRecado = ?";
	private static final String update = "UPDATE recado SET idUsuarioDe = ?, idUsuarioPara = ?, asunto = ?, mensaje = ?, visto = ?, eliminado = ?  WHERE idRecado = ?";
	private static final String readall = "SELECT * FROM recado";

	@Override
	public boolean insert(RecadoDTO recado) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, recado.getIdUsuarioDe());
			statement.setLong(2, recado.getIdUsuarioPara());
			statement.setString(3, recado.getAsunto());
			statement.setString(4, recado.getMensaje());
			statement.setBoolean(5, recado.isVisto());
			statement.setBoolean(6, recado.isEliminado());
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
	public boolean delete(RecadoDTO recado_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(recado_a_eliminar.getIdRecado()));
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
	public boolean update(RecadoDTO recado_a_actualizar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setLong(1, recado_a_actualizar.getIdUsuarioDe());
			statement.setLong(2, recado_a_actualizar.getIdUsuarioPara());
			statement.setString(3, recado_a_actualizar.getAsunto());
			statement.setString(4, recado_a_actualizar.getMensaje());
			statement.setBoolean(5, recado_a_actualizar.isVisto());
			statement.setBoolean(6, recado_a_actualizar.isEliminado());
			statement.setLong(7, recado_a_actualizar.getIdRecado());
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
	public List<RecadoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<RecadoDTO> recados = new ArrayList<RecadoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				recados.add(new RecadoDTO(
								resultSet.getLong("idRecado"), 
								resultSet.getLong("idUsuarioDe"),
								resultSet.getLong("idUsuarioPara"), 
								resultSet.getString("asunto"),
								resultSet.getString("mensaje"),
								resultSet.getTimestamp("fechaHoraEnvio"),
								resultSet.getBoolean("visto"),
								resultSet.getBoolean("eliminado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return recados;
	}

}
