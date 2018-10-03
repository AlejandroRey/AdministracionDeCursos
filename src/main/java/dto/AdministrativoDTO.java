package dto;

public class AdministrativoDTO {

	private long idAdministrativo;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	public AdministrativoDTO(long idAdministrativo, String nombre, String apellido, String telefono, String email) {
		super();
		this.idAdministrativo = idAdministrativo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}
	
	public long getIdAdministrativo() {
		return idAdministrativo;
	}
	public void setIdAdministrativo(long idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
