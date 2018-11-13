package presentacion.vista;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class RecadoABMPanel extends JPanel{

	private JScrollPane spRecados;
	private DefaultTableModel modelRecados;
	private JTable tblRecados;
	private String[] nombreColumnas = {"idRecado","idUsuarioDe", "idUsuarioPara", "asunto", "Mensaje", "Enviado", "Visto", "Eliminado"};
	private JButton btnEliminar_1;
	private JButton btnVer;
	private JLabel lblTitulo;

	/**
	 * Create the Panel.
	 */
	public RecadoABMPanel(String titulo) {
		super();
		this.setBounds(0, 0, 742, 708);
		this.setLayout(null);
		inicializar(titulo);
	}

	private void inicializar(String titulo) {
		
		inicializarTabla();
		inicializarEditor(titulo);
		
	}

	private void inicializarTabla() {
		
		spRecados = new JScrollPane();
		spRecados.setBounds(15, 49, 712, 581);
		this.add(spRecados);
		
		modelRecados = new DefaultTableModel(null, nombreColumnas);
		tblRecados = new JTable(modelRecados){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblRecados.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);	
		spRecados.setViewportView(tblRecados);
	}

	private void inicializarEditor(String titulo) {
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.darkGray);
		separator.setBackground(SystemColor.DARK_GRAY);
		separator.setBounds(15, 646, 712, 1);
		add(separator);
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(15, 663, 115, 29);
		add(btnEliminar_1);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVer.setBounds(612, 663, 115, 29);
		add(btnVer);
		
		lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(289, 13, 148, 20);
		add(lblTitulo);
		
	}

	public JScrollPane getSpRecados() {
		return spRecados;
	}

	public void setSpRecados(JScrollPane spRecados) {
		this.spRecados = spRecados;
	}

	public DefaultTableModel getModelRecados() {
		return modelRecados;
	}

	public void setModelRecados(DefaultTableModel modelRecados) {
		this.modelRecados = modelRecados;
	}

	public JTable getTblRecados() {
		return tblRecados;
	}

	public void setTblRecados(JTable tblRecados) {
		this.tblRecados = tblRecados;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JButton getBtnEliminar() {
		return btnEliminar_1;
	}

	public void setBtnEliminar(JButton btnEliminar_1) {
		this.btnEliminar_1 = btnEliminar_1;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}
	
	
}
