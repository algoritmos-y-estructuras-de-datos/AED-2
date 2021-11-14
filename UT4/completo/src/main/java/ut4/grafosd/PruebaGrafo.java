package ut4.grafosd;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

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
        
    
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz Costos");

        //Recuperar caminos, un camino desde un vertice origen a un destino
        TCaminos caminolas = gd.todosLosCaminos("Porto_Alegre", "Punta_Del_Este");
        System.out.println(caminolas.imprimirCaminos());
        System.out.println(caminolas.caminoMenorCosto().imprimirEtiquetas());
        
        
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

