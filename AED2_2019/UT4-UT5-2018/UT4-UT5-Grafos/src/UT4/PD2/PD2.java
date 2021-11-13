
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.PD2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import Grafos.GraphViz;
import Grafos.ManejadorArchivosGenerico;
import Grafos.TArista;
import Grafos.TGrafoDirigido;
import Grafos.TVertice;
import Grafos.UtilGrafos;
import java.util.LinkedList;



/**
 *
 * @author usuario
 */
public class PD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<TVertice> vert = new LinkedList<>();
        LinkedList<TArista> ari = new LinkedList<>();
        
        for (String a: ManejadorArchivosGenerico.leerArchivo("src/UT4/PD2/vert.txt", false)){
            try {
                TVertice v = new TVertice (a.trim());
                vert.addLast(v);
            }
            catch (Exception e){}
        }
        
        for (String a: ManejadorArchivosGenerico.leerArchivo("src/UT4/PD2/ari.txt", false)){
            try {
                String[] s = a.split(",");
                Integer n = Integer.parseInt(s[2]);
                TArista v = new TArista (s[0],s[1],n);
                ari.addLast(v);
            }
            catch (Exception e){}
        }
        
        TGrafoDirigido gd = new TGrafoDirigido(vert,ari);
        
        
        Double [][] aux2 = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(aux2, gd.getVertices(), "MATRIZ COSTOS");
        new GraphViz(vert, ari, "Grafo Dirigido", true);
        
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "MATRIZ COSTOS");
        gd.desvisitarVertices();
        System.out.println(gd.centroDelGrafo());
        gd.desvisitarVertices();
        
        for (TVertice ve : gd.getVertices().values())
        {
            System.out.println(gd.obtenerExcentricidad(ve.getEtiqueta()));
        }
    }
    
}
