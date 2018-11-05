package dto;

public class CursoTipoDTO {
	
	private long idCursoTipo;
	private String nombre;
	
	public CursoTipoDTO(long idCursoTipo, String nombre) {
		super();
		this.idCursoTipo = idCursoTipo;
		this.nombre = nombre;
	}

	/**
	 * @return the idCursoTipo
	 */
	public long getIdCursoTipo() {
		return idCursoTipo;
	}

	/**
	 * @param idCursoTipo the idCursoTipo to set
	 */
	public void setIdCursoTipo(long idCursoTipo) {
		this.idCursoTipo = idCursoTipo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
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
	public boolean equals(Object cursoTipo) {
	    return this.idCursoTipo == ((CursoTipoDTO) cursoTipo).idCursoTipo;
	}
}
