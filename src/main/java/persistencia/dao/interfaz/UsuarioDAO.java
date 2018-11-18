package persistencia.dao.interfaz;

import java.util.List;

import dto.UsuarioDTO;

public interface UsuarioDAO {

	public boolean insert(UsuarioDTO usuarioParaAgregar);

	public boolean delete(UsuarioDTO usuarioParaEliminar);

	public boolean update(UsuarioDTO usuarioParaActualizar);

	public List<UsuarioDTO> readAll();
	
}
