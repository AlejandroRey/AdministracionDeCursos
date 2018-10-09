package persistencia.dao.interfaz;

import java.util.List;

import dto.InscriptoDTO;

public interface InscriptoDAO {

	public boolean insert(InscriptoDTO nuevoAlumnoInscrito);

	public boolean delete(InscriptoDTO alumnoInscripto_a_eliminar);

	public boolean update(InscriptoDTO alumnoInscripto_a_actualizar);

	public List<InscriptoDTO> readAll();
	
}
