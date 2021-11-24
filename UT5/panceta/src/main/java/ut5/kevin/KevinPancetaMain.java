package ut5.kevin;

public class KevinPancetaMain {
    
    public static void main(String[] args) {
        
        TGrafoKevinBacon grafoKevinBacon = (TGrafoKevinBacon) UtilGrafos.cargarGrafoKevinBacon("UT5/panceta/src/main/java/ut5/kevin/actores.csv", "UT5/panceta/src/main/java/ut5/kevin/en_pelicula.csv",
                false, TGrafoKevinBacon.class);


        // Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafoKevinBacon.getVertices());
        // UtilGrafos.imprimirMatrizMejorado(matriz, grafoKevinBacon.getVertices(), "MATRIZ COSTOS");

        // Exception in thread "main" java.lang.ClassCastException: class uy.edu.ucu.aed2.TVertice cannot be cast to class uy.edu.ucu.aed2.TVerticeKevinBacon (uy.
        System.out.println(grafoKevinBacon.numBacon("John_Goodman")); 

        



    }
}
// at uy.edu.ucu.aed2.TGrafoKevinBacon.numBacon(TGrafoKevinBacon.java:25)
//         at uy.edu.ucu.aed2.KevinPanceta.main(KevinPanceta.java:15)


// Exception in thread "main" java.lang.ClassCastException: class uy.edu.ucu.aed2.TVertice cannot be cast to class uy.edu.ucu.aed2.TVerticeKevinBacon (uy.edu.ucu.aed2.TVertice and uy.edu.ucu.aed2.TVerticeKevinBacon are in unnamed module of loader 'app')
//         at uy.edu.ucu.aed2.TGrafoKevinBacon.numBacon(TGrafoKevinBacon.java:25)
//         at uy.edu.ucu.aed2.KevinPanceta.main(KevinPanceta.java:15)