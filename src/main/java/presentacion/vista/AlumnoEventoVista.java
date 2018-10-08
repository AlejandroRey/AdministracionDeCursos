package presentacion.vista;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dto.CursoTipoDTO;
import persistencia.conexion.Conexion;
import persistencia.controlador.AlumnoEventoControlador;

import javax.swing.JComboBox;

public class AlumnoEventoVista {

	private AlumnoEventoControlador controlador;
	
	private JFrame frmTarea;
	
	private JLabel lblDescripcion;
	private JLabel lblEstado;
	private JLabel lblFechaAContactar;
	private JLabel lblCurso;
	private JLabel lblAlumno;
	private JLabel lblRegistrarTarea;
	
	private JTextField textField_idAlumno;
	private JTextField textField_fechaContactar;
	private JTextField textField_idEstado;
	private JTextField textField_descripcion;
	
	private JComboBox<CursoTipoDTO> comboBox_Cursos;
	
	private JButton btnGuardar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoEventoVista window = new AlumnoEventoVista();
					window.frmTarea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AlumnoEventoVista() {
		super();
		inicializar();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void inicializar() {
		frmTarea = new JFrame();
		frmTarea.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmTarea.setTitle("Tarea");
		frmTarea.setBounds(100, 100, 521, 321);
		frmTarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTarea.getContentPane().setLayout(null);
		inicializarContenido();
	}
	
	private void inicializarContenido() {
		
		lblAlumno = new JLabel("Alumno:");
		lblAlumno.setBounds(25, 45, 46, 14);
		frmTarea.getContentPane().add(lblAlumno);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(25, 105, 46, 14);
		frmTarea.getContentPane().add(lblCurso);
		
		lblFechaAContactar = new JLabel("Fecha a contactar:");
		lblFechaAContactar.setBounds(301, 45, 112, 14);
		frmTarea.getContentPane().add(lblFechaAContactar);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(25, 73, 46, 14);
		frmTarea.getContentPane().add(lblEstado);
		
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(25, 133, 73, 14);
		frmTarea.getContentPane().add(lblDescripcion);
		
		textField_idAlumno = new JTextField();
		textField_idAlumno.setBounds(81, 42, 142, 20);
		frmTarea.getContentPane().add(textField_idAlumno);
		textField_idAlumno.setColumns(10);
		
		/*calendario = new JCalendar();
		calendario.setBounds(246, 42, 248, 119);
		frmTarea.getContentPane().add(calendario);*/
		
		
		
		textField_idEstado = new JTextField();
		textField_idEstado.setBounds(81, 70, 142, 20);
		frmTarea.getContentPane().add(textField_idEstado);
		textField_idEstado.setColumns(10);
		
		textField_descripcion = new JTextField();
		textField_descripcion.setBounds(25, 155, 469, 81);
		frmTarea.getContentPane().add(textField_descripcion);
		textField_descripcion.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(390, 247, 89, 23);
		frmTarea.getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(276, 247, 89, 23);
		frmTarea.getContentPane().add(btnCancelar);
		
		lblRegistrarTarea = new JLabel("Registrar tarea");
		lblRegistrarTarea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrarTarea.setBounds(204, 11, 119, 23);
		frmTarea.getContentPane().add(lblRegistrarTarea);
		
		textField_fechaContactar = new JTextField();
		textField_fechaContactar.setBounds(276, 70, 146, 20);
		frmTarea.getContentPane().add(textField_fechaContactar);
		textField_fechaContactar.setColumns(10);
		
		comboBox_Cursos = new JComboBox<CursoTipoDTO>();
		comboBox_Cursos.setBounds(81, 102, 142, 20);
		frmTarea.getContentPane().add(comboBox_Cursos);
		
	}
	
	public void show() {
		this.frmTarea.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmTarea.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Aplicacion!?",
				//		"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				//if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				//}
			}
		});
		this.frmTarea.setVisible(true);
	}
	
	public JTextField getTextField_idAlumno() {
		return textField_idAlumno;
	}
	public JTextField getTextField_fechaContactar() {
		return textField_fechaContactar;
	}
	public JTextField getTextField_idEstado() {
		return textField_idEstado;
	}
	public JTextField getTextField_descripcion() {
		return textField_descripcion;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JComboBox<CursoTipoDTO> getComboBox_Cursos() {
		return comboBox_Cursos;
	}
}
