package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EvaluacionDTO;
import dto.NotaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.NotaDAO;

public class NotaDAOSQL implements NotaDAO {
	
	private static final String insert = "INSERT INTO nota (idAlumno, idEvaluacion, nota) VALUES (?, ?, ?)";
	private static final String delete = "DELETE FROM nota WHERE idAlumno = ? AND idEvaluacion = ?";
	private static final String update = "UPDATE nota SET nota = ? WHERE idAlumno = ? AND idEvaluacion = ?";
	private static final String readall = "SELECT * FROM nota WHERE idEvaluacion = ?";

	@Override
	public boolean insert(NotaDTO notaDTO) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, notaDTO.getIdAlumno());
			statement.setLong(2, notaDTO.getIdEvaluacion());
			statement.setString(3, notaDTO.getNota());
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
	public boolean delete(NotaDTO notaDTO) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setLong(1, notaDTO.getIdAlumno());
			statement.setLong(2, notaDTO.getIdEvaluacion());
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
	public boolean update(NotaDTO notaDTO) {
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, notaDTO.getNota());
			statement.setLong(2, notaDTO.getIdAlumno());
			statement.setLong(3, notaDTO.getIdEvaluacion());
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
	public List<NotaDTO> readAll(EvaluacionDTO evaluacionDTO) {
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<NotaDTO> notasList = new ArrayList<NotaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, evaluacionDTO.getIdEvaluacion());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				notasList.add(new NotaDTO(resultSet.getLong("idAlumno"), 
										  resultSet.getLong("idEvaluacion"), 
										  resultSet.getString("nota")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return notasList;
	}

}
