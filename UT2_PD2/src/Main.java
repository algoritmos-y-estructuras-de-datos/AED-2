
import java.util.ArrayList;
/**
 * Usa como datos de prueba los siguientes y construye el trie correspondiente
Ala, 1, 3, 88
Alimaña, 11, 22
Alabastro, 4
Perro, 5, 8
Pera, 7,12
Alimento, 9
Casa, 11,13
Casada, 1
Cazar, 33
Programa, 22, 67
Programación, 15
Programar 15,16
3. Responde las siguientes preguntas:
• ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Programa”?
• ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Proselitismo?
• ¿Cuántas comparaciones se realizan para insertar la palabra “cazadores”?
• ¿cuál es la altura del árbol trie resultante?
• ¿cuál es su tamaño?
 * 
 */
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
        arbol.insertarConPaginas("ala",1);
        arbol.insertarConPaginas("ala",3);
        
        arbol.imprimir();
        
        /*
        String[] array = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        for (String i : array){
            arbol.insertar(i);
        }
        
        System.out.println(arbol.buscar("alar"));*/
    }
    
}
