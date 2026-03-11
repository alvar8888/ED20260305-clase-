package jcolonia.daw2025.tablasmvc;

import java.util.List;
import java.util.Scanner;


public class VistaGeneral {

		
	int n;
	private String FORMATO_PRINTF_MOSTRARTEXTO ="%s%n";
	private String FORMATO_PRINTF_MOSTRARSC = "AVISO: %s%n";

	private Scanner scEntrada= new Scanner(System.in);

	public void mostrarTexto(String texto) {
		
	}

	public void mostrarAviso(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARSC);
	}

	public void mostrarTitulo(String texto) {
		
	}

	public void mostrarTitulo2(String texto) {
		
	}

	public int pedirNumero(String texto) {
		System.out.print(texto + ":");
		int numero= scEntrada.nextInt();
		scEntrada.nextLine();
		return numero;
	}


	public void Pausa(String texto) {
		
	}

	public boolean pedirConfirmacion(String texto) {
		System.out.print(texto + "(S/N): ");
		String respuesta=scEntrada.nextLine();
		return respuesta.equalsIgnoreCase("s");
	}


	public void mostrarLista(List<String> Lista) {
		
		
	}

	public void getScEntrada() {
		System.out.print(scEntrada);	

		scEntrada.close();
	}
}

