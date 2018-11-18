package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import modelo.AdministracionDeCursos;
import persistencia.controlador.ContactoTareaControlador;
import persistencia.controlador.TareaABMControlador;
import persistencia.dao.mysql.DAOSQLFactory;

@SuppressWarnings("serial")
public class ContactoTareaDialog extends JDialog {
	
	private TareaABMPanel contactoAlumnoPanel;
	
	public ContactoTareaDialog() {
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1200,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
	}
	
	public void showDialog() {
		this.setVisible(true);
	}

	/**
	 * @return the contactoAlumnoPanel
	 */
	public TareaABMPanel getContactoAlumnoPanel() {
		return contactoAlumnoPanel;
	}

	/**
	 * @param contactoAlumnoPanel the contactoAlumnoPanel to set
	 */
	public void setContactoAlumnoPanel(TareaABMPanel contactoAlumnoPanel) {
		this.contactoAlumnoPanel = contactoAlumnoPanel;
		this.getContentPane().add(this.contactoAlumnoPanel, BorderLayout.CENTER);
	}
	
	public static void main (String[] args) {
//		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
//		TareaABMPanel panel = new TareaABMPanel();
//		ContactoTareaDialog dialog = new ContactoTareaDialog();
//		dialog.setContactoAlumnoPanel(panel);
//		ContactoTareaControlador crt = new ContactoTareaControlador(dialog, modelo);
//		crt.inicializar();
	}
}