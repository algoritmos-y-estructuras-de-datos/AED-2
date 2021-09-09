
import java.util.ArrayList;

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
        TArbolTrie arbol = new TArbolTrie();
        String[] array = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        for (String i : array){
            arbol.insertar(i);
        }
        
        System.out.println(arbol.buscar("alar"));
    }
    
}
