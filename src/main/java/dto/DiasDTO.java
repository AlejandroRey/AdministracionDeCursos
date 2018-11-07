package dto;

public enum DiasDTO {
	
	LUNES(1, "Lunes"),
	MARTES(2, "Martes"),
	MIERCOLES(3, "Miércoles"),
	JUEVES(4, "Jueves"),
	VIERNES(5, "Viernes"),
	SABADO(6, "Sábado"),
	DOMINGO(7, "Domingo");
	
	private int numeroDia;
	private String nombreDia;
	
	private DiasDTO(int numeroDia, String nombreDia) {
	
		this.numeroDia = numeroDia;
		this.nombreDia = nombreDia;
	}

	/**
	 * @return the numeroDia
	 */
	public int getNumeroDia() {
		return numeroDia;
	}

	/**
	 * @return the dia
	 */
	public String getNombreDia() {
		return nombreDia;
	}

}