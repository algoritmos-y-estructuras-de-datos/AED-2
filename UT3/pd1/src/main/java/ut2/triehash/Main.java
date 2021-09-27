package ut2.triehash;

import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TArbolTrie trie = new TArbolTrie();

        String[] palabrasClave = ManejadorArchivosGenerico.leerArchivo("C:/Source/AED-2/UT3/pd1/src/main/java/ut2/triehash/PalabrasIndice.txt");
        for (String palabra : palabrasClave) {
            //System.out.println(palabra);
            trie.insertar(IndizarLibro.filtrarPalabra(palabra));
        }
        
        //trie.imprimir();
        
        
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo("C:/Source/AED-2/UT3/pd1/src/main/java/ut2/triehash/libro.txt");
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
