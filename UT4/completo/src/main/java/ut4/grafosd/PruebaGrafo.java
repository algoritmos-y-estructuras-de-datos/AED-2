package ut4.grafosd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PruebaGrafo {

    // public static void main(String[] args) {
    // TGrafoDirigido gd = (TGrafoDirigido)
    // UtilGrafos.cargarGrafo("UT4/clase/src/main/java/ut4/previo/aeropuertos_1.txt","UT4/clase/src/main/java/ut4/previo/conexionesPrueba.txt",
    // false, TGrafoDirigido.class);

    // // Object[] etiquetasarray = gd.getEtiquetasOrdenado();

    // Object[] etiquetasarray = gd.getEtiquetasOrdenado();

    // gd.desvisitarVertices();

    // gd.todosLosCaminos("San_Pablo", "Montevideo");

    // if (gd.tieneCiclo()) {
    // System.out.println("tiene ciclos");
    // } else {
    // System.out.println("no tiene ciclos");
    // }

    // // Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
    // // UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");

    // // Double[][] mfloyd = gd.floyd();
    // // UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego
    // de FLOYD");

    // // String vertice = "Montevideo";

    // // System.out.println(gd.centroDelGrafo());

    // // System.out.println("La excentricidad del vértice " + vertice + " es: "
    // +gd.obtenerExcentricidad(vertice));

    // // // for (int i = 0; i < etiquetasarray.length; i++) {
    // // // System.out.println("excentricidad de " + etiquetasarray[i] + " : " +
    // gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
    // // // }
    // // System.out.println();

    // // System.out.println("Centro del grafo: " + gd.centroDelGrafo());

    // }
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "UT4/completo/src/main/java/ut4/grafosd/aeropuertos_2.txt",
                "UT4/completo/src/main/java/ut4/grafosd/conexionesPrueba.txt", false, TGrafoDirigido.class);

        // Dice PD1, pero debería ser PD2, no voy a cambiar todas las ocurrencias...
        // PD1 Insertar vértices
        List<TVertice> verticespd1 = new ArrayList<>();
        verticespd1.add(new TVertice<>("Artigas"));
        verticespd1.add(new TVertice<>("Canelones"));
        verticespd1.add(new TVertice<>("Durazno"));
        verticespd1.add(new TVertice<>("Florida"));
        verticespd1.add(new TVertice<>("Montevideo"));
        verticespd1.add(new TVertice<>("Punta_del_Este"));
        verticespd1.add(new TVertice<>("Rocha"));
        // PD1 Inserar aristas
        List<TArista> aristaspd1 = new ArrayList<>();
        aristaspd1.add(new TArista("Artigas", "Rocha", 400.0));
        aristaspd1.add(new TArista("Canelones", "Artigas", 500.0));
        aristaspd1.add(new TArista("Canelones", "Colonia", 200.0));
        aristaspd1.add(new TArista("Canelones", "Duraznos", 170.0));
        aristaspd1.add(new TArista("Canelones", "Punta_del_Este", 90.0));
        aristaspd1.add(new TArista("Colonia", "Montevideo", 180.0));
        aristaspd1.add(new TArista("Florida", "Durazno", 60.0));
        aristaspd1.add(new TArista("Montevideo", "Artigas", 700.0));
        aristaspd1.add(new TArista("Montevideo", "Canelones", 30.0));
        aristaspd1.add(new TArista("Montevideo", "Punta_del_Este", 130.0));
        aristaspd1.add(new TArista("Punta_del_Este", "Rocha", 90.0));
        aristaspd1.add(new TArista("Rocha", "Montevideo", 270.0));
        aristaspd1.add(new TArista("Florida", "Durazno", 60.0));
        // Grafo pd1
        TGrafoDirigido gdpd1 = new TGrafoDirigido(verticespd1, aristaspd1);
        // Ejercicio 1 pd1
        Double[][] matrizpd1 = UtilGrafos.obtenerMatrizCostos(gdpd1.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizpd1, gdpd1.getVertices(), "Matriz PD1");
        // Ejercicio 2 pd1 costos de caminos mínimos de acuerdo al algoritmo de Floyd
        Double[][] matrizFloydpd1 = gdpd1.floyd2();
        UtilGrafos.imprimirMatrizMejorado(matrizFloydpd1, gdpd1.getVertices(), "Matriz PD1 luego de FLOYD");
        // Ejercicio 3 pd1
        Object[] etiquetasarray = gdpd1.getEtiquetasOrdenado();
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : "
                    + gdpd1.obtenerExcentricidad2((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println(gdpd1.centroDelGrafo2());
        System.out.println();
        System.out.println(
                "=======================================================================================================");
        System.out.println();

        /*
         * PD3 ejercicio 2 Implementa un algoritmo que permita conocer la conectividad
         * entre cualquier par de ciudades. El programa Java resultante deberá permitir
         * contestar interactivamente preguntas del tipo “indique si es posible volar
         * desde la ciudad x a la ciudad y”.
         */
        boolean[][] mWarshall = gd.warshall();
        UtilGrafos.imprimirMatrizBooleanos(mWarshall, gd.getVertices(), "Matriz luego de WARSHALL");
        // PD3 imprimo la matriz warshall para verificar que el resultado de lo
        // siguiente es verdad
        // HAY CONECTIVIDAD?, un camino desde un vertice origen a un destino
        System.out.println(gd.hayConexion("Flores", "Porto_Alegre"));
        

        // Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        // UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz Costos");

        // LinkedList<TVertice> lista = gd.unOrdenTopologico();
        // gd.imprimirTopologico(lista);

        // Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // // imprimir etiquetas del bpf desde Asunción....
        // for (TVertice etVert : recorrido_Asuncion) {
        // System.out.print(etVert.getEtiqueta() + " ");
        // }

        // gd.desvisitarVertices();

        // TCaminos caminos = gd.todosLosCaminos("Asuncion", "Montevideo");
        // System.out.println(caminos.imprimirCaminos());

    }
}
