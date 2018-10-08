package persistencia.dao.interfaz;

import java.util.List;

import dto.AlumnoEventoDTO;

public interface AlumnoEventoDAO {
	
	public boolean insert(AlumnoEventoDTO alumnoEventoParaAgregar);

	public List<AlumnoEventoDTO> readAll();

}
