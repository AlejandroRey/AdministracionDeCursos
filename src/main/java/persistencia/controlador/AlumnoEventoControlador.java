package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;

import dto.AlumnoEventoDTO;
import dto.CategoriaDTO;
import dto.CursoTipoDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AlumnoEventoVista;
import presentacion.vista.UsuarioCrudVista;

public class AlumnoEventoControlador implements ActionListener {
	
	private AlumnoEventoVista AlumnoEventoVista;
	private AdministracionDeCursos modelo;
	private List<CursoTipoDTO> cursos;
	
	public AlumnoEventoControlador(AlumnoEventoVista vista, AdministracionDeCursos modelo) {
		this.AlumnoEventoVista = vista;
		this.modelo = modelo;
		this.AlumnoEventoVista.getBtnGuardar().addActionListener(this);
		this.AlumnoEventoVista.getBtnCancelar().addActionListener(this);
	}

	public void inicializar() {
		this.AlumnoEventoVista.show();
		llenarComboCursos();
	}
	
	public void llenarComboCursos() {
		this.cursos = modelo.obtenerCursoTipos();
		for (CursoTipoDTO curso: this.cursos) {
			AlumnoEventoVista.getComboBox_Cursos().addItem(curso);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == this.AlumnoEventoVista.getBtnGuardar()) {
			agregarAlumnoEvento();
		} else if (e.getSource() == this.AlumnoVista.getBtnCancelar()) {
			agregarInstructor();
		}*/
	}
	
	/*private void agregarAlumnoEvento() {		
		AlumnoEventoDTO alumnoEvento = new AlumnoEventoDTO( 0, 6, 5, 2, this.AlumnoEventoVista.getTextField_descripcion().getText(),
					   this.AlumnoEventoVista.getCalendario(), false,null);
		modelo.agregarAlumnoEvento(alumnoEvento);
		}*/
	}
