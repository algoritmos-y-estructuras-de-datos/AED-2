
import java.util.ArrayList;
import java.util.LinkedList;

public class TTrieSufijosHashMap {

    private TNodoTrieHashMap raiz;

   
        public void insertar(String palabra, int indice) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra, indice);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public LinkedList<String> predecir(String prefijo) {
        if (raiz != null) {
            LinkedList<String> palabras = new LinkedList<String>();
            raiz.predecir(prefijo,palabras);
            return palabras;
        }
        return null;
    }
     public ArrayList<Integer> posicionesPatron(String patron) {
        if (raiz != null) {
            ArrayList<Integer> posiciones = new ArrayList<>();
            raiz.posicionesPatron(patron,posiciones);
            return posiciones;
        }
        return null;
    }

 
}
