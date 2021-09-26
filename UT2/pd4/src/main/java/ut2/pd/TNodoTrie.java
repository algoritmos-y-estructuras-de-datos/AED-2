package ut2.pd;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas =  new LinkedList<>();
    }

    @Override
    public void insertar(String unaPalabra, int pagina) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.paginas.add(pagina);
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " Paginas:  " + this.paginas.toString());

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    // "[A]rbol"
    private TNodoTrie buscarNodoTrie(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            } else {
                nodo = nodo.hijos[indice];
            }
        }
        // if (nodo.esPalabra) {
        //     return nodo;
        // }
        return nodo;
        // return null;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if(nodo != null){
            if(nodo.esPalabra == true){
                palabras.add(prefijo + s);
                System.out.println("hola");
            }
            else{
                for(int c = 0; c < CANT_CHR_ABECEDARIO; c++){
                    if(nodo.hijos[c] !=  null){
                        predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                    }
                }
            }


        }

    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie buscado = buscarNodoTrie(prefijo); //Me va a dar el punto de inflección en el arbol (Los hijos de este nodo serán los que componen la lista de palabras)
        this.predecir("", prefijo, palabras, buscado);
    }

    @Override
    public int buscar(String unaPalabra) {
        TNodoTrie nodoAux = this;
        int comparaciones = 0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            comparaciones++;
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodoAux.hijos[indice] == null) {
                return -comparaciones;
            } else {
                nodoAux = nodoAux.hijos[indice];
            }
        }
        if (nodoAux.esPalabra) {
            return comparaciones;
        }
        return -comparaciones;
    }

}