package dto;

import java.time.LocalDateTime;

public class ClaseDTO {
	
	private long idClase;
	private long idCursada;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private boolean esFeriado;
	
	public ClaseDTO(long idClase, long idCursada, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			boolean esFeriado) {
		super();
		this.idClase = idClase;
		this.idCursada = idCursada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.esFeriado = esFeriado;
	}

	/**
	 * @return the idClase
	 */
	public long getIdClase() {
		return idClase;
	}

	/**
	 * @param idClase the idClase to set
	 */
	public void setIdClase(long idClase) {
		this.idClase = idClase;
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

	/**
	 * @return the esFeriado
	 */
	public boolean isEsFeriado() {
		return esFeriado;
	}

	/**
	 * @param esFeriado the esFeriado to set
	 */
	public void setEsFeriado(boolean esFeriado) {
		this.esFeriado = esFeriado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClaseDTO [idClase=" + idClase + ", idCursada=" + idCursada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", esFeriado=" + esFeriado + "]";
	}
	
}
