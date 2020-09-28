/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
class TNodoTrie {
    
    private static final int CANT_CHR_ABC = 26;
    private TNodoTrie[] hijos;
    private boolean esNumero;
    private TAbonado dato;
    private ArrayList<Integer> paginas = new ArrayList<Integer>();
    
    public TNodoTrie(){
        hijos = new TNodoTrie[CANT_CHR_ABC];  //creo un array de hijos del mismo tamanio del abc
        esNumero = false;
    }

  public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie aux = this.buscarNodoTrie(primerosDigitos);
        if (aux != null) {
            obtenerNumeros(aux, primerosDigitos, abonados);
        }
    }

    public void insertarAbonado(TAbonado unAbonado) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            int indice = Character.getNumericValue(unAbonado.getTelefono().charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esNumero = true;
        nodo.dato = unAbonado;
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = Character.getNumericValue(s.charAt(c));
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    public void obtenerNumeros(TNodoTrie nodo, String prefijo, LinkedList<TAbonado> palabras) {
        if (nodo != null) {
            if (nodo.esNumero) {
                palabras.add(nodo.dato);
            }
            for (int c = 0; c < 10; c++) {
                if (nodo.hijos[c] != null) {
                    obtenerNumeros(nodo.hijos[c], prefijo + (c), palabras);
                }
            }
        }
    }
    
}
