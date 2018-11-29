package dto;

import java.time.LocalDateTime;

public class SalaDisponibleDTO {
	
	private long idFechaCursadaClase;
	private long idSala;
	private int estadoSala;
	private LocalDateTime dispDesde;
	private LocalDateTime dispHasta;
	private String estado;
	
	public SalaDisponibleDTO(long idFechaCursadaClase, long idSala, int estadoSala, LocalDateTime dispDesde,
			LocalDateTime dispHasta, String estado) {
		super();
		this.idFechaCursadaClase = idFechaCursadaClase;
		this.idSala = idSala;
		this.estadoSala = estadoSala;
		this.dispDesde = dispDesde;
		this.dispHasta = dispHasta;
		this.estado = estado;
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
	 * @return the estadoSala
	 */
	public int getEstadoSala() {
		return estadoSala;
	}

	/**
	 * @param estadoSala the estadoSala to set
	 */
	public void setEstadoSala(int estadoSala) {
		this.estadoSala = estadoSala;
	}

	/**
	 * @return the dispDesde
	 */
	public LocalDateTime getDispDesde() {
		return dispDesde;
	}

	/**
	 * @param dispDesde the dispDesde to set
	 */
	public void setDispDesde(LocalDateTime dispDesde) {
		this.dispDesde = dispDesde;
	}

	/**
	 * @return the dispHasta
	 */
	public LocalDateTime getDispHasta() {
		return dispHasta;
	}

	/**
	 * @param dispHasta the dispHasta to set
	 */
	public void setDispHasta(LocalDateTime dispHasta) {
		this.dispHasta = dispHasta;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalaDisponibleDTO [idFechaCursadaClase: " + idFechaCursadaClase + ", idSala: " + idSala + ", estadoSala: "
				+ estadoSala + ", dispDesde: " + dispDesde + ", dispHasta: " + dispHasta + ", estado: " + estado + "]";
	}	
	
}
