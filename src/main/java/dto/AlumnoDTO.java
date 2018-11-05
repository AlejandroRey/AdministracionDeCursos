package dto;

public class AlumnoDTO {
	
	private long idAlumno;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	public AlumnoDTO(long idAlumno, String nombre, String apellido, String telefono, String email) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * @return the idAlumno
	 */
	public long getIdAlumno() {
		return idAlumno;
	}

	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
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
		return "AlumnoDTO [idAlumno: " + idAlumno + ", nombre: " + nombre + ", apellido: " + apellido + ", telefono: "
				+ telefono + ", email: " + email + "]";
	}
	

}
