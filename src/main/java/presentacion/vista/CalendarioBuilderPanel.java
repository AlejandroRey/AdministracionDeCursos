package presentacion.vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.github.lgooddatepicker.components.TimePicker;

import dto.DiasDTO;

@SuppressWarnings("serial")
public class CalendarioBuilderPanel extends JPanel {
	
	private JPanel panelFechaInicio;
	private JTextField textFechaInicio;
	private JTextField textCantidadDeDias;
	
	private JPanel panelSeleccionarDia;
	private JComboBox<DiasDTO> cbxDias;
	private TimePicker textHoraInicio;
	private TimePicker textHoraFin;
	private JButton btnSeleccionar;

	private JScrollPane spDiasDeCursada;
	private JTable tablaDiasDeCursada;
	private DefaultTableModel modelDiasDeCursada;
	private String[] nombreColumnasDiasDeCursada = {"idCursada", "idDia", "Dia", "Hora Inicio", "Hora Fin"};
	
	private JButton btnEliminar;
	
	private JScrollPane spFechasDeCursada;
	private JTable tablaFechasDeCursada;
	private DefaultTableModel modelFechasDeCursada;
	private String[] nombreColumnasFechasDeCursada = {"", "", "", "Dia", "Fecha Inicio", "Fecha Fin"};
	
	private JPanel panelHorario;
	private JButton btnGenerarHorario;
	
	public CalendarioBuilderPanel() {
		super();
		this.setBounds(0, 0, 650, 650);
		this.setLayout(null);
		
		initialize();
	}

	private void initialize() {
		
		buildFechaDeInicio();
		buildPanelSeleccionarDias();
		buildTablaSeleccionarDiasDeCursada();
		buildPanelDiasDeCursadaGenerados();
		buildTablaDiasDeCursadaGenerados();
	}
	
	private void buildFechaDeInicio() {
		
		panelFechaInicio = new JPanel();
		panelFechaInicio.setBounds(10, 11, 280, 88);
		add(panelFechaInicio);
		panelFechaInicio.setLayout(null);
		panelFechaInicio.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Fecha de Inicio de Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		textFechaInicio = new JTextField();
		textFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		textFechaInicio.setColumns(10);
		textFechaInicio.setBounds(120, 23, 87, 20);
		panelFechaInicio.add(textFechaInicio);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
		lblFechaDeInicio.setBounds(10, 23, 100, 14);
		panelFechaInicio.add(lblFechaDeInicio);
		
		JLabel lblDiasDeCursada = new JLabel("Dias de Cursada:");
		lblDiasDeCursada.setBounds(10, 54, 100, 14);
		panelFechaInicio.add(lblDiasDeCursada);
		
		textCantidadDeDias = new JTextField();
		textCantidadDeDias.setHorizontalAlignment(SwingConstants.CENTER);
		textCantidadDeDias.setColumns(10);
		textCantidadDeDias.setBounds(120, 54, 87, 20);
		panelFechaInicio.add(textCantidadDeDias);
	}

	private void buildPanelSeleccionarDias() {
		
		panelSeleccionarDia = new JPanel();
		panelSeleccionarDia.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Seleccionar Dia de Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSeleccionarDia.setBounds(10, 110, 280, 417);
		add(panelSeleccionarDia);
		panelSeleccionarDia.setLayout(null);
		
		JLabel lblDia = new JLabel("Dia de Cursada:");
		lblDia.setBounds(10, 23, 100, 14);
		panelSeleccionarDia.add(lblDia);
		
		cbxDias = new JComboBox<DiasDTO>();
		cbxDias.setModel(new DefaultComboBoxModel<DiasDTO>(DiasDTO.values()));
		cbxDias.setBounds(120, 23, 87, 20);
		panelSeleccionarDia.add(cbxDias);
		
		JLabel lblHoraDeInicio = new JLabel("Hora de Inicio:");
		lblHoraDeInicio.setBounds(10, 54, 100, 14);
		panelSeleccionarDia.add(lblHoraDeInicio);
		
		textHoraInicio = new TimePicker();
		textHoraInicio.getComponentTimeTextField().setLocation(146, 0);
		textHoraInicio.setBounds(120, 54, 87, 20);
		panelSeleccionarDia.add(textHoraInicio);
		
		JLabel lblHoraDeFin = new JLabel("Hora de Fin:");
		lblHoraDeFin.setBounds(10, 85, 100, 14);
		panelSeleccionarDia.add(lblHoraDeFin);
		
		textHoraFin = new TimePicker();
		textHoraFin.setBounds(120, 85, 87, 20);
		panelSeleccionarDia.add(textHoraFin);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(181, 115, 89, 23);
		panelSeleccionarDia.add(btnSeleccionar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(181, 383, 89, 23);
		panelSeleccionarDia.add(btnEliminar);
	}
	
	private void buildTablaSeleccionarDiasDeCursada() {
		
		spDiasDeCursada = new JScrollPane();
		spDiasDeCursada.setBounds(10, 149, 260, 223);
		panelSeleccionarDia.add(spDiasDeCursada);
		
		modelDiasDeCursada = new DefaultTableModel(null, nombreColumnasDiasDeCursada);
		tablaDiasDeCursada = new JTable(modelDiasDeCursada){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tablaDiasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tablaDiasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spDiasDeCursada.setViewportView(tablaDiasDeCursada);
	}

	private void buildPanelDiasDeCursadaGenerados() {
		
		panelHorario = new JPanel();
		panelHorario.setLayout(null);
		panelHorario.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Calendario de Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHorario.setBounds(300, 11, 319, 516);
		add(panelHorario);
		panelHorario.setLayout(null);
	}

	private void buildTablaDiasDeCursadaGenerados() {
		
		spFechasDeCursada = new JScrollPane();
		spFechasDeCursada.setBounds(10, 26, 300, 446);
		panelHorario.add(spFechasDeCursada);
		
		modelFechasDeCursada = new DefaultTableModel(null, nombreColumnasFechasDeCursada);
		tablaFechasDeCursada = new JTable(modelFechasDeCursada){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tablaFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tablaFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spFechasDeCursada.setViewportView(tablaFechasDeCursada);			
		
		btnGenerarHorario = new JButton("Generar Calendario de Cursada");
		btnGenerarHorario.setBounds(10, 483, 300, 23);
		panelHorario.add(btnGenerarHorario);
	}

	/**
	 * @return the panelFechaInicio
	 */
	public JPanel getPanelFechaInicio() {
		return panelFechaInicio;
	}

	/**
	 * @param panelFechaInicio the panelFechaInicio to set
	 */
	public void setPanelFechaInicio(JPanel panelFechaInicio) {
		this.panelFechaInicio = panelFechaInicio;
	}

	/**
	 * @return the textFechaInicio
	 */
	public JTextField getTextFechaInicio() {
		return textFechaInicio;
	}

	/**
	 * @param textFechaInicio the textFechaInicio to set
	 */
	public void setTextFechaInicio(JTextField textFechaInicio) {
		this.textFechaInicio = textFechaInicio;
	}

	/**
	 * @return the textCantidadDeDias
	 */
	public JTextField getTextCantidadDeDias() {
		return textCantidadDeDias;
	}

	/**
	 * @param textCantidadDeDias the textCantidadDeDias to set
	 */
	public void setTextCantidadDeDias(JTextField textCantidadDeDias) {
		this.textCantidadDeDias = textCantidadDeDias;
	}

	/**
	 * @return the panelSeleccionarDia
	 */
	public JPanel getPanelSeleccionarDia() {
		return panelSeleccionarDia;
	}

	/**
	 * @param panelSeleccionarDia the panelSeleccionarDia to set
	 */
	public void setPanelSeleccionarDia(JPanel panelSeleccionarDia) {
		this.panelSeleccionarDia = panelSeleccionarDia;
	}

	/**
	 * @return the cbxDias
	 */
	public JComboBox<DiasDTO> getCbxDias() {
		return cbxDias;
	}

	/**
	 * @param cbxDias the cbxDias to set
	 */
	public void setCbxDias(JComboBox<DiasDTO> cbxDias) {
		this.cbxDias = cbxDias;
	}

	/**
	 * @return the textHoraInicio
	 */
	public TimePicker getTextHoraInicio() {
		return textHoraInicio;
	}

	/**
	 * @param textHoraInicio the textHoraInicio to set
	 */
	public void setTextHoraInicio(TimePicker textHoraInicio) {
		this.textHoraInicio = textHoraInicio;
	}

	/**
	 * @return the textHoraFin
	 */
	public TimePicker getTextHoraFin() {
		return textHoraFin;
	}

	/**
	 * @param textHoraFin the textHoraFin to set
	 */
	public void setTextHoraFin(TimePicker textHoraFin) {
		this.textHoraFin = textHoraFin;
	}

	/**
	 * @return the btnSeleccionar
	 */
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	/**
	 * @param btnSeleccionar the btnSeleccionar to set
	 */
	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

	/**
	 * @return the spDiasDeCursada
	 */
	public JScrollPane getSpDiasDeCursada() {
		return spDiasDeCursada;
	}

	/**
	 * @param spDiasDeCursada the spDiasDeCursada to set
	 */
	public void setSpDiasDeCursada(JScrollPane spDiasDeCursada) {
		this.spDiasDeCursada = spDiasDeCursada;
	}

	/**
	 * @return the tablaDiasDeCursada
	 */
	public JTable getTablaDiasDeCursada() {
		return tablaDiasDeCursada;
	}

	/**
	 * @param tablaDiasDeCursada the tablaDiasDeCursada to set
	 */
	public void setTablaDiasDeCursada(JTable tablaDiasDeCursada) {
		this.tablaDiasDeCursada = tablaDiasDeCursada;
	}

	/**
	 * @return the modelDiasDeCursada
	 */
	public DefaultTableModel getModelDiasDeCursada() {
		return modelDiasDeCursada;
	}

	/**
	 * @param modelDiasDeCursada the modelDiasDeCursada to set
	 */
	public void setModelDiasDeCursada(DefaultTableModel modelDiasDeCursada) {
		this.modelDiasDeCursada = modelDiasDeCursada;
	}

	/**
	 * @return the nombreColumnasDiasDeCursada
	 */
	public String[] getNombreColumnasDiasDeCursada() {
		return nombreColumnasDiasDeCursada;
	}

	/**
	 * @param nombreColumnasDiasDeCursada the nombreColumnasDiasDeCursada to set
	 */
	public void setNombreColumnasDiasDeCursada(String[] nombreColumnasDiasDeCursada) {
		this.nombreColumnasDiasDeCursada = nombreColumnasDiasDeCursada;
	}

	/**
	 * @return the btnEliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @param btnEliminar the btnEliminar to set
	 */
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/**
	 * @return the spFechasDeCursada
	 */
	public JScrollPane getSpFechasDeCursada() {
		return spFechasDeCursada;
	}

	/**
	 * @param spFechasDeCursada the spFechasDeCursada to set
	 */
	public void setSpFechasDeCursada(JScrollPane spFechasDeCursada) {
		this.spFechasDeCursada = spFechasDeCursada;
	}

	/**
	 * @return the tablaFechasDeCursada
	 */
	public JTable getTablaFechasDeCursada() {
		return tablaFechasDeCursada;
	}

	/**
	 * @param tablaFechasDeCursada the tablaFechasDeCursada to set
	 */
	public void setTablaFechasDeCursada(JTable tablaFechasDeCursada) {
		this.tablaFechasDeCursada = tablaFechasDeCursada;
	}

	/**
	 * @return the modelFechasDeCursada
	 */
	public DefaultTableModel getModelFechasDeCursada() {
		return modelFechasDeCursada;
	}

	/**
	 * @param modelFechasDeCursada the modelFechasDeCursada to set
	 */
	public void setModelFechasDeCursada(DefaultTableModel modelFechasDeCursada) {
		this.modelFechasDeCursada = modelFechasDeCursada;
	}

	/**
	 * @return the nombreColumnasFechasDeCursada
	 */
	public String[] getNombreColumnasFechasDeCursada() {
		return nombreColumnasFechasDeCursada;
	}

	/**
	 * @param nombreColumnasFechasDeCursada the nombreColumnasFechasDeCursada to set
	 */
	public void setNombreColumnasFechasDeCursada(String[] nombreColumnasFechasDeCursada) {
		this.nombreColumnasFechasDeCursada = nombreColumnasFechasDeCursada;
	}

	/**
	 * @return the panelHorario
	 */
	public JPanel getPanelHorario() {
		return panelHorario;
	}

	/**
	 * @param panelHorario the panelHorario to set
	 */
	public void setPanelHorario(JPanel panelHorario) {
		this.panelHorario = panelHorario;
	}

	/**
	 * @return the btnGenerarHorario
	 */
	public JButton getBtnGenerarHorario() {
		return btnGenerarHorario;
	}

	/**
	 * @param btnGenerarHorario the btnGenerarHorario to set
	 */
	public void setBtnGenerarHorario(JButton btnGenerarHorario) {
		this.btnGenerarHorario = btnGenerarHorario;
	}

}

