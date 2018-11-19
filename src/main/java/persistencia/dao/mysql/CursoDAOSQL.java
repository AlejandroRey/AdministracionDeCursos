package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CursoDTO;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CursoDAO;

public class CursoDAOSQL implements CursoDAO{
	
	private static final String insert = "INSERT INTO curso (idCursoTipo, nombre, tema, temario) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM curso WHERE idCurso = ?";
	private static final String update = "UPDATE curso SET idCursoTipo = ?, nombre = ?, tema = ?, temario = ?  WHERE idCurso = ?";
	private static final String readall = "SELECT * FROM curso";
	private static final String readone = "SELECT * FROM curso WHERE idCurso = ?";
	

	@Override
	public boolean insert(CursoDTO nuevoCurso) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, nuevoCurso.getIdCursoTipo());
			statement.setString(2, nuevoCurso.getNombre());
			statement.setString(3, nuevoCurso.getTema());
			statement.setString(4, nuevoCurso.getTemario());
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
	public boolean delete(CursoDTO curso_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(curso_a_eliminar.getIdCurso()));
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
	public boolean update(CursoDTO curso_a_actualizar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);				
			statement.setLong(1, curso_a_actualizar.getIdCursoTipo());
			statement.setString(2, curso_a_actualizar.getNombre());
			statement.setString(3, curso_a_actualizar.getTema());
			statement.setString(4, curso_a_actualizar.getTemario());
			statement.setLong(5, curso_a_actualizar.getIdCurso());
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
	public List<CursoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<CursoDTO> cursos = new ArrayList<CursoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cursos.add(new CursoDTO(resultSet.getLong("idCurso"), 
										  resultSet.getLong("IdCursoTipo"),
										  resultSet.getString("nombre"), 
										  resultSet.getString("tema"),
										  resultSet.getString("temario")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cursos;
	}
	
	@Override
	public CursoDTO obtenerCurso(long id) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		CursoDTO curso = null;
		try {
			statement = conexion.getSQLConexion().prepareStatement(readone);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSet.next();
			curso = new CursoDTO(resultSet.getLong("idCurso"), 
										  resultSet.getLong("IdCursoTipo"),
										  resultSet.getString("nombre"), 
										  resultSet.getString("tema"),
										  resultSet.getString("temario"));		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return curso;
	}
}
