package presentacion.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class InstructorAdministracionVista {

	private JFrame frame;
	private JPanel mainPanel;
	private JMenuBar menuBar;
	
	private JMenu menuAdministrativos;
	private JMenuItem menuItemAdministrativosVer;
	
	private JMenu menuRecados;
	private JMenuItem menuItemRecadosVer;
	
	private JMenu menuSistema;
	private JMenuItem menuItemCambiarDeUsuario;
	private JMenuItem menuItemImportarBaseDeDatos;
	private JMenuItem menuItemExportarBaseDeDatos;
	private JMenuItem menuItemSalirDelSistema;

	/**
	 * Launch the application.
	 */
	public InstructorAdministracionVista() {
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
		
		buildMenuSistema();
		buildMenuAdministrativos();
		buildMenuRecados();
	}

private void buildMenuSistema() {
		
		menuSistema = new JMenu("Sistema");
		menuSistema.setMnemonic(KeyEvent.VK_A);
		menuSistema.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuSistema);
				
		menuItemCambiarDeUsuario = new JMenuItem("Cambiar de usuario");
		menuSistema.add(menuItemCambiarDeUsuario);
		
		menuItemSalirDelSistema = new JMenuItem("Salir del sistema");
		menuSistema.add(menuItemSalirDelSistema);
	}
	
	private void buildMenuAdministrativos() {
		
		menuAdministrativos = new JMenu("Administrativos");
		menuAdministrativos.setMnemonic(KeyEvent.VK_A);
		menuAdministrativos.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuAdministrativos);
		
		menuItemAdministrativosVer = new JMenuItem("Ver Administrativos");
		menuAdministrativos.add(menuItemAdministrativosVer);
	}
	
	private void buildMenuRecados() {

		menuRecados = new JMenu("Recados");
		menuRecados.setMnemonic(KeyEvent.VK_A);
		menuRecados.getAccessibleContext().setAccessibleDescription("");
		menuBar.add(menuRecados);
		
		menuItemRecadosVer = new JMenuItem("Ver Recados");
		menuRecados.add(menuItemRecadosVer);
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
	public JMenu getMenuAdministrativos() {
		return menuAdministrativos;
	}

	/**
	 * @param menuAlumno the menuAlumno to set
	 */
	public void setMenuAdministrativos(JMenu menuAlumno) {
		this.menuAdministrativos = menuAlumno;
	}

	/**
	 * @return the menuItemAlumnoVer
	 */
	public JMenuItem getMenuItemAdministrativosVer() {
		return menuItemAdministrativosVer;
	}

	/**
	 * @param menuItemAlumnoVer the menuItemAlumnoVer to set
	 */
	public void setMenuItemAdministrativosVer(JMenuItem menuItemAlumnoVer) {
		this.menuItemAdministrativosVer = menuItemAlumnoVer;
	}

	/**
	 * @return the menuCurso
	 */
	public JMenu getMenuRecados() {
		return menuRecados;
	}

	/**
	 * @param menuCurso the menuCurso to set
	 */
	public void setMenuRecados(JMenu menuCurso) {
		this.menuRecados = menuCurso;
	}

	/**
	 * @return the menuItemCursoVer
	 */
	public JMenuItem getMenuItemRecadosVer() {
		return menuItemRecadosVer;
	}

	/**
	 * @param menuItemCursoVer the menuItemCursoVer to set
	 */
	public void setMenuItemRecadosVer(JMenuItem menuItemCursoVer) {
		this.menuItemRecadosVer = menuItemCursoVer;
	}

	public JMenuItem getMenuItemCambiarDeUsuario() {
		return menuItemCambiarDeUsuario;
	}

	public void setMenuItemCambiarDeUsuario(JMenuItem menuItemCambiarDeUsuario) {
		this.menuItemCambiarDeUsuario = menuItemCambiarDeUsuario;
	}

	public JMenuItem getMenuItemSalirDelSistema() {
		return menuItemSalirDelSistema;
	}

	public void setMenuItemSalirDelSistema(JMenuItem menuItemSalirDelSistema) {
		this.menuItemSalirDelSistema = menuItemSalirDelSistema;
	}

	public JMenuItem getMenuItemImportarBaseDeDatos() {
		return menuItemImportarBaseDeDatos;
	}

	public void setMenuItemImportarBaseDeDatos(JMenuItem menuItemImportarBaseDeDatos) {
		this.menuItemImportarBaseDeDatos = menuItemImportarBaseDeDatos;
	}

	public JMenuItem getMenuItemExportarBaseDeDatos() {
		return menuItemExportarBaseDeDatos;
	}

	public void setMenuItemExportarBaseDeDatos(JMenuItem menuItemExportarBaseDeDatos) {
		this.menuItemExportarBaseDeDatos = menuItemExportarBaseDeDatos;
	}


	
}