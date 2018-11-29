package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CursoDTO;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Cursor;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class ContactoABMPanel extends JPanel {
		private JScrollPane spContactos;
		private DefaultTableModel modelContactos;
		private JTable tblContactos;
		private String[] nombreColumnas = {"idContacto", "idAlumno", "idAdministrativo", "idCurso", "Curso de interes", "Nombre", "Apellido", 
				"Descripcion", "Telefono", "Email", "Fecha de contacto", "horaComtacto", "Próximo contacto", "horaProximoContacto",
				"apellidoAdministrativo","nombreAdministrativo","estado", "idTarea"};
		private JPanel panel;
		private JButton btnActualizar;
		private JButton btnEliminar;
		private JButton btnSeleccionar;
		private JButton btnAgregar;
		private JButton btnSeleccionarAlumno;
		private JTextField txtNombre;
		private JTextField txtApellido;
		private JTextField txtTelefono;
		private JTextField txtEmail;
		private JTextField txtProximoContacto;
		private JTextArea txtDescripcion;
		private JLabel lblCursoDeInteres;
		private JComboBox<CursoDTO> comboBoxCursoDeInteres;
		private JScrollPane spDescripcion;
		private JTextField txtIDContacto;
		private JTextField txtIDAlumno;
		private JTextField txtIDAdministrativo;
		private JTextField txtIDTarea;
		private JTextField txtIDCurso;

		/**
		 * Create the frame.
		 */
		public ContactoABMPanel() {
			super();
			setForeground(new Color(0, 0, 0));
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			setBackground(UIManager.getColor("Panel.background"));
			this.setBounds(0, 0, 1065, 656);
			this.setLayout(null);
			inicializar();
		}

		private void inicializar() {
			inicializarTabla();
			inicializarEditor();
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
			
		}

		private void inicializarEditor() {		
			panel = new JPanel();
			panel.setBackground(UIManager.getColor("Panel.background"));
			panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Contacto:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("OptionPane.foreground")));
			panel.setBounds(139, 403, 807, 242);
			this.add(panel);
			panel.setLayout(null);
			
			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(668, 205, 129, 23);
			panel.add(btnAgregar);
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setBounds(668, 205, 129, 23);
			panel.add(btnActualizar);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnEliminar.setBounds(668, 205, 129, 23);
			panel.add(btnEliminar);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.setBounds(668, 205, 129, 23);
			panel.add(btnSeleccionar);
			
			inicializarLabels();
			
			txtNombre = new JTextField();
			txtNombre.setBounds(98, 23, 252, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(98, 48, 252, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(545, 23, 252, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(545, 48, 252, 20);
			panel.add(txtEmail);
			txtEmail.setColumns(10);
			
			txtProximoContacto = new JTextField();
			txtProximoContacto.setBounds(180, 174, 170, 20);
			panel.add(txtProximoContacto);
			txtProximoContacto.setColumns(10);
			
			lblCursoDeInteres = new JLabel("Curso de interes:");
			lblCursoDeInteres.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblCursoDeInteres.setBackground(new Color(255, 255, 255));
			lblCursoDeInteres.setBounds(10, 206, 123, 14);
			panel.add(lblCursoDeInteres);
			
			comboBoxCursoDeInteres = new JComboBox<CursoDTO>();
			comboBoxCursoDeInteres.setBounds(156, 203, 194, 20);
			panel.add(comboBoxCursoDeInteres);
			
			spDescripcion = new JScrollPane();
			spDescripcion.setBounds(10, 95, 787, 68);
			panel.add(spDescripcion);
			
			txtDescripcion = new JTextArea();
			spDescripcion.setViewportView(txtDescripcion);
			txtDescripcion.setColumns(10);
			
			txtIDContacto = new JTextField();
			txtIDContacto.setVisible(false);
			txtIDContacto.setBackground(Color.WHITE);
			txtIDContacto.setDisabledTextColor(Color.DARK_GRAY);
			txtIDContacto.setEnabled(false);
			txtIDContacto.setEditable(false);
			txtIDContacto.setBounds(381, 174, 86, 20);
			panel.add(txtIDContacto);
			txtIDContacto.setColumns(10);
			
			txtIDAlumno = new JTextField();
			txtIDAlumno.setVisible(false);
			txtIDAlumno.setBackground(Color.WHITE);
			txtIDAlumno.setDisabledTextColor(Color.DARK_GRAY);
			txtIDAlumno.setEnabled(false);
			txtIDAlumno.setEditable(false);
			txtIDAlumno.setBounds(478, 174, 86, 20);
			panel.add(txtIDAlumno);
			txtIDAlumno.setColumns(10);
			
			txtIDAdministrativo = new JTextField();
			txtIDAdministrativo.setVisible(false);
			txtIDAdministrativo.setBackground(Color.WHITE);
			txtIDAdministrativo.setDisabledTextColor(Color.DARK_GRAY);
			txtIDAdministrativo.setEnabled(false);
			txtIDAdministrativo.setEditable(false);
			txtIDAdministrativo.setBounds(574, 174, 86, 20);
			panel.add(txtIDAdministrativo);
			txtIDAdministrativo.setColumns(10);
			
			btnSeleccionarAlumno = new JButton("Seleccionar Alumno");
			btnSeleccionarAlumno.setBounds(529, 205, 129, 23);
			panel.add(btnSeleccionarAlumno);
			
			txtIDTarea = new JTextField();
			txtIDTarea.setVisible(false);
			txtIDTarea.setBounds(753, 174, 44, 20);
			panel.add(txtIDTarea);
			txtIDTarea.setColumns(10);
			
			txtIDCurso = new JTextField();
			txtIDCurso.setVisible(false);
			txtIDCurso.setBounds(699, 174, 44, 20);
			panel.add(txtIDCurso);
			txtIDCurso.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(SystemColor.activeCaption);
			separator.setBackground(new Color(153, 180, 209));
			separator.setBounds(132, 394, 826, 2);
			this.add(separator);
		}

		private void inicializarLabels() {
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblNombre.setBackground(new Color(255, 255, 255));
			lblNombre.setBounds(10, 26, 77, 14);
			panel.add(lblNombre);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblApellido.setBackground(new Color(255, 255, 255));
			lblApellido.setBounds(10, 51, 77, 14);
			panel.add(lblApellido);
			
			JLabel lblTelefono = new JLabel("Teléfono:");
			lblTelefono.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblTelefono.setBackground(new Color(255, 255, 255));
			lblTelefono.setBounds(459, 26, 77, 14);
			panel.add(lblTelefono);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblEmail.setBackground(new Color(255, 255, 255));
			lblEmail.setBounds(459, 51, 57, 14);
			panel.add(lblEmail);
			
			JLabel lblFechaDePrximo = new JLabel("Fecha de próximo contacto:");
			lblFechaDePrximo.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblFechaDePrximo.setBackground(new Color(255, 255, 255));
			lblFechaDePrximo.setBounds(10, 177, 161, 14);
			panel.add(lblFechaDePrximo);
			
			JLabel lblDescripcion = new JLabel("Descripción");
			lblDescripcion.setForeground(UIManager.getColor("OptionPane.foreground"));
			lblDescripcion.setBackground(new Color(255, 255, 255));
			lblDescripcion.setBounds(10, 76, 77, 14);
			panel.add(lblDescripcion);
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

		/**
		 * @return the panel
		 */
		public JPanel getPanel() {
			return panel;
		}

		/**
		 * @param panel the panel to set
		 */
		public void setPanel(JPanel panel) {
			this.panel = panel;
		}

		/**
		 * @return the btnAgregar
		 */
		public JButton getBtnAgregar() {
			return btnAgregar;
		}

		/**
		 * @param btnAgregar the btnAgregar to set
		 */
		public void setBtnAgregar(JButton btnAgregar) {
			this.btnAgregar = btnAgregar;
		}

		/**
		 * @return the btnActualizar
		 */
		public JButton getBtnActualizar() {
			return btnActualizar;
		}

		/**
		 * @param btnActualizar the btnActualizar to set
		 */
		public void setBtnActualizar(JButton btnActualizar) {
			this.btnActualizar = btnActualizar;
		}

		/**
		 * @return the btnEliminar
		 */
		public JButton getBtnEliminar() {
			return btnEliminar;
		}

		/**
		 * @param btnEliminar the btnEliminar to set
		 */
		public void setBtnEliminar(JButton btnEliminar) {
			this.btnEliminar = btnEliminar;
		}

		/**
		 * @return the btnSeleccionar
		 */
		public JButton getBtnSeleccionar() {
			return btnSeleccionar;
		}

		/**
		 * @param btnSeleccionar the btnSeleccionar to set
		 */
		public void setBtnSeleccionar(JButton btnSeleccionar) {
			this.btnSeleccionar = btnSeleccionar;
		}

		/**
		 * @return the btnSeleccionarAlumno
		 */
		public JButton getBtnSeleccionarAlumno() {
			return btnSeleccionarAlumno;
		}

		/**
		 * @param btnSeleccionarAlumno the btnSeleccionarAlumno to set
		 */
		public void setBtnSeleccionarAlumno(JButton btnSeleccionarAlumno) {
			this.btnSeleccionarAlumno = btnSeleccionarAlumno;
		}

		/**
		 * @return the txtNombre
		 */
		public JTextField getTxtNombre() {
			return txtNombre;
		}

		/**
		 * @param txtNombre the txtNombre to set
		 */
		public void setTxtNombre(JTextField txtNombre) {
			this.txtNombre = txtNombre;
		}

		/**
		 * @return the txtApellido
		 */
		public JTextField getTxtApellido() {
			return txtApellido;
		}

		/**
		 * @param txtApellido the txtApellido to set
		 */
		public void setTxtApellido(JTextField txtApellido) {
			this.txtApellido = txtApellido;
		}

		/**
		 * @return the txtTelefono
		 */
		public JTextField getTxtTelefono() {
			return txtTelefono;
		}

		/**
		 * @param txtTelefono the txtTelefono to set
		 */
		public void setTxtTelefono(JTextField txtTelefono) {
			this.txtTelefono = txtTelefono;
		}

		/**
		 * @return the txtEmail
		 */
		public JTextField getTxtEmail() {
			return txtEmail;
		}

		/**
		 * @param txtEmail the txtEmail to set
		 */
		public void setTxtEmail(JTextField txtEmail) {
			this.txtEmail = txtEmail;
		}

		/**
		 * @return the txtProximoContacto
		 */
		public JTextField getTxtProximoContacto() {
			return txtProximoContacto;
		}

		/**
		 * @param txtProximoContacto the txtProximoContacto to set
		 */
		public void setTxtProximoContacto(JTextField txtProximoContacto) {
			this.txtProximoContacto = txtProximoContacto;
		}

		/**
		 * @return the txtDescripcion
		 */
		public JTextArea getTxtDescripcion() {
			return txtDescripcion;
		}

		/**
		 * @param txtDescripcion the txtDescripcion to set
		 */
		public void setTxtDescripcion(JTextArea txtDescripcion) {
			this.txtDescripcion = txtDescripcion;
		}

		/**
		 * @return the lblCursoDeInteres
		 */
		public JLabel getLblCursoDeInteres() {
			return lblCursoDeInteres;
		}

		/**
		 * @param lblCursoDeInteres the lblCursoDeInteres to set
		 */
		public void setLblCursoDeInteres(JLabel lblCursoDeInteres) {
			this.lblCursoDeInteres = lblCursoDeInteres;
		}

		/**
		 * @return the comboBoxCursoDeInteres
		 */
		public JComboBox<CursoDTO> getComboBoxCursoDeInteres() {
			return comboBoxCursoDeInteres;
		}

		/**
		 * @param comboBoxCursoDeInteres the comboBoxCursoDeInteres to set
		 */
		public void setComboBoxCursoDeInteres(JComboBox<CursoDTO> comboBoxCursoDeInteres) {
			this.comboBoxCursoDeInteres = comboBoxCursoDeInteres;
		}

		/**
		 * @return the spDescripcion
		 */
		public JScrollPane getSpDescripcion() {
			return spDescripcion;
		}

		/**
		 * @param spDescripcion the spDescripcion to set
		 */
		public void setSpDescripcion(JScrollPane spDescripcion) {
			this.spDescripcion = spDescripcion;
		}

		/**
		 * @return the txtIDContacto
		 */
		public JTextField getTxtIDContacto() {
			return txtIDContacto;
		}

		/**
		 * @param txtIDContacto the txtIDContacto to set
		 */
		public void setTxtIDContacto(JTextField txtIDContacto) {
			this.txtIDContacto = txtIDContacto;
		}

		/**
		 * @return the txtIDAlumno
		 */
		public JTextField getTxtIDAlumno() {
			return txtIDAlumno;
		}

		/**
		 * @param txtIDAlumno the txtIDAlumno to set
		 */
		public void setTxtIDAlumno(JTextField txtIDAlumno) {
			this.txtIDAlumno = txtIDAlumno;
		}

		/**
		 * @return the txtIDAdministrativo
		 */
		public JTextField getTxtIDAdministrativo() {
			return txtIDAdministrativo;
		}

		/**
		 * @param txtIDAdministrativo the txtIDAdministrativo to set
		 */
		public void setTxtIDAdministrativo(JTextField txtIDAdministrativo) {
			this.txtIDAdministrativo = txtIDAdministrativo;
		}

		/**
		 * @return the txtIDTarea
		 */
		public JTextField getTxtIDTarea() {
			return txtIDTarea;
		}

		/**
		 * @param txtIDTarea the txtIDTarea to set
		 */
		public void setTxtIDTarea(JTextField txtIDTarea) {
			this.txtIDTarea = txtIDTarea;
		}

		/**
		 * @return the txtIDCurso
		 */
		public JTextField getTxtIDCurso() {
			return txtIDCurso;
		}

		/**
		 * @param txtIDCurso the txtIDCurso to set
		 */
		public void setTxtIDCurso(JTextField txtIDCurso) {
			this.txtIDCurso = txtIDCurso;
		}

}
