
import java.util.LinkedList;


public class TTrieHashMap implements IArbolTrie {

    public TNodoTrieHashMap raiz;

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

        @Override
        public int buscar(String palabra) {
                if (raiz == null) {
                        return -1;
                }
                return raiz.buscar(palabra);
        }

    @Override
    public LinkedList<String> predecir(String prefijo) 
    {
            LinkedList<String> prefijos = new LinkedList<String>();
            this.raiz.predecir(prefijo, prefijos);
            return prefijos;
    }
    
    
}
