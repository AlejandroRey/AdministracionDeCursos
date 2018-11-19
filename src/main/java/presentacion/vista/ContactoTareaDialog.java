package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import persistencia.controlador.ContactoTareaControlador;
import persistencia.controlador.TareaABMControlador;
import persistencia.dao.mysql.DAOSQLFactory;

@SuppressWarnings("serial")
public class ContactoTareaDialog extends JDialog {
	
	private JPanel contactoTareaPanel;
	
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
	public JPanel getContactoTareaPanel() {
		return contactoTareaPanel;
	}

	/**
	 * @param contactoTareaPanel the contactoAlumnoPanel to set
	 */
	public void setContactoTareaPanel(JPanel contactoTareaPanel) {
		this.contactoTareaPanel = contactoTareaPanel;
		this.getContentPane().add(this.contactoTareaPanel, BorderLayout.CENTER);
	}
	
	public static void main (String[] args) {
		AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
		ContactoABMPanel panel = new ContactoABMPanel();
		ContactoTareaDialog dialog = new ContactoTareaDialog();
		dialog.setContactoTareaPanel(panel);
		dialog.setSize(1100, 700);
		dialog.showDialog();
//		ContactoTareaControlador crt = new ContactoTareaControlador(dialog, modelo);
//		crt.inicializar();
	}
}