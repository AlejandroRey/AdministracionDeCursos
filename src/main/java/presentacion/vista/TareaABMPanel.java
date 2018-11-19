package presentacion.vista;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class TareaABMPanel extends JPanel {

	private JScrollPane spTareas;
	private JTable tableTareas;
	private DefaultTableModel modelTareas;
	private TableRowSorter<TableModel> modeloOrdenado;
	private String[] nombreColumnas = {"ID", "Tarea", "Descripcion", "Estado", "Responsable" , "ID Reponsable", "Fecha de Creacion", "Fecha de cierre", "IDAlumno"};
	
	private JScrollPane spAdministrativos;
	private JTable tableAdministrativos;
	private DefaultTableModel modelAdministrativos;
	private TableRowSorter<TableModel> modeloOrdenadoAdministrativos;
	private String[] nombreColumnasAdministrativos = {"Id", "idCategoria", "Categoria", "Nombre", "Apellido", "Telefono", "Email", "Usuario", "Password"};
	
	private JPanel panelEditor;
	private JTextField txtNombre;
	private JTextField txtResponsable;
	private JTextField txtFecha;
	private JTextField txtID;
	private JTextField txtIDResponsable;
	private JTextField txtEstado;

	private JPanel panelDescripcion;
	private JScrollPane spDescripcion;
	private JTextArea textAreaDescripcion;
	
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnSeleccionarResponsable;
	private JLabel lblId;
	private JButton btnMarcarComoRealizada;
	private JComboBox<String> cboxTareas;
	private JComboBox<String> cboxEstado;
	private JTextField txtIDAlumno;
	
	public TareaABMPanel() {
		super();
		setBackground(new Color(41, 57, 80));
		inicializarTareaABMPanel();
	}

	private void inicializarTareaABMPanel() {
		inicializarPanel();
		inicializarTablaTareas(); 
		inicializarCbox();
		inicializarPanelEditorTareas();
		inicializarPanelAdministrativos();
		inicializarLbls();
		inicializarTxts();
		inicializarBtns();
	}

	private void inicializarPanel() {
		setBounds(0, 0, 1181, 679);
		setLayout(null);
	}

	private void inicializarPanelEditorTareas() {
		panelEditor = new JPanel();
		panelEditor.setForeground(new Color(255, 255, 255));
		panelEditor.setBackground(new Color(41, 57, 80));
		panelEditor.setBounds(27, 390, 706, 278);
		panelEditor.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Tarea - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelEditor.setLayout(null);
		this.add(panelEditor);
	}
	
	private void inicializarPanelAdministrativos() {
		spAdministrativos = new JScrollPane();
		spAdministrativos.getViewport().setBackground(new Color(41, 57, 80));
		spAdministrativos.setBounds(758, 27, 396, 641);
		spAdministrativos.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Administrativos:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		this.add(spAdministrativos);
		
		modelAdministrativos = new DefaultTableModel(null, nombreColumnasAdministrativos){public boolean isCellEditable(int row, int column){return false;}};
		tableAdministrativos = new JTable(modelAdministrativos){
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		};
		tableAdministrativos.setOpaque(false);
		tableAdministrativos.getTableHeader().setBackground(new Color(255, 255, 255));
		tableAdministrativos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		spAdministrativos.setViewportView(tableAdministrativos);
		
		modeloOrdenadoAdministrativos = new TableRowSorter<TableModel>(modelAdministrativos);
		tableAdministrativos.setRowSorter(modeloOrdenadoAdministrativos);
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
		spTareas.getViewport().setBackground(new Color(41, 57, 80));
		spTareas.setBounds(27, 65, 706, 302);
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
		separator.setBounds(27, 378, 706, 1);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		this.add(separator);
	}

	private void inicializarLbls() {
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(10, 30, 58, 14);
		panelEditor.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setBounds(10, 59, 46, 14);
		panelEditor.add(lblFecha);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setBounds(10, 115, 98, 14);
		panelEditor.add(lblDescripcion);
		
		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setForeground(new Color(255, 255, 255));
		lblResponsable.setBounds(382, 30, 91, 14);
		panelEditor.add(lblResponsable);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(new Color(255, 255, 255));
		lblEstado.setBounds(10, 87, 46, 14);
		panelEditor.add(lblEstado);
		
		lblId = new JLabel("ID:");
		lblId.setVisible(false);
		lblId.setEnabled(false);
		lblId.setBounds(407, 122, 30, 14);
		panelEditor.add(lblId);

	}

	private void inicializarTxts() {
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 27, 244, 20);
		panelEditor.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(85, 56, 98, 20);
		panelEditor.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setEditable(false);
		txtID.setEnabled(false);
		txtID.setBounds(504, 116, 86, 20);
		panelEditor.add(txtID);
		txtID.setColumns(10);
		
		txtIDResponsable = new JTextField();
		txtIDResponsable.setVisible(false);
		txtIDResponsable.setEditable(false);
		txtIDResponsable.setEnabled(false);
		txtIDResponsable.setBounds(599, 116, 86, 20);
		panelEditor.add(txtIDResponsable);
		txtIDResponsable.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBackground(Color.WHITE);
		txtEstado.setDisabledTextColor(Color.WHITE);
		txtEstado.setBounds(85, 84, 98, 20);
		panelEditor.add(txtEstado);
		txtEstado.setColumns(10);

		
		txtResponsable = new JTextField();
		txtResponsable.setBackground(Color.WHITE);
		txtResponsable.setEditable(false);
		txtResponsable.setColumns(10);
		txtResponsable.setBounds(483, 27, 181, 20);
		panelEditor.add(txtResponsable);
		
		panelDescripcion = new JPanel();
		panelDescripcion.setBounds(10, 147, 686, 83);
		panelEditor.add(panelDescripcion);
		panelDescripcion.setLayout(new BorderLayout(0, 0));
		
		spDescripcion = new JScrollPane();
		panelDescripcion.add(spDescripcion, BorderLayout.CENTER);
		
		textAreaDescripcion = new JTextArea();
		spDescripcion.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
	}

	private void inicializarBtns() {
		btnSeleccionarResponsable = new JButton("Seleccionar Responsable");
		btnSeleccionarResponsable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSeleccionarResponsable.setBounds(493, 55, 171, 23);
		panelEditor.add(btnSeleccionarResponsable);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setBounds(589, 241, 107, 23);
		panelEditor.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(589, 241, 107, 23);
		panelEditor.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(589, 241, 107, 23);
		panelEditor.add(btnEliminar);
		
		btnMarcarComoRealizada = new JButton("Marcar como realizada");
		btnMarcarComoRealizada.setFocusPainted(false);
		btnMarcarComoRealizada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMarcarComoRealizada.setBounds(430, 241, 139, 23);
		panelEditor.add(btnMarcarComoRealizada);
		
		txtIDAlumno = new JTextField();
		txtIDAlumno.setEditable(false);
		txtIDAlumno.setEnabled(false);
		txtIDAlumno.setBounds(448, 115, 46, 20);
		panelEditor.add(txtIDAlumno);
		txtIDAlumno.setColumns(10);
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton button) {
		this.btnAgregar = button;}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton button) {
		this.btnActualizar = button;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton button) {
		this.btnEliminar = button;
	}

	public JButton getBtnSelecionarResponsable() {
		return btnSeleccionarResponsable;
	}

	public void setBtnSelecionarResponsable(JButton btnSeleccionarResponsable) {
		this.btnSeleccionarResponsable = btnSeleccionarResponsable;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	
	/**
	 * @return the txtFecha
	 */
	public JTextField getTxtFecha() {
		return txtFecha;
	}

	/**
	 * @param txtFecha the txtFecha to set
	 */
	public void setTxtFecha(JTextField txtFecha) {
		this.txtFecha = txtFecha;
	}

	public JTextField getTxtResponsable() {
		return txtResponsable;
	}

	public void setTxtResponsable(JTextField txtResponsable) {
		this.txtResponsable = txtResponsable;
	}

	public JTextArea getTxtAreaDescripcion() {
		return textAreaDescripcion;
	}

	public void setTxtAreaDescripcion(JTextArea txtArea) {
		this.textAreaDescripcion = txtArea;
	}
	
	/**
	 * @return the txtEstado
	 */
	public JTextField getTxtEstado() {
		return txtEstado;
	}

	/**
	 * @param txtEstado the txtEstado to set
	 */
	public void setTxtEstado(JTextField txtEstado) {
		this.txtEstado = txtEstado;
	}

	public JTable getTableTareas() {
		return tableTareas;
	}

	public void setTableTareas(JTable table) {
		this.tableTareas = table;
	}

	public DefaultTableModel getModelTareas() {
		return modelTareas;
	}

	public void setModelTareas(DefaultTableModel dtmodel) {
		this.modelTareas = dtmodel;
	}

	public TableRowSorter<TableModel> getModeloOrdenado() {
		return modeloOrdenado;
	}

	public void setModeloOrdenado(TableRowSorter<TableModel> model) {
		this.modeloOrdenado = model;
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
	 * @return the txtID
	 */
	public JTextField getTxtID() {
		return txtID;
	}

	/**
	 * @param txtID the txtID to set
	 */
	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	/**
	 * @return the txtIDResponsable
	 */
	public JTextField getTxtIDResponsable() {
		return txtIDResponsable;
	}

	/**
	 * @param txtIDResponsable the txtIDResponsable to set
	 */
	public void setTxtIDResponsable(JTextField txtIDResponsable) {
		this.txtIDResponsable = txtIDResponsable;
	}
	
	/**
	 * @return the tableAdministrativos
	 */
	public JTable getTableAdministrativos() {
		return tableAdministrativos;
	}

	/**
	 * @param tableAdministrativos the tableAdministrativos to set
	 */
	public void setTableAdministrativos(JTable tableAdministrativos) {
		this.tableAdministrativos = tableAdministrativos;
	}

	/**
	 * @return the modelAdministrativos
	 */
	public DefaultTableModel getModelAdministrativos() {
		return modelAdministrativos;
	}

	/**
	 * @param modelAdministrativos the modelAdministrativos to set
	 */
	public void setModelAdministrativos(DefaultTableModel modelAdministrativos) {
		this.modelAdministrativos = modelAdministrativos;
	}

	/**
	 * @return the modeloOrdenadoAdministrativos
	 */
	public TableRowSorter<TableModel> getModeloOrdenadoAdministrativos() {
		return modeloOrdenadoAdministrativos;
	}

	/**
	 * @param modeloOrdenadoAdministrativos the modeloOrdenadoAdministrativos to set
	 */
	public void setModeloOrdenadoAdministrativos(
			TableRowSorter<TableModel> modeloOrdenadoAdministrativos) {
		this.modeloOrdenadoAdministrativos = modeloOrdenadoAdministrativos;
	}

	/**
	 * @return the nombreColumnasAdministrativos
	 */
	public String[] getNombreColumnasAdministrativos() {
		return nombreColumnasAdministrativos;
	}

	/**
	 * @param nombreColumnasAdministrativos the nombreColumnasAdministrativos to set
	 */
	public void setNombreColumnasAdministrativos(
			String[] nombreColumnasAdministrativos) {
		this.nombreColumnasAdministrativos = nombreColumnasAdministrativos;
	}
	
	/**
	 * @return the spAdministrativos
	 */
	public JScrollPane getSpAdministrativos() {
		return spAdministrativos;
	}

	/**
	 * @param spAdministrativos the spAdministrativos to set
	 */
	public void setSpAdministrativos(JScrollPane spAdministrativos) {
		this.spAdministrativos = spAdministrativos;
	}

	/**
	 * @return the btnMarcarComoRealizada
	 */
	public JButton getBtnMarcarComoRealizada() {
		return btnMarcarComoRealizada;
	}

	/**
	 * @param btnMarcarComoRealizada the btnMarcarComoRealizada to set
	 */
	public void setBtnMarcarComoRealizada(JButton btnMarcarComoRealizada) {
		this.btnMarcarComoRealizada = btnMarcarComoRealizada;
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

	/**
	 * @return the txtIDAlumno
	 */
	public JTextField getTxtIDAlumno() {
		return txtIDAlumno;
	}

	/**
	 * @param txtIDAlumno the txtIDAlumno to set
	 */
	public void setTxtIDAlumno(JTextField txtIDAlumno) {
		this.txtIDAlumno = txtIDAlumno;
	}
}