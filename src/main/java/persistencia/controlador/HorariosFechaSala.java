package persistencia.controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.SalaDisponibilidadDTO;

public class HorariosFechaSala {

	private List<DisponibilidadControlador> disponibilidad;
	
	public HorariosFechaSala(List<SalaDisponibilidadDTO> fechasCursadasLista) {
		this.disponibilidad = new ArrayList<DisponibilidadControlador>();
		generateDisponibilidades(fechasCursadasLista);
	}

	private void generateDisponibilidades(List<SalaDisponibilidadDTO> fechasCursadasLista) {
		for (SalaDisponibilidadDTO fecha : fechasCursadasLista) { 
			addDisponibilidad(fecha);
		}
	}

	private void addDisponibilidad(SalaDisponibilidadDTO fecha) {
		String sala = fecha.getSala();
		String curso = fecha.getCurso();
		LocalDateTime inicio = fecha.getHoraFin();
		LocalDateTime fin = fecha.getHoraFin();
		DisponibilidadControlador disponibilidad = new DisponibilidadControlador(sala,curso,inicio,fin);
		this.disponibilidad.add(disponibilidad);
	}

	public List<DisponibilidadControlador> getDisponibilidades() {
		return disponibilidad;
	}
}
