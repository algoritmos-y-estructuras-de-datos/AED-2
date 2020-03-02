

import java.util.ArrayList;
import java.util.LinkedList;

public class TNodoTrie {
    public static final int CANT_CHR_ADN = 4;
    public TNodoTrie[] hijos;
    public boolean esPalabra;
    public ArrayList paginas;
    public int profundidad;
    
    public TNodoTrie(){
        hijos = new TNodoTrie[CANT_CHR_ADN];
        esPalabra = false;
        paginas = new ArrayList();
        profundidad = 0;
    }
    
    public void insertar(String unaPalabra){
        TNodoTrie nodo = this;
        int contador = 0;
        for (int c = 0; c < unaPalabra.length(); c++){  
            contador++;
            int indice = existeLetra(unaPalabra.charAt(c));
            if (indice!=-1){
                if (nodo.hijos[indice] == null){
                    nodo.hijos[indice] = new TNodoTrie();
                }
                nodo = nodo.hijos[indice];
            }
            
        }
        nodo.esPalabra = true;
        nodo.profundidad = contador;
    }
    
    public int existeLetra(char c){
        switch (c) {
                case 'a':                           
                         return 0;
                case 'c':  
                         return 1;
                case 'g': 
                         return 2;
                case 't':
                         return 3;
                default:
                         return -1;
                }
    }
    /*
    public void insertar(String unaPalabra, int pagina){
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++){
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null){
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        paginas.add(pagina);
    }
    
    */
    public char devolverLetra (int posicion){
        switch (posicion){
                case 0:                           
                         return 'a';
                case 1:  
                         return 'c';
                case 2: 
                         return 'g';
                case 3:
                         return 't';
                default:
                         return '-';
                }
    }
    
    private void imprimir(String s, TNodoTrie nodo){
        if (nodo != null){
            if (nodo.esPalabra){
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ADN; c++){
                if (nodo.hijos[c] != null){
                    
                    imprimir(s + (char) (devolverLetra(c)), nodo.hijos[c]);
                }
            }
        }        
    }
    
    public void imprimir(){
        this.imprimir("", this);
    }
    
    public boolean buscar (String palabra){
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            int indice = existeLetra(palabra.charAt(c));
            if (indice!= -1){
                TNodoTrie aux = nodo.hijos[indice];
                if(aux == null) {
                    return false;
                }
                nodo = aux;
            }
            else{
                return false;
            }
        }
        return nodo.esPalabra;
    }
    
    /**
     *
     * @param palabra
     * @return
     */
    public ArrayList buscarPaginas(String palabra){
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            int indice = palabra.charAt(c) - 'a';
            TNodoTrie aux = nodo.hijos[indice];
            if(aux == null) {
                return null;
            }
            nodo = aux;
        }
        return nodo.paginas;
    }
    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = this;
        for (int c = 0; c < prefijo.length(); c++){
            int indice = existeLetra(prefijo.charAt(c));
            TNodoTrie aux = nodo.hijos[indice];
            if (aux != null) {
                nodo = aux;
            } 
            else{
                return ;
            }
        }
        traerTodos(prefijo, palabras, nodo);
    }
    
    private void traerTodos(String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo.esPalabra){
            palabras.add(prefijo);
        }
        for (int c = 0; c < 4; c++){
            if (nodo.hijos[c] != null){
                char letra = (char) (devolverLetra(c));
                traerTodos(prefijo + letra, palabras, nodo.hijos[c]);
            }
        }  
    }
    
    public TNodoTrie buscarPatron (String palabra){
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            int indice = existeLetra(palabra.charAt(c));
            if (indice!= -1){
                TNodoTrie aux = nodo.hijos[indice];
                if(aux == null) {
                    return null;
                }
                nodo = aux;
            }
            else{
                return null;
            }
        }
        return nodo;
    }
    
    public void buscarExistenciaPatron (String s, Integer[] contador,LinkedList<Integer> posicion){
        TNodoTrie nodo = buscarPatron(s);
        if (nodo!=null){
            buscarRepeticiones (nodo, contador,posicion);
        }
    }
    
    public void buscarRepeticiones (TNodoTrie nodo, Integer[] contador, LinkedList<Integer> posicion){
        if (nodo!=null){
            if (nodo.esPalabra){
                contador[0]++;
                posicion.add(nodo.profundidad);
            }
            for (int c = 0; c < CANT_CHR_ADN; c++) {
                if (nodo.hijos[c] != null){
                    buscarRepeticiones (nodo.hijos[c],contador,posicion);
                }
            }
        }
    }
}
