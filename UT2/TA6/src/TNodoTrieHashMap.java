
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements INodoTrie {

    private static final int MAX_DATOS = 2;

    private static final int CANT_CHR_ABECEDARIO = 26;
    private HashMap<Comparable, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public LinkedList<LinkedList<Integer>> datos;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
        datos = new LinkedList<>();
        datos.add(new LinkedList<>());
        datos.add(new LinkedList<>());
        datos.get(0).add(0);
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {

            if (!nodo.hijos.containsKey(unaPalabra.charAt(c))) {
                nodo.hijos.put(unaPalabra.charAt(c), new TNodoTrieHashMap());
                //System.out.println(nodo.hijos.get(c));
            }
            nodo = nodo.hijos.get(unaPalabra.charAt(c));
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < 4; c++) {
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {

            if (!nodo.hijos.containsKey(s.charAt(c))) {
                return null;
            }
            nodo = nodo.hijos.get(s.charAt(c));
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
                System.out.println(prefijo + s);
            }

           for (int c = 0; c < palabras.size(); c++) {
                if (!nodo.hijos.containsKey(c)) {
                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos.get(c));
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap buscado = buscarNodoTrie(prefijo);
        this.predecir("", prefijo, palabras, buscado);
    }

    @Override
    public int buscar(String s) {

        int comparaciones = 0;
        s = s.toLowerCase();
        TNodoTrieHashMap esteNodo = this;
        for (char c : s.toCharArray()) {
            //int indice = c - 'a';
            TNodoTrieHashMap nodoAux = esteNodo.hijos.get(c);
            if (nodoAux == null) {
                return 0;
            }
            comparaciones++;
            esteNodo = nodoAux;
        }
        return esteNodo.esPalabra ? comparaciones : 0;
    }

    public TNodoTrieHashMap busqueda(String unaPalabra) {
             TNodoTrieHashMap nodo = this;
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
