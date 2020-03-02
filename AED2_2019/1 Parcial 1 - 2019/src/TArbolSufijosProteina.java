
import java.util.LinkedList;

public class TArbolSufijosProteina implements IArbolSufijosProteina {

    private TNodoTrieProteina raiz;

    private LinkedList<Integer> locations;

    public TArbolSufijosProteina() {

        raiz = null;
        locations = new LinkedList<>();
    }

    @Override
    public LinkedList<Integer> encontrarPatron(String patron) {
        if (raiz != null) {
            LinkedList<Integer> proteinas = new <Integer>LinkedList();
            raiz.encontrarPatron(patron, proteinas);
            return proteinas;
        } else {
            return null;
        }
    }

    @Override
    public void insertar(String palabra, int posicion) {
        if (raiz == null) {
            raiz = new TNodoTrieProteina();
        }
        raiz.insertar(palabra, posicion);
    }

}
