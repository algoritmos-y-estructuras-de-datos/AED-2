package ut5.parcial2;

import java.util.ArrayList;
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

        this.desvisitarVertices();
        LinkedList<TVertice> puntos = new LinkedList<>();
        int[] cont = {0};
        TVertice verticeOrigen = this.getVertices().get(etOrigen);
        if (verticeOrigen != null) {
            verticeOrigen.puntoArticulacion(puntos, cont);
        }
        return puntos;
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

    // public LinkedList<TVertice> calculoEnlaces(Comparable etiquetaOrigen,int separacionMax){
    //     this.desvisitarVertices();

    //     LinkedList<TVertice> verticesVisitados = new LinkedList<>();
    //     TVertice verticeOrigen =  this.getVertices().get(etiquetaOrigen);
    //     if(verticeOrigen != null){
    //         verticeOrigen.calculoEnlaces(verticesVisitados, separacionMax);
    //     }
    //     return verticesVisitados;
    // }

    public Collection<TVertice> listarContactos(String nombreActor, int maxSaltos) {
        TVertice origen = this.getVertices().get(nombreActor);
        Collection<TVertice> visitados = new ArrayList<>();
        if (origen != null)
        {
            origen.listarContactos(visitados, maxSaltos);
        }
        return visitados;
    }

    

}
