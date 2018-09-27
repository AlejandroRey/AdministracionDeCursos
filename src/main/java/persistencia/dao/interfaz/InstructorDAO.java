package persistencia.dao.interfaz;

import java.util.List;

import dto.InstructorDTO;

public interface InstructorDAO {
	
	public boolean insert(InstructorDTO instructorParaAgregar);

	public boolean delete(InstructorDTO instructorParaEliminar);

	public boolean update(InstructorDTO instructorParaActualizar);

	public List<InstructorDTO> readAll();

}
