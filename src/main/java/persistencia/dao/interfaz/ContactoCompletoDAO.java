package persistencia.dao.interfaz;

import java.util.List;

import dto.ContactoCompletoDTO;
import dto.CursoDTO;

public interface ContactoCompletoDAO {

	public List<ContactoCompletoDTO> readAll();
	
	public List<ContactoCompletoDTO> readAllInteresados(CursoDTO curso);
}
