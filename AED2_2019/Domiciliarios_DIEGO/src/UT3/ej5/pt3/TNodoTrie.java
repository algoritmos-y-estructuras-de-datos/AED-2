/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.ej5.pt3;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class TNodoTrie implements INodoTrie {

    private HashMap<Comparable,TNodoTrie> hijos;
    private boolean esNumero;
    private TAbonado abonado;

    public TNodoTrie() {
        hijos = new HashMap();
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
            
            if (!nodo.hijos.containsKey(unAbonado.getTelefono().charAt(c))) {
                nodo.hijos.put(unAbonado.getTelefono().charAt(c), new TNodoTrie());
            }
            nodo = nodo.hijos.get(unAbonado.getTelefono().charAt(c));
        }
        nodo.esNumero = true;
    }
    
    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = Character.getNumericValue(s.charAt(c));
            if (!nodo.hijos.containsKey(indice)) {
                return null;
            }
            nodo = nodo.hijos.get(indice);
        }
        return nodo;
    }

    public void obtenerNumeros(TNodoTrie nodo, String prefijo, LinkedList<TAbonado> palabras) {
        if (nodo != null) {
            if (nodo.esNumero) {
                palabras.add(nodo.abonado);
            }
            for (int c = 0; c < 10; c++) {
                if (nodo.hijos.containsKey(c)) {
                    obtenerNumeros(nodo.hijos.get(c), prefijo + (c), palabras);
                }
            }
        }
    }
}
