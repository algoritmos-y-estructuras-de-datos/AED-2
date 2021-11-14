package ut4.grafosd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PruebaGrafo {

    // public static void main(String[] args) {
    //     TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("UT4/clase/src/main/java/ut4/previo/aeropuertos_1.txt","UT4/clase/src/main/java/ut4/previo/conexionesPrueba.txt",
    //             false, TGrafoDirigido.class);

    //     // Object[] etiquetasarray = gd.getEtiquetasOrdenado();


    //     Object[] etiquetasarray = gd.getEtiquetasOrdenado();

   
    //     gd.desvisitarVertices();

    //     gd.todosLosCaminos("San_Pablo", "Montevideo");
   
    //     if (gd.tieneCiclo()) {
    //         System.out.println("tiene ciclos");
    //     } else {
    //         System.out.println("no tiene ciclos");
    //     }
        
    //     // Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
    //     // UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        
    //     // Double[][] mfloyd = gd.floyd();
    //     // UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");

    //     // String vertice = "Montevideo";

    //     // System.out.println(gd.centroDelGrafo());

    //     // System.out.println("La excentricidad del vértice " + vertice + " es: " +gd.obtenerExcentricidad(vertice));
        
    //     // // for (int i = 0; i < etiquetasarray.length; i++) {
    //     // //     System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
    //     // // }
    //     // System.out.println();
        
    //     // System.out.println("Centro del grafo: " + gd.centroDelGrafo());
       
       
    // }
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("UT4/completo/src/main/java/ut4/grafosd/aeropuertos_2.txt", "UT4/completo/src/main/java/ut4/grafosd/conexionesPrueba.txt",
                false, TGrafoDirigido.class);
        
        

        //PD1 Insertar vértices
        List<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice<>("Artigas"));
        vertices.add(new TVertice<>("Canelones"));
        vertices.add(new TVertice<>("Durazno"));
        vertices.add(new TVertice<>("Florida"));
        vertices.add(new TVertice<>("Montevideo"));
        vertices.add(new TVertice<>("Punta_del_Este"));
        vertices.add(new TVertice<>("Rocha"));
        
        /*PD1 Inserar aristas: Artigas, Rocha, 400; Canelones, Artigas, 500; Canelones, Colonia, 200; Canelones, Durazno, 170; Canelones, 
        Punta del Este, 90; Colonia, Montevideo, 180; Florida, Durazno, 60; Montevideo, Artigas, 700; Montevideo, 
        Canelones, 30; Montevideo, Punta del Este, 130; Punta del Este, Rocha, 90; Rocha, Montevideo, 270; Florida, 
        Durazno, 60*/
        List<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("Artigas", "Rocha", 400));
        
        
        
        
        TGrafoDirigido gdpd1 = new TGrafoDirigido(vertices, aristas);


       

        //Recuperar caminos, un camino desde un vertice origen a un destino
        TCaminos caminolas = gd.todosLosCaminos("Porto_Alegre", "Punta_Del_Este");
        System.out.println(caminolas.imprimirCaminos());
        System.out.println(caminolas.caminoMenorCosto().imprimirEtiquetas());
        

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz Costos");
        
        // LinkedList<TVertice> lista = gd.unOrdenTopologico();
        // gd.imprimirTopologico(lista);

        // Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // // imprimir etiquetas del bpf desde Asunción....
        // for (TVertice etVert : recorrido_Asuncion) {
        //     System.out.print(etVert.getEtiqueta() + " ");
        // }

        // gd.desvisitarVertices();
        
        // TCaminos caminos = gd.todosLosCaminos("Asuncion", "Montevideo");
        // System.out.println(caminos.imprimirCaminos());

    }
}

