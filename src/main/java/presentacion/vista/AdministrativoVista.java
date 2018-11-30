package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import dto.NotificacionDTO;
import persistencia.controlador.AdministrativoVistaControlador;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;

public class AdministrativoVista {

	private JFrame frmAdministrativo;
	private JToolBar toolBar;
	private JButton btnCerrarSesion;
	private JToolBar toolBar_1;
	private JButton btnCambiarContrasena;
	private JButton btnRecados;
	private JButton btnCursos;
	private JButton btnContactos;
	private JButton btnAlumnos;
	private JButton btnSalas;
	private JButton btnFeriados;
	private JButton btnCursadas;
	private JButton btnTareas;
	private JButton btnEmpresas;
	private JButton btnInstructores;
	private JButton btnNotificaciones;
	private JLabel lblMensajePrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrativoVista window = new AdministrativoVista();
					window.frmAdministrativo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdministrativoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministrativo = new JFrame();
		frmAdministrativo.setTitle("Administrativo");
		frmAdministrativo.setBounds(100, 100, 497, 372);
		frmAdministrativo.setLocationRelativeTo(null);
		frmAdministrativo.setResizable(false);
		frmAdministrativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministrativo.getContentPane().setLayout(null);
		frmAdministrativo.setVisible(true);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 95, 23);
		frmAdministrativo.getContentPane().add(toolBar);
		
		btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		toolBar.add(btnCerrarSesion);
		
		toolBar_1 = new JToolBar();
		toolBar_1.setBounds(100, 0, 134, 23);
		frmAdministrativo.getContentPane().add(toolBar_1);
		
		btnCambiarContrasena = new JButton("Cambiar contraseña");
		btnCambiarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		toolBar_1.add(btnCambiarContrasena);
		
		btnRecados = new JButton("Recados");
		btnRecados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRecados.setBounds(353, 11, 89, 23);
		frmAdministrativo.getContentPane().add(btnRecados);
		
		btnCursos = new JButton("Cursos");
		btnCursos.setBounds(36, 83, 198, 36);
		frmAdministrativo.getContentPane().add(btnCursos);
		
		btnContactos = new JButton("Contactos");
		btnContactos.setBounds(36, 130, 198, 36);
		frmAdministrativo.getContentPane().add(btnContactos);
		
		btnAlumnos = new JButton("Alumnos");
		btnAlumnos.setBounds(36, 180, 198, 36);
		frmAdministrativo.getContentPane().add(btnAlumnos);
		
		btnSalas = new JButton("Salas");
		btnSalas.setBounds(36, 227, 198, 36);
		frmAdministrativo.getContentPane().add(btnSalas);
		
		btnFeriados = new JButton("Feriados");
		btnFeriados.setEnabled(false);
		btnFeriados.setBounds(36, 271, 198, 36);
		frmAdministrativo.getContentPane().add(btnFeriados);
		
		btnCursadas = new JButton("Cursadas");
		btnCursadas.setBounds(245, 83, 198, 36);
		frmAdministrativo.getContentPane().add(btnCursadas);
		
		btnTareas = new JButton("Tareas");
		btnTareas.setBounds(244, 130, 198, 36);
		frmAdministrativo.getContentPane().add(btnTareas);
		
		btnEmpresas = new JButton("Empresas");
		btnEmpresas.setEnabled(false);
		btnEmpresas.setBounds(245, 180, 198, 36);
		frmAdministrativo.getContentPane().add(btnEmpresas);
		
		btnInstructores = new JButton("Instructores");
		btnInstructores.setBounds(245, 227, 198, 36);
		frmAdministrativo.getContentPane().add(btnInstructores);
		
		btnNotificaciones = new JButton("Notificaciones");
		btnNotificaciones.setBounds(245, 271, 198, 36);
		frmAdministrativo.getContentPane().add(btnNotificaciones);
		
		lblMensajePrincipal = new JLabel("Seleccione la opción que desea administrar");
		lblMensajePrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMensajePrincipal.setBounds(75, 45, 337, 19);
		frmAdministrativo.getContentPane().add(lblMensajePrincipal);
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public JButton getBtnCambiarContrasena() {
		return btnCambiarContrasena;
	}

	public JButton getBtnRecados() {
		return btnRecados;
	}

	public JButton getBtnCursos() {
		return btnCursos;
	}

	public JButton getBtnContactos() {
		return btnContactos;
	}

	public JButton getBtnAlumnos() {
		return btnAlumnos;
	}

	public JButton getBtnSalas() {
		return btnSalas;
	}

	public JButton getBtnFeriados() {
		return btnFeriados;
	}

	public JButton getBtnCursadas() {
		return btnCursadas;
	}

	public JButton getBtnTareas() {
		return btnTareas;
	}

	public JButton getBtnEmpresas() {
		return btnEmpresas;
	}

	public JButton getBtnInstructores() {
		return btnInstructores;
	}

	public JButton getBtnNotificaciones() {
		return btnNotificaciones;
	}

	public JFrame getFrmAdministrativo() {
		return frmAdministrativo;
	}
}
