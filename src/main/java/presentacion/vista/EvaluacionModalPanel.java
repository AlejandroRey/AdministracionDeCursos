package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class EvaluacionModalPanel extends JDialog {
	
	private EvaluacionABMPanel evaluacionABMPanel;
	private JButton btnAgregar;
	
	public EvaluacionModalPanel() {
		super();
		setSize(372, 300);
		getContentPane().setLayout(null);
	}

	/**
	 * @return the evaluacionABMPanel
	 */
	public EvaluacionABMPanel getEvaluacionABMPanel() {
		return evaluacionABMPanel;
	}

	/**
	 * @param evaluacionABMPanel the evaluacionABMPanel to set
	 */
	public void setEvaluacionABMPanel(EvaluacionABMPanel evaluacionABMPanel) {
		
		getContentPane().setLayout(null);		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.evaluacionABMPanel = evaluacionABMPanel;
		this.evaluacionABMPanel.setBounds(0, 23, 586, 519);
		getContentPane().add(evaluacionABMPanel);
		
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}

}
