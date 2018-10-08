package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.conexion.Conexion;

public class CursadaFullVista {

	private JFrame frame;
	private CursadaNuevaVista panelCursada;
	
	public CursadaFullVista() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelCursada = new CursadaNuevaVista();
		panelCursada.setSize(700, 622);
		panelCursada.setLocation(10, 11);
		//panelCursada.setBounds(0, 0, 1064, 262);
		frame.getContentPane().add(panelCursada);

	}

	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Agenda!?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	/**
	 * @return the panelCursada
	 */
	public CursadaNuevaVista getPanelCursada() {
		return panelCursada;
	}

	/**
	 * @param panelCursada the panelCursada to set
	 */
	public void setPanelCursada(CursadaNuevaVista panelCursada) {
		this.panelCursada = panelCursada;
	}

}
