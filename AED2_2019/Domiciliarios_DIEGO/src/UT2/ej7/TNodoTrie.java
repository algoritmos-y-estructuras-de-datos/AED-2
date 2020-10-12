/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.ej7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class TNodoTrie implements INodoTrie {

    private TNodoTrie[] hijos;
    private boolean esNumero;
    private TAbonado abonado;

    public TNodoTrie() {
        hijos = new TNodoTrie[10];
    }
 
    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie aux = this.buscarNodoTrie(primerosDigitos);
        if (aux!=null){obtenerNumeros(aux, primerosDigitos, abonados);}
    }

    @Override    
    public void insertar(TAbonado unAbonado) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            int indice = Character.getNumericValue(unAbonado.getTelefono().charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esNumero = true;
        nodo.abonado=unAbonado;
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
                palabras.add(nodo.abonado);
            }
            for (int c = 0; c < 10; c++) {
                if (nodo.hijos[c] != null) {
                    obtenerNumeros(nodo.hijos[c], prefijo + (c), palabras);
                }
            }
        }
    }
}
