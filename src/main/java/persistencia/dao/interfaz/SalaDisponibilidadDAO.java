package persistencia.dao.interfaz;

import java.util.List;

import dto.SalaDTO;
import dto.SalaDisponibilidadDTO;


public interface SalaDisponibilidadDAO {

	public List<SalaDisponibilidadDTO> readAll();
	public List<SalaDisponibilidadDTO> readAll(SalaDTO sala);
}
