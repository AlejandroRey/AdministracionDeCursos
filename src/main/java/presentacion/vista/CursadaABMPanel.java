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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dto.CursoDTO;
import dto.EmpresaDTO;
import dto.EstadoDeCursoDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CursadaABMPanel extends JPanel {
	
	private JScrollPane spCursadas;
	private DefaultTableModel modelCursadas;
	private JTable tblCursadas;
	private String[] nombreColumnas = {"idCursada", "idEmpresa", "idCurso", "idEstadoCurso", "idAdministrativo","Curso", "Empresa", "Ini Inscrip", "Fin Inscrip", "EstadoCurso", "Vacantes", "Ini Cursada", "DiasDeClase"};
	private TableRowSorter<TableModel> modeloOrdenado;
	private DefaultTableModel modelAsignaciones;
	private String[] nombreColumnasAsignaciones = {"Nombre", "Tema", "Estado", "Fecha de inicio"};
	
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
	private JButton btnCerrarPeriodoDe;
	
	private JTextField textFechaInicioCursada;
	private JTextField textDiasDeClase;
	
	private JTextField textInstructor;
	private JButton btnAgregarInstructor;
	private JTextField textidAdministrativo;
	private JLabel lblIdadmin;
	private JLabel lblInstructor;
	private JTextField textIdIntructor;
	private JLabel lblIdintructor;
	private JButton btnCancelarCursada;

	/**
	 * Create the frame.
	 */
	public CursadaABMPanel() {
		super();
		this.setBounds(0, 0, 1125, 640);
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
		spCursadas.setBounds(216, 11, 681, 364);
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
		
		modeloOrdenado = new TableRowSorter<TableModel>(modelCursadas);
		tblCursadas.setRowSorter(modeloOrdenado);
		
		modelAsignaciones = new DefaultTableModel(null, nombreColumnasAsignaciones);
	}

	public TableRowSorter<TableModel> getModeloOrdenado() {
		return modeloOrdenado;
	}

	public void setModeloOrdenado(TableRowSorter<TableModel> modeloOrdenado) {
		this.modeloOrdenado = modeloOrdenado;
	}

	private void inicializarEditor() {	
		
		panel = new JPanel();
		panel.setBounds(216, 386, 681, 239);
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
		lblIdCursada.setVisible(false);
		lblIdCursada.setBounds(497, 94, 70, 14);
		panel.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada.setVisible(false);
		textIdCursada.setBounds(577, 91, 70, 20);
		panel.add(textIdCursada);
		textIdCursada.setHorizontalAlignment(SwingConstants.LEFT);
		textIdCursada.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		btnAgregar.setBounds(234, 188, 240, 40);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizar.setBounds(234, 188, 240, 40);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminar.setBounds(234, 188, 240, 40);
		panel.add(btnEliminar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeleccionar.setBounds(234, 188, 240, 40);
		panel.add(btnSeleccionar);
		
		lblInstructor = new JLabel("Instructor:");
		lblInstructor.setBounds(12, 125, 70, 14);
		panel.add(lblInstructor);
		
		textInstructor = new JTextField();
		textInstructor.setHorizontalAlignment(SwingConstants.LEFT);
		textInstructor.setColumns(10);
		textInstructor.setBounds(82, 125, 141, 20);
		panel.add(textInstructor);
		
		btnAgregarInstructor = new JButton("Agregar");
		btnAgregarInstructor.setBounds(238, 125, 89, 23);
		panel.add(btnAgregarInstructor);
		
		textidAdministrativo = new JTextField();
		textidAdministrativo.setVisible(false);
		textidAdministrativo.setBounds(577, 125, 70, 20);
		panel.add(textidAdministrativo);
		textidAdministrativo.setColumns(10);
		
		lblIdadmin = new JLabel("idAdmin:");
		lblIdadmin.setVisible(false);
		lblIdadmin.setBounds(497, 125, 70, 14);
		panel.add(lblIdadmin);
		
		lblIdintructor = new JLabel("idIntructor:");
		lblIdintructor.setVisible(false);
		lblIdintructor.setBounds(497, 150, 70, 27);
		panel.add(lblIdintructor);
		
		textIdIntructor = new JTextField();
		textIdIntructor.setVisible(false);
		textIdIntructor.setBounds(577, 156, 70, 20);
		panel.add(textIdIntructor);
		textIdIntructor.setColumns(10);
		
		btnCerrarPeriodoDe = new JButton("Cerrar periodo de cursada");
		btnCerrarPeriodoDe.setBounds(10, 197, 213, 23);
		panel.add(btnCerrarPeriodoDe);
		
		btnCancelarCursada = new JButton("Cancelar cursada");
		btnCancelarCursada.setBounds(497, 197, 150, 23);
		panel.add(btnCancelarCursada);
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
	public JTextField getTextInstructor() {
		return textInstructor;
	}

	/**
	 * @param textInstructor the textAdministrativo to set
	 */
	public void setTextInstructor(JTextField textInstructor) {
		this.textInstructor = textInstructor;
	}

	/**
	 * @return the btnAgregarAdministrativo
	 */
	public JButton getBtnAgregarInstructor() {
		return btnAgregarInstructor;
	}

	/**
	 * @param btnAgregarInstructor the btnAgregarAdministrativo to set
	 */
	public void setBtnAgregarInstructor(JButton btnAgregarInstructor) {
		this.btnAgregarInstructor = btnAgregarInstructor;
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
		return lblInstructor;
	}

	/**
	 * @param lblAdmisitrativo the lblAdmisitrativo to set
	 */
	public void setLblAdmisitrativo(JLabel lblAdmisitrativo) {
		this.lblInstructor = lblAdmisitrativo;
	}

	/**
	 * @return the textIdIntructor
	 */
	public JTextField getTextIdIntructor() {
		return textIdIntructor;
	}

	/**
	 * @param textIdIntructor the textIdIntructor to set
	 */
	public void setTextIdIntructor(JTextField textIdIntructor) {
		this.textIdIntructor = textIdIntructor;
	}

//	public JScrollPane getSpAsignaciones() {
//		return spAsignaciones;
//	}
//
//	public void setSpAsignaciones(JScrollPane spAsignaciones) {
//		this.spAsignaciones = spAsignaciones;
//	}

	public DefaultTableModel getModelAsignaciones() {
		return modelAsignaciones;
	}

	public void setModelAsignaciones(DefaultTableModel modelAsignaciones) {
		this.modelAsignaciones = modelAsignaciones;
	}

//	public JTable getTblAsignaciones() {
//		return tblAsignaciones;
//	}
//
//	public void setTblAsignaciones(JTable tblAsignaciones) {
//		this.tblAsignaciones = tblAsignaciones;
//	}

	public String[] getNombreColumnasAsignaciones() {
		return nombreColumnasAsignaciones;
	}

	public void setNombreColumnasAsignaciones(String[] nombreColumnasAsignaciones) {
		this.nombreColumnasAsignaciones = nombreColumnasAsignaciones;
	}

	public JButton getBtnCerrarPeriodoDe() {
		return btnCerrarPeriodoDe;
	}

	public void setBtnCerrarPeriodoDe(JButton btnCerrarPeriodoDe) {
		this.btnCerrarPeriodoDe = btnCerrarPeriodoDe;
	}

	public JButton getBtnCancelarCursada() {
		return btnCancelarCursada;
	}

	public void setBtnCancelarCursada(JButton btnCancelarCursada) {
		this.btnCancelarCursada = btnCancelarCursada;
	}
}
