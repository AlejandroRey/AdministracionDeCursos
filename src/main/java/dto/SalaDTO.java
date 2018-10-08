package dto;

public class SalaDTO {
	private long idSala;
	private String nombre;
	private int cantidadAlumnos;
	private int cantidadPc;
	private String descripcion;

	public SalaDTO(long idSala, String nombre, int cantidadAlumnos, int cantidadPc, String descripcion) {
		super();
		this.idSala = idSala;
		this.nombre = nombre;
		this.cantidadAlumnos = cantidadAlumnos;
		this.cantidadPc = cantidadPc;
		this.descripcion = descripcion;
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

	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}
	
	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public int getCantidadPc() {
		return cantidadPc;
	}

	public void setCantidadPc(int cantidadPc) {
		this.cantidadPc = cantidadPc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
