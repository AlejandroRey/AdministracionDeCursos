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

import dto.AlumnoDTO;
import dto.CursoDTO;
import dto.UsuarioDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import persistencia.conexion.Conexion;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;

public class AlumnoEventoCrudVista {
	
	private JFrame frame;

	private JScrollPane spAlumnoEventos;
	private DefaultTableModel modelAlumnoEventos;
	private JTable tblAlumnoEventos;
	private String[] nombreColumnas = {"idAlumnoEvento","Alumno", "Usuario", "Curso", "Descripcion", "Contactar", "Creacion", "Estado"};
	
	private JPanel panel;
	
	private JTextField textIdAlumnoEvento;
	private JComboBox<AlumnoDTO> cbxIdAlumno;
	private JComboBox<UsuarioDTO> cbxIdUsuario;
	private JComboBox<CursoDTO> cbxIdCurso;
	private JTextPane textDescripcion;
	private UtilDateModel utilDateModelFechaContactar;
	private JDatePanelImpl datePanelFechaContactar;
	private JDatePickerImpl datePickerFechaContactar;
	private JRadioButton rdbtnAbierto;
	private JRadioButton rdbtnCerrado;
	
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private SpringLayout springLayout;

	/**
	 * Create the frame.
	 */
	public AlumnoEventoCrudVista() {
		super();
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		inicializarTabla();
		inicializarEditor();		
	}

	@SuppressWarnings("serial")
	private void inicializarTabla() {
		
		spAlumnoEventos = new JScrollPane();
		spAlumnoEventos.setBounds(15, 4, 706, 310);
		frame.getContentPane().add(spAlumnoEventos);
		
		modelAlumnoEventos = new DefaultTableModel(null, nombreColumnas);
		tblAlumnoEventos = new JTable(modelAlumnoEventos){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblAlumnoEventos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spAlumnoEventos.setViewportView(tblAlumnoEventos);		
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contactar - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(15, 330, 706, 181);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdAlumnoEvento = new JLabel("id AlumnoEvento:");
		lblIdAlumnoEvento.setVisible(false);
		lblIdAlumnoEvento.setBounds(301, 167, 132, 14);
		panel.add(lblIdAlumnoEvento);
		
		textIdAlumnoEvento = new JTextField();
		textIdAlumnoEvento.setBounds(448, 165, 102, 17);
		textIdAlumnoEvento.setVisible(false);
		textIdAlumnoEvento.setEnabled(false);
		panel.add(textIdAlumnoEvento);
		textIdAlumnoEvento.setColumns(10);
		
		JLabel lblIdAlumno = new JLabel("Id Alumno:");
		lblIdAlumno.setBounds(15, 37, 95, 19);
		panel.add(lblIdAlumno);
		
		cbxIdAlumno = new JComboBox<>();
		cbxIdAlumno.setBounds(110, 33, 141, 23);
		panel.add(cbxIdAlumno);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario: ");
		lblIdUsuario.setBounds(15, 76, 95, 19);
		panel.add(lblIdUsuario);
		
		cbxIdUsuario = new JComboBox<>();
		cbxIdUsuario.setBounds(110, 72, 141, 23);
		panel.add(cbxIdUsuario);
		
		JLabel lblIdCurso = new JLabel("Id Curso: ");
		lblIdCurso.setBounds(15, 111, 95, 19);
		panel.add(lblIdCurso);
		
		cbxIdCurso = new JComboBox<>();
		cbxIdCurso.setBounds(110, 107, 141, 23);
		panel.add(cbxIdCurso);
		
		JLabel lblFechaContactar = new JLabel("Contactar: ");
		lblFechaContactar.setBounds(15, 146, 95, 29);
		panel.add(lblFechaContactar);
		
		utilDateModelFechaContactar = new UtilDateModel();
		datePanelFechaContactar = new JDatePanelImpl(utilDateModelFechaContactar);
		datePickerFechaContactar = new JDatePickerImpl(datePanelFechaContactar);
		datePickerFechaContactar.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);
		springLayout = (SpringLayout) datePickerFechaContactar.getLayout();
		datePickerFechaContactar.setBounds(110, 146, 141, 29);
		datePickerFechaContactar.getJFormattedTextField().setText("");
		panel.add(datePickerFechaContactar);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(367, 33, 102, 14);
		panel.add(lblDescripcion);
		
		textDescripcion = new JTextPane();
		textDescripcion.setBounds(301, 55, 249, 65);
		panel.add(textDescripcion);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(589, 27, 102, 23);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(589, 68, 102, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(589, 107, 102, 23);
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(589, 146, 102, 23);
		panel.add(btnCerrar);
		
		rdbtnAbierto = new JRadioButton("Abierto");
		rdbtnAbierto.setBounds(332, 132, 89, 23);
		panel.add(rdbtnAbierto);
		
		rdbtnCerrado = new JRadioButton("Cerrado");
		rdbtnCerrado.setBounds(428, 129, 89, 29);
		panel.add(rdbtnCerrado);
						
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.BLUE);
		separator.setBounds(21, 319, 700, 1);
		frame.getContentPane().add(separator);
	}
	
	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la vista!?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					frame.dispose();
				}
			}
		});
		this.frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JScrollPane getSpAlumnoEventos() {
		return spAlumnoEventos;
	}

	public void setSpAlumnoEventos(JScrollPane spAlumnoEventos) {
		this.spAlumnoEventos = spAlumnoEventos;
	}

	public DefaultTableModel getModelAlumnoEventos() {
		return modelAlumnoEventos;
	}

	public void setModelAlumnoEventos(DefaultTableModel modelAlumnoEventos) {
		this.modelAlumnoEventos = modelAlumnoEventos;
	}

	public JTable getTblAlumnoEventos() {
		return tblAlumnoEventos;
	}

	public void setTblAlumnoEventos(JTable tblAlumnoEventos) {
		this.tblAlumnoEventos = tblAlumnoEventos;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextIdAlumnoEvento() {
		return textIdAlumnoEvento;
	}

	public void setTextIdAlumnoEvento(JTextField textIdAlumnoEvento) {
		this.textIdAlumnoEvento = textIdAlumnoEvento;
	}

	public JComboBox<AlumnoDTO> getCbxIdAlumno() {
		return cbxIdAlumno;
	}

	public void setCbxIdAlumno(JComboBox<AlumnoDTO> cbxIdAlumno) {
		this.cbxIdAlumno = cbxIdAlumno;
	}

	public JComboBox<UsuarioDTO> getCbxIdUsuario() {
		return cbxIdUsuario;
	}

	public void setCbxIdUsuario(JComboBox<UsuarioDTO> cbxIdUsuario) {
		this.cbxIdUsuario = cbxIdUsuario;
	}

	public JComboBox<CursoDTO> getCbxIdCurso() {
		return cbxIdCurso;
	}

	public void setCbxIdCurso(JComboBox<CursoDTO> cbxIdCurso) {
		this.cbxIdCurso = cbxIdCurso;
	}

	public UtilDateModel getUtilDateModelFechaContactar() {
		return utilDateModelFechaContactar;
	}

	public void setUtilDateModelFechaContactar(UtilDateModel utilDateModelFechaContactar) {
		this.utilDateModelFechaContactar = utilDateModelFechaContactar;
	}

	public JTextPane getTextDescripcion() {
		return textDescripcion;
	}

	public void setTextDescripcion(JTextPane textDescripcion) {
		this.textDescripcion = textDescripcion;
	}

	public JDatePanelImpl getDatePanelFechaContactar() {
		return datePanelFechaContactar;
	}

	public void setDatePanelFechaContactar(JDatePanelImpl datePanelFechaContactar) {
		this.datePanelFechaContactar = datePanelFechaContactar;
	}

	public JDatePickerImpl getDatePickerFechaContactar() {
		return datePickerFechaContactar;
	}

	public void setDatePickerFechaContactar(JDatePickerImpl datePickerFechaContactar) {
		this.datePickerFechaContactar = datePickerFechaContactar;
	}

	public JRadioButton getRdbtnAbierto() {
		return rdbtnAbierto;
	}

	public void setRdbtnAbierto(JRadioButton rdbtnAbierto) {
		this.rdbtnAbierto = rdbtnAbierto;
	}

	public JRadioButton getRdbtnCerrado() {
		return rdbtnCerrado;
	}

	public void setRdbtnCerrado(JRadioButton rdbtnCerrado) {
		this.rdbtnCerrado = rdbtnCerrado;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public SpringLayout getSpringLayout() {
		return springLayout;
	}

	public void setSpringLayout(SpringLayout springLayout) {
		this.springLayout = springLayout;
	}
}