package dto;

import java.time.LocalDateTime;

public class InscriptoDTO {
	
	private long idAlumno;
	private long idCursada;
	private LocalDateTime fecha;
	private boolean estado;
	
	public InscriptoDTO(long idAlumno, long idCursada, LocalDateTime fecha, boolean estado) {
		super();
		this.idAlumno = idAlumno;
		this.idCursada = idCursada;
		this.fecha = fecha;
		this.estado = estado;
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
	 * @return the idCursada
	 */
	public long getIdCursada() {
		return idCursada;
	}

	/**
	 * @param idCursada the idCursada to set
	 */
	public void setIdCursada(long idCursada) {
		this.idCursada = idCursada;
	}

	/**
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InscriptoDTO [idAlumno=" + idAlumno + ", idCursada=" + idCursada + ", fecha=" + fecha + ", estado="
				+ estado + "]";
	}

}
