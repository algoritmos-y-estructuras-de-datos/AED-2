package UT3.ej5.pt2;

import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrie  {

    private static final char[] abc = new char[]{'a','c','g','t'};
    private HashMap<Comparable,TNodoTrie> hijos;
    private boolean esPalabra;
    private int inicio;
   
    public TNodoTrie() {
        hijos = new HashMap();
        esPalabra = false;
    }
    
    private int enAbecedario(char caracter){
        return (new String(abc).indexOf(caracter));
    }

  
    public void insertar(String unaPalabra, int inicio) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            
            if (!nodo.hijos.containsKey(unaPalabra.charAt(c))) {
                nodo.hijos.put(unaPalabra.charAt(c), new TNodoTrie());
            }
            nodo = nodo.hijos.get(unaPalabra.charAt(c));
        }
        nodo.esPalabra = true;
        nodo.inicio = inicio;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < 4; c++) {
                if (nodo.hijos.containsKey(abc[c])) {
                    imprimir(s+ abc[c], nodo.hijos.get(abc[c]));
                }
            }
        }
    }

    
    public void imprimir() {    
        imprimir("", this);
    }
    
    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            
            if (!nodo.hijos.containsKey(s.charAt(c))) {
                return null;
            }
            nodo = nodo.hijos.get(s.charAt(c));
        }
        return nodo;
    }

    public void obtenerPalabras(TNodoTrie nodo, String prefijo, LinkedList<Integer> inicios) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                inicios.add(nodo.inicio);
            }
            for (int c = 0; c < 4; c++) {
                if (nodo.hijos.containsKey(abc[c])) {
                    obtenerPalabras(nodo.hijos.get(abc[c]), prefijo +abc[c], inicios);
                }
            }
        }
    }

    
    public void prefijoUbicación(String prefijo, LinkedList<Integer> inicios) {
        TNodoTrie nodo = this.buscarNodoTrie(prefijo);
         
         if (nodo != null) {
             obtenerPalabras(nodo, prefijo, inicios);
         }
    }
    
    public int busqueda(String unaPalabra){
        TNodoTrie nodo = this;
        int comparaciones=0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (!nodo.hijos.containsKey(unaPalabra.charAt(c))) {
                return 0;
            } else {
                comparaciones++;
                nodo = nodo.hijos.get(unaPalabra.charAt(c));
            }
        }
        if(nodo.esPalabra){
            return comparaciones;
        } else {
            return 0;
        }
    }
    
  
}
