package ut5.pd3;

import java.util.Collection;

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

}