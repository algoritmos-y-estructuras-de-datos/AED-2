/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TArbolTrieTest {

    /**
     * Test of insertar method, of class TArbolTrie.
     */
    @Test
    public void testPredecirE() {
        System.out.println("TEST PREDECIR - EXISTE");
        String prefijo = "p";
        TArbolTrie trie = new TArbolTrie();
        String[] palabrasclave = {"casa","casamiento","arbol","arado","pension","paseo"};
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        LinkedList<String> misPalabras = trie.predecir("pas");
        for (String palabra : misPalabras){
            System.out.println( (String) palabra);
        }
        assertEquals("paseo", misPalabras.get(0)); 
    }
    
    /**
     * Test of insertar method, of class TArbolTrie.
     */
    @Test
    public void testPredecirNoE() {
        System.out.println("TEST PREDECIR - NO EXISTE");
        String prefijo = "p";
        TArbolTrie trie = new TArbolTrie();
        String[] palabrasclave = {"casa","casamiento","arbol","arado","pension","paseo"};
        for (String p : palabrasclave) {
             trie.insertar(p);
        }
        LinkedList<String> misPalabras = trie.predecir("ari");
        for (String palabra : misPalabras){
            System.out.println( (String) palabra);
        }
        assertEquals(0, misPalabras.size()); 
    }
}
