package dto;

public class EstadoCursoDTO {

	private long idEstadoCurso;
	private String nombre;
	
	public EstadoCursoDTO(long idEstadoCurso, String nombre) {
		super();
		this.idEstadoCurso = idEstadoCurso;
		this.nombre = nombre;
	}
	
	public long getIdEstadoCurso() {
		return idEstadoCurso;
	}
	public void setIdEstadoCurso(long idEstadoCurso) {
		this.idEstadoCurso = idEstadoCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
