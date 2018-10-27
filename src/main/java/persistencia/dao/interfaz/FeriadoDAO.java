package persistencia.dao.interfaz;

import java.util.List;

import dto.FeriadoDTO;

public interface FeriadoDAO {
	
	public List<FeriadoDTO> readAll(int year);

}
