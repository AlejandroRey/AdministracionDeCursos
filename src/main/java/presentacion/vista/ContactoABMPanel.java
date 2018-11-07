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
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dto.CursoDTO;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ContactoABMPanel extends JPanel {
		private JScrollPane spContactos;
		private DefaultTableModel modelContactos;
		private JTable tblContactos;
		private String[] nombreColumnas = {"idContacto", "idCurso", "idAlumno", "Nombre", "Apellido", "Descripcion", "Telefono", "Email", "Fecha de contacto", "Próximo contacto"};
		
		private JPanel panel;
		private JButton btnActualizar;
		private JButton btnEliminar;
		private JButton btnSeleccionar;
		private JButton btnAgregar;
		private JButton btnAgregarYTareas;
		private JTextField nombreField;
		private JTextField ApellidoField;
		private JTextField telefonoField;
		private JTextField emailField;
		private JTextField proximoContactoField;
		private JTextArea descripcionField;
		private JLabel lblFechaCreacion;
		private JTextField fechaInteraccionField;
		private JLabel lblCursoDeInteres;
		private JComboBox<CursoDTO> comboBoxCursoDeInteres;

		/**
		 * Create the frame.
		 */
		public ContactoABMPanel() {
			super();
			this.setBounds(0, 0, 658, 656);
			this.setLayout(null);
			inicializar();
		}

		private void inicializar() {
			
			inicializarTabla();
			inicializarEditor();
			
		}

		private void inicializarTabla() {
			//JLabel lblFiltro = new JLabel("Filtro:");
			//lblFiltro.setBounds(4, 14, 46, 14);
			//this.add(lblFiltro);
			
			/*cbxCategoriaFiltro = new JComboBox<>();
			cbxCategoriaFiltro.setBounds(48, 11, 141, 20);
			this.add(cbxCategoriaFiltro);*/
			
			spContactos = new JScrollPane();
			spContactos.setBounds(4, 53, 644, 339);
			this.add(spContactos);
			
			modelContactos = new DefaultTableModel(null, nombreColumnas);
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
			tblContactos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			//tblusuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
			spContactos.setViewportView(tblContactos);		
		}

		private void inicializarEditor() {		
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Contacto:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
			panel.setBounds(4, 403, 644, 242);
			this.add(panel);
			panel.setLayout(null);
			
			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(353, 202, 89, 23);
			panel.add(btnAgregar);
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setBounds(353, 202, 89, 23);
			panel.add(btnActualizar);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnEliminar.setBounds(353, 202, 89, 23);
			panel.add(btnEliminar);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.setBounds(353, 202, 89, 23);
			panel.add(btnSeleccionar);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 26, 46, 14);
			panel.add(lblNombre);
			
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(10, 51, 46, 14);
			panel.add(lblApellido);
			
			JLabel lblTelefono = new JLabel("Teléfono");
			lblTelefono.setBounds(353, 26, 77, 14);
			panel.add(lblTelefono);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(353, 51, 57, 14);
			panel.add(lblEmail);
			
			JLabel lblFechaDePrximo = new JLabel("Fecha de próximo contacto");
			lblFechaDePrximo.setBounds(10, 177, 161, 14);
			panel.add(lblFechaDePrximo);
			
			JLabel lblDescripcion = new JLabel("Descripción");
			lblDescripcion.setBounds(10, 76, 77, 14);
			panel.add(lblDescripcion);
			
			nombreField = new JTextField();
			nombreField.setBounds(98, 23, 211, 20);
			panel.add(nombreField);
			nombreField.setColumns(10);
			
			ApellidoField = new JTextField();
			ApellidoField.setBounds(98, 48, 211, 20);
			panel.add(ApellidoField);
			ApellidoField.setColumns(10);
			
			telefonoField = new JTextField();
			telefonoField.setBounds(463, 23, 171, 20);
			panel.add(telefonoField);
			telefonoField.setColumns(10);
			
			emailField = new JTextField();
			emailField.setBounds(463, 48, 171, 20);
			panel.add(emailField);
			emailField.setColumns(10);
			
			proximoContactoField = new JTextField();
			proximoContactoField.setBounds(158, 174, 151, 20);
			panel.add(proximoContactoField);
			proximoContactoField.setColumns(10);
			
			descripcionField = new JTextArea();
			descripcionField.setBounds(10, 95, 624, 68);
			panel.add(descripcionField);
			descripcionField.setColumns(10);
			
			lblFechaCreacion = new JLabel("Fecha de interacción");
			lblFechaCreacion.setBounds(353, 177, 129, 14);
			panel.add(lblFechaCreacion);
			
			fechaInteraccionField = new JTextField();
			fechaInteraccionField.setBounds(492, 174, 142, 20);
			panel.add(fechaInteraccionField);
			fechaInteraccionField.setColumns(10);
			
			lblCursoDeInteres = new JLabel("Curso de interes:");
			lblCursoDeInteres.setBounds(10, 206, 123, 14);
			panel.add(lblCursoDeInteres);
			
			comboBoxCursoDeInteres = new JComboBox<CursoDTO>();
			comboBoxCursoDeInteres.setBounds(156, 203, 153, 20);
			panel.add(comboBoxCursoDeInteres);
			
			btnAgregarYTareas = new JButton("Agregar y generar tarea");
			btnAgregarYTareas.setBounds(463, 202, 171, 23);
			panel.add(btnAgregarYTareas);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(SystemColor.activeCaption);
			separator.setBackground(SystemColor.activeCaption);
			separator.setBounds(13, 395, 560, 1);
			this.add(separator);
		}

		
		/**
		 * @return the cbxCategoriaFiltro
		 */
		//public JComboBox<CategoriaDTO> getCbxCategoriaFiltro() {
		//	return cbxCategoriaFiltro;
		//}

		/**
		 * @param cbxCategoriaFiltro the cbxCategoriaFiltro to set
		 */
		//public void setCbxCategoriaFiltro(JComboBox<CategoriaDTO> cbxCategoriaFiltro) {
		//	this.cbxCategoriaFiltro = cbxCategoriaFiltro;
		//}

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

		public JTextField getNombreField() {
			return nombreField;
		}

		public JTextField getApellidoField() {
			return ApellidoField;
		}

		public JTextField getTelefonoField() {
			return telefonoField;
		}

		public JTextField getEmailField() {
			return emailField;
		}

		public JTextField getProximoContactoField() {
			return proximoContactoField;
		}

		public JTextArea getDescripcionField() {
			return descripcionField;
		}

		public JTextField getFechaInteraccionField() {
			return fechaInteraccionField;
		}

		public JComboBox<CursoDTO> getComboBoxCursoDeInteres() {
			return comboBoxCursoDeInteres;
		}

		public void setComboBoxCursoDeInteres(JComboBox<CursoDTO> comboBoxCursoDeInteres) {
			this.comboBoxCursoDeInteres = comboBoxCursoDeInteres;
		}

		public JButton getBtnAgregarYTareas() {
			return btnAgregarYTareas;
		}

		public void setBtnAgregarYTareas(JButton btnAgregarYTareas) {
			this.btnAgregarYTareas = btnAgregarYTareas;
		}
}
