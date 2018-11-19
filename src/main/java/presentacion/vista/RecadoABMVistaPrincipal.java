package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RecadoABMVistaPrincipal extends JPanel {

	private JPanel mainPanel;
	private JPanel buttonPanel;	
	private JLabel lblHome;
	private JLabel lblRecado;
	private JLabel lblIconoPrincipal;
	
	private JPanel btnRecibidos;
	private JPanel btnNuevo;
	private JLabel lblTitleBtn1;
	private JLabel lblTitleBtn3;
	private JLabel lblIconBtn1;
	private JLabel lblIconBtn3;
	
	private JPanel btnEnviados;
	private JLabel lblTitleBtn2;
	private JLabel lblIconBtn2;
	
	private JPanel btnEliminados;
	private JLabel lblIconBtn4; 
	private JLabel lblTitleBtn4;	
	
	/**
	 * Create the application.
	 */
	
	/**
	 * Create the panel.
	 */
	public RecadoABMVistaPrincipal() {
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
		
		buildButtonEnviar();
		buildButtonRecibidos();
		buildButtonEliminados();
	}
	
	private void buildButtonRecibidos() {

		btnEnviados = new JPanel();
		btnEnviados.setLayout(null);
		btnEnviados.setBackground(new Color(47, 79, 79));
		btnEnviados.setBounds(0, 319, 200, 50);
		buttonPanel.add(btnEnviados);
		btnEnviados.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEnviados.setLayout(null);
		
		lblIconBtn2 = new JLabel("New label");
		lblIconBtn2.setIcon(new ImageIcon("imagenes/read.png"));
		lblIconBtn2.setBounds(10, 11, 32, 32);
		btnEnviados.add(lblIconBtn2);

		lblTitleBtn2 = new JLabel("Enviados");
		lblTitleBtn2.setForeground(Color.WHITE);
		lblTitleBtn2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn2.setEnabled(true);
		lblTitleBtn2.setBounds(74, 25, 116, 14);
		btnEnviados.add(lblTitleBtn2);
	}

	private void buildButtonEnviar() {
		
		btnNuevo = new JPanel();
		btnNuevo.setLayout(null);
		btnNuevo.setBackground(new Color(47, 79, 79));
		btnNuevo.setBounds(0, 219, 200, 50);
		buttonPanel.add(btnNuevo);
		btnNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNuevo.setLayout(null);
		
		lblIconBtn3 = new JLabel("New label");
		lblIconBtn3.setIcon(new ImageIcon("imagenes/create.png"));
		lblIconBtn3.setBounds(10, 11, 32, 32);
		btnNuevo.add(lblIconBtn3);
		
		lblTitleBtn3 = new JLabel("Nuevo");
		lblTitleBtn3.setForeground(Color.WHITE);
		lblTitleBtn3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn3.setEnabled(true);
		lblTitleBtn3.setBounds(74, 25, 116, 14);
		btnNuevo.add(lblTitleBtn3);		
	}
	
	private void buildButtonEliminados() {
		
		btnEliminados = new JPanel();
		btnEliminados.setLayout(null);
		btnEliminados.setBackground(new Color(47, 79, 79));
		btnEliminados.setBounds(0, 371, 200, 50);
		buttonPanel.add(btnEliminados);
		btnEliminados.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminados.setLayout(null);
		
		lblIconBtn4 = new JLabel("New label");
		lblIconBtn4.setIcon(new ImageIcon("imagenes/delete.png"));
		lblIconBtn4.setBounds(10, 11, 32, 32);
		btnEliminados.add(lblIconBtn4);
		
		lblTitleBtn4 = new JLabel("Eliminados");
		lblTitleBtn4.setForeground(Color.WHITE);
		lblTitleBtn4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn4.setEnabled(true);
		lblTitleBtn4.setBounds(74, 25, 116, 14);
		btnEliminados.add(lblTitleBtn4);
		
		lblHome = new JLabel("New label");
		lblHome.setIcon(new ImageIcon("imagenes/home.png"));
		lblHome.setBounds(74, 16, 48, 48);
		buttonPanel.add(lblHome);
		
		lblRecado = new JLabel("Recados");
		lblRecado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecado.setForeground(Color.WHITE);
		lblRecado.setBounds(49, 57, 85, 26);
		buttonPanel.add(lblRecado);
		
		lblIconoPrincipal = new JLabel("New label");
		lblIconoPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoPrincipal.setIcon(new ImageIcon("imagenes/curso.png"));
		lblIconoPrincipal.setBounds(38, 88, 125, 100);
		buttonPanel.add(lblIconoPrincipal);
		
		btnRecibidos = new JPanel();
		btnRecibidos.setBounds(0, 268, 200, 50);
		buttonPanel.add(btnRecibidos);
		btnRecibidos.setLayout(null);
		btnRecibidos.setBackground(new Color(47, 79, 79));
		btnRecibidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRecibidos.setLayout(null);
		
		lblIconBtn1 = new JLabel("New label");
		lblIconBtn1.setIcon(new ImageIcon("imagenes/read.png"));
		lblIconBtn1.setBounds(10, 11, 32, 32);
		btnRecibidos.add(lblIconBtn1);
		
		lblTitleBtn1 = new JLabel("Recibidos");
		lblTitleBtn1.setForeground(Color.WHITE);
		lblTitleBtn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn1.setEnabled(true);
		lblTitleBtn1.setBounds(74, 25, 116, 14);
		btnRecibidos.add(lblTitleBtn1);		
	}
	
	

	public JPanel getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JPanel btnNuevo) {
		this.btnNuevo = btnNuevo;
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
	 * @return the btnSeleccionar
	 */
	public JPanel getBtnRecibidos() {
		return btnRecibidos;
	}

	/**
	 * @param btnSeleccionar the btnSeleccionar to set
	 */
	public void setBtnSeleccionar(JPanel btnSeleccionar) {
		this.btnRecibidos = btnSeleccionar;
	}

	/**
	 * @return the lblTitleBtn1
	 */
	public JLabel getLblTitleBtn1() {
		return lblTitleBtn1;
	}

	/**
	 * @param lblTitleBtn1 the lblTitleBtn1 to set
	 */
	public void setLblTitleBtn1(JLabel lblTitleBtn1) {
		this.lblTitleBtn1 = lblTitleBtn1;
	}

	/**
	 * @return the lblIconBtn1
	 */
	public JLabel getLblIconBtn1() {
		return lblIconBtn1;
	}

	/**
	 * @param lblIconBtn1 the lblIconBtn1 to set
	 */
	public void setLblIconBtn1(JLabel lblIconBtn1) {
		this.lblIconBtn1 = lblIconBtn1;
	}

	/**
	 * @return the btnAgregar
	 */
	public JPanel getBtnEnviados() {
		return btnEnviados;
	}

	/**
	 * @param btnAgregar the btnAgregar to set
	 */
	public void setBtnAgregar(JPanel btnAgregar) {
		this.btnEnviados = btnAgregar;
	}

	/**
	 * @return the lblTitleBtn2
	 */
	public JLabel getLblTitleBtn2() {
		return lblTitleBtn2;
	}

	/**
	 * @param lblTitleBtn2 the lblTitleBtn2 to set
	 */
	public void setLblTitleBtn2(JLabel lblTitleBtn2) {
		this.lblTitleBtn2 = lblTitleBtn2;
	}

	/**
	 * @return the lblIconBtn2
	 */
	public JLabel getLblIconBtn2() {
		return lblIconBtn2;
	}

	/**
	 * @param lblIconBtn2 the lblIconBtn2 to set
	 */
	public void setLblIconBtn2(JLabel lblIconBtn2) {
		this.lblIconBtn2 = lblIconBtn2;
	}

	/**
	 * @return the btnEliminar
	 */
	public JPanel getBtnEliminados() {
		return btnEliminados;
	}

	/**
	 * @param btnEliminar the btnEliminar to set
	 */
	public void setBtnEliminar(JPanel btnEliminar) {
		this.btnEliminados = btnEliminar;
	}
	
	public JLabel getLblTitleBtn3() {
		return lblTitleBtn3;
	}

	public void setLblTitleBtn3(JLabel lblTitleBtn3) {
		this.lblTitleBtn3 = lblTitleBtn3;
	}

	public JLabel getLblIconBtn3() {
		return lblIconBtn3;
	}

	public void setLblIconBtn3(JLabel lblIconBtn3) {
		this.lblIconBtn3 = lblIconBtn3;
	}

	/**
	 * @return the lblIconBtn4
	 */
	public JLabel getLblIconBtn4() {
		return lblIconBtn4;
	}

	/**
	 * @param lblIconBtn4 the lblIconBtn4 to set
	 */
	public void setLblIconBtn4(JLabel lblIconBtn4) {
		this.lblIconBtn4 = lblIconBtn4;
	}

	/**
	 * @return the lblTitleBtn4
	 */
	public JLabel getLblTitleBtn4() {
		return lblTitleBtn4;
	}

	/**
	 * @param lblTitleBtn4 the lblTitleBtn4 to set
	 */
	public void setLblTitleBtn4(JLabel lblTitleBtn4) {
		this.lblTitleBtn4 = lblTitleBtn4;
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
