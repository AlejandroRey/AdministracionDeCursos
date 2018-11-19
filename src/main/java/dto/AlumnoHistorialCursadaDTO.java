package dto;

import java.time.LocalDateTime;

public class AlumnoHistorialCursadaDTO {

	private long idCurso;
	private long idCursada;
	private long idAlumno;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String curso;
	private String tema;
	private LocalDateTime fechaInicioCursada;
	
	public AlumnoHistorialCursadaDTO(long idCurso, long idCursada, long idAlumno, String nombre, String apellido,
			String telefono, String email, String curso, String tema, LocalDateTime fechaInicioCursada) {
		super();
		this.idCurso = idCurso;
		this.idCursada = idCursada;
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.curso = curso;
		this.tema = tema;
		this.fechaInicioCursada = fechaInicioCursada;
	}

	/**
	 * @return the idCurso
	 */
	public long getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the idCursada
	 */
	public long getIdCursada() {
		return idCursada;
	}

	/**
	 * @param idCursada the idCursada to set
	 */
	public void setIdCursada(long idCursada) {
		this.idCursada = idCursada;
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

	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * @return the fechaInicioCursada
	 */
	public LocalDateTime getFechaInicioCursada() {
		return fechaInicioCursada;
	}

	/**
	 * @param fechaInicioCursada the fechaInicioCursada to set
	 */
	public void setFechaInicioCursada(LocalDateTime fechaInicioCursada) {
		this.fechaInicioCursada = fechaInicioCursada;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlumnoHistorialCursadaDTO [idCurso: " + idCurso + ", idCursada: " + idCursada + ", idAlumno: " + idAlumno
				+ ", nombre: " + nombre + ", apellido: " + apellido + ", telefono: " + telefono + ", email: " + email
				+ ", curso: " + curso + ", tema: " + tema + ", fechaInicioCursada: " + fechaInicioCursada + "]";
	}
	
}
