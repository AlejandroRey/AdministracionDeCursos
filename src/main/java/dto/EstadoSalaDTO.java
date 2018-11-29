package dto;

public enum EstadoSalaDTO {

	LIBRE(0, "Libre"), 
	OCUPADA(1, "Ocupada"), 
	PRIORIDAD(2, "Prioridad"), 
	CONDICIONAL(3, "Condicional");

	private int idEstadoSala;
	private String estadoSala;

	private EstadoSalaDTO(int idEstadoSala, String estadoSala) {
		this.idEstadoSala = idEstadoSala;
		this.estadoSala = estadoSala;
	}

	/**
	 * @return the idEstadoSala
	 */
	public int getIdEstadoSala() {
		return idEstadoSala;
	}

	/**
	 * @return the estadoSala
	 */
	public String getEstadoSala() {
		return estadoSala;
	}

}
