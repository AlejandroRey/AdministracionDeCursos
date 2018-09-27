package modelo;

import java.util.List;

import dto.InstructorDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.InstructorDAO;

public class GestionCursos {

	private InstructorDAO instructor;

	public GestionCursos(DAOAbstractFactory metodo_persistencia) {
		this.instructor = metodo_persistencia.createInstructorDAO();
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

}
