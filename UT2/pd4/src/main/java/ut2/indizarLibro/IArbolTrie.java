package ut2.indizarLibro;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface IArbolTrie {

    void imprimir();
    int buscar(String palabra);

    void insertar(String palabra, int pagina);

    LinkedList<String> predecir(String prefijo);
    
}
