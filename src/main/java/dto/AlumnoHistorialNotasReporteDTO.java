package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlumnoHistorialNotasReporteDTO {
	
	private long idAlumno;
	private long idEvaluacion;
	private long idCursada;
	private long idEvaluacionTipo;
	private long idEmpresa;
	private long idCurso;
	private long idEstadoCurso;
	private String curso;
	private String temaCurso;
	private String empresa;
	private String fechaInicioCursada;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String evaluacion;
	private String temaEvaluacion;
	private LocalDate fechaEvaluacion;
	private long nota;
	
	public AlumnoHistorialNotasReporteDTO(long idAlumno, long idEvaluacion, long idCursada, long idEvaluacionTipo,
			long idEmpresa, long idCurso, long idEstadoCurso, String curso, String temaCurso, String empresa,
			String fechaInicioCursada, String nombre, String apellido, String telefono, String email, String evaluacion,
			String temaEvaluacion, LocalDate fechaEvaluacion, long nota) {
		super();
		this.idAlumno = idAlumno;
		this.idEvaluacion = idEvaluacion;
		this.idCursada = idCursada;
		this.idEvaluacionTipo = idEvaluacionTipo;
		this.idEmpresa = idEmpresa;
		this.idCurso = idCurso;
		this.idEstadoCurso = idEstadoCurso;
		this.curso = curso;
		this.temaCurso = temaCurso;
		this.empresa = empresa;
		this.fechaInicioCursada = fechaInicioCursada;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.evaluacion = evaluacion;
		this.temaEvaluacion = temaEvaluacion;
		this.fechaEvaluacion = fechaEvaluacion;
		this.nota = nota;
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
	 * @return the idEvaluacion
	 */
	public long getIdEvaluacion() {
		return idEvaluacion;
	}

	/**
	 * @param idEvaluacion the idEvaluacion to set
	 */
	public void setIdEvaluacion(long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
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
	 * @return the idEvaluacionTipo
	 */
	public long getIdEvaluacionTipo() {
		return idEvaluacionTipo;
	}

	/**
	 * @param idEvaluacionTipo the idEvaluacionTipo to set
	 */
	public void setIdEvaluacionTipo(long idEvaluacionTipo) {
		this.idEvaluacionTipo = idEvaluacionTipo;
	}

	/**
	 * @return the idEmpresa
	 */
	public long getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
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
	 * @return the idEstadoCurso
	 */
	public long getIdEstadoCurso() {
		return idEstadoCurso;
	}

	/**
	 * @param idEstadoCurso the idEstadoCurso to set
	 */
	public void setIdEstadoCurso(long idEstadoCurso) {
		this.idEstadoCurso = idEstadoCurso;
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
	 * @return the temaCurso
	 */
	public String getTemaCurso() {
		return temaCurso;
	}

	/**
	 * @param temaCurso the temaCurso to set
	 */
	public void setTemaCurso(String temaCurso) {
		this.temaCurso = temaCurso;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the fechaInicioCursada
	 */
	public String getFechaInicioCursada() {
		return fechaInicioCursada;
	}

	/**
	 * @param fechaInicioCursada the fechaInicioCursada to set
	 */
	public void setFechaInicioCursada(String fechaInicioCursada) {
		this.fechaInicioCursada = fechaInicioCursada;
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
	 * @return the evaluacion
	 */
	public String getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @param evaluacion the evaluacion to set
	 */
	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	/**
	 * @return the temaEvaluacion
	 */
	public String getTemaEvaluacion() {
		return temaEvaluacion;
	}

	/**
	 * @param temaEvaluacion the temaEvaluacion to set
	 */
	public void setTemaEvaluacion(String temaEvaluacion) {
		this.temaEvaluacion = temaEvaluacion;
	}

	/**
	 * @return the fechaEvaluacion
	 */
	public LocalDate getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	/**
	 * @param fechaEvaluacion the fechaEvaluacion to set
	 */
	public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	/**
	 * @return the nota
	 */
	public long getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(long nota) {
		this.nota = nota;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlumnoHistorialNotasReporteDTO [idAlumno=" + idAlumno + ", idEvaluacion=" + idEvaluacion
				+ ", idCursada=" + idCursada + ", idEvaluacionTipo=" + idEvaluacionTipo + ", idEmpresa=" + idEmpresa
				+ ", idCurso=" + idCurso + ", idEstadoCurso=" + idEstadoCurso + ", curso=" + curso + ", temaCurso="
				+ temaCurso + ", empresa=" + empresa + ", fechaInicioCursada=" + fechaInicioCursada + ", nombre="
				+ nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", evaluacion="
				+ evaluacion + ", temaEvaluacion=" + temaEvaluacion + ", fechaEvaluacion=" + fechaEvaluacion + ", nota="
				+ nota + "]";
	}	
	
}
