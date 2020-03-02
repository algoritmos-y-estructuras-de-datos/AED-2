
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TTrieHashMap trieHashMap = new TTrieHashMap();
        // Cargamos palabras
        String[] palabrasClave = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        for (String palabra : palabrasClave) {
            //System.out.println(palabra);
            trieHashMap.insertar(IndizarLibro.filtrarPalabra(palabra));
        }
        LinkedList result = trieHashMap.predecir("a");
        System.out.println(result);
    }

}
