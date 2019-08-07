/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.ej5.pt2;

import UT2.ej6.*;

/**
 *
 * @author Diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/UT2/ej6/secuencia.txt");
        TArbolTrie trie = new TArbolTrie(palabrasclave[0].trim());
        //TArbolTrie trie = new TArbolTrie("ccttgacttgc");
        //trie.imprimir();
        System.out.println("Prefijo: aacct");
        System.out.println("Aparece: " + trie.ubicaciónPrefijo("aacct").size()+ " veces.");
        System.out.println("En "+trie.ubicaciónPrefijo("aacct"));
        
        System.out.println("Prefijo: ccta");
        System.out.println("Aparece: " + trie.ubicaciónPrefijo("ccta").size()+ " veces.");
        System.out.println("En "+trie.ubicaciónPrefijo("ccta"));
        
        System.out.println("Prefijo: ggtca");
        System.out.println("Aparece: " + trie.ubicaciónPrefijo("ggtca").size()+ " veces.");
        System.out.println("En "+trie.ubicaciónPrefijo("ggtca"));
        System.out.println("####################################################");
        TArbolTrie trie2 = new TArbolTrie("alacena");
        
        System.out.println(trie2.buscar("ala"));
       }
    
}
