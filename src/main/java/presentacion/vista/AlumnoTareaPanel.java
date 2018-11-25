package presentacion.vista;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.SystemColor;
 


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
 
@SuppressWarnings("serial")
public class AlumnoTareaPanel extends JPanel{
	
	private JScrollPane spTareas;
	private JTable tableTareas;
	private DefaultTableModel modelTareas;
	private TableRowSorter<TableModel> modeloOrdenado;
	private String[] nombreColumnas = {"ID", "Tarea", "Descripcion", "Estado", "Responsable" , "ID Reponsable", "Fecha de Creacion", "Hora de Creacion","Fecha a realizar","Hora Realizar", "Fecha de cierre", "Hora de cierre","IDAlumno"};
 	private JComboBox<String> cboxTareas;
	private JComboBox<String> cboxEstado;
	private JPanel panel;
	private JScrollPane scrollPane;
 	
	public AlumnoTareaPanel() {
		super();
		setBackground(UIManager.getColor("Panel.background"));
		inicializarTareaAlumnoPanel();
	}
 	private void inicializarTareaAlumnoPanel() {
		inicializarPanel();
		inicializarTablaTareas(); 
		inicializarCbox();
	}
 	private void inicializarPanel() {
		setBounds(0, 0, 1162, 617);
		setLayout(null);
	}
 	private void inicializarCbox() {
		cboxTareas = new JComboBox<>();
		cboxTareas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboxTareas.setModel(new DefaultComboBoxModel<String>(new String[] {"Todas", "Mis tareas"}));
		cboxTareas.setBounds(27, 34, 100, 20);
		add(cboxTareas);
		
		cboxEstado = new JComboBox<>();
		cboxEstado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboxEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Todas", "Pendientes", "Realizadas"}));
		cboxEstado.setBounds(633, 34, 100, 20);
		add(cboxEstado);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(769, 48, 363, 531);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
	}
 	private void inicializarTablaTareas() {
		spTareas = new JScrollPane();
		spTareas.getViewport().setBackground(UIManager.getColor("Panel.background"));
		spTareas.setBounds(27, 65, 706, 507);
		this.add(spTareas);
		
		modelTareas = new DefaultTableModel(null, nombreColumnas){public boolean isCellEditable(int row, int column){return false;}};
		tableTareas = new JTable(modelTareas){
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		};
		tableTareas.setOpaque(false);
		tableTareas.getTableHeader().setBackground(new Color(255, 255, 255));
		tableTareas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		spTareas.setViewportView(tableTareas);
		
		modeloOrdenado = new TableRowSorter<TableModel>(modelTareas);
		tableTareas.setRowSorter(modeloOrdenado);
 		JSeparator separator = new JSeparator();
		separator.setBounds(27, 583, 706, 1);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		this.add(separator);
	}
 	/**
	 * @return the spTareas
	 */
	public JScrollPane getSpTareas() {
		return spTareas;
	}
 	/**
	 * @param spTareas the spTareas to set
	 */
	public void setSpTareas(JScrollPane spTareas) {
		this.spTareas = spTareas;
	}
 	/**
	 * @return the tableTareas
	 */
	public JTable getTableTareas() {
		return tableTareas;
	}
 	/**
	 * @param tableTareas the tableTareas to set
	 */
	public void setTableTareas(JTable tableTareas) {
		this.tableTareas = tableTareas;
	}
 	/**
	 * @return the modelTareas
	 */
	public DefaultTableModel getModelTareas() {
		return modelTareas;
	}
 	/**
	 * @param modelTareas the modelTareas to set
	 */
	public void setModelTareas(DefaultTableModel modelTareas) {
		this.modelTareas = modelTareas;
	}
 	/**
	 * @return the modeloOrdenado
	 */
	public TableRowSorter<TableModel> getModeloOrdenado() {
		return modeloOrdenado;
	}
 	/**
	 * @param modeloOrdenado the modeloOrdenado to set
	 */
	public void setModeloOrdenado(TableRowSorter<TableModel> modeloOrdenado) {
		this.modeloOrdenado = modeloOrdenado;
	}
 	/**
	 * @return the nombreColumnas
	 */
	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
 	/**
	 * @param nombreColumnas the nombreColumnas to set
	 */
	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}
 	/**
	 * @return the cboxTareas
	 */
	public JComboBox<String> getCboxTareas() {
		return cboxTareas;
	}
 	/**
	 * @param cboxTareas the cboxTareas to set
	 */
	public void setCboxTareas(JComboBox<String> cboxTareas) {
		this.cboxTareas = cboxTareas;
	}
 	/**
	 * @return the cboxEstado
	 */
	public JComboBox<String> getCboxEstado() {
		return cboxEstado;
	}
 	/**
	 * @param cboxEstado the cboxEstado to set
	 */
	public void setCboxEstado(JComboBox<String> cboxEstado) {
		this.cboxEstado = cboxEstado;
	}
}
