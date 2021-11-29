package ut5.pd3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "UT5/mejorredelectricapd3/src/main/java/ut5/pd3/barrio.txt",
                "UT5/mejorredelectricapd3/src/main/java/ut5/pd3/distancias.txt",
                true, TGrafoRedElectrica.class);

        
      /*
           
        calcular la mejor red electrica
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */

        TAristas aristasPrim = laRed.mejorRedElectrica();
        TAristas aristasKruskal = laRed.mejorRedElectricaKruskal();

        String[] textoImprimir = new String[aristasPrim.size() + 2];
        //Header
        textoImprimir[0] = "<--- COSTO TOTAL DEL CABLEADO: " + laRed.costoTotal + " --->";
        textoImprimir[1] = "<[ METODO UTILIZADO: PRIM ]>";
        
        int i = 2;

        
        System.out.println("<Costo Primogenito> " + laRed.costoTotal);
        for(TArista aristaAux : aristasPrim){
          textoImprimir[i] = (aristaAux.getEtiquetaOrigen() + ", " + aristaAux.getEtiquetaDestino() + ", " + aristaAux.getCosto());
          System.out.println(textoImprimir[i]);
          i++;
        }

        System.out.println(" ====================================================== ");
        
        System.out.println("<Costo Kruskeiro> " + laRed.costoTotalKruskal);
        for(TArista aristaKrus : aristasKruskal){
          System.out.println(aristaKrus.getEtiquetaOrigen() + ", " + aristaKrus.getEtiquetaDestino() + ", " + aristaKrus.getCosto());
        }



        
        
        ManejadorArchivosGenerico.escribirArchivo("redelectrica.txt", textoImprimir);



        
    }
}
