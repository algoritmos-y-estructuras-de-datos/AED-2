package uy.edu.ucu.aed2;

import java.util.LinkedList;

/**
 *
 * @author lucas
 */
public class TArbolTrie implements IArbolTrie{
    private TNodoTrie raiz;
    
    
    public void insertar(String palabra, int[] posEnArray){
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, posEnArray);
    }

    public void imprimir() {
        if(raiz != null){
            raiz.imprimir();
        }
    }

    public int buscar(String palabra){
        return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<Integer> encontrarPatron(String patron) {
        LinkedList<Integer> palabras = new LinkedList<>();
        raiz.encontrarPatron(patron, palabras);
        return palabras;
    }

  
}
