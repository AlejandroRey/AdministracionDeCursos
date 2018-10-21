package dto;

import java.time.LocalDateTime;

public class SalaDisponibleDTO {
	
	private long idSala;
	private LocalDateTime dispDesde;
	private LocalDateTime dispHaasta;
	private String estado;
	
	public SalaDisponibleDTO(long idSala, LocalDateTime dispDesde, LocalDateTime dispHaasta, String estado) {
		super();
		this.idSala = idSala;
		this.dispDesde = dispDesde;
		this.dispHaasta = dispHaasta;
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
	 * @return the dispHaasta
	 */
	public LocalDateTime getDispHaasta() {
		return dispHaasta;
	}

	/**
	 * @param dispHaasta the dispHaasta to set
	 */
	public void setDispHaasta(LocalDateTime dispHaasta) {
		this.dispHaasta = dispHaasta;
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
		return "SalaDisponibleDTO [idSala: " + idSala + ", dispDesde: " + dispDesde + ", dispHaasta: " + dispHaasta
				+ ", estado: " + estado + "]";
	}

}
