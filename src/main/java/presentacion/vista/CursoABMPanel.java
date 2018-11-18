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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CursoTipoDTO;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CursoABMPanel extends JPanel {

	private JScrollPane spCursos;
	private JScrollPane spInteresados;
	private DefaultTableModel modelCursos;
	private DefaultTableModel modelInteresados;
	private JTable tblCursos;
	private JTable tableInteresados;
	private String[] nombreColumnas = {"idCurso","idCursoTipo", "Tipo", "Nombre", "Tema", "Temario"};
	private String[] nombreColumnasInteresados = {"Nombre", "Apellido", "Email", "Fecha"};
	
	private JPanel panel;
	
	private JTextField textIdCurso;
	private JComboBox<CursoTipoDTO> cbxCursoTipo;
	private JTextField textNombre;
	private JTextField textTema;
	
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnSeleccionar;
	
	private JTextArea textAreaTemario;
	private JButton btnConsultarInteresados;

	/**
	 * Create the Panel.
	 */
	public CursoABMPanel() {
		super();
		this.setBounds(0, 0, 900, 670);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTabla();
		inicializarEditor();
		
	}

	private void inicializarTabla() {
		
		spCursos = new JScrollPane();
		spCursos.setBounds(4, 12, 500, 310);
		this.add(spCursos);
		
		modelCursos = new DefaultTableModel(null, nombreColumnas);
		tblCursos = new JTable(modelCursos){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblCursos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spCursos.setViewportView(tblCursos);
		
		spInteresados = new JScrollPane();
		spInteresados.setBounds(4, 492, 500, 164);
		this.add(spInteresados);
		
		modelInteresados = new DefaultTableModel(null, nombreColumnasInteresados);
		tableInteresados = new JTable(modelInteresados){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tableInteresados.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spInteresados.setViewportView(tableInteresados);
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Curso - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panel.setBounds(4, 330, 500, 151);
		this.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdCurso = new JLabel("id Curso:");
		lblIdCurso.setVisible(false);
		lblIdCurso.setBounds(21, 123, 70, 14);
		panel.add(lblIdCurso);
		
		textIdCurso = new JTextField();
		textIdCurso.setBounds(96, 120, 70, 17);
		textIdCurso.setVisible(false);
		textIdCurso.setEnabled(false);
		panel.add(textIdCurso);
		textIdCurso.setColumns(10);
		
		JLabel lblIdCursoTipo = new JLabel("Categoria:");
		lblIdCursoTipo.setBounds(21, 27, 70, 14);
		panel.add(lblIdCursoTipo);
		
		cbxCursoTipo = new JComboBox<>();
		cbxCursoTipo.setBounds(96, 22, 141, 20);
		panel.add(cbxCursoTipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(258, 27, 70, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(334, 24, 141, 20);
		panel.add(textNombre);
		
		JLabel lblTema = new JLabel("Tema: ");
		lblTema.setBounds(21, 58, 70, 14);
		panel.add(lblTema);
		
		textTema = new JTextField();
		textTema.setHorizontalAlignment(SwingConstants.LEFT);
		textTema.setColumns(10);
		textTema.setBounds(96, 55, 141, 20);
		panel.add(textTema);	
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(207, 114, 89, 23);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(207, 114, 89, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(207, 114, 89, 23);
		panel.add(btnEliminar);
		
		btnSeleccionar = new JButton("Cerrar");
		btnSeleccionar.setBounds(207, 114, 89, 23);
		panel.add(btnSeleccionar);
		
		btnConsultarInteresados = new JButton("Consultar interesados");
		btnConsultarInteresados.setBounds(334, 114, 141, 23);
		panel.add(btnConsultarInteresados);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(9, 325, 490, 1);
		this.add(separator);
		
		JPanel panelTemario = new JPanel();
		panelTemario.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Temario", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panelTemario.setBounds(514, 4, 380, 477);
		add(panelTemario);
		panelTemario.setLayout(null);
		
		textAreaTemario = new JTextArea();
		textAreaTemario.setBounds(1, 1, 378, 476);
		
	    JScrollPane scrollTextArea = new JScrollPane ( textAreaTemario );
	    scrollTextArea.setBounds(10, 21, 360, 445);
	    scrollTextArea.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    
	    panelTemario.add(scrollTextArea);
	    
	    /*spInteresados = new JScrollPane();
	    spInteresados.setBounds(4, 492, 500, 194);
	    add(spInteresados);
	    
	    tableInteresados = new JTable();
	    spInteresados.setViewportView(tableInteresados);*/
	}

	/**
	 * @return the spCursos
	 */
	public JScrollPane getSpCursos() {
		return spCursos;
	}

	/**
	 * @param spCursos the spCursos to set
	 */
	public void setSpCursos(JScrollPane spCursos) {
		this.spCursos = spCursos;
	}

	/**
	 * @return the modelCursos
	 */
	public DefaultTableModel getModelCursos() {
		return modelCursos;
	}

	/**
	 * @param modelCursos the modelCursos to set
	 */
	public void setModelCursos(DefaultTableModel modelCursos) {
		this.modelCursos = modelCursos;
	}

	/**
	 * @return the tblCursos
	 */
	public JTable getTblCursos() {
		return tblCursos;
	}

	/**
	 * @param tblCursos the tblCursos to set
	 */
	public void setTblCursos(JTable tblCursos) {
		this.tblCursos = tblCursos;
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
	 * @return the textIdCurso
	 */
	public JTextField getTextIdCurso() {
		return textIdCurso;
	}

	/**
	 * @param textIdCurso the textIdCurso to set
	 */
	public void setTextIdCurso(JTextField textIdCurso) {
		this.textIdCurso = textIdCurso;
	}

	/**
	 * @return the cbxCursoTipo
	 */
	public JComboBox<CursoTipoDTO> getCbxCursoTipo() {
		return cbxCursoTipo;
	}

	/**
	 * @param cbxCursoTipo the cbxCursoTipo to set
	 */
	public void setCbxCursoTipo(JComboBox<CursoTipoDTO> cbxCursoTipo) {
		this.cbxCursoTipo = cbxCursoTipo;
	}

	/**
	 * @return the textNombre
	 */
	public JTextField getTextNombre() {
		return textNombre;
	}

	/**
	 * @param textNombre the textNombre to set
	 */
	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	/**
	 * @return the textTema
	 */
	public JTextField getTextTema() {
		return textTema;
	}

	/**
	 * @param textTema the textTema to set
	 */
	public void setTextTema(JTextField textTema) {
		this.textTema = textTema;
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
	 * @return the textAreaTemario
	 */
	public JTextArea getTextAreaTemario() {
		return textAreaTemario;
	}

	/**
	 * @param textAreaTemario the textAreaTemario to set
	 */
	public void setTextAreaTemario(JTextArea textAreaTemario) {
		this.textAreaTemario = textAreaTemario;
	}

	public JScrollPane getSpInteresados() {
		return spInteresados;
	}

	public void setSpInteresados(JScrollPane spInteresados) {
		this.spInteresados = spInteresados;
	}

	public DefaultTableModel getModelInteresados() {
		return modelInteresados;
	}

	public void setModelInteresados(DefaultTableModel modelInteresados) {
		this.modelInteresados = modelInteresados;
	}

	public JTable getTableInteresados() {
		return tableInteresados;
	}

	public void setTableInteresados(JTable tableInteresados) {
		this.tableInteresados = tableInteresados;
	}

	public String[] getNombreColumnasInteresados() {
		return nombreColumnasInteresados;
	}

	public void setNombreColumnasInteresados(String[] nombreColumnasInteresados) {
		this.nombreColumnasInteresados = nombreColumnasInteresados;
	}

	public JButton getBtnConsultarInteresados() {
		return btnConsultarInteresados;
	}

	public void setBtnConsultarInteresados(JButton btnConsultarInteresados) {
		this.btnConsultarInteresados = btnConsultarInteresados;
	}
}
