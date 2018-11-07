package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.UsuarioDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.UsuarioDAO;

public class UsuarioDAOSQL implements UsuarioDAO {
	
	private static final String insert = "INSERT INTO usuario (idCategoria, nombre, apellido, telefono, email, usuario, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM usuario WHERE idUsuario = ?";
	private static final String update = "UPDATE usuario SET idCategoria = ?, nombre = ?, apellido = ?, telefono = ?, email = ?, usuario = ?, password = ?  WHERE idUsuario = ?";
	private static final String readall = "SELECT * FROM usuario";

	@Override
	public boolean insert(UsuarioDTO usuario) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, usuario.getIdCategoria());
			statement.setString(2, usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setString(4, usuario.getTelefono());
			statement.setString(5, usuario.getEmail());
			statement.setString(6, usuario.getUsuario());
			statement.setString(7, usuario.getPassword());
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
	public boolean delete(UsuarioDTO usuario) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(usuario.getIdUsuario()));
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
	public boolean update(UsuarioDTO usuario) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setLong(1, usuario.getIdCategoria());
			statement.setString(2, usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setString(4, usuario.getTelefono());
			statement.setString(5, usuario.getEmail());
			statement.setString(6, usuario.getUsuario());
			statement.setString(7, usuario.getPassword());
			statement.setLong(8, usuario.getIdUsuario());
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
	public List<UsuarioDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				usuarios.add(new UsuarioDTO(resultSet.getLong("idUsuario"), 
												resultSet.getLong("idCategoria"), 
												resultSet.getString("nombre"),
												resultSet.getString("apellido"), 
												resultSet.getString("telefono"),
												resultSet.getString("email"),
												resultSet.getString("usuario"),
												resultSet.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return usuarios;
	}
}
