package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class CursoABMVistaPrincipal extends JPanel {
	
	private JPanel mainPanel;
	
	private JPanel buttonPanel;	
	
	private JLabel lblHome;
	private JLabel lblCurso;
	private JLabel lblIconoPrincipal;
	
	private JPanel btnSeleccionar;
	private JLabel lblTitleBtn1;
	private JLabel lblIconBtn1;
	
	private JPanel btnAgregar;
	private JLabel lblTitleBtn2;
	private JLabel lblIconBtn2;
	
	private JPanel btnActualizar;
	private JLabel lblIconBtn3;
	private JLabel lblTitleBtn3;
	
	private JPanel btnEliminar;
	private JLabel lblIconBtn4; 
	private JLabel lblTitleBtn4;	

	/**
	 * Create the panel.
	 */
	public CursoABMVistaPrincipal() {
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
		buttonPanel.setBackground(new Color(0, 0, 0));
		
		buildButtonVer();
		buildButtonAgregar();
		buildButtonActualizar();
		buildButtonEliminar();
	}

	private void buildButtonVer() {
		
		btnSeleccionar = new JPanel();
		btnSeleccionar.setLayout(null);
		btnSeleccionar.setBackground(new Color(0, 0, 0));
		btnSeleccionar.setBounds(0, 219, 200, 50);
		buttonPanel.add(btnSeleccionar);
		btnSeleccionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeleccionar.setLayout(null);
		
		lblIconBtn1 = new JLabel("New label");
		lblIconBtn1.setIcon(new ImageIcon("imagenes/read.png"));
		lblIconBtn1.setBounds(10, 11, 32, 32);
		btnSeleccionar.add(lblIconBtn1);
		
		lblTitleBtn1 = new JLabel("Seleccionar Curso");
		lblTitleBtn1.setForeground(Color.WHITE);
		lblTitleBtn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn1.setEnabled(true);
		lblTitleBtn1.setBounds(74, 25, 116, 14);
		btnSeleccionar.add(lblTitleBtn1);		
	}
	
	private void buildButtonAgregar() {

		btnAgregar = new JPanel();
		btnAgregar.setLayout(null);
		btnAgregar.setBackground(new Color(0, 0, 0));
		btnAgregar.setBounds(0, 269, 200, 50);
		buttonPanel.add(btnAgregar);
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregar.setLayout(null);
		
		lblIconBtn2 = new JLabel("New label");
		lblIconBtn2.setIcon(new ImageIcon("imagenes/create.png"));
		lblIconBtn2.setBounds(10, 11, 32, 32);
		btnAgregar.add(lblIconBtn2);

		lblTitleBtn2 = new JLabel("Agregar Curso");
		lblTitleBtn2.setForeground(Color.WHITE);
		lblTitleBtn2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn2.setEnabled(true);
		lblTitleBtn2.setBounds(74, 25, 116, 14);
		btnAgregar.add(lblTitleBtn2);
	}
	
	private void buildButtonActualizar() {
		
		btnActualizar = new JPanel();
		btnActualizar.setLayout(null);
		btnActualizar.setBackground(new Color(0, 0, 0));
		btnActualizar.setBounds(0, 319, 200, 50);
		buttonPanel.add(btnActualizar);
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizar.setLayout(null);
		
		lblIconBtn3 = new JLabel("New label");
		lblIconBtn3.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn3.setBounds(10, 11, 32, 32);
		btnActualizar.add(lblIconBtn3);
		
		lblTitleBtn3 = new JLabel("Actualizar Curso");
		lblTitleBtn3.setForeground(Color.WHITE);
		lblTitleBtn3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn3.setEnabled(true);
		lblTitleBtn3.setBounds(74, 25, 116, 14);
		btnActualizar.add(lblTitleBtn3);		
	}

	private void buildButtonEliminar() {
		
		btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.setBounds(0, 368, 200, 50);
		buttonPanel.add(btnEliminar);
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminar.setLayout(null);
		
		lblIconBtn4 = new JLabel("New label");
		lblIconBtn4.setIcon(new ImageIcon("imagenes/delete.png"));
		lblIconBtn4.setBounds(10, 11, 32, 32);
		btnEliminar.add(lblIconBtn4);
		
		lblTitleBtn4 = new JLabel("Eliminar Curso");
		lblTitleBtn4.setForeground(Color.WHITE);
		lblTitleBtn4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn4.setEnabled(true);
		lblTitleBtn4.setBounds(74, 25, 116, 14);
		btnEliminar.add(lblTitleBtn4);
		
		lblHome = new JLabel("New label");
		lblHome.setIcon(new ImageIcon("imagenes/home.png"));
		lblHome.setBounds(82, 5, 48, 48);
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.setLayout(null);
		buttonPanel.add(lblHome);	
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setBounds(76, 57, 48, 26);
		buttonPanel.add(lblCurso);
		
		lblIconoPrincipal = new JLabel("New label");
		lblIconoPrincipal.setIcon(new ImageIcon("imagenes/curso.png"));
		lblIconoPrincipal.setBounds(49, 94, 100, 100);
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
	 * @return the btnSeleccionar
	 */
	public JPanel getBtnSeleccionar() {
		return btnSeleccionar;
	}

	/**
	 * @param btnSeleccionar the btnSeleccionar to set
	 */
	public void setBtnSeleccionar(JPanel btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
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
	public JPanel getBtnAgregar() {
		return btnAgregar;
	}

	/**
	 * @param btnAgregar the btnAgregar to set
	 */
	public void setBtnAgregar(JPanel btnAgregar) {
		this.btnAgregar = btnAgregar;
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
	 * @return the btnActualizar
	 */
	public JPanel getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * @param btnActualizar the btnActualizar to set
	 */
	public void setBtnActualizar(JPanel btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	/**
	 * @return the lblIconBtn3
	 */
	public JLabel getLblIconBtn3() {
		return lblIconBtn3;
	}

	/**
	 * @param lblIconBtn3 the lblIconBtn3 to set
	 */
	public void setLblIconBtn3(JLabel lblIconBtn3) {
		this.lblIconBtn3 = lblIconBtn3;
	}

	/**
	 * @return the lblTitleBtn3
	 */
	public JLabel getLblTitleBtn3() {
		return lblTitleBtn3;
	}

	/**
	 * @param lblTitleBtn3 the lblTitleBtn3 to set
	 */
	public void setLblTitleBtn3(JLabel lblTitleBtn3) {
		this.lblTitleBtn3 = lblTitleBtn3;
	}

	/**
	 * @return the btnEliminar
	 */
	public JPanel getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @param btnEliminar the btnEliminar to set
	 */
	public void setBtnEliminar(JPanel btnEliminar) {
		this.btnEliminar = btnEliminar;
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
