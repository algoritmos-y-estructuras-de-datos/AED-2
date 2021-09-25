
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        
        // Tarea indizar libro
        TArbolTrie trie = new TArbolTrie();
        
        // Cargamos palabras
        String[] palabrasClave = ManejadorArchivosGenerico.leerArchivo("src/PalabrasIndice.txt");
        for (String palabra : palabrasClave) {
            //System.out.println(palabra);
            trie.insertar(IndizarLibro.filtrarPalabra(palabra));
        }
        
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo("src/libro.txt");
        int contLineas = 0;
        for (String linea : lineasLibro) {
            contLineas++;
//            System.out.println(linea);
            String[] palabras = linea.split(" ");
            for (String palabra : palabras) {
                palabra = IndizarLibro.filtrarPalabra(palabra);
                TNodoTrie nodoAux = trie.raiz.busqueda(palabra);
                if (nodoAux != null) {
                    // Actualizo ocurrencias
                    Integer ocurrencias = nodoAux.datos.get(0).get(0) + 1;
                    System.out.printf("%s - ocurrencias: %s - linea actual %s %s", palabra, ocurrencias, contLineas, "\n");
                    nodoAux.datos.get(0).set(0, ocurrencias);
                    // Agrego línea actual al nodo
                    nodoAux.datos.get(1).add(contLineas);
                } else {
                    //System.out.printf("[IGNORADO] %s - línea actual: %s %s", palabra, contLineas, "\n");
                }
            }
        }
        
        
//        TArbolTrie trie = new TArbolTrie();
//
//        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
//        for (String p : palabrasclave) {
//                trie.insertar(p);
//        }
//        trie.imprimir();

        System.out.println("...");

    }
}