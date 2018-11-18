package dto;

public class EstadoDeCursoDTO {
	private long idEstadoDeCurso;
	private String nombre;
	
	public EstadoDeCursoDTO(long idEstadoDeCurso, String nombre) {
		super();
		this.idEstadoDeCurso = idEstadoDeCurso;
		this.nombre = nombre;
	}
	
	public long getIdEstadoDeCurso() {
		return idEstadoDeCurso;
	}
	public void setIdEstadoDeCurso(long idEstadoDeCurso) {
		this.idEstadoDeCurso = idEstadoDeCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object estado) {
	    return this.idEstadoDeCurso == ((EstadoDeCursoDTO) estado).idEstadoDeCurso;
	}
	
}
