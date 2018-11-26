package herramientas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

		public static final String expMail = "\\w+@\\w+(\\.\\w+)+";                // ejemplo@ejemplo.com
		public static final String expMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		public static final String expFecha = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}"; // dd//mm/yyyy
		public static final String expTelefono = "1[15]\\d{8}";			 		   // 15xxxxxxxx o 11xxxxxxxx
		public static final String expAltura = "\\d{1,4}";			       		   // 1321
		public static final String expNombres = "^[A-Z][a-z]+((\\s[A-Z]((\\.)?)([a-z]+)?)+$)"; // ??????????? ?????????
		public static final String expNombre =  "^[A-Z][a-z]+((\\s[A-Z]((\\.)?)([a-z]+)?)+$)|^[A-Z][a-z]+"; //????? tambien toma un nombre solo
		public static final String expNumeros = "\\d+";						   // xx
		public static final String expNoVacio = "([A-Z]|[a-z])+";
		
		public boolean mailValido(String mailInput)
		{
			return verificar(mailInput,expMAIL);
		}
		
		public boolean nombresValido(String nombreInput)
		{
			return verificar(nombreInput,expNombres);
		}
		
		public boolean textValido(String text)
		{
			return verificar(text,expNoVacio);
		}
		/**
		 *Idem a nombresValido. Admite un solo nombre. 
		 */
		public boolean nombreValido(String nombreInput)
		{
			return verificar(nombreInput,expNombre);
		}
		
		public boolean telefonoValido(String telefonoInput)
		{
			return verificar(telefonoInput,expTelefono);
		}
		
		public boolean alturaValida(String alturaInput)
		{
			return verificar(alturaInput,expAltura);
		}
		
		public boolean fechaValida(String fechaInput)
		{
			return verificar(fechaInput,expFecha);
		}
		
		public boolean numeroValido(String numeroInput)
		{
			return verificar(numeroInput,expNumeros);
		}
		
		private boolean verificar(String input, String expresion) 
		{
			Pattern pattern = Pattern.compile(expresion);
			Matcher matcher = pattern.matcher(input);
			return matcher.matches();
		}
		
		public static void main(String []args)
		{
			Validator validador = new Validator();
			String dsa = "  Leandro Gonzalez";
			System.out.println("Nombre y apellido: " + validador.nombreValido(" Leandro Gonzalez") );
			System.out.println(validador.nombreValido(dsa.trim()));
			System.out.println(dsa.trim());
			System.out.println("Telefono: " + validador.telefonoValido(" 1123564578"));
			System.out.println("Calle: " + validador.nombreValido(" Bona"));
			System.out.println("Altura: " + validador.alturaValida("36"));
			System.out.println("Numero: " + validador.numeroValido(""));
			System.out.println("Departamento: " + validador.nombreValido("") );
			System.out.println("Localidad: " + validador.nombreValido(" Jose C. Paz"));
			System.out.println("Mail: " + validador.mailValido(" leo_6@hotmail.com"));
			System.out.println("Cumpleaños: " + validador.fechaValida("09/02/2202"));
			System.out.println("Tipo: " + validador.nombreValido(" Universidad"));
			System.out.println("Fin de prueba.");
		}
}
