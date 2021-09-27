import uy.edu.ucu.aed2.IArbolTrie;

/**
 *
 * @author lucas
 */
public class TArbolTrie implements IArbolTrie{
    private TNodoTrie raiz;
    
    
    public void insertar(String palabra){
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    public void imprimir() {
        if(raiz != null){
            raiz.imprimir();
        }
    }

    public int buscar(String palabra){
        return raiz.busqueda(palabra);
    }
}
