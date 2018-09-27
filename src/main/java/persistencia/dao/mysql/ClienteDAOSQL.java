package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ClienteDAO;

public class ClienteDAOSQL implements ClienteDAO {
	
	private static final String insert = "INSERT INTO cliente (idEmpresa, nombre, apellido, telefono, email) VALUES (?, ?, ?, ?, ?)";
	private static final String delete = "DELETE * FROM cliente WHERE idCliente = ?";
	private static final String update = "UPDATE cliente SET idEmpresa = ?, nombre = ?, apellido = ?, telefono = ?, email = ? WHERE idCliente = ?";
	private static final String readall = "SELECT * FROM cliente";

	public boolean insert(ClienteDTO clienteParaAgregar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, clienteParaAgregar.getIdEmpresa());
			statement.setString(2, clienteParaAgregar.getNombre());
			statement.setString(3, clienteParaAgregar.getApellido());
			statement.setString(4, clienteParaAgregar.getTelefono());
			statement.setString(5, clienteParaAgregar.getEmail());
			statement.setLong(6, clienteParaAgregar.getIdCliente());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(ClienteDTO clienteParaEliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(clienteParaEliminar.getIdCliente()));
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(ClienteDTO clienteParaActualizar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setLong(1, clienteParaActualizar.getIdEmpresa());
			statement.setString(2, clienteParaActualizar.getNombre());
			statement.setString(3, clienteParaActualizar.getApellido());
			statement.setString(4, clienteParaActualizar.getTelefono());
			statement.setString(5, clienteParaActualizar.getEmail());
			statement.setLong(6, clienteParaActualizar.getIdCliente());
			if (statement.executeUpdate() > 0) // True is successfully return
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ClienteDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				clientes.add(new ClienteDTO(
								 resultSet.getLong("idCliente"), 
								 resultSet.getLong("idEmpresa"), 
								 resultSet.getString("nombre"), 
								 resultSet.getString("apellido"), 
								 resultSet.getString("telefono"), 
								 resultSet.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

}
