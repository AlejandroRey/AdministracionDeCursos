package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dto.CursoTipoDTO;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class InstructorCrudVista extends JFrame {

	private JPanel contentPane;
	
	private JComboBox<CursoTipoDTO> cbxCursoTipoFiltro;
	private JTable tblInstructores;
	
	private JPanel panel;
	
	private JTextField textIdInstructor;
	private JComboBox<CursoTipoDTO> cbxCursoTipo;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textEmail;
	
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCerrar;

	/**
	 * Create the frame.
	 */
	public InstructorCrudVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		inicializar();
	}

	private void inicializar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inicializarTabla();
		inicializarEditor();		
	}

	private void inicializarTabla() {
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(4, 14, 46, 14);
		contentPane.add(lblFiltro);
		
		cbxCursoTipoFiltro = new JComboBox<>();
		cbxCursoTipoFiltro.setBounds(48, 11, 141, 20);
		contentPane.add(cbxCursoTipoFiltro);

		tblInstructores = new JTable();
		tblInstructores.setBounds(4, 53, 574, 250);
		contentPane.add(tblInstructores);
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Instructor - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(41, 326, 500, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id Instructor:");
		lblNewLabel.setBounds(21, 30, 70, 14);
		panel.add(lblNewLabel);
		
		textIdInstructor = new JTextField();
		textIdInstructor.setBounds(97, 30, 70, 20);
		textIdInstructor.setEnabled(false);
		panel.add(textIdInstructor);
		textIdInstructor.setColumns(10);
		
		JLabel lblCursoTipo = new JLabel("Curso Tipo:");
		lblCursoTipo.setBounds(21, 61, 70, 14);
		panel.add(lblCursoTipo);
		
		cbxCursoTipo = new JComboBox<>();
		cbxCursoTipo.setBounds(97, 61, 141, 20);
		panel.add(cbxCursoTipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 95, 70, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(97, 92, 141, 20);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(258, 95, 70, 14);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(334, 92, 141, 20);
		panel.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 126, 70, 14);
		panel.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(97, 123, 141, 20);
		panel.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(258, 123, 70, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(334, 120, 141, 20);
		panel.add(textEmail);		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(34, 179, 89, 23);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(146, 179, 89, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(258, 179, 89, 23);
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(370, 179, 89, 23);
		panel.add(btnCerrar);
	}

	/**
	 * @return the cbxCursoTipoFiltro
	 */
	public JComboBox<CursoTipoDTO> getCbxCursoTipoFiltro() {
		return cbxCursoTipoFiltro;
	}

	/**
	 * @param cbxCursoTipoFiltro the cbxCursoTipoFiltro to set
	 */
	public void setCbxCursoTipoFiltro(JComboBox<CursoTipoDTO> cbxCursoTipoFiltro) {
		this.cbxCursoTipoFiltro = cbxCursoTipoFiltro;
	}

	/**
	 * @return the tblInstructores
	 */
	public JTable getTblInstructores() {
		return tblInstructores;
	}

	/**
	 * @param tblInstructores the tblInstructores to set
	 */
	public void setTblInstructores(JTable tblInstructores) {
		this.tblInstructores = tblInstructores;
	}

	/**
	 * @return the textIdInstructor
	 */
	public JTextField getTextIdInstructor() {
		return textIdInstructor;
	}

	/**
	 * @param textIdInstructor the textIdInstructor to set
	 */
	public void setTextIdInstructor(JTextField textIdInstructor) {
		this.textIdInstructor = textIdInstructor;
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
	 * @return the btnCerrar
	 */
	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	/**
	 * @param btnCerrar the btnCerrar to set
	 */
	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}
}
