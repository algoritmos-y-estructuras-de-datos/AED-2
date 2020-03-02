import java.util.LinkedList;

public class TNodoTrieProteina implements INodoTrieProteina {

    // DISEÑAR LA ESTRUCTURA MAS APROPIADA Y EFICIENTE
    private TNodoTrieProteina[] hijos;
    private boolean esProteina;

    public TNodoTrieProteina() {
        // completar constructor en forma apropiada
        hijos = new TNodoTrieProteina[50];
        esProteina = false;
    }

    @Override
    public void encontrarPatron(String patron, LinkedList<Integer> locations) {
        TNodoTrieProteina nodo = this;
        for (int c = 0; c < patron.length(); c++) {
            if (patron.charAt(c) != '.') {
                int pos = patron.charAt(c) - '0';
                if (nodo != null && nodo.hijos != null && nodo.hijos[pos] != null) {
                    nodo = nodo.hijos[pos];
                } else {
                    nodo = null;
                }
            }
        }
    }

    @Override
    public void insertar(String unaPalabra, int posicion) {
        TNodoTrieProteina nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieProteina();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esProteina = true;

    }
}
