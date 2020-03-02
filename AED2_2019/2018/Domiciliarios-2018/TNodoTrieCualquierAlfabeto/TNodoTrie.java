package TA3;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    //private static final int MAX_DATOS = 2;
    
    //private static final int CANT_CHR_ABECEDARIO = 26;
    //private TNodoTrie[] hijos;
    private HashMap<Comparable, TNodoTrie> hijos;
    private boolean esPalabra;
    
    public LinkedList<LinkedList<Integer>> datos;

    public TNodoTrie() {
        //hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        hijos = new HashMap<>();
        esPalabra = false;
        datos = new LinkedList<>();
        datos.add(new LinkedList<>()); // primer lista de datos
        datos.add(new LinkedList<>()); // segunda lista de datos
        datos.get(0).add(0); // agrego valor 0 a la primera lista de datos
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            //int indice = unaPalabra.charAt(c) - 'a';
            char letra = unaPalabra.charAt(c);
            //if (nodo.hijos[indice] == null) {
            if (!nodo.hijos.containsKey(letra)) {
                //nodo.hijos[indice] = new TNodoTrie();
                System.out.println(nodo.hijos);
                nodo.hijos.put(letra, new TNodoTrie());
            }
            //nodo = nodo.hijos[indice];
            nodo = nodo.hijos.get(letra);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            //for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            for (Comparable clave : nodo.hijos.keySet()) {
                //if (nodo.hijos[c] != null) {
                    //imprimir(s + (char)(c + 'a'), nodo.hijos[c]);
                //}
                imprimir(s + clave, nodo.hijos.get(clave));
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
      private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        //for (int c = 0; c < s.length(); c++) {
        for (char letra : s.toCharArray()) {
            //int indice = unaPalabra.charAt(c) - 'a';
            //int indice = s.charAt(c) - 'a';
            if (!hijos.containsKey(letra)) {
                return null;
            }
            nodo = nodo.hijos.get(letra);
        }
        return nodo;
    }
    

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) 
    {
        TNodoTrie buscado = buscarNodoTrie(prefijo);
        this.predecir("", prefijo, palabras, buscado);
    }
      
     private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) 
     {
        if (nodo != null) {
           if (nodo.esPalabra) {
               palabras.add(prefijo + s);
               System.out.println(prefijo + s);
           }
            //for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
           for (Comparable clave : nodo.hijos.keySet()) {
                //predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                predecir(s + clave, prefijo, palabras, nodo.hijos.get(clave));
            }
        }
     }
    
    @Override
    public int buscar(String s) 
    {
        int comparaciones = 0;
        s = s.toLowerCase();
        TNodoTrie nodo = this;
        for (char letra : s.toCharArray()) {
            //int indice = c - 'a';
            //TNodoTrie nodoAux = esteNodo.hijos[indice];
            //if (nodoAux == null) {
            if (!hijos.containsKey(letra)) {
                return 0;
            }
            comparaciones++;
            nodo = nodo.hijos.get(letra);
        }
        return nodo.esPalabra ? comparaciones : 0;
    }
    
       
    
    public TNodoTrie busqueda(String unaPalabra){
        TNodoTrie nodo = this;
        //for (int c = 0; c < unaPalabra.length(); c++) {
        for (char letra : unaPalabra.toCharArray()) {
            //int indice = unaPalabra.charAt(c) - 'a';
            //if (nodo.hijos[indice] == null) {
            //    return null;
            //} else {
            //    nodo = nodo.hijos[indice];
           //}
            if (!hijos.containsKey(letra)) {
                return null;
            }
            // Me ubico en el nodo encontrado
            nodo = nodo.hijos.get(letra);
        }
        return nodo.esPalabra ? nodo : null;
    }

    [15:25, 9/16/2019] Bruno Cattaneo: con respeto a la pregunta de ocampo (también importante) sobre el orden del predecir en este código de arriba
[15:25, 9/16/2019] Bruno Cattaneo: el keySet del hashmap siempre da cualquier orden
[15:26, 9/16/2019] Bruno Cattaneo: para arreglarlo y que quede en exactamente el mismo orden del ejercicio de la UT2, se puede hacer esto en predecir:
[15:26, 9/16/2019] Bruno Cattaneo: 
TreeSet<Comparable> hijosOrdenados = new TreeSet<>(nodo.hijos.keySet());
for (Comparable clave : hijosOrdenados) {
     //predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
     predecir(s + clave, prefijo, palabras, nodo.hijos.get(clave));
 }

[15:27, 9/16/2019] Bruno Cattaneo: TreeSet admite en el constructor el hashMap, entonces ya te lo ordena
[15:27, 9/16/2019] Bruno Cattaneo: por cada nodo le ordenás sus hijos y recorrés
}
