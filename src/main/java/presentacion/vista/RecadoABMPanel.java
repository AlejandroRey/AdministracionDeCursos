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
	private JTable tblCursos;
	private String[] nombreColumnas = {"idRecado","idUsuarioDe", "idUsuarioPara", "asunto", "Mensaje", "Enviado", "Visto", "Eliminado"};
	private JButton btnEliminar_1;
	private JButton btnVer;
	private JLabel lblTitulo;

	/**
	 * Create the Panel.
	 */
	public RecadoABMPanel(String titulo) {
		super();
		this.setBounds(0, 0, 534, 427);
		this.setLayout(null);
		inicializar(titulo);
	}

	private void inicializar(String titulo) {
		
		inicializarTabla();
		inicializarEditor(titulo);
		
	}

	private void inicializarTabla() {
		
		spRecados = new JScrollPane();
		spRecados.setBounds(15, 49, 500, 300);
		this.add(spRecados);
		
		modelRecados = new DefaultTableModel(null, nombreColumnas);
		tblCursos = new JTable(modelRecados){
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
		spRecados.setViewportView(tblCursos);
	}

	private void inicializarEditor(String titulo) {
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(15, 365, 500, 1);
		this.add(separator);
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(400, 382, 115, 29);
		add(btnEliminar_1);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVer.setBounds(15, 382, 115, 29);
		add(btnVer);
		
		lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(171, 13, 148, 20);
		add(lblTitulo);
		
	}

	/**
	 * @return the spCursos
	 */
	public JScrollPane getSpCursos() {
		return spRecados;
	}

	/**
	 * @param spCursos the spCursos to set
	 */
	public void setSpCursos(JScrollPane spCursos) {
		this.spRecados = spCursos;
	}

	/**
	 * @return the modelCursos
	 */
	public DefaultTableModel getModelCursos() {
		return modelRecados;
	}

	/**
	 * @param modelCursos the modelCursos to set
	 */
	public void setModelCursos(DefaultTableModel modelCursos) {
		this.modelRecados = modelCursos;
	}

	/**
	 * @return the tblCursos
	 */
	public JTable getTblCursos() {
		return tblCursos;
	}

	/**
	 * @param tblCursos the tblCursos to set
	 */
	public void setTblCursos(JTable tblCursos) {
		this.tblCursos = tblCursos;
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
