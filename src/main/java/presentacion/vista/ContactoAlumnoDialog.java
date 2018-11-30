package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ContactoAlumnoDialog extends JDialog {
	
	private ContactoAlumnoPanel contactoAlumnoPanel;
	private JButton btnSeleccionar;
	private JButton btnSeleccionarNuevo;
	
	public ContactoAlumnoDialog() {
		super();
		setSize(593,523);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		inicializarPanel();
		inicializarBtns();
	}
	
	private void inicializarPanel() {
		contactoAlumnoPanel = new ContactoAlumnoPanel();
		getContentPane().add(contactoAlumnoPanel, BorderLayout.CENTER);
	}
	
	private void inicializarBtns() {
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(448, 460, 129, 23);
		contactoAlumnoPanel.add(btnSeleccionar);
		
		btnSeleccionarNuevo = new JButton("Seleccionar Nuevo");
		btnSeleccionarNuevo.setBounds(287, 460, 129, 23);
		contactoAlumnoPanel.add(btnSeleccionarNuevo);	
	}

	public void showDialog() {
		this.setVisible(true);
	}

	/**
	 * @return the contactoAlumnoPanel
	 */
	public ContactoAlumnoPanel getContactoAlumnoPanel() {
		return contactoAlumnoPanel;
	}

	/**
	 * @param contactoAlumnoPanel the contactoAlumnoPanel to set
	 */
	public void setContactoAlumnoPanel(ContactoAlumnoPanel contactoAlumnoPanel) {
		this.contactoAlumnoPanel = contactoAlumnoPanel;
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

	/**
	 * @return the btnSeleccionarNuevo
	 */
	public JButton getBtnSeleccionarNuevo() {
		return btnSeleccionarNuevo;
	}

	/**
	 * @param btnSeleccionarNuevo the btnSeleccionarNuevo to set
	 */
	public void setBtnSeleccionarNuevo(JButton btnSeleccionarNuevo) {
		this.btnSeleccionarNuevo = btnSeleccionarNuevo;
	}

}
