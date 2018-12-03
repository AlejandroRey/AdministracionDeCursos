package herramientas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OptionPanel 
{
	public static void mensaje(String mensaje, String titulo)
	{
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(OptionPanel.class.getResource("/presentacion/imagenes/information_64.png")));
	}

	public static String input(String referencia, String titulo)
	{
		return JOptionPane.showInputDialog( null, referencia, titulo,  JOptionPane.QUESTION_MESSAGE);
	}

	public static int confimarcion(String pregunta, String titulo)
	{
		return JOptionPane.showConfirmDialog(null, pregunta, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(OptionPanel.class.getResource("/presentacion/imagenes/information_64.png")));
	}

	public static void error(String mensaje, String titulo)
	{
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE,new ImageIcon(OptionPanel.class.getResource("/presentacion/imagenes/error_64.png")));
	}
}
