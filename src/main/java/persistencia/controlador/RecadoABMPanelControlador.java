package persistencia.controlador;

import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import dto.RecadoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.RecadoABMPanel;

public class RecadoABMPanelControlador {

	private AdministracionDeCursos modelo;
	private RecadoABMPanel vista;
	private String tipo; // Enviados - Recibidos - Eliminados
	private List<RecadoDTO> recadosLista;
	
	public RecadoABMPanelControlador(AdministracionDeCursos modelo, RecadoABMPanel vista, String tipo) {
		this.vista = vista;
		this.modelo = modelo;
		this.tipo = tipo;
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
	
	
	// Oculto los id del Objeto
//	this.vista.getTblRecados().getColumnModel().getColumn(0).setWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(0).setMinWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(0).setMaxWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(1).setWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(1).setMinWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(1).setMaxWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(5).setWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(5).setMinWidth(0);
//	this.vista.getTblRecados().getColumnModel().getColumn(5).setMaxWidth(0);

//	this.vista.getTblRecados().setSelectionMode(new ListSelectionEvent());
//	this.vista.getTblRecados().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
//		try {
//			if (this.vista.getTblRecados().getSelectedRow() >= 0) {
//
//				Object idRecado = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
//						0);
//				Object idUsuarioDe = this.vista.getTblRecados()
//						.getValueAt(this.vista.getTblRecados().getSelectedRow(), 1);
//				Object idUsuarioPara = this.vista.getTblRecados()
//						.getValueAt(this.vista.getTblRecados().getSelectedRow(), 2);
//				Object asunto = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
//						3);
//				Object mensaje = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
//						4);
//				Object enviado = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
//						5);
//				Object visto = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
//						6);
//				Object elimanado = this.vista.getTblRecados()
//						.getValueAt(this.vista.getTblRecados().getSelectedRow(), 7);
//
//			}
//		} catch (Exception ex) {
//			System.out.println("Error: " + ex.getMessage());
//		}
//	});

}
