import java.rmi.server.RemoteObject;
import java.util.Arrays;
import java.util.HashMap;

import javax.sound.sampled.Line;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        String[] cadenas = ManejadorArchivosGenerico.leerArchivo("UT3_TA1-Ej2/pruebas.txt");
        
        THash nuevoHash = new THash(cadenas.length);
        for(String cadena : cadenas){
            nuevoHash.insertarLineal2(cadena);
        }
        
        System.out.println(nuevoHash.miLista.toString());
        
    }
}