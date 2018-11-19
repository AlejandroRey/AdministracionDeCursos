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
 
@SuppressWarnings("serial")
public class AlumnoTareaPanel extends JPanel{
	
	private JScrollPane spTareas;
	private JTable tableTareas;
	private DefaultTableModel modelTareas;
	private TableRowSorter<TableModel> modeloOrdenado;
	private String[] nombreColumnas = {"ID", "Tarea", "Descripcion", "Estado", "Responsable" , "ID Reponsable", "Fecha de Creacion", "Fecha de cierre", "IDAlumno"};
 	private JComboBox<String> cboxTareas;
	private JComboBox<String> cboxEstado;
 	
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
		setBounds(0, 0, 764, 617);
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
 //	private void inicializarTxts() {
//		txtNombre = new JTextField();
//		txtNombre.setBounds(85, 27, 244, 20);
//		panelEditor.add(txtNombre);
//		txtNombre.setColumns(10);
//		
//		txtFecha = new JTextField();
//		txtFecha.setBounds(85, 56, 98, 20);
//		panelEditor.add(txtFecha);
//		txtFecha.setColumns(10);
//		
//		txtID = new JTextField();
//		txtID.setVisible(false);
//		txtID.setEditable(false);
//		txtID.setEnabled(false);
//		txtID.setBounds(504, 116, 86, 20);
//		panelEditor.add(txtID);
//		txtID.setColumns(10);
//		
//		txtIDResponsable = new JTextField();
//		txtIDResponsable.setVisible(false);
//		txtIDResponsable.setEditable(false);
//		txtIDResponsable.setEnabled(false);
//		txtIDResponsable.setBounds(599, 116, 86, 20);
//		panelEditor.add(txtIDResponsable);
//		txtIDResponsable.setColumns(10);
//		
//		txtEstado = new JTextField();
//		txtEstado.setEditable(false);
//		txtEstado.setBackground(Color.WHITE);
//		txtEstado.setDisabledTextColor(Color.WHITE);
//		txtEstado.setBounds(85, 84, 98, 20);
//		panelEditor.add(txtEstado);
//		txtEstado.setColumns(10);
//
//		
//		txtResponsable = new JTextField();
//		txtResponsable.setBackground(Color.WHITE);
//		txtResponsable.setEditable(false);
//		txtResponsable.setColumns(10);
//		txtResponsable.setBounds(483, 27, 181, 20);
//		panelEditor.add(txtResponsable);
//		
//		panelDescripcion = new JPanel();
//		panelDescripcion.setBounds(10, 147, 686, 83);
//		panelEditor.add(panelDescripcion);
//		panelDescripcion.setLayout(new BorderLayout(0, 0));
//		
//		spDescripcion = new JScrollPane();
//		panelDescripcion.add(spDescripcion, BorderLayout.CENTER);
//		
//		textAreaDescripcion = new JTextArea();
//		spDescripcion.setViewportView(textAreaDescripcion);
//		textAreaDescripcion.setLineWrap(true);
//		textAreaDescripcion.setWrapStyleWord(true);
//	}
 //	private void inicializarBtns() {
//		btnSeleccionarResponsable = new JButton("Seleccionar Responsable");
//		btnSeleccionarResponsable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnSeleccionarResponsable.setBounds(493, 55, 171, 23);
//		panelEditor.add(btnSeleccionarResponsable);
//		
//		btnAgregar = new JButton("Agregar");
//		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnAgregar.setBounds(589, 241, 107, 23);
//		panelEditor.add(btnAgregar);
//		
//		btnActualizar = new JButton("Actualizar");
//		btnActualizar.setBounds(589, 241, 107, 23);
//		panelEditor.add(btnActualizar);
//		
//		btnEliminar = new JButton("Eliminar");
//		btnEliminar.setBounds(589, 241, 107, 23);
//		panelEditor.add(btnEliminar);
//		
//		btnMarcarComoRealizada = new JButton("Marcar como realizada");
//		btnMarcarComoRealizada.setFocusPainted(false);
//		btnMarcarComoRealizada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnMarcarComoRealizada.setBounds(430, 241, 139, 23);
//		panelEditor.add(btnMarcarComoRealizada);
//		
//		txtIDAlumno = new JTextField();
//		txtIDAlumno.setEditable(false);
//		txtIDAlumno.setEnabled(false);
//		txtIDAlumno.setBounds(448, 115, 46, 20);
//		panelEditor.add(txtIDAlumno);
//		txtIDAlumno.setColumns(10);
//	}
}
