package dto;

import java.time.LocalDateTime;

public class ContactoDTO {
	private long idContacto;
	private long idCurso;
	private long idAlumno;
	private String nombre;
	private String	apellido;
	private String descripcion;
	private String telefono;
	private String email;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaAccion;
	
	public ContactoDTO(long idContacto, long idCurso, long idAlumno, String nombre,
			String apellido, String descripcion, String telefono,
			String email, LocalDateTime fechaCreacion, LocalDateTime fechaAccion) {
		super();
		this.idContacto = idContacto;
		this.idCurso = idCurso;
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.fechaAccion = fechaAccion;
	}

	public long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaAccion() {
		return fechaAccion;
	}

	public void setFechaAccion(LocalDateTime fechaAccion) {
		this.fechaAccion = fechaAccion;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactoDTO [idContacto: " + idContacto + ", idCurso: " + idCurso + ", idAlumno: " + idAlumno + 
				", nombre: " + nombre + ", apellido: " + apellido + ", descripcion: " + descripcion + ", telefono: " + 
				telefono + ", email " + email + ", fechaCreacion: " + fechaCreacion + ", fechaAccion: " + fechaCreacion + "]";
	}

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}	
}