package persistencia.dao.interfaz;

import java.util.List;

import dto.FechaCursadaClaseDTO;
import dto.SalaDTO;
import dto.SalaDisponibleDTO;

public interface SalaDisponibleDAO {
	
	public List<SalaDisponibleDTO> readAll(FechaCursadaClaseDTO fechaCursadaDTO, SalaDTO salaDTO);

}
