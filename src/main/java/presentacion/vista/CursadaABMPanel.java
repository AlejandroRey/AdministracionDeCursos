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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;

@SuppressWarnings("serial")
public class CursadaABMPanel extends JPanel {
	
	private JScrollPane spCursadas;
	private DefaultTableModel modelCursadas;
	private JTable tblCursadas;
	private String[] nombreColumnas = {"idCursada", "idEmpresa", "idCurso", "idEstadoCurso", "Curso", "Empresa", "Ini Inscrip", "Fin Inscrip", "EstadoCurso", "Vacantes", "Ini Cursada", "DiasDeClase"};
	

	private JPanel panel;	
	private JComboBox<EmpresaDTO> cbxEmpresa;
	private JComboBox<CursoDTO> cbxCurso;
	private JComboBox<EstadoDeCursoDTO> cbxEstado;
	private JTextField textFechaInicioInsc;
	private JTextField textFechaFinInsc;
	private JTextField textVacantes;
	private JTextField textIdCursada;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnSeleccionar;
	
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
		panel.setBounds(10, 10, 681, 195);
		panel.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cursada:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		this.add(panel);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(233, 22, 53, 14);
		panel.add(lblCurso);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(20, 22, 70, 14);
		panel.add(lblEmpresa);
		
		cbxEmpresa = new JComboBox<>();
		cbxEmpresa.setBounds(82, 22, 141, 20);
		panel.add(cbxEmpresa);
		
		JLabel lblInicioCursada = new JLabel("Inic Cursada");
		lblInicioCursada.setBounds(454, 60, 70, 14);
		panel.add(lblInicioCursada);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(454, 22, 53, 14);
		panel.add(lblEstado);
		
		JLabel lblFechaInicio = new JLabel("Inicio Insc:");
		lblFechaInicio.setBounds(20, 60, 70, 14);
		panel.add(lblFechaInicio);
		
		textFechaInicioInsc = new JTextField();
		textFechaInicioInsc.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaInicioInsc.setColumns(10);
		textFechaInicioInsc.setBounds(82, 60, 141, 20);
		panel.add(textFechaInicioInsc);
		
		JLabel lblFechaFin = new JLabel("Fecha Insc:");
		lblFechaFin.setBounds(233, 60, 70, 14);
		panel.add(lblFechaFin);
		
		textFechaFinInsc = new JTextField();
		textFechaFinInsc.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaFinInsc.setColumns(10);
		textFechaFinInsc.setBounds(303, 60, 141, 20);
		panel.add(textFechaFinInsc);	
		
		
		///
		JLabel lblVacantes = new JLabel("Vacantes:");
		lblVacantes.setBounds(20, 95, 70, 14);
		panel.add(lblVacantes);
		
		textVacantes = new JTextField();
		textVacantes.setHorizontalAlignment(SwingConstants.LEFT);
		textVacantes.setColumns(10);
		textVacantes.setBounds(82, 95, 70, 20);
		panel.add(textVacantes);
		
		cbxCurso = new JComboBox<CursoDTO>();
		cbxCurso.setBounds(303, 22, 141, 20);
		panel.add(cbxCurso);
		
		cbxEstado = new JComboBox<EstadoDeCursoDTO>();
		cbxEstado.setEnabled(false);
		cbxEstado.setBounds(530, 22, 141, 20);
		panel.add(cbxEstado);
		
		JLabel lblIdCursada = new JLabel("Id Cursada:");
		lblIdCursada.setVisible(false);
		lblIdCursada.setBounds(233, 95, 70, 14);
		panel.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada.setVisible(true);
		textIdCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textIdCursada.setColumns(10);
		textIdCursada.setBounds(302, 95, 70, 20);
		panel.add(textIdCursada);
		
		textFechaInicioCursada = new JTextField();
		textFechaInicioCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaInicioCursada.setColumns(10);
		textFechaInicioCursada.setBounds(530, 60, 141, 20);
		panel.add(textFechaInicioCursada);
		
		JLabel lblDiasDeClase = new JLabel("Dias de Clase");
		lblDiasDeClase.setBounds(435, 95, 89, 14);
		panel.add(lblDiasDeClase);
		
		textDiasDeClase = new JTextField();
		textDiasDeClase.setHorizontalAlignment(SwingConstants.LEFT);
		textDiasDeClase.setColumns(10);
		textDiasDeClase.setBounds(530, 95, 70, 20);
		panel.add(textDiasDeClase);
		
		separatorCursada = new JSeparator();
		separatorCursada.setBounds(10, 130, 660, 1);
		panel.add(separatorCursada);
		separatorCursada.setForeground(SystemColor.activeCaption);
		separatorCursada.setBackground(SystemColor.activeCaption);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(265, 144, 150, 40);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(265, 144, 150, 40);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(265, 144, 150, 40);
		panel.add(btnEliminar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(265, 144, 150, 40);
		panel.add(btnSeleccionar);
	}
	
	private void inicializarBotones() {
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

	/**
	 * @return the separatorCursada
	 */
	public JSeparator getSeparatorCursada() {
		return separatorCursada;
	}

	/**
	 * @param separatorCursada the separatorCursada to set
	 */
	public void setSeparatorCursada(JSeparator separatorCursada) {
		this.separatorCursada = separatorCursada;
	}

}
