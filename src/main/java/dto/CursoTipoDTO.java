package dto;

public class CursoTipoDTO {

	private long idCursoTipo;
	private String nombre;
	
	public CursoTipoDTO(long idCursoTipo, String nombre) {
		super();
		this.idCursoTipo = idCursoTipo;
		this.nombre = nombre;
	}
	
	public long getIdCursoTipo() {
		return idCursoTipo;
	}
	public void setIdCursoTipo(long idCursoTipo) {
		this.idCursoTipo = idCursoTipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
