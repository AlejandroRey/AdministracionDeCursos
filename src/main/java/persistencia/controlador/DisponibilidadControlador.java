package persistencia.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DisponibilidadControlador {
	
	private String nombreSala;
	private String nombreCurso;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private LocalDate fecha;
	
	public DisponibilidadControlador(String sala, String curso, LocalDateTime inicio, LocalDateTime fin) { 
		this.nombreSala = sala;
		this.nombreCurso = curso;
		this.horaInicio = inicio;
		this.horaFin = fin;
		this.fecha = createDate(inicio);
	}
	
	private LocalDate createDate(LocalDateTime localDateTime) {
		LocalDate date = localDateTime.toLocalDate();
		return date;
	}
	
	public String stringDate(LocalDateTime fecha, String pattern) {
		String formatDateTime = "";
		if ( fecha != null){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			formatDateTime = fecha.format(formatter);
		}
		return formatDateTime;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the nombreSala
	 */
	public String getNombreSala() {
		return nombreSala;
	}

	/**
	 * @param nombreSala the nombreSala to set
	 */
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	/**
	 * @return the nombreCurso
	 */
	public String getNombreCurso() {
		return nombreCurso;
	}

	/**
	 * @param nombreCurso the nombreCurso to set
	 */
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	/**
	 * @return the horaInicio
	 */
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFin
	 */
	public LocalDateTime getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}

}
