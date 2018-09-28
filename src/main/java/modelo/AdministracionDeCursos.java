package modelo;

import java.util.List;

import dto.ClienteDTO;
import dto.InstructorDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.InstructorDAO;
import persistencia.dao.interfaz.ClienteDAO;

public class AdministracionDeCursos {

	private InstructorDAO instructor;
	private ClienteDAO cliente;

	public AdministracionDeCursos(DAOAbstractFactory metodo_persistencia) {
		this.instructor = metodo_persistencia.createInstructorDAO();
		this.cliente = metodo_persistencia.createClienteDAO();
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
	 *                         Cliente
	 * ****************************************************************
	 */
	public void agregarInstructor(ClienteDTO nuevoCliente) {
		this.cliente.insert(nuevoCliente);
	}

	public void borrarInstructor(ClienteDTO cliente_a_eliminar) {
		this.cliente.delete(cliente_a_eliminar);
	}
	
	public void actualizarInstructor(ClienteDTO cliente_a_actualizar) {
		this.cliente.update(cliente_a_actualizar);
	}
	
	public List<ClienteDTO> obtenerClientes() {
		return this.cliente.readAll();
	}

}
