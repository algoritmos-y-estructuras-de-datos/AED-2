package preparacion2parcial;


import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {

        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/preparacion2parcial/aeropuertos_1.txt", "./src/preparacion2parcial/conexiones_1.txt",
                false, TGrafoDirigido.class);        
        
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        
        boolean[][] mWarshall = gd.warshall();
        UtilGrafos.imprimirMatrizBooleanos(mWarshall, gd.getVertices(), "Matriz luego de WARSHALL");
        
        
        
        System.out.println("Recorrido ASUNCION");
        System.out.println(" ");
        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        for(Object vertice: recorrido_Asuncion){
            TVertice aux = (TVertice)vertice;
            System.out.println(aux.getEtiqueta());
        }
        System.out.println("------------");
        System.out.println("Santos a San Pablo");
        System.out.println(" ");
        TCaminos caminos = gd.todosLosCaminos("Santos", "San_Pablo");
        caminos.imprimirCaminosConsola();
        System.out.println("------------");
        System.out.println("Montevideo a Rio de Janeiro");
        System.out.println(" ");
        caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        caminos.imprimirCaminosConsola();
        
        
        Comparable aeropuerto = "Curitiba";
        System.out.println("------------");
        System.out.println("Calculo de excentricidad de "+aeropuerto);
        System.out.println(" ");
        Comparable ex = gd.obtenerExcentricidad(aeropuerto);
        System.out.println("Exectricidad de " + aeropuerto + " es:" + ex);
        
        Comparable aeropuerto2 = "Montevideo";
        System.out.println("------------");
        System.out.println("Calculo de excentricidad de "+aeropuerto);
        System.out.println(" ");
        Comparable ex2 = gd.obtenerExcentricidad(aeropuerto2);
        System.out.println("Exectricidad de " + aeropuerto2 + " es:" + ex2);
        
        System.out.println("--------------");
        System.out.println("Calculo de centro del grafo");
        System.out.println(" ");
        Comparable centro = gd.centroDelGrafo();
        
        System.out.println(centro);
        
        Double[] dijkstra =  gd.dijkstra("Asuncion");
        for (int i = 0; i < dijkstra.length; i++) {
            System.out.println(dijkstra[i]);
        }
    }
}
