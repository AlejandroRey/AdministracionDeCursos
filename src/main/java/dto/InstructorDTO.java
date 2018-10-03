package dto;

public class InstructorDTO {

	private long idInstructor;
	private long idCursoTipo;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	public InstructorDTO(long idInstructor, long idCursoTipo, String nombre, String apellido, String telefono,
			String email) {
		super();
		this.idInstructor = idInstructor;
		this.idCursoTipo = idCursoTipo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * @return the idInstructor
	 */
	public long getIdInstructor() {
		return idInstructor;
	}

	/**
	 * @param idInstructor the idInstructor to set
	 */
	public void setIdInstructor(long idInstructor) {
		this.idInstructor = idInstructor;
	}

	/**
	 * @return the idCursoTipo
	 */
	public long getIdCursoTipo() {
		return idCursoTipo;
	}

	/**
	 * @param idCursoTipo the idCursoTipo to set
	 */
	public void setIdCursoTipo(long idCursoTipo) {
		this.idCursoTipo = idCursoTipo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InstructorDTO [idInstructor= " + idInstructor + ", idCursoTipo= " + idCursoTipo + ", nombre= " + nombre
				+ ", apellido= " + apellido + ", telefono= " + telefono + ", email= " + email + "]";
	}	
	
}
