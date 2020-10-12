package ut4pd7;


import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    public TAristas aristasInvertidas() {
        if (this.isEmpty()) {
            return null;
        }
        TAristas nuevasAristas = new TAristas();
        for (TArista la : this) {
            nuevasAristas.add(la.aristaInversa());
        }
        return nuevasAristas;

    }
}
