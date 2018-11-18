package persistencia.dao.interfaz;

import java.util.List;

import dto.EmpresaDTO;

public interface EmpresaDAO {
	
	public boolean insert(EmpresaDTO nuevaEmpresa);

	public boolean delete(EmpresaDTO empresa_a_eliminar);

	public boolean update(EmpresaDTO empresa_a_actualizar);

	public List<EmpresaDTO> readAll();

}
