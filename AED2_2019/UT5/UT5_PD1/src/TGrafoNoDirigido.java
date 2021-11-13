
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoRedElectrica {

    //private TListaAristas Aristas;
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
    public TAristas mejorRedElectrica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cargarArista(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Comparable costo) {
        lasAristas.add(new TArista(etiquetaOrigen, etiquetaDestino, (double) costo));

        insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
    }

    // este procedimiento de PRIM usa la lista de aristas expl�cita para
    // resolver. Por claridad y seguridad, se arman listas de v�rtices para
    // trabajar,
    // "VerticesU" y "VerticesV", de forma de hacerlo lo m�s parecido posible al
    // seudoc�digo abstracto.
    // al final devuelve un nuevo grafo no dirigido que es el �rbol abarcador de
    // costo m�nimo obtenido.
    public TGrafoNoDirigido Prim() {
        Collection<Comparable> universo = new LinkedList<>();
        Collection<Comparable> vertices = getVertices().keySet();
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(this.getVertices().values(), new TAristas());
        universo.add(getLasAristas().getFirst().getEtiquetaOrigen());
        int largo = vertices.size();
        while (universo.size() < largo) {
            vertices.removeAll(universo);
            TArista arista = lasAristas.buscarMin(universo, vertices);
            universo.add(arista.getEtiquetaDestino());
            grafo.insertarArista(arista);
            grafo.lasAristas.add(arista);
        }
        return grafo;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean insertarAdyacencia(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Comparable costo) {
        return (super
                .insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo) && super
                .insertarAdyacencia(etiquetaDestino, etiquetaOrigen, costo));
    }

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

                Comparable lookFor = C.get(a.etiquetaDestino);
                Comparable replaceWith = C.get(a.etiquetaOrigen);
                for (Comparable v : C.keySet()) {
                    if (C.get(v).equals(lookFor)) {
                        C.replace(v, replaceWith);
                    }
                }
            }
        } while ((new HashSet(C.values()).size() != 1));

        return new TGrafoNoDirigido(getVertices().values(), F);
    }

}
