package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class ContactoAlumnoPanel extends JPanel {
		private JScrollPane spAlumnos;
		private DefaultTableModel modelAlumnos;
		private JTable tblAlumnos;
		private String[] nombreColumnas = {"idAlumno", "Nombre", "Apellido", "Telefono", "Email"};
		
		private JPanel panel;
		
		private JTextField textIdAlumno;
		private JLabel lblAlumno;

		/**
		 * Create the panel.
		 */
		public ContactoAlumnoPanel() {
			super();
			this.setBounds(0, 0, 584, 449);
			this.setLayout(null);
			inicializar();
		}

		private void inicializar() {
			
			inicializarTabla();
			inicializarEditor();
		}

		private void inicializarTabla() {
			
			spAlumnos = new JScrollPane();
			spAlumnos.setBounds(4, 4, 576, 310);
			this.add(spAlumnos);
			
			modelAlumnos = new DefaultTableModel(null, nombreColumnas);
			tblAlumnos = new JTable(modelAlumnos){
				@Override
			       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			           Component component = super.prepareRenderer(renderer, row, column);
			           int rendererWidth = component.getPreferredSize().width;
			           TableColumn tableColumn = getColumnModel().getColumn(column);
			           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
			           return component;
			        }
			    };
			tblAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			//tblInstructores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
			spAlumnos.setViewportView(tblAlumnos);	
			
			JSeparator separator = new JSeparator();
			separator.setForeground(SystemColor.activeCaption);
			separator.setBackground(SystemColor.activeCaption);
			separator.setBounds(11, 320, 560, 1);
			this.add(separator);
		}

		private void inicializarEditor() {	
			
			panel = new JPanel();
			panel.setBounds(41, 336, 500, 109);
			panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Alumno:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			this.add(panel);
			panel.setLayout(null);
			
			JLabel lblIdInstructor = new JLabel("id Alumno:");
			lblIdInstructor.setVisible(false);
			lblIdInstructor.setBounds(165, 86, 70, 14);
			panel.add(lblIdInstructor);
			
			textIdAlumno = new JTextField();
			textIdAlumno.setBounds(281, 83, 70, 20);
			textIdAlumno.setVisible(false);
			textIdAlumno.setEnabled(false);
			panel.add(textIdAlumno);
			textIdAlumno.setColumns(10);
			
			lblAlumno = new JLabel("");
			lblAlumno.setBounds(27, 38, 442, 37);
			panel.add(lblAlumno);
		}

		/**
		 * @return the spAlumnos
		 */
		public JScrollPane getSpAlumnos() {
			return spAlumnos;
		}

		/**
		 * @param spAlumnos the spAlumnos to set
		 */
		public void setSpAlumnos(JScrollPane spAlumnos) {
			this.spAlumnos = spAlumnos;
		}

		/**
		 * @return the modelAlumnos
		 */
		public DefaultTableModel getModelAlumnos() {
			return modelAlumnos;
		}

		/**
		 * @param modelAlumnos the modelAlumnos to set
		 */
		public void setModelAlumnos(DefaultTableModel modelAlumnos) {
			this.modelAlumnos = modelAlumnos;
		}

		/**
		 * @return the tblAlumnos
		 */
		public JTable getTblAlumnos() {
			return tblAlumnos;
		}

		/**
		 * @param tblAlumnos the tblAlumnos to set
		 */
		public void setTblAlumnos(JTable tblAlumnos) {
			this.tblAlumnos = tblAlumnos;
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
		 * @return the textIdAlumno
		 */
		public JTextField getTextIdAlumno() {
			return textIdAlumno;
		}

		/**
		 * @param textIdAlumno the textIdAlumno to set
		 */
		public void setTextIdAlumno(JTextField textIdAlumno) {
			this.textIdAlumno = textIdAlumno;
		}

		/**
		 * @return the lblAlumno
		 */
		public JLabel getLblAlumno() {
			return lblAlumno;
		}

		/**
		 * @param lblAlumno the lblAlumno to set
		 */
		public void setLblAlumno(JLabel lblAlumno) {
			this.lblAlumno = lblAlumno;
		}

}
