package persistencia.dao.interfaz;

import java.util.List;

import dto.ContactoDTO;

public interface ContactoDAO {
	
	public boolean insert(ContactoDTO nuevoContacto);

	public boolean delete(ContactoDTO contacto_a_eliminar);

	public boolean update(ContactoDTO contacto_a_actualizar);

	public List<ContactoDTO> readAll();
}
