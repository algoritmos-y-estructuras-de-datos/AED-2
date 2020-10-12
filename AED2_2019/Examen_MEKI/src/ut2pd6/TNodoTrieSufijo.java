/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd6;

import ut2pd2.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
class TNodoTrieSufijo {
    
    private static final char[] abc = new char[]{'a', 'c', 'g', 't'};
    private TNodoTrieSufijo[] hijos;
    private boolean esPalabra;
    private ArrayList<Integer> paginas = new ArrayList<Integer>();
    private int inicio;
    
    public TNodoTrieSufijo(){
        hijos = new TNodoTrieSufijo[4];  //creo un array de hijos del mismo tamanio del abc
        esPalabra = false;
    }

    private int enAbc (char caracter){
        
        return (new String(abc).indexOf(caracter));
        
    }
    
    void insertar(String palabra, int inicio) {
        TNodoTrieSufijo nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            
            int indice = enAbc(palabra.charAt(c));
            if(nodo.hijos[indice]== null){
                nodo.hijos[indice] = new TNodoTrieSufijo();
            }
            nodo = nodo.hijos[indice];
            
        }
        nodo.esPalabra = true;
        nodo.inicio = inicio;
    }
    
//    //se agrega para poder insertar una palara con sus respectivas paginas
//    void insertarConPaginas(String palabra, int pagina) {
//        TNodoTrieSufijo nodo = this;
//        for (int i = 0; i < palabra.length(); i++) {
//            
//            int indice = palabra.charAt(i) - 'a';
//            if(nodo.hijos[indice]== null){
//                nodo.hijos[indice] = new TNodoTrieSufijo();
//            }
//            nodo = nodo.hijos[indice];
//            
//        }
//        nodo.esPalabra = true;
//        nodo.paginas.add(pagina);
//    }
//    
// imprime con todos los sufijos
    void imprimir(String s, TNodoTrieSufijo nodo) {
        if (nodo != null){
            if(nodo.esPalabra){
                System.out.println(s);
            }
            for (int i = 0; i < 4; i++) {
                if(nodo.hijos[i] != null){
                    imprimir(s + abc[i], nodo.hijos[i]);
                }
                
            }
        }
       
    }
    
    public void imprimir(){
        imprimir("", this);
    }

    int buscar(String palabra) {
        TNodoTrieSufijo nodo = this;
        int comparaciones = 0;
        for (int i = 0; i < palabra.length(); i++) {
            int indice = palabra.charAt(i) - 'a';
            comparaciones = i + 1;
            if (nodo.hijos[indice] == null) {
                return 0;
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra) {
            return comparaciones;
        } else {
            return 0;

        }

    }

//    public String paginasDePalabra(String palabra) {
//       TNodoTrieSufijo nodo = this;
//        for (int i = 0; i < palabra.length(); i++) {
//            int indice = palabra.charAt(i) - 'a';
//            if (nodo.hijos[indice] == null) {
//                return "No se encuentra " + palabra ;
//            }
//            nodo = nodo.hijos[indice];
//        }
//        if (nodo.esPalabra) {
//            
//            return palabra + " se encuentra en paginas "+ nodo.paginas.toString();
//    
//        }else{
//            return "no se encuentra";
//        }
//    }

    void prefijoUbicación(String prefijo, LinkedList<Integer> inicios) {
        TNodoTrieSufijo nodo = this.buscarNodoTrie(prefijo);
        if(nodo!= null){
            obtenerPalabrasPrefijos(nodo, prefijo, inicios);
        }
    }

    private TNodoTrieSufijo buscarNodoTrie(String prefijo) {
        TNodoTrieSufijo nodo = this;
        for (int i = 0; i < prefijo.length(); i++) {
            
            int indice = enAbc(prefijo.charAt(i));
            if(nodo.hijos[indice] == null){
                return null;
            }
            nodo = nodo.hijos[indice];
            
        }
        return nodo;
    }

    private void obtenerPalabrasPrefijos(TNodoTrieSufijo nodo, String prefijo, LinkedList<Integer> inicios) {
       if(nodo != null){
           if(nodo.esPalabra){
               inicios.add(nodo.inicio);
           }
       }
        for (int i = 0; i < 4; i++) {
            if(nodo.hijos[i] != null){
                obtenerPalabrasPrefijos(nodo.hijos[i], prefijo +abc[i], inicios);
            }
            
        }
    }
    
    
    
}
