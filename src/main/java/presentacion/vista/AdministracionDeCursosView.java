package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexion.Conexion;

public class AdministracionDeCursosView {

	private JFrame frame;
	private JButton btnLlenarTabla;
	private JPanel panel;
	private JScrollPane spInstructores;
	private DefaultTableModel modelInstructores;
	private JTable tablaInstructores;
	private String[] nombreColumnas = { "IdInstructor", "IdUsuario", "IdCursoTipo", "Nombre", "Apellido", "Telefono",
			"Email", "Actualizar", "Eliminar" };

	public AdministracionDeCursosView() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 1064, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		spInstructores = new JScrollPane();
		spInstructores.setBounds(10, 11, 1044, 182);
		panel.add(spInstructores);

		modelInstructores = new DefaultTableModel(null, nombreColumnas);
		tablaInstructores = new JTable(modelInstructores);

		tablaInstructores.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaInstructores.getColumnModel().getColumn(0).setResizable(false);
		tablaInstructores.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaInstructores.getColumnModel().getColumn(1).setResizable(false);

		spInstructores.setViewportView(tablaInstructores);

		btnLlenarTabla = new JButton("Llenar Tabla");
		btnLlenarTabla.setBounds(447, 214, 171, 23);
		panel.add(btnLlenarTabla);
	}

	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Agenda!?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	/**
	 * @return the btnLlenarTabla
	 */
	public JButton getBtnLlenarTabla() {
		return btnLlenarTabla;
	}

	/**
	 * @param btnLlenarTabla the btnLlenarTabla to set
	 */
	public void setBtnLlenarTabla(JButton btnLlenarTabla) {
		this.btnLlenarTabla = btnLlenarTabla;
	}

	/**
	 * @return the modelInstructores
	 */
	public DefaultTableModel getModelInstructores() {
		return modelInstructores;
	}

	/**
	 * @param modelInstructores the modelInstructores to set
	 */
	public void setModelInstructores(DefaultTableModel modelInstructores) {
		this.modelInstructores = modelInstructores;
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
	 * @return the tablaInstructores
	 */
	public JTable getTablaInstructores() {
		return tablaInstructores;
	}

	/**
	 * @param tablaInstructores the tablaInstructores to set
	 */
	public void setTablaInstructores(JTable tablaInstructores) {
		this.tablaInstructores = tablaInstructores;
	}

}
