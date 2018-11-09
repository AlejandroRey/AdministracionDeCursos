package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AlumnosEvaluacionesPanel extends JPanel {	
	
	private JPanel panelEvaluacionSeleccionada;
	private JLabel lblEvaluacionSeleccionada;
	private JLabel lblEvaluacionSeleccionadaFecha;
	private JScrollPane spEvaluaciones;
	private DefaultTableModel modelEvaluaciones;
	private String[] nombreColumnasEvaluaciones = {"idEvaluacion", "idCursada", "idEvaluacionTipo", "Tema", "Tipo Parcial", "Fecha"};
	private JTable tablaEvaluaciones;
	
	private JPanel panelAlumnoSeleccionado;
	private JLabel lblAlumnoSeleccionado;
	private JScrollPane spAlumnos;
	private DefaultTableModel modelAlumnos;
	private String[] nombreColumnasAlumnos = {"idAlumno", "idCursada", "Nombre", "Apellido", "Telefono", "Email", "Fecha", "Estado", "Nota"};
	private JTable tablaAlumnos;	
	
	private JPanel panelNota;
	private JTable tablaNota;
	
	private JButton btnAgregarEvaluacion;	
	private JButton btnEliminarEvaluacion;
	private JButton btnActualizarEvaluacion;
	private JButton btnActualizarNota;
	private JTextField textNota;

	/**
	 * Create the Panel.
	 */
	public AlumnosEvaluacionesPanel() {
		super();
		this.setBounds(0, 0, 960, 600);

		inicializar();
	}

	private void inicializar() {

		buildEvaluaciones();
		buildAlumnos();
		buildNotas();
	}

	private void buildEvaluaciones() {
		setLayout(null);

		panelEvaluacionSeleccionada = new JPanel();
		panelEvaluacionSeleccionada.setBounds(10, 11, 311, 65);
		panelEvaluacionSeleccionada.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Evaluacion Seleccionada:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelEvaluacionSeleccionada);
		panelEvaluacionSeleccionada.setLayout(null);
		
		lblEvaluacionSeleccionada = new JLabel("--------");
		lblEvaluacionSeleccionada.setBounds(10, 13, 291, 25);
		panelEvaluacionSeleccionada.add(lblEvaluacionSeleccionada);
		lblEvaluacionSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluacionSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblEvaluacionSeleccionadaFecha = new JLabel("--------");
		lblEvaluacionSeleccionadaFecha.setBounds(10, 45, 291, 14);
		panelEvaluacionSeleccionada.add(lblEvaluacionSeleccionadaFecha);
		lblEvaluacionSeleccionadaFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluacionSeleccionadaFecha.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		btnAgregarEvaluacion = new JButton("Agregar Evaluacion");
		btnAgregarEvaluacion.setBounds(10, 454, 311, 35);
		btnAgregarEvaluacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregarEvaluacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnAgregarEvaluacion);
		
		buildTablaEvaluaciones();
	}

	private void buildTablaEvaluaciones() {

		spEvaluaciones = new JScrollPane();
		spEvaluaciones.setBounds(10, 80, 311, 348);
		add(spEvaluaciones);
		
		modelEvaluaciones = new DefaultTableModel(null, nombreColumnasEvaluaciones);
		tablaEvaluaciones = new JTable(modelEvaluaciones) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}
		};
		
		tablaEvaluaciones.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spEvaluaciones.setViewportView(tablaEvaluaciones);	
	}

	private void buildAlumnos() {

		panelAlumnoSeleccionado = new JPanel();
		panelAlumnoSeleccionado.setBounds(331, 11, 326, 65);
		panelAlumnoSeleccionado.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Alumno Seleccionado:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelAlumnoSeleccionado);
		panelAlumnoSeleccionado.setLayout(null);
		
		lblAlumnoSeleccionado = new JLabel("--------");
		lblAlumnoSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnoSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlumnoSeleccionado.setBounds(10, 21, 306, 33);
		panelAlumnoSeleccionado.add(lblAlumnoSeleccionado);
		
		buildTablaAlumnos();
	}

	private void buildTablaAlumnos() {

		spAlumnos = new JScrollPane();
		spAlumnos.setBounds(331, 80, 326, 348);
		add(spAlumnos);
		
		modelAlumnos = new DefaultTableModel(null, nombreColumnasAlumnos);
		tablaAlumnos = new JTable(modelAlumnos){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		
		tablaAlumnos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
				boolean status = (boolean) table.getModel().getValueAt(row, 7);
				if (status == false) {
					setBackground(Color.RED);
					setForeground(Color.WHITE);
				} else {
					setBackground(table.getBackground());
					setForeground(table.getForeground());
				}
				return this;
			}
		});
		    
		tablaAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spAlumnos.setViewportView(tablaAlumnos);			
	}

	private void buildNotas() {

		panelNota = new JPanel();
		panelNota.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Nota", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNota.setBounds(331, 439, 326, 104);
		add(panelNota);
		panelNota.setLayout(null);
		
		textNota = new JTextField();
		textNota.setBounds(147, 16, 33, 25);
		panelNota.add(textNota);
		textNota.setColumns(10);
		
		btnActualizarNota = new JButton("Actualizar Nota");
		btnActualizarNota.setBounds(10, 61, 306, 35);
		panelNota.add(btnActualizarNota);
		btnActualizarNota.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizarNota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnActualizarEvaluacion = new JButton("Actualizar");
		btnActualizarEvaluacion.setBounds(10, 554, 311, 35);
		btnActualizarEvaluacion.setVisible(false);
		btnActualizarEvaluacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizarEvaluacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnActualizarEvaluacion);
		
		btnEliminarEvaluacion = new JButton("Eliminar");
		btnEliminarEvaluacion.setBounds(10, 500, 311, 35);
		btnEliminarEvaluacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminarEvaluacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnEliminarEvaluacion);
	}

	/**
	 * @return the lblEvaluacionSeleccionada
	 */
	public JLabel getLblEvaluacionSeleccionada() {
		return lblEvaluacionSeleccionada;
	}

	/**
	 * @param lblEvaluacionSeleccionada the lblEvaluacionSeleccionada to set
	 */
	public void setLblEvaluacionSeleccionada(JLabel lblEvaluacionSeleccionada) {
		this.lblEvaluacionSeleccionada = lblEvaluacionSeleccionada;
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
	 * @return the lblAlumnoSeleccionado
	 */
	public JLabel getLblAlumnoSeleccionado() {
		return lblAlumnoSeleccionado;
	}

	/**
	 * @param lblAlumnoSeleccionado the lblAlumnoSeleccionado to set
	 */
	public void setLblAlumnoSeleccionado(JLabel lblAlumnoSeleccionado) {
		this.lblAlumnoSeleccionado = lblAlumnoSeleccionado;
	}

	/**
	 * @return the modelAlumnos
	 */
	public DefaultTableModel getModelAlumnos() {
		return modelAlumnos;
	}

	/**
	 * @param modelAlumnos the modelAlumnos to set
	 */
	public void setModelAlumnos(DefaultTableModel modelAlumnos) {
		this.modelAlumnos = modelAlumnos;
	}

	/**
	 * @return the tablaAlumnos
	 */
	public JTable getTablaAlumnos() {
		return tablaAlumnos;
	}

	/**
	 * @param tablaAlumnos the tablaAlumnos to set
	 */
	public void setTablaAlumnos(JTable tablaAlumnos) {
		this.tablaAlumnos = tablaAlumnos;
	}

	/**
	 * @return the tablaNota
	 */
	public JTable getTablaNota() {
		return tablaNota;
	}

	/**
	 * @param tablaNota the tablaNota to set
	 */
	public void setTablaNota(JTable tablaNota) {
		this.tablaNota = tablaNota;
	}

	/**
	 * @return the btnAgregarEvaluacion
	 */
	public JButton getBtnAgregarEvaluacion() {
		return btnAgregarEvaluacion;
	}

	/**
	 * @param btnAgregarEvaluacion the btnAgregarEvaluacion to set
	 */
	public void setBtnAgregarEvaluacion(JButton btnAgregarEvaluacion) {
		this.btnAgregarEvaluacion = btnAgregarEvaluacion;
	}

	/**
	 * @return the panelEvaluacionSeleccionada
	 */
	public JPanel getPanelEvaluacionSeleccionada() {
		return panelEvaluacionSeleccionada;
	}

	/**
	 * @param panelEvaluacionSeleccionada the panelEvaluacionSeleccionada to set
	 */
	public void setPanelEvaluacionSeleccionada(JPanel panelEvaluacionSeleccionada) {
		this.panelEvaluacionSeleccionada = panelEvaluacionSeleccionada;
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
	 * @return the panelAlumnoSeleccionado
	 */
	public JPanel getPanelAlumnoSeleccionado() {
		return panelAlumnoSeleccionado;
	}

	/**
	 * @param panelAlumnoSeleccionado the panelAlumnoSeleccionado to set
	 */
	public void setPanelAlumnoSeleccionado(JPanel panelAlumnoSeleccionado) {
		this.panelAlumnoSeleccionado = panelAlumnoSeleccionado;
	}

	/**
	 * @return the spAlumnos
	 */
	public JScrollPane getSpAlumnos() {
		return spAlumnos;
	}

	/**
	 * @param spAlumnos the spAlumnos to set
	 */
	public void setSpAlumnos(JScrollPane spAlumnos) {
		this.spAlumnos = spAlumnos;
	}

	/**
	 * @return the nombreColumnasAlumnos
	 */
	public String[] getNombreColumnasAlumnos() {
		return nombreColumnasAlumnos;
	}

	/**
	 * @param nombreColumnasAlumnos the nombreColumnasAlumnos to set
	 */
	public void setNombreColumnasAlumnos(String[] nombreColumnasAlumnos) {
		this.nombreColumnasAlumnos = nombreColumnasAlumnos;
	}

	/**
	 * @return the lblEvaluacionSeleccionadaFecha
	 */
	public JLabel getLblEvaluacionSeleccionadaFecha() {
		return lblEvaluacionSeleccionadaFecha;
	}

	/**
	 * @param lblEvaluacionSeleccionadaFecha the lblEvaluacionSeleccionadaFecha to set
	 */
	public void setLblEvaluacionSeleccionadaFecha(JLabel lblEvaluacionSeleccionadaFecha) {
		this.lblEvaluacionSeleccionadaFecha = lblEvaluacionSeleccionadaFecha;
	}

	/**
	 * @return the btnEliminarEvaluacion
	 */
	public JButton getBtnEliminarEvaluacion() {
		return btnEliminarEvaluacion;
	}

	/**
	 * @param btnEliminarEvaluacion the btnEliminarEvaluacion to set
	 */
	public void setBtnEliminarEvaluacion(JButton btnEliminarEvaluacion) {
		this.btnEliminarEvaluacion = btnEliminarEvaluacion;
	}

	/**
	 * @return the btnActualizarEvaluacion
	 */
	public JButton getBtnActualizarEvaluacion() {
		return btnActualizarEvaluacion;
	}

	/**
	 * @param btnActualizarEvaluacion the btnActualizarEvaluacion to set
	 */
	public void setBtnActualizarEvaluacion(JButton btnActualizarEvaluacion) {
		this.btnActualizarEvaluacion = btnActualizarEvaluacion;
	}

	/**
	 * @return the btnActualizarNota
	 */
	public JButton getBtnActualizarNota() {
		return btnActualizarNota;
	}

	/**
	 * @param btnActualizarNota the btnActualizarNota to set
	 */
	public void setBtnActualizarNota(JButton btnActualizarNota) {
		this.btnActualizarNota = btnActualizarNota;
	}

	/**
	 * @return the spNotas
	 */
	public JPanel getSpNotas() {
		return panelNota;
	}

	/**
	 * @param spNotas the spNotas to set
	 */
	public void setSpNotas(JPanel spNotas) {
		this.panelNota = spNotas;
	}

	/**
	 * @return the panelNota
	 */
	public JPanel getPanelNota() {
		return panelNota;
	}

	/**
	 * @param panelNota the panelNota to set
	 */
	public void setPanelNota(JPanel panelNota) {
		this.panelNota = panelNota;
	}

	/**
	 * @return the textNota
	 */
	public JTextField getTextNota() {
		return textNota;
	}

	/**
	 * @param textNota the textNota to set
	 */
	public void setTextNota(JTextField textNota) {
		this.textNota = textNota;
	}
}
