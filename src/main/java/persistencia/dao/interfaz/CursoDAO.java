package persistencia.dao.interfaz;

import java.util.List;

import dto.CursoDTO;

public interface CursoDAO {

	public boolean insert(CursoDTO nuevoCurso);

	public boolean delete(CursoDTO curso_a_eliminar);

	public boolean update(CursoDTO curso_a_actualizar);

	public List<CursoDTO> readAll();
	
}
