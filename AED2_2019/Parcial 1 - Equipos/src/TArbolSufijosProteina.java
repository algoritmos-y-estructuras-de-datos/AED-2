
import java.io.Serializable;
import java.util.LinkedList;

public class TArbolSufijosProteina implements IArbolSufijosProteina{

    private TNodoTrieProteina raiz;

    @Override
    public LinkedList<Integer> encontrarPatron(String patron) {
        LinkedList<Integer> posiciones = new LinkedList<>();
        TNodoTrieProteina nodo = raiz;
        
        if (nodo != null) {
            // Me ubico en el nodo para comenzar a buscar los patrones
            for (char letra : patron.toCharArray()) {
                if (!nodo.hijos.containsKey(letra)) {
                    return posiciones;
                }
                nodo = nodo.hijos.get(letra);
            }
            if (nodo != null) {
                // Obtengo patrones
                nodo.encontrarPatron(patron, posiciones);
                // Retorno posiciones con patrones
                return posiciones;
            }
        }
        // Retorno posiciones vacías (no encontré)
        return posiciones;
    }

    @Override
    public void insertar(String palabra, int posicion) {
        if (raiz == null) {
            raiz = new TNodoTrieProteina();
        }
        raiz.insertar(palabra, posicion);
    }

}