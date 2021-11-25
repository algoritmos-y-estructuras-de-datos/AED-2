package ut5.panceta;

import java.util.Collection;

public class GrafosNoDirigidosMain {
    public static void main(String[] args) {
        TGrafoNoDirigido gd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed2/verticesBEA.txt", "src/main/java/uy/edu/ucu/aed2/aristasBEA.txt",
                false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "MATRIZ COSTOS");

        TGrafoNoDirigido arbolMinimo = gd.Prim2();
        
        Double[][] matrizPrim = UtilGrafos.obtenerMatrizCostos(arbolMinimo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizPrim, arbolMinimo.getVertices(), "MATRIZ COSTOS LUEGO DE PRIM");

        gd.desvisitarVertices();
        Collection<TVertice> profundidad = gd.bpf("a");
        for(TVertice aux : profundidad){
            System.out.println(aux.getEtiqueta());
        }
        
        // el desvisitar lo tenemos uqe poner en los metodos del grafo

        gd.desvisitarVertices();
        gd.bea();

        
    }
}
