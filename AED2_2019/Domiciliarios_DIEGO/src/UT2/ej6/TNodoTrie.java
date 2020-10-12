package UT2.ej6;
import java.util.LinkedList;

public class TNodoTrie  {

    private static final char[] abc = new char[]{'a','c','g','t'};
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int inicio;
   
    public TNodoTrie() {
        hijos = new TNodoTrie[4];
        esPalabra = false;
    }
    
    private int enAbecedario(char caracter){
        return (new String(abc).indexOf(caracter));
    }

  
    public void insertar(String unaPalabra, int inicio) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = enAbecedario(unaPalabra.charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
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
                if (nodo.hijos[c] != null) {
                    imprimir(s+ abc[c], nodo.hijos[c]);
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
            int indice = enAbecedario(s.charAt(c));
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    public void obtenerPalabras(TNodoTrie nodo, String prefijo, LinkedList<Integer> inicios) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                inicios.add(nodo.inicio);
            }
            for (int c = 0; c < 4; c++) {
                if (nodo.hijos[c] != null) {
                    obtenerPalabras(nodo.hijos[c], prefijo +abc[c], inicios);
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
    
    public int busqueda(String palabra, int indice, int comparaciones) {
        TNodoTrie nodo = this;
        int hijo = 0;
        String[] unaPalabra = palabra.split("");
        if (nodo.esPalabra) {
            return comparaciones;
        }
        while (nodo!=null) {
            nodo = this.hijos[hijo];
            if (nodo.hijos.equals(unaPalabra[indice])) {
                return busqueda(palabra, indice++, comparaciones++);
            } else {
                hijo++;
            }
        }
        return comparaciones;
    }
    
  
}
