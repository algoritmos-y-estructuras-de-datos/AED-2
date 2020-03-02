
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        Set<Comparable> U = new HashSet<>();
        Set<Comparable> V = new HashSet<>(getVertices().keySet());

        Collection<TArista> T = new ArrayList<>();
        Comparable primero = V.iterator().next();
        U.add(primero);
        V.remove(primero);
        while (U.size() != getVertices().size()) {
            TArista aristaMin = lasAristas.buscarMin(U, V);
            T.add(aristaMin);
            U.add(aristaMin.getEtiquetaDestino());
            V.remove(aristaMin.getEtiquetaDestino());
        }

        return new TGrafoNoDirigido(getVertices().values(), T);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        Set<TArista> F = new HashSet<>();
        Set<Comparable> V = getVertices().keySet();
        HashMap<Comparable, Comparable> C = new HashMap();

        for (Comparable v : V) {
            C.put(v, v);
        }

        LinkedList<TArista> aristasOrdenadas = lasAristas.obtenerAristasOrdenadasPorCosto();

        do {
            TArista a = aristasOrdenadas.poll();
            if (!C.get(a.etiquetaOrigen).equals(C.get(a.etiquetaDestino))) {
                F.add(a);
                Comparable buscado = C.get(a.etiquetaDestino);
                Comparable reemplazo = C.get(a.etiquetaOrigen);
                for (Comparable v : C.keySet()) {
                    if (C.get(v).equals(buscado)) {
                        C.replace(v, reemplazo);
                    }
                }
            }
        } while ((new HashSet(C.values()).size() != 1));

        return new TGrafoNoDirigido(getVertices().values(), F);
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        LinkedList<TVertice> recorrido = new LinkedList<>();
        TVertice vertOrigen = this.getVertices().get(etiquetaOrigen);
        if (vertOrigen != null) {
            vertOrigen.bea(recorrido);
        }
        // Desvisito todos los vértices
        this.desvisitarVertices();
        return recorrido;
    }

    public List<TVertice> puntosDeArticulacion() {
        List<TVertice> puntos = new LinkedList<>();

        for (TVertice v : getVertices().values()) {
            if (!v.getVisitado()) {
                v.puntosDeArticulacion(puntos, new int[]{1}, null);
            }
        }

        return puntos;
    }
}
