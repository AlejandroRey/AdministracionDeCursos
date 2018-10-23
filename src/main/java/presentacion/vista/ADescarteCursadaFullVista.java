//package presentacion.vista;
//
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//
//import persistencia.conexion.Conexion;
//
//public class ADescarteCursadaFullVista {
//
//	private JFrame frame;
//	private CursadaABMPanel panelCursada;
//	private AlumnosInscriptosPanel panelInscriptos;
//	
//	public ADescarteCursadaFullVista() {
//		super();
//		initialize();
//	}
//
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1600, 682);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		panelCursada = new CursadaABMPanel();
//		panelCursada.setSize(700, 622);
//		panelCursada.setLocation(2, 2);
//		//panelCursada.setBounds(0, 0, 1064, 262);
//		frame.getContentPane().add(panelCursada);
//		
//		panelInscriptos = new AlumnosInscriptosPanel();
//		panelInscriptos.setSize(628, 536);
//		panelInscriptos.setLocation(708, 2);
//		frame.getContentPane().add(panelInscriptos);
//	}
//
//	public void show() {
//		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		this.frame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la vista!?",
//						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//				if (confirm == 0) {
//					Conexion.getConexion().cerrarConexion();
//					frame.dispose();
//				}
//			}
//		});
//		this.frame.setVisible(true);
//	}
//
//	/**
//	 * @return the panelCursada
//	 */
//	public CursadaABMPanel getPanelCursada() {
//		return panelCursada;
//	}
//
//	/**
//	 * @param panelCursada the panelCursada to set
//	 */
//	public void setPanelCursada(CursadaABMPanel panelCursada) {
//		this.panelCursada = panelCursada;
//	}
//
//	/**
//	 * @return the panelInscriptos
//	 */
//	public AdescarteAlumnosInscriptosPanel getPanelInscriptos() {
//		return panelInscriptos;
//	}
//
//	/**
//	 * @param panelInscriptos the panelInscriptos to set
//	 */
//	public void setPanelInscriptos(AdescarteAlumnosInscriptosPanel panelInscriptos) {
//		this.panelInscriptos = panelInscriptos;
//	}
//
//	/**
//	 * @return the frame
//	 */
//	public JFrame getFrame() {
//		return frame;
//	}
//
//	/**
//	 * @param frame the frame to set
//	 */
//	public void setFrame(JFrame frame) {
//		this.frame = frame;
//	}
//
//}
