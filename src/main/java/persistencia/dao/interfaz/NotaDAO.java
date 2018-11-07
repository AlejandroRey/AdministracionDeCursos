package persistencia.dao.interfaz;

import java.util.List;

import dto.EvaluacionDTO;
import dto.NotaDTO;

public interface NotaDAO {

	public boolean insert(NotaDTO notaDTO);

	public boolean delete(NotaDTO notaDTO);

	public boolean update(NotaDTO notaDTO);

	public List<NotaDTO> readAll(EvaluacionDTO evaluacionDTO);
	
}
