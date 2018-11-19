package presentacion.vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class RecadoEnviarPanel extends JPanel{

	private JPanel panel;
	
	private JTextField textIdRecado;
	private JTextField textAsunto;
	
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JButton btnB;
	
	private JTextArea textAreaMensaje;
	private JTextField txtPara;
	protected Object frmBienvenidoAlSistema;
	
	/**
	 * Create the Panel.
	 */
	public RecadoEnviarPanel() {
		super();
		this.setBounds(0, 0, 733, 708);
		this.setLayout(null);
		inicializar();
	}

	private void inicializar() {		
		inicializarEditor();		
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Nuevo Recado", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panel.setBounds(15, 16, 703, 151);
		this.add(panel);
		panel.setLayout(null);
						
		JLabel lblIdRecado = new JLabel("id Recado:");
		lblIdRecado.setVisible(false);
		lblIdRecado.setBounds(21, 123, 94, 14);
		panel.add(lblIdRecado);
		
		textIdRecado = new JTextField();
		textIdRecado.setBounds(119, 121, 36, 17);
		textIdRecado.setVisible(false);
		textIdRecado.setEnabled(false);
		panel.add(textIdRecado);
		textIdRecado.setColumns(10);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(21, 76, 70, 14);
		panel.add(lblAsunto);
		
		textAsunto = new JTextField();
		textAsunto.setHorizontalAlignment(SwingConstants.LEFT);
		textAsunto.setColumns(10);
		textAsunto.setBounds(98, 73, 522, 20);
		panel.add(textAsunto);	
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setBounds(21, 32, 70, 14);
		panel.add(lblPara);
		
		txtPara = new JTextField();
		txtPara.setHorizontalAlignment(SwingConstants.LEFT);
		txtPara.setColumns(10);
		txtPara.setBounds(98, 26, 522, 20);
		panel.add(txtPara);
		
		btnB = new JButton("B");
		btnB.setVisible(false);
		btnB.setBounds(635, 28, 41, 22);
		panel.add(btnB);
				
		JPanel panelMensaje = new JPanel();
		panelMensaje.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panelMensaje.setBounds(14, 177, 704, 477);
		add(panelMensaje);
		panelMensaje.setLayout(null);
		
		textAreaMensaje = new JTextArea();
		textAreaMensaje.setBounds(1, 1, 378, 476);
		
	    JScrollPane scrollTextArea = new JScrollPane ( textAreaMensaje );
	    scrollTextArea.setBounds(10, 21, 679, 445);
	    scrollTextArea.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    
	    panelMensaje.add(scrollTextArea);
	    
	    btnCancelar = new JButton("Nuevo");
	    btnCancelar.setBounds(15, 667, 96, 23);
	    add(btnCancelar);
	    
	    btnEnviar = new JButton("Enviar");
	    btnEnviar.setBounds(622, 667, 96, 23);
	    add(btnEnviar);
	    
	}

	public JButton getBtnB() {
		return btnB;
	}

	public void setBtnB(JButton btnB) {
		this.btnB = btnB;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextIdRecado() {
		return textIdRecado;
	}

	public void setTextIdRecado(JTextField textIdRecado) {
		this.textIdRecado = textIdRecado;
	}

	public JTextField getTextAsunto() {
		return textAsunto;
	}

	public void setTextAsunto(JTextField textAsunto) {
		this.textAsunto = textAsunto;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTextArea getTextAreaMensaje() {
		return textAreaMensaje;
	}

	public void setTextAreaMensaje(JTextArea textAreaMensaje) {
		this.textAreaMensaje = textAreaMensaje;
	}

	public JTextField getTxtPara() {
		return txtPara;
	}

	public void setTxtPara(JTextField txtPara) {
		this.txtPara = txtPara;
	}

	public Object getFrmBienvenidoAlSistema() {
		return frmBienvenidoAlSistema;
	}

	public void setFrmBienvenidoAlSistema(Object frmBienvenidoAlSistema) {
		this.frmBienvenidoAlSistema = frmBienvenidoAlSistema;
	}
}
