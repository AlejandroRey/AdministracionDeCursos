package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
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

import persistencia.conexion.Conexion;

public class AlumnoCrudVista {

	private JFrame frame;

	private JScrollPane spAlumnos;
	private DefaultTableModel modelAlumnos;
	private JTable tblAlumnos;
	private String[] nombreColumnas = {"idAlumno", "Nombre", "Apellido", "Telefono", "Email"};
	
	private JPanel panel;
	
	private JTextField textIdAlumno;
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
	public AlumnoCrudVista() {
		super();
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inicializarTabla();
		inicializarEditor();		
	}

	@SuppressWarnings("serial")
	private void inicializarTabla() {
		
		spAlumnos = new JScrollPane();
		spAlumnos.setBounds(4, 4, 576, 310);
		frame.getContentPane().add(spAlumnos);
		
		modelAlumnos = new DefaultTableModel(null, nombreColumnas);
		tblAlumnos = new JTable(modelAlumnos){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spAlumnos.setViewportView(tblAlumnos);		
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Alumno - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(41, 336, 500, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdInstructor = new JLabel("id Alumno:");
		lblIdInstructor.setVisible(false);
		lblIdInstructor.setBounds(203, 83, 70, 14);
		panel.add(lblIdInstructor);
		
		textIdAlumno = new JTextField();
		textIdAlumno.setBounds(279, 83, 70, 20);
		textIdAlumno.setVisible(false);
		textIdAlumno.setEnabled(false);
		panel.add(textIdAlumno);
		textIdAlumno.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 27, 70, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(97, 24, 141, 20);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(258, 27, 70, 14);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setColumns(10);
		textApellido.setBounds(334, 24, 141, 20);
		panel.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 58, 70, 14);
		panel.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textTelefono.setColumns(10);
		textTelefono.setBounds(97, 55, 141, 20);
		panel.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(258, 55, 70, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);
		textEmail.setBounds(334, 52, 141, 20);
		panel.add(textEmail);		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(19, 114, 89, 23);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(144, 114, 89, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(261, 114, 89, 23);
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(384, 114, 89, 23);
		panel.add(btnCerrar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.BLUE);
		separator.setBounds(11, 320, 560, 1);
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
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	/**
	 * @return the spAlumnos
	 */
	public JScrollPane getSpAlumnos() {
		return spAlumnos;
	}

	/**
	 * @param spAlumnos the spAlumnos to set
	 */
	public void setSpAlumnos(JScrollPane spAlumnos) {
		this.spAlumnos = spAlumnos;
	}

	/**
	 * @return the modelAlumnos
	 */
	public DefaultTableModel getModelAlumnos() {
		return modelAlumnos;
	}

	/**
	 * @param modelAlumnos the modelAlumnos to set
	 */
	public void setModelAlumnos(DefaultTableModel modelAlumnos) {
		this.modelAlumnos = modelAlumnos;
	}

	/**
	 * @return the tblAlumnos
	 */
	public JTable getTblAlumnos() {
		return tblAlumnos;
	}

	/**
	 * @param tblAlumnos the tblAlumnos to set
	 */
	public void setTblAlumnos(JTable tblAlumnos) {
		this.tblAlumnos = tblAlumnos;
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
	 * @return the textIdAlumno
	 */
	public JTextField getTextIdAlumno() {
		return textIdAlumno;
	}

	/**
	 * @param textIdAlumno the textIdAlumno to set
	 */
	public void setTextIdAlumno(JTextField textIdAlumno) {
		this.textIdAlumno = textIdAlumno;
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
