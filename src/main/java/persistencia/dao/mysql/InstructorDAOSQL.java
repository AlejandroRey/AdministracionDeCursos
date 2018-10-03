package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.InstructorDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.InstructorDAO;

public class InstructorDAOSQL implements InstructorDAO {

	private static final String insert = "INSERT INTO instructor (idCursoTipo, nombre, apellido, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE * FROM instructor WHERE idInstructor = ?";
	private static final String update = "UPDATE instructor SET idCursoTipo = ?, nombre = ?, apellido = ?, telefono = ?, email = ? WHERE idInstructor = ?";
	private static final String readall = "SELECT * FROM instructor";

	public boolean insert(InstructorDTO instructor) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, instructor.getIdCursoTipo());
			statement.setString(2, instructor.getNombre());
			statement.setString(3, instructor.getApellido());
			statement.setString(4, instructor.getTelefono());
			statement.setString(5, instructor.getEmail());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(InstructorDTO instructor) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(instructor.getIdInstructor()));
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(InstructorDTO instructor) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setLong(1, instructor.getIdCursoTipo());
			statement.setString(2, instructor.getNombre());
			statement.setString(3, instructor.getApellido());
			statement.setString(4, instructor.getTelefono());
			statement.setString(5, instructor.getEmail());
			statement.setLong(6, instructor.getIdInstructor());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<InstructorDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<InstructorDTO> instructores = new ArrayList<InstructorDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				instructores.add(new InstructorDTO(
								resultSet.getLong("idInstructor"), 
								resultSet.getLong("idCursoTipo"), 
								resultSet.getString("nombre"),
								resultSet.getString("apellido"), 
								resultSet.getString("telefono"),
								resultSet.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instructores;
	}

}
