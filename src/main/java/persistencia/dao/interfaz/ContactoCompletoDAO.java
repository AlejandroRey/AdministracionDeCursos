package persistencia.dao.interfaz;

import java.util.List;

import dto.ContactoCompletoDTO;

public interface ContactoCompletoDAO {

	public List<ContactoCompletoDTO> readAll();
}
