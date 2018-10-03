package dto;

public class NotaDTO {

	private long idNota;
	private long idAlumno;
	private long idNotaTipo;
	private String nota;
	
	public NotaDTO(long idNota, long idAlumno, long idNotaTipo, String nota) {
		super();
		this.idNota = idNota;
		this.idAlumno = idAlumno;
		this.idNotaTipo = idNotaTipo;
		this.nota = nota;
	}
	
	public long getIdNota() {
		return idNota;
	}
	public void setIdNota(long idNota) {
		this.idNota = idNota;
	}
	public long getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}
	public long getIdNotaTipo() {
		return idNotaTipo;
	}
	public void setIdNotaTipo(long idNotaTipo) {
		this.idNotaTipo = idNotaTipo;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
}
