/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.PD3;

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
public class PD3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<TVertice> vert = new LinkedList<>();
        LinkedList<TArista> ari = new LinkedList<>();
        
        for (String a: ManejadorArchivosGenerico.leerArchivo("src/UT4/PD3/aeropuertos.txt", false)){
            try {
                TVertice v = new TVertice (a.trim());
                vert.addLast(v);
            }
            catch (Exception e){}
        }
        
        for (String a: ManejadorArchivosGenerico.leerArchivo("src/UT4/PD3/conexiones.txt", false)){
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
        
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "FLOYD");
        gd.desvisitarVertices();
        System.out.println(gd.centroDelGrafo());
        gd.desvisitarVertices();
        System.out.println("");
        System.out.println("Bpf DE GRAFO");
        for (TVertice a : gd.bpf()){System.out.println(a.getEtiqueta());}
        System.out.println("");
        gd.desvisitarVertices();
        System.out.println("Bpf DE GRAFO DESDE MONTEVIDEO");
        for (TVertice a : gd.bpf("Montevideo")){System.out.println(a.getEtiqueta());}
        System.out.println("");
        gd.desvisitarVertices();
        
        gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro").imprimirCaminosConsola();;
    }
    
}
