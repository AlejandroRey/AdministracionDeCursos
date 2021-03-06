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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SalaABMPanel extends JPanel {

	private JScrollPane spSalas;
	private JTable tableSalas;
	private DefaultTableModel modelSalas;
	private TableRowSorter<TableModel> modeloOrdenado;
	private String[] nombreColumnas = { "ID", "Nombre", "Cantidad de Alumnos", "Cantidad de Pc", "Descripcion" };

	private JPanel panel;
	private JTextField txtNombre;
	private JTextField txtCantidadDePc;
	private JTextField txtCantidadDeAlumnos;
	private JTextField txtID;
	private JPanel panelDescripcion;
	private JScrollPane spDescripcion;
	private JTextArea textAreaDescripcion;

	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnVerDisponibilidad;

	public SalaABMPanel() {
		super();
		setBackground(UIManager.getColor("Panel.background"));
		inicializarSalaABMPanel();
	}

	private void inicializarSalaABMPanel() {
		inicializarPanel();
		inicializarTablaSalas();
		inicializarPanelEditorSalas();
		inicializarLbls();
		inicializarTxts();
		inicializarBtns();
	}

	private void inicializarPanel() {
		setBounds(0, 0, 1079, 595);
		setLayout(null);
	}

	private void inicializarPanelEditorSalas() {
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Panel.background"));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(10, 28, 405, 327);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Sala - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("OptionPane.foreground")));
		panel.setLayout(null);
		this.add(panel);
	}

	private void inicializarTablaSalas() {
		spSalas = new JScrollPane();
		spSalas.getViewport().setBackground(UIManager.getColor("Panel.background"));
		spSalas.setBounds(440, 28, 615, 387);
		this.add(spSalas);

		modelSalas = new DefaultTableModel(null, nombreColumnas) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableSalas = new JTable(modelSalas) {
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
		tableSalas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		spSalas.setViewportView(tableSalas);

		modeloOrdenado = new TableRowSorter<TableModel>(modelSalas);
		tableSalas.setRowSorter(modeloOrdenado);

		JSeparator separator = new JSeparator();
		separator.setBounds(440, 426, 615, 10);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		this.add(separator);
	}

	private void inicializarLbls() {
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(UIManager.getColor("OptionPane.foreground"));
		lblNombre.setBounds(10, 30, 92, 14);
		panel.add(lblNombre);

		JLabel lblCantidadDePc = new JLabel("Cantidad de Pc:");
		lblCantidadDePc.setForeground(UIManager.getColor("OptionPane.foreground"));
		lblCantidadDePc.setBounds(10, 65, 92, 14);
		panel.add(lblCantidadDePc);

		JLabel lblCantidadDeAlumnos = new JLabel("Cantidad de Alumnos:");
		lblCantidadDeAlumnos.setForeground(UIManager.getColor("OptionPane.foreground"));
		lblCantidadDeAlumnos.setBounds(10, 101, 112, 14);
		panel.add(lblCantidadDeAlumnos);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(UIManager.getColor("OptionPane.foreground"));
		lblId.setVisible(false);
		lblId.setBounds(10, 262, 46, 14);
		panel.add(lblId);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(UIManager.getColor("OptionPane.foreground"));
		lblDescripcion.setBounds(10, 139, 92, 14);
		panel.add(lblDescripcion);

	}

	private void inicializarTxts() {

		txtNombre = new JTextField();
		txtNombre.setBounds(132, 27, 251, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtCantidadDePc = new JTextField();
		txtCantidadDePc.setBounds(132, 63, 251, 20);
		panel.add(txtCantidadDePc);
		txtCantidadDePc.setColumns(10);

		txtCantidadDeAlumnos = new JTextField();
		txtCantidadDeAlumnos.setColumns(10);
		txtCantidadDeAlumnos.setBounds(132, 95, 251, 20);
		panel.add(txtCantidadDeAlumnos);

		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setEnabled(false);
		txtID.setBounds(70, 259, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		panelDescripcion = new JPanel();
		panelDescripcion.setBounds(134, 142, 249, 106);
		panelDescripcion.setLayout(new BorderLayout(0, 0));
		panel.add(panelDescripcion);

		spDescripcion = new JScrollPane();
		panelDescripcion.add(spDescripcion, BorderLayout.CENTER);

		textAreaDescripcion = new JTextArea();
		spDescripcion.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
	}

	private void inicializarBtns() {
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(276, 258, 107, 23);
		panel.add(btnAgregar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(276, 258, 107, 23);
		panel.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(276, 258, 107, 23);
		panel.add(btnEliminar);

		btnVerDisponibilidad = new JButton("Ver Disponibilidad");
		btnVerDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVerDisponibilidad.setBounds(879, 447, 176, 31);
		add(btnVerDisponibilidad);
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton button) {
		this.btnAgregar = button;
	}

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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @return the btnVerDisponibilidad
	 */
	public JButton getBtnVerDisponibilidad() {
		return btnVerDisponibilidad;
	}

	/**
	 * @param btnVerDisponibilidad
	 *            the btnVerDisponibilidad to set
	 */
	public void setBtnVerDisponibilidad(JButton btnVerDisponibilidad) {
		this.btnVerDisponibilidad = btnVerDisponibilidad;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtCantidadDePc() {
		return txtCantidadDePc;
	}

	public void setTxtCantidadDePc(JTextField txtCantidadDePc) {
		this.txtCantidadDePc = txtCantidadDePc;
	}

	public JTextField getTxtCantidadDeAlumnos() {
		return txtCantidadDeAlumnos;
	}

	public void setTxtCantidadDeAlumnos(JTextField txtCantidadDeAlumnos) {
		this.txtCantidadDeAlumnos = txtCantidadDeAlumnos;
	}

	public JTextArea getTxtAreaDescripcion() {
		return textAreaDescripcion;
	}

	public void setTxtAreaDescripcion(JTextArea txtArea) {
		this.textAreaDescripcion = txtArea;
	}

	public JTable getTableSalas() {
		return tableSalas;
	}

	public void setTableSalas(JTable table) {
		this.tableSalas = table;
	}

	public DefaultTableModel getModelSalas() {
		return modelSalas;
	}

	public void setModelSalas(DefaultTableModel dtmodel) {
		this.modelSalas = dtmodel;
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
	 * @param nombreColumnas
	 *            the nombreColumnas to set
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
	 * @param txtID
	 *            the txtID to set
	 */
	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}
}
