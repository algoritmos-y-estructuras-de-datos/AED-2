
import java.util.ArrayList;
import java.util.LinkedList;

public class TArbolTrie {
    private TNodoTrie raiz;
    
    public TArbolTrie(){
        this.raiz=null;
    }
    
    public TNodoTrie getRaiz() {
        return raiz;
    }
   
    public void setRaiz(TNodoTrie raiz) {
        this.raiz = raiz;
    }
   
    public void insertar (String palabra){
        if (raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }
    /*
    public void insertar (String palabra, int pagina){
        if (raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra,pagina);
    }
    */
    public void imprimir(){
        if (raiz != null){
            raiz.imprimir();
        }
    }
    
    public boolean buscar (String palabra){
        if (this.raiz == null) 
            return false;
        return raiz.buscar(palabra);
    }

    public ArrayList buscarPaginas (String palabra){
        if (this.raiz == null) 
            return null;
        return raiz.buscarPaginas(palabra);
    } 
    
    
    
    public LinkedList<String> predecir(String a) {
        LinkedList lista = new LinkedList<>();
        if(raiz != null){
            raiz.predecir(a, lista);
            return lista;
        }
        else{
            return lista;
        }
    }
    public void repeticionesPatron (String s, Integer[] contador,LinkedList<Integer> posicion){
        if (raiz !=null){
            raiz.buscarExistenciaPatron(s, contador,posicion);
        }
    }
}