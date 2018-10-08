package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CursadaDAO;
import dto.CursadaDTO;

public class CursadaDAOSQL implements CursadaDAO{
	
	private static final String insert = "INSERT INTO cursada (idEmpresa, idCurso, idUsuario, idSala, idEstadoCurso, vacantes) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM cursada WHERE idCursada = ?";
	private static final String update = "UPDATE cursada SET idEmpresa = ?, idCurso = ?, idUsuario = ?, idSala = ?, idEstadoCurso = ?, vacantes = ? WHERE idCursada = ?";
	private static final String readall = "SELECT * FROM cursada";

	@Override
	public boolean insert(CursadaDTO cursada) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setFloat(1, cursada.getIdEmpresa());
			statement.setFloat(2, cursada.getIdCurso());
			statement.setFloat(3, cursada.getIdUsuario());
			statement.setFloat(4, cursada.getIdSala());
			statement.setFloat(5, cursada.getIdEstadoCurso());
			statement.setInt(6, cursada.getVacantes());
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
	public boolean delete(CursadaDTO cursada) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(cursada.getIdCursada()));
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
	public boolean update(CursadaDTO cursada) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setFloat(1, cursada.getIdEmpresa());
			statement.setFloat(2, cursada.getIdCurso());
			statement.setFloat(3, cursada.getIdUsuario());
			statement.setFloat(4, cursada.getIdSala());
			statement.setFloat(5, cursada.getIdEstadoCurso());
			statement.setInt(6, cursada.getVacantes());
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
	public List<CursadaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<CursadaDTO> cursadas = new ArrayList<CursadaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cursadas.add(new CursadaDTO(resultSet.getLong("idCursada"), 
											resultSet.getLong("idEmpresa"),
											resultSet.getLong("idCurso"), 
											resultSet.getLong("idUsuario"),
											resultSet.getLong("idSala"),
											resultSet.getLong("idEstadoCurso"),
											resultSet.getInt("vacantes")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cursadas;
	}


}
