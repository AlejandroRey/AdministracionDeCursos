package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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

	private JScrollPane spFechasDeCursada;
	private DefaultTableModel modelFechasDeCursada;
	private JTable tblFechasDeCursada;
	private String[] nombreColumnasFechasDeCursada = {"idFechaCursada", "idCursada", "idSala", "fechaInicio", "fechaFin", "Fecha", "Ini", "Fin","Pre", "Aus"};
	
	private JScrollPane spAlumnos;
	private DefaultTableModel modelAlumnos;
	private JTable tblAlumnos;
	private String[] nombreColumnas = {"idAlumno", "idCursada", "Nombre", "Apellido", "Telefono", "Email", "Fecha Insc", "Asistencia", "Pres", "Aus"};
	
	
	private JPanel panelAlumnoDTO;	
	private JTextField textIdAlumno;
	private JTextField textIdCursada;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textFecha;
	private JTextField textPresente;
	private JTextField textAusente;
	//private JCheckBox chxAsistencia;
	
	private JPanel panelButtons;
	private JButton btnAgregar;
	private JButton btnEliminar;
	
	private JButton btnAnterior;
	private JButton btnSiguiente;
	
	private ButtonGroup rbtnGroup;;
	private JRadioButton rbtnPresente;
	private JRadioButton rbtnAusente;
	private JTextField textPresenteTotal;
	private JTextField textAusenteTotal;
	private JLabel lblFechaCursadaSeleccionada;

	/**
	 * Create the frame.
	 */
	public AlumnosAsistenciaPanel() {
		super();
		this.setBounds(0, 0, 960, 500);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {
		
		inicializarTablaFechasDeCursada();
		inicializarTablaAlumnosInscriptos();
		inicializarEditor();
		inicializarPanelButtons();
		inicializarRadioButtonsGroup();
	}
	
	private void inicializarRadioButtonsGroup() {
		
		rbtnGroup = new ButtonGroup();

		rbtnPresente = new JRadioButton("Presente", false);
		rbtnPresente.setSize(100, 20);
		rbtnPresente.setLocation(21, 274);
		rbtnAusente = new JRadioButton("Ausente", false);
		rbtnAusente.setSize(100, 20);
		rbtnAusente.setLocation(21, 297);

		rbtnGroup.add(rbtnPresente);
		rbtnGroup.add(rbtnAusente);

		panelAlumnoDTO.add(rbtnPresente);
		panelAlumnoDTO.add(rbtnAusente);
	}

	private void inicializarTablaFechasDeCursada() {
		
		spFechasDeCursada = new JScrollPane();
		spFechasDeCursada.setBounds(10, 90, 250, 379);
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
		spAlumnos.setBounds(270, 90, 420, 379);
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

//			@SuppressWarnings({ "unchecked", "rawtypes" })
//			@Override
//            public Class getColumnClass(int column) {
//                switch (column) {
//                    case 0:
//                        return String.class;
//                    case 1:
//                        return String.class;
//                    case 2:
//                    	return String.class;
//                    case 3:
//                    	return String.class;
//                    case 4:
//                    	return String.class;
//                    case 5:
//                    	return String.class;
//                    case 6:
//                    	return String.class;
//                    default:
//                        return Boolean.class;
//                }
//            }
		};
		tblAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spAlumnos.setViewportView(tblAlumnos);		
	}

	private void inicializarEditor() {		
		
		panelAlumnoDTO = new JPanel();
		panelAlumnoDTO.setVisible(true);
		panelAlumnoDTO.setBounds(700, 81, 250, 388);
		panelAlumnoDTO.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Alumno Seleccionado:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAlumnoDTO.setLayout(null);
		this.add(panelAlumnoDTO);
		
		JLabel lblIdAlumno = new JLabel("id Alumno:");
		lblIdAlumno.setVisible(false);
		lblIdAlumno.setBounds(183, 190, 56, 14);
		panelAlumnoDTO.add(lblIdAlumno);
		
		textIdAlumno = new JTextField();
		textIdAlumno.setBounds(183, 195, 56, 20);
		textIdAlumno.setVisible(false);
		textIdAlumno.setEnabled(false);
		panelAlumnoDTO.add(textIdAlumno);
		
		JLabel lblIdCursada = new JLabel("id Cursada:");
		lblIdCursada.setVisible(false);
		lblIdCursada.setBounds(183, 215, 56, 14);
		panelAlumnoDTO.add(lblIdCursada);
		
		textIdCursada = new JTextField();
		textIdCursada .setBounds(183, 226, 56, 20);
		textIdCursada .setVisible(false);
		textIdCursada .setEnabled(false);
		panelAlumnoDTO.add(textIdCursada );
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 25, 70, 14);
		panelAlumnoDTO.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		textNombre.setBounds(101, 25, 141, 20);
		panelAlumnoDTO.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(21, 127, 70, 14);
		panelAlumnoDTO.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setEditable(false);
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setColumns(10);
		textApellido.setBounds(101, 127, 141, 20);
		panelAlumnoDTO.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 59, 70, 14);
		panelAlumnoDTO.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textTelefono.setColumns(10);
		textTelefono.setBounds(101, 59, 141, 20);
		panelAlumnoDTO.add(textTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(21, 161, 70, 14);
		panelAlumnoDTO.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);
		textEmail.setBounds(101, 161, 141, 20);
		panelAlumnoDTO.add(textEmail);		
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(21, 93, 70, 14);
		panelAlumnoDTO.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setHorizontalAlignment(SwingConstants.LEFT);
		textFecha.setColumns(10);
		textFecha.setBounds(101, 93, 141, 20);
		panelAlumnoDTO.add(textFecha);
		
		textPresente = new JTextField();
		textPresente.setEnabled(false);
		textPresente.setBounds(101, 195, 44, 20);
		panelAlumnoDTO.add(textPresente);
		textPresente.setColumns(10);
		
		textAusente = new JTextField();
		textAusente.setEnabled(false);
		textAusente.setColumns(10);
		textAusente.setBounds(101, 229, 44, 20);
		panelAlumnoDTO.add(textAusente);
		
		JLabel lblPresente = new JLabel("Presente:");
		lblPresente.setBounds(21, 195, 60, 14);
		panelAlumnoDTO.add(lblPresente);
		
		JLabel lblAusente = new JLabel("Ausente:");
		lblAusente.setBounds(21, 229, 60, 14);
		panelAlumnoDTO.add(lblAusente);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAnterior.setBounds(10, 354, 89, 23);
		panelAlumnoDTO.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSiguiente.setBounds(150, 354, 89, 23);
		panelAlumnoDTO.add(btnSiguiente);
	}

	private void inicializarPanelButtons() {
		
		panelButtons = new JPanel();
		panelButtons.setVisible(false);
		panelButtons.setBounds(292, 120, 245, 84);
		this.add(panelButtons);
		panelButtons.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(108, 46, 153, 30);
		btnAgregar.setVisible(true);
		panelButtons.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(108, 5, 153, 30);
		panelButtons.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Ausentismo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 250, 69);
		add(panel_1);
		
		JLabel lblAusente_1 = new JLabel("Ausente:");
		lblAusente_1.setBounds(113, 40, 61, 14);
		panel_1.add(lblAusente_1);
		
		textAusenteTotal = new JTextField();
		textAusenteTotal.setBounds(184, 40, 56, 20);
		panel_1.add(textAusenteTotal);
		textAusenteTotal.setEnabled(false);
		textAusenteTotal.setColumns(10);
		
		JLabel lblPresente_1 = new JLabel("Presente:");
		lblPresente_1.setBounds(113, 11, 61, 14);
		panel_1.add(lblPresente_1);
		
		textPresenteTotal = new JTextField();
		textPresenteTotal.setBounds(184, 11, 56, 20);
		panel_1.add(textPresenteTotal);
		textPresenteTotal.setEnabled(false);
		textPresenteTotal.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(270, 11, 420, 69);
		add(panel);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Fecha Seleccionada:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		lblFechaCursadaSeleccionada = new JLabel();
		lblFechaCursadaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaCursadaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFechaCursadaSeleccionada.setBounds(125, 14, 186, 43);
		panel.add(lblFechaCursadaSeleccionada);
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

	/**
	 * @return the textPresente
	 */
	public JTextField getTextPresente() {
		return textPresente;
	}

	/**
	 * @param textPresente the textPresente to set
	 */
	public void setTextPresente(JTextField textPresente) {
		this.textPresente = textPresente;
	}

	/**
	 * @return the textAusente
	 */
	public JTextField getTextAusente() {
		return textAusente;
	}

	/**
	 * @param textAusente the textAusente to set
	 */
	public void setTextAusente(JTextField textAusente) {
		this.textAusente = textAusente;
	}

	/**
	 * @return the btnAnterior
	 */
	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	/**
	 * @param btnAnterior the btnAnterior to set
	 */
	public void setBtnAnterior(JButton btnAnterior) {
		this.btnAnterior = btnAnterior;
	}

	/**
	 * @return the btnSiguiente
	 */
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	/**
	 * @param btnSiguiente the btnSiguiente to set
	 */
	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	/**
	 * @return the rbtnGroup
	 */
	public ButtonGroup getRbtnGroup() {
		return rbtnGroup;
	}

	/**
	 * @param rbtnGroup the rbtnGroup to set
	 */
	public void setRbtnGroup(ButtonGroup rbtnGroup) {
		this.rbtnGroup = rbtnGroup;
	}

	/**
	 * @return the rbtnPresente
	 */
	public JRadioButton getRbtnPresente() {
		return rbtnPresente;
	}

	/**
	 * @param rbtnPresente the rbtnPresente to set
	 */
	public void setRbtnPresente(JRadioButton rbtnPresente) {
		this.rbtnPresente = rbtnPresente;
	}

	/**
	 * @return the rbtnAusente
	 */
	public JRadioButton getRbtnAusente() {
		return rbtnAusente;
	}

	/**
	 * @param rbtnAusente the rbtnAusente to set
	 */
	public void setRbtnAusente(JRadioButton rbtnAusente) {
		this.rbtnAusente = rbtnAusente;
	}

	/**
	 * @return the textPresenteTotal
	 */
	public JTextField getTextPresenteTotal() {
		return textPresenteTotal;
	}

	/**
	 * @param textPresenteTotal the textPresenteTotal to set
	 */
	public void setTextPresenteTotal(JTextField textPresenteTotal) {
		this.textPresenteTotal = textPresenteTotal;
	}

	/**
	 * @return the textAusenteTotal
	 */
	public JTextField getTextAusenteTotal() {
		return textAusenteTotal;
	}

	/**
	 * @param textAusenteTotal the textAusenteTotal to set
	 */
	public void setTextAusenteTotal(JTextField textAusenteTotal) {
		this.textAusenteTotal = textAusenteTotal;
	}

	/**
	 * @return the lblFechaCursadaSeleccionada
	 */
	public JLabel getLblFechaCursadaSeleccionada() {
		return lblFechaCursadaSeleccionada;
	}

	/**
	 * @param lblFechaCursadaSeleccionada the lblFechaCursadaSeleccionada to set
	 */
	public void setLblFechaCursadaSeleccionada(JLabel lblFechaCursadaSeleccionada) {
		this.lblFechaCursadaSeleccionada = lblFechaCursadaSeleccionada;
	}
}
