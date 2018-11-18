package presentacion.vista;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class UsuarioModalPanel extends JDialog {
	
	private UsuarioABMPanel usuarioAbmPanel;
	private JButton btnAgregar;
	
	public UsuarioModalPanel() {
		super();
		setSize(600, 700);
		getContentPane().setLayout(null);
		
		btnAgregar = new JButton("Seleccionar Administrativo");
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregar.setBounds(0, 624, 581, 37);
		getContentPane().add(btnAgregar);
	}

	/**
	 * @return the usuarioAbmPanel
	 */
	public UsuarioABMPanel getUsuarioAbmPanel() {
		return usuarioAbmPanel;
	}

	/**
	 * @param usuarioAbmPanel the usuarioAbmPanel to set
	 */
	public void setUsuarioAbmPanel(UsuarioABMPanel usuarioAbmPanel) {
		getContentPane().setLayout(null);		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.usuarioAbmPanel = usuarioAbmPanel;
		this.usuarioAbmPanel.setBounds(0, 0, 600, 700);
		getContentPane().add(this.usuarioAbmPanel);
		
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}

	/**
	 * @return the btnAgregar
	 */
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	/**
	 * @param btnAgregar the btnAgregar to set
	 */
	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
}
