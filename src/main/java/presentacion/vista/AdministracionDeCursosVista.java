package presentacion.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AdministracionDeCursosVista {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JMenuBar menuBar;
	
	private JMenu menuAlumno;
	private JMenuItem menuItemAlumnoVer;
	
	private JMenu menuCursada;
	
	private JMenu menuCurso;
	private JMenuItem menuItemCursoVer;
	
	private JMenu menuLogin;
	private JMenuItem menuItemLogin;
	private JMenuItem menuItemLogout;
	
	private JMenu menuUsuario;
	private JMenuItem menuItemUsuarioVer;
	

	
	/**
	 * Create the frame.
	 */
	public AdministracionDeCursosVista() {
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

		buildMenuAlumno();
		menuBar.add(menuAlumno);
		
		buildMenuCurso();
		menuBar.add(menuCurso);

		buildMenuCursada();
		menuBar.add(menuCursada);

		buildMenuUsuario();
		menuBar.add(menuUsuario);
	}

	private void buildMenuAlumno() {
		
		menuAlumno = new JMenu("Alumno");
		menuAlumno.setMnemonic(KeyEvent.VK_A);
		menuAlumno.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuAlumno);
		
		menuItemAlumnoVer = new JMenuItem("Ver Alumno");
		menuAlumno.add(menuItemAlumnoVer);
	}
	
	private void buildMenuCurso() {

		menuCurso = new JMenu("Curso");
		menuCurso.setMnemonic(KeyEvent.VK_A);
		menuCurso.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuCurso);
		
		menuItemCursoVer = new JMenuItem("Ver Curso");
		menuCurso.add(menuItemCursoVer);
	}

	private void buildMenuCursada() {
		
		menuCursada = new JMenu("Cursada");
		menuCursada.setMnemonic(KeyEvent.VK_A);
		menuCursada.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuCursada);		
	}

	private void buildMenuLogin() {
		
		menuLogin = new JMenu("Login");
		menuLogin.setMnemonic(KeyEvent.VK_A);
		menuLogin.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuLogin);
		
		menuItemLogin = new JMenuItem("Cambiar de Usuario");
		menuLogin.add(menuItemLogin);

		menuItemLogout = new JMenuItem("Salir del Sistema");
		menuLogin.add(menuItemLogout);		
	}

	private void buildMenuUsuario() {
		
		menuUsuario = new JMenu("Usuario");
		menuUsuario.setMnemonic(KeyEvent.VK_U);
		menuUsuario.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuUsuario);	
		
		menuItemUsuarioVer = new JMenuItem("Ver Usuario");
		menuUsuario.add(menuItemUsuarioVer);
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
	 * @return the menuBar
	 */
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
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
	 * @return the menuItemAlumnoVer
	 */
	public JMenuItem getMenuItemAlumnoVer() {
		return menuItemAlumnoVer;
	}

	/**
	 * @param menuItemAlumnoVer the menuItemAlumnoVer to set
	 */
	public void setMenuItemAlumnoVer(JMenuItem menuItemAlumnoVer) {
		this.menuItemAlumnoVer = menuItemAlumnoVer;
	}

	/**
	 * @return the menuItemUsuarioVer
	 */
	public JMenuItem getMenuItemUsuarioVer() {
		return menuItemUsuarioVer;
	}

	/**
	 * @param menuItemUsuarioVer the menuItemUsuarioVer to set
	 */
	public void setMenuItemUsuarioVer(JMenuItem menuItemUsuarioVer) {
		this.menuItemUsuarioVer = menuItemUsuarioVer;
	}

	/**
	 * @return the menuCurso
	 */
	public JMenu getMenuCurso() {
		return menuCurso;
	}

	/**
	 * @param menuCurso the menuCurso to set
	 */
	public void setMenuCurso(JMenu menuCurso) {
		this.menuCurso = menuCurso;
	}

	/**
	 * @return the menuItemCursoVer
	 */
	public JMenuItem getMenuItemCursoVer() {
		return menuItemCursoVer;
	}

	/**
	 * @param menuItemCursoVer the menuItemCursoVer to set
	 */
	public void setMenuItemCursoVer(JMenuItem menuItemCursoVer) {
		this.menuItemCursoVer = menuItemCursoVer;
	}

}
