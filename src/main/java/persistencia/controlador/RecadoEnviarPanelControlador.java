package persistencia.controlador;

import modelo.AdministracionDeCursos;
import presentacion.vista.RecadoEnviarPanel;

public class RecadoEnviarPanelControlador {

	private AdministracionDeCursos modelo;
	private RecadoEnviarPanel vista;
	
	public RecadoEnviarPanelControlador(AdministracionDeCursos modelo, RecadoEnviarPanel vista) {
		this.vista = vista;
		this.modelo = modelo;

	}
	
	public void inicializar() {
		
	}

	public void limpiarInputs() {
		clearTextInputsBox();
	}
	
	private void clearTextInputsBox() {
		this.vista.getTextIdRecado().setText("");
		this.vista.getTextAreaMensaje().setText("");
		this.vista.getTextAsunto().setText("");
		this.vista.getTxtPara().setText("");
	}
	
}
