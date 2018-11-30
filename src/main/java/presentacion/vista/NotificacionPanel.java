package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class NotificacionPanel extends JPanel {
	private JScrollPane spNotificaciones;
	private DefaultTableModel modelNotificaciones;
	private TableRowSorter<TableModel> modeloOrdenadoNotificaciones;
	private JTable tblNotificaciones;
	private String[] nombreColumnas = {"idNotificacion","idUsuario", "tipoNotificacion", "Mensaje", "Visto", "Fecha y hora"};
	
	private JPanel panel;
	
	private JButton btnIrARecados;
	private JButton btnIrATareas;
	private JButton btnIrACursadas;
	private JButton btnMarcarComoNoLeido;
	private JTextField textFechaHora;
	private JLabel lblFiltrar;
	private JComboBox<String> comboBoxFiltro;
	private JTextArea textDetalle;

	/**
	 * Create the Panel.
	 */
	public NotificacionPanel() {
		super();
		this.setBounds(0, 0, 1025, 528);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTabla();
		inicializarEditor();
		
	}

	private void inicializarTabla() {
		
		spNotificaciones = new JScrollPane();
		spNotificaciones.setBounds(49, 45, 927, 310);
		this.add(spNotificaciones);
		
		modelNotificaciones = new DefaultTableModel(null, nombreColumnas);
		tblNotificaciones = new JTable(modelNotificaciones){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblNotificaciones.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);		
		spNotificaciones.setViewportView(tblNotificaciones);
		
		modeloOrdenadoNotificaciones = new TableRowSorter<TableModel>(modelNotificaciones);
		tblNotificaciones.setRowSorter(modeloOrdenadoNotificaciones);
		//modelNotificaciones = new DefaultTableModel(null, nombreColumnas);
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Detalles:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panel.setBounds(49, 366, 927, 151);
		this.add(panel);
		panel.setLayout(null);
		
		btnIrARecados = new JButton("Ir a Recados");
		btnIrARecados.setBounds(638, 114, 107, 23);
		panel.add(btnIrARecados);
		
		btnIrATareas = new JButton("Ir a Tareas");
		btnIrATareas.setBounds(638, 114, 107, 23);
		panel.add(btnIrATareas);
		
		btnIrACursadas = new JButton("Ir a Cursadas");
		btnIrACursadas.setBounds(638, 114, 107, 23);
		panel.add(btnIrACursadas);
		
		btnMarcarComoNoLeido = new JButton("Marcar como no leido");
		btnMarcarComoNoLeido.setBounds(772, 114, 141, 23);
		panel.add(btnMarcarComoNoLeido);
		
		textFechaHora = new JTextField();
		textFechaHora.setBounds(111, 120, 107, 20);
		panel.add(textFechaHora);
		textFechaHora.setColumns(10);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora");
		lblFechaYHora.setBounds(20, 123, 81, 14);
		panel.add(lblFechaYHora);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 903, 82);
		panel.add(scrollPane);
		
		textDetalle = new JTextArea();
		scrollPane.setViewportView(textDetalle);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(49, 364, 927, 2);
		this.add(separator);
		
		comboBoxFiltro = new JComboBox<>();
		comboBoxFiltro.setBounds(115, 14, 119, 20);
		add(comboBoxFiltro);
		
		lblFiltrar = new JLabel("Filtrar:");
		lblFiltrar.setBounds(51, 20, 54, 14);
		add(lblFiltrar);
	}

	public JScrollPane getSpNotificaciones() {
		return spNotificaciones;
	}

	public void setSpNotificaciones(JScrollPane spNotificaciones) {
		this.spNotificaciones = spNotificaciones;
	}

	public DefaultTableModel getModelNotificaciones() {
		return modelNotificaciones;
	}

	public void setModelNotificaciones(DefaultTableModel modelNotificaciones) {
		this.modelNotificaciones = modelNotificaciones;
	}

	public JTable getTblNotificaciones() {
		return tblNotificaciones;
	}

	public void setTblNotificaciones(JTable tblNotificaciones) {
		this.tblNotificaciones = tblNotificaciones;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnIrARecados() {
		return btnIrARecados;
	}

	public void setBtnIrARecados(JButton btnIrARecados) {
		this.btnIrARecados = btnIrARecados;
	}

	public JButton getBtnIrATareas() {
		return btnIrATareas;
	}

	public void setBtnIrATareas(JButton btnIrATareas) {
		this.btnIrATareas = btnIrATareas;
	}

	public JButton getBtnIrACursadas() {
		return btnIrACursadas;
	}

	public void setBtnIrACursadas(JButton btnIrACursadas) {
		this.btnIrACursadas = btnIrACursadas;
	}

	public JButton getBtnMarcarComoNoLeido() {
		return btnMarcarComoNoLeido;
	}

	public void setBtnMarcarComoNoLeido(JButton btnMarcarComoLeido) {
		this.btnMarcarComoNoLeido = btnMarcarComoLeido;
	}

	public JTextField getTextFechaHora() {
		return textFechaHora;
	}

	public void setTextFechaHora(JTextField textFechaHora) {
		this.textFechaHora = textFechaHora;
	}

	public JComboBox<String> getComboBoxFiltro() {
		return comboBoxFiltro;
	}

	public void setComboBoxFiltro(JComboBox<String> comboBoxFiltro) {
		this.comboBoxFiltro = comboBoxFiltro;
	}

	public JTextArea getTextDetalle() {
		return textDetalle;
	}

	public void setTextDetalle(JTextArea textDetalle) {
		this.textDetalle = textDetalle;
	}

	public TableRowSorter<TableModel> getModeloOrdenadoNotificaciones() {
		return modeloOrdenadoNotificaciones;
	}

	public void setModeloOrdenadoNotificaciones(TableRowSorter<TableModel> modeloOrdenadoNotificaciones) {
		this.modeloOrdenadoNotificaciones = modeloOrdenadoNotificaciones;
	}
}
