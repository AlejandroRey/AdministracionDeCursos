package dto;

public class NotaTipoDTO {

	private long idNotaTipo;
	private String nombre;
	
	public NotaTipoDTO(long idNotaTipo, String nombre) {
		super();
		this.idNotaTipo = idNotaTipo;
		this.nombre = nombre;
	}
	
	public long getIdNotaTipo() {
		return idNotaTipo;
	}
	public void setIdNotaTipo(long idNotaTipo) {
		this.idNotaTipo = idNotaTipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
