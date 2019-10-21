package preparacion2parcial;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
protected TAristas lasAristas = new TAristas() ;
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
        Collection<Comparable> universo = new LinkedList<>();
        Collection<Comparable> vertices = getVertices().keySet();
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(this.getVertices().values(), new TAristas());
        universo.add(getLasAristas().getFirst().getEtiquetaOrigen());
        int largo = vertices.size();
        while(universo.size()<largo){
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
            existeCamino = arbolAbarcador.todosLosCaminos(aristaMinima.etiquetaOrigen, aristaMinima.etiquetaDestino).getCaminos().size() > 0;
            if (!existeCamino) {
                arbolAbarcador.insertarArista(aristaMinima);
                arbolAbarcador.lasAristas.add(aristaMinima);
            }
        }
        return arbolAbarcador;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<TVertice> etiquetas = new LinkedList();
        TVertice verticeOrigen = this.getVertices().get(etiquetaOrigen);
        if (verticeOrigen != null){
            verticeOrigen.setBacon(0);
            verticeOrigen.bea(etiquetas);
        }
        return etiquetas;
            
    }
   

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean esConexo(){
        bea(lasAristas.getFirst().etiquetaOrigen);
        for(TVertice vertice : getVertices().values()){
            if(!vertice.getVisitado()){
                return false;
            }
        }
        return true;
    }

       
    public LinkedList<TVertice> puntosArticulacion(Comparable etiqueta){
        desvisitarVertices();
        LinkedList<TVertice> respuesta = new LinkedList<>();
        LinkedList<TVertice> visitados = new LinkedList<>();
        if(this.existeVertice(etiqueta)){
            TVertice vertice = getVertices().get(etiqueta);
            vertice.setNumBajo(1);
            vertice.numerarBP(visitados);
            desvisitarVertices();
            vertice.puntosArticulacion(vertice, respuesta);
        }
        return respuesta;

    }

    public int numBacon1(Comparable actor) {
        desvisitarVertices();
        Collection<TVertice> lista = new LinkedList<>();
        TVertice vertice = getVertices().get(actor);
        int numeroBeacon = 0;
        if (vertice != null) {
            numeroBeacon = vertice.numBacon1(lista);
        }
        return numeroBeacon;
    }

    public int numBacon2(Comparable actor) {
        for (Map.Entry<Comparable, TVertice> entradas : this.getVertices().entrySet()) {
            if (entradas.getKey().equals(actor)) {
                return entradas.getValue().getBacon();
            }
        }
        return -1;
    }
    
    public Collection<TVertice> beaBacon(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<TVertice> etiquetas = new LinkedList();
        TVertice verticeOrigen = this.getVertices().get(etiquetaOrigen);
        if (verticeOrigen != null){
            verticeOrigen.setBacon(0);
            verticeOrigen.beaBacon(etiquetas);
        }
        return etiquetas;
    }
    
    
}
