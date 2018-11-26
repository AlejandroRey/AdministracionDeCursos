package presentacion.vista;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AlumnoHistorialNotaPanel extends JPanel {
	
	private JScrollPane spCursadas;
	private DefaultTableModel modelCursadas;
	private JTable tablaCursadas;
	private String[] nombreColumnasCursadas = {"idCurso", "idCursada", "idAlumno", "nombre", "apellido", "telefono", "email", "curso", "tema", "fecha"};
	
	private JScrollPane spEvaluaciones;
	private DefaultTableModel modelEvaluaciones;
	private JTable tablaEvaluaciones;
	private String[] nombreColumnasEvaluaciones = {"idAlumno", "idEvaluacion", "idCursada", "idEvaluacionTipo", "parcial", "tema", "fecha", "nota"};
	
	private JLabel lblPromedio;
	private JButton btnImprimirHistorial;
	private JButton btnImprimirAnalitico;
	
	/**
	 * Create the Panel.
	 */
	public AlumnoHistorialNotaPanel() {
		super();
		
		this.setBounds(0, 0, 960, 550);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTablaCursadas();
		inicializartablaEvaluaciones();
	}
	
	private void inicializarTablaCursadas() {
		
		spCursadas = new JScrollPane();
		spCursadas.setBounds(10, 10, 500, 529);
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
		spEvaluaciones.setBounds(520, 10, 340, 289);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Nota Final", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(520, 310, 340, 80);
		add(panel);
		panel.setLayout(null);
		
		lblPromedio = new JLabel("");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPromedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromedio.setBounds(140, 13, 60, 60);
		panel.add(lblPromedio);
		
		btnImprimirHistorial = new JButton("Imprimir Historial");
		btnImprimirHistorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnImprimirHistorial.setBounds(520, 401, 340, 59);
		add(btnImprimirHistorial);
		
		btnImprimirAnalitico = new JButton("Imprimir Analitico");
		btnImprimirAnalitico.setBounds(520, 480, 340, 59);
		add(btnImprimirAnalitico);
	}

	/**
	 * @return the spCursadas
	 */
	public JScrollPane getSpCursadas() {
		return spCursadas;
	}

	/**
	 * @param spCursadas the spCursadas to set
	 */
	public void setSpCursadas(JScrollPane spCursadas) {
		this.spCursadas = spCursadas;
	}

	/**
	 * @return the modelCursadas
	 */
	public DefaultTableModel getModelCursadas() {
		return modelCursadas;
	}

	/**
	 * @param modelCursadas the modelCursadas to set
	 */
	public void setModelCursadas(DefaultTableModel modelCursadas) {
		this.modelCursadas = modelCursadas;
	}

	/**
	 * @return the tablaCursadas
	 */
	public JTable getTablaCursadas() {
		return tablaCursadas;
	}

	/**
	 * @param tablaCursadas the tablaCursadas to set
	 */
	public void setTablaCursadas(JTable tablaCursadas) {
		this.tablaCursadas = tablaCursadas;
	}

	/**
	 * @return the nombreColumnasCursadas
	 */
	public String[] getNombreColumnasCursadas() {
		return nombreColumnasCursadas;
	}

	/**
	 * @param nombreColumnasCursadas the nombreColumnasCursadas to set
	 */
	public void setNombreColumnasCursadas(String[] nombreColumnasCursadas) {
		this.nombreColumnasCursadas = nombreColumnasCursadas;
	}

	/**
	 * @return the spEvaluaciones
	 */
	public JScrollPane getSpEvaluaciones() {
		return spEvaluaciones;
	}

	/**
	 * @param spEvaluaciones the spEvaluaciones to set
	 */
	public void setSpEvaluaciones(JScrollPane spEvaluaciones) {
		this.spEvaluaciones = spEvaluaciones;
	}

	/**
	 * @return the modelEvaluaciones
	 */
	public DefaultTableModel getModelEvaluaciones() {
		return modelEvaluaciones;
	}

	/**
	 * @param modelEvaluaciones the modelEvaluaciones to set
	 */
	public void setModelEvaluaciones(DefaultTableModel modelEvaluaciones) {
		this.modelEvaluaciones = modelEvaluaciones;
	}

	/**
	 * @return the tablaEvaluaciones
	 */
	public JTable getTablaEvaluaciones() {
		return tablaEvaluaciones;
	}

	/**
	 * @param tablaEvaluaciones the tablaEvaluaciones to set
	 */
	public void setTablaEvaluaciones(JTable tablaEvaluaciones) {
		this.tablaEvaluaciones = tablaEvaluaciones;
	}

	/**
	 * @return the nombreColumnasEvaluaciones
	 */
	public String[] getNombreColumnasEvaluaciones() {
		return nombreColumnasEvaluaciones;
	}

	/**
	 * @param nombreColumnasEvaluaciones the nombreColumnasEvaluaciones to set
	 */
	public void setNombreColumnasEvaluaciones(String[] nombreColumnasEvaluaciones) {
		this.nombreColumnasEvaluaciones = nombreColumnasEvaluaciones;
	}

	/**
	 * @return the lblPromedio
	 */
	public JLabel getLblPromedio() {
		return lblPromedio;
	}

	/**
	 * @param lblPromedio the lblPromedio to set
	 */
	public void setLblPromedio(JLabel lblPromedio) {
		this.lblPromedio = lblPromedio;
	}

	/**
	 * @return the btnImprimirHistorial
	 */
	public JButton getBtnImprimirHistorial() {
		return btnImprimirHistorial;
	}

	/**
	 * @param btnImprimirHistorial the btnImprimirHistorial to set
	 */
	public void setBtnImprimirHistorial(JButton btnImprimirHistorial) {
		this.btnImprimirHistorial = btnImprimirHistorial;
	}

	/**
	 * @return the btnImprimirAnalitico
	 */
	public JButton getBtnImprimirAnalitico() {
		return btnImprimirAnalitico;
	}

	/**
	 * @param btnImprimirAnalitico the btnImprimirAnalitico to set
	 */
	public void setBtnImprimirAnalitico(JButton btnImprimirAnalitico) {
		this.btnImprimirAnalitico = btnImprimirAnalitico;
	}
}
