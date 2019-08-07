package Grafos;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante.fit
 */
public class Main {
    public static void main(String [] args){
        System.out.println("GRAFO NO DIRIGIDO");
        
        System.out.println("DibujarGrafo");
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));
        vertices.add(new TVertice("E"));
        
        
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 2));
        aristas.add(new TArista("A", "D", 7));
        //aristas.add(new TArista("B", "A", 7));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("B", "D", 2));
        aristas.add(new TArista("C", "D", 3));
        //aristas.add(new TArista("D", "A", 6));
       // aristas.add(new TArista("D", "C", 4));
        aristas.add(new TArista("D", "E", 4));
        aristas.add(new TArista("E", "B", 2));
        //aristas.add(new TArista("E", "D", 8));
        String nombre = "testDibujarGrafo";
        boolean esDirigido = false;
        new GraphViz(vertices, aristas, nombre, esDirigido);
       
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
        System.out.println("Centro del grafo: " + gnd.centroDelGrafo().toString());
        gnd.desvisitarVertices();
        System.out.println("Tiene ciclo: " + (gnd.tieneCiclo() ? "Si" : "No"));
        gnd.desvisitarVertices();
        System.out.println("Excentricidad del vértice A: " + gnd.obtenerExcentricidad("A"));
        gnd.desvisitarVertices();
        System.out.println("Excentricidad del vértice B: " + gnd.obtenerExcentricidad("B"));    
        gnd.desvisitarVertices();
        System.out.println("Recorrida bea: " + gnd.bea());
        gnd.desvisitarVertices();
        System.out.println("Recorrida bpf: " + gnd.bpf());
        gnd.desvisitarVertices();
        TCaminos todosLosCaminos = gnd.todosLosCaminos("A", "B");
        todosLosCaminos.imprimirCaminosConsola();
        
        TGrafoNoDirigido Prim = gnd.Prim();
        System.out.println("Dibujar Prim");
        new GraphViz(Prim.getVertices().values(), Prim.getLasAristas(), "Prim", false);
        TGrafoNoDirigido Kruskall = gnd.Kruskal();
        System.out.println("Dibujar Kruskall");
        new GraphViz(Kruskall.getVertices().values(), Kruskall.getLasAristas(), "Kruskall", false);
        
        Double [][] aux = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(aux, gnd.getVertices(), "MATRIZ COSTOS");
        UtilGrafos.imprimirMatrizMejorado(gnd.floyd(), gnd.getVertices(), "Matriz luego de FLOYD");
        
        LinkedList<TVertice> vert = new LinkedList<>();
        LinkedList<TArista> ari = new LinkedList<>();
        
        TVertice v0= new TVertice("a");
        TVertice v1= new TVertice("b");
        TVertice v2= new TVertice("c");
        TVertice v3= new TVertice("d");
        TVertice v4= new TVertice("e");
        
        vert.addFirst(v4);
        vert.addFirst(v3);
        vert.addFirst(v2);
        vert.addFirst(v1);
        vert.addFirst(v0);
        
        TArista a0 = new TArista("a","b",1);
        TArista a1 = new TArista("a","c",2);
        TArista a2 = new TArista("a","d",7);
        TArista a3 = new TArista("b","a",7);
        TArista a4 = new TArista("b","c",1);
        TArista a5 = new TArista("b","d",2);
        TArista a6 = new TArista("c","d",3);
        TArista a7 = new TArista("d","a",6);
        TArista a8 = new TArista("d","c",4);
        TArista a9 = new TArista("d","e",4);
        TArista a10 = new TArista("e","b",2);
        TArista a11 = new TArista("e","d",8);
        
        ari.addFirst(a11);
        ari.addFirst(a10);
        ari.addFirst(a9);
        ari.addFirst(a8);
        ari.addFirst(a7);
        ari.addFirst(a6);
        ari.addFirst(a5);
        ari.addFirst(a4);
        ari.addFirst(a3);
        ari.addFirst(a2);
        ari.addFirst(a1);
        ari.addFirst(a0);
        
        TGrafoDirigido gd = new TGrafoDirigido (vert,ari);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("GRAFO DIRIGIDO");
        
        System.out.println("Centro del grafo: " + gd.centroDelGrafo().toString());
        gd.desvisitarVertices();
        System.out.println("Tiene ciclo: " + (gd.tieneCiclo() ? "Si" : "No"));
        gd.desvisitarVertices();
        System.out.println("Excentricidad del vértice A: " + gd.obtenerExcentricidad("a"));
        gd.desvisitarVertices();
        System.out.println("Excentricidad del vértice B: " + gd.obtenerExcentricidad("b"));    
        gd.desvisitarVertices();
        System.out.println("Recorrida bea: " + gd.bea());
        gd.desvisitarVertices();
        System.out.println("Recorrida bpf: " + gd.bpf());
        gd.desvisitarVertices();
        System.out.println("Todos los caminos");
        TCaminos todosLosCaminosd = gd.todosLosCaminos("a", "b");
        todosLosCaminosd.imprimirCaminosConsola();
        
        Double [][] aux2 = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(aux2, gd.getVertices(), "MATRIZ COSTOS");
        System.out.println("");
        
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "Matriz luego de FLOYD");
        
        System.out.println("Dibujar grafo");
        new GraphViz(vert, ari, "Grafo Dirigido", true);
        
       
    }
}
