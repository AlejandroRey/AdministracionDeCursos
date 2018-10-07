package dto;

import java.sql.Timestamp;

public class AlumnoEventoDTO {
	
	private long idAlumnoEvento;
	private long idAlumno;
	private long idUsuaio;
	private long idCurso;
	private String descripcion;
	private Timestamp fechaContactar;
	private Timestamp fechaCreacion;
	private boolean estado;
	
	public AlumnoEventoDTO(long idAlumnoEvento, long idAlumno, long idUsuaio, long idCurso, String descripcion,
			Timestamp fechaContactar, Timestamp fechaCreacion, boolean estado) {
		super();
		this.idAlumnoEvento = idAlumnoEvento;
		this.idAlumno = idAlumno;
		this.idUsuaio = idUsuaio;
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.fechaContactar = fechaContactar;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}
	
	public long getIdAlumnoEvento() {
		return idAlumnoEvento;
	}
	public void setIdAlumnoEvento(long idAlumnoEvento) {
		this.idAlumnoEvento = idAlumnoEvento;
	}
	public long getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}
	public long getIdUsuaio() {
		return idUsuaio;
	}
	public void setIdUsuaio(long idUsuaio) {
		this.idUsuaio = idUsuaio;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Timestamp getFechaContactar() {
		return fechaContactar;
	}
	public void setFechaContactar(Timestamp fechaContactar) {
		this.fechaContactar = fechaContactar;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
