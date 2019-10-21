/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacion2parcial;

import java.util.Collection;

/**
 *
 * @author Meki
 */
public class Preparacion2parcialGD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/preparacion2parcial/aeropuertos_1.txt", "./src/preparacion2parcial/conexiones_1.txt",
                false, TGrafoDirigido.class);
        
        System.out.println("****************************MATRICES****************************");
        System.out.println("COSTOS");
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz de COSTOS");               
        System.out.println("FLOYD");       
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        System.out.println("WARSHALL"); 
        boolean[][] mWarshall = gd.warshall();
        UtilGrafos.imprimirMatrizBooleanos(mWarshall, gd.getVertices(), "Matriz luego de WARSHALL");
        
        
        System.out.println("****************************CALCULOS DE EXCENTRICIDAD****************************"); 
        Comparable exAsuncion = gd.obtenerExcentricidad("Asuncion");
        Comparable exCuri = gd.obtenerExcentricidad("Curitiba");
        Comparable exBsAs = gd.obtenerExcentricidad("Buenos_Aires");
        Comparable exFlo = gd.obtenerExcentricidad("Florianopolis");
        Comparable exMvd = gd.obtenerExcentricidad("Montevideo");
        Comparable exPa = gd.obtenerExcentricidad("Porto_Alegre");
        Comparable exRio = gd.obtenerExcentricidad("Rio_de_Janeiro");
        Comparable exSa = gd.obtenerExcentricidad("San_Pablo");
        Comparable exSantos = gd.obtenerExcentricidad("Santos");
        System.out.println("Exectricidad de Buenos_Aires" + " es:" + exBsAs);
        System.out.println("Exectricidad de Curitiba" + " es:" + exCuri);
        System.out.println("Exectricidad de Florianopolis" + " es:" + exFlo);
        System.out.println("Exectricidad de Montevideo" + " es:" + exMvd);
        System.out.println("Exectricidad de Porto_Alegre" + " es:" + exPa);
        System.out.println("Exectricidad de Rio_de_Janeiro" + " es:" + exRio);
        System.out.println("Exectricidad de San_Pablo" + " es:" + exSa);
        System.out.println("Exectricidad de Santos" + " es:" + exSantos);
        System.out.println("Exectricidad de Asuncion" + " es:" + exAsuncion);
        
        
        System.out.println("****************************CALCULOS DE CENTRO DE GRAFO****************************");
        Comparable centro = gd.centroDelGrafo();
        System.out.println(centro);
        
        
        System.out.println("****************************CALCULOS DE DIJKSTRA****************************");
        Double[] dijkstra =  gd.dijkstra("Montevideo");
        for (int i = 0; i < dijkstra.length; i++) {
            System.out.println("dijkstra desde Montevideo "+dijkstra[i]);
        }
        Double[] dijkstraP =  gd.dijkstra("Porto_Alegre");
        for (int i = 0; i < dijkstraP.length; i++) {
            System.out.println("DijKstra desde Porto_Alegre "+dijkstraP[i]);
        }
        Double[] dijkstraC =  gd.dijkstra("Curitiba");
        for (int i = 0; i < dijkstraC.length; i++) {
            System.out.println("Dijkstra desde Curitiba "+dijkstraC[i]);
        }
        
        System.out.println("****************************CALCULOS DE TODOS LOS CAMINOS****************************");
        System.out.println("Santos a San Pablo");
        System.out.println(" ");
        TCaminos caminos = gd.todosLosCaminos("Santos", "San_Pablo");
        caminos.imprimirCaminosConsola();
        System.out.println("------------");
        System.out.println("Montevideo a Rio de Janeiro");
        System.out.println(" ");
        caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        caminos.imprimirCaminosConsola();
        
        System.out.println("****************************CALCULOS DE RECORRIDOS BPF****************************");
        Collection recorrido = gd.bpf();
        System.out.println("Recorrido BPF :");
        for(Object vertice: recorrido){
            TVertice aux = (TVertice)vertice;
            System.out.println(aux.getEtiqueta());
        }
        System.out.println("");
        Collection recorridoMvd = gd.bpf("Montevideo");
        System.out.println("Recorrido BPF desde Montevideo:");
        for(Object vertice: recorridoMvd){
            TVertice aux = (TVertice)vertice;
            System.out.println(aux.getEtiqueta());
        }
        
        System.out.println("****************************CALCULOS SI TIENE CICLO****************************");
        System.out.println("gd tiene ciclo? :"+gd.tieneCiclo());
        
        System.out.println("****************************CALCULOS ORDEN TOPOLOGICO****************************");
        System.out.println("");
        
                TGrafoDirigido gdInvertido = (TGrafoDirigido) UtilGrafos.cargarGrafoInvertido(
                "./src/preparacion2parcial/asignaturas.txt", 
                "./src/preparacion2parcial/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        TGrafoDirigido gdasignatura = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/preparacion2parcial/asignaturas.txt", 
                "./src/preparacion2parcial/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        System.out.println("ORDEN TOPOLOGICO");
        
        System.out.println("Asignaturas");
        gdasignatura.imprimirTopologico(gdasignatura.ordenTopologico());
        System.out.println("Grafo invertido");
        gdInvertido.imprimirTopologico(gdInvertido.ordenTopologico());
        System.out.println(" ");
        System.out.println("ORDEN PREVIATURAS");
        Comparable etiqueta = "PROYECTO";
        TVertice asigantura = gdInvertido.buscarVertice(etiqueta);
        gdInvertido.ordenPreviaturas(asigantura);
    }
    
    
    
}
