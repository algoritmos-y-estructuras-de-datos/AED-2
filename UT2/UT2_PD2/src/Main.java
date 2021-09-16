
import java.util.ArrayList;

/**
 * Usa como datos de prueba los siguientes y construye el trie correspondiente
 * 3. Responde las siguientes preguntas: • ¿Cuántas comparaciones realiza el
 * algoritmo de búsqueda si el argumento es “Programa”?
 *
 * Realiza 8 comparaciones
 *
 * • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es
 * “Proselitismo?
 *
 * Realiza 0 comparaciones
 *
 * • ¿Cuántas comparaciones se realizan para insertar la palabra “cazadores”?
 *
 * Son necesarias 9 comparaciones
 *
 * • ¿cuál es la altura del árbol trie resultante? (camino mas largo)
 *
 * La altura del Trie es 14
 *
 * • ¿cuál es su tamaño?
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
        arbol.insertarConPaginas("ala", 1);
        arbol.insertarConPaginas("ala", 3);
        arbol.insertarConPaginas("ala", 88);
        arbol.insertarConPaginas("alimana", 11);
        arbol.insertarConPaginas("alimana", 22);
        arbol.insertarConPaginas("alabastro", 4);
        arbol.insertarConPaginas("perro", 5);
        arbol.insertarConPaginas("perro", 8);
        arbol.insertarConPaginas("pera", 7);
        arbol.insertarConPaginas("pera", 12);
        arbol.insertarConPaginas("alimento", 9);
        arbol.insertarConPaginas("casa", 11);
        arbol.insertarConPaginas("casa", 13);
        arbol.insertarConPaginas("casada", 1);
        arbol.insertarConPaginas("cazar", 33);
        arbol.insertarConPaginas("programa", 22);
        arbol.insertarConPaginas("programa", 67);
        arbol.insertarConPaginas("programar", 16);
        arbol.insertarConPaginas("programar", 15);
        arbol.insertarConPaginas("programacion", 15);

        System.out.println("Comparaciones para Programa: " + arbol.buscar("programa"));
        System.out.println("Comparaciones para Proselitismo: " + arbol.buscar("proselitismo"));
        System.out.println("Comparaciones para insertar Cazadores: " + arbol.insertarConPaginas("cazadores", 89));

        System.out.println("La altura del arbol es: " + arbol.altura(arbol.raiz));
        
        System.out.println("El tamanio del arbol es: " + arbol.tamanio(arbol.raiz));

    }

}
