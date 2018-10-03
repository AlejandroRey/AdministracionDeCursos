package dto;

public class SalaDTO {

	private long idSala;
	private String nombre;
	private String capacidad;
	
	public SalaDTO(long idSala, String nombre, String capacidad) {
		super();
		this.idSala = idSala;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	public long getIdSala() {
		return idSala;
	}
	public void setIdSala(long idSala) {
		this.idSala = idSala;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	
}
