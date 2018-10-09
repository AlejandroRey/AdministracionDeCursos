package dto;

import java.time.LocalDateTime;

public class CursadaDTO {
	private long idCursada;
	private long idEmpresa;
	private long idCurso;
	private long idSala;
	private long idEstadoCurso;
	private LocalDateTime fechaInicioInscripcion;
	private LocalDateTime fechaFinInscripcion;
	private String vacantes;
	
	public CursadaDTO(long idCursada, long idEmpresa, long idCurso, long idSala, long idEstadoCurso,
			LocalDateTime fechaInicioInscripcion, LocalDateTime fechaFinInscripcion, String vacantes) {
		super();
		this.idCursada = idCursada;
		this.idEmpresa = idEmpresa;
		this.idCurso = idCurso;
		this.idSala = idSala;
		this.idEstadoCurso = idEstadoCurso;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
		this.vacantes = vacantes;
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
	 * @return the idSala
	 */
	public long getIdSala() {
		return idSala;
	}

	/**
	 * @param idSala the idSala to set
	 */
	public void setIdSala(long idSala) {
		this.idSala = idSala;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CursadaDTO [idCursada: " + idCursada + ", idEmpresa: " + idEmpresa + ", idCurso: " + idCurso + ", idSala: "
				+ idSala + ", idEstadoCurso: " + idEstadoCurso + ", fechaInicioInscripcion: " + fechaInicioInscripcion
				+ ", fechaFinInscripcion: " + fechaFinInscripcion + ", vacantes: " + vacantes + "]";
	}
	
}
