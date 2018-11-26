package dto;

import java.time.LocalDate;

public class EvaluacionDTO {
	
	private long idEvaluacion;
	private long idCursada;
	private long idEvaluacionTipo;
	private String descripcion;
	private String tipoParcial;
	private LocalDate fecha;
	
	public EvaluacionDTO(long idEvaluacion, long idCursada, long idEvaluacionTipo, String descripcion,
			String tipoParcial, LocalDate fecha) {
		super();
		this.idEvaluacion = idEvaluacion;
		this.idCursada = idCursada;
		this.idEvaluacionTipo = idEvaluacionTipo;
		this.descripcion = descripcion;
		this.tipoParcial = tipoParcial;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipoParcial
	 */
	public String getTipoParcial() {
		return tipoParcial;
	}

	/**
	 * @param tipoParcial the tipoParcial to set
	 */
	public void setTipoParcial(String tipoParcial) {
		this.tipoParcial = tipoParcial;
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
		return "EvaluacionDTO [idEvaluacion: " + idEvaluacion + ", idCursada: " + idCursada + ", idEvaluacionTipo: "
				+ idEvaluacionTipo + ", descripcion: " + descripcion + ", tipoParcial: " + tipoParcial + ", fecha: "
				+ fecha + "]";
	}
}
