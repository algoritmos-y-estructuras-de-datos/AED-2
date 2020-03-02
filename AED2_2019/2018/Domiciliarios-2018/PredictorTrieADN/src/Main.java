
import java.util.LinkedList;


public class Main {

    /**
     * 
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();
        /*
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
*/      
        String aInsertar = "ttctaatgtcccgacgctttatagcatcccatgcgattgcgaccttctcccctttatacgtctctacggtatgtttgtcgttcctctgtgtacgtctggtgcttcagtatcccgggtcggcaggaccgcccccggcgcaccgaagctgaacaagtatttaaacttgtgttcgcgacttgtctagattgatgtgttgtttcggtggactttatacctttctatatactgcgggttacgcatggcggttcctctttattctaagcttccactccattgcgcagcttagactcgattttttatttggcgggtcataaatctcacctctctgctcttccatattcggacagtcgggagattatgacgttgccatgtccgaccggtagataccagggacagacgcccggcgtgtaacggaaactgttccgctctcaccgtggtcacctcagcatatgtttcgtgtctcgtttgatggctcagctgggacgactagtacggtctggaagcgtagagctggcttcatgtacctctttcggtctttgtgcgcttcgtgttcctggggtgtcgtcccacgacatctgaagttagttgtcattaacccccccggcgccttgtcgaaaatatccaggcctagtatgcctgcggatgcctctatcgtgactcggttgctgtggtttagtttggactcttactccatactttaacccgttacctactggctctgttaatgcatggttacgcgcgtgtattccccggtctgcaaggttgtgtgcgatgaggtgcgaattcgcagcatcggacatacaggacagcgtggtcgggaatcgtccgcggccctgtgggccagtgatagtgaggtctacgtgagctaacatgctggatggttgggagggcttgtagtttcagatgtcgaaatgcaaccccgataacaccccgttaccttgtctgacgaccttaggtgcgtctgtaacggagactaagaccggtcacaagtcaatcggtg";
        String[] sufijos = new String[aInsertar.length()];
        for (int i = 0; i < aInsertar.length(); i++) {
            sufijos[i] = (aInsertar.substring(i,aInsertar.length()));
        }
        for (int j = 0; j<sufijos.length ; j++){
            trie.insertar(sufijos[j]);
        }
        
        Integer[] contador = new Integer[1];
        LinkedList<Integer> posiciones = new LinkedList<Integer>();
        contador[0] = 0;
        System.out.println("Patron: ccta");
        trie.repeticionesPatron("ccta",contador,posiciones);
        System.out.println("Posiciones:");
        for (int i = 0; i < posiciones.size(); i++) {
            System.out.println(posiciones.get(i));
        }
        System.out.println("Cantidad de veces aparecido:");
        System.out.println(contador[0]);
        System.out.println("________________________");
        contador[0] = 0;
        LinkedList<Integer> posiciones2 = new LinkedList<Integer>();
        System.out.println("Patron ggtca: ");
        trie.repeticionesPatron("ggtca",contador,posiciones2);
        System.out.println("Posiciones:");
        for (int i = 0; i < posiciones2.size(); i++) {
            System.out.println(posiciones2.get(i));
        }
        System.out.println("Cantidad de veces aparecido:");
        System.out.println(contador[0]);
        contador[0] = 0;
        System.out.println("___________________________");
        System.out.println("Patron: aacct");
        LinkedList<Integer> posiciones3 = new LinkedList<Integer>();
        trie.repeticionesPatron("aacct",contador,posiciones3);
        System.out.println("Posiciones:");
        for (int i = 0; i < posiciones3.size(); i++) {
            System.out.println(posiciones3.get(i));
        }
        System.out.println("Cantidad de veces aparecido:");
        System.out.println(contador[0]);
        
    /*
        trie.insertar("cttgacttgc");
        trie.insertar("ttgacttgc");
        trie.insertar("tagcttgc");
        trie.insertar("agcttgc");
        trie.insertar("gcttgc");
        trie.insertar("cttgc");
        trie.insertar("ttgc");
        trie.insertar("tgc");
        trie.insertar("gc");
        trie.insertar("c");
    */
              
    }
}