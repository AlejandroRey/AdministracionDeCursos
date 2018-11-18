package dto;

import java.time.LocalDateTime;

public class ContactoDTO {
	
	private long idContacto;
	private long idAlumno;
	private long idAdministrativo;
	private long idTarea;
	private long idCurso;
	private String descripcion;
	private LocalDateTime fechaContactar;
	private LocalDateTime fechaCreacion;
	private int estado;

	public ContactoDTO(long idContacto, long idAlumno, long idUsuario, long idCurso, String descripcion, LocalDateTime fechaContactar,
			LocalDateTime fechaCreacion, int estado) {
		super();
		this.idContacto = idContacto;
		this.idAlumno = idAlumno;
		this.idAdministrativo = idUsuario;
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.fechaContactar = fechaContactar;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public ContactoDTO(long idContacto, long idAlumno, long idAdministrativo,
			long idTarea, long idCurso, String descripcion,
			LocalDateTime fechaContactar, LocalDateTime fechaCreacion,
			int estado) {
		super();
		this.idContacto = idContacto;
		this.idAlumno = idAlumno;
		this.idAdministrativo = idAdministrativo;
		this.idTarea = idTarea;
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.fechaContactar = fechaContactar;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
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

	/**
	 * @return the idAdministrativo
	 */
	public long getIdAdministrativo() {
		return idAdministrativo;
	}

	/**
	 * @param idAdministrativo the idAdministrativo to set
	 */
	public void setIdAdministrativo(long idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @return the idTarea
	 */
	public long getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}	
}