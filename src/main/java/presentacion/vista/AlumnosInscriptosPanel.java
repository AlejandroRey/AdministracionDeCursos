package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JButton;
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

@SuppressWarnings("serial")
public class AlumnosInscriptosPanel extends JPanel {

	private JScrollPane spAlumnos;
	private DefaultTableModel modelAlumnos;
	private JTable tblAlumnos;
	private String[] nombreColumnas = {"", "", "Nombre", "Apellido", "Telefono", "Email", "Fecha Insc"};
	
	private JPanel panel;
	
	private JTextField textIdAlumno;
	private JTextField textIdCursada;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textFecha;
	
	private JPanel panelButtons;
	private JButton btnAgregar;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public AlumnosInscriptosPanel() {
		super();
		this.setBounds(0, 0, 630, 600);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTabla();
		inicializarEditor();
		inicializarPanelButtons();
	}

	private void inicializarTabla() {
		
		spAlumnos = new JScrollPane();
		spAlumnos.setBounds(10, 10, 610, 310);
		this.add(spAlumnos);
		
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
		panel.setBounds(65, 336, 500, 120);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Alumno - Inscripto:", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel.setLayout(null);
		this.add(panel);
		
		JLabel lblIdAlumno = new JLabel("id Alumno:");
		lblIdAlumno.setVisible(false);
		lblIdAlumno.setBounds(339, 83, 56, 14);
		panel.add(lblIdAlumno);
		
		textIdAlumno = new JTextField();
		textIdAlumno.setBounds(339, 97, 56, 20);
		textIdAlumno.setVisible(false);
		textIdAlumno.setEnabled(false);
		panel.add(textIdAlumno);
		
		JLabel lblIdCursada = new JLabel("id Cursada:");
		lblIdCursada.setVisible(false);
		lblIdCursada.setBounds(405, 83, 56, 14);
		panel.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada .setBounds(405, 97, 56, 20);
		textIdCursada .setVisible(false);
		textIdCursada .setEnabled(false);
		panel.add(textIdCursada );
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 27, 70, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(97, 24, 141, 20);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(258, 27, 70, 14);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setColumns(10);
		textApellido.setBounds(334, 24, 141, 20);
		panel.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 58, 70, 14);
		panel.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textTelefono.setColumns(10);
		textTelefono.setBounds(97, 55, 141, 20);
		panel.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(258, 55, 70, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);
		textEmail.setBounds(334, 52, 141, 20);
		panel.add(textEmail);		
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(21, 86, 70, 14);
		panel.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setHorizontalAlignment(SwingConstants.LEFT);
		textFecha.setColumns(10);
		textFecha.setBounds(97, 83, 141, 20);
		panel.add(textFecha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 325, 610, 2);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		this.add(separator);
	}

	private void inicializarPanelButtons() {
		
		panelButtons = new JPanel();
		panelButtons.setBounds(65, 470, 500, 84);
		this.add(panelButtons);
		panelButtons.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(108, 46, 280, 30);
		btnAgregar.setVisible(true);
		panelButtons.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(108, 5, 280, 30);
		panelButtons.add(btnEliminar);
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
	 * @return the textFecha
	 */
	public JTextField getTextFecha() {
		return textFecha;
	}

	/**
	 * @param textFecha the textFecha to set
	 */
	public void setTextFecha(JTextField textFecha) {
		this.textFecha = textFecha;
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

}
