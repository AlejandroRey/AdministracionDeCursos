package persistencia.dao.mysql;

import java.util.List;

import dto.SalaDisponibilidadDTO;
import persistencia.dao.interfaz.SalaDisponibilidadDAO;

public class SalaDisponibilidadDAOSQL implements SalaDisponibilidadDAO{

	private static final String readall = "SELECT * FROM diacursadaclase WHERE idCursada = ?";	
	
	@Override
	public List<SalaDisponibilidadDTO> readAll() {
		
	return null;	
		
		
	}

}
