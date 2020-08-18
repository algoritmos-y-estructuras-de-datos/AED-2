
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private ArrayList<Integer> paginas = new ArrayList<Integer>();

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    public void insertar(String palabras, Integer paginas) {
        TNodoTrie nodo = this;

        for (int i = 0; i < palabras.length(); i++) {
            int indice = palabras.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.paginas.add(paginas);
    }

    public String paginasDePalabra(String palabras){
        TNodoTrie nodo = this;
        for (int i = 0; i < palabras.length(); i++) {
            int indice = palabras.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                return "No se encuentra";
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra) {
            return nodo.paginas.toString();
        } else {
            return "No se encuentra";
        }
    }
    
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    public int busqueda(String unaPalabra) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return 0;
            } else {
                comparaciones++;
                nodo = nodo.hijos[indice];
            }
        }
        if (nodo.esPalabra) {
            return comparaciones;
        } else {
            return 0;
        }
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + ", " + nodo.paginas.toString());
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    public void imprimir() {
        imprimir("", this);
    }

}
