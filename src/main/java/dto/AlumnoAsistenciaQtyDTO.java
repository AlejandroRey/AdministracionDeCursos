package dto;

public class AlumnoAsistenciaQtyDTO {

	private long idAlumno;
	private int presente;
	private int ausente;
	
	public AlumnoAsistenciaQtyDTO(long idAlumno, int presente, int ausente) {
		super();
		this.idAlumno = idAlumno;
		this.presente = presente;
		this.ausente = ausente;
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
	 * @return the presente
	 */
	public int getPresente() {
		return presente;
	}

	/**
	 * @param presente the presente to set
	 */
	public void setPresente(int presente) {
		this.presente = presente;
	}

	/**
	 * @return the ausente
	 */
	public int getAusente() {
		return ausente;
	}

	/**
	 * @param ausente the ausente to set
	 */
	public void setAusente(int ausente) {
		this.ausente = ausente;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlumnoAsistenciaQtyDTO [idAlumno: " + idAlumno + ", presente: " + presente + ", ausente: " + ausente + "]";
	}
	
}
