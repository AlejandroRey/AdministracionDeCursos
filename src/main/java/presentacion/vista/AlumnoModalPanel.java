package presentacion.vista;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class AlumnoModalPanel extends JDialog {
	
	private AlumnoABMPanel alumnoAbmPanel;
	private JButton btnAgregar;
	
	public AlumnoModalPanel() {
		super();
		setSize(600, 600);
	}

	/**
	 * @return the alumnoAbmPanel
	 */
	public AlumnoABMPanel getAlumnoAbmPanel() {
		return alumnoAbmPanel;
	}

	/**
	 * @param alumnoAbmPanel the alumnoAbmPanel to set
	 */
	public void setAlumnoAbmPanel(AlumnoABMPanel alumnoAbmPanel) {
		getContentPane().setLayout(null);		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.alumnoAbmPanel = alumnoAbmPanel;
		this.alumnoAbmPanel.setBounds(0, 23, 586, 519);
		getContentPane().add(alumnoAbmPanel);
		
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}
}
