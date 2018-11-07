package persistencia.dao.interfaz;

import java.util.List;

import dto.AlumnoAsistenciaQtyDTO;
import dto.CursadaDTO;

public interface AlumnoAsistenciaQtyDAO {
	
	public List<AlumnoAsistenciaQtyDTO> readAll(CursadaDTO cursadaDTO);
	
}
