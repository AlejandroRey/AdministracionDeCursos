package presentacion.vista;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CursadaVista extends JPanel {

	/**
	 * Create the panel.
	 */
	public CursadaVista() {
		super();
		this.setBounds(0, 0, 590, 500);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panel.setBounds(44, 54, 180, 41);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Cursada");
		lblNewLabel.setBounds(55, 16, 115, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setLabelFor(panel);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ALEJANDRO\\Desktop\\prezi.img\\eclipse.png"));
		lblNewLabel_1.setBounds(5, 5, 32, 32);
		panel.add(lblNewLabel_1);

	}
}
