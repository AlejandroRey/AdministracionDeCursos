package persistencia.dao.interfaz;

import java.util.List;

import dto.CursadaDTO;
import dto.DiaCursadaClaseDTO;

public interface DiaCursadaClaseDAO {
	
	public boolean insert(DiaCursadaClaseDTO diaCursadaClaseDTO);

	public boolean delete(CursadaDTO diaCursadaClaseDTO);

	public boolean update(DiaCursadaClaseDTO diaCursadaClaseDTO);
	
	public List<DiaCursadaClaseDTO> readAll(CursadaDTO cursadaDTO);

}
