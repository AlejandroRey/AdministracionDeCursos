package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.AdministracionDeCursos;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.InstructorVista;
import presentacion.vista.SupervisorVista;
import presentacion.vista.VistaInicial;

public class VistaInicialControlador implements ActionListener {
	
	private VistaInicial vista;
	private AdministrativoVista administrativoVista;
	private AdministrativoVistaControlador administrativoVistaControlador;
	private SupervisorVista supervisorVista;
	private SupervisorVistaControlador supervisorVistaControlador;
	private InstructorVista instructorVista;
	private InstructorVistaControlador instructorVistaControlador;
	private AdministracionDeCursos modelo;
	
	public VistaInicialControlador(VistaInicial vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnAdministrativo().addActionListener(this);
		this.vista.getBtnInstructor().addActionListener(this);
		this.vista.getBtnSupervisor().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.vista.getBtnAdministrativo()) {
			this.vista.getFrmBienvenidoAlSistema().dispose();
			administrativoVista = new AdministrativoVista();
			administrativoVistaControlador = new AdministrativoVistaControlador(administrativoVista,modelo);
			administrativoVistaControlador.inicializar();
		}
		
		if (e.getSource() == this.vista.getBtnInstructor()) {
			this.vista.getFrmBienvenidoAlSistema().dispose();
			instructorVista = new InstructorVista();
			instructorVistaControlador = new InstructorVistaControlador(instructorVista,modelo);
			instructorVistaControlador.inicializar();
		}
		
		if (e.getSource() == this.vista.getBtnSupervisor()) {
			this.vista.getFrmBienvenidoAlSistema().dispose();
			supervisorVista = new SupervisorVista();
			supervisorVistaControlador = new SupervisorVistaControlador(supervisorVista,modelo);
			supervisorVistaControlador.inicializar();
		}
	}
}
