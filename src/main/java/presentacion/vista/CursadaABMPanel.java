package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

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

import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;

@SuppressWarnings("serial")
public class CursadaABMPanel extends JPanel {
	
	private JScrollPane spCursadas;
	private DefaultTableModel modelCursadas;
	private JTable tblCursadas;
	private String[] nombreColumnas = {"idCursada", "idEmpresa", "idCurso", "idEstadoCurso", "idAdministrativo","Curso", "Empresa", "Ini Inscrip", "Fin Inscrip", "EstadoCurso", "Vacantes", "Ini Cursada", "DiasDeClase"};
	

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
	
	private JTextField textAdministrativo;
	private JButton btnAgregarAdministrativo;
	private JTextField textidAdministrativo;
	private JLabel lblIdadmin;
	private JLabel lblAdmisitrativo;
	private JTextField textFieldInstructor;

	/**
	 * Create the frame.
	 */
	public CursadaABMPanel() {
		super();
		this.setBounds(0, 0, 705, 640);
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
		spCursadas.setBounds(10, 11, 681, 364);
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
	}

	private void inicializarEditor() {	
		
		panel = new JPanel();
		panel.setBounds(10, 386, 681, 239);
		panel.setBorder(new TitledBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cursada:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		this.add(panel);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(12, 21, 53, 14);
		panel.add(lblCurso);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(12, 57, 70, 14);
		panel.add(lblEmpresa);
		
		cbxEmpresa = new JComboBox<>();
		cbxEmpresa.setBounds(82, 57, 141, 20);
		panel.add(cbxEmpresa);
		
		JLabel lblInicioCursada = new JLabel("Inicio Cursada");
		lblInicioCursada.setBounds(244, 91, 101, 14);
		panel.add(lblInicioCursada);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 91, 53, 14);
		panel.add(lblEstado);
		
		JLabel lblFechaInicio = new JLabel("Inicio Inscripcion:");
		lblFechaInicio.setBounds(244, 21, 101, 14);
		panel.add(lblFechaInicio);
		
		textFechaInicioInsc = new JTextField();
		textFechaInicioInsc.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaInicioInsc.setColumns(10);
		textFechaInicioInsc.setBounds(345, 22, 110, 20);
		panel.add(textFechaInicioInsc);
		
		JLabel lblFechaFin = new JLabel("Fin Inscripcion:");
		lblFechaFin.setBounds(244, 57, 101, 14);
		panel.add(lblFechaFin);
		
		textFechaFinInsc = new JTextField();
		textFechaFinInsc.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaFinInsc.setColumns(10);
		textFechaFinInsc.setBounds(345, 57, 110, 20);
		panel.add(textFechaFinInsc);	
		
		
		///
		JLabel lblVacantes = new JLabel("Vacantes:");
		lblVacantes.setBounds(497, 57, 70, 14);
		panel.add(lblVacantes);
		
		textVacantes = new JTextField();
		textVacantes.setHorizontalAlignment(SwingConstants.LEFT);
		textVacantes.setColumns(10);
		textVacantes.setBounds(577, 54, 70, 20);
		panel.add(textVacantes);
		
		cbxCurso = new JComboBox<CursoDTO>();
		cbxCurso.setBounds(82, 21, 141, 20);
		panel.add(cbxCurso);
		
		cbxEstado = new JComboBox<EstadoDeCursoDTO>();
		cbxEstado.setEnabled(false);
		cbxEstado.setBounds(82, 91, 141, 20);
		panel.add(cbxEstado);
		
		textFechaInicioCursada = new JTextField();
		textFechaInicioCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textFechaInicioCursada.setColumns(10);
		textFechaInicioCursada.setBounds(345, 91, 110, 20);
		panel.add(textFechaInicioCursada);
		
		JLabel lblDiasDeClase = new JLabel("Clases");
		lblDiasDeClase.setBounds(497, 21, 70, 14);
		panel.add(lblDiasDeClase);
		
		textDiasDeClase = new JTextField();
		textDiasDeClase.setHorizontalAlignment(SwingConstants.LEFT);
		textDiasDeClase.setColumns(10);
		textDiasDeClase.setBounds(577, 21, 70, 20);
		panel.add(textDiasDeClase);
		
		JLabel lblIdCursada = new JLabel("Id Cursada:");
		lblIdCursada.setBounds(497, 94, 70, 14);
		panel.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada.setBounds(577, 91, 70, 20);
		panel.add(textIdCursada);
		textIdCursada.setVisible(false);
		textIdCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textIdCursada.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		btnAgregar.setBounds(173, 188, 333, 40);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizar.setBounds(173, 188, 333, 40);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminar.setBounds(173, 188, 333, 40);
		panel.add(btnEliminar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeleccionar.setBounds(173, 188, 333, 40);
		panel.add(btnSeleccionar);
		
		lblAdmisitrativo = new JLabel("Admisitrativo:");
		lblAdmisitrativo.setBounds(12, 125, 70, 14);
		panel.add(lblAdmisitrativo);
		
		textAdministrativo = new JTextField();
		textAdministrativo.setHorizontalAlignment(SwingConstants.LEFT);
		textAdministrativo.setColumns(10);
		textAdministrativo.setBounds(82, 125, 141, 20);
		panel.add(textAdministrativo);
		
		btnAgregarAdministrativo = new JButton("Agregar");
		btnAgregarAdministrativo.setBounds(238, 125, 89, 23);
		panel.add(btnAgregarAdministrativo);
		
		textidAdministrativo = new JTextField();		
		textidAdministrativo.setBounds(577, 125, 70, 20);
		panel.add(textidAdministrativo);
		textidAdministrativo.setColumns(10);
		textidAdministrativo.setVisible(false);
		
		lblIdadmin = new JLabel("idAdmin:");
		lblIdadmin.setVisible(false);
		lblIdadmin.setBounds(497, 125, 70, 14);
		panel.add(lblIdadmin);
		
		JLabel labelInstructor = new JLabel("Instructor:");
		labelInstructor.setBounds(12, 155, 70, 14);
		panel.add(labelInstructor);
		
		textFieldInstructor = new JTextField();
		textFieldInstructor.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldInstructor.setColumns(10);
		textFieldInstructor.setBounds(82, 155, 141, 20);
		panel.add(textFieldInstructor);
		lblIdCursada.setVisible(false);
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
	 * @return the textAdministrativo
	 */
	public JTextField getTextAdministrativo() {
		return textAdministrativo;
	}

	/**
	 * @param textAdministrativo the textAdministrativo to set
	 */
	public void setTextAdministrativo(JTextField textAdministrativo) {
		this.textAdministrativo = textAdministrativo;
	}

	/**
	 * @return the btnAgregarAdministrativo
	 */
	public JButton getBtnAgregarAdministrativo() {
		return btnAgregarAdministrativo;
	}

	/**
	 * @param btnAgregarAdministrativo the btnAgregarAdministrativo to set
	 */
	public void setBtnAgregarAdministrativo(JButton btnAgregarAdministrativo) {
		this.btnAgregarAdministrativo = btnAgregarAdministrativo;
	}

	/**
	 * @return the textidAdministrativo
	 */
	public JTextField getTextidAdministrativo() {
		return textidAdministrativo;
	}

	/**
	 * @param textidAdministrativo the textidAdministrativo to set
	 */
	public void setTextidAdministrativo(JTextField textidAdministrativo) {
		this.textidAdministrativo = textidAdministrativo;
	}

	/**
	 * @return the lblIdadmin
	 */
	public JLabel getLblIdadmin() {
		return lblIdadmin;
	}

	/**
	 * @param lblIdadmin the lblIdadmin to set
	 */
	public void setLblIdadmin(JLabel lblIdadmin) {
		this.lblIdadmin = lblIdadmin;
	}

	/**
	 * @return the lblAdmisitrativo
	 */
	public JLabel getLblAdmisitrativo() {
		return lblAdmisitrativo;
	}

	/**
	 * @param lblAdmisitrativo the lblAdmisitrativo to set
	 */
	public void setLblAdmisitrativo(JLabel lblAdmisitrativo) {
		this.lblAdmisitrativo = lblAdmisitrativo;
	}

	public JTextField getTextFieldInstructor() {
		return textFieldInstructor;
	}

	public void setTextFieldInstructor(JTextField textFieldInstructor) {
		this.textFieldInstructor = textFieldInstructor;
	}
}
