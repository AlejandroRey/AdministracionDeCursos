package persistencia.dao.interfaz;

import java.util.List;

import dto.CursadaDTO;
import dto.EvaluacionDTO;

public interface EvaluacionDAO {
	
	public List<EvaluacionDTO> readAll(CursadaDTO cursadaDTO);

}
