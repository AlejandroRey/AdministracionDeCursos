package presentacion.vista;

import javax.swing.JFrame;

public class ADescarteTestTimePicker {

	private JFrame frame;
	private ADescarteClaseTimePicker TimePicker;

	public ADescarteTestTimePicker() {
		super();
		inicializar();
		this.frame.setVisible(true);
	}

	private void inicializar() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TimePicker = new ADescarteClaseTimePicker();
		TimePicker.setLocation(0, 0);
		TimePicker.setSize(574, 353);
		frame.getContentPane().add(TimePicker);
	}
}
