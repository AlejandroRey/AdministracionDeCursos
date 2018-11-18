package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class ContactoAlumnoNuevoDialog extends JDialog{
	
	private ContactoAlumnoNuevoPanel contactoAlumnoNuevoPanel;
	
	public ContactoAlumnoNuevoDialog() {
		super();
		inicializarDialog();
		inicializarPanel();
		incializarBtns();
	}

	private void inicializarPanel() {
		contactoAlumnoNuevoPanel = new ContactoAlumnoNuevoPanel();
		getContentPane().add(contactoAlumnoNuevoPanel,BorderLayout.CENTER);
	}

	private void incializarBtns() {
		
	}

	private void inicializarDialog() {
		setTitle("Seleccionar nuevo alumno"); 
		setSize(527,199);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
	}
	
	public void showDialog() {
		this.setVisible(true);
	}

	/**
	 * @return the contactoAlumnoNuevoPanel
	 */
	public ContactoAlumnoNuevoPanel getContactoAlumnoNuevoPanel() {
		return contactoAlumnoNuevoPanel;
	}

	/**
	 * @param contactoAlumnoNuevoPanel the contactoAlumnoNuevoPanel to set
	 */
	public void setContactoAlumnoNuevoPanel(
			ContactoAlumnoNuevoPanel contactoAlumnoNuevoPanel) {
		this.contactoAlumnoNuevoPanel = contactoAlumnoNuevoPanel;
	}

}
