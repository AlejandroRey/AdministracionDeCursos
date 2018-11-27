package presentacion.vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class RecadoVistaPanel {

	private JFrame jFrame;
	private JPanel panel;
	private JTextField textAsunto;
	private JTextArea textAreaMensaje;
	private JTextField txtPara;
	protected Object frmBienvenidoAlSistema;
	private static String asunto;
	private static String de;
	private static String para;
	private static String mensaje;
	private JTextField textFieldDe;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecadoVistaPanel window = new RecadoVistaPanel(de, para, asunto, mensaje);
					window.jFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the Panel.
	 */
	@SuppressWarnings("static-access")
	public RecadoVistaPanel(String de, String para, String asunto, String mensaje) {
		jFrame = new JFrame();
		jFrame.setTitle("Recado");
		jFrame.setBounds(0, 0, 650, 690);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.getContentPane().setLayout(null);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.de = de;
		this.para = para;
		this.asunto = asunto;
		this.mensaje = mensaje;
		inicializar();
	}

	private void inicializar() {		
		inicializarEditor();		
	}

	private void inicializarEditor() {		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Recado", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panel.setBounds(15, 16, 616, 151);
		jFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(21, 106, 70, 14);
		panel.add(lblAsunto);
		
		textAsunto = new JTextField();
		textAsunto.setEditable(false);
		textAsunto.setHorizontalAlignment(SwingConstants.LEFT);
		textAsunto.setColumns(10);
		textAsunto.setBounds(98, 103, 486, 20);
		textAsunto.setText(asunto);
		panel.add(textAsunto);	
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setBounds(21, 70, 70, 14);
		panel.add(lblPara);
		
		txtPara = new JTextField();
		txtPara.setEditable(false);
		txtPara.setHorizontalAlignment(SwingConstants.LEFT);
		txtPara.setColumns(10);
		txtPara.setBounds(98, 67, 486, 20);
		txtPara.setText(para);
		panel.add(txtPara);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setBounds(21, 34, 69, 20);
		panel.add(lblDe);
		
		textFieldDe = new JTextField();
		textFieldDe.setEditable(false);
		textFieldDe.setBounds(98, 31, 486, 20);
		textFieldDe.setText(de);
		panel.add(textFieldDe);
		textFieldDe.setColumns(10);
				
		JPanel panelMensaje = new JPanel();
		panelMensaje.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 180, 209)), "Mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("textText")));
		panelMensaje.setBounds(14, 177, 616, 471);
		jFrame.getContentPane().add(panelMensaje);
		panelMensaje.setLayout(null);
		
		textAreaMensaje = new JTextArea();
		textAreaMensaje.setEditable(false);
		textAreaMensaje.setBounds(1, 1, 378, 476);
		textAreaMensaje.setText(mensaje);
		
	    JScrollPane scrollTextArea = new JScrollPane ( textAreaMensaje );
	    scrollTextArea.setBounds(10, 21, 593, 440);
	    scrollTextArea.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    
	    panelMensaje.add(scrollTextArea);
	    
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextAsunto() {
		return textAsunto;
	}

	public void setTextAsunto(JTextField textAsunto) {
		this.textAsunto = textAsunto;
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
	
	public JFrame getFrame() {
		return jFrame;
	}
	
	public void iniciliazar() {
		
	}
}