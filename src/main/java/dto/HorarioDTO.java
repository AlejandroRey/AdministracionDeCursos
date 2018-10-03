package dto;

import java.sql.Timestamp;

public class HorarioDTO {

	private long idHorario;
	private long idCursada;
	private Timestamp fechaHoraInicio;
	private Timestamp fechaHoraFin;
	
	public HorarioDTO(long idHorario, long idCursada, Timestamp fechaHoraInicio, Timestamp fechaHoraFin) {
		super();
		this.idHorario = idHorario;
		this.idCursada = idCursada;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
	}
	
	public long getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}
	public long getIdCursada() {
		return idCursada;
	}
	public void setIdCursada(long idCursada) {
		this.idCursada = idCursada;
	}
	public Timestamp getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	public Timestamp getFechaHoraFin() {
		return fechaHoraFin;
	}
	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	
}
