package dto;

import java.time.LocalDateTime;

public class CursadaCompletaDTO {
	
	private long idCursada;
	private long idEmpresa;
	private long idCurso;
	private long idEstadoCurso;
	private LocalDateTime fechaInicioInscripcion;
	private LocalDateTime fechaFinInscripcion;
	private String vacantes;
	private LocalDateTime fechaInicioCursada;
	private int diasDeClase;
	private String empresa;
	private String  curso;
	private String estadoCurso;
	
	public CursadaCompletaDTO(long idCursada, long idEmpresa, long idCurso, long idEstadoCurso,
			LocalDateTime fechaInicioInscripcion, LocalDateTime fechaFinInscripcion, String vacantes,
			LocalDateTime fechaInicioCursada, int diasDeClase, String empresa, String curso, String estadoCurso) {
		super();
		this.idCursada = idCursada;
		this.idEmpresa = idEmpresa;
		this.idCurso = idCurso;
		this.idEstadoCurso = idEstadoCurso;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
		this.vacantes = vacantes;
		this.fechaInicioCursada = fechaInicioCursada;
		this.diasDeClase = diasDeClase;
		this.empresa = empresa;
		this.curso = curso;
		this.estadoCurso = estadoCurso;
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
	 * @return the fechaInicioInscripcion
	 */
	public LocalDateTime getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	/**
	 * @param fechaInicioInscripcion the fechaInicioInscripcion to set
	 */
	public void setFechaInicioInscripcion(LocalDateTime fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	/**
	 * @return the fechaFinInscripcion
	 */
	public LocalDateTime getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}

	/**
	 * @param fechaFinInscripcion the fechaFinInscripcion to set
	 */
	public void setFechaFinInscripcion(LocalDateTime fechaFinInscripcion) {
		this.fechaFinInscripcion = fechaFinInscripcion;
	}

	/**
	 * @return the vacantes
	 */
	public String getVacantes() {
		return vacantes;
	}

	/**
	 * @param vacantes the vacantes to set
	 */
	public void setVacantes(String vacantes) {
		this.vacantes = vacantes;
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

	/**
	 * @return the diasDeClase
	 */
	public int getDiasDeClase() {
		return diasDeClase;
	}

	/**
	 * @param diasDeClase the diasDeClase to set
	 */
	public void setDiasDeClase(int diasDeClase) {
		this.diasDeClase = diasDeClase;
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
	 * @return the estadoCurso
	 */
	public String getEstadoCurso() {
		return estadoCurso;
	}

	/**
	 * @param estadoCurso the estadoCurso to set
	 */
	public void setEstadoCurso(String estadoCurso) {
		this.estadoCurso = estadoCurso;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CursadaCompletaDTO [idCursada: " + idCursada + ", idEmpresa: " + idEmpresa + ", idCurso: " + idCurso
				+ ", idEstadoCurso: " + idEstadoCurso + ", fechaInicioInscripcion: " + fechaInicioInscripcion
				+ ", fechaFinInscripcion: " + fechaFinInscripcion + ", vacantes: " + vacantes + ", fechaInicioCursada: "
				+ fechaInicioCursada + ", diasDeClase: " + diasDeClase + ", empresa: " + empresa + ", curso: " + curso
				+ ", estadoCurso: " + estadoCurso + "]";
	}
	
}
