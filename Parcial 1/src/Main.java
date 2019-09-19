
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // INSTANCIAR UN ARBOL DE SUFIJOS
        TArbolSufijosProteina asProteina = new TArbolSufijosProteina();

        // LEER LA CADENA DE AMINOACIDOS DESDE EL ARCHIVO
        String[] secuencia = ManejadorArchivosGenerico.leerArchivo("src/proteina.txt");
        String proteina = secuencia[0];
        
        // Obtengo todos los sufijos e inserto en el árbol
        String[] sufijos = new String[proteina.length()];
        for (int i = 0; i <= sufijos.length; i++) {
            String sufijo = (String) proteina.subSequence(i, sufijos.length);
            asProteina.insertar(sufijo, i);
        }
        
        // Para escritura de archivos
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/salida.txt"));
        
        // cargar el árbol de sufijos en la forma apropiada
        // buscar las ocurrencias del patrón "KPL" 
        String elPatron = "KPL";
        LinkedList<Integer> locations = asProteina.encontrarPatron(elPatron);
        bw.write(elPatron + " -> " + locations + "\n");

        // buscar las ocurrencias del patrón "PQL" 
        elPatron = "PQL";
        LinkedList<Integer> locations1 = asProteina.encontrarPatron(elPatron);
        bw.write(elPatron + " -> " + locations1 + "\n");

        // buscar las ocurrencias del patrón "CIEAL" 
        elPatron = "CIEAL";
        LinkedList<Integer> locations2 = asProteina.encontrarPatron(elPatron);
        bw.write(elPatron + " -> " + locations2 + "\n");

        // Y escribir los resultados en el archivo 
        // SALIDA.TXT, titulando para cada patrón.
        bw.close();
    }
}
