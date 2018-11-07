package presentacion.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ADescarteAdministracionDeCursosVista extends JFrame {

	private JFrame frame;
	private JPanel mainPanel;
	private JMenuBar menuBar;
	
	private JMenu menuLogin;
	private JMenuItem menuItemLogin;
	private JMenuItem menuItemLogout;	
	
	private JMenu menuUsuario;
	private JMenuItem menuItemAgregarUsuario;
	private JMenuItem menuItemActualizarUsuario;
	private JMenuItem menuItemEliminarUsuario;	
	
	private JMenu menuCursada;
	private JMenuItem menuItemAgregarCursada;
	private JMenuItem menuItemActualizarCursada;
	private JMenuItem menuItemEliminarCursada;
	private JMenuItem menuItemAddAlumno;
	private JMenuItem menuItemAddSala;
	private JMenuItem menuItemAddHorario;
	private JMenuItem menuItemAddInstructor;	
	
	private JMenu menuAlumno;
	private JMenuItem menuItemAgregarAlumno;
	private JMenuItem menuItemActualizarAlumno;
	private JMenuItem menuItemEliminarAlumno;
	private JMenuItem menuItemSeleccionarAlumno;

	/**
	 * Create the frame.
	 */
	public ADescarteAdministracionDeCursosVista() {
		super();		
		initialize();		
	}
	
	private void initialize() {
		
		this.frame = new JFrame();
		this.frame.setBounds(0, 0, 1366, 768);
		this.frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
		this.frame.setLayout( new FlowLayout() );
		this.frame.setVisible( true );
		
		buildMenuBar();		
		this.frame.setJMenuBar(menuBar);
	}
	
	private void buildMenuBar() {

		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(Color.DARK_GRAY);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1366, 768);
		this.frame.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		buildMenuLogin();
		menuBar.add(menuLogin);
		
		buildMenuUsuario();
		menuBar.add(menuUsuario);
		
		buildMenuCursada();
		menuBar.add(menuCursada);
		
		buildMenuAlumno();
		menuBar.add(menuAlumno);
	}
	
	private void buildMenuLogin() {

		menuLogin = new JMenu("Login");
		menuLogin.setMnemonic(KeyEvent.VK_A);
		menuLogin.getAccessibleContext().setAccessibleDescription(
		        "");
		menuBar.add(menuLogin);
		
		menuItemLogin = new JMenuItem("Cambiar de Usuario");
		menuLogin.add(menuItemLogin);
		
		menuItemLogout = new JMenuItem("Salir del Sistema");
		menuLogin.add(menuItemLogout);		
	}

	private void buildMenuAlumno() {
		
		menuAlumno = new JMenu("Alumno");
		menuAlumno.setMnemonic(KeyEvent.VK_A);
		menuAlumno.getAccessibleContext().setAccessibleDescription(
		        "");
		menuBar.add(menuAlumno);		
		
		menuItemAgregarAlumno =new JMenuItem("Agregar Nuevo Alumno");
		menuAlumno.add(menuItemAgregarAlumno);
		
		menuItemActualizarAlumno =new JMenuItem("Actualizar Alumno");
		menuAlumno.add(menuItemActualizarAlumno);
		
		menuItemEliminarAlumno =new JMenuItem("Eliminar Alumno");
		menuAlumno.add(menuItemEliminarAlumno);		
		
		menuItemSeleccionarAlumno = new JMenuItem("Seleccionar Alumno");
		menuAlumno.add(menuItemSeleccionarAlumno);
	}

	private void buildMenuUsuario() {

		menuUsuario = new JMenu("Usuario");
		menuUsuario.setMnemonic(KeyEvent.VK_A);
		menuUsuario.getAccessibleContext().setAccessibleDescription(
		        "");
		menuBar.add(menuUsuario);

		menuItemAgregarUsuario = new JMenuItem("Agregar Nuevo Usuario");
		menuUsuario.add(menuItemAgregarUsuario);	
		
		menuItemActualizarUsuario = new JMenuItem("Actualizar Usuario");
		menuUsuario.add(menuItemActualizarUsuario);
		
		menuItemEliminarUsuario = new JMenuItem("Eliminar Usuario");
		menuUsuario.add(menuItemEliminarUsuario);		
	}
	
	private void buildMenuCursada() {
		
		menuCursada = new JMenu("Cursada");
		menuCursada.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuCursada);

		menuItemAgregarCursada = new JMenuItem("Agregar Cursada");
		menuCursada.add(menuItemAgregarCursada);
		
		menuItemActualizarCursada = new JMenuItem("Actualizar Cursada");
		menuCursada.add(menuItemActualizarCursada);
		
		menuItemEliminarCursada = new JMenuItem("Eliminar Cursada");
		menuCursada.add(menuItemEliminarCursada );
		
		menuItemAddAlumno = new JMenuItem("Agregar Alumnos a Cursada");
		menuCursada.add(menuItemAddAlumno);
		
		menuItemAddSala = new JMenuItem("Seleccionar Cursada");
		menuCursada.add(menuItemAddSala );
		
		menuItemAddHorario = new JMenuItem("Dias & Horarios");
		menuCursada.add(menuItemAddHorario);
		
		menuItemAddInstructor = new JMenuItem("Agregar Instructor");
		menuCursada.add(menuItemAddInstructor);
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
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
	 * @return the menuLogin
	 */
	public JMenu getMenuLogin() {
		return menuLogin;
	}

	/**
	 * @param menuLogin the menuLogin to set
	 */
	public void setMenuLogin(JMenu menuLogin) {
		this.menuLogin = menuLogin;
	}

	/**
	 * @return the menuItemLogin
	 */
	public JMenuItem getMenuItemLogin() {
		return menuItemLogin;
	}

	/**
	 * @param menuItemLogin the menuItemLogin to set
	 */
	public void setMenuItemLogin(JMenuItem menuItemLogin) {
		this.menuItemLogin = menuItemLogin;
	}

	/**
	 * @return the menuItemLogout
	 */
	public JMenuItem getMenuItemLogout() {
		return menuItemLogout;
	}

	/**
	 * @param menuItemLogout the menuItemLogout to set
	 */
	public void setMenuItemLogout(JMenuItem menuItemLogout) {
		this.menuItemLogout = menuItemLogout;
	}

	/**
	 * @return the menuUsuario
	 */
	public JMenu getMenuUsuario() {
		return menuUsuario;
	}

	/**
	 * @param menuUsuario the menuUsuario to set
	 */
	public void setMenuUsuario(JMenu menuUsuario) {
		this.menuUsuario = menuUsuario;
	}

	/**
	 * @return the menuItemAgregarUsuario
	 */
	public JMenuItem getMenuItemAgregarUsuario() {
		return menuItemAgregarUsuario;
	}

	/**
	 * @param menuItemAgregarUsuario the menuItemAgregarUsuario to set
	 */
	public void setMenuItemAgregarUsuario(JMenuItem menuItemAgregarUsuario) {
		this.menuItemAgregarUsuario = menuItemAgregarUsuario;
	}

	/**
	 * @return the menuItemActualizarUsuario
	 */
	public JMenuItem getMenuItemActualizarUsuario() {
		return menuItemActualizarUsuario;
	}

	/**
	 * @param menuItemActualizarUsuario the menuItemActualizarUsuario to set
	 */
	public void setMenuItemActualizarUsuario(JMenuItem menuItemActualizarUsuario) {
		this.menuItemActualizarUsuario = menuItemActualizarUsuario;
	}

	/**
	 * @return the menuItemEliminarUsuario
	 */
	public JMenuItem getMenuItemEliminarUsuario() {
		return menuItemEliminarUsuario;
	}

	/**
	 * @param menuItemEliminarUsuario the menuItemEliminarUsuario to set
	 */
	public void setMenuItemEliminarUsuario(JMenuItem menuItemEliminarUsuario) {
		this.menuItemEliminarUsuario = menuItemEliminarUsuario;
	}

	/**
	 * @return the menuCursada
	 */
	public JMenu getMenuCursada() {
		return menuCursada;
	}

	/**
	 * @param menuCursada the menuCursada to set
	 */
	public void setMenuCursada(JMenu menuCursada) {
		this.menuCursada = menuCursada;
	}

	/**
	 * @return the menuItemAgregarCursada
	 */
	public JMenuItem getMenuItemAgregarCursada() {
		return menuItemAgregarCursada;
	}

	/**
	 * @param menuItemAgregarCursada the menuItemAgregarCursada to set
	 */
	public void setMenuItemAgregarCursada(JMenuItem menuItemAgregarCursada) {
		this.menuItemAgregarCursada = menuItemAgregarCursada;
	}

	/**
	 * @return the menuItemActualizarCursada
	 */
	public JMenuItem getMenuItemActualizarCursada() {
		return menuItemActualizarCursada;
	}

	/**
	 * @param menuItemActualizarCursada the menuItemActualizarCursada to set
	 */
	public void setMenuItemActualizarCursada(JMenuItem menuItemActualizarCursada) {
		this.menuItemActualizarCursada = menuItemActualizarCursada;
	}

	/**
	 * @return the menuItemEliminarCursada
	 */
	public JMenuItem getMenuItemEliminarCursada() {
		return menuItemEliminarCursada;
	}

	/**
	 * @param menuItemEliminarCursada the menuItemEliminarCursada to set
	 */
	public void setMenuItemEliminarCursada(JMenuItem menuItemEliminarCursada) {
		this.menuItemEliminarCursada = menuItemEliminarCursada;
	}

	/**
	 * @return the menuItemAddAlumno
	 */
	public JMenuItem getMenuItemAddAlumno() {
		return menuItemAddAlumno;
	}

	/**
	 * @param menuItemAddAlumno the menuItemAddAlumno to set
	 */
	public void setMenuItemAddAlumno(JMenuItem menuItemAddAlumno) {
		this.menuItemAddAlumno = menuItemAddAlumno;
	}

	/**
	 * @return the menuItemAddSala
	 */
	public JMenuItem getMenuItemAddSala() {
		return menuItemAddSala;
	}

	/**
	 * @param menuItemAddSala the menuItemAddSala to set
	 */
	public void setMenuItemAddSala(JMenuItem menuItemAddSala) {
		this.menuItemAddSala = menuItemAddSala;
	}

	/**
	 * @return the menuItemAddHorario
	 */
	public JMenuItem getMenuItemAddHorario() {
		return menuItemAddHorario;
	}

	/**
	 * @param menuItemAddHorario the menuItemAddHorario to set
	 */
	public void setMenuItemAddHorario(JMenuItem menuItemAddHorario) {
		this.menuItemAddHorario = menuItemAddHorario;
	}

	/**
	 * @return the menuItemAddInstructor
	 */
	public JMenuItem getMenuItemAddInstructor() {
		return menuItemAddInstructor;
	}

	/**
	 * @param menuItemAddInstructor the menuItemAddInstructor to set
	 */
	public void setMenuItemAddInstructor(JMenuItem menuItemAddInstructor) {
		this.menuItemAddInstructor = menuItemAddInstructor;
	}

	/**
	 * @return the menuAlumno
	 */
	public JMenu getMenuAlumno() {
		return menuAlumno;
	}

	/**
	 * @param menuAlumno the menuAlumno to set
	 */
	public void setMenuAlumno(JMenu menuAlumno) {
		this.menuAlumno = menuAlumno;
	}

	/**
	 * @return the menuItemAgregarAlumno
	 */
	public JMenuItem getMenuItemAgregarAlumno() {
		return menuItemAgregarAlumno;
	}

	/**
	 * @param menuItemAgregarAlumno the menuItemAgregarAlumno to set
	 */
	public void setMenuItemAgregarAlumno(JMenuItem menuItemAgregarAlumno) {
		this.menuItemAgregarAlumno = menuItemAgregarAlumno;
	}

	/**
	 * @return the menuItemActualizarAlumno
	 */
	public JMenuItem getMenuItemActualizarAlumno() {
		return menuItemActualizarAlumno;
	}

	/**
	 * @param menuItemActualizarAlumno the menuItemActualizarAlumno to set
	 */
	public void setMenuItemActualizarAlumno(JMenuItem menuItemActualizarAlumno) {
		this.menuItemActualizarAlumno = menuItemActualizarAlumno;
	}

	/**
	 * @return the menuItemEliminarAlumno
	 */
	public JMenuItem getMenuItemEliminarAlumno() {
		return menuItemEliminarAlumno;
	}

	/**
	 * @param menuItemEliminarAlumno the menuItemEliminarAlumno to set
	 */
	public void setMenuItemEliminarAlumno(JMenuItem menuItemEliminarAlumno) {
		this.menuItemEliminarAlumno = menuItemEliminarAlumno;
	}

	/**
	 * @return the menuItemSeleccionarAlumno
	 */
	public JMenuItem getMenuItemSeleccionarAlumno() {
		return menuItemSeleccionarAlumno;
	}

	/**
	 * @param menuItemSeleccionarAlumno the menuItemSeleccionarAlumno to set
	 */
	public void setMenuItemSeleccionarAlumno(JMenuItem menuItemSeleccionarAlumno) {
		this.menuItemSeleccionarAlumno = menuItemSeleccionarAlumno;
	}

}
