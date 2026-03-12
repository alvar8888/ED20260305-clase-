package jcolonia.daw2025.tablasmvc;

import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario.
 * <p>
 * Forma parte de la vista dentro del patrón MVC y se ocupa de mostrar
 * mensajes por pantalla y recoger datos introducidos por el usuario.
 * </p>
 */
public class VistaGeneral {

	int n;

	/** Formato utilizado para mostrar texto estándar por pantalla. */
	private final String FORMATO_PRINTF_MOSTRARTEXTO ="%s%n";

	/** Formato utilizado para mostrar avisos al usuario. */
	private static final String FORMATO_PRINTF_MOSTRARSC = "AVISO: %s%n";

	/** Scanner utilizado para leer datos introducidos por teclado. */
	private static Scanner scEntrada= new Scanner(System.in);

	/**
	 * Muestra un texto simple por pantalla.
	 * 
	 * @param texto el texto que se desea mostrar
	 */
	public void mostrarTexto(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARTEXTO, texto);
	}

	/**
	 * Muestra un aviso por pantalla con un formato específico.
	 * 
	 * @param texto el mensaje de aviso que se desea mostrar
	 */
	public static void mostrarAviso(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARSC, texto);
	}

	/**
	 * Muestra un título principal en pantalla.
	 * 
	 * @param texto el texto que se mostrará como título
	 */
	public void mostrarTitulo(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARTEXTO, texto);
        System.out.println("================================");
	}

	/**
	 * Muestra un título secundario en pantalla.
	 * 
	 * @param texto el texto que se mostrará como subtítulo
	 */
	public void mostrarTitulo2(String texto) {
        System.out.printf(FORMATO_PRINTF_MOSTRARTEXTO, texto);
        System.out.println("-------------------------------");
		
	}

	/**
	 * Solicita al usuario la introducción de un número entero.
	 * 
	 * @param texto el mensaje que se muestra para pedir el número
	 * @return el número introducido por el usuario
	 */
	public static int pedirNumero(String texto) {
		System.out.print(texto + ":");
		int numero= scEntrada.nextInt();
		scEntrada.nextLine();
		return numero;
	}

	/**
	 * Realiza una pausa en la ejecución del programa mostrando un mensaje.
	 * 
	 * @param texto el mensaje que se mostrará antes de la pausa
	 */
	public void Pausa(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARTEXTO, texto);
		scEntrada.nextLine();
	}

	/**
	 * Solicita al usuario una confirmación mediante una respuesta
	 * de tipo sí o no.
	 * 
	 * @param texto el mensaje que solicita la confirmación
	 * @return {@code true} si el usuario responde "s" o "S", {@code false} en caso contrario
	 */
	public boolean pedirConfirmacion(String texto) {
		System.out.print(texto + "(S/N): ");
		String respuesta=scEntrada.nextLine();
		return respuesta.equalsIgnoreCase("s");
	}

	/**
	 * Muestra una lista de textos por pantalla.
	 * 
	 * @param Lista lista de cadenas que se desea mostrar
	 */
	public void mostrarLista(List<String> Lista) {

	    for(String texto : Lista){
	        System.out.println(texto);
	    }
	}

	/**
	 * Muestra información del objeto Scanner utilizado para la entrada
	 * y posteriormente lo cierra.
	 */
	public void getScEntrada() {
		System.out.print(scEntrada);	
		scEntrada.close();
	}
}


