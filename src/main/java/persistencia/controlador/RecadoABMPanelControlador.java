package persistencia.controlador;

import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.RecadoDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.RecadoABMPanel;

public class RecadoABMPanelControlador {

	private AdministracionDeCursos modelo;
	private RecadoABMPanel vista;
	private String tipo;
	private List<RecadoDTO> recadosLista;
	
	public RecadoABMPanelControlador(AdministracionDeCursos modelo, RecadoABMPanel vista, String tipo) {
		this.vista = vista;
		this.modelo = modelo;
		this.tipo = tipo;
	}

	public void inicializar() {
		llenarTabla();
	}

	private void llenarTabla() {
		this.vista.getModelRecados().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelRecados().setColumnCount(0);
		this.vista.getModelRecados().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.recadosLista = modelo.obtenerRecados();
		for (RecadoDTO recadoDTO : recadosLista) {
			Object[] fila = { recadoDTO.getIdRecado(), recadoDTO.getIdUsuarioDe(), recadoDTO.getIdUsuarioPara(),
					recadoDTO.getAsunto(), recadoDTO.getMensaje(), recadoDTO.getFechaHoraEnvio(), recadoDTO.isVisto(),
					recadoDTO.isEliminado() };
			this.vista.getModelRecados().addRow(fila);
		}

		// Oculto los id del Objeto
//		this.vista.getTblRecados().getColumnModel().getColumn(0).setWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(0).setMinWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(0).setMaxWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(1).setWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(1).setMinWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(1).setMaxWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(5).setWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(5).setMinWidth(0);
//		this.vista.getTblRecados().getColumnModel().getColumn(5).setMaxWidth(0);

//		this.vista.getTblRecados().setSelectionMode(new ListSelectionEvent());
		this.vista.getTblRecados().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblRecados().getSelectedRow() >= 0) {

					Object idRecado = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
							0);
					Object idUsuarioDe = this.vista.getTblRecados()
							.getValueAt(this.vista.getTblRecados().getSelectedRow(), 1);
					Object idUsuarioPara = this.vista.getTblRecados()
							.getValueAt(this.vista.getTblRecados().getSelectedRow(), 2);
					Object asunto = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
							3);
					Object mensaje = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
							4);
					Object enviado = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
							5);
					Object visto = this.vista.getTblRecados().getValueAt(this.vista.getTblRecados().getSelectedRow(),
							6);
					Object elimanado = this.vista.getTblRecados()
							.getValueAt(this.vista.getTblRecados().getSelectedRow(), 7);

				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblRecados().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

	}

}
