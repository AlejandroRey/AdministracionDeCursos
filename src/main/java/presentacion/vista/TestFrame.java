package presentacion.vista;

import javax.swing.JFrame;

public class TestFrame {
	
	private JFrame frame;
	private AlumnosEvaluacionesPanel alumnosEvaluacionesPanel;
	
	public TestFrame() {
		super();
		
		initilalize();
		this.frame.setVisible(true);
	}

	private void initilalize() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.e);
		frame.getContentPane().setLayout(null);
		
		alumnosEvaluacionesPanel =  new AlumnosEvaluacionesPanel();
		alumnosEvaluacionesPanel.setBounds(0, 0, 880, 800);
		frame.getContentPane().add(alumnosEvaluacionesPanel);
		alumnosEvaluacionesPanel.setLayout(null);
		
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the alumnosEvaluacionesPanel
	 */
	public AlumnosEvaluacionesPanel getAlumnosEvaluacionesPanel() {
		return alumnosEvaluacionesPanel;
	}

	/**
	 * @param alumnosEvaluacionesPanel the alumnosEvaluacionesPanel to set
	 */
	public void setAlumnosEvaluacionesPanel(AlumnosEvaluacionesPanel alumnosEvaluacionesPanel) {
		this.alumnosEvaluacionesPanel = alumnosEvaluacionesPanel;
	}
}
