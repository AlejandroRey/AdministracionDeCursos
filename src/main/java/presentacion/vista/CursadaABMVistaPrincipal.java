package presentacion.vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class CursadaABMVistaPrincipal extends JPanel {
	
	private JPanel mainPanel;
	
	private JPanel buttonPanel;	
	
	private JLabel lblHome;
	private JLabel lblCursada;
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
	
	private JPanel buttonPanelExtends;
	private JPanel btnCalendario;
	private JLabel lblIconBtn5;
	private JLabel lblTitleBtn5;
	
	private JPanel btnInscriptos;
	private JLabel lblIconBtn6;
	private JLabel lblTitleBtn6;
	
	private JPanel btnPagos;
	private JLabel lblIconBtn7;
	private JLabel lblTitleBtn7;
	
	private JPanel btnAsistencias;
	private JLabel lblIconBtn8;
	private JLabel lblTitleBtn8;
	
	private JPanel btnEvaluaciones;
	private JLabel lblIconBtn9;
	private JLabel lblTitleBtn9;
	
	private JPanel btnHomeII;
	private JLabel lblHomeII;
	
	private JLabel lblTituloII;
	private JTextArea textAreaCursadaSeleccionada;
	private JPanel btnHome;

	/**
	 * Create the panel.
	 */
	public CursadaABMVistaPrincipal() {
		super();
		this.setBounds(0, 0, 1366, 768);
		this.setLayout(null);
		
		initialize();
	}

	private void initialize() {
		buildButtonPanel();
		buildButtonPanelExtends();
		buildMainPanel();	
	}
	
	private void buildButtonPanel() {
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, 200, 736);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(Color.DARK_GRAY);
		
		btnSeleccionar = new JPanel();
		btnSeleccionar.setLayout(null);
		btnSeleccionar.setBackground(Color.DARK_GRAY);
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
		
		btnAgregar = new JPanel();
		btnAgregar.setLayout(null);
		btnAgregar.setBackground(Color.DARK_GRAY);
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
		
		btnActualizar = new JPanel();
		btnActualizar.setLayout(null);
		btnActualizar.setBackground(Color.DARK_GRAY);
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
		
		btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(Color.DARK_GRAY);
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
		
		lblCursada = new JLabel("Cursada");
		lblCursada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCursada.setForeground(Color.WHITE);
		lblCursada.setBounds(69, 57, 63, 26);
		buttonPanel.add(lblCursada);
		
		lblIconoPrincipal = new JLabel("New label");
		lblIconoPrincipal.setIcon(new ImageIcon("imagenes/cursada.png"));
		lblIconoPrincipal.setBounds(49, 94, 100, 100);
		buttonPanel.add(lblIconoPrincipal);		
		
		btnHome = new JPanel();
		btnHome.setBackground(Color.DARK_GRAY);
		btnHome.setBounds(0, 0, 200, 60);
		buttonPanel.add(btnHome);
		btnHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHome.setLayout(null);		
		
		lblHome = new JLabel("New label");
		lblHome.setIcon(new ImageIcon("imagenes/home.png"));
		lblHome.setBounds(82, 5, 48, 48);
		btnHome.add(lblHome);
	}

	private void buildButtonPanelExtends() {

		buttonPanelExtends = new JPanel();
		buttonPanelExtends.setLayout(null);
		buttonPanelExtends.setBackground(Color.DARK_GRAY);
		buttonPanelExtends.setBounds(0, 0, 200, 736);
		add(buttonPanelExtends);
		
		btnCalendario = new JPanel();
		btnCalendario.setLayout(null);
		btnCalendario.setBackground(Color.DARK_GRAY);
		btnCalendario.setBounds(0, 219, 200, 50);
		buttonPanelExtends.add(btnCalendario);
		btnCalendario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblIconBtn5 = new JLabel("New label");
		lblIconBtn5.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn5.setBounds(10, 11, 32, 32);
		btnCalendario.add(lblIconBtn5);
		
		lblTitleBtn5 = new JLabel("Calendario");
		lblTitleBtn5.setForeground(Color.WHITE);
		lblTitleBtn5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn5.setEnabled(true);
		lblTitleBtn5.setBounds(74, 25, 116, 14);
		btnCalendario.add(lblTitleBtn5);
		
		btnInscriptos = new JPanel();
		btnInscriptos.setLayout(null);
		btnInscriptos.setBackground(Color.DARK_GRAY);
		btnInscriptos.setBounds(0, 269, 200, 50);
		buttonPanelExtends.add(btnInscriptos);
		btnInscriptos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblIconBtn6 = new JLabel("New label");
		lblIconBtn6.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn6.setBounds(10, 11, 32, 32);
		btnInscriptos.add(lblIconBtn6);
		
		lblTitleBtn6 = new JLabel("Inscriptos");
		lblTitleBtn6.setForeground(Color.WHITE);
		lblTitleBtn6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn6.setEnabled(true);
		lblTitleBtn6.setBounds(74, 25, 116, 14);
		btnInscriptos.add(lblTitleBtn6);
		
		btnPagos = new JPanel();
		btnPagos.setLayout(null);
		btnPagos.setBackground(Color.DARK_GRAY);
		btnPagos.setBounds(0, 319, 200, 50);
		buttonPanelExtends.add(btnPagos);
		btnPagos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblIconBtn7 = new JLabel("New label");
		lblIconBtn7.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn7.setBounds(10, 11, 32, 32);
		btnPagos.add(lblIconBtn7);
		
		lblTitleBtn7 = new JLabel("Pagos");
		lblTitleBtn7.setForeground(Color.WHITE);
		lblTitleBtn7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn7.setEnabled(true);
		lblTitleBtn7.setBounds(74, 25, 116, 14);
		btnPagos.add(lblTitleBtn7);
		
		btnAsistencias = new JPanel();
		btnAsistencias.setLayout(null);
		btnAsistencias.setBackground(Color.DARK_GRAY);
		btnAsistencias.setBounds(0, 368, 200, 50);
		buttonPanelExtends.add(btnAsistencias);
		btnAsistencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblIconBtn8 = new JLabel("New label");
		lblIconBtn8.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn8.setBounds(10, 11, 32, 32);
		btnAsistencias.add(lblIconBtn8);
		
		lblTitleBtn8 = new JLabel("Asistencia");
		lblTitleBtn8.setForeground(Color.WHITE);
		lblTitleBtn8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn8.setEnabled(true);
		lblTitleBtn8.setBounds(74, 25, 116, 14);
		btnAsistencias.add(lblTitleBtn8);
		
		btnEvaluaciones = new JPanel();
		btnEvaluaciones.setLayout(null);
		btnEvaluaciones.setBackground(Color.DARK_GRAY);
		btnEvaluaciones.setBounds(0, 417, 200, 50);
		buttonPanelExtends.add(btnEvaluaciones);
		btnEvaluaciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblIconBtn9 = new JLabel("New label");
		lblIconBtn9.setIcon(new ImageIcon("imagenes/update.png"));
		lblIconBtn9.setBounds(10, 11, 32, 32);
		btnEvaluaciones.add(lblIconBtn9);
		
		lblTitleBtn9 = new JLabel("Evaluaciones");
		lblTitleBtn9.setForeground(Color.WHITE);
		lblTitleBtn9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitleBtn9.setEnabled(true);
		lblTitleBtn9.setBounds(74, 25, 116, 14);
		btnEvaluaciones.add(lblTitleBtn9);
		
		lblTituloII = new JLabel("Cursada");
		lblTituloII.setForeground(Color.WHITE);
		lblTituloII.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloII.setBounds(69, 57, 63, 26);
		buttonPanelExtends.add(lblTituloII);
		
		textAreaCursadaSeleccionada = new JTextArea("Cursada" + System.lineSeparator() + "Seleccionada");
		textAreaCursadaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaCursadaSeleccionada.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textAreaCursadaSeleccionada.setBackground(Color.DARK_GRAY);
		textAreaCursadaSeleccionada.setForeground(Color.WHITE);
		textAreaCursadaSeleccionada.setEditable(false);
		textAreaCursadaSeleccionada.setBounds(5, 83, 190, 120);
		buttonPanelExtends.add(textAreaCursadaSeleccionada);		
		
		btnHomeII = new JPanel();
		btnHomeII.setBackground(Color.DARK_GRAY);
		btnHomeII.setBounds(0, 0, 200, 60);
		buttonPanelExtends.add(btnHomeII);
		btnHomeII.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHomeII.setLayout(null);
		
		lblHomeII = new JLabel("New label");
		lblHomeII.setIcon(new ImageIcon("imagenes/home.png"));
		lblHomeII.setBounds(82, 5, 48, 48);
		btnHomeII.add(lblHomeII);
	}

	private void buildMainPanel() {

		mainPanel = new JPanel();
		mainPanel.setBounds(200, 0, 1162, 736);
		add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setBackground(UIManager.getColor("Panel.background"));
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
	 * @return the buttonPanelExtends
	 */
	public JPanel getButtonPanelExtends() {
		return buttonPanelExtends;
	}

	/**
	 * @param buttonPanelExtends the buttonPanelExtends to set
	 */
	public void setButtonPanelExtends(JPanel buttonPanelExtends) {
		this.buttonPanelExtends = buttonPanelExtends;
	}

	/**
	 * @return the btnCalendario
	 */
	public JPanel getBtnCalendario() {
		return btnCalendario;
	}

	/**
	 * @param btnCalendario the btnCalendario to set
	 */
	public void setBtnCalendario(JPanel btnCalendario) {
		this.btnCalendario = btnCalendario;
	}

	/**
	 * @return the btnInscriptos
	 */
	public JPanel getBtnInscriptos() {
		return btnInscriptos;
	}

	/**
	 * @param btnInscriptos the btnInscriptos to set
	 */
	public void setBtnInscriptos(JPanel btnInscriptos) {
		this.btnInscriptos = btnInscriptos;
	}

	/**
	 * @return the btnPSagos
	 */
	public JPanel getBtnPagos() {
		return btnPagos;
	}

	/**
	 * @param btnPSagos the btnPSagos to set
	 */
	public void setBtnPagos(JPanel btnPagos) {
		this.btnPagos = btnPagos;
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
	 * @return the btnEvaluaciones
	 */
	public JPanel getBtnEvaluaciones() {
		return btnEvaluaciones;
	}

	/**
	 * @param btnEvaluaciones the btnEvaluaciones to set
	 */
	public void setBtnEvaluaciones(JPanel btnEvaluaciones) {
		this.btnEvaluaciones = btnEvaluaciones;
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
	 * @return the textAreaCursadaSeleccionada
	 */
	public JTextArea getTextAreaCursadaSeleccionada() {
		return textAreaCursadaSeleccionada;
	}

	/**
	 * @param textAreaCursadaSeleccionada the textAreaCursadaSeleccionada to set
	 */
	public void setTextAreaCursadaSeleccionada(JTextArea textAreaCursadaSeleccionada) {
		this.textAreaCursadaSeleccionada = textAreaCursadaSeleccionada;
	}

	/**
	 * @return the btnHome
	 */
	public JPanel getBtnHome() {
		return btnHome;
	}

	/**
	 * @param btnHome the btnHome to set
	 */
	public void setBtnHome(JPanel btnHome) {
		this.btnHome = btnHome;
	}

}
