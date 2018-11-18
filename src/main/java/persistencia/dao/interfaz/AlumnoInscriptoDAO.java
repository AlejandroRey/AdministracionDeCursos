package persistencia.dao.interfaz;

import java.util.List;

import dto.AlumnoInscriptoDTO;
import dto.CursadaDTO;

public interface AlumnoInscriptoDAO {

	public List<AlumnoInscriptoDTO> readAll(CursadaDTO cursada);
	
}
