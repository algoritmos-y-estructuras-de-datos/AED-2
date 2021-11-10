package uy.edu.ucu.aed2;

import java.util.Arrays;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 10;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int[] posArray;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        posArray = new int[2];
    }

    @Override
    public void insertar(String unaPalabra, int[] posEnArray) {
        TNodoTrie nodo = this;
        char[] caracteresTelefonicos = unaPalabra.toCharArray();
        for (int c = 0; c < caracteresTelefonicos.length; c++) {
            int indice = Character.getNumericValue(caracteresTelefonicos[c]);
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.posArray = posEnArray;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(
                        "Palabra del nodo: '" + s + "' | Pos en String: " + Arrays.toString(nodo.posArray) + "\n");
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String unaPalabra) {
        TNodoTrie nodo = this;
        char[] caracteresTelefonicos = unaPalabra.toCharArray();

        for (int i = 0; i < caracteresTelefonicos.length; i++) {
            int indice = Character.getNumericValue(caracteresTelefonicos[i]);
            if (nodo.hijos[indice] == null) {
                return null;
            } else {
                nodo = nodo.hijos[indice];
            }
        }
        return nodo;
    }

    private void encontrarPatron(String s, String prefijo, LinkedList<Integer> palabras, TNodoTrie nodo) {

        if (nodo != null) {
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    encontrarPatron("" + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
            if (nodo.esPalabra == true) {
                palabras.add(nodo.posArray[0]);
            }

        }
    }

    @Override
    public void encontrarPatron(String prefijo, LinkedList<Integer> palabras) {
        TNodoTrie buscado = buscarNodoTrie(prefijo);
        this.encontrarPatron("", prefijo, palabras, buscado);
    }

    @Override
    public int buscar(String s) {
        // TODO Auto-generated method stub
        return 0;
    }


}