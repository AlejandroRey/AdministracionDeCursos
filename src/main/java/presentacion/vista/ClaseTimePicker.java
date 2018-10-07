package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;
import com.toedter.calendar.JCalendar;

@SuppressWarnings("serial")
public class ClaseTimePicker extends JPanel {
	
	private JCalendar calendario;
	private JScrollPane spFechas;
	private DefaultTableModel modelFechas;
	private JTable tblFechas;
	private String[] nombreColumnas = {"Fecha Inicio", "Hora Inicio", "Fecha Fin", "Hora Fin"};
	
	private TimePicker textHoraInicio;
	private TimePicker textHoraFin;
	
	private JButton btnAgregar;

	public ClaseTimePicker() {
		super();
		
		inicializar();
	}

	private void inicializar() {
		setLayout(null);
	
		calendario = new JCalendar();
		calendario.setBounds(10, 11, 212, 153);
		this.add(calendario);
		
		spFechas = new JScrollPane();
		spFechas.setBounds(232, 11, 338, 328);
		this.add(spFechas);
		
		modelFechas = new DefaultTableModel(null, nombreColumnas);
		tblFechas = new JTable(modelFechas){
		    @Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		tblFechas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		//tblusuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		spFechas.setViewportView(tblFechas);	
		
		JLabel lblHoraInicio = new JLabel("Hora de Inicio:");
		lblHoraInicio.setBounds(10, 175, 81, 14);
		add(lblHoraInicio);
		
        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.setColor(TimeArea.TimePickerTextValidTime, Color.blue);
        timeSettings.initialTime = LocalTime.now();
		
		textHoraInicio = new TimePicker(timeSettings);
		textHoraInicio.setBounds(88, 175, 80, 20);
		add(textHoraInicio);
		
		JLabel lblHoraDeFin = new JLabel("Hora de Fin:");
		lblHoraDeFin.setBounds(10, 206, 81, 14);
		add(lblHoraDeFin);
		
		textHoraFin = new TimePicker();
		textHoraFin.setBounds(88, 206, 80, 20);
		add(textHoraFin);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(72, 255, 89, 23);
		add(btnAgregar);
	}

	public JCalendar getCalendario() {
		return calendario;
	}

	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}

	public JScrollPane getSpFechas() {
		return spFechas;
	}

	public void setSpFechas(JScrollPane spFechas) {
		this.spFechas = spFechas;
	}

	public DefaultTableModel getModelFechas() {
		return modelFechas;
	}

	public void setModelFechas(DefaultTableModel modelFechas) {
		this.modelFechas = modelFechas;
	}

	public JTable getTblFechas() {
		return tblFechas;
	}

	public void setTblFechas(JTable tblFechas) {
		this.tblFechas = tblFechas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public TimePicker getTextHoraInicio() {
		return textHoraInicio;
	}

	public void setTextHoraInicio(TimePicker textHoraInicio) {
		this.textHoraInicio = textHoraInicio;
	}

	public TimePicker getTextHoraFin() {
		return textHoraFin;
	}

	public void setTextHoraFin(TimePicker textHoraFin) {
		this.textHoraFin = textHoraFin;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
}
