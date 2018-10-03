package dto;

public class InscriptoDTO {

	private long idAlumno;
	private long idCursada;
	
	public InscriptoDTO(long idAlumno, long idCursada) {
		super();
		this.idAlumno = idAlumno;
		this.idCursada = idCursada;
	}
	
	public long getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}
	public long getIdCursada() {
		return idCursada;
	}
	public void setIdCursada(long idCursada) {
		this.idCursada = idCursada;
	}
		
}
