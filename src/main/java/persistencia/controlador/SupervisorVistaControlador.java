package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoABMVistaPrincipal;
import presentacion.vista.LoginVista;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.SupervisorAdministracionVista;
import presentacion.vista.SupervisorVista;
import presentacion.vista.UsuarioCambioContraseñaVista;

public class SupervisorVistaControlador implements ActionListener {

	private SupervisorVista vista;
	private AdministracionDeCursos modelo;
	private SupervisorAdministracionVista supervisorAdministracionVista;
	private AdministracionDeCursosVista administracionVista;
	private SupervisorAdministracionVistaControlador supervisorAdministracionVistaControlador;
	private AdministrativoABMVistaPrincipal administrativoABMVistaPrincipal;
	private AdministrativoABMVistaPrincipalControlador administrativoABMVistaPrincipalControlador;
	private RecadoABMVistaPrincipal recadoABMVistaPrincipal;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	
	public SupervisorVistaControlador(SupervisorVista vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnAdministrativos().addActionListener(this);
		this.vista.getBtnRecados().addActionListener(this);
		this.vista.getBtnTareas().addActionListener(this);
		this.vista.getMntmCambiarContrasena().addActionListener(this);
		this.vista.getMntmCerrarSesion().addActionListener(this);
		this.vista.getMntmExportar().addActionListener(this);
		this.vista.getMntmImportar().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getMntmCerrarSesion()) {
			this.vista.getFrmSupervisor().dispose();
			LoginVista vista = new LoginVista();
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		if (e.getSource() == this.vista.getMntmImportar()) {
			// TODO IMPORTAR
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getMntmExportar()) {
			// TODO EXPORTAR
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getMntmCambiarContrasena()) {
			UsuarioCambioContraseñaVista vista = new UsuarioCambioContraseñaVista();
			UsuarioCambioContraseñaVistaControlador controlador = new UsuarioCambioContraseñaVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		if (e.getSource() == this.vista.getBtnRecados()) {
			this.vista.getFrmSupervisor().dispose();

			supervisorAdministracionVista = new SupervisorAdministracionVista();
			supervisorAdministracionVistaControlador = new SupervisorAdministracionVistaControlador(modelo,supervisorAdministracionVista);
			supervisorAdministracionVistaControlador.inicializar();
			
			if (recadoABMVistaPrincipal == null) {
				recadoABMVistaPrincipal = new RecadoABMVistaPrincipal();
				recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABMVistaPrincipal, null, supervisorAdministracionVista, null);			
				this.supervisorAdministracionVista.getMainPanel().add(recadoABMVistaPrincipal);
			}
		}
		if (e.getSource() == this.vista.getBtnAdministrativos()) {
			this.vista.getFrmSupervisor().dispose();
			supervisorAdministracionVista = new SupervisorAdministracionVista();
			supervisorAdministracionVistaControlador = new SupervisorAdministracionVistaControlador(modelo,supervisorAdministracionVista);
			administrativoABMVistaPrincipal = new AdministrativoABMVistaPrincipal();
			administrativoABMVistaPrincipalControlador = new AdministrativoABMVistaPrincipalControlador(modelo, administrativoABMVistaPrincipal, supervisorAdministracionVista);
			this.supervisorAdministracionVista.getMainPanel().add(administrativoABMVistaPrincipal);
		}
		if (e.getSource() == this.vista.getBtnTareas()) {
			// TODO TAREAS
		}
	}
}
