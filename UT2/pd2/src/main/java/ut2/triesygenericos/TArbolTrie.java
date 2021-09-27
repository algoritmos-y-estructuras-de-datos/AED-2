package ut2.triesygenericos;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class TArbolTrie {

    public TNodoTrie raiz;

    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    public int insertarConPaginas(String palabra, Integer paginas) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        return raiz.insertarConPaginas(palabra, paginas);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public Integer buscar(String palabra) {
        return raiz.busqueda(palabra);
    }

    public Integer altura(TNodoTrie nodo) {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.altura(nodo);
        }
    }
    
     public Integer tamanio(TNodoTrie nodo) {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.tamanio(nodo);
        }
    }

}
