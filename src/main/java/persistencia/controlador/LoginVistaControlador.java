package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.log.SysoCounter;

import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.AdministrativoVista;
import presentacion.vista.InstructorVista;
import presentacion.vista.LoginVista;
import presentacion.vista.SupervisorVista;

public class LoginVistaControlador implements ActionListener {
	
	private LoginVista vista;
	private AdministracionDeCursos modelo;
	private List<UsuarioDTO> listaDeUsuarios;
	private AdministrativoVista administrativoVista;
	private AdministrativoVistaControlador administrativoVistaControlador;
	private SupervisorVista supervisorVista;
	private SupervisorVistaControlador supervisorVistaControlador;
	private InstructorVista instructorVista;
	private InstructorVistaControlador instructorVistaControlador;
	
	public LoginVistaControlador(LoginVista vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnIniciarSesion().addActionListener(this);
	}
	
	public void inicializar() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//Chequeo que el usuario y contraseña existan
		if(e.getSource() == this.vista.getBtnIniciarSesion()) {
			this.listaDeUsuarios = this.modelo.obtenerUsuarios();
			boolean encontrado = false;
			for(UsuarioDTO usuarioDTO : listaDeUsuarios) {
				if (usuarioDTO.getUsuario().equals(this.vista.getUsuarioField().getText()) && usuarioDTO.getPassword().equals(this.vista.getContraseniaField().getText())){
					this.modelo.setUsuarioLogueado(usuarioDTO);
					//Si es supervisor
					if (usuarioDTO.getIdCategoria()==1) {
						this.vista.getLoginFrame().dispose();
						supervisorVista = new SupervisorVista();
						supervisorVistaControlador = new SupervisorVistaControlador(supervisorVista, modelo);
						supervisorVistaControlador.inicializar();
						encontrado = true;
					}
					//Si es administrativo
					if (usuarioDTO.getIdCategoria()==2) {
						this.vista.getLoginFrame().dispose();
						administrativoVista = new AdministrativoVista();
						administrativoVistaControlador = new AdministrativoVistaControlador(administrativoVista, modelo);
						administrativoVistaControlador.inicializar();
						encontrado = true;
					}
					//Si es instructor
					if (usuarioDTO.getIdCategoria()==3){
						this.vista.getLoginFrame().dispose();
						instructorVista = new InstructorVista();
						instructorVistaControlador = new InstructorVistaControlador(instructorVista, modelo);
						instructorVistaControlador.inicializar();
						encontrado = true;
					}
				}
			}
			if (encontrado==false) {
				JOptionPane.showMessageDialog(null, "Los datos son inválidos", "No es posible iniciar sesión", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
