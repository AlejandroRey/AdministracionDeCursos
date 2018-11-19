package persistencia.dao.interfaz;

import java.util.List;

import dto.CategoriaDTO;

public interface CategoriaDAO {

	public List<CategoriaDTO> readAll();

}
