package presentacion.vista;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class AlumnoHistorialNotaPanel extends JPanel {
	
	private JScrollPane spCursadas;
	private DefaultTableModel modelCursadas;
	private JTable tablaCursadas;
	private String[] nombreColumnasCursadas = {"idFechaCursada", "idCursada", "idSala", "fechaInicio", "fechaFin", "Fecha", "Ini", "Fin","Pre", "Aus"};
	
	private JScrollPane spEvaluaciones;
	private DefaultTableModel modelEvaluaciones;
	private JTable tablaEvaluaciones;
	private String[] nombreColumnasEvaluaciones = {"idFechaCursada", "idCursada", "idSala", "fechaInicio", "fechaFin", "Fecha", "Ini", "Fin","Pre", "Aus"};
	
	
	/**
	 * Create the Panel.
	 */
	public AlumnoHistorialNotaPanel() {
		super();
		
		this.setBounds(0, 0, 960, 500);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTablaCursadas();
		inicializartablaEvaluaciones();
	}
	
	private void inicializarTablaCursadas() {
		
		spCursadas = new JScrollPane();
		spCursadas.setBounds(10, 90, 338, 379);
		add(spCursadas);
		
		modelCursadas = new DefaultTableModel(null, nombreColumnasCursadas);
		tablaCursadas = new JTable(modelCursadas) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}
		};
		
		tablaCursadas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spCursadas.setViewportView(tablaCursadas);		
	}
	
	private void inicializartablaEvaluaciones() {

		spEvaluaciones = new JScrollPane();
		spEvaluaciones.setBounds(367, 90, 338, 379);
		add(spEvaluaciones);

		modelEvaluaciones = new DefaultTableModel(null, nombreColumnasEvaluaciones);
		tablaEvaluaciones = new JTable(modelEvaluaciones) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(
						Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}
		};

		tablaEvaluaciones.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		// tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		spEvaluaciones.setViewportView(tablaEvaluaciones);
	}

}
