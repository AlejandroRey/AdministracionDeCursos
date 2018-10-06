package persistencia.dao.interfaz;

import java.util.List;

import dto.AlumnoDTO;

public interface AlumnoDAO {

	public boolean insert(AlumnoDTO nuevoAlumno);

	public boolean delete(AlumnoDTO alumno_a_eliminar);

	public boolean update(AlumnoDTO alumno_a_actualizar);

	public List<AlumnoDTO> readAll();

}
