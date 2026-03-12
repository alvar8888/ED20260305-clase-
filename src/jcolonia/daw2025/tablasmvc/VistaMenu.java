package jcolonia.daw2025.tablasmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una vista de menú en un patrón MVC.
 * Permite mostrar un título, una lista de opciones y solicitar al usuario que seleccione una opción.
 * Hereda de {@link VistaGeneral}.
 * 
 * @author Álvar Escudero Barriuso
 * @version 1.0
 */
public class VistaMenu extends VistaGeneral {

    /**
     * Título del menú.
     */
    private String titulo;

    /**
     * Lista de opciones disponibles en el menú.
     */
    private ArrayList<String> opciones = new ArrayList<>();

    /**
     * Scanner para leer la entrada del usuario desde la consola.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase {@code VistaMenu}.
     * Inicializa el título y la lista de opciones del menú.
     * 
     * @param titulo Título del menú.
     * @param opciones Lista de opciones a mostrar.
     */
    public VistaMenu(String titulo, List<String> opciones) {
        this.titulo = titulo;
        this.opciones = new ArrayList<>(opciones);
    }

    /**
     * Muestra el título del menú usando el método {@link VistaGeneral#mostrarTitulo(String)}.
     */
    public void mostrarTitulo() {
        super.mostrarTitulo(titulo);
    }

    /**
     * Muestra todas las opciones del menú numeradas.
     * Cada opción se imprime en la consola con su número correspondiente empezando desde 1.
     */
    public void mostrarOpciones() { 
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }

    /**
     * Solicita al usuario que seleccione una opción del menú.
     * Lee un número entero desde la entrada estándar.
     * 
     * @return La opción seleccionada por el usuario como un número entero.
     */
    public int pedirOpcion() { 
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    /**
     * Muestra un texto genérico usando el método {@link VistaGeneral#mostrarTexto(String)}.
     * 
     * @param texto Texto a mostrar en la consola.
     */
    public void mostrarTexto(String texto) {
        super.mostrarTexto(texto);
    }
}
