package persistencia.dao.interfaz;

import java.util.List;

import dto.SalaDisponibilidadDTO;


public interface SalaDisponibilidadDAO {

	public List<SalaDisponibilidadDTO> readAll();

}
