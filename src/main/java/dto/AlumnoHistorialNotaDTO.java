package dto;

import java.time.LocalDate;

public class AlumnoHistorialNotaDTO {
	
	private long idAlumno;
	private long idEvaluacion;
	private long idCursada;
	private long idEvaluacionTipo;
	private String parcial;
	private String tema;
	private LocalDate fecha;
	private int nota;
	
	public AlumnoHistorialNotaDTO(long idAlumno, long idEvaluacion, long idCursada, long idEvaluacionTipo, String parcial,
			String tema, LocalDate fecha, int nota) {
		super();
		this.idAlumno = idAlumno;
		this.idEvaluacion = idEvaluacion;
		this.idCursada = idCursada;
		this.idEvaluacionTipo = idEvaluacionTipo;
		this.parcial = parcial;
		this.tema = tema;
		this.fecha = fecha;
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
	 * @return the parcial
	 */
	public String getParcial() {
		return parcial;
	}

	/**
	 * @param parcial the parcial to set
	 */
	public void setParcial(String parcial) {
		this.parcial = parcial;
	}

	/**
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlumnoHistorialNota [idAlumno: " + idAlumno + ", idEvaluacion: " + idEvaluacion + ", idCursada: "
				+ idCursada + ", idEvaluacionTipo: " + idEvaluacionTipo + ", parcial: " + parcial + ", tema: " + tema
				+ ", fecha: " + fecha + ", nota: " + nota + "]";
	}

}
