package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import dto.EvaluacionTipoDTO;

@SuppressWarnings("serial")
public class EvaluacionABMPanel extends JPanel {
	
	private JPanel panelEvaluacion;
	private JComboBox<EvaluacionTipoDTO> cbxEvaluacionTipo;
	private JButton btnAgregarEvaluacion;
	private JTextField textTema;
	private JTextField textFecha;
	
	public EvaluacionABMPanel() {
		super();
		setBounds(0, 0, 372, 240);
		setLayout(null);
		
		inicializar();
	}

	private void inicializar() {
		
		panelEvaluacion = new JPanel();
		panelEvaluacion.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Evaluacion:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEvaluacion.setBounds(20, 11, 330, 164);
		add(panelEvaluacion);
		panelEvaluacion.setLayout(null);
		
		JLabel lblTipoDeEvaluacion = new JLabel("Tipo de Evaluacion:");
		lblTipoDeEvaluacion.setBounds(10, 35, 130, 25);
		panelEvaluacion.add(lblTipoDeEvaluacion);
		lblTipoDeEvaluacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTema = new JLabel("Tema:");
		lblTema.setBounds(10, 82, 130, 25);
		panelEvaluacion.add(lblTema);
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 128, 130, 25);
		panelEvaluacion.add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbxEvaluacionTipo = new JComboBox<EvaluacionTipoDTO>();
		cbxEvaluacionTipo.setBounds(150, 35, 160, 25);
		panelEvaluacion.add(cbxEvaluacionTipo);
		cbxEvaluacionTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textTema = new JTextField();
		textTema.setBounds(150, 82, 160, 25);
		panelEvaluacion.add(textTema);
		textTema.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(150, 128, 160, 25);
		panelEvaluacion.add(textFecha);
		textFecha.setColumns(10);
		
		btnAgregarEvaluacion = new JButton("Agregar Evaluacion");
		btnAgregarEvaluacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregarEvaluacion.setBounds(20, 189, 330, 35);
		add(btnAgregarEvaluacion);
	}

	/**
	 * @return the panelEvaluacion
	 */
	public JPanel getPanelEvaluacion() {
		return panelEvaluacion;
	}

	/**
	 * @param panelEvaluacion the panelEvaluacion to set
	 */
	public void setPanelEvaluacion(JPanel panelEvaluacion) {
		this.panelEvaluacion = panelEvaluacion;
	}

	/**
	 * @return the cbxEvaluacionTipo
	 */
	public JComboBox<EvaluacionTipoDTO> getCbxEvaluacionTipo() {
		return cbxEvaluacionTipo;
	}

	/**
	 * @param cbxEvaluacionTipo the cbxEvaluacionTipo to set
	 */
	public void setCbxEvaluacionTipo(JComboBox<EvaluacionTipoDTO> cbxEvaluacionTipo) {
		this.cbxEvaluacionTipo = cbxEvaluacionTipo;
	}

	/**
	 * @return the btnAgregarEvaluacion
	 */
	public JButton getBtnAgregarEvaluacion() {
		return btnAgregarEvaluacion;
	}

	/**
	 * @param btnAgregarEvaluacion the btnAgregarEvaluacion to set
	 */
	public void setBtnAgregarEvaluacion(JButton btnAgregarEvaluacion) {
		this.btnAgregarEvaluacion = btnAgregarEvaluacion;
	}

	/**
	 * @return the textTema
	 */
	public JTextField getTextTema() {
		return textTema;
	}

	/**
	 * @param textTema the textTema to set
	 */
	public void setTextTema(JTextField textTema) {
		this.textTema = textTema;
	}

	/**
	 * @return the textFecha
	 */
	public JTextField getTextFecha() {
		return textFecha;
	}

	/**
	 * @param textFecha the textFecha to set
	 */
	public void setTextFecha(JTextField textFecha) {
		this.textFecha = textFecha;
	}
	
}
