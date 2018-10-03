package dto;

import java.sql.Date;

public class EventoDTO {
	
	private long idAlumnoEvento;
	private long idAlumno;
	private long idAdministrativo;
	private String cursosDeIntereses;
	private String descripcion;
	private Date fechaContactar;
	private Date fechaCreacion;
	private String estado;
	
	public EventoDTO(long idAlumnoEvento, long idAlumno, long idAdministrativo, String cursosDeIntereses,
			String descripcion, Date fechaContactar) {
		super();
		this.idAlumnoEvento = idAlumnoEvento;
		this.idAlumno = idAlumno;
		this.idAdministrativo = idAdministrativo;
		this.cursosDeIntereses = cursosDeIntereses;
		this.descripcion = descripcion;
		this.fechaContactar = fechaContactar;
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

	public long getIdAdministrativo() {
		return idAdministrativo;
	}

	public void setIdAdministrativo(long idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}

	public String getCursosDeIntereses() {
		return cursosDeIntereses;
	}

	public void setCursosDeIntereses(String cursosDeIntereses) {
		this.cursosDeIntereses = cursosDeIntereses;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaContactar() {
		return fechaContactar;
	}

	public void setFechaContactar(Date fechaContactar) {
		this.fechaContactar = fechaContactar;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
