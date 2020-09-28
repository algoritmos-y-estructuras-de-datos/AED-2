/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd1;

import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class TTrieHashMap implements ITrieHashMap {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public void imprimirConPreFijos() {
        if (raiz != null) {
            raiz.imprimirConPreFijos();
        }
    }

    @Override
    public int buscar(String palabra) {
        if(raiz != null){
            return raiz.buscar(palabra);
        }
        else{
            return 0;
        }
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList lista = new LinkedList<>();
        if(!prefijo.isEmpty()){
            raiz.predecir(prefijo, lista);
        }
        return lista;
    }
    
    
}
