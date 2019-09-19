
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieProteina implements INodoTrieProteina{
    
    public int posicion;
    public HashMap<Comparable, TNodoTrieProteina> hijos;

    public TNodoTrieProteina() {
        posicion = -1;
        hijos = new HashMap<>();
    }

    @Override
    public void encontrarPatron(String patron, LinkedList<Integer> locations) {
        // Si tiene posición, lo agrego
        if (this.posicion >= 0) {
            locations.add(posicion);
        }
        // Recorro recursivamente sus hijos
        for (Comparable clave : this.hijos.keySet()) {
            TNodoTrieProteina hijo = this.hijos.get(clave);
            hijo.encontrarPatron(patron, locations);
        }
    }

    @Override
    public void insertar(String unaPalabra, int posicion) {
        TNodoTrieProteina nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            char letra = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(letra)) {
                nodo.hijos.put(letra, new TNodoTrieProteina());
            }
            nodo = nodo.hijos.get(letra);
        }
        nodo.posicion = posicion;
    }
}
