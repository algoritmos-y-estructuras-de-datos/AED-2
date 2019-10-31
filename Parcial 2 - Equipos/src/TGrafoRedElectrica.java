
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ocamp
 */
public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    /**
     * Adaptación del algoritmo de Prim
     * @return TAristas
     */
    @Override
    public TAristas mejorRedElectrica() {
        int costoPrim = 0;
        if (this.getVertices().size() == 0) {
            return new TAristas();
        } else if (this.lasAristas.size() < this.getVertices().size() - 1) {
            return null;
        }
        TreeMap<Comparable, TVertice> VerticesU = new TreeMap<>();
        TreeMap<Comparable, TVertice> VerticesV = new TreeMap<Comparable, TVertice>(this.getVertices());
        TreeSet<TAristas> AristasAAM = new TreeSet<TAristas>();
        TArista tempArista;
        if (this.getVertices().isEmpty()) {
            return null;
        }
        LinkedList<TArista> aristasElegidas = new LinkedList<>();
        Map.Entry<Comparable, TVertice> tempV = VerticesV.firstEntry();
            VerticesV.pollFirstEntry();
            VerticesU.put(tempV.getKey(),tempV.getValue());
        
        while (!VerticesV.isEmpty()) {
            TArista arista = lasAristas.buscarMin(VerticesU.keySet(), VerticesV.keySet());
            costoPrim += arista.getCosto(); 
            TVertice vert = VerticesV.remove(arista.getEtiquetaDestino());
            if(vert == null){
                vert = VerticesV.remove(arista.getEtiquetaOrigen());
            }
            VerticesU.put(vert.getEtiqueta(),vert);
            aristasElegidas.add(arista);
        }
        
        this.desvisitarVertices();
        return new TGrafoNoDirigido(this.getVertices().values(), aristasElegidas).getLasAristas();
    }
    
    /**
     * Adaptación del algoritmo de Kruskal
     * @return TAristas
     */
    public TAristas mejorRedElectrica_kruskal() {
        int costoTotal= 0;
        
        if (this.getVertices().size() == 0) {
            return new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>()).getLasAristas();
        } else if (this.lasAristas.size() < this.getVertices().size() - 1) {
            return null;
        }
        PriorityQueue<TArista> aristasEnOrden = new PriorityQueue<>(lasAristas.size(), Comparator.comparingDouble(TArista::getCosto));
        TGrafoNoDirigido aam = new TGrafoNoDirigido(this.getVertices().values(), new LinkedList<>());

        HashMap<Comparable, Comparable> padre = new HashMap<>(this.getVertices().size());
        for (Comparable et : this.getVertices().keySet()) {
            padre.put(et, et);
        }
        aristasEnOrden.addAll(lasAristas);
        LinkedList<TArista> aristasElegidas = new LinkedList<>();
        while (!aristasEnOrden.isEmpty()) {
            TArista arista = aristasEnOrden.remove();
            
            Comparable raizOrigen = "";
            Comparable vertAux = arista.etiquetaOrigen;
            while (padre.get(vertAux) != null && padre.get(vertAux).compareTo(vertAux) != 0) {
                vertAux = padre.get(vertAux);
            }
            raizOrigen = vertAux;
            
            Comparable raizDestino = "";
            vertAux = arista.etiquetaDestino;
            while (padre.get(vertAux) != null && padre.get(vertAux).compareTo(vertAux) != 0) {
                vertAux = padre.get(vertAux);
            }
            raizDestino = vertAux;
            
            if (raizOrigen.compareTo(raizDestino) == 0) {
                continue;
            } else {
                costoTotal+=arista.getCosto();
                aristasElegidas.add(arista);
                padre.put(raizDestino, raizOrigen);
            }

            if (aristasElegidas.size() == this.getVertices().size() - 1) {
                this.desvisitarVertices();
                return new TGrafoNoDirigido(this.getVertices().values(), aristasElegidas).getLasAristas();
            }
        }
        this.desvisitarVertices();
        return null;
    }
    
}