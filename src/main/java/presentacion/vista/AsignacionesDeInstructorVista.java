package presentacion.vista;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class AsignacionesDeInstructorVista {

	private JFrame frmCursadasAsignadas;
	private JScrollPane spAsignaciones;
	private DefaultTableModel modelAsignaciones;
	private JTable tblAsignaciones;
	private String[] nombreColumnasAsignaciones = {"Nombre", "Tema", "Estado", "Fecha de inicio"};

	/**
	 * Create the application.
	 */
	public AsignacionesDeInstructorVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCursadasAsignadas = new JFrame();
		frmCursadasAsignadas.setTitle("Cursadas Asignadas");
		frmCursadasAsignadas.setBounds(100, 100, 517, 429);
		frmCursadasAsignadas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCursadasAsignadas.setVisible(true);
		
		spAsignaciones = new JScrollPane();
		spAsignaciones.setBounds(602, 53, 337, 339);
		frmCursadasAsignadas.getContentPane().add(spAsignaciones);
		
		modelAsignaciones = new DefaultTableModel(null, nombreColumnasAsignaciones);
		tblAsignaciones = new JTable(modelAsignaciones){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblAsignaciones.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblusuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spAsignaciones.setViewportView(tblAsignaciones);
	}

	public JFrame getFrame() {
		return frmCursadasAsignadas;
	}

	public void setFrame(JFrame frame) {
		this.frmCursadasAsignadas = frame;
	}

	public JScrollPane getSpAsignaciones() {
		return spAsignaciones;
	}

	public void setSpAsignaciones(JScrollPane spAsignaciones) {
		this.spAsignaciones = spAsignaciones;
	}

	public DefaultTableModel getModelAsignaciones() {
		return modelAsignaciones;
	}

	public void setModelAsignaciones(DefaultTableModel modelAsignaciones) {
		this.modelAsignaciones = modelAsignaciones;
	}

	public JTable getTblAsignaciones() {
		return tblAsignaciones;
	}

	public void setTblAsignaciones(JTable tblAsignaciones) {
		this.tblAsignaciones = tblAsignaciones;
	}

	public String[] getNombreColumnasAsignaciones() {
		return nombreColumnasAsignaciones;
	}

	public void setNombreColumnasAsignaciones(String[] nombreColumnasAsignaciones) {
		this.nombreColumnasAsignaciones = nombreColumnasAsignaciones;
	}

}
