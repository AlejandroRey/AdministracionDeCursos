package dto;

import java.sql.Timestamp;

public class RecadoDTO {

	private long idRecado;
	private long idUsuarioDe;
	private long idUsuarioPara;
	private String asunto;
	private String mensaje;
	private Timestamp fechaHoraEnvio;
	private boolean visto;
	
	public RecadoDTO(long idRecado, long idUsuarioDe, long idUsuarioPara, String asunto, String mensaje,
			Timestamp fechaHoraEnvio, boolean visto) {
		super();
		this.idRecado = idRecado;
		this.idUsuarioDe = idUsuarioDe;
		this.idUsuarioPara = idUsuarioPara;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.fechaHoraEnvio = fechaHoraEnvio;
		this.visto = visto;
	}
	
	public long getIdRecado() {
		return idRecado;
	}
	public void setIdRecado(long idRecado) {
		this.idRecado = idRecado;
	}
	public long getIdUsuarioDe() {
		return idUsuarioDe;
	}
	public void setIdUsuarioDe(long idUsuarioDe) {
		this.idUsuarioDe = idUsuarioDe;
	}
	public long getIdUsuarioPara() {
		return idUsuarioPara;
	}
	public void setIdUsuarioPara(long idUsuarioPara) {
		this.idUsuarioPara = idUsuarioPara;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Timestamp getFechaHoraEnvio() {
		return fechaHoraEnvio;
	}
	public void setFechaHoraEnvio(Timestamp fechaHoraEnvio) {
		this.fechaHoraEnvio = fechaHoraEnvio;
	}
	public boolean isVisto() {
		return visto;
	}
	public void setVisto(boolean visto) {
		this.visto = visto;
	}
		
}
