package persistencia.dao.interfaz;

import java.util.List;

import dto.SalaDTO;

public interface SalaDAO {
	
	public boolean insert(SalaDTO nuevosala);

	public boolean delete(SalaDTO sala_a_eliminar);

	public boolean update(SalaDTO sala_a_actualizar);

	public List<SalaDTO> readAll();

}
