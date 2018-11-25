package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class TareaAdministrativosDialog extends JDialog{

	private TareaAdministrativosPanel tareaAdministrativosPanel;
	private JButton btnSeleccionar;
	
	public TareaAdministrativosDialog() {
		super();
		setSize(421,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		inicializarPanel();
		inicializarBtns();
	}

	private void inicializarBtns() {
		
	}

	private void inicializarPanel() {
		tareaAdministrativosPanel = new TareaAdministrativosPanel();
		getContentPane().add(tareaAdministrativosPanel, BorderLayout.CENTER);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(316, 662, 89, 23);
		tareaAdministrativosPanel.add(btnSeleccionar);
	}

	/**
	 * @return the tareaAdministrativosPanel
	 */
	public TareaAdministrativosPanel getTareaAdministrativosPanel() {
		return tareaAdministrativosPanel;
	}

	/**
	 * @param tareaAdministrativosPanel the tareaAdministrativosPanel to set
	 */
	public void setTareaAdministrativosPanel(
			TareaAdministrativosPanel tareaAdministrativosPanel) {
		this.tareaAdministrativosPanel = tareaAdministrativosPanel;
	}

	/**
	 * @return the btnSeleccionar
	 */
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	/**
	 * @param btnSeleccionar the btnSeleccionar to set
	 */
	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

}
