package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
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
	private String[] nombreColumnasDiasDeCursada = {"", "", "Dia", "Ini", "Fin", "Sala"};
	private JButton btnEliminar;
	
	private JPanel panelFechasDeCursada;
	private JScrollPane spFechasDeCursada;
	private JTable tablaFechasDeCursada;
	private DefaultTableModel modelFechasDeCursada;
	private String[] nombreColumnasFechasDeCursada = {"", "", "", "Dia", "Fecha", "Ini", "Fin", "Sala", "Fecha.Inicio", "Fecha.Fin", "Reserva"};
	private JButton btnGenerarHorario;
	private JButton btnGuardarCambios;
	
	private JPanel panelSalas;
	private JTable tablaSalas;
	private JScrollPane spSalas;
	private DefaultTableModel modelSalas;
	private String[] nombreColumnasSalas = {"idSala", "Sala", "Desde", "Hasta", "Estado"};
	private JButton btnAsignarSala;
	private JButton btnCancelar;
	
	private JPanel panelSalasEnConflicto;
	private JTable tablaSalasEnConflicto;
	private JScrollPane spSalasEnConflicto;
	private DefaultTableModel modelSalasEnConflicto;
	private String[] nombreColumnasSalasEnConflicto = {"idFechaCursadaClase", "idSala", "Sala", "Desde", "Hasta", "Estado"};
	private JButton btnReasignarSalasEnConflicto;
	
	private JTextField textSalaDia;
	private JLabel lblFechaIni;
	private JTextField textSalaFechaInicio;
	private JLabel lblFechaFin;
	private JTextField textSalaFechaFin;
	private JLabel lblSala;
	private JTextField textSalaNombre;
	private JLabel lblIdsala;
	private JTextField textSalaId;
	private JTextField textSalaIdFechaCursada;
	
	
	public CalendarioBuilderPanel() {
		super();
		this.setBounds(0, 0, 1127, 750);
		this.setLayout(null);
		
		initialize();
	}

	private void initialize() {
		
		buildFechaDeInicio();
		buildPanelSeleccionarDias();
		buildTablaSeleccionarDiasDeCursada();
		buildPanelDiasDeCursadaGenerados();
		buildTablaDiasDeCursadaGenerados();
		buildPanelSalasDisponibles();
		buildTablaSalas();
		buildPanelSalasEnConflicto();
		buildTablaSalasEnConflicto();
	}
	
	private void buildFechaDeInicio() {
		
		panelFechaInicio = new JPanel();
		panelFechaInicio.setBounds(10, 11, 280, 88);
		add(panelFechaInicio);
		panelFechaInicio.setLayout(null);
		panelFechaInicio.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Fecha de Inicio de Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		textFechaInicio = new JTextField();
		textFechaInicio.setEnabled(false);
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
		textCantidadDeDias.setEnabled(false);
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
		btnEliminar.setBounds(10, 365, 260, 41);
		panelSeleccionarDia.add(btnEliminar);
	}
	
	private void buildTablaSeleccionarDiasDeCursada() {
		
		spDiasDeCursada = new JScrollPane();
		spDiasDeCursada.setBounds(10, 149, 260, 210);
		panelSeleccionarDia.add(spDiasDeCursada);
		
		modelDiasDeCursada = new DefaultTableModel(null, nombreColumnasDiasDeCursada);
		tablaDiasDeCursada = new JTable(modelDiasDeCursada) {
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Haga Click aqui para elegir SALA!");
		tablaDiasDeCursada.getColumnModel().getColumn(4).setCellRenderer(renderer);
			
		tablaDiasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tablaDiasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spDiasDeCursada.setViewportView(tablaDiasDeCursada);
	}

	private void buildPanelDiasDeCursadaGenerados() {
		
		panelFechasDeCursada = new JPanel();
		panelFechasDeCursada.setLayout(null);
		panelFechasDeCursada.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Calendario de Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFechasDeCursada.setBounds(300, 11, 390, 516);
		add(panelFechasDeCursada);
	}

	private void buildTablaDiasDeCursadaGenerados() {
		
		spFechasDeCursada = new JScrollPane();
		spFechasDeCursada.setBounds(10, 26, 370, 432);
		panelFechasDeCursada.add(spFechasDeCursada);
		
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
		//tablaFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tablaFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spFechasDeCursada.setViewportView(tablaFechasDeCursada);			
		
		btnGenerarHorario = new JButton("Generar Calendario de Cursada");
		btnGenerarHorario.setBounds(10, 464, 370, 41);
		panelFechasDeCursada.add(btnGenerarHorario);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(10, 417, 370, 41);
		panelFechasDeCursada.add(btnGuardarCambios);
	}
	
	private void buildPanelSalasDisponibles() {
		
		panelSalas = new JPanel();
		panelSalas.setLayout(null);
		panelSalas.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Salas Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSalas.setBounds(700, 11, 390, 516);
		add(panelSalas);
		panelSalas.setVisible(false);
	}
	
	private void buildPanelSalasEnConflicto() {
		
		panelSalasEnConflicto = new JPanel();
		panelSalasEnConflicto.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Salas en Conflicto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSalasEnConflicto.setBounds(700, 11, 390, 516);
		add(panelSalasEnConflicto);
		panelSalasEnConflicto.setLayout(null);
	}
	
	private void buildTablaSalasEnConflicto() {	
		
		spSalasEnConflicto = new JScrollPane();
		spSalasEnConflicto.setBounds(10, 23, 370, 389);
		panelSalasEnConflicto.add(spSalasEnConflicto);
		
		modelSalasEnConflicto = new DefaultTableModel(null, nombreColumnasSalasEnConflicto);
		tablaSalasEnConflicto = new JTable(modelSalasEnConflicto){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tablaSalasEnConflicto.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tablaFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spSalasEnConflicto.setViewportView(tablaSalasEnConflicto);
		
		btnReasignarSalasEnConflicto = new JButton("Reasignar Salas en Conflicto");
		btnReasignarSalasEnConflicto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnReasignarSalasEnConflicto.setBounds(10, 464, 370, 41);
		panelSalasEnConflicto.add(btnReasignarSalasEnConflicto);		
		
		btnCancelar = new JButton("Cancelar Reasignacion");
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(10, 423, 370, 41);
		panelSalasEnConflicto.add(btnCancelar);
	}
	
	private void buildTablaSalas() {

		spSalas = new JScrollPane();
		spSalas.setBounds(10, 26, 370, 275);
		panelSalas.add(spSalas);
		
		modelSalas = new DefaultTableModel(null, nombreColumnasSalas);
		tablaSalas = new JTable(modelSalas){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tablaSalas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tablaFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spSalas.setViewportView(tablaSalas);			
		
		btnAsignarSala = new JButton("Asignar Sala");
		btnAsignarSala.setBounds(10, 464, 370, 41);
		panelSalas.add(btnAsignarSala);
		
		JLabel lblNewLabel = new JLabel("Dia:");
		lblNewLabel.setBounds(10, 337, 66, 14);
		panelSalas.add(lblNewLabel);
		
		textSalaDia = new JTextField();
		textSalaDia.setBounds(76, 337, 105, 20);
		panelSalas.add(textSalaDia);
		textSalaDia.setColumns(10);
		
		lblFechaIni = new JLabel("Fecha Ini:");
		lblFechaIni.setBounds(10, 372, 66, 14);
		panelSalas.add(lblFechaIni);
		
		textSalaFechaInicio = new JTextField();
		textSalaFechaInicio.setColumns(10);
		textSalaFechaInicio.setBounds(76, 372, 105, 20);
		panelSalas.add(textSalaFechaInicio);
		
		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(10, 407, 66, 14);
		panelSalas.add(lblFechaFin);
		
		textSalaFechaFin = new JTextField();
		textSalaFechaFin.setColumns(10);
		textSalaFechaFin.setBounds(76, 407, 105, 20);
		panelSalas.add(textSalaFechaFin);
		
		lblSala = new JLabel("Sala:");
		lblSala.setBounds(10, 438, 66, 14);
		panelSalas.add(lblSala);
		
		textSalaNombre = new JTextField();
		textSalaNombre.setColumns(10);
		textSalaNombre.setBounds(76, 438, 105, 20);
		panelSalas.add(textSalaNombre);
		
		lblIdsala = new JLabel("idSala:");
		lblIdsala.setVisible(false);
		lblIdsala.setBounds(205, 337, 51, 14);
		panelSalas.add(lblIdsala);
		
		textSalaId = new JTextField();
		textSalaId.setVisible(false);
		textSalaId.setColumns(10);
		textSalaId.setBounds(253, 337, 57, 20);
		panelSalas.add(textSalaId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 312, 370, 3);
		panelSalas.add(separator);
		
		JLabel lblIdfechacurs = new JLabel("idFechaCurs:");
		lblIdfechacurs.setVisible(false);
		lblIdfechacurs.setBounds(205, 372, 51, 14);
		panelSalas.add(lblIdfechacurs);
		
		textSalaIdFechaCursada = new JTextField();
		textSalaIdFechaCursada.setVisible(false);
		textSalaIdFechaCursada.setColumns(10);
		textSalaIdFechaCursada.setBounds(253, 372, 57, 20);
		panelSalas.add(textSalaIdFechaCursada);
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
	 * @return the panelFechasDeCursada
	 */
	public JPanel getPanelFechasDeCursada() {
		return panelFechasDeCursada;
	}

	/**
	 * @param panelFechasDeCursada the panelFechasDeCursada to set
	 */
	public void setPanelFechasDeCursada(JPanel panelFechasDeCursada) {
		this.panelFechasDeCursada = panelFechasDeCursada;
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

	/**
	 * @return the btnGuardarCambios
	 */
	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

	/**
	 * @param btnGuardarCambios the btnGuardarCambios to set
	 */
	public void setBtnGuardarCambios(JButton btnGuardarCambios) {
		this.btnGuardarCambios = btnGuardarCambios;
	}

	/**
	 * @return the panelSalas
	 */
	public JPanel getPanelSalas() {
		return panelSalas;
	}

	/**
	 * @param panelSalas the panelSalas to set
	 */
	public void setPanelSalas(JPanel panelSalas) {
		this.panelSalas = panelSalas;
	}

	/**
	 * @return the tablaSalas
	 */
	public JTable getTablaSalas() {
		return tablaSalas;
	}

	/**
	 * @param tablaSalas the tablaSalas to set
	 */
	public void setTablaSalas(JTable tablaSalas) {
		this.tablaSalas = tablaSalas;
	}

	/**
	 * @return the spSalas
	 */
	public JScrollPane getSpSalas() {
		return spSalas;
	}

	/**
	 * @param spSalas the spSalas to set
	 */
	public void setSpSalas(JScrollPane spSalas) {
		this.spSalas = spSalas;
	}

	/**
	 * @return the modelSalas
	 */
	public DefaultTableModel getModelSalas() {
		return modelSalas;
	}

	/**
	 * @param modelSalas the modelSalas to set
	 */
	public void setModelSalas(DefaultTableModel modelSalas) {
		this.modelSalas = modelSalas;
	}

	/**
	 * @return the nombreColumnasSalas
	 */
	public String[] getNombreColumnasSalas() {
		return nombreColumnasSalas;
	}

	/**
	 * @param nombreColumnasSalas the nombreColumnasSalas to set
	 */
	public void setNombreColumnasSalas(String[] nombreColumnasSalas) {
		this.nombreColumnasSalas = nombreColumnasSalas;
	}

	/**
	 * @return the btnAsignarSala
	 */
	public JButton getBtnAsignarSala() {
		return btnAsignarSala;
	}

	/**
	 * @param btnAsignarSala the btnAsignarSala to set
	 */
	public void setBtnAsignarSala(JButton btnAsignarSala) {
		this.btnAsignarSala = btnAsignarSala;
	}

	/**
	 * @return the textSalaDia
	 */
	public JTextField getTextSalaDia() {
		return textSalaDia;
	}

	/**
	 * @param textSalaDia the textSalaDia to set
	 */
	public void setTextSalaDia(JTextField textSalaDia) {
		this.textSalaDia = textSalaDia;
	}

	/**
	 * @return the textSalaFechaInicio
	 */
	public JTextField getTextSalaFechaInicio() {
		return textSalaFechaInicio;
	}

	/**
	 * @param textSalaFechaInicio the textSalaFechaInicio to set
	 */
	public void setTextSalaFechaInicio(JTextField textSalaFechaInicio) {
		this.textSalaFechaInicio = textSalaFechaInicio;
	}

	/**
	 * @return the textSalaFechaFin
	 */
	public JTextField getTextSalaFechaFin() {
		return textSalaFechaFin;
	}

	/**
	 * @param textSalaFechaFin the textSalaFechaFin to set
	 */
	public void setTextSalaFechaFin(JTextField textSalaFechaFin) {
		this.textSalaFechaFin = textSalaFechaFin;
	}

	/**
	 * @return the textSalaNombre
	 */
	public JTextField getTextSalaNombre() {
		return textSalaNombre;
	}

	/**
	 * @param textSalaNombre the textSalaNombre to set
	 */
	public void setTextSalaNombre(JTextField textSalaNombre) {
		this.textSalaNombre = textSalaNombre;
	}

	/**
	 * @return the textSalaId
	 */
	public JTextField getTextSalaId() {
		return textSalaId;
	}

	/**
	 * @param textSalaId the textSalaId to set
	 */
	public void setTextSalaId(JTextField textSalaId) {
		this.textSalaId = textSalaId;
	}

	/**
	 * @return the textSalaIdFechaCursada
	 */
	public JTextField getTextSalaIdFechaCursada() {
		return textSalaIdFechaCursada;
	}

	/**
	 * @param textSalaIdFechaCursada the textSalaIdFechaCursada to set
	 */
	public void setTextSalaIdFechaCursada(JTextField textSalaIdFechaCursada) {
		this.textSalaIdFechaCursada = textSalaIdFechaCursada;
	}

	/**
	 * @return the btnCancelar
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * @param btnCancelar the btnCancelar to set
	 */
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/**
	 * @return the panelSalasEnConflicto
	 */
	public JPanel getPanelSalasEnConflicto() {
		return panelSalasEnConflicto;
	}

	/**
	 * @param panelSalasEnConflicto the panelSalasEnConflicto to set
	 */
	public void setPanelSalasEnConflicto(JPanel panelSalasEnConflicto) {
		this.panelSalasEnConflicto = panelSalasEnConflicto;
	}

	/**
	 * @return the tablaSalasEnConflicto
	 */
	public JTable getTablaSalasEnConflicto() {
		return tablaSalasEnConflicto;
	}

	/**
	 * @param tablaSalasEnConflicto the tablaSalasEnConflicto to set
	 */
	public void setTablaSalasEnConflicto(JTable tablaSalasEnConflicto) {
		this.tablaSalasEnConflicto = tablaSalasEnConflicto;
	}

	/**
	 * @return the spSalasEnConflicto
	 */
	public JScrollPane getSpSalasEnConflicto() {
		return spSalasEnConflicto;
	}

	/**
	 * @param spSalasEnConflicto the spSalasEnConflicto to set
	 */
	public void setSpSalasEnConflicto(JScrollPane spSalasEnConflicto) {
		this.spSalasEnConflicto = spSalasEnConflicto;
	}

	/**
	 * @return the modelSalasEnConflicto
	 */
	public DefaultTableModel getModelSalasEnConflicto() {
		return modelSalasEnConflicto;
	}

	/**
	 * @param modelSalasEnConflicto the modelSalasEnConflicto to set
	 */
	public void setModelSalasEnConflicto(DefaultTableModel modelSalasEnConflicto) {
		this.modelSalasEnConflicto = modelSalasEnConflicto;
	}

	/**
	 * @return the nombreColumnasSalasEnConflicto
	 */
	public String[] getNombreColumnasSalasEnConflicto() {
		return nombreColumnasSalasEnConflicto;
	}

	/**
	 * @param nombreColumnasSalasEnConflicto the nombreColumnasSalasEnConflicto to set
	 */
	public void setNombreColumnasSalasEnConflicto(String[] nombreColumnasSalasEnConflicto) {
		this.nombreColumnasSalasEnConflicto = nombreColumnasSalasEnConflicto;
	}

	/**
	 * @return the btnReasignarSalasEnConflicto
	 */
	public JButton getBtnReasignarSalasEnConflicto() {
		return btnReasignarSalasEnConflicto;
	}

	/**
	 * @param btnReasignarSalasEnConflicto the btnReasignarSalasEnConflicto to set
	 */
	public void setBtnReasignarSalasEnConflicto(JButton btnReasignarSalasEnConflicto) {
		this.btnReasignarSalasEnConflicto = btnReasignarSalasEnConflicto;
	}
}

