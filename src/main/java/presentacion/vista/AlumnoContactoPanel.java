package presentacion.vista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.SystemColor;
 
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
 
@SuppressWarnings("serial")
public class AlumnoContactoPanel extends JPanel{
	private JScrollPane spContactos;
	private DefaultTableModel modelContactos;
	private JTable tblContactos;
	private String[] nombreColumnas = {"idContacto", "idAlumno", "idAdministrativo", "idCurso", "Curso de interes", "Nombre", "Apellido", 
			"Descripcion", "Telefono", "Email", "Fecha de contacto", "horaComtacto", "Próximo contacto", "horaProximoContacto",
			"apellidoAdministrativo","nombreAdministrativo","estado", "idTarea"};
	private JPanel panel;
	private JScrollPane scrollPaneDetalle;
	private JTextPane textDetalle;
	
	public AlumnoContactoPanel() {
		super();
		setForeground(UIManager.getColor("Panel.background"));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(UIManager.getColor("Panel.background"));
		this.setBounds(0, 0, 1065, 656);
		this.setLayout(null);
		inicializar();
	}
 	private void inicializar() {
		inicializarTabla();
	}
 	private void inicializarTabla() {
		modelContactos = new DefaultTableModel(null, nombreColumnas){public boolean isCellEditable(int row, int column){return false;}};
		tblContactos = new JTable(modelContactos){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblContactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblContactos.setOpaque(false);
		tblContactos.getTableHeader().setBackground(new Color(230,230, 230));
		tblContactos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		spContactos = new JScrollPane(tblContactos);
		spContactos.getViewport().setBackground(UIManager.getColor("Panel.background")); 
		spContactos.setBounds(129, 25, 829, 358);
		this.add(spContactos);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(new Color(153, 180, 209));
		separator.setBounds(132, 394, 826, 2);
		this.add(separator);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(127, 409, 831, 236);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPaneDetalle = new JScrollPane();
		panel.add(scrollPaneDetalle, BorderLayout.CENTER);
		
		textDetalle = new JTextPane();
		textDetalle.setDisabledTextColor(Color.WHITE);
		textDetalle.setEditable(false);
		scrollPaneDetalle.setViewportView(textDetalle);
	}
 	/**
	 * @return the spContactos
	 */
	public JScrollPane getSpContactos() {
		return spContactos;
	}
 	/**
	 * @param spContactos the spContactos to set
	 */
	public void setSpContactos(JScrollPane spContactos) {
		this.spContactos = spContactos;
	}
 	/**
	 * @return the modelContactos
	 */
	public DefaultTableModel getModelContactos() {
		return modelContactos;
	}
 	/**
	 * @param modelContactos the modelContactos to set
	 */
	public void setModelContactos(DefaultTableModel modelContactos) {
		this.modelContactos = modelContactos;
	}
 	/**
	 * @return the tblContactos
	 */
	public JTable getTblContactos() {
		return tblContactos;
	}
 	/**
	 * @param tblContactos the tblContactos to set
	 */
	public void setTblContactos(JTable tblContactos) {
		this.tblContactos = tblContactos;
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
	
	public JScrollPane getScrollPaneDetalle() {
		return scrollPaneDetalle;
	}
	
	public void setScrollPaneDetalle(JScrollPane scrollPaneDetalle) {
		this.scrollPaneDetalle = scrollPaneDetalle;
	}
	
	public JTextPane getTextDetalle() {
		return textDetalle;
	}
	
	public void setTextDetalle(JTextPane textDetalle) {
		this.textDetalle = textDetalle;
	}
}
