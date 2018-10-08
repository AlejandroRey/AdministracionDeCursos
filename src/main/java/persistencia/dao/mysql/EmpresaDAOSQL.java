package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EmpresaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EmpresaDAO;

public class EmpresaDAOSQL implements EmpresaDAO{
	
	private static final String insert = "INSERT INTO empresa (idEmpresa, nombre, telefono, email) VALUES (?, ?, ?, ?)";
	private static final String delete = "DELETE FROM empresa WHERE idEmpresa = ?";
	private static final String update = "UPDATE empresa SET nombre = ?, telefono = ?, email = ? WHERE idEmpresa = ?";
	private static final String readall = "SELECT * FROM empresa";
	
	@Override
	public boolean insert(EmpresaDTO empresa) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, empresa.getNombre());
			statement.setString(2, empresa.getTelefono());
			statement.setString(3, empresa.getEmail());
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
	public boolean delete(EmpresaDTO empresa) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(empresa.getIdEmpresa()));
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
	public boolean update(EmpresaDTO empresa) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, empresa.getNombre());
			statement.setString(2, empresa.getTelefono());
			statement.setString(3, empresa.getEmail());
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
	public List<EmpresaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				empresas.add(new EmpresaDTO(resultSet.getLong("idEmpresa"), 
											resultSet.getString("nombre"),
											resultSet.getString("telefono"), 
											resultSet.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return empresas;
	}

}
