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
public interface INodoTrieHashMap {
    void imprimir();

    void imprimirConPreFijos();

    void insertar(String unaPalabra);

    public void predecir(String prefijo, LinkedList<String> palabras);
}
