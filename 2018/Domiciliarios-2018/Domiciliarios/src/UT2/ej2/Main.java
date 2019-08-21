package UT2.ej2;


/**
 *
 * @author Diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/UT2/ej2/palabras-paginas.txt");
        TArbolTrie trie = new TArbolTrie();
        for (String linea : palabrasclave) {
            
            String[] aux = linea.split(",");
            
            trie.insertar(aux[0], Integer.parseInt(aux[1].trim()));
        }
        
        trie.imprimir();*/
        String l = "000.111.555.";
        System.out.println(l.split(".").length);
    }
    
}
