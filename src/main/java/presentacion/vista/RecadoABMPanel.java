package presentacion.vista;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	private String[] nombreColumnas = {"idRecado","De", "Para", "Asunto", "Mensaje", "Enviado", "Visto", "Eliminado", "Fecha y Hora"};
	private JButton btnEliminar_1;
	private JButton btnVer;
	private JButton btnRestaurar;
	
	private JLabel lblTitulo;

	/**
	 * Create the Panel.
	 */
	public RecadoABMPanel(String titulo) {
		super();
		this.setBounds(0, 0, 1088, 717);
		this.setLayout(null);
		inicializar(titulo);
	}

	private void inicializar(String titulo) {
		
		inicializarTabla();
		inicializarEditor(titulo);
		
	}

	private void inicializarTabla() {
		
		spRecados = new JScrollPane();
		spRecados.setBounds(15, 49, 1054, 601);
		this.add(spRecados);
		
		modelRecados = new DefaultTableModel(null, nombreColumnas);
		tblRecados = new JTable(modelRecados){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);	
		           boolean status = (boolean) getValueAt(row, 6);
	                if (!status) {
	                	component.setFont(new Font("Tahoma", Font.BOLD, 14));
	                } else {
	                	component.setBackground(super.getBackground());
	                	component.setForeground(super.getForeground());
	                }
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblRecados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblRecados.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);	
		spRecados.setViewportView(tblRecados);
	}

	private void inicializarEditor(String titulo) {
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(15, 666, 115, 35);
		add(btnEliminar_1);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVer.setBounds(954, 666, 115, 35);
		add(btnVer);
		
		lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(450, 16, 148, 20);
		add(lblTitulo);

		btnRestaurar = new JButton("Restaurar");
		btnRestaurar.setBounds(824, 666, 115, 35);
		add(btnRestaurar);
		
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
	
	public JButton getBtnRestaurar() {
		return btnRestaurar;
	}

	public void setBtnRestaurar(JButton btnRestaurar) {
		this.btnRestaurar = btnRestaurar;
	}
	
	public void setBtnRestaurarVisible(boolean visible) {
		this.btnRestaurar.setVisible(visible);
	}
}