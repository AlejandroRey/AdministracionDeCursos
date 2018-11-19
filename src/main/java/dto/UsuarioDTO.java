package dto;

public class UsuarioDTO {
	
	private long idUsuario;
	private long idCategoria;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String usuario;
	private String password;
	
	public UsuarioDTO(long idUsuario, long idCategoria, String nombre, String apellido, String telefono, String email,
			String usuario, String password) {
		super();
		this.idUsuario = idUsuario;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
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
	 * @return the idCategoria
	 */
	public long getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario: " + idUsuario + ", idCategoria: " + idCategoria + ", nombre: " + nombre
				+ ", apellido: " + apellido + ", telefono: " + telefono + ", email: " + email + ", usuario: " + usuario
				+ ", password: " + password + "]";
	}
}
