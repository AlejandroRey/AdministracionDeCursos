package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import dto.RecadoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.RecadoABMPanel;

public class RecadoABMPanelControlador implements ActionListener {

	private AdministracionDeCursos modelo;
	private RecadoABMPanel vista;
	private String tipo; // Enviados - Recibidos - Eliminados
	private List<RecadoDTO> recadosLista;
	
	public RecadoABMPanelControlador(AdministracionDeCursos modelo, RecadoABMPanel vista, String tipo) {
		this.vista = vista;
		this.modelo = modelo;
		this.tipo = tipo;
		this.vista.getBtnVer().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
	}

	public void inicializar() {
		if(this.tipo.equals("Enviados")){
			llenarTabladeEnviados();
		} else if (this.tipo.equals("Recibidos")) {
			llenarTabladeRecibidos();
		} else if (this.tipo.equals("Eliminados")){
			llenarTabladeEliminados();
		}
	}

	private void llenarTabladeEnviados() {
		instanciarTabla();	
		// TODO Cambiar id -- SE OBTIENEN LOS ENVIADOS DEL idUsuarioDe = 1
		this.recadosLista = modelo.obtenerRecadosEnviados(1);
		for (RecadoDTO recadoDTO : recadosLista) {
			Object[] fila = { recadoDTO.getIdRecado(), recadoDTO.getIdUsuarioDe(), recadoDTO.getIdUsuarioPara(),
					recadoDTO.getAsunto(), recadoDTO.getMensaje(), recadoDTO.getFechaHoraEnvio(), recadoDTO.isVisto(),
					recadoDTO.isEliminado() };
			this.vista.getModelRecados().addRow(fila);
		}

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblRecados().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

	}
	
	private void llenarTabladeRecibidos() {
		instanciarTabla();
		// TODO Cambiar id -- SE OBTIENEN LOS ENVIADOS DEL idUsuarioPara = 1
		this.recadosLista = modelo.obtenerRecadosRecibidos(1);
		for (RecadoDTO recadoDTO : recadosLista) {
			Object[] fila = { recadoDTO.getIdRecado(), recadoDTO.getIdUsuarioDe(), recadoDTO.getIdUsuarioPara(),
					recadoDTO.getAsunto(), recadoDTO.getMensaje(), recadoDTO.getFechaHoraEnvio(), recadoDTO.isVisto(),
					recadoDTO.isEliminado() };
			this.vista.getModelRecados().addRow(fila);
		}

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblRecados().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

	}
	
	private void llenarTabladeEliminados() {
		instanciarTabla();	
		this.recadosLista = modelo.obtenerRecadosEliminados();
		for (RecadoDTO recadoDTO : recadosLista) {
			Object[] fila = { recadoDTO.getIdRecado(), recadoDTO.getIdUsuarioDe(), recadoDTO.getIdUsuarioPara(),
					recadoDTO.getAsunto(), recadoDTO.getMensaje(), recadoDTO.getFechaHoraEnvio(), recadoDTO.isVisto(),
					recadoDTO.isEliminado() };
			this.vista.getModelRecados().addRow(fila);
		}

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblRecados().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnVer()) {
			// TODO
		} else if (e.getSource() == this.vista.getBtnEliminar()) {	
			if(this.tipo.equals("Enviados")){
				marcarComoEliminado();
			} else if (this.tipo.equals("Recibidos")) {
				marcarComoEliminado();
			} else if (this.tipo.equals("Eliminados")){
				eliminarRecadoPermanente();
			}			
		}
	}
	
	private void instanciarTabla() {
		this.vista.getModelRecados().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelRecados().setColumnCount(0);
		this.vista.getModelRecados().setColumnIdentifiers(this.vista.getNombreColumnas());
		this.vista.getTblRecados().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(1).setWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(1).setMinWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(1).setMaxWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(2).setWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(2).setMinWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(2).setMaxWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(6).setWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(6).setMinWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(6).setMaxWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(7).setWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(7).setMinWidth(0);
		this.vista.getTblRecados().getColumnModel().getColumn(7).setMaxWidth(0);		
	}
	
	private void marcarComoEliminado() {
		try {
			if (this.vista.getTblRecados().getSelectedRow() >= 0) {
				String idRecado = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),0).toString();
				String idUsuarioDe = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(), 1).toString();
				String idUsuarioPara = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(), 2).toString();
				String asunto = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(), 3).toString();
				String mensaje = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(), 4).toString();
				Timestamp enviado = (Timestamp) this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(), 5);
				boolean visto = (boolean) this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(), 6);
				if(JOptionPane.showConfirmDialog(null, "Desea eliminar el recado seleccionado?", "Recado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
					try {
						this.modelo.actualizarRecado(new RecadoDTO(Long.parseLong(idRecado), Long.parseLong(idUsuarioDe), Long.parseLong(idUsuarioPara), asunto, mensaje, enviado, visto, true));			
						if(this.tipo.equals("Enviados")){
							llenarTabladeEnviados();
						} else if (this.tipo.equals("Recibidos")) {
							llenarTabladeRecibidos();
						}	
					} catch (Exception ex) {
						System.out.println("NO SE PUDO ELIMINAR: " + ex);
					}					
				}
			} else {
				JOptionPane.showMessageDialog(null, "No seleccionaste ningun recado!", "Recado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	private void eliminarRecadoPermanente() {
		try {
			if (this.vista.getTblRecados().getSelectedRow() >= 0) {
				String idRecado = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),0).toString();
				if(JOptionPane.showConfirmDialog(null, "Desea eliminar de forma permanente el recado seleccionado?", "Recado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
					try {
						this.modelo.borrarRecado(new RecadoDTO(Long.parseLong(idRecado), 0, 0, idRecado, idRecado, null, false, false));
						llenarTabladeEliminados();
					} catch (Exception ex) {
						System.out.println("NO SE PUDO ELIMINAR: " + ex);
					}					
				}
			} else {
				JOptionPane.showMessageDialog(null, "No seleccionaste ningun recado!", "Recado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
}
