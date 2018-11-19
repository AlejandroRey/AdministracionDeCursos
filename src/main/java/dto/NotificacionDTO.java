package dto;

import java.time.LocalDateTime;

public class NotificacionDTO {
	
	private long idNotificacion;
	private long idUsuario;
	private long tipoNotificacion;
	private String mensaje;
	private boolean visto;
	private LocalDateTime fechaHora;

	public NotificacionDTO(long idNotificacion, long idUsuario, long tipoNotificacion, String mensaje, boolean visto, 
			LocalDateTime fechaHora) {
		super();
		this.idNotificacion = idNotificacion;
		this.idUsuario = idUsuario;
		this.tipoNotificacion = tipoNotificacion;
		this.mensaje = mensaje;
		this.visto = visto;
		this.fechaHora = fechaHora;
	}

	public long getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(long idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isVisto() {
		return visto;
	}

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	@Override
	public String toString() {
		return "NotificacionDTO [idNotificacion: " + idNotificacion + ", idUsuario: " + idUsuario + ", tipoNotificacion: " +
				tipoNotificacion + ", mensaje: " + mensaje + ", visto: " + visto + ", fecha y hora: " + fechaHora + "]";
	}

	public long getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(long tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}
}
