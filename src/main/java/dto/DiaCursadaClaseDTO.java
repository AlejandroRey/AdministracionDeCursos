package dto;

import java.time.LocalTime;

public class DiaCursadaClaseDTO {
	
	private long idCursada;
	private int idDia;
	private String nombreDia;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private long idSala;
	
	public DiaCursadaClaseDTO(long idCursada, int idDia, String nombreDia, LocalTime horaInicio, LocalTime horaFin,
			long idSala) {
		super();
		this.idCursada = idCursada;
		this.idDia = idDia;
		this.nombreDia = nombreDia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idSala = idSala;
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
	 * @return the idDia
	 */
	public int getIdDia() {
		return idDia;
	}

	/**
	 * @param idDia the idDia to set
	 */
	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}

	/**
	 * @return the nombreDia
	 */
	public String getNombreDia() {
		return nombreDia;
	}

	/**
	 * @param nombreDia the nombreDia to set
	 */
	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}

	/**
	 * @return the horaInicio
	 */
	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFin
	 */
	public LocalTime getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DiaCursadaClaseDTO [idCursada: " + idCursada + ", idDia: " + idDia + ", nombreDia: " + nombreDia
				+ ", horaInicio: " + horaInicio + ", horaFin: " + horaFin + ", idSala: " + idSala + "]";
	}	
	
}
