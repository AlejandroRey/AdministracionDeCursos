package dto;

import java.time.LocalDateTime;

public class ContactoDTO {
	
	private long idContacto;
	private long idAlumno;
	private long idAdministrativo;
	private long idCurso;
	private String descripcion;
	private LocalDateTime fechaContactar;
	private LocalDateTime fechaCreacion;
	private int estado;

	public ContactoDTO(long idAlumnoEvento, long idAlumno, long idUsuario, long idCurso, String descripcion, LocalDateTime fechaContactar,
			LocalDateTime fechaCreacion, int estado) {
		super();
		this.idContacto = idAlumnoEvento;
		this.idAlumno = idAlumno;
		this.idAdministrativo = idUsuario;
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.fechaContactar = fechaContactar;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public long getIdAlumnoEvento() {
		return idContacto;
	}

	public void setIdAlumnoEvento(long idAlumnoEvento) {
		this.idContacto = idAlumnoEvento;
	}

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public long getIdUsuario() {
		return idAdministrativo;
	}

	public void setIdUsuario(long idUsuario) {
		this.idAdministrativo = idUsuario;
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

	public LocalDateTime getFechaContactar() {
		return fechaContactar;
	}

	public void setFechaContactar(LocalDateTime fechaContactar) {
		this.fechaContactar = fechaContactar;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}	
}