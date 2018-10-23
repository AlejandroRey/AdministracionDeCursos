package dto;

public class AsistenciaDTO {
	
	private long idAlumno;
	private long idFechaCursadaClase;
	private boolean tipoAsistencia;
	private String comentario;
	
	public AsistenciaDTO(long idAlumno, long idFechaCursadaClase, boolean tipoAsistencia, String comentario) {
		super();
		this.idAlumno = idAlumno;
		this.idFechaCursadaClase = idFechaCursadaClase;
		this.tipoAsistencia = tipoAsistencia;
		this.comentario = comentario;
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
	 * @return the idFechaCursadaClase
	 */
	public long getIdFechaCursadaClase() {
		return idFechaCursadaClase;
	}

	/**
	 * @param idFechaCursadaClase the idFechaCursadaClase to set
	 */
	public void setIdFechaCursadaClase(long idFechaCursadaClase) {
		this.idFechaCursadaClase = idFechaCursadaClase;
	}

	/**
	 * @return the tipoAsistencia
	 */
	public boolean isTipoAsistencia() {
		return tipoAsistencia;
	}

	/**
	 * @param tipoAsistencia the tipoAsistencia to set
	 */
	public void setTipoAsistencia(boolean tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AsistenciaDTO [idAlumno=" + idAlumno + ", idFechaCursadaClase=" + idFechaCursadaClase
				+ ", tipoAsistencia=" + tipoAsistencia + ", comentario=" + comentario + "]";
	}
	
}
