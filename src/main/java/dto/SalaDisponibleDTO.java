package dto;

import java.time.LocalDateTime;

public class SalaDisponibleDTO {
	
	private long idSala;
	private LocalDateTime dispDesde;
	private LocalDateTime dispHasta;
	private String estado;
	
	public SalaDisponibleDTO(long idSala, LocalDateTime dispDesde, LocalDateTime dispHasta, String estado) {
		super();
		this.idSala = idSala;
		this.dispDesde = dispDesde;
		this.dispHasta = dispHasta;
		this.estado = estado;
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
		return "SalaDisponibleDTO [idSala=" + idSala + ", dispDesde=" + dispDesde + ", dispHasta=" + dispHasta
				+ ", estado=" + estado + "]";
	}
	
}
