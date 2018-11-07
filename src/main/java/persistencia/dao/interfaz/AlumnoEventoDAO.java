package persistencia.dao.interfaz;

import java.util.List;

import dto.AlumnoEventoDTO;

public interface AlumnoEventoDAO {
	
	public boolean insert(AlumnoEventoDTO alumnoEventoParaAgregar);

	public boolean delete(AlumnoEventoDTO alumnoEvento_a_eliminar);

	public boolean update(AlumnoEventoDTO alumnoEvento_a_actualizar);
	
	public List<AlumnoEventoDTO> readAll();
	
}
