package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import persistencia.conexion.Conexion;
import javax.swing.border.TitledBorder;

public class CursadaCrudVista {
	
	private JFrame frame;
	private JTable cursadasTable;
	private DefaultTableModel modelCursadasGeneradas;
	private JTable tablaCursadasGeneradas;
	private String[] columnasCursadasGeneradas = { "Cursada", "Empresa", "Curso", "Instructor", "Sala", "Estado de Curso", "Vacantes"};
	private JTextField txtCantidadDeVacantes;
	private JLabel lblEmpresa;
	private JLabel lblEstadoCurso;
	private Component lblInstructor;
	private JLabel lblSala;
	private JLabel lblCurso;
	private JComboBox cmBoxCurso; //Falta DTO
	private JComboBox cmBoxSala; //Falta DTO
	private JComboBox cmBoxInstructor; //Falta DTO
	private JComboBox cmBoxEstadoDeCurso; //Falta DTO
	private JComboBox cmBoxEmpresa; //Falta DTO
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblCantidadDeVacantes;
	private JScrollPane scrollCursadas_GeneradasPane;
	private JPanel cursadaPanel;

	/**
	 * Create the frame.
	 */
	public CursadaCrudVista() {
		inicialize();
	}

	private void inicialize() {
		inicializeFrame();
		inicializePanel();
		inicializeLbl();
		inicializeCmBox();
		inicializeBtn();
		inicializeTxt();
		inicializeTables();
	}

	private void inicializeFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1152, 631);
		frame.getContentPane().setLayout(null);
	}

	private void inicializePanel() {
		cursadaPanel = new JPanel();
		cursadaPanel.setBorder(new TitledBorder(null, "Cursada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cursadaPanel.setBounds(10, 11, 258, 513);
		frame.getContentPane().add(cursadaPanel);
		cursadaPanel.setLayout(null);
	}

	private void inicializeBtn() {
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(22, 417, 98, 23);
		cursadaPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(137, 417, 98, 23);
		cursadaPanel.add(btnCancelar);
	}

	private void inicializeCmBox() {
		cmBoxCurso = new JComboBox();
		cmBoxCurso.setBounds(109, 73, 139, 26);
		cursadaPanel.add(cmBoxCurso);
		
		cmBoxSala = new JComboBox();
		cmBoxSala.setBounds(109, 126, 139, 26);
		cursadaPanel.add(cmBoxSala);
		
		cmBoxInstructor = new JComboBox();
		cmBoxInstructor.setBounds(110, 176, 138, 26);
		cursadaPanel.add(cmBoxInstructor);
		
		cmBoxEstadoDeCurso = new JComboBox();
		cmBoxEstadoDeCurso.setBounds(109, 234, 139, 26);
		cursadaPanel.add(cmBoxEstadoDeCurso);
		
		cmBoxEmpresa = new JComboBox();
		cmBoxEmpresa.setBounds(109, 296, 139, 26);
		cursadaPanel.add(cmBoxEmpresa);
	}

	private void inicializeLbl() {
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 74, 46, 14);
		cursadaPanel.add(lblCurso);
		
		lblSala = new JLabel("Sala:");
		lblSala.setBounds(10, 127, 46, 14);
		cursadaPanel.add(lblSala);
		
		lblInstructor = new JLabel("Instructor:");
		lblInstructor.setBounds(10, 182, 61, 14);
		cursadaPanel.add(lblInstructor);
		
		lblEstadoCurso = new JLabel("Estado de Curso:");
		lblEstadoCurso.setBounds(10, 234, 89, 14);
		cursadaPanel.add(lblEstadoCurso);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 296, 46, 14);
		cursadaPanel.add(lblEmpresa);
		
		lblCantidadDeVacantes = new JLabel("Cantidad de vacantes:");
		lblCantidadDeVacantes.setBounds(10, 361, 120, 14);
		cursadaPanel.add(lblCantidadDeVacantes);
	}

	private void inicializeTxt() {
		txtCantidadDeVacantes = new JTextField();
		txtCantidadDeVacantes.setBounds(149, 358, 86, 20);
		cursadaPanel.add(txtCantidadDeVacantes);
		txtCantidadDeVacantes.setColumns(10);
	}

	private void inicializeTables()	{
		
		scrollCursadas_GeneradasPane = new JScrollPane();
		scrollCursadas_GeneradasPane.setBounds(287, 11, 839, 182);
		frame.getContentPane().add(scrollCursadas_GeneradasPane);
		cursadasTable = new JTable(modelCursadasGeneradas) {
			
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}
		};
		cursadasTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollCursadas_GeneradasPane.setViewportView(cursadasTable);
		
	}
	
	public JComboBox getCmBoxCurso() {
		return this.cmBoxCurso;
	}
	
	public JComboBox getCmBoxInstructor() {
		return this.cmBoxInstructor;
	}
	
	
	public JComboBox getCmBoxSala() {
		return this.cmBoxSala;
	}
	
	public JComboBox getCmBoxEmpresa() {
		return this.cmBoxEmpresa;
	}
	
	
	public JComboBox getCmBoxEstadoDeCurso() {
		return this.cmBoxEstadoDeCurso;
	}
	
	public JTextField getTxtVacantes() {
		return this.txtCantidadDeVacantes;
	}
	
	public JButton BtnAceptar() {
		return btnAceptar;
	}
	
	public JButton BtnCancelar() {
		return btnCancelar;
	}
	
	public DefaultTableModel getModelCursadas() {
		return modelCursadasGeneradas;
	}
	
	public JTable getTablaCursadas() {
		return tablaCursadasGeneradas;
	}

	public String[] getNombreColumnas() {
		return columnasCursadasGeneradas;
	}


}
