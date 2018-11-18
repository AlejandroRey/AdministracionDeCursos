package dto;

public class CursoDTO {

	private long idCurso;
	private long idCursoTipo;
	private String nombre;
	private String tema;
	private String temario;
	
	public CursoDTO(long idCurso, long idCursoTipo, String nombre, String tema, String temario) {
		super();
		this.idCurso = idCurso;
		this.idCursoTipo = idCursoTipo;
		this.nombre = nombre;
		this.tema = tema;
		this.temario = temario;
	}
	
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	public long getIdCursoTipo() {
		return idCursoTipo;
	}
	public void setIdCursoTipo(long idCursoTipo) {
		this.idCursoTipo = idCursoTipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getTemario() {
		return temario;
	}
	public void setTemario(String temario) {
		this.temario = temario;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object curso) {
	    return this.idCurso == ((CursoDTO) curso).idCurso;
	}
		
}
