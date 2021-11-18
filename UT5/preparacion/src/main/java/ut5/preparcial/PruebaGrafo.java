package ut5.preparcial;

import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {

    //     // EJERCICIO 1
    //     /**
    //      * ***********************
    //      * PROBAR FLOYD, EXCENTRICIDAD Y CENTRO DEL GRAFO
    //     ************************
    //      */
    //     TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed2/aeropuertos_1.txt", "src/main/java/uy/edu/ucu/aed2/conexiones_1.txt",
    //             false, TGrafoDirigido.class);

    //     TGrafoDirigido gd2 = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed2/aeropuertos_2.txt", "src/main/java/uy/edu/ucu/aed2/conexiones_2.txt",
    //             false, TGrafoDirigido.class);

    //     Object[] etiquetasarray = gd.getEtiquetasOrdenado();

    //     Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
    //     UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
    //     Double[][] mfloyd = gd.floyd();
    //     UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD - Grafo 1");

    //     Double[][] mfloyd2 = gd2.floyd();
    //     UtilGrafos.imprimirMatrizMejorado(mfloyd2, gd2.getVertices(), "Matriz luego de FLOYD - Grafo 2");


    //     for (int i = 0; i < etiquetasarray.length; i++) {
    //         System.out.println("Excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
    //     }
    //     System.out.println();
    //     System.out.println("Centro del grafo: " + gd.centroDelGrafo());

    //     gd.getPred();

    //     /**
    //      * ***********************
    //      * PROBAR WARSHALL **************************
    //      *
    //      * INSERTAR CODIGO PARA PROBAR WARSHALL Y MOSTRAR LA MATRIZ RESULTANTE
    //      *
    //      **************************
    //      */

    //     gd.warshall();
    //     // EJERCICIO 2
    //     /**
    //      * ***********************
    //      * PROBAR BPF DEL GRAFO, CON DISTINTOS GRAFOS
    //     **************************
    //      */
        
    //     System.out.println("\nEjercicio 2 - BPF");
    //     // Grafo 1
    //     System.out.println("\nGrafo 1 : ");
    //     Collection<TVertice> recorrido = gd.bpf();
    //     for (TVertice etVert : recorrido) {
    //         System.out.print(etVert.getEtiqueta() + " ");
    //     }
        
        
    //     // Grafo 2
    //     System.out.println("\nGrafo 2 : ");
    //     Collection<TVertice> recorrido2 = gd2.bpf();
    //     for (TVertice etVert : recorrido2) {
    //         System.out.print(etVert.getEtiqueta() + " ");
    //     }

    //     System.out.println("\nEjercicio 2 - BPF A partir de un Vertice");
    //     /**
    //      * *************************************************
    //      * PROBAR BPF DEL GRAFO, a partir de un sólo vértice
    //     **************************************************
    //      */
    //     System.out.println("\nBPF desde Asuncion Grafo 1: ");
    //     gd.desvisitarVertices();
    //     Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
    //     // imprimir etiquetas del bpf desde Asunción....
    //     for (TVertice etVert : recorrido_Asuncion) {
    //         System.out.print(etVert.getEtiqueta() + " ");
    //     }

    //     System.out.println("\nBPF desde Asuncion Grafo 2: ");
    //     gd.desvisitarVertices();
    //     Collection<TVertice> recorrido_Asuncion2 = gd2.bpf("Asuncion");
    //     // imprimir etiquetas del bpf desde Asunción....
    //     for (TVertice etVert : recorrido_Asuncion2) {
    //         System.out.print(etVert.getEtiqueta() + " ");
    //     }


    //     // probar con distintos GRAFOS y vértices de origen 

    //     // EJERCICIO 3
    //     /**
    //      * ***********************
    //      * todos los caminos
    //     **************************
    //      */
    //     TGrafoDirigido gdcaminos = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed2/aeropuertosPROYECTO.txt", "src/main/java/uy/edu/ucu/aed2/conexionesPROYECTO.txt",
    //             false, TGrafoDirigido.class);
    //     gd.desvisitarVertices();
    //     // TCaminos caminos = gdcaminos.todosLosCaminos("ATL", "JAX");
    //     TCaminos caminos = gd.todosLosCaminos("Asuncion", "Porto_Alegre");
    //     // System.out.println(gdcaminos.tieneCiclo());
    //     System.out.println(gd.tieneCiclo());
    //     caminos.imprimirCaminosConsola();
    //     System.out.println("Camino critico: " + caminos.caminoMayorCosto());
    //     caminos.caminoMayorCosto().imprimirEtiquetasConsola();
        
    //      /***********************
    //      * camino crítico
    //     **************************/
    //     /*
    //      ver la letra del ejercicio 3, elegir dos aeropuertos del grafo aeropuertosPROYECTO1 y buscar el camino crítico entre los mismos. 
    //      SUGERENCIA: probar primero con un grafo pequeño, dibujado. 
    //      */
         
    //     /***********************
    //      * ciclos
    //     **************************/
    //    // Dados los archivos “conexiones_2.txt” y “aeropuertos_2.txt”, ejecutar el programa e indicar si el grafo resultante contiene ciclos o no. 
         
    //     /***********************
    //      * unOrdenTopologico
    //     **************************/
        
    //     /* implementar los métodos para, dado un grafo y un vértice del mismo, obtener una ordenación topológica
        
    //     Cargar el grafo utilizado en la presentación del curso y ejecutar el método para el 
    //     vértice C5
    //     */

        TGrafoNoDirigido grafitoNoDirigidito = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("UT5/preparacion/src/main/java/ut5/preparcial/aeropuertosGND.txt", "UT5/preparacion/src/main/java/ut5/preparcial/conexionesGND.txt",
                false, TGrafoNoDirigido.class);


        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafitoNoDirigidito.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafitoNoDirigidito.getVertices(), "Matriz costos");
        UtilGrafos.imprimirMatrizMejorado(matriz, grafitoNoDirigidito.getVertices(), "Matriz costos");

        grafitoNoDirigidito.floyd();


        grafitoNoDirigidito.bea("Buenos_Aires");

        
        
    }
}
