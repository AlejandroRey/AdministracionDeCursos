package presentacion.vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class TareaAdministrativosPanel extends JPanel {

	private JScrollPane spAdministrativos;
	private JTable tableAdministrativos;
	private DefaultTableModel modelAdministrativos;
	private TableRowSorter<TableModel> modeloOrdenadoAdministrativos;
	private String[] nombreColumnasAdministrativos = {"Id", "idCategoria", "Categoria", "Nombre", "Apellido", "Telefono", "Email", "Usuario", "Password"};

	/**
	 * Create the panel.
	 */
	public TareaAdministrativosPanel() {
		super();
		inicializarPanel();
		inicializarPanelAdministrativos();
	}
	
	private void inicializarPanel() {
		setBounds(0, 0, 419, 656);
		setLayout(null);
	}
	
	private void inicializarPanelAdministrativos() {
		spAdministrativos = new JScrollPane();
		spAdministrativos.getViewport().setBackground(UIManager.getColor("Panel.background"));
		spAdministrativos.setBounds(10, 10, 396, 641);
		spAdministrativos.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Administrativos:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		this.add(spAdministrativos);
		
		modelAdministrativos = new DefaultTableModel(null, nombreColumnasAdministrativos){public boolean isCellEditable(int row, int column){return false;}};
		tableAdministrativos = new JTable(modelAdministrativos){
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		};
		tableAdministrativos.setOpaque(false);
		tableAdministrativos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		spAdministrativos.setViewportView(tableAdministrativos);
		
		modeloOrdenadoAdministrativos = new TableRowSorter<TableModel>(modelAdministrativos);
		tableAdministrativos.setRowSorter(modeloOrdenadoAdministrativos);
	}

	/**
	 * @return the spAdministrativos
	 */
	public JScrollPane getSpAdministrativos() {
		return spAdministrativos;
	}

	/**
	 * @param spAdministrativos the spAdministrativos to set
	 */
	public void setSpAdministrativos(JScrollPane spAdministrativos) {
		this.spAdministrativos = spAdministrativos;
	}

	/**
	 * @return the tableAdministrativos
	 */
	public JTable getTableAdministrativos() {
		return tableAdministrativos;
	}

	/**
	 * @param tableAdministrativos the tableAdministrativos to set
	 */
	public void setTableAdministrativos(JTable tableAdministrativos) {
		this.tableAdministrativos = tableAdministrativos;
	}

	/**
	 * @return the modelAdministrativos
	 */
	public DefaultTableModel getModelAdministrativos() {
		return modelAdministrativos;
	}

	/**
	 * @param modelAdministrativos the modelAdministrativos to set
	 */
	public void setModelAdministrativos(DefaultTableModel modelAdministrativos) {
		this.modelAdministrativos = modelAdministrativos;
	}

	/**
	 * @return the modeloOrdenadoAdministrativos
	 */
	public TableRowSorter<TableModel> getModeloOrdenadoAdministrativos() {
		return modeloOrdenadoAdministrativos;
	}

	/**
	 * @param modeloOrdenadoAdministrativos the modeloOrdenadoAdministrativos to set
	 */
	public void setModeloOrdenadoAdministrativos(
			TableRowSorter<TableModel> modeloOrdenadoAdministrativos) {
		this.modeloOrdenadoAdministrativos = modeloOrdenadoAdministrativos;
	}

	/**
	 * @return the nombreColumnasAdministrativos
	 */
	public String[] getNombreColumnasAdministrativos() {
		return nombreColumnasAdministrativos;
	}

	/**
	 * @param nombreColumnasAdministrativos the nombreColumnasAdministrativos to set
	 */
	public void setNombreColumnasAdministrativos(
			String[] nombreColumnasAdministrativos) {
		this.nombreColumnasAdministrativos = nombreColumnasAdministrativos;
	}

}
