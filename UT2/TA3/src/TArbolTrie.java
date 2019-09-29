
import java.io.Serializable;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EQUIPO 1
 */
public class TArbolTrie implements Serializable {

    private TNodoTrie raiz;

    /**
     * Insertar una palabra en el árbol
     *
     * @param palabra Palabra a insertar
     */
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    /**
     * IMPRIMIR TODO EL ÁRBOL
     */
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    /**
     * Busca si una cadena se encuentra en el árbol
     *
     * @param palabra Palabra a buscar en el árbol
     * @return -1 Si la raíz del árbol es nula ;
     */
    public int buscar(String palabra) {
        if (raiz == null) {
            return -1;
        }
        return raiz.buscar(palabra);
    }

    public boolean contains(String s) {
        return buscar(s) > -1;
    }

    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> prefijos = new LinkedList<String>();
        this.raiz.predecir(prefijo, prefijos);
        return prefijos;
    }
}
