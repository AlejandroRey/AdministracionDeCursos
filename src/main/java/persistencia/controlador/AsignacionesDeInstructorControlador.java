package persistencia.controlador;

import java.util.List;

import dto.CursadaDTO;
import dto.CursoDTO;
import dto.EstadoDeCursoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AsignacionesDeInstructorVista;

public class AsignacionesDeInstructorControlador {
	private AdministracionDeCursos modelo;
	private AsignacionesDeInstructorVista vista;
	private List<CursadaDTO> cursadas;
	
	public AsignacionesDeInstructorControlador(AdministracionDeCursos modelo, AsignacionesDeInstructorVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.cursadas = null;
	}
	
	public void inicializar(){
		llenarTabla();
	}
	
	private void llenarTabla() {
			this.cursadas = modelo.obtenerCursadas();
			for (CursadaDTO cursadaDTO : cursadas) {
				CursoDTO curso = modelo.obtenerCurso(cursadaDTO.getIdCurso());
				Object[] fila = {curso.getNombre(), curso.getTema(), asd(cursadaDTO.getIdEstadoCurso()), cursadaDTO.getFechaInicioCursada()};
				if (cursadaDTO.getIdInstructor()==this.modelo.getUsuarioLogueado().getIdUsuario()) {
					
					this.vista.getModelAsignaciones().addRow(fila);
				}
				
			}
	}
	
	public String asd(long id) {
		List<EstadoDeCursoDTO> estados = modelo.obtenerEstadosDeCurso();
		String result = "";
		for (EstadoDeCursoDTO estado : estados) {
			if (estado.getIdEstadoDeCurso()==id) {
				result = estado.getNombre();
			}
		}
		return result;
	}
}
