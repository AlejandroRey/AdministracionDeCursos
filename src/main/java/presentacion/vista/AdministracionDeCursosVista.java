package presentacion.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class AdministracionDeCursosVista {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JMenuBar menuBar;
	
	private JMenu menuAlumno;
	private JMenuItem menuItemAlumnoVer;
	
	private JMenu menuContacto;
	private JMenuItem menuItemContactoVer;
	
	private JMenu menuCursada;
	private JMenuItem menuItemCursadaVer;
	
	private JMenu menuCurso;
	private JMenuItem menuItemCursoVer;
	
	private JMenu menuLogin;
	private JMenuItem menuItemLogin;
	private JMenuItem menuItemLogout;
	private JMenuItem menuItemCambiarContraseña;
	
	private JMenu menuUsuario;
	private JMenuItem menuItemUsuarioVer;
	
	private JMenu menuTarea;
	private JMenuItem menuItemTareaVer;
	
	private JMenu menuSala;
	private JMenuItem menuItemSalaVer;
	
	private JMenu menuNotificaciones;
	private JMenuItem menuItemNotificacionesVer;
	
	private JMenu menuRecados;
	private JMenuItem menuItemRecadosVer;

	
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
		this.frame.getContentPane().setLayout( new FlowLayout() );
		this.frame.setVisible( true );
		
		buildMenuBar();		
		this.frame.setJMenuBar(menuBar);
	}
	
	private void buildMenuBar() {

		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(Color.DARK_GRAY);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mainPanel.setBounds(0, 0, 1366, 768);
		this.frame.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		buildMenuLogin();
		buildMenuAlumno();
		buildMenuCurso();
		buildMenuCursada();
		buildMenuUsuario();
		buildMenuTarea();
		buildMenuSala();
		buildMenuContacto();
		buildMenuRecados();
		buildMenuNotificaciones();
	}

	private void buildMenuAlumno() {
		
		menuAlumno = new JMenu("Alumno");
		menuAlumno.setMnemonic(KeyEvent.VK_A);
		menuAlumno.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuAlumno);
		
		menuItemAlumnoVer = new JMenuItem("Ver Alumno");
		menuAlumno.add(menuItemAlumnoVer);
	}
	
	private void buildMenuContacto() {
		menuContacto = new JMenu("Contacto");
		menuContacto.setMnemonic(KeyEvent.VK_C);
		menuContacto.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuContacto);
		
		menuItemContactoVer = new JMenuItem("Ver Contacto");
		menuContacto.add(menuItemContactoVer);
	}
	
	private void buildMenuCurso() {

		menuCurso = new JMenu("Curso");
		menuCurso.setMnemonic(KeyEvent.VK_0);
		menuCurso.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuCurso);
		
		menuItemCursoVer = new JMenuItem("Ver Curso");
		menuCurso.add(menuItemCursoVer);
	}

	private void buildMenuCursada() {
		
		menuCursada = new JMenu("Cursada");
		menuCursada.setMnemonic(KeyEvent.VK_K);
		menuCursada.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuCursada);
		
		menuItemCursadaVer = new JMenuItem("Ver Cursada");
		menuCursada.add(menuItemCursadaVer);
	}

	private void buildMenuLogin() {
		
		menuLogin = new JMenu("Login");
		menuLogin.setMnemonic(KeyEvent.VK_L);
		menuLogin.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuLogin);
		
		menuItemLogin = new JMenuItem("Cambiar de Usuario");
		menuLogin.add(menuItemLogin);

		menuItemLogout = new JMenuItem("Salir del Sistema");
		menuLogin.add(menuItemLogout);		
	}

	private void buildMenuUsuario() {
		
		menuUsuario = new JMenu("Instructores");
		menuUsuario.setMnemonic(KeyEvent.VK_I);
		menuUsuario.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuUsuario);	
		
		menuItemUsuarioVer = new JMenuItem("Ver Instructores");
		menuUsuario.add(menuItemUsuarioVer);
	}
	
	private void buildMenuTarea() {
		menuTarea = new JMenu("Tarea");
		menuTarea.setMnemonic(KeyEvent.VK_T);
		menuTarea.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuTarea);
		
		menuItemTareaVer = new JMenuItem("Ver Tarea");
		menuTarea.add(menuItemTareaVer);
	}

	private void buildMenuSala() {
		menuSala = new JMenu("Sala");
		menuSala.setMnemonic(KeyEvent.VK_S);
		menuSala.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuSala);
		
		menuItemSalaVer = new JMenuItem("Ver Sala");
		menuSala.add(menuItemSalaVer);
	}
	
	private void buildMenuRecados() {
		menuRecados = new JMenu("Recados");
		menuRecados.setMnemonic(KeyEvent.VK_R);
		menuRecados.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuRecados);
		
		menuItemRecadosVer = new JMenuItem("Ver Recados");
		menuRecados.add(menuItemRecadosVer);
	}
	
	private void buildMenuNotificaciones() {
		menuNotificaciones = new JMenu("Notificaciones");
		menuNotificaciones.setMnemonic(KeyEvent.VK_N);
		menuNotificaciones.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuNotificaciones);
		
		menuItemNotificacionesVer = new JMenuItem("Ver Notificaciones");
		menuNotificaciones.add(menuItemNotificacionesVer);
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

	/**
	 * @return the menuItemCursadaVer
	 */
	public JMenuItem getMenuItemCursadaVer() {
		return menuItemCursadaVer;
	}

	/**
	 * @param menuItemCursadaVer the menuItemCursadaVer to set
	 */
	public void setMenuItemCursadaVer(JMenuItem menuItemCursadaVer) {
		this.menuItemCursadaVer = menuItemCursadaVer;
	}

	/**
	 * @return the menuTarea
	 */
	public JMenu getMenuTarea() {
		return menuTarea;
	}

	/**
	 * @param menuTarea the menuTarea to set
	 */
	public void setMenuTarea(JMenu menuTarea) {
		this.menuTarea = menuTarea;
	}

	/**
	 * @return the menuItemTareaVer
	 */
	public JMenuItem getMenuItemTareaVer() {
		return menuItemTareaVer;
	}

	/**
	 * @param menuItemTareaVer the menuItemTareaVer to set
	 */
	public void setMenuItemTareaVer(JMenuItem menuItemTareaVer) {
		this.menuItemTareaVer = menuItemTareaVer;
	}

	/**
	 * @return the menuSala
	 */
	public JMenu getMenuSala() {
		return menuSala;
	}

	/**
	 * @param menuSala the menuSala to set
	 */
	public void setMenuSala(JMenu menuSala) {
		this.menuSala = menuSala;
	}

	/**
	 * @return the menuItemSalaVer
	 */
	public JMenuItem getMenuItemSalaVer() {
		return menuItemSalaVer;
	}

	/**
	 * @param menuItemSalaVer the menuItemSalaVer to set
	 */
	public void setMenuItemSalaVer(JMenuItem menuItemSalaVer) {
		this.menuItemSalaVer = menuItemSalaVer;
	}

	public JMenu getMenuContacto() {
		return menuContacto;
	}

	public void setMenuContacto(JMenu menuContacto) {
		this.menuContacto = menuContacto;
	}

	public JMenuItem getMenuItemContactoVer() {
		return menuItemContactoVer;
	}

	public void setMenuItemContactoVer(JMenuItem menuItemContactoVer) {
		this.menuItemContactoVer = menuItemContactoVer;
	}

	public JMenuItem getMenuItemNotificacionesVer() {
		return menuItemNotificacionesVer;
	}

	public void setMenuItemNotificacionesVer(JMenuItem menuItemNotificacionesVer) {
		this.menuItemNotificacionesVer = menuItemNotificacionesVer;
	}

	public JMenuItem getMenuItemRecadosVer() {
		return menuItemRecadosVer;
	}

	public void setMenuItemRecadosVer(JMenuItem menuItemRecadosVer) {
		this.menuItemRecadosVer = menuItemRecadosVer;
	}

}
