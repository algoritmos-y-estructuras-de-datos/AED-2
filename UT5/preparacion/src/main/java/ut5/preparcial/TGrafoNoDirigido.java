package ut5.preparcial;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas();

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }


    @Override
    public Collection<TVertice> bea() {
        TVertice v = this.getVertices().get(0);
        LinkedList<TVertice> lista = new LinkedList<>();
        if (v != null) {
            v.bea(lista);
        }
        return lista;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<TVertice> etiquetas = new LinkedList();
        TVertice verticeOrigen = this.getVertices().get(etiquetaOrigen);
        if (verticeOrigen != null) {
        verticeOrigen.bea(etiquetas);
        return etiquetas;
        }
        return etiquetas;

    }

    @Override
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

    @Override
    public TGrafoNoDirigido Kruskal() {
        TGrafoNoDirigido arbolAbarcador = new TGrafoNoDirigido(this.getVertices().values(), new TAristas());
        Collection<Comparable> clavesVertices = this.getVertices().keySet();
        TAristas ConjuntoSeleccion = (TAristas) this.lasAristas.clone();
        boolean existeCamino;
        TArista aristaMinima;
        while (arbolAbarcador.lasAristas.size() < this.getVertices().size() - 1) {
            aristaMinima = ConjuntoSeleccion.buscarMin(clavesVertices, clavesVertices);
            ConjuntoSeleccion.remove(aristaMinima);
            existeCamino = arbolAbarcador.todosLosCaminos(aristaMinima.etiquetaOrigen, aristaMinima.etiquetaDestino)
                    .getCaminos().size() > 0;
            if (!existeCamino) {
                arbolAbarcador.insertarArista(aristaMinima);
                arbolAbarcador.lasAristas.add(aristaMinima);
            }
        }
        return arbolAbarcador;
    }

    @Override
    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> respuesta = new LinkedList<>();
        LinkedList<TVertice> visitados = new LinkedList<>();
        if (this.existeVertice(etOrigen)) {
            TVertice vertice = getVertices().get(etOrigen);
            vertice.setNumBajo(1);
            vertice.numerarBP(visitados);
            desvisitarVertices();
            vertice.puntosArticulacion(vertice, respuesta);
        }
        return respuesta;
    }

    @Override
    public boolean esConexo() {
        bea(lasAristas.getFirst().etiquetaOrigen);
        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                return false;
            }
        }
        return true;
    }

}
