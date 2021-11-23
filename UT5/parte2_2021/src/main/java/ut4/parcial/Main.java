package ut4.parcial;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido grafitoNoDirigidito = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("UT5/parte2_2021/src/main/java/ut4/parcial/personas.txt", "UT5/parte2_2021/src/main/java/ut4/parcial/amistades.txt",
                false, TGrafoNoDirigido.class);

        Collection<TVertice> conexiones = grafitoNoDirigidito.listarContactos("Fabian", 2);

        // Double[][] matrizpd1 = UtilGrafos.obtenerMatrizCostos(grafitoNoDirigidito.getVertices());
        // UtilGrafos.imprimirMatrizMejorado(matrizpd1, grafitoNoDirigidito.getVertices(), "Matriz chequiada");

        for(TVertice c : conexiones){
            System.out.println(c.getEtiqueta());
        }

    }

   
    
}
