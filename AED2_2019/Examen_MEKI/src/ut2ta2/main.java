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
        String [] array = ManejadorArchivosGenerico.leerArchivo("src/ut2ta2/palabras.txt");
       
        
        TArbolTrie arbol = new TArbolTrie();
        for (String letras : array) {
            arbol.insertar(letras); 
       }
        System.out.println(arbol.buscar("ala"));
        System.out.println(arbol.buscar("pepe"));
        arbol.imprimir();
        
            
        }
}
