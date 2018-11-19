package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AdministracionDeCursos;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.InstructorVista;
import presentacion.vista.LoginVista;
import presentacion.vista.RecadoABMVistaPrincipal;

public class InstructorVistaControlador implements ActionListener {
	
	private InstructorVista vista;
	private AdministracionDeCursos modelo;
	private InstructorAdministracionVista instructorAdministracionVista;
	private InstructorAdministracionVistaControlador instructorAdministracionVistaControlador;
	private RecadoABMVistaPrincipal recadoABMVistaPrincipal;
	private RecadoABMVistaPrincipalControlador recadoABMControlador;
	
	public InstructorVistaControlador (InstructorVista vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnCerrarSesion().addActionListener(this);
		this.vista.getBtnConsultarAsignaciones().addActionListener(this);
		this.vista.getBtnRecados().addActionListener(this);
		this.vista.getBtnRegistrar().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnCerrarSesion()) {
			this.vista.getFrmInstructor().dispose();
			LoginVista vista = new LoginVista();
			AdministracionDeCursos modelo = new AdministracionDeCursos(new DAOSQLFactory());
			LoginVistaControlador controlador = new LoginVistaControlador(vista, modelo);
			controlador.inicializar();
		}
		
		if (e.getSource() == this.vista.getBtnRecados()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no esta desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			this.vista.getFrmInstructor().dispose();

			instructorAdministracionVista = new InstructorAdministracionVista();
			instructorAdministracionVistaControlador = new InstructorAdministracionVistaControlador(modelo,instructorAdministracionVista);
			instructorAdministracionVistaControlador.inicializar();
			
			if (recadoABMVistaPrincipal == null) {
				recadoABMVistaPrincipal = new RecadoABMVistaPrincipal();
				recadoABMControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABMVistaPrincipal);
				
				this.instructorAdministracionVista.getMainPanel().add(recadoABMVistaPrincipal);
			}
		}
		
		if (e.getSource() == this.vista.getBtnConsultarAsignaciones()) {
			JOptionPane.showMessageDialog(null, "Esta función todavía no esta desarrollada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == this.vista.getBtnRegistrar()) {
			
		}
	}

}
