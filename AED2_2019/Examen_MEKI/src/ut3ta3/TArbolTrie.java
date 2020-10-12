package ut3ta3;



import java.io.Serializable;
import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie,Serializable {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        palabra = palabra.toLowerCase();
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
        if (raiz!=null)
        {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lista = new LinkedList<>();
        if (raiz!=null)
        {
            raiz.predecir(prefijo, lista);
        }
        return lista;
    }
    
    
}
