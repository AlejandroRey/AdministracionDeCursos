package persistencia.dao.interfaz;

import java.util.List;

import dto.EstadoDeCursoDTO;

public interface EstadoDeCursoDAO {
	
	public boolean insert(EstadoDeCursoDTO nuevoEstadoDeCurso);

	public boolean delete(EstadoDeCursoDTO estadoDeCurso_a_eliminar);

	public boolean update(EstadoDeCursoDTO estadoDeCurso_a_actualizar);

	public List<EstadoDeCursoDTO> readAll();

}
