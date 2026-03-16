package jcolonia.daw2025.tablasmvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jcolonia.daw2025.tablasmvc.VistaMenu.*;

/**
 * Núcleo de la aplicación de consola con sistema de menús.
 * La aplicación permite trabajar con tablas de multiplicar
 * clásicas infantiles, mostrando la tabla activa, cambiándola
 * o exportándola a un archivo de texto.
 */
public class ControlTablaMultiplicar {

    /**
     * Formato tipo «printf» para el nombre del archivo
     * utilizado en la exportación de la tabla.
     */
    public static final String FORMATO_RUTA_ARCHIVO_EXPORTACIÓN =
        "tabla del %02d.txt";

    /** Tabla de multiplicar actualmente activa. */
    private TablaMultiplicar tabla;

    /** Número correspondiente a la tabla activa. */
    private int numeroActivo;

    /** Lista con los textos de las opciones disponibles en el menú principal. */
    private static final List<String> OPCIONES_MENÚ_PRINCIPAL = new ArrayList<>();

    static {
        OPCIONES_MENÚ_PRINCIPAL.add("Mostrar tabla activa");
        OPCIONES_MENÚ_PRINCIPAL.add("Cambiar tabla (nuevo número)");
        OPCIONES_MENÚ_PRINCIPAL.add("Exportar tabla a archivo");
        OPCIONES_MENÚ_PRINCIPAL.add("Salir");
    }

    /**
     * Constructor principal de la clase ControlTablaMultiplicar.
     * Inicializa la aplicación preparando la primera tabla activa.
     */
    public ControlTablaMultiplicar() {
        init();
    }

    /**
     * Solicita al usuario un número y prepara la primera
     * tabla de multiplicar activa.
     */
    public void init() {
        cambiarTabla();
    }

    /**
     * Gestiona el menú principal de la aplicación.
     * Desde este menú el usuario puede seleccionar las
     * distintas opciones disponibles.
     * 
     * El programa finaliza cuando el usuario elige la opción de salida.
     */
    public void buclePrincipal() {
        VistaMenu menu = new VistaMenu("Tablas de multiplicar", OPCIONES_MENÚ_PRINCIPAL);
        int opción = -1;

        do {
                menu.mostrarOpciones();
                opción = menu.pedirOpción();

                switch (opción) {
                    case 1:
                        mostrarTabla();
                        break;
                    case 2:
                        cambiarTabla();
                        break;
                    case 3:
                        exportarTabla();
                        break;
                    case 0: // SALIR
                        break;
                    default:
                        opciónNoDisponible();
                        break;
                }
        } while (opción != 0);

        VistaGeneral.mostrarAviso("FIN");
    }
    private void cambiarTabla() {
        int n;

        System.out.println("Introduzca el número para la tabla:");

        Scanner scEntrada = new Scanner(System.in);
        n = scEntrada.nextInt();
        this.numeroActivo = n;
        scEntrada.nextLine();

        tabla = new TablaMultiplicar(n);
        tabla.generarTabla();

        VistaGeneral.mostrarAviso("Tabla del " + n + " preparada.");
    }

    /**
     * Exporta el contenido de la tabla activa a un archivo de texto.
     * El nombre del archivo se genera automáticamente utilizando
     * el formato definido en {@link #FORMATO_RUTA_ARCHIVO_EXPORTACIÓN}.
     */
    private void exportarTabla() {

        String nombreArchivo = String.format(FORMATO_RUTA_ARCHIVO_EXPORTACIÓN, this.numeroActivo);

        List<String> lineas = tabla.toListaExportacion();

        try (java.io.PrintWriter escritor = new java.io.PrintWriter(nombreArchivo)) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
            VistaGeneral.mostrarAviso("Archivo exportado con éxito: " + nombreArchivo);

        } catch (java.io.FileNotFoundException e) {
            VistaGeneral.mostrarAviso("Error al crear el archivo: " + e.getMessage());
        }
    }

    /**
     * Muestra un mensaje indicando que la opción elegida
     * no está disponible dentro del menú.
     */
    private void opciónNoDisponible() {
        VistaGeneral.mostrarAviso("La opcion indicada no esta disponible");
    }
}