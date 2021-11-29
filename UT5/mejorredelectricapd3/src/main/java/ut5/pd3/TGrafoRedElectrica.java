package ut5.pd3;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ocampee
 */
public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    int costoTotal;
    int costoTotalKruskal;

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
        this.costoTotal = costoPrim;
        
        this.desvisitarVertices();
        return new TGrafoNoDirigido(this.getVertices().values(), aristasElegidas).getLasAristas();
    }

    
    public TAristas mejorRedElectricaKruskal() {
        this.desvisitarVertices();
        int costoKruskal = 0;
        Set<TArista> F = new HashSet<>();
        Set<Comparable> V = getVertices().keySet();
        HashMap<Comparable, Comparable> C = new HashMap();

        for (Comparable v : V) {
            C.put(v, v);
        }

        LinkedList<TArista> aristasOrdenadas = lasAristas.obtenerAristasOrdenadasPorCosto();

        do {
            TArista a = aristasOrdenadas.poll();
            
            if (!C.get(a.getEtiquetaOrigen()).equals(C.get(a.getEtiquetaDestino()))) {
                F.add(a);
                costoKruskal += a.getCosto();
                Comparable buscado = C.get(a.getEtiquetaDestino());
                Comparable reemplazo = C.get(a.getEtiquetaOrigen());
                for (Comparable v : C.keySet()) {
                    if (C.get(v).equals(buscado)) {
                        C.replace(v, reemplazo);
                        
                    }
                }
            }
        } while ((new HashSet(C.values()).size() != 1));
        this.costoTotalKruskal = costoKruskal;
        return new TGrafoNoDirigido(getVertices().values(), F).getLasAristas();
    }

}