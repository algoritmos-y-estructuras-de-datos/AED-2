package uy.edu.ucu.aed2;

import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TGrafoRedDatos extends TGrafoNoDirigido implements IGrafoRedDatos {

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public LinkedList<TVertice> rutaMenosSaltos(Comparable origen, Comparable destino) {
        TVertice verticeOri = this.buscarVertice(origen);
        TVertice verticeD = null;
        LinkedList<TVertice> visitados = new LinkedList<>();
        if (verticeOri != null) {
            verticeD = verticeOri.rutaMenosSaltos(destino);
        }
        if (verticeD != null) {
            while (verticeD != null) {
                visitados.addFirst(verticeD);
                verticeD = verticeD.getPredecesor();
            }
        }
        for (TVertice v : this.getVertices().values()) {
            v.setVisitado(false);
            v.setPredecesor(null);
        }
        return visitados;
    }
}