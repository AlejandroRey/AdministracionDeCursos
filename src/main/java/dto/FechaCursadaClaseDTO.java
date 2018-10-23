package dto;

import java.time.LocalDateTime;

public class FechaCursadaClaseDTO {
	
	private long idFechaCursadaClase;
	private long idCursada;
	private long idSala;
	LocalDateTime fechaInicio;
	LocalDateTime fechaFin;
	
	//idCursada, idSala, fechaInicio, fechaFin

	public FechaCursadaClaseDTO(long idFechaCursadaClase, long idCursada, long idSala, LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		super();
		this.idFechaCursadaClase = idFechaCursadaClase;
		this.idCursada = idCursada;
		this.idSala = idSala;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the idFechaCursadaClase
	 */
	public long getIdFechaCursadaClase() {
		return idFechaCursadaClase;
	}

	/**
	 * @param idFechaCursadaClase the idFechaCursadaClase to set
	 */
	public void setIdFechaCursadaClase(long idFechaCursadaClase) {
		this.idFechaCursadaClase = idFechaCursadaClase;
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
	 * @return the fechaInicio
	 */
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FechaCursadaClaseDTO [idFechaCursadaClase: " + idFechaCursadaClase + ", idCursada: " + idCursada
				+ ", idSala: " + idSala + ", fechaInicio: " + fechaInicio + ", fechaFin: " + fechaFin + "]";
	}
	
}
