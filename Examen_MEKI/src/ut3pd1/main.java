/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd1;

/**
 *
 * @author Meki
 */
public class main {
    
    public static void main(String[] args) {
        // TODO code application logic here
         TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/ut3pd1/palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }  
        System.out.println("\n\nAhora con prefijos:\n\n");
        trie.imprimirConPreFijos();

    }
    
}
