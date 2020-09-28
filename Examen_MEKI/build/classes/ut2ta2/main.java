/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ta2;

/**
 *
 * @author Meki
 */
public class main {
    public static void main(String[] args) {
        String [] texto = ManejadorArchivosGenerico.leerArchivo("src/ut2ta2/palabras.txt");
       
        
        TArbolTrie arbolito = new TArbolTrie();
        
        for (int i = 0; i < texto.length; i++) {
            arbolito.insertar(texto[i]);
            
        }
        
    }
}
