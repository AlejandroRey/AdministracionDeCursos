package dto;

import java.time.LocalDateTime;

public class SalaDisponibilidadDTO {
	
	private Long idSala;
	private Long idCursada;
	private Long idCurso;
	private String sala;
	private String curso;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	
	public SalaDisponibilidadDTO(Long idSala, Long idCursada, Long idCurso, String sala, String curso, LocalDateTime horaInicio, LocalDateTime horaFin) {
		super();
		this.idSala = idSala;
		this.idCursada = idCursada;
		this.idCurso = idCurso;
		this.sala = sala;
		this.curso = curso;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	/**
	 * @return the idSala
	 */
	public Long getIdSala() {
		return idSala;
	}

	/**
	 * @param idSala the idSala to set
	 */
	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	/**
	 * @return the idCursada
	 */
	public Long getIdCursada() {
		return idCursada;
	}

	/**
	 * @param idCursada the idCursada to set
	 */
	public void setIdCursada(Long idCursada) {
		this.idCursada = idCursada;
	}

	/**
	 * @return the idCurso
	 */
	public Long getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the sala
	 */
	public String getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(String sala) {
		this.sala = sala;
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
	 * @return the horaInicio
	 */
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFin
	 */
	public LocalDateTime getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
