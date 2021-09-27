package ut2.indizarLibro;
import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra, int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra,pagina);
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
            return 0;
        }
        return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> listaPalabras = new LinkedList<String>();
        if(raiz != null){
            raiz.predecir(prefijo, listaPalabras);
        }
        return listaPalabras;
    }
    
    
}
