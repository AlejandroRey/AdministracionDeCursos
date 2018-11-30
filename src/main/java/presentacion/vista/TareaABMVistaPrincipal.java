package presentacion.vista;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class TareaABMVistaPrincipal extends JPanel {
	
	private JPanel mainPanel;
	
	private JPanel buttonPanel;	
	
	private JLabel lblHome;
	private JLabel lblCurso;
	private JLabel lblIconoPrincipal;
	
	private JPanel btnAgregar;
	private JLabel lblTitleBtn2;
	private JLabel lblIconBtn2;
	
	private JPanel btnActualizar;
	private JLabel lblIconBtn3;
	private JLabel lblTitleBtn3;
	
	private JPanel btnEliminar;
	private JLabel lblIconBtn4; 
	private JLabel lblTitleBtn4;	

	public TareaABMVistaPrincipal() {
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
		
		buildButtonAgregar();
		buildButtonActualizar();
		buildButtonEliminar();
	}
	
	private void buildButtonAgregar() {

		btnAgregar = new JPanel();
		btnAgregar.setLayout(null);
		btnAgregar.setBackground(new Color(0, 0, 0));
		btnAgregar.setBounds(0, 269, 200, 50);
		buttonPanel.add(btnAgregar);
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregar.setLayout(null);
		
		lblIconBtn2 = new JLabel("");
		lblIconBtn2.setIcon(new ImageIcon("imagenes/create.png"));
		lblIconBtn2.setBounds(10, 11, 32, 32);
		btnAgregar.add(lblIconBtn2);

		lblTitleBtn2 = new JLabel("Agregar Tarea");
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
		
		lblIconBtn3 = new JLabel("");
		lblIconBtn3.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn3.setBounds(10, 11, 32, 32);
		btnActualizar.add(lblIconBtn3);
		
		lblTitleBtn3 = new JLabel("Actualizar Tarea");
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
		
		lblIconBtn4 = new JLabel("");
		lblIconBtn4.setIcon(new ImageIcon("imagenes/delete.png"));
		lblIconBtn4.setBounds(10, 11, 32, 32);
		btnEliminar.add(lblIconBtn4);
		
		lblTitleBtn4 = new JLabel("Eliminar Tarea");
		lblTitleBtn4.setForeground(Color.WHITE);
		lblTitleBtn4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn4.setEnabled(true);
		lblTitleBtn4.setBounds(74, 25, 116, 14);
		btnEliminar.add(lblTitleBtn4);
		
		lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon("imagenes/home.png"));
		lblHome.setBounds(82, 5, 48, 48);
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.setLayout(null);
		buttonPanel.add(lblHome);	
		
		lblCurso = new JLabel("Tarea");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setBounds(76, 57, 48, 26);
		buttonPanel.add(lblCurso);
		
		lblIconoPrincipal = new JLabel("");
		lblIconoPrincipal.setIcon(new ImageIcon("imagenes/curso.png"));
		lblIconoPrincipal.setBounds(49, 94, 100, 100);
		buttonPanel.add(lblIconoPrincipal);
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

	public JLabel getLblHome() {
		return lblHome;
	}

	public void setLblHome(JLabel lblHome) {
		this.lblHome = lblHome;
	}
	
}
