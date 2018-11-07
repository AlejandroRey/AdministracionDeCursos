package persistencia.dao.interfaz;

import java.util.List;

import dto.CursadaDTO;

public interface CursadaDAO {
	
	public boolean insert(CursadaDTO nuevaCursada);

	public boolean delete(CursadaDTO cursada_a_eliminar);

	public boolean update(CursadaDTO cursada_a_actualizar);

	public List<CursadaDTO> readAll();
}
