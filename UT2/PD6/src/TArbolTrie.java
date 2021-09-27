import java.util.LinkedList;

/**
 *
 * @author lucas
 */
public class TArbolTrie implements IArbolTrie{
    private TNodoTrie raiz;
    
    
    public void insertar(String palabra, int[] posEnArray){
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, posEnArray);
    }

    public void imprimir() {
        if(raiz != null){
            raiz.imprimir();
        }
    }

    public int buscar(String palabra){
        return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        raiz.predecir(prefijo, palabras);
        return palabras;
    }

  
}
