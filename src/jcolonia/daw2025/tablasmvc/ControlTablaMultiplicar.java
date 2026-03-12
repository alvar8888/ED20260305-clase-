package jcolonia.daw2025.tablasmvc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Núcleo de la aplicación de consola de texto con menús.
 * Esta clase gestiona la lógica de las tablas de multiplicar infantiles clásicas.
 * Permite mostrar la tabla activa, cambiarla y exportarla a un archivo.
 * Funciona con un menú principal interactivo en consola.
 * 
 * @author 
 * @version 1.0
 */
public class ControlTablaMultiplicar {

    /**
     * Formato tipo «printf» para el nombre del archivo de exportación.
     * Se usa con el número de la tabla para generar un archivo como
     * "tabla del 03.txt".
     */
    public static final String FORMATO_RUTA_ARCHIVO_EXPORTACIÓN =
            "tabla del %02d.txt";

    /**
     * Opciones disponibles en el menú principal.
     */
    private static final String[] OPCIONES_MENU_PRINCIPAL = {
            "Mostrar tabla", "Cambiar tabla", "Exportar tabla"};

    /**
     * Tabla de multiplicar actualmente activa.
     */
    private TablaMultiplicar tabla;

    /**
     * Constructor de la clase {@code ControlTablaMultiplicar}.
     * Inicializa la primera tabla activa mediante {@link #init()}.
     */
    public ControlTablaMultiplicar() {
        init();
    }

    /**
     * Inicializa la aplicación solicitando al usuario un número
     * para establecer la primera tabla de multiplicar activa.
     */
    public void init() {
        cambiarTabla();
    }

    /**
     * Gestiona el menú principal de la aplicación.
     * Permite al usuario seleccionar las opciones disponibles:
     * mostrar la tabla, cambiarla o exportarla. El menú se repite
     * hasta que el usuario seleccione 0 para salir.
     */
    public void buclePrincipal() {
        VistaMenu menú;
        int opción;

        menú = new VistaMenu("Tablas de multiplicar", Arrays.asList(OPCIONES_MENU_PRINCIPAL));

        do {
            menú.mostrarOpciones();
            opción = menú.pedirOpcion();

            switch (opción) {
                case 1: // Mostrar tabla
                    mostrarTabla();
                    break;
                case 2: // Cambiar tabla
                    cambiarTabla();
                    break;
                case 3: // Exportar tabla
                    exportarTabla();
                    break;
                case 0: // Salir
                    break;
                default: // Opciones no implementadas
                    opciónNoDisponible();
                    break;
            }

        } while (opción != 0);

        VistaGeneral.mostrarAviso("FIN");
    }

    /**
     * Muestra por pantalla los productos correspondientes
     * a la tabla de multiplicar activa.
     * Actualmente este método está vacío y debe implementarse.
     */
    private void mostrarTabla() {}

    /**
     * Cambia la tabla activa solicitando al usuario un número
     * y generando la nueva tabla correspondiente.
     */
    private void cambiarTabla() {
        VistaGeneral.pedirNumero("Introduzca el número para la tabla");

        tabla = new TablaMultiplicar(numero);
        TablaMultiplicar.numero();
        tabla.generarTabla();
    }

    /**
     * Exporta a un archivo los productos correspondientes
     * a la tabla de multiplicar activa.
     * Actualmente este método está vacío y debe implementarse.
     */
    private void exportarTabla() {}

    /**
     * Muestra un mensaje de aviso indicando que
     * la opción elegida no está disponible.
     */
    private void opciónNoDisponible() {}
}