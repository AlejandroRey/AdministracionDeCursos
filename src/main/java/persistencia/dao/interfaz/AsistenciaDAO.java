package persistencia.dao.interfaz;

import java.util.List;

import dto.AsistenciaDTO;
import dto.FechaCursadaClaseDTO;

public interface AsistenciaDAO {
	
	public boolean insert(AsistenciaDTO asistenciaDTO);

	public boolean delete(AsistenciaDTO asistenciaDTO);

	public boolean update(AsistenciaDTO asistenciaDTO);
	
	public List<AsistenciaDTO> readAll(FechaCursadaClaseDTO fechaCursadaClaseDTO);
	
}
