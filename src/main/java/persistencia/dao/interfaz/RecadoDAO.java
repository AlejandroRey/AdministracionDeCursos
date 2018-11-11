package persistencia.dao.interfaz;

import java.util.List;

import dto.RecadoDTO;

public interface RecadoDAO {

	public boolean insert(RecadoDTO nuevoRecado);

	public boolean delete(RecadoDTO recado_a_eliminar);

	public boolean update(RecadoDTO recado_a_actualizar);

	public List<RecadoDTO> readAll();
	
}
