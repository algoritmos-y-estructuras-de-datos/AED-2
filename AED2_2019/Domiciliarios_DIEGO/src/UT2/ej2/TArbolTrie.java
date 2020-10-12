package UT2.ej2;


public class TArbolTrie {

    private TNodoTrie raiz;

    public void insertar(String palabra, int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, pagina);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    public TNodoTrie getRaiz(){return raiz;}
}