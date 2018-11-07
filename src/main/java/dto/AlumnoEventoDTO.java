package dto;

import java.sql.Date;
import java.sql.Timestamp;

public class AlumnoEventoDTO {
	
	private long idAlumnoEvento;
	private long idAlumno;
	private long idUsuario;
	private long idCurso;
	private String descripcion;
	private Date fechaContactar;
	private Timestamp fechaCreacion;
	private boolean estado;

	public AlumnoEventoDTO(long idAlumnoEvento, long idAlumno, long idUsuario, long idCurso, String descripcion, Date fechaContactar,
			Timestamp fechaCreacion, boolean estado) {
		super();
		this.idAlumnoEvento = idAlumnoEvento;
		this.idAlumno = idAlumno;
		this.idUsuario = idUsuario;
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

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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

	public Date getFechaContactar() {
		return fechaContactar;
	}

	public void setFechaContactar(Date fechaContactar) {
		this.fechaContactar = fechaContactar;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}	
}