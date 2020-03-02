package parcialCompleto;


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
     public ArrayList<Integer>  ocurrenciasPosicionesPatron(String patron) {
        if (raiz != null) {
            
            return raiz.ocurrenciasPosicionesPatron(patron);
        }
        return null;
    }
    
    /* 
    public void longestSubString(){
        LinkedList<String> palabras = new LinkedList<>();
        if(raiz != null){
            raiz.longestSubString(palabras);
            
            for(int i=0;i<palabras.size();i++)
                System.out.println(palabras.get(i));
            
        }
    }*/
    
    
       
     
    public int contarPal(){
        if(raiz != null){
            return raiz.contarPal();
        }
        return 0;
    }   
    
    public int alturaTrie(){
        if(raiz != null){
            return raiz.alturaTrie();
        }
        return 0;
    }

    public int contarPrefijos(){
        if(raiz != null){
            return raiz.contarPrefijos();
        }
        return 0;
    }
    
    
    
 
 
}
