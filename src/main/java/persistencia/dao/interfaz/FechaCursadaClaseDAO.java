package persistencia.dao.interfaz;

import java.util.List;

import dto.CursadaDTO;
import dto.FechaCursadaClaseDTO;

public interface FechaCursadaClaseDAO {
	
	public boolean insert(FechaCursadaClaseDTO fechaCursadaClaseDTO);

	public boolean delete(FechaCursadaClaseDTO fechaCursadaClaseDTO);

	public boolean update(FechaCursadaClaseDTO fechaCursadaClaseDTO);

	public List<FechaCursadaClaseDTO> readAll(CursadaDTO cursadaDTO);

}
