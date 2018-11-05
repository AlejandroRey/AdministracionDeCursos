package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.AdministrativoABMVistaPrincipal;
import presentacion.vista.AlumnoABMVistaPrincipal;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.CursoABMVistaPrincipal;
import presentacion.vista.LoginVista;
import presentacion.vista.SalaABMVistaPrincipal;
import presentacion.vista.SupervisorAdministracionVista;
import presentacion.vista.TareaABMVistaPrincipal;
import presentacion.vista.UsuarionABMVistaPrincipal;

public class SupervisorAdministracionVistaControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private SupervisorAdministracionVista vista;
	
	private AdministrativoABMVistaPrincipal administrativoABM;
	private AdministrativoABMVistaPrincipalControlador administrativoABMControlador;
	
	public SupervisorAdministracionVistaControlador(AdministracionDeCursos modelo, SupervisorAdministracionVista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getMenuItemAdministrativosVer().addActionListener(this);
		this.vista.getMenuItemSalirDelSistema().addActionListener(this);
		this.vista.getMenuItemCambiarDeUsuario().addActionListener(this);
		this.vista.getMenuItemExportarBaseDeDatos().addActionListener(this);
		this.vista.getMenuItemImportarBaseDeDatos().addActionListener(this);
		this.vista.getMenuItemRecadosVer().addActionListener(this);
	}
	
	public void inicializar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		resetVistas();
		
		if (e.getSource() == this.vista.getMenuItemAdministrativosVer()) {
			if (administrativoABM == null) {
				administrativoABM = new AdministrativoABMVistaPrincipal();
				administrativoABMControlador = new AdministrativoABMVistaPrincipalControlador(modelo, administrativoABM);
				this.vista.getMainPanel().add(administrativoABM);
			}
		} 
		else if (e.getSource()==this.vista.getMenuItemExportarBaseDeDatos()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource()==this.vista.getMenuItemImportarBaseDeDatos()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource()==this.vista.getMenuItemRecadosVer()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no fue desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource()== this.vista.getMenuItemSalirDelSistema()) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir?", "Salir del sistema", JOptionPane.YES_NO_OPTION);
		    if (respuesta == JOptionPane.YES_OPTION)
		    {
		    	this.vista.getFrame().dispose();
		    }
			
		}
		else if (e.getSource()==this.vista.getMenuItemCambiarDeUsuario()) {
			this.vista.getFrame().dispose();
			LoginVista vista = new LoginVista();
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		this.vista.getFrame().repaint();
	}
	
	private void resetVistas() {
		if (administrativoABMControlador != null) {
			administrativoABM = null;
			administrativoABMControlador = null;
		}
		
		this.vista.getMainPanel().removeAll();
		this.vista.getMainPanel().repaint();
		this.vista.getFrame().repaint();
	}
}