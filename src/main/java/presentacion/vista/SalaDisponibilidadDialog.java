package presentacion.vista;

import javax.swing.JDialog;

import java.awt.BorderLayout;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SalaDisponibilidadDialog extends JDialog {

	private SalaDisponibilidadPanel disponibilidadPanel;
	private JButton btnCerrar;

	public SalaDisponibilidadDialog() {
		super();
		inicializar();
	}
	
	public void inicializar() {
		inicializarDialog();
	}
	
	private void inicializarDialog() {
		setSize(460,600);
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
		btnCerrar.setBounds(345, 527, 89, 23);
		disponibilidadPanel.add(btnCerrar);
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
