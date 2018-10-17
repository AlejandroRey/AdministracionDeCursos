package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import dto.CursoTipoDTO;
import persistencia.conexion.Conexion;

public class ADescarteInstructorCrudVista {

	private JFrame frame;
	
	private JComboBox<CursoTipoDTO> cbxCursoTipoFiltro;
	private JScrollPane spInstructores;
	private DefaultTableModel modelInstructores;
	private JTable tblInstructores;
	private String[] nombreColumnas = {"id Inst", "id CursT", "Curso Tipo", "Nombre", "Apellido", "Telefono", "Email"};
	
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
	public ADescarteInstructorCrudVista() {
		super();
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inicializarTabla();
		inicializarEditor();		
	}

	@SuppressWarnings("serial")
	private void inicializarTabla() {
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(4, 14, 46, 14);
		frame.getContentPane().add(lblFiltro);
		
		cbxCursoTipoFiltro = new JComboBox<>();
		cbxCursoTipoFiltro.setBounds(48, 11, 105, 20);
		frame.getContentPane().add(cbxCursoTipoFiltro);
		
		spInstructores = new JScrollPane();
		spInstructores.setBounds(4, 53, 578, 308);
		frame.getContentPane().add(spInstructores);
		
		modelInstructores = new DefaultTableModel(null, nombreColumnas);
		tblInstructores = new JTable(modelInstructores){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spInstructores.setViewportView(tblInstructores);		
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Instructor - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(43, 380, 500, 170);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdInstructor = new JLabel("id Instructor:");
		lblIdInstructor.setVisible(false);
		lblIdInstructor.setBounds(256, 22, 70, 14);
		panel.add(lblIdInstructor);
		
		textIdInstructor = new JTextField();
		textIdInstructor.setBounds(332, 22, 70, 20);
		textIdInstructor.setVisible(false);
		textIdInstructor.setEnabled(false);
		panel.add(textIdInstructor);
		textIdInstructor.setColumns(10);
		
		JLabel lblCursoTipo = new JLabel("Curso Tipo:");
		lblCursoTipo.setBounds(20, 22, 70, 14);
		panel.add(lblCursoTipo);
		
		cbxCursoTipo = new JComboBox<>();
		cbxCursoTipo.setBounds(96, 22, 141, 20);
		panel.add(cbxCursoTipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 56, 70, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(96, 53, 141, 20);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(257, 56, 70, 14);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setColumns(10);
		textApellido.setBounds(333, 53, 141, 20);
		panel.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(20, 87, 70, 14);
		panel.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textTelefono.setColumns(10);
		textTelefono.setBounds(96, 84, 141, 20);
		panel.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(257, 84, 70, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);
		textEmail.setBounds(333, 81, 141, 20);
		panel.add(textEmail);		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(206, 136, 89, 23);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(206, 136, 89, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(206, 136, 89, 23);
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(206, 136, 89, 23);
		panel.add(btnCerrar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.BLUE);
		separator.setBounds(13, 372, 560, 1);
		frame.getContentPane().add(separator);
	}
	
	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Aplicacion!?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					frame.dispose();
				}
			}
		});
		this.frame.setVisible(true);
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

	/**
	 * @return the modelInstructores
	 */
	public DefaultTableModel getModelInstructores() {
		return modelInstructores;
	}

	/**
	 * @param modelInstructores the modelInstructores to set
	 */
	public void setModelInstructores(DefaultTableModel modelInstructores) {
		this.modelInstructores = modelInstructores;
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
}
