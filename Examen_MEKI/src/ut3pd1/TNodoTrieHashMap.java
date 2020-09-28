/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd1;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class TNodoTrieHashMap implements INodoTrieHashMap {
    public static final int CANT_CHR_ABCEDARIO = 26;
    private final HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character caracter = unaPalabra.charAt(c);
            if(!nodo.hijos.containsKey(caracter)){
                nodo.hijos.put(caracter, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(caracter);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (Object objetoIndice: nodo.hijos.keySet()){
                Character caracter = (Character) objetoIndice;
                imprimir(s+caracter, (TNodoTrieHashMap) nodo.hijos.get(caracter));
            } 
        }
    }
    private void imprimirConPreFijos(String prefijo, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            System.out.println(prefijo);
            for (Object objetoIndice: nodo.hijos.keySet()){
                Character caracter = (Character) objetoIndice;
                imprimirConPreFijos(prefijo + caracter, (TNodoTrieHashMap) nodo.hijos.get(caracter));
            } 
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    @Override
    public void imprimirConPreFijos() {
        imprimirConPreFijos("", this);
    }
    
    public int buscar(String unaPalabra) {
        int contador = 0;
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character caracter = unaPalabra.charAt(c);
            if(nodo.hijos.containsKey(caracter)){
                contador++;
            }
            nodo = nodo.hijos.get(caracter);
        }
        return contador;
    }
    
      private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            Character caracter = s.charAt(c);
            nodo = nodo.hijos.get(caracter);
        }
        if(nodo.esPalabra){
            return nodo;
        }
        return null;
    }
    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < prefijo.length(); c++){
            char letra = prefijo.charAt(c);
            TNodoTrieHashMap aux = nodo.hijos.get(letra);
            if (aux != null) {
                nodo = aux;
            } 
            else{
                return ;
            }
        }
        traerTodos(prefijo, palabras, nodo);
    }
    
    private void traerTodos(String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo.esPalabra){
            palabras.add(prefijo);
        }
        for (int c = 0; c < CANT_CHR_ABCEDARIO; c++){            
            if (nodo.hijos.get((char) ('a' + c ))!=null){
                char letra = (char) ('a'+ c);
                traerTodos(prefijo + letra, palabras, nodo.hijos.get(letra));
            }
           
        }  
    }  
}
