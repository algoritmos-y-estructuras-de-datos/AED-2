
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int MAX_DATOS = 2;

    //private static final int CANT_CHR_ABECEDARIO = 26;
    private static final char[] abc = new char[]{'a', 'c', 'g', 't'};
    private HashMap<Comparable, TNodoTrie> hijos;
    private boolean esPalabra;
    private int inicio;
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
            
            if (!nodo.hijos.containsKey(unaPalabra.charAt(c))) {
                nodo.hijos.put(unaPalabra.charAt(c), new TNodoTrie());
                System.out.println(nodo.hijos.get(c));
            }
            nodo = nodo.hijos.get(unaPalabra.charAt(c));
        }
        nodo.esPalabra = true;
        nodo.inicio = inicio;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < 4; c++) {
                if (nodo.hijos.containsKey(abc[c])) {
                    imprimir(s + abc[c], nodo.hijos.get(abc[c]));
                }
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
                System.out.println(prefijo + s);
            }

           for (int c = 0; c < 26; c++) {
                if (nodo.hijos.get(c) != null) {
                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos.get(c));
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
