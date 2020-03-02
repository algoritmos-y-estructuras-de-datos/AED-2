package Grafos;


import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante.fit
 */
public class GraphViz {
    public GraphViz(Collection<TVertice> vertices, Collection<TArista> aristas, String nombre, boolean esDirigido){
        MultiGraph graph = new MultiGraph(nombre);      
        graph.setAttribute("ui.title", nombre);
        for(TVertice v : vertices){
            Node n = graph.addNode(v.getEtiqueta().toString());
            n.addAttribute("ui.label", v.getEtiqueta().toString());
            n.addAttribute("ui.style", "text-size: 30px; text-color: red; size: 30px;");
        }
        for(TArista a : aristas){
            Edge e = graph.addEdge(a.getEtiquetaOrigen().toString()+ a.getEtiquetaDestino().toString(), a.getEtiquetaOrigen().toString(), a.getEtiquetaDestino().toString(), esDirigido);
            e.addAttribute("ui.label", String.valueOf(a.getCosto()));
            e.addAttribute("ui.style", "text-size: 30px;");            
        }
        
        Viewer display = graph.display();            
    }
}
