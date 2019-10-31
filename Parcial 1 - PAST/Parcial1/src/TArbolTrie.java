
import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class TArbolTrie implements IArbolTrie{

    private TNodoTrie raiz;
    
    @Override
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
     LinkedList<TDispositivo> aux = new LinkedList();
        if (raiz!= null) {raiz.buscarDispositivos(mascaraSubRed, aux);}
        return aux;   
    }

    @Override
    public void insertar(TDispositivo unDispositivo) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unDispositivo);
    }

    public TNodoTrie getRaiz() {
        return raiz;
    }
    
    
    
}
