package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.CategoriaDTO;
import dto.NotificacionDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import persistencia.controlador.UsuarioABMControlador.ListSelectionModelCstm;
import presentacion.vista.AdministracionDeCursosVista;
import presentacion.vista.CursadaABMPanel;
import presentacion.vista.CursadaABMVistaPrincipal;
import presentacion.vista.InstructorAdministracionVista;
import presentacion.vista.NotificacionPanel;
import presentacion.vista.RecadoABMPanel;
import presentacion.vista.RecadoABMVistaPrincipal;
import presentacion.vista.SupervisorAdministracionVista;
import presentacion.vista.TareaABMPanel;
import presentacion.vista.TareaABMVistaPrincipal;

public class NotificacionControlador implements ActionListener {
	
	private AdministracionDeCursos modelo;
	private NotificacionPanel vista;
	private List<NotificacionDTO> notificaciones;
	
	private AdministracionDeCursosControlador administracionDeCursosControlador;
	private AdministracionDeCursosVista administracionDeCursosVista;
	
	private SupervisorAdministracionVista supervisorAdministracionVista;
	private SupervisorAdministracionVistaControlador supervisorAdministracionVistaControlador;
	
	private InstructorAdministracionVista instructorAdministracionVista;
	private InstructorAdministracionVistaControlador intrusctorAdministracionVistaControlador;
	
	private TareaABMVistaPrincipal tareaABMVistaPrincipal;
	private TareaABMVistaPrincipalControlador tareaABMVistaPrincipalControlador;
	private TareaABMPanel tareaABMPanel;
	private TareaABMControlador tareaABMControlador;
	
	private CursadaABMVistaPrincipal cursadaABMVistaPrincipal;
	private CursadaABMVistaPrincipalControlador cursadaABMVistaPrincipalControlador;
	private CursadaABMPanel cursadaABMPanel;
	private CursadaABMControlador cursadaABMControlador;
	
	private RecadoABMVistaPrincipal recadoABMVistaPrincipal;
	private RecadoABMVistaPrincipalControlador recadoABMVistaPrincipalControlador;
	private RecadoABMPanel recadoABMPanel;
	private RecadoABMPanelControlador recadoABMPanelControlador;
	
	public NotificacionControlador(AdministracionDeCursos modelo, NotificacionPanel vista, 
		AdministracionDeCursosVista administracionDeCursosVista, SupervisorAdministracionVista supervisorAdministracionVista,
		InstructorAdministracionVista instructorAdministracionVista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.notificaciones = null;
		this.administracionDeCursosVista = administracionDeCursosVista;
		this.supervisorAdministracionVista = supervisorAdministracionVista;
		this.instructorAdministracionVista = instructorAdministracionVista;
		//this.administracionDeCursosControlador = administracionDeCursosControlador;
		
		this.vista.getBtnIrACursadas().addActionListener(this);
		this.vista.getBtnIrARecados().addActionListener(this);
		this.vista.getBtnIrATareas().addActionListener(this);
		this.vista.getBtnMarcarComoLeido().addActionListener(this);
		this.vista.getComboBoxFiltro().addActionListener(this);
	}
	
	public void inicializar() {
		llenarComboBox();
		llenarTabla();
	}
	
	private void llenarTabla() {
		this.notificaciones = modelo.obtenerNotificaciones();
		this.vista.getModelNotificaciones().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelNotificaciones().setColumnCount(0);
		this.vista.getModelNotificaciones().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearFields();
		setBtnNotVisible();
		this.vista.getBtnMarcarComoLeido().setVisible(false);

		this.notificaciones = modelo.obtenerNotificaciones();
		for (NotificacionDTO notificacionDTO : notificaciones) {
			Object[] fila = {notificacionDTO.getIdNotificacion(),
							 notificacionDTO.getIdUsuario(),
							 notificacionDTO.getTipoNotificacion(),
							 notificacionDTO.getMensaje(),
							 booleanToString(notificacionDTO.isVisto()),
							 stringToLocalDateFormatter(notificacionDTO.getFechaHora())};
			//filtro para obterner solo los instructores
			if(this.modelo.getUsuarioLogueado().getIdUsuario()==notificacionDTO.getIdUsuario())
			//System.out.println("El usuario logueado es: " + this.modelo.getUsuarioLogueado().getIdUsuario());
			//System.out.println(this.modelo.getUsuarioLogueado().toString());
			//System.out.println("El idNotificacion actual es: " + notificacionDTO.getIdUsuario());
			this.vista.getModelNotificaciones().addRow(fila);
		}
		
		// Oculto los id del Objeto
		this.vista.getTblNotificaciones().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(1).setMaxWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(2).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblNotificaciones().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblNotificaciones().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblNotificaciones().getSelectedRow() >= 0) {
					/*if (this.vista.getComboBoxFiltro().getItemCount() == 0) {
						//this.vista.getCbxCategoria().addItem(new CategoriaDTO(0, ""));
						for (NotificacionDTO notificacionDTO : notificaciones) {
							this.vista.getComboBoxFiltro().addItem(notificacionDTO);
						}
					}*/				
				
					Object tipoNotificacion = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 2);
					Object mensaje = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 3);
					Object visto = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 4);
					Object fechaHora = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 5);
					/*Object idUsuario = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 0);
					Object idCategoria = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 1);
					Object categoria = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 2);
					Object nombre = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 3);
					Object apellido = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 4);
					Object telefono = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 5);
					Object email = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 6);
					Object usuario = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 7);
					Object password = this.vista.getTblUsuarios().getValueAt(this.vista.getTblUsuarios().getSelectedRow(), 8);*/
					
					this.vista.getTextDetalle().setText(mensaje.toString());
					this.vista.getTextFechaHora().setText(fechaHora.toString());
					/*this.vista.getTextIdUsuario().setText(idUsuario.toString());
					this.vista.getCbxCategoria().setSelectedItem(new CategoriaDTO(Long.parseLong(idCategoria.toString()), categoria.toString()));
					this.vista.getTextNombre().setText(nombre.toString());
					this.vista.getTextApellido().setText(apellido.toString());
					this.vista.getTextTelefono().setText(telefono.toString());
					this.vista.getTextEmail().setText(email.toString());
					this.vista.getTextUsuario().setText(usuario.toString());
					this.vista.getTextPassword().setText(password.toString());*/
					if(tipoNotificacion.toString().equals("0"))
						setVisibleBtnIrACursadas();
					else if(tipoNotificacion.toString().equals("1"))
						setVisibleBtnIrARecados();
					else if(tipoNotificacion.toString().equals("2"))
						setVisibleBtnIrATareas();
					if(visto.toString().equals("No leído"))
						this.vista.getBtnMarcarComoLeido().setVisible(true);
					else 
						this.vista.getBtnMarcarComoLeido().setVisible(false);
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});
		
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblNotificaciones().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		filtro();
	}
	
	private void llenarComboBox() {
		this.vista.getComboBoxFiltro().addItem("Todas");
		this.vista.getComboBoxFiltro().addItem("Leídas");
		this.vista.getComboBoxFiltro().addItem("No leídas");
	}
	
	public void filtro() {
        if(this.vista.getComboBoxFiltro().getSelectedItem().toString() == "Leídas")
        	this.vista.getModeloOrdenadoNotificaciones().setRowFilter(RowFilter.regexFilter("Leído", 4));
        else if(this.vista.getComboBoxFiltro().getSelectedItem().toString() == "No leídas")
        	this.vista.getModeloOrdenadoNotificaciones().setRowFilter(RowFilter.regexFilter("No leído", 4));
        else 
        	this.vista.getModeloOrdenadoNotificaciones().setRowFilter(null);
    }
	
	private void clearFields() {
		this.vista.getTextDetalle().setText("");
		this.vista.getTextFechaHora().setText("");
		setBtnNotVisible();
	}
	
	private String stringToLocalDateFormatter(LocalDateTime fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}
	
	private LocalDateTime localDateTimeToString(String fecha) {
		String date = fecha;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format);
		return dateTime;
	}
	
	public void setVisibleBtnIrACursadas() {
		this.vista.getTblNotificaciones().setEnabled(true);
		setBtnNotVisible();
		this.vista.getBtnIrACursadas().setVisible(true);		
	}
	
	public void setVisibleBtnIrARecados() {
		this.vista.getTblNotificaciones().setEnabled(true);
		setBtnNotVisible();
		this.vista.getBtnIrARecados().setVisible(true);		
	}
	
	public void setVisibleBtnIrATareas() {
		this.vista.getTblNotificaciones().setEnabled(true);
		setBtnNotVisible();
		this.vista.getBtnIrATareas().setVisible(true);		
	}
	
	
	public void setBtnNotVisible() {
		this.vista.getBtnIrACursadas().setVisible(false);
		this.vista.getBtnIrARecados().setVisible(false);
		this.vista.getBtnIrATareas().setVisible(false);
	}
	
	private String booleanToString(boolean data) {
		String result;
		if (data == false) {
			result = "No leído";
		}
		else {
			result = "Leído";
		}
		return result;
	}
	
	private boolean stringToBoolean(String data) {
		boolean result;
		if (data.equals("No leído"))
			result = false;
		else
			result = true;
		return result;
	}
		
	private void marcarComoLeido() {
		Object idNotificacion = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 0);
		Object idUsuario = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 1);
		Object tipoNotificacion = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 2);
		Object visto = this.vista.getTblNotificaciones().getValueAt(this.vista.getTblNotificaciones().getSelectedRow(), 4);
			NotificacionDTO notificacion = new NotificacionDTO(Long.parseLong(idNotificacion.toString()), 
												Long.parseLong(idUsuario.toString()), 
												Long.parseLong(tipoNotificacion.toString()),
												this.vista.getTextDetalle().getText(),
												true,
												localDateTimeToString(this.vista.getTextFechaHora().getText()));
			this.modelo.actualizarNotificacion(notificacion);
			System.out.println(notificacion.toString());
			llenarTabla();
	}
	
	@SuppressWarnings("serial")
	public class ListSelectionModelCstm extends DefaultListSelectionModel {

	    public ListSelectionModelCstm () {
	        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    }

	    @Override
	    public void clearSelection() {
	    }

	    @Override
	    public void removeSelectionInterval(int index0, int index1) {
	    }

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getComboBoxFiltro()) {
			llenarTabla();
		}
		else if (e.getSource() == this.vista.getBtnMarcarComoLeido()) {
				marcarComoLeido();
		}
		else if (e.getSource() == this.vista.getBtnIrACursadas()) {
			cursadaABMVistaPrincipal = new CursadaABMVistaPrincipal();
			cursadaABMVistaPrincipalControlador = new CursadaABMVistaPrincipalControlador(modelo, cursadaABMVistaPrincipal, administracionDeCursosVista, instructorAdministracionVista);
			administracionDeCursosVista.getMainPanel().removeAll();
			administracionDeCursosVista.getMainPanel().add(cursadaABMVistaPrincipal);
			vista.setVisible(false);
			administracionDeCursosVista.getFrame().repaint();
			administracionDeCursosVista.getFrame().revalidate();
		}
		else if (e.getSource() == this.vista.getBtnIrATareas()) {
			tareaABMVistaPrincipal = new TareaABMVistaPrincipal();
			tareaABMVistaPrincipalControlador = new TareaABMVistaPrincipalControlador(modelo, tareaABMVistaPrincipal, administracionDeCursosVista, supervisorAdministracionVista,null);
			administracionDeCursosVista.getMainPanel().removeAll();
			tareaABMVistaPrincipalControlador = new TareaABMVistaPrincipalControlador(modelo, tareaABMVistaPrincipal, administracionDeCursosVista,null,null);
			administracionDeCursosVista.getMainPanel().add(tareaABMVistaPrincipal);
			vista.setVisible(false);
			administracionDeCursosVista.getFrame().repaint();
			administracionDeCursosVista.getFrame().revalidate();
		}
		else if (e.getSource() == this.vista.getBtnIrARecados()) {
			recadoABMVistaPrincipal = new RecadoABMVistaPrincipal();
			recadoABMVistaPrincipalControlador = new RecadoABMVistaPrincipalControlador(modelo, recadoABMVistaPrincipal, administracionDeCursosVista, null, null);
			try {
			administracionDeCursosVista.getMainPanel().removeAll();
			administracionDeCursosVista.getMainPanel().add(recadoABMVistaPrincipal);
			vista.setVisible(false);
			administracionDeCursosVista.getFrame().repaint();
			administracionDeCursosVista.getFrame().revalidate();
			}
			catch (Exception ex) {
				
			}
			try {
				supervisorAdministracionVista.getMainPanel().removeAll();
				supervisorAdministracionVista.getMainPanel().add(recadoABMVistaPrincipal);
				vista.setVisible(false);
				supervisorAdministracionVista.getFrame().repaint();
				supervisorAdministracionVista.getFrame().revalidate();
			}
			catch(Exception ex) {
				
			}
			try {
				instructorAdministracionVista.getMainPanel().removeAll();
				instructorAdministracionVista.getMainPanel().add(recadoABMVistaPrincipal);
				vista.setVisible(false);
				instructorAdministracionVista.getFrame().repaint();
				instructorAdministracionVista.getFrame().revalidate();
			}
			catch(Exception ex) {
				
			}
		}
	}
}
