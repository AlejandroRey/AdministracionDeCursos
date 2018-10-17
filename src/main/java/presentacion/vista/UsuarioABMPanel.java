package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CategoriaDTO;

@SuppressWarnings("serial")
public class UsuarioABMPanel extends JPanel {
	
	private JComboBox<CategoriaDTO> cbxCategoriaFiltro;
	private JScrollPane spUsuarios;
	private DefaultTableModel modelUsuarios;
	private JTable tblUsuarios;
	private String[] nombreColumnas = {"idUsuario", "idCategoria", "Categoria", "Nombre", "Apellido", "Telefono", "Email", "Usuario", "Password"};
	
	private JPanel panel;
	
	private JTextField textIdUsuario;
	private JComboBox<CategoriaDTO> cbxCategoria;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textUsuario;
	private JPasswordField textPassword;
	
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnSeleccionar;

	/**
	 * Create the frame.
	 */
	public UsuarioABMPanel() {
		super();
		this.setBounds(0, 0, 600, 650);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTabla();
		inicializarEditor();
		
	}

	private void inicializarTabla() {
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(4, 14, 46, 14);
		this.add(lblFiltro);
		
		cbxCategoriaFiltro = new JComboBox<>();
		cbxCategoriaFiltro.setBounds(48, 11, 141, 20);
		this.add(cbxCategoriaFiltro);
		
		spUsuarios = new JScrollPane();
		spUsuarios.setBounds(4, 53, 578, 339);
		this.add(spUsuarios);
		
		modelUsuarios = new DefaultTableModel(null, nombreColumnas);
		tblUsuarios = new JTable(modelUsuarios){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblusuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spUsuarios.setViewportView(tblUsuarios);		
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Usuario:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panel.setBounds(43, 403, 500, 197);
		this.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("id Usuario:");
		lblIdUsuario.setVisible(false);
		lblIdUsuario.setBounds(256, 22, 70, 14);
		panel.add(lblIdUsuario);
		
		textIdUsuario = new JTextField();
		textIdUsuario.setBounds(332, 22, 70, 20);
		textIdUsuario.setVisible(false);
		textIdUsuario.setEnabled(false);
		panel.add(textIdUsuario);
		textIdUsuario.setColumns(10);
		
		JLabel lblCursoTipo = new JLabel("Categoria:");
		lblCursoTipo.setBounds(20, 22, 70, 14);
		panel.add(lblCursoTipo);
		
		cbxCategoria = new JComboBox<>();
		cbxCategoria.setBounds(96, 22, 141, 20);
		panel.add(cbxCategoria);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 56, 70, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(96, 56, 141, 20);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(257, 56, 70, 14);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setColumns(10);
		textApellido.setBounds(333, 56, 141, 20);
		panel.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(20, 87, 70, 14);
		panel.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textTelefono.setColumns(10);
		textTelefono.setBounds(96, 87, 141, 20);
		panel.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(257, 84, 70, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);
		textEmail.setBounds(332, 84, 141, 20);
		panel.add(textEmail);	
		
		
		///
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 116, 70, 14);
		panel.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		textUsuario.setColumns(10);
		textUsuario.setBounds(96, 116, 141, 20);
		panel.add(textUsuario);
		///
		
		///
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(256, 116, 70, 14);
		panel.add(lblPassword);
		
		textPassword = new JPasswordField();
		textPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textPassword.setColumns(10);
		textPassword.setBounds(333, 116, 141, 20);
		panel.add(textPassword);
		///
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(207, 163, 89, 23);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(207, 163, 89, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(207, 163, 89, 23);
		panel.add(btnEliminar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(207, 163, 89, 23);
		panel.add(btnSeleccionar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(13, 395, 560, 1);
		this.add(separator);
	}

	/**
	 * @return the cbxCategoriaFiltro
	 */
	public JComboBox<CategoriaDTO> getCbxCategoriaFiltro() {
		return cbxCategoriaFiltro;
	}

	/**
	 * @param cbxCategoriaFiltro the cbxCategoriaFiltro to set
	 */
	public void setCbxCategoriaFiltro(JComboBox<CategoriaDTO> cbxCategoriaFiltro) {
		this.cbxCategoriaFiltro = cbxCategoriaFiltro;
	}

	/**
	 * @return the spUsuarios
	 */
	public JScrollPane getSpUsuarios() {
		return spUsuarios;
	}

	/**
	 * @param spUsuarios the spUsuarios to set
	 */
	public void setSpUsuarios(JScrollPane spUsuarios) {
		this.spUsuarios = spUsuarios;
	}

	/**
	 * @return the modelUsuarios
	 */
	public DefaultTableModel getModelUsuarios() {
		return modelUsuarios;
	}

	/**
	 * @param modelUsuarios the modelUsuarios to set
	 */
	public void setModelUsuarios(DefaultTableModel modelUsuarios) {
		this.modelUsuarios = modelUsuarios;
	}

	/**
	 * @return the tblUsuarios
	 */
	public JTable getTblUsuarios() {
		return tblUsuarios;
	}

	/**
	 * @param tblUsuarios the tblUsuarios to set
	 */
	public void setTblUsuarios(JTable tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
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
	 * @return the textIdUsuario
	 */
	public JTextField getTextIdUsuario() {
		return textIdUsuario;
	}

	/**
	 * @param textIdUsuario the textIdUsuario to set
	 */
	public void setTextIdUsuario(JTextField textIdUsuario) {
		this.textIdUsuario = textIdUsuario;
	}

	/**
	 * @return the cbxCategoria
	 */
	public JComboBox<CategoriaDTO> getCbxCategoria() {
		return cbxCategoria;
	}

	/**
	 * @param cbxCategoria the cbxCategoria to set
	 */
	public void setCbxCategoria(JComboBox<CategoriaDTO> cbxCategoria) {
		this.cbxCategoria = cbxCategoria;
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
	 * @return the textApellido
	 */
	public JTextField getTextApellido() {
		return textApellido;
	}

	/**
	 * @param textApellido the textApellido to set
	 */
	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	/**
	 * @return the textTelefono
	 */
	public JTextField getTextTelefono() {
		return textTelefono;
	}

	/**
	 * @param textTelefono the textTelefono to set
	 */
	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}

	/**
	 * @return the textEmail
	 */
	public JTextField getTextEmail() {
		return textEmail;
	}

	/**
	 * @param textEmail the textEmail to set
	 */
	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	/**
	 * @return the textUsuario
	 */
	public JTextField getTextUsuario() {
		return textUsuario;
	}

	/**
	 * @param textUsuario the textUsuario to set
	 */
	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	/**
	 * @return the textPassword
	 */
	public JPasswordField getTextPassword() {
		return textPassword;
	}

	/**
	 * @param textPassword the textPassword to set
	 */
	public void setTextPassword(JPasswordField textPassword) {
		this.textPassword = textPassword;
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

}
