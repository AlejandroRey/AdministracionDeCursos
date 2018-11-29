package presentacion.vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class SalaDisponibilidadPanel extends JPanel {
	
	private JCalendar calendar;
	private JTable tableHorarios;
	private DefaultTableModel modelHorarios;
	private TableRowSorter<TableModel> modeloOrdenadoHorarios;
	private String [] nombreColumnasHorarios = {"Hora inicio","Hora fin","Curso"};
	private JScrollPane spHorarios;
	
	public SalaDisponibilidadPanel() { 
		super();
		inicializar();
	}

	private void inicializar() {
		setLayout(null);
		inicializarJCalendar();
		inicializarScrollPanelHorarios();
	}

	private void inicializarJCalendar() {
		calendar = new JCalendar();
		calendar.setBounds(10, 11, 430, 165);
		add(calendar);		
	}

	private void inicializarScrollPanelHorarios() {
		spHorarios = new JScrollPane();
		spHorarios.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Horarios:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		spHorarios.setToolTipText("Horarios:");
		spHorarios.setBounds(10, 202, 430, 319);
		add(spHorarios);
		inicializarTableHorarios();
	}

	private void inicializarTableHorarios() {
		inicializeModel();
		generateTable();
		tableHorarios.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		modeloOrdenadoHorarios = new TableRowSorter<TableModel>(modelHorarios);
		tableHorarios.setRowSorter(modeloOrdenadoHorarios);
		spHorarios.setViewportView(tableHorarios);
	}
	
	private void inicializeModel() {
		modelHorarios = new DefaultTableModel(null, nombreColumnasHorarios) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
	
	private void generateTable() {
		tableHorarios = new JTable(modelHorarios){
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
				}
		};
	}
	
	/**
	 * @return the calendar
	 */
	public JCalendar getCalendar() {
		return calendar;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * @return the tableHorarios
	 */
	public JTable getTableHorarios() {
		return tableHorarios;
	}

	/**
	 * @param tableHorarios the tableHorarios to set
	 */
	public void setTableHorarios(JTable tableHorarios) {
		this.tableHorarios = tableHorarios;
	}

	/**
	 * @return the modelHorarios
	 */
	public DefaultTableModel getModelHorarios() {
		return modelHorarios;
	}

	/**
	 * @param modelHorarios the modelHorarios to set
	 */
	public void setModelHorarios(DefaultTableModel modelHorarios) {
		this.modelHorarios = modelHorarios;
	}

	/**
	 * @return the modeloOrdenadoHorarios
	 */
	public TableRowSorter<TableModel> getModeloOrdenadoHorarios() {
		return modeloOrdenadoHorarios;
	}

	/**
	 * @param modeloOrdenadoHorarios the modeloOrdenadoHorarios to set
	 */
	public void setModeloOrdenadoHorarios(
			TableRowSorter<TableModel> modeloOrdenadoHorarios) {
		this.modeloOrdenadoHorarios = modeloOrdenadoHorarios;
	}

	/**
	 * @return the nombreColumnasHorarios
	 */
	public String[] getNombreColumnasHorarios() {
		return nombreColumnasHorarios;
	}

	/**
	 * @param nombreColumnasHorarios the nombreColumnasHorarios to set
	 */
	public void setNombreColumnasHorarios(String[] nombreColumnasHorarios) {
		this.nombreColumnasHorarios = nombreColumnasHorarios;
	}

	/**
	 * @return the spHorarios
	 */
	public JScrollPane getSpHorarios() {
		return spHorarios;
	}

	/**
	 * @param spHorarios the spHorarios to set
	 */
	public void setSpHorarios(JScrollPane spHorarios) {
		this.spHorarios = spHorarios;
	}

}
