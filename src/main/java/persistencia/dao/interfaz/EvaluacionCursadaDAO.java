package persistencia.dao.interfaz;

import dto.EvaluacionCursadaDTO;

public interface EvaluacionCursadaDAO {

	public boolean insert(EvaluacionCursadaDTO evaluacionCursadaDTO);

	public boolean delete(EvaluacionCursadaDTO evaluacionCursadaDTO);

	public boolean update(EvaluacionCursadaDTO evaluacionCursadaDTO);

}
