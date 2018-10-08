package presentacion.vista;

import javax.swing.JFrame;

public class TestTimePicker {

	private JFrame frame;
	private ClaseTimePicker TimePicker;

	public TestTimePicker() {
		super();
		inicializar();
		this.frame.setVisible(true);
	}

	private void inicializar() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TimePicker = new ClaseTimePicker();
		TimePicker.setLocation(0, 0);
		TimePicker.setSize(574, 353);
		frame.getContentPane().add(TimePicker);
	}
}
