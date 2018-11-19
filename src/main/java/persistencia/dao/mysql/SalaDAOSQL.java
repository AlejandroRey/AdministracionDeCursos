package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SalaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.SalaDAO;

public class SalaDAOSQL implements SalaDAO{
	
	private static final String insert = "INSERT INTO sala (nombre, cantidadAlumnos, cantidadPC, descripcion) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM sala WHERE idSala = ?";
	private static final String update = "UPDATE sala SET nombre = ?, cantidadAlumnos = ?, cantidadPC = ?, descripcion = ? WHERE idSala = ?";
	private static final String readall = "SELECT * FROM sala";
	
	@Override
	public boolean insert(SalaDTO sala) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, sala.getNombre());
			statement.setInt(2, sala.getCantidadAlumnos());
			statement.setInt(3, sala.getCantidadPc());
			statement.setString(4, sala.getDescripcion());
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
	public boolean delete(SalaDTO sala) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(sala.getIdSala()));
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
	public boolean update(SalaDTO sala) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, sala.getNombre());
			statement.setInt(2, sala.getCantidadAlumnos());
			statement.setInt(3, sala.getCantidadPc());
			statement.setString(4, sala.getDescripcion());
			statement.setLong(5, sala.getIdSala());;
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
	public List<SalaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<SalaDTO> salas = new ArrayList<SalaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				salas.add(new SalaDTO(resultSet.getLong("idSala"), 
											resultSet.getString("nombre"),
											resultSet.getInt("cantidadAlumnos"), 
											resultSet.getInt("cantidadPc"),
											resultSet.getString("descripcion")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return salas;
	}

}
