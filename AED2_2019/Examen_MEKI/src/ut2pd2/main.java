/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd2;

/**
 *
 * @author Meki
 */
public class main {
     public static void main(String[] args) {
         TArbolTrie arbolito = new TArbolTrie();
         String[] libro = ManejadorArchivosGenerico.leerArchivo("src/ut2pd2/palabras.txt");
         
         for (String linea : libro) {
             
             String[] separados = linea.split(",");
             arbolito.insertarConPaginas(separados[0], Integer.parseInt(separados[1].trim()));
             
         }
         
         arbolito.imprimir();
         arbolito.paginasDePalabra("ala");
     }
    
}
