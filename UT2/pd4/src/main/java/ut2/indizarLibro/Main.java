package ut2.indizarLibro;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("C:/Source/AED-2/UT2/pd4/src/main/java/ut2/indizarLibro/libro.txt");
        
        int contadorLineas = 1;
        for (String p : palabrasclave) {
            String[] fraseToPalabras = p.split(" ");
            for(String palabra : fraseToPalabras){
                String filtrada = IndizarLibro.filtrarPalabra(palabra);
                trie.insertar(filtrada,((int) ((contadorLineas / 50) + 1)));
            }
            contadorLineas++;
        }


        trie.imprimir();
        //System.out.println(Arrays.toString(palabrasclave));


        String aBuscar1 = "metropolitano";
        String aBuscar2 = "arboleada";
        String aBuscar3 = "mam";

        int comparaciones = trie.buscar(aBuscar1);
        System.out.printf("La busqueda de: '%s' realizó: [%d] comparaciones \n",aBuscar1,comparaciones);
        
        comparaciones = trie.buscar(aBuscar2);
        System.out.printf("La busqueda de: '%s' realizó: [%d] comparaciones \n",aBuscar2,comparaciones);
        
        comparaciones = trie.buscar(aBuscar3);
        System.out.printf("La busqueda de: '%s' realizó: [%d] comparaciones \n",aBuscar3,comparaciones);


        // <-- Prueba de predicción -->
        System.out.println("\nPredicción de 'mu':");
        LinkedList<String> predict = trie.predecir("mu");
        System.out.println(predict.toString());



    }
}