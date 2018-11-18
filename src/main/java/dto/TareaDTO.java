package dto;
import java.time.LocalDateTime;


public class TareaDTO {

	private long idTarea;
	private long idUsuario;
	private long idAlumno;
	private String nombre;
	private String descripcion;
	private String estado;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaRealizar;
	private LocalDateTime fechaCierre;

	public TareaDTO(long idTarea, long idUsuario, long idAlumno, String nombre, String descripcion, String estado, LocalDateTime fechaCreacion, LocalDateTime fechaRealizar, LocalDateTime fechaCierre) {
		super();
		this.idTarea = idTarea;
		this.idUsuario = idUsuario;
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.fechaRealizar = fechaRealizar;
		this.fechaCierre = fechaCierre;
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

	/**
	 * @return the idUsuario
	 */
	public long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaCierre
	 */
	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	/**
	 * @param fechaCierre the fechaCierre to set
	 */
	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	/**
	 * @return the idAlumno
	 */
	public Long getIdAlumno() {
		return idAlumno;
	}

	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	/**
	 * @return the fechaRealizar
	 */
	public LocalDateTime getFechaRealizar() {
		return fechaRealizar;
	}

	/**
	 * @param fechaRealizar the fechaRealizar to set
	 */
	public void setFechaRealizar(LocalDateTime fechaRealizar) {
		this.fechaRealizar = fechaRealizar;
	}
}
