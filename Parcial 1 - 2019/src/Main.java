
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
// INSTANCIAR UN ARBOL DE SUFIJOS
        TArbolSufijosProteina asProteina = new TArbolSufijosProteina();

// LEER LA CADENA DE AMINOACIDOS DESDE EL ARCHIVO
        String[] secuencia = ManejadorArchivosGenerico.leerArchivo("src/proteina.txt");

// cargar el árbol de sufijos en la forma apropiada
        for (String p : secuencia) {
            asProteina.insertar(p, 0);
        }
// buscar las ocurrencias del patrón "KPL" 
        String elPatron = "KPL";
        LinkedList<Integer> locations = asProteina.encontrarPatron(elPatron);

// buscar las ocurrencias del patrón "PQL" 
        elPatron = "PQL";
        LinkedList<Integer> locations1 = asProteina.encontrarPatron(elPatron);

// buscar las ocurrencias del patrón "CIEAL" 
        elPatron = "CIEAL";
        LinkedList<Integer> locations2 = asProteina.encontrarPatron(elPatron);

// Y escribir los resultados en el archivo
// SALIDA.TXT, titulando para cada patrón.
System.out.println(locations2.size());
        String[] salida = new String[locations.size()];
        for (Integer i : locations) {
            salida[i] = i.toString();
            ManejadorArchivosGenerico.escribirArchivo("src/SALIDA_KPL.txt", salida);
        }
    }
}
