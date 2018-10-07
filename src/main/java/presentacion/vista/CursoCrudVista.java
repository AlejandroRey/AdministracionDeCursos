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

public class CursoCrudVista {
	
	private JFrame frame;

	private JScrollPane spCursos;
	private DefaultTableModel modelCursos;
	private JTable tblCursos;
	private String[] nombreColumnas = {"idCurso","idCursoTipo", "Tipo", "Nombre", "Tema", "Temario"};
	
	private JPanel panel;
	
	private JTextField textIdCurso;
	private JComboBox<CursoTipoDTO> cbxCursoTipo;
	private JTextField textNombre;
	private JTextField textTema;
	private JTextField textTemario;
	
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCerrar;

	/**
	 * Create the frame.
	 */
	public CursoCrudVista() {
		super();
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		inicializarTabla();
		inicializarEditor();		
	}

	@SuppressWarnings("serial")
	private void inicializarTabla() {
		
		spCursos = new JScrollPane();
		spCursos.setBounds(4, 4, 576, 310);
		frame.getContentPane().add(spCursos);
		
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
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Curso - Editor:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(32, 330, 500, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdCurso = new JLabel("id Curso:");
		lblIdCurso.setVisible(false);
		lblIdCurso.setBounds(21, 88, 70, 14);
		panel.add(lblIdCurso);
		
		textIdCurso = new JTextField();
		textIdCurso.setBounds(96, 88, 70, 17);
		textIdCurso.setVisible(false);
		textIdCurso.setEnabled(false);
		panel.add(textIdCurso);
		textIdCurso.setColumns(10);
		
		JLabel lblIdCursoTipo = new JLabel("Id Curso Tipo:");
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
		textTema.setBounds(97, 55, 140, 35);
		panel.add(textTema);
		
		JLabel lblTemario = new JLabel("Temario:");
		lblTemario.setBounds(258, 55, 70, 14);
		panel.add(lblTemario);
		
		textTemario = new JTextField();
		textTemario.setHorizontalAlignment(SwingConstants.LEFT);
		textTemario.setColumns(10);
		textTemario.setBounds(334, 52, 141, 38);
		panel.add(textTemario);		
		
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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JScrollPane getSpCursos() {
		return spCursos;
	}

	public void setSpCursos(JScrollPane spCursos) {
		this.spCursos = spCursos;
	}

	public DefaultTableModel getModelCursos() {
		return modelCursos;
	}

	public void setModelCursos(DefaultTableModel modelCursos) {
		this.modelCursos = modelCursos;
	}

	public JTable getTblCursos() {
		return tblCursos;
	}

	public void setTblCursos(JTable tblCursos) {
		this.tblCursos = tblCursos;
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

	public JTextField getTextIdCurso() {
		return textIdCurso;
	}

	public void setTextIdCurso(JTextField textIdCurso) {
		this.textIdCurso = textIdCurso;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextTema() {
		return textTema;
	}

	public void setTextTema(JTextField textTema) {
		this.textTema = textTema;
	}

	public JTextField getTextTemario() {
		return textTemario;
	}

	public void setTextTemario(JTextField textTemario) {
		this.textTemario = textTemario;
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

	public JComboBox<CursoTipoDTO> getCbxCursoTipo() {
		return cbxCursoTipo;
	}

	public void setCbxCursoTipo(JComboBox<CursoTipoDTO> cbxCursoTipo) {
		this.cbxCursoTipo = cbxCursoTipo;
	}

}
