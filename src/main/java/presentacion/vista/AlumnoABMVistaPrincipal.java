package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AlumnoABMVistaPrincipal extends JPanel {
	
	private JPanel mainPanel;	
	private JPanel panelAbm;
	
	private JLabel lblTitulo;
	private JLabel lblHomeI;
	private JLabel lblIconoPrincipal;
	
	private JPanel panelBtnAbmAlumno;
	
	private JPanel btnVer;
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
	
	private JPanel panelBtnHistorialAlumno;
	
	private JPanel btnNotas;
	private JLabel lblTitleBtn5;
	private JLabel lblHistorialDeNotas;
	
	private JPanel btnAsistencias;
	private JLabel lblTitleBtn6;
	private JLabel lblHistorialDeInasistencias;
	
	private JPanel btnPagos;
	private JLabel lblTitleBtn7;
	private JLabel lblHistorialDePagos;
	
	private JPanel btnContactos;
	private JLabel lblTitleBtn8;
	private JLabel lblContactos;	
	private JPanel btnHomeI;
	private JPanel panelHistorial;
	private JLabel label;
	private JLabel lblAlumnoActual;
	private JPanel btnHomeII;
	private JLabel lblHomeII;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public AlumnoABMVistaPrincipal() {
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
		
		panelHistorial = new JPanel();
		panelHistorial.setLayout(null);
		panelHistorial.setBackground(new Color(23, 35, 51));
		panelHistorial.setBounds(0, 0, 200, 736);
		add(panelHistorial);
		
		btnHomeII = new JPanel();
		btnHomeII.setLayout(null);
		btnHomeII.setBackground(new Color(23, 35, 51));
		btnHomeII.setBounds(0, 0, 200, 64);
		panelHistorial.add(btnHomeII);
		
		lblHomeII = new JLabel("");
		lblHomeII.setIcon(new ImageIcon("imagenes/home.png"));
		lblHomeII.setBounds(78, 7, 48, 48);
		btnHomeII.add(lblHomeII);		
		
		label = new JLabel("Alumno");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(70, 64, 60, 26);
		panelHistorial.add(label);
		
		lblAlumnoActual = new JLabel("New label");
		lblAlumnoActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnoActual.setBounds(0, 112, 200, 100);
		panelHistorial.add(lblAlumnoActual);
		
		panelBtnHistorialAlumno = new JPanel();
		panelBtnHistorialAlumno.setBounds(0, 240, 200, 203);
		panelHistorial.add(panelBtnHistorialAlumno);
		panelBtnHistorialAlumno.setLayout(null);
		panelBtnHistorialAlumno.setBackground(new Color(23, 35, 51));
		
		btnNotas = new JPanel();
		btnNotas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNotas.setLayout(null);
		btnNotas.setBackground(new Color(23, 35, 51));
		btnNotas.setBounds(0, 0, 200, 50);
		panelBtnHistorialAlumno.add(btnNotas);
		
		lblTitleBtn5 = new JLabel("New label");
		lblTitleBtn5.setIcon(new ImageIcon("imagenes/history_32.png"));
		lblTitleBtn5.setBounds(10, 11, 32, 32);
		btnNotas.add(lblTitleBtn5);
		
		lblHistorialDeNotas = new JLabel("Historial de Notas");
		lblHistorialDeNotas.setForeground(Color.WHITE);
		lblHistorialDeNotas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHistorialDeNotas.setEnabled(true);
		lblHistorialDeNotas.setBounds(74, 25, 116, 14);
		btnNotas.add(lblHistorialDeNotas);
		
		btnAsistencias = new JPanel();
		btnAsistencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAsistencias.setLayout(null);
		btnAsistencias.setBackground(new Color(23, 35, 51));
		btnAsistencias.setBounds(0, 51, 200, 50);
		panelBtnHistorialAlumno.add(btnAsistencias);
		
		lblTitleBtn6 = new JLabel("New label");
		lblTitleBtn6.setIcon(new ImageIcon("imagenes/history_32.png"));
		lblTitleBtn6.setBounds(10, 11, 32, 32);
		btnAsistencias.add(lblTitleBtn6);
		
		lblHistorialDeInasistencias = new JLabel("Historial de Asistencias");
		lblHistorialDeInasistencias.setForeground(Color.WHITE);
		lblHistorialDeInasistencias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHistorialDeInasistencias.setEnabled(true);
		lblHistorialDeInasistencias.setBounds(74, 25, 116, 14);
		btnAsistencias.add(lblHistorialDeInasistencias);
		
		btnPagos = new JPanel();
		btnPagos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPagos.setLayout(null);
		btnPagos.setBackground(new Color(23, 35, 51));
		btnPagos.setBounds(0, 102, 200, 50);
		panelBtnHistorialAlumno.add(btnPagos);
		
		lblTitleBtn7 = new JLabel("New label");
		lblTitleBtn7.setIcon(new ImageIcon("imagenes/history_32.png"));
		lblTitleBtn7.setBounds(10, 11, 32, 32);
		btnPagos.add(lblTitleBtn7);
		
		lblHistorialDePagos = new JLabel("Historial de Pagos");
		lblHistorialDePagos.setForeground(Color.WHITE);
		lblHistorialDePagos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHistorialDePagos.setEnabled(true);
		lblHistorialDePagos.setBounds(74, 25, 116, 14);
		btnPagos.add(lblHistorialDePagos);
		
		btnContactos = new JPanel();
		btnContactos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnContactos.setLayout(null);
		btnContactos.setBackground(new Color(23, 35, 51));
		btnContactos.setBounds(0, 153, 200, 50);
		panelBtnHistorialAlumno.add(btnContactos);
		
		lblTitleBtn8 = new JLabel("New label");
		lblTitleBtn8.setIcon(new ImageIcon("imagenes/history_32.png"));
		lblTitleBtn8.setBounds(10, 11, 32, 32);
		btnContactos.add(lblTitleBtn8);
		
		lblContactos = new JLabel("Contactos");
		lblContactos.setForeground(Color.WHITE);
		lblContactos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactos.setEnabled(true);
		lblContactos.setBounds(74, 25, 116, 14);
		btnContactos.add(lblContactos);

		mainPanel = new JPanel();
		mainPanel.setBounds(200, 0, 1162, 736);
		add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setBackground(UIManager.getColor("Panel.background"));
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(62, 221, 89, 23);
		mainPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(60, 275, 89, 23);
		mainPanel.add(btnNewButton_1);
	}

	private void buildButtonPanel() {
		
		panelAbm = new JPanel();
		panelAbm.setBounds(0, 0, 200, 736);
		add(panelAbm);
		panelAbm.setLayout(null);
		panelAbm.setBackground(new Color(23, 35, 51));
		
		btnHomeI = new JPanel();
		btnHomeI.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHomeI.setBackground(new Color(23, 35, 51));
		btnHomeI.setBounds(0, 0, 200, 64);
		panelAbm.add(btnHomeI);
		btnHomeI.setLayout(null);

		lblHomeI = new JLabel("");
		lblHomeI.setBounds(78, 7, 48, 48);
		btnHomeI.add(lblHomeI);
		lblHomeI.setIcon(new ImageIcon("imagenes/home.png"));

		lblTitulo = new JLabel("Alumno");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(70, 64, 60, 26);
		panelAbm.add(lblTitulo);

		lblIconoPrincipal = new JLabel("New label");
		lblIconoPrincipal.setIcon(new ImageIcon("imagenes/alumno.png"));
		lblIconoPrincipal.setBounds(50, 111, 100, 100);
		panelAbm.add(lblIconoPrincipal);
		
		buildPanelBtnAbmAlumno();
		buildButtonVer();
		buildButtonAgregar();
		buildButtonActualizar();
		buildButtonEliminar();
	}

	private void buildPanelBtnAbmAlumno() {

		panelBtnAbmAlumno = new JPanel();
		panelBtnAbmAlumno.setBackground(new Color(23, 35, 51));
		panelBtnAbmAlumno.setBounds(0, 240, 200, 203);
		panelAbm.add(panelBtnAbmAlumno);
		panelBtnAbmAlumno.setLayout(null);
	}

	private void buildButtonVer() {
		
		btnVer = new JPanel();
		btnVer.setBounds(0, 0, 200, 50);
		panelBtnAbmAlumno.add(btnVer);
		btnVer.setLayout(null);
		btnVer.setBackground(new Color(23, 35, 51));
		btnVer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVer.setLayout(null);

		lblIconBtn1 = new JLabel("New label");
		lblIconBtn1.setIcon(new ImageIcon("imagenes/read.png"));
		lblIconBtn1.setBounds(10, 11, 32, 32);
		btnVer.add(lblIconBtn1);

		lblTitleBtn1 = new JLabel("Seleccionar Alumno");
		lblTitleBtn1.setForeground(Color.WHITE);
		lblTitleBtn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn1.setEnabled(true);
		lblTitleBtn1.setBounds(74, 25, 116, 14);
		btnVer.add(lblTitleBtn1);		
	}
	
	private void buildButtonAgregar() {
		
		btnAgregar = new JPanel();
		btnAgregar.setBounds(0, 51, 200, 50);
		panelBtnAbmAlumno.add(btnAgregar);
		btnAgregar.setLayout(null);
		btnAgregar.setBackground(new Color(23, 35, 51));
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregar.setLayout(null);

		lblIconBtn2 = new JLabel("New label");
		lblIconBtn2.setIcon(new ImageIcon("imagenes/create.png"));
		lblIconBtn2.setBounds(10, 11, 32, 32);
		btnAgregar.add(lblIconBtn2);

		lblTitleBtn2 = new JLabel("Agregar Alumno");
		lblTitleBtn2.setForeground(Color.WHITE);
		lblTitleBtn2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn2.setEnabled(true);
		lblTitleBtn2.setBounds(74, 25, 116, 14);
		btnAgregar.add(lblTitleBtn2);
	}
	
	private void buildButtonActualizar() {
		
		btnActualizar = new JPanel();
		btnActualizar.setBounds(0, 102, 200, 50);
		panelBtnAbmAlumno.add(btnActualizar);
		btnActualizar.setLayout(null);
		btnActualizar.setBackground(new Color(23, 35, 51));
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizar.setLayout(null);

		lblIconBtn3 = new JLabel("New label");
		lblIconBtn3.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn3.setBounds(10, 11, 32, 32);
		btnActualizar.add(lblIconBtn3);

		lblTitleBtn3 = new JLabel("Actualizar Alumno");
		lblTitleBtn3.setForeground(Color.WHITE);
		lblTitleBtn3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn3.setEnabled(true);
		lblTitleBtn3.setBounds(74, 25, 116, 14);
		btnActualizar.add(lblTitleBtn3);
	}

	private void buildButtonEliminar() {

		btnEliminar = new JPanel();
		btnEliminar.setBounds(0, 153, 200, 50);
		panelBtnAbmAlumno.add(btnEliminar);
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(23, 35, 51));
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminar.setLayout(null);

		lblIconBtn4 = new JLabel("New label");
		lblIconBtn4.setIcon(new ImageIcon("imagenes/delete.png"));
		lblIconBtn4.setBounds(10, 11, 32, 32);
		btnEliminar.add(lblIconBtn4);

		lblTitleBtn4 = new JLabel("Eliminar Alumno");
		lblTitleBtn4.setForeground(Color.WHITE);
		lblTitleBtn4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn4.setEnabled(true);
		lblTitleBtn4.setBounds(74, 25, 116, 14);
		btnEliminar.add(lblTitleBtn4);
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
	 * @return the btnVer
	 */
	public JPanel getBtnVer() {
		return btnVer;
	}

	/**
	 * @param btnVer the btnVer to set
	 */
	public void setBtnVer(JPanel btnVer) {
		this.btnVer = btnVer;
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
	 * @return the panelBtnAbmAlumno
	 */
	public JPanel getPanelBtnAbmAlumno() {
		return panelBtnAbmAlumno;
	}

	/**
	 * @param panelBtnAbmAlumno the panelBtnAbmAlumno to set
	 */
	public void setPanelBtnAbmAlumno(JPanel panelBtnAbmAlumno) {
		this.panelBtnAbmAlumno = panelBtnAbmAlumno;
	}

	/**
	 * @return the panelBtnHistorialAlumno
	 */
	public JPanel getPanelBtnHistorialAlumno() {
		return panelBtnHistorialAlumno;
	}

	/**
	 * @param panelBtnHistorialAlumno the panelBtnHistorialAlumno to set
	 */
	public void setPanelBtnHistorialAlumno(JPanel panelBtnHistorialAlumno) {
		this.panelBtnHistorialAlumno = panelBtnHistorialAlumno;
	}

	/**
	 * @return the btnNotas
	 */
	public JPanel getBtnNotas() {
		return btnNotas;
	}

	/**
	 * @param btnNotas the btnNotas to set
	 */
	public void setBtnNotas(JPanel btnNotas) {
		this.btnNotas = btnNotas;
	}

	/**
	 * @return the btnAsistencias
	 */
	public JPanel getBtnAsistencias() {
		return btnAsistencias;
	}

	/**
	 * @param btnAsistencias the btnAsistencias to set
	 */
	public void setBtnAsistencias(JPanel btnAsistencias) {
		this.btnAsistencias = btnAsistencias;
	}

	/**
	 * @return the btnPagos
	 */
	public JPanel getBtnPagos() {
		return btnPagos;
	}

	/**
	 * @param btnPagos the btnPagos to set
	 */
	public void setBtnPagos(JPanel btnPagos) {
		this.btnPagos = btnPagos;
	}

	/**
	 * @return the btnContactos
	 */
	public JPanel getBtnContactos() {
		return btnContactos;
	}

	/**
	 * @param btnContactos the btnContactos to set
	 */
	public void setBtnContactos(JPanel btnContactos) {
		this.btnContactos = btnContactos;
	}

	/**
	 * @return the panelAbm
	 */
	public JPanel getPanelAbm() {
		return panelAbm;
	}

	/**
	 * @param panelAbm the panelAbm to set
	 */
	public void setPanelAbm(JPanel panelAbm) {
		this.panelAbm = panelAbm;
	}

	/**
	 * @return the btnHomeI
	 */
	public JPanel getBtnHomeI() {
		return btnHomeI;
	}

	/**
	 * @param btnHomeI the btnHomeI to set
	 */
	public void setBtnHomeI(JPanel btnHomeI) {
		this.btnHomeI = btnHomeI;
	}

	/**
	 * @return the panelHistorial
	 */
	public JPanel getPanelHistorial() {
		return panelHistorial;
	}

	/**
	 * @param panelHistorial the panelHistorial to set
	 */
	public void setPanelHistorial(JPanel panelHistorial) {
		this.panelHistorial = panelHistorial;
	}

	/**
	 * @return the btnHomeII
	 */
	public JPanel getBtnHomeII() {
		return btnHomeII;
	}

	/**
	 * @param btnHomeII the btnHomeII to set
	 */
	public void setBtnHomeII(JPanel btnHomeII) {
		this.btnHomeII = btnHomeII;
	}

	/**
	 * @return the btnNewButton
	 */
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	/**
	 * @param btnNewButton the btnNewButton to set
	 */
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	/**
	 * @return the btnNewButton_1
	 */
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	/**
	 * @param btnNewButton_1 the btnNewButton_1 to set
	 */
	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	/**
	 * @return the lblAlumnoActual
	 */
	public JLabel getLblAlumnoActual() {
		return lblAlumnoActual;
	}

	/**
	 * @param lblAlumnoActual the lblAlumnoActual to set
	 */
	public void setLblAlumnoActual(JLabel lblAlumnoActual) {
		this.lblAlumnoActual = lblAlumnoActual;
	}
}
