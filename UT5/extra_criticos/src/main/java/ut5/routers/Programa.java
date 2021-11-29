package ut5.routers;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        // TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
        //         "src/barrio.csv",
        //         "src/distancias.csv",
        //         false, TGrafoRedElectrica.class);

        TGrafoConexionesRed redFragil = (TGrafoConexionesRed) UtilGrafos.cargarGrafo(
          "UT5/extra_criticos/src/main/java/ut5/routers/routers.txt", 
          "UT5/extra_criticos/src/main/java/ut5/routers/conexiones.txt", 
          false, 
          TGrafoConexionesRed.class);

        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R2");
        LinkedList<TVertice> routersCriticos2Secundario = redFragil.routersCriticos2Secundario("R1");

        for(TVertice aux : routersCriticos){
          System.out.println(aux.getEtiqueta());
        }
        
        for(TVertice aucs : routersCriticos2Secundario){
          System.out.println(aucs.getEtiqueta());
        }
       
         /*
           
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */
    }
}
