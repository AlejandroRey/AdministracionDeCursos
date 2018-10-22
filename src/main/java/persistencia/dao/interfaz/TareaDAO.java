package persistencia.dao.interfaz;

import java.util.List;

import dto.TareaDTO;

public interface TareaDAO {
	
	public boolean insert(TareaDTO nuevo_tarea);

	public boolean delete(TareaDTO tarea_a_eliminar);

	public boolean update(TareaDTO tarea_a_actualizar);

	public List<TareaDTO> readAll();

}
