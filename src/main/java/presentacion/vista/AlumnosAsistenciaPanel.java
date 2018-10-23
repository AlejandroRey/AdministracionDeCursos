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
public class AlumnosAsistenciaPanel extends JPanel {

	private JScrollPane spAlumnos;
	private DefaultTableModel modelAlumnos;
	private JTable tblAlumnos;
	private String[] nombreColumnas = {"idAlumno", "idCursada", "Nombre", "Apellido", "Telefono", "Email", "Fecha Insc", "P"};
	
	private JScrollPane spFechasDeCursada;
	private DefaultTableModel modelFechasDeCursada;
	private JTable tblFechasDeCursada;
	private String[] nombreColumnasFechasDeCursada = {"idFechaCursada", "idCursada", "idSala", "fechaInicio", "fechaFin"};
	
	private JPanel panelAlumnoDTO;	
	private JTextField textIdAlumno;
	private JTextField textIdCursada;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textFecha;
	//private JCheckBox chxAsistencia;
	
	private JPanel panelButtons;
	private JButton btnAgregar;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public AlumnosAsistenciaPanel() {
		super();
		this.setBounds(0, 0, 860, 420);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTablaFechasDeCursada();
		inicializarTablaAlumnosInscriptos();
		inicializarEditor();
		inicializarPanelButtons();
	}
	
	private void inicializarTablaFechasDeCursada() {
		
		spFechasDeCursada = new JScrollPane();
		spFechasDeCursada.setBounds(10, 10, 250, 379);
		add(spFechasDeCursada);
		
		modelFechasDeCursada = new DefaultTableModel(null, nombreColumnasFechasDeCursada);
		tblFechasDeCursada = new JTable(modelFechasDeCursada) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}
		};
		
		tblFechasDeCursada.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spFechasDeCursada.setViewportView(tblFechasDeCursada);		
	}

	private void inicializarTablaAlumnosInscriptos() {
		
		spAlumnos = new JScrollPane();
		spAlumnos.setBounds(270, 10, 610, 379);
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

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                    	return String.class;
                    case 3:
                    	return String.class;
                    case 4:
                    	return String.class;
                    case 5:
                    	return String.class;
                    case 6:
                    	return String.class;
                    default:
                        return Boolean.class;
                }
            }
		};
		tblAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spAlumnos.setViewportView(tblAlumnos);		
	}

	private void inicializarEditor() {		
		
		panelAlumnoDTO = new JPanel();
		panelAlumnoDTO.setVisible(false);
		panelAlumnoDTO.setBounds(295, 10, 500, 120);
		panelAlumnoDTO.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Alumno - Inscripto:", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panelAlumnoDTO.setLayout(null);
		this.add(panelAlumnoDTO);
		
		JLabel lblIdAlumno = new JLabel("id Alumno:");
		lblIdAlumno.setVisible(false);
		lblIdAlumno.setBounds(339, 83, 56, 14);
		panelAlumnoDTO.add(lblIdAlumno);
		
		textIdAlumno = new JTextField();
		textIdAlumno.setBounds(339, 97, 56, 20);
		textIdAlumno.setVisible(false);
		textIdAlumno.setEnabled(false);
		panelAlumnoDTO.add(textIdAlumno);
		
		JLabel lblIdCursada = new JLabel("id Cursada:");
		lblIdCursada.setVisible(false);
		lblIdCursada.setBounds(405, 83, 56, 14);
		panelAlumnoDTO.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada .setBounds(405, 97, 56, 20);
		textIdCursada .setVisible(false);
		textIdCursada .setEnabled(false);
		panelAlumnoDTO.add(textIdCursada );
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 27, 70, 14);
		panelAlumnoDTO.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(97, 24, 141, 20);
		panelAlumnoDTO.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(258, 27, 70, 14);
		panelAlumnoDTO.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setColumns(10);
		textApellido.setBounds(334, 24, 141, 20);
		panelAlumnoDTO.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 58, 70, 14);
		panelAlumnoDTO.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textTelefono.setColumns(10);
		textTelefono.setBounds(97, 55, 141, 20);
		panelAlumnoDTO.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(258, 55, 70, 14);
		panelAlumnoDTO.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);
		textEmail.setBounds(334, 52, 141, 20);
		panelAlumnoDTO.add(textEmail);		
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(21, 86, 70, 14);
		panelAlumnoDTO.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setHorizontalAlignment(SwingConstants.LEFT);
		textFecha.setColumns(10);
		textFecha.setBounds(97, 83, 141, 20);
		panelAlumnoDTO.add(textFecha);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaptionText);
		separator.setBounds(270, 400, 610, 4);
		separator.setBorder(new MatteBorder(4, 1, 1, 1, (Color) new Color(153, 180, 209)));
		separator.setBackground(SystemColor.activeCaption);
		this.add(separator);
	}

	private void inicializarPanelButtons() {
		
		panelButtons = new JPanel();
		panelButtons.setVisible(false);
		panelButtons.setBounds(295, 10, 500, 84);
		this.add(panelButtons);
		panelButtons.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(108, 46, 280, 30);
		btnAgregar.setVisible(true);
		panelButtons.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(108, 5, 280, 30);
		panelButtons.add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new MatteBorder(4, 1, 1, 1, (Color) new Color(153, 180, 209)));
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(10, 400, 250, 4);
		add(separator);
	}

	/**
	 * @return the spFechasDeCursada
	 */
	public JScrollPane getSpFechasDeCursada() {
		return spFechasDeCursada;
	}

	/**
	 * @param spFechasDeCursada the spFechasDeCursada to set
	 */
	public void setSpFechasDeCursada(JScrollPane spFechasDeCursada) {
		this.spFechasDeCursada = spFechasDeCursada;
	}

	/**
	 * @return the modelFechasDeCursada
	 */
	public DefaultTableModel getModelFechasDeCursada() {
		return modelFechasDeCursada;
	}

	/**
	 * @param modelFechasDeCursada the modelFechasDeCursada to set
	 */
	public void setModelFechasDeCursada(DefaultTableModel modelFechasDeCursada) {
		this.modelFechasDeCursada = modelFechasDeCursada;
	}

	/**
	 * @return the tblFechasDeCursada
	 */
	public JTable getTblFechasDeCursada() {
		return tblFechasDeCursada;
	}

	/**
	 * @param tblFechasDeCursada the tblFechasDeCursada to set
	 */
	public void setTblFechasDeCursada(JTable tblFechasDeCursada) {
		this.tblFechasDeCursada = tblFechasDeCursada;
	}

	/**
	 * @return the nombreColumnasFechasDeCursada
	 */
	public String[] getNombreColumnasFechasDeCursada() {
		return nombreColumnasFechasDeCursada;
	}

	/**
	 * @param nombreColumnasFechasDeCursada the nombreColumnasFechasDeCursada to set
	 */
	public void setNombreColumnasFechasDeCursada(String[] nombreColumnasFechasDeCursada) {
		this.nombreColumnasFechasDeCursada = nombreColumnasFechasDeCursada;
	}

	/**
	 * @return the panelAlumnoDTO
	 */
	public JPanel getPanelAlumnoDTO() {
		return panelAlumnoDTO;
	}

	/**
	 * @param panelAlumnoDTO the panelAlumnoDTO to set
	 */
	public void setPanelAlumnoDTO(JPanel panelAlumnoDTO) {
		this.panelAlumnoDTO = panelAlumnoDTO;
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

}
