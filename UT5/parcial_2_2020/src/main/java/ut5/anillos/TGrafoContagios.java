package ut5.anillos;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public class TGrafoContagios extends TGrafoNoDirigido implements IGrafoContagio{
    
    public TGrafoContagios(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public TAnillosContagio anillosDeProbablesContagiados(String personaCOVID, int maxDistancia) {
        this.desvisitarVertices();
        TVertice origen = this.getVertices().get(personaCOVID);
        TAnillosContagio anillos = new TAnillosContagio();
        if (origen != null) {
            origen.obtenerAnillos(anillos, maxDistancia);
        }
        return anillos;
    }
    
    // #Referencia
    public TAnillosContagio anillosDeProbablesContagiadosEntreDos(String personaCOVID, int minDistancia , int maxDistancia) {
        this.desvisitarVertices();
        TVertice origen = this.getVertices().get(personaCOVID);
        TAnillosContagio anillos = new TAnillosContagio();
        if (origen != null) {
            origen.obtenerAnillosEntreDos(anillos, minDistancia, maxDistancia);
        }
        return anillos;
    }

          
    

}
