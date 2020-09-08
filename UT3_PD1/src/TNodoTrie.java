
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int MAX_DATOS = 2;

    private static final int CANT_CHR_ABECEDARIO = 26;
    //private static final char[] abc = new char[]{'a', 'c', 'g', 't'};
    private HashMap<Character, TNodoTrie> hijos;
    private boolean esPalabra;
    //private int inicio;
    public LinkedList<LinkedList<Integer>> datos;

    public TNodoTrie() {
        hijos = new HashMap();
        esPalabra = false;
        datos = new LinkedList<>();
        datos.add(new LinkedList<>());
        datos.add(new LinkedList<>());
        datos.get(0).add(0);
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character character = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(character)) {
                nodo.hijos.put(character, new TNodoTrie());
            }
            nodo = nodo.hijos.get(character);
        }
        nodo.esPalabra = true;
        //nodo.setPosicion(posicion);
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (Object indice : nodo.hijos.keySet()){
                char caracter = (char)indice;
                imprimir (s+caracter,(TNodoTrie)nodo.hijos.get(caracter));
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {

            if (!nodo.hijos.containsKey(s.charAt(c))) {
                return null;
            }
            nodo = nodo.hijos.get(s.charAt(c));
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
         if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            for (Character caracter : nodo.hijos.keySet()) {
                if (nodo.hijos.get(caracter) != null) {
                    predecir(s + caracter, prefijo, palabras, nodo.hijos.get(caracter));
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie buscado = buscarNodoTrie(prefijo);
        this.predecir("", prefijo, palabras, buscado);
    }

    @Override
    public int buscar(String s) {

        int comparaciones = 0;
        s = s.toLowerCase();
        TNodoTrie esteNodo = this;
        for (char c : s.toCharArray()) {
            //int indice = c - 'a';
            TNodoTrie nodoAux = esteNodo.hijos.get(c);
            if (nodoAux == null) {
                return 0;
            }
            comparaciones++;
            esteNodo = nodoAux;
        }
        return esteNodo.esPalabra ? comparaciones : 0;
    }

    public TNodoTrie busqueda(String unaPalabra) {
        TNodoTrie nodo = this;
//        int comparaciones = 0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (!nodo.hijos.containsKey(unaPalabra.charAt(c))) {
                return null;
            } else {
//                comparaciones++;
                nodo = nodo.hijos.get(unaPalabra.charAt(c));
            }
        }
        if (nodo.esPalabra) {
//            return comparaciones;
            return nodo;
        } else {
//            return 0;
            return null;
        }
    }

}
