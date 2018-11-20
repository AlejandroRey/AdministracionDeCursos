package presentacion.vista;

import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SalaDisponibilidadDialog extends JDialog {

	private SalaDisponibilidadPanel disponibilidadPanel;
	private JButton btnCerrar;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	public SalaDisponibilidadDialog() {
		super();
		inicializar();
	}
	
	public void inicializar() {
		inicializarDialog();
	}
	
	private void inicializarDialog() {
		setSize(460,645);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		inicializarPanel();
		inicializarBtns();
	}
	
	public void showDialog() {
		setVisible(true);		
	}

	private void inicializarPanel() {
		disponibilidadPanel = new SalaDisponibilidadPanel();
		getContentPane().add(disponibilidadPanel, BorderLayout.CENTER);
	}

	private void inicializarBtns() {
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(351, 582, 89, 23);
		disponibilidadPanel.add(btnCerrar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Colores - Referencia horarios ocupados en el dia:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panel.setBounds(10, 532, 430, 50);
		disponibilidadPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(91, 23, 24, 16);
		panel.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(229, 23, 24, 16);
		panel.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		panel_3.setBounds(363, 23, 24, 16);
		panel.add(panel_3);
		
		JLabel lblMenosDe = new JLabel("Menos de 4");
		lblMenosDe.setBounds(10, 23, 112, 14);
		panel.add(lblMenosDe);
		
		JLabel lblEntreY = new JLabel("Entre 5 y 10");
		lblEntreY.setBounds(151, 25, 68, 14);
		panel.add(lblEntreY);
		
		JLabel lblMasDe10 = new JLabel("Mas de 10");
		lblMasDe10.setBounds(286, 25, 67, 14);
		panel.add(lblMasDe10);
	}
	
	/**
	 * @return the disponibilidadPanel
	 */
	public SalaDisponibilidadPanel getDisponibilidadPanel() {
		return disponibilidadPanel;
	}

	/**
	 * @param disponibilidadPanel the disponibilidadPanel to set
	 */
	public void setDisponibilidadPanel(SalaDisponibilidadPanel disponibilidadPanel) {
		this.disponibilidadPanel = disponibilidadPanel;
	}

	/**
	 * @return the btnCerrar
	 */
	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	/**
	 * @param btnCerrar the btnCerrar to set
	 */
	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}
	
	public static void main(String args[]) {
		System.out.println("Hola");
		SalaDisponibilidadDialog dialog = new SalaDisponibilidadDialog();
		dialog.showDialog();
	}
}
