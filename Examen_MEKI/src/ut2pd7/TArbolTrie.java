/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd7;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class TArbolTrie {
    
    private TNodoTrie raiz;
    
  public Collection<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> aux = new LinkedList();
        if (raiz!= null) {raiz.buscarTelefonos((pais + area), aux);}
        return aux;
    }

    public void insertarAbonado(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertarAbonado(unAbonado);
    }
    
    
    
}
