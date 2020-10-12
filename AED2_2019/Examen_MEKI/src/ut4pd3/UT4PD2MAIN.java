package ut4pd3;


import java.util.Collection;

public class UT4PD2MAIN {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/UT4PD2/aeropuertos_1.txt","src/UT4PD2/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        //Double[][] mfloyd = gd.floyd();
        boolean [][] mWarshall = gd.warshall();
       
        UtilGrafos.imprimirMatrizBooleanos(mWarshall, gd.getVertices(), "Matriz luego de WARSHALL");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println( gd.centroDelGrafo());
        
       
        

       
       
    }
}
