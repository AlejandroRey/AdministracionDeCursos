package dto;

public class CursadaDTO {
	private long idCursada;
	private long idEmpresa;
	private long idCurso;
	private long idUsuario;
	private long idSala;
	private long idEstadoCurso;
	private int vacantes;
	
	public CursadaDTO(long idCursada, long idEmpresa, long idCurso, long idUsuario, long idSala, long idEstadoCurso, int vacantes) {
		super();
		this.idCursada = idCursada;
		this.idEmpresa = idEmpresa;
		this.idCurso = idCurso;
		this.idUsuario = idUsuario;
		this.idSala = idSala;
		this.idEstadoCurso = idEstadoCurso;
		this.vacantes = vacantes;
	}

	public long getIdCursada() {
		return idCursada;
	}

	public void setIdCursada(long idCursada) {
		this.idCursada = idCursada;
	}

	public long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdSala() {
		return idSala;
	}

	public void setIdSala(long idSala) {
		this.idSala = idSala;
	}

	public long getIdEstadoCurso() {
		return idEstadoCurso;
	}

	public void setIdEstadoCurso(long idEstadoCurso) {
		this.idEstadoCurso = idEstadoCurso;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	
	@Override
	public String toString() {
		return "CursadaDTO [idCursada: " + idCursada + ", idEmpresa: " + idEmpresa + ", idCurso: " + idCurso + ", idUsuario: "
				+ idUsuario + ", idSala: " + idSala + ", idEstadoCurso: " + idEstadoCurso + ", vacantes: " + vacantes + "]";
	}

	
}
