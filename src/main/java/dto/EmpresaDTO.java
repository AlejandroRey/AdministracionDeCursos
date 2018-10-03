package dto;

public class EmpresaDTO {

	private long idEmpresa;
	private String nombre;
	private String telefono;
	private String email;
	
	public EmpresaDTO(long idEmpresa, String nombre, String telefono, String email) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	public long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

