package dto;

public class NotaDTO {
	
	private long idAlumno;
	private long idEvaluacion;
	private String nota;
	
	public NotaDTO(long idAlumno, long idEvaluacion, String nota) {
		super();
		this.idAlumno = idAlumno;
		this.idEvaluacion = idEvaluacion;
		this.nota = nota;
	}

	/**
	 * @return the idAlumno
	 */
	public long getIdAlumno() {
		return idAlumno;
	}

	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	/**
	 * @return the idEvaluacion
	 */
	public long getIdEvaluacion() {
		return idEvaluacion;
	}

	/**
	 * @param idEvaluacion the idEvaluacion to set
	 */
	public void setIdEvaluacion(long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	/**
	 * @return the nota
	 */
	public String getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(String nota) {
		this.nota = nota;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NotaDTO [idAlumno=" + idAlumno + ", idEvaluacion=" + idEvaluacion + ", nota=" + nota + "]";
	}

}
