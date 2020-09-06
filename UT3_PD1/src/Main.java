
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        

        TArbolTrie trie = new TArbolTrie();
        

        String[] palabrasClave = ManejadorArchivosGenerico.leerArchivo("src/PalabrasIndice.txt");
        for (String palabra : palabrasClave) {

            trie.insertar(IndizarLibro.filtrarPalabra(palabra));
        }
        
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo("src/libro.txt");
        int contLineas = 0;
        for (String linea : lineasLibro) {
            contLineas++;

            String[] palabras = linea.split(" ");
            for (String palabra : palabras) {
                palabra = IndizarLibro.filtrarPalabra(palabra);
                TNodoTrie nodoAux = trie.raiz.busqueda(palabra);
                if (nodoAux != null) {
                    
                    Integer ocurrencias = nodoAux.datos.get(0).get(0) + 1;
                    System.out.printf("%s - ocurrencias: %s - linea actual %s %s", palabra, ocurrencias, contLineas, "\n");
                    nodoAux.datos.get(0).set(0, ocurrencias);
                    
                    nodoAux.datos.get(1).add(contLineas);
                } else {
                    
                }
            }
        }
        
        
        System.out.println("...");

    }
}