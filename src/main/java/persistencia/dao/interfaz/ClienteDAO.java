package persistencia.dao.interfaz;

import java.util.List;

import dto.ClienteDTO;

public interface ClienteDAO {
	
	public boolean insert(ClienteDTO clienteParaAgregar);

	public boolean delete(ClienteDTO clienteParaEliminar);

	public boolean update(ClienteDTO clienteParaActualizar);

	public List<ClienteDTO> readAll();

}
