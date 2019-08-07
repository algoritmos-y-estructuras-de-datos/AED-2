/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.ej7;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;
    
    @Override
    public Collection<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> aux = new LinkedList();
        if (raiz!= null) {raiz.buscarTelefonos((pais + area), aux);}
        return aux;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unAbonado);
    }
    
}
