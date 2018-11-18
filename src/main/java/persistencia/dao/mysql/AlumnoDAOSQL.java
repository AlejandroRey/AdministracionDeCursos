package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.AlumnoDAO;

public class AlumnoDAOSQL implements AlumnoDAO {
	
	private static final String insert = "INSERT INTO alumno (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM alumno WHERE idAlumno = ?";
	private static final String update = "UPDATE alumno SET nombre = ?, apellido = ?, telefono = ?, email = ?  WHERE idAlumno = ?";
	private static final String readall = "SELECT * FROM alumno";

	@Override
	public boolean insert(AlumnoDTO alumno) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, alumno.getNombre());
			statement.setString(2, alumno.getApellido());
			statement.setString(3, alumno.getTelefono());
			statement.setString(4, alumno.getEmail());
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
	public boolean delete(AlumnoDTO alumno) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(alumno.getIdAlumno()));
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
	public boolean update(AlumnoDTO alumno) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, alumno.getNombre());
			statement.setString(2, alumno.getApellido());
			statement.setString(3, alumno.getTelefono());
			statement.setString(4, alumno.getEmail());
			statement.setLong(5, alumno.getIdAlumno());;
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
	public List<AlumnoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AlumnoDTO> alumnos = new ArrayList<AlumnoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnos.add(new AlumnoDTO(resultSet.getLong("idAlumno"), 
										  resultSet.getString("nombre"),
										  resultSet.getString("apellido"), 
										  resultSet.getString("telefono"),
										  resultSet.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnos;
	}
}
