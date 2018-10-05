package modelo;

import java.util.List;

import dto.CursoTipoDTO;
import dto.InstructorDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.InstructorDAO;
import persistencia.dao.interfaz.CursoTipoDAO;

public class AdministracionDeCursos {

	private InstructorDAO instructor;
	private CursoTipoDAO cursoTipo;

	public AdministracionDeCursos(DAOAbstractFactory metodo_persistencia) {
		this.instructor = metodo_persistencia.createInstructorDAO();
		this.cursoTipo = metodo_persistencia.createCursoTipoDAO();
	}
	
	/* ****************************************************************
	 *                         Instructor
	 * ****************************************************************
	 */
	public void agregarInstructor(InstructorDTO nuevoInstructor) {
		this.instructor.insert(nuevoInstructor);
	}

	public void borrarInstructor(InstructorDTO instructor_a_eliminar) {
		this.instructor.delete(instructor_a_eliminar);
	}
	
	public void actualizarInstructor(InstructorDTO instructor_a_actualizar) {
		this.instructor.update(instructor_a_actualizar);
	}
	
	public List<InstructorDTO> obtenerInstructores() {
		return this.instructor.readAll();
	}
	
	/* ****************************************************************
	 *                         CursoTipo
	 * ****************************************************************
	 */
	public List<CursoTipoDTO> obtenerCursoTipos() {
		return this.cursoTipo.readAll();
	}
	
}
