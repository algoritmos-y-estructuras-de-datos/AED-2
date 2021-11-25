package ut5.panceta;

import java.util.ArrayList;
import java.util.List;

public class KevinPancetaMain {
    
    public static void main(String[] args) {
        
        TGrafoNoDirigido grafoKevinBacon = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("UT5/panceta_final/src/main/java/ut5/panceta/actores.csv", "UT5/panceta_final/src/main/java/ut5/panceta/en_pelicula.csv",
                false, TGrafoNoDirigido.class);

        //System.out.println(grafoKevinBacon.numBacon("Kevin_Bacon")); 
        
        String[] vertices = ManejadorArchivosGenerico.leerArchivo("UT5/panceta_final/src/main/java/ut5/panceta/actores.csv",true);
        List<TVertice> verticesList = new ArrayList<TVertice>();
        for (String verticeString : vertices) {
            if ((verticeString != null) && (! verticeString.trim().equals(""))) {
                verticeString = verticeString.split(",")[0];
                System.out.println(verticeString + " : " + grafoKevinBacon.numBacon(verticeString));
            }
        }
        



    }
}
