package presentacion.vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class CursadaABMPanel extends JPanel {
	
	private JScrollPane spCursadas;
	private DefaultTableModel modelCursadas;
	private JTable tblCursadas;
	private String[] nombreColumnas = {"idCursada", "idEmpresa", "idCurso", "idEstadoCurso", "Curso", "Empresa", "FechaInicioInscripcion", "FechaFinInscripcion", "EstadoCurso", "Vacantes", "FechaInicioCursada", "DiasDeClase"};
	

	private JPanel panel;	
	private JComboBox<EmpresaDTO> cbxEmpresa;
	private JComboBox<CursoDTO> cbxCurso;
	private JComboBox<EstadoDeCursoDTO> cbxEstado;
	private JTextField textFechaInicioInsc;
	private JTextField textFechaFinInsc;
	private JTextField textVacantes;
	private JTextField textIdCursada;
	
	private JPanel panelButtons;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAddAlumnos;
	private JButton btnAddInstructor;
	private JButton btnAddHorariosCursada;
	private JTextField textFechaInicioCursada;
	private JTextField textDiasDeClase;
	private JSeparator separatorCursada;

	/**
	 * Create the frame.
	 */
	public CursadaABMPanel() {
		super();
		this.setBounds(0, 0, 700, 625);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTabla();
		inicializarEditor();
		inicializarBotones();
	}

	private void inicializarTabla() {
		
		spCursadas = new JScrollPane();
		spCursadas.setBounds(10, 240, 681, 373);
		this.add(spCursadas);
		
		modelCursadas = new DefaultTableModel(null, nombreColumnas);
		tblCursadas = new JTable(modelCursadas){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblCursadas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblusuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spCursadas.setViewportView(tblCursadas);	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 222, 682, 1);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		this.add(separator);
	}

	private void inicializarEditor() {	
		
		panel = new JPanel();
		panel.setBounds(10, 10, 500, 195);
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cursada:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setLayout(null);
		this.add(panel);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(256, 22, 70, 14);
		panel.add(lblCurso);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(20, 22, 70, 14);
		panel.add(lblEmpresa);
		
		cbxEmpresa = new JComboBox<>();
		cbxEmpresa.setBounds(96, 22, 141, 20);
		panel.add(cbxEmpresa);
		
		JLabel lblInicioCursada = new JLabel("Inic Cursada");
		lblInicioCursada.setBounds(20, 135, 70, 14);
		panel.add(lblInicioCursada);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(258, 138, 70, 14);
		panel.add(lblEstado);
		
		JLabel lblFechaInicio = new JLabel("Inicio Insc:");
		lblFechaInicio.setBounds(20, 60, 70, 14);
		panel.add(lblFechaInicio);
		
		textFechaInicioInsc = new JTextField();
		textFechaInicioInsc.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaInicioInsc.setColumns(10);
		textFechaInicioInsc.setBounds(96, 60, 141, 20);
		panel.add(textFechaInicioInsc);
		
		JLabel lblFechaFin = new JLabel("Fecha Insc:");
		lblFechaFin.setBounds(258, 57, 70, 14);
		panel.add(lblFechaFin);
		
		textFechaFinInsc = new JTextField();
		textFechaFinInsc.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaFinInsc.setColumns(10);
		textFechaFinInsc.setBounds(333, 57, 141, 20);
		panel.add(textFechaFinInsc);	
		
		
		///
		JLabel lblVacantes = new JLabel("Vacantes:");
		lblVacantes.setBounds(20, 95, 70, 14);
		panel.add(lblVacantes);
		
		textVacantes = new JTextField();
		textVacantes.setHorizontalAlignment(SwingConstants.LEFT);
		textVacantes.setColumns(10);
		textVacantes.setBounds(96, 95, 70, 20);
		panel.add(textVacantes);
		
		cbxCurso = new JComboBox<CursoDTO>();
		cbxCurso.setBounds(333, 19, 141, 20);
		panel.add(cbxCurso);
		
		cbxEstado = new JComboBox<EstadoDeCursoDTO>();
		cbxEstado.setEnabled(false);
		cbxEstado.setBounds(333, 135, 141, 20);
		panel.add(cbxEstado);
		
		JLabel lblIdCursada = new JLabel("Id Cursada:");
		lblIdCursada.setVisible(false);
		lblIdCursada.setBounds(256, 88, 70, 14);
		panel.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada.setVisible(true);
		textIdCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textIdCursada.setColumns(10);
		textIdCursada.setBounds(332, 88, 70, 20);
		panel.add(textIdCursada);
		
		textFechaInicioCursada = new JTextField();
		textFechaInicioCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaInicioCursada.setColumns(10);
		textFechaInicioCursada.setBounds(96, 132, 141, 20);
		panel.add(textFechaInicioCursada);
		
		JLabel lblDiasDeClase = new JLabel("Dias de Clase");
		lblDiasDeClase.setBounds(20, 160, 70, 14);
		panel.add(lblDiasDeClase);
		
		textDiasDeClase = new JTextField();
		textDiasDeClase.setHorizontalAlignment(SwingConstants.LEFT);
		textDiasDeClase.setColumns(10);
		textDiasDeClase.setBounds(96, 160, 70, 20);
		panel.add(textDiasDeClase);
		
		separatorCursada = new JSeparator();
		separatorCursada.setBounds(10, 123, 480, 1);
		panel.add(separatorCursada);
		separatorCursada.setForeground(SystemColor.activeCaption);
		separatorCursada.setBackground(SystemColor.activeCaption);
	}
	
	private void inicializarBotones() {
		
		panelButtons = new JPanel();
		panelButtons.setBounds(520, 15, 170, 204);
		panelButtons.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panelButtons.setLayout(null);
		this.add(panelButtons);
		
		btnAgregar = new JButton("Nueva Cursada");
		btnAgregar.setBounds(10, 10, 150, 23);
		panelButtons.add(btnAgregar);
		
		btnActualizar = new JButton("Editar Cursada");
		btnActualizar.setBounds(10, 39, 150, 23);
		panelButtons.add(btnActualizar);
		
		this.add(panelButtons);
		
		btnAddAlumnos = new JButton("Agregar Alumnos");
		btnAddAlumnos.setBounds(10, 105, 150, 23);
		panelButtons.add(btnAddAlumnos);
		
		btnEliminar = new JButton("Eliminar Cursada");
		btnEliminar.setBounds(10, 73, 150, 23);
		panelButtons.add(btnEliminar);
		
		btnAddInstructor = new JButton("Asignar Instructor");
		btnAddInstructor.setBounds(10, 136, 150, 23);
		panelButtons.add(btnAddInstructor);
		
		btnAddHorariosCursada = new JButton("Agregar Horarios Cursada");
		btnAddHorariosCursada.setBounds(10, 170, 150, 23);
		panelButtons.add(btnAddHorariosCursada);
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
	 * @return the tblCursadas
	 */
	public JTable getTblCursadas() {
		return tblCursadas;
	}

	/**
	 * @param tblCursadas the tblCursadas to set
	 */
	public void setTblCursadas(JTable tblCursadas) {
		this.tblCursadas = tblCursadas;
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
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the cbxEmpresa
	 */
	public JComboBox<EmpresaDTO> getCbxEmpresa() {
		return cbxEmpresa;
	}

	/**
	 * @param cbxEmpresa the cbxEmpresa to set
	 */
	public void setCbxEmpresa(JComboBox<EmpresaDTO> cbxEmpresa) {
		this.cbxEmpresa = cbxEmpresa;
	}

	/**
	 * @return the cbxCurso
	 */
	public JComboBox<CursoDTO> getCbxCurso() {
		return cbxCurso;
	}

	/**
	 * @param cbxCurso the cbxCurso to set
	 */
	public void setCbxCurso(JComboBox<CursoDTO> cbxCurso) {
		this.cbxCurso = cbxCurso;
	}

	/**
	 * @return the cbxEstado
	 */
	public JComboBox<EstadoDeCursoDTO> getCbxEstado() {
		return cbxEstado;
	}

	/**
	 * @param cbxEstado the cbxEstado to set
	 */
	public void setCbxEstado(JComboBox<EstadoDeCursoDTO> cbxEstado) {
		this.cbxEstado = cbxEstado;
	}

	/**
	 * @return the textFechaInicioInsc
	 */
	public JTextField getTextFechaInicioInsc() {
		return textFechaInicioInsc;
	}

	/**
	 * @param textFechaInicioInsc the textFechaInicioInsc to set
	 */
	public void setTextFechaInicioInsc(JTextField textFechaInicioInsc) {
		this.textFechaInicioInsc = textFechaInicioInsc;
	}

	/**
	 * @return the textFechaFinInsc
	 */
	public JTextField getTextFechaFinInsc() {
		return textFechaFinInsc;
	}

	/**
	 * @param textFechaFinInsc the textFechaFinInsc to set
	 */
	public void setTextFechaFinInsc(JTextField textFechaFinInsc) {
		this.textFechaFinInsc = textFechaFinInsc;
	}

	/**
	 * @return the textVacantes
	 */
	public JTextField getTextVacantes() {
		return textVacantes;
	}

	/**
	 * @param textVacantes the textVacantes to set
	 */
	public void setTextVacantes(JTextField textVacantes) {
		this.textVacantes = textVacantes;
	}

	/**
	 * @return the textIdCursada
	 */
	public JTextField getTextIdCursada() {
		return textIdCursada;
	}

	/**
	 * @param textIdCursada the textIdCursada to set
	 */
	public void setTextIdCursada(JTextField textIdCursada) {
		this.textIdCursada = textIdCursada;
	}

	/**
	 * @return the panelButtons
	 */
	public JPanel getPanelButtons() {
		return panelButtons;
	}

	/**
	 * @param panelButtons the panelButtons to set
	 */
	public void setPanelButtons(JPanel panelButtons) {
		this.panelButtons = panelButtons;
	}

	/**
	 * @return the btnAgregar
	 */
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	/**
	 * @param btnAgregar the btnAgregar to set
	 */
	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	/**
	 * @return the btnActualizar
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * @param btnActualizar the btnActualizar to set
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
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
	 * @return the btnAddAlumnos
	 */
	public JButton getBtnAddAlumnos() {
		return btnAddAlumnos;
	}

	/**
	 * @param btnAddAlumnos the btnAddAlumnos to set
	 */
	public void setBtnAddAlumnos(JButton btnAddAlumnos) {
		this.btnAddAlumnos = btnAddAlumnos;
	}

	/**
	 * @return the btnAddPagos
	 */
	public JButton getBtnAddPagos() {
		return btnAddInstructor;
	}

	/**
	 * @param btnAddPagos the btnAddPagos to set
	 */
	public void setBtnAddPagos(JButton btnAddPagos) {
		this.btnAddInstructor = btnAddPagos;
	}

	/**
	 * @return the btnAddHorariosCursada
	 */
	public JButton getBtnAddHorariosCursada() {
		return btnAddHorariosCursada;
	}

	/**
	 * @param btnAddHorariosCursada the btnAddHorariosCursada to set
	 */
	public void setBtnAddHorariosCursada(JButton btnAddHorariosCursada) {
		this.btnAddHorariosCursada = btnAddHorariosCursada;
	}

	/**
	 * @return the textFechaInicioCursada
	 */
	public JTextField getTextFechaInicioCursada() {
		return textFechaInicioCursada;
	}

	/**
	 * @param textFechaInicioCursada the textFechaInicioCursada to set
	 */
	public void setTextFechaInicioCursada(JTextField textFechaInicioCursada) {
		this.textFechaInicioCursada = textFechaInicioCursada;
	}

	/**
	 * @return the textDiasDeClase
	 */
	public JTextField getTextDiasDeClase() {
		return textDiasDeClase;
	}

	/**
	 * @param textDiasDeClase the textDiasDeClase to set
	 */
	public void setTextDiasDeClase(JTextField textDiasDeClase) {
		this.textDiasDeClase = textDiasDeClase;
	}
}
