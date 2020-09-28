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
class TNodoTrie {
    
    private static final int CANT_CHR_ABC = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    
    public TNodoTrie(){
        hijos = new TNodoTrie[CANT_CHR_ABC];  //creo un array de hijos del mismo tamanio del abc
        esPalabra = false;
    }

    void insertar(String palabra) {
        TNodoTrie nodo = this;
        for (int i = 0; i < palabra.length(); i++) {
            
            int indice = palabra.charAt(i) - 'a';
            if(nodo.hijos[indice]== null){
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
            
        }
        nodo.esPalabra = true;
    }

    void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null){
            if(nodo.esPalabra){
                System.out.println(s);
            }
            for (int i = 0; i < CANT_CHR_ABC; i++) {
                if(nodo.hijos[i] != null){
                    imprimir(s + (char)(i + 'a'), nodo.hijos[i]);
                }
                
            }
        }
       
    }
    
    public void imprimir(){
        imprimir("", this);
    }

    int buscar(String palabra) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        for (int i = 0; i < palabra.length(); i++) {
            int indice = palabra.charAt(i) - 'a';
            comparaciones = indice + 1;
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
    
    
}
