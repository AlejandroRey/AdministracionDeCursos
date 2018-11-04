package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.EvaluacionTipoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.EvaluacionABMPanel;

public class EvaluacionABMControlador implements ActionListener {
	
	private EvaluacionABMPanel vista;
	private AdministracionDeCursos modelo;
	
	public EvaluacionABMControlador(EvaluacionABMPanel vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
	}

	public void inicializar() {
		llenarComboBoxEvaluacionTipo();
	}

	private void llenarComboBoxEvaluacionTipo() {
		
		List<EvaluacionTipoDTO> list = modelo.obtenerEvaluacionTipo();
		for (EvaluacionTipoDTO evaluacionTipoDTO : list) {
			this.vista.getCbxEvaluacionTipo().addItem(evaluacionTipoDTO);
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
