package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.UsuarioABMPanel;
import presentacion.vista.UsuarioModalPanel;

public class UsuarioModalControlador implements ActionListener {
	
	private UsuarioABMControlador usuarioABMControlador;
	private UsuarioABMPanel usuarioABMPanel;
	private CursadaABMControlador cursadaABMControlador;
	
	private AdministracionDeCursos modelo;
	private UsuarioModalPanel usuarioModalPanel;
	private UsuarioDTO usuarioDTO;
	

	public UsuarioModalControlador(AdministracionDeCursos modelo, CursadaABMControlador cursadaABMControlador) {
		super();
		this.modelo = modelo;
		this.cursadaABMControlador = cursadaABMControlador;
		this.usuarioModalPanel = cursadaABMControlador.getUsuarioModalPanel();
		this.usuarioModalPanel = cursadaABMControlador.getUsuarioModalPanel();
		
		this.usuarioABMPanel = new UsuarioABMPanel();
		this.usuarioABMControlador = new UsuarioABMControlador(this.usuarioABMPanel, this.modelo);	
		this.usuarioABMControlador.inicializar();
		this.usuarioABMControlador.setBtnNotVisible();
		this.usuarioABMControlador.setTextDisable();
		this.usuarioABMControlador.filtrarInstructores();
		
		this.usuarioModalPanel.getBtnAgregar().addActionListener(this);
	}
	
	public void inicializar() {
		this.cursadaABMControlador.getUsuarioModalPanel().setUsuarioAbmPanel(this.usuarioABMPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.usuarioModalPanel.getBtnAgregar()) {
			try {
				this.usuarioDTO = this.usuarioABMControlador.getUsuarioDTO();
				this.cursadaABMControlador.getVista().getTextIdIntructor().setText(this.usuarioDTO.getIdUsuario()+"");
				this.cursadaABMControlador.getVista().getTextInstructor()
				.setText(this.usuarioDTO.getNombre() + " " + this.usuarioDTO.getApellido());
				this.usuarioModalPanel.dispose();
			} catch (Exception ex) {
			}
		}
		
	}

}
