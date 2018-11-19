package dto;

public class ContactoCompletoDTO {
	
	private ContactoDTO contacto;
	private AlumnoDTO alumno;//
	private String curso;
	private String nombreAdministrativo;
	private String apellidoAdministrativo;
	
	public ContactoCompletoDTO(ContactoDTO contacto, AlumnoDTO alumno) {
		super();
		this.contacto = contacto;
		this.alumno = alumno;
	}
	
	public ContactoCompletoDTO(ContactoDTO contacto, AlumnoDTO alumno, String curso, String nombreAdministrativo, String apellidoAdministrativo) {
		super();
		this.contacto = contacto;
		this.alumno = alumno;
		this.curso = curso;
		this.nombreAdministrativo = nombreAdministrativo;
		this.apellidoAdministrativo = apellidoAdministrativo;
	}

	/**
	 * @return the contacto
	 */
	public ContactoDTO getContacto() {
		return contacto;
	}
	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(ContactoDTO contacto) {
		this.contacto = contacto;
	}
	/**
	 * @return the alumno
	 */
	public AlumnoDTO getAlumno() {
		return alumno;
	}
	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(AlumnoDTO alumno) {
		this.alumno = alumno;
	}

	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the nombreAdministrativo
	 */
	public String getNombreAdministrativo() {
		return nombreAdministrativo;
	}

	/**
	 * @param nombreAdministrativo the nombreAdministrativo to set
	 */
	public void setNombreAdministrativo(String nombreAdministrativo) {
		this.nombreAdministrativo = nombreAdministrativo;
	}

	/**
	 * @return the apellidoAdministrativo
	 */
	public String getApellidoAdministrativo() {
		return apellidoAdministrativo;
	}

	/**
	 * @param apellidoAdministrativo the apellidoAdministrativo to set
	 */
	public void setApellidoAdministrativo(String apellidoAdministrativo) {
		this.apellidoAdministrativo = apellidoAdministrativo;
	}

}
