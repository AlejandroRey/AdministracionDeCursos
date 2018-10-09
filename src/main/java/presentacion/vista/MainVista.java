package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import modelo.AdministracionDeCursos;
import persistencia.conexion.Conexion;
import persistencia.controlador.AlumnoCrudControlador;
import persistencia.controlador.CursadaCrudControlador;
import persistencia.controlador.AlumnoEventoCrudControlador;
import persistencia.controlador.CursoCrudControlador;
import persistencia.controlador.UsuarioCrudControlador;
import persistencia.dao.mysql.DAOSQLFactory;

public class MainVista {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainVista window = new MainVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainVista() {
		initialize();
	}
	
	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Aplicacion!?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 1248, 879);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);

		
		//STATUS BAR
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.WHITE);
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		frame.getContentPane().add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		JLabel statusLabel = new JLabel("Conectado - Administracion de Cursos v1.0");
		statusLabel.setPreferredSize(new Dimension(frame.getWidth(), 16));
		statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		statusPanel.add(statusLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnVistas = new JMenu("Vistas");
		menuBar.add(mnVistas);
		
		JMenuItem mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
				AlumnoCrudVista vista = new AlumnoCrudVista();
				AlumnoCrudControlador ctrl = new AlumnoCrudControlador(vista, modelo);
				ctrl.inicializar();
			}
		});
		mnVistas.add(mntmAlumno);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
				CursoCrudVista vista = new CursoCrudVista();
				CursoCrudControlador ctrl = new CursoCrudControlador(vista, modelo);
				ctrl.inicializar();
			}
		});
		mntmCurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnVistas.add(mntmCurso);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
				UsuarioCrudVista vista = new UsuarioCrudVista();
				UsuarioCrudControlador ctrl = new UsuarioCrudControlador(vista, modelo);
				ctrl.inicializar();
			}
		});
		mnVistas.add(mntmUsuario);
		
		JMenuItem mntmCursada = new JMenuItem("Cursada");
		mntmCursada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
				CursadaCrudVista cursadaVista = new CursadaCrudVista();
				CursadaCrudControlador ctrlCursada = new CursadaCrudControlador(cursadaVista, modelo);
				ctrlCursada.inicializar();
			}
		});
		mnVistas.add(mntmCursada);

		JMenuItem mntmContacto = new JMenuItem("Contacto");
		mntmContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
				AlumnoEventoCrudVista vista = new AlumnoEventoCrudVista();
				AlumnoEventoCrudControlador ctrl = new AlumnoEventoCrudControlador(vista, modelo);
				ctrl.inicializar();
			}
		});
		mnVistas.add(mntmContacto);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		//frame.setVisible(true);
	}
}
