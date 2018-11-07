package dto;

import java.time.LocalDate;

public class FeriadoDTO {
	
	private long idFeriado;
	private LocalDate feriado;
	
	public FeriadoDTO(long idFeriado, LocalDate feriado) {
		super();
		this.idFeriado = idFeriado;
		this.feriado = feriado;
	}

	/**
	 * @return the idFeriado
	 */
	public long getIdFeriado() {
		return idFeriado;
	}

	/**
	 * @param idFeriado the idFeriado to set
	 */
	public void setIdFeriado(long idFeriado) {
		this.idFeriado = idFeriado;
	}

	/**
	 * @return the feriado
	 */
	public LocalDate getFeriado() {
		return feriado;
	}

	/**
	 * @param feriado the feriado to set
	 */
	public void setFeriado(LocalDate feriado) {
		this.feriado = feriado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeriadoDTO [idFeriado=" + idFeriado + ", feriado=" + feriado + "]";
	}
	
}
