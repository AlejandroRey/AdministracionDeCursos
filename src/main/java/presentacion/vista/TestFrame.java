package presentacion.vista;

import javax.swing.JFrame;

public class TestFrame {
	
	private JFrame frame;
	private AlumnosAsistenciaPanel alumnosAsistenciaPanel;
	
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
		
		alumnosAsistenciaPanel =  new AlumnosAsistenciaPanel();
		alumnosAsistenciaPanel.setBounds(0, 0, 880, 800);
		frame.getContentPane().add(alumnosAsistenciaPanel);
		alumnosAsistenciaPanel.setLayout(null);
		
	}

	/**
	 * @return the alumnosAsistenciaPanel
	 */
	public AlumnosAsistenciaPanel getAlumnosAsistenciaPanel() {
		return alumnosAsistenciaPanel;
	}

	/**
	 * @param alumnosAsistenciaPanel the alumnosAsistenciaPanel to set
	 */
	public void setAlumnosAsistenciaPanel(AlumnosAsistenciaPanel alumnosAsistenciaPanel) {
		this.alumnosAsistenciaPanel = alumnosAsistenciaPanel;
	}

}
