
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap {

    private final HashMap<Character,TNodoTrieHashMap> hijos;
    private boolean esPalabra;
    private int posicion;

    public boolean isEsPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public TNodoTrieHashMap() {
        hijos       = new HashMap<>();
        esPalabra   = false;
        posicion = -1;
    }

   
      public void insertar(String unaPalabra, int posicion) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character character = unaPalabra.charAt(c);
            /* COMPLETAR CODIGO  {
               COMPLETAR CODIGO ;
            }*/
            nodo = nodo.hijos.get(character);
        }
        nodo.setEsPalabra(true);
        nodo.setPosicion(posicion);
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " " + nodo.getPosicion());
            }
            
            for (Character caracter : nodo.hijos.keySet())
                if (nodo.hijos.get(caracter) != null) {
                    imprimir(s + caracter, nodo.hijos.get(caracter));
                }
            }
        }

    public void imprimir(){
        imprimir("", this);
    }

    
        private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            for (Character caracter : nodo.hijos.keySet()){
                if (nodo.hijos.get(caracter) != null) {
                    predecir(s + caracter, prefijo, palabras, nodo.hijos.get(caracter));
                }
            }
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        predecir("", prefijo, palabras, nodo);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            Character character = s.charAt(c);
            if (nodo.hijos.get(character) == null) {
                return null;
            }
            nodo = nodo.hijos.get(character);
        }
        return nodo;
    }
     private void posicionesPatron(String patron, ArrayList<Integer> posiciones, TNodoTrieHashMap nodo) {
        // TODO completar
        
    }

    public void posicionesPatron(String patron, ArrayList<Integer> posiciones) {
         //TODO completar
        
    }
}
