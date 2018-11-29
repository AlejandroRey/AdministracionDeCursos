package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class NotificacionABMVistaPrincipal extends JPanel {
	private JPanel mainPanel;
	private JPanel buttonPanel;	
	private JLabel lblHome;
	private JLabel lblNotificaciones;
	private JLabel lblIconoPrincipal;
	
	/**
	 * Create the application.
	 */
	
	/**
	 * Create the panel.
	 */
	public NotificacionABMVistaPrincipal() {
		super();
		this.setBounds(0, 0, 1366, 768);
		this.setLayout(null);
		initialize();
	}

	private void initialize() {
		buildButtonPanel();
		buildMainPanel();	
	}

	private void buildMainPanel() {

		mainPanel = new JPanel();
		mainPanel.setBounds(200, 0, 1162, 736);
		add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setBackground(UIManager.getColor("Panel.background"));	
	}

	private void buildButtonPanel() {
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, 200, 736);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(47, 79, 79));
		
		buildButtonEliminados();
	}
		
	private void buildButtonEliminados() {
		
		lblHome = new JLabel("New label");
		lblHome.setIcon(new ImageIcon("imagenes/home.png"));
		lblHome.setBounds(74, 16, 48, 48);
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.setLayout(null);
		buttonPanel.add(lblHome);
		
		lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNotificaciones.setForeground(Color.WHITE);
		lblNotificaciones.setBounds(10, 57, 180, 26);
		buttonPanel.add(lblNotificaciones);
		
		lblIconoPrincipal = new JLabel("New label");
		lblIconoPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoPrincipal.setIcon(new ImageIcon("imagenes/curso.png"));
		lblIconoPrincipal.setBounds(38, 88, 125, 100);
		buttonPanel.add(lblIconoPrincipal);
	}
	
	

	
	/**
	 * @return the mainPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * @param mainPanel the mainPanel to set
	 */
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * @return the buttonPanel
	 */
	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	/**
	 * @param buttonPanel the buttonPanel to set
	 */
	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	/**
	 * @return the lblIconoPrincipal
	 */
	public JLabel getLblIconoPrincipal() {
		return lblIconoPrincipal;
	}

	/**
	 * @param lblIconoPrincipal the lblIconoPrincipal to set
	 */
	public void setLblIconoPrincipal(JLabel lblIconoPrincipal) {
		this.lblIconoPrincipal = lblIconoPrincipal;
	}

	public JLabel getLblHome() {
		return lblHome;
	}

	public void setLblHome(JLabel lblHome) {
		this.lblHome = lblHome;
	}
}
