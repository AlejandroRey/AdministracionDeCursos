package dto;

public class EvaluacionTipoDTO {

	private long idEvaluacionTipo;
	private String nombre;
	
	public EvaluacionTipoDTO(long idEvaluacionTipo, String nombre) {
		super();
		this.idEvaluacionTipo = idEvaluacionTipo;
		this.nombre = nombre;
	}

	/**
	 * @return the idEvaluacionTipo
	 */
	public long getIdEvaluacionTipo() {
		return idEvaluacionTipo;
	}

	/**
	 * @param idEvaluacionTipo the idEvaluacionTipo to set
	 */
	public void setIdEvaluacionTipo(long idEvaluacionTipo) {
		this.idEvaluacionTipo = idEvaluacionTipo;
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
	public boolean equals(Object evaluacionTipoDTO) {
	    return this.idEvaluacionTipo == ((EvaluacionTipoDTO) evaluacionTipoDTO).idEvaluacionTipo;
	}
	
}
