package dto;

import java.time.LocalDate;

public class EvaluacionCursadaDTO {
	
	private long idEvaluacion;
	private long idCursada;
	private long idEvaluacionTipo;
	private String tema;
	private LocalDate fecha;
	
	public EvaluacionCursadaDTO(long idEvaluacion, long idCursada, long idEvaluacionTipo, String tema,
			LocalDate fecha) {
		super();
		this.idEvaluacion = idEvaluacion;
		this.idCursada = idCursada;
		this.idEvaluacionTipo = idEvaluacionTipo;
		this.tema = tema;
		this.fecha = fecha;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EvaluacionCursadaDTO [idEvaluacion=" + idEvaluacion + ", idCursada=" + idCursada + ", idEvaluacionTipo="
				+ idEvaluacionTipo + ", tema=" + tema + ", fecha=" + fecha + "]";
	}	

}
