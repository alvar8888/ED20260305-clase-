import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la tabla de multiplicar de un número.
 * Permite generar la tabla del 0 al 10 y obtener los resultados
 * en formato de lista o en formato de texto.
 * 
 * Cada resultado se almacena como un String dentro de un ArrayList.
 * 
 * </pre>
 * 
 * @author Álvar Escudero Barriuso
 * @version 1.0
 */
public class TablaMultiplicar{

    /**
     * Número del que se generará la tabla de multiplicar.
     */
    private int numero;

    /**
     * Lista donde se almacenan las líneas de texto de la tabla de multiplicar.
     */
    private ArrayList<String> listaTextos = new ArrayList<>();
    
    /**
     * Constructor de la clase TablaMultiplicar.
     * Inicializa el número del cual se generará la tabla.
     * 
     * @param numero2 número del que se quiere generar la tabla de multiplicar
     */
    public TablaMultiplicar(int numero){
        this.numero = numero;
    }

    /**
     * Genera la tabla de multiplicar del número desde 0 hasta 10.
     * Cada resultado se guarda en la lista en formato de texto.
     */
    public void generarTabla(){
        int i;

        for(i = 0; i <= 10; i++){
            int resultado = numero * i;
            String textoTabla = numero + " por " + i + " es igual a " + resultado;
            listaTextos.add(textoTabla); // añade el texto al final del ArrayList
        }
    }

    /**
     * Devuelve la tabla de multiplicar en forma de lista para exportación.
     * 
     * @return lista de Strings con las operaciones de la tabla de multiplicar
     */
    public List<String> toListaExportacion(){
        return listaTextos;
    }

    /**
     * Devuelve la tabla de multiplicar en forma de lista para mostrar en pantalla.
     * 
     * @return lista de Strings con las operaciones de la tabla de multiplicar
     */
    public List<String> toListaPantalla(){
        return listaTextos;
    }

    /**
     * Devuelve una representación en texto de la tabla de multiplicar.
     * 
     * @return String con el número de la tabla y todas las operaciones generadas
     */
    @Override
    public String toString(){
       return "Tabla Multiplicar del " + "[" + numero + "]" + " es :" +
       String.join(", ", listaTextos);
    }
}
