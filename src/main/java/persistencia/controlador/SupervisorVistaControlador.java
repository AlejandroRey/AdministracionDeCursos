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

public class SupervisorVistaControlador implements ActionListener {

	private SupervisorVista vista;
	private AdministracionDeCursos modelo;
	private SupervisorAdministracionVista supervisorAdministracionVista;
	private SupervisorAdministracionVistaControlador supervisorAdministracionVistaControlador;
	private AdministrativoABMVistaPrincipal administrativoABMVistaPrincipal;
	private AdministrativoABMVistaPrincipalControlador administrativoABMVistaPrincipalControlador;
	
	public SupervisorVistaControlador(SupervisorVista vista) {
		super();
		this.vista = vista;
		
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
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
	
		if (e.getSource() == this.vista.getMntmImportar()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getMntmExportar()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getMntmCambiarContrasena()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == this.vista.getBtnRecados()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			//TODO AGREGAR RECADO
		}
		if (e.getSource() == this.vista.getBtnAdministrativos()) {
			this.vista.getFrmSupervisor().dispose();
			//supervisorAdministracionVistaControlador = new SupervisorAdministracionVistaControlador(AdministracionDeCursos, vista);
			modelo = new AdministracionDeCursos(new DAOSQLFactory());
			supervisorAdministracionVista = new SupervisorAdministracionVista();
			supervisorAdministracionVistaControlador = new SupervisorAdministracionVistaControlador(modelo,supervisorAdministracionVista);
			administrativoABMVistaPrincipal = new AdministrativoABMVistaPrincipal();
			administrativoABMVistaPrincipalControlador = new AdministrativoABMVistaPrincipalControlador(modelo, administrativoABMVistaPrincipal);
			this.supervisorAdministracionVista.getMainPanel().add(administrativoABMVistaPrincipal);
		}
		if (e.getSource() == this.vista.getBtnTareas()) {
			
		}
	}
}
