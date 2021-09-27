
import java.lang.reflect.Array;
import java.util.Arrays;


public class Program {
    public static void main(String[] args) {
        String[] secuencia = ManejadorArchivosGenerico.leerArchivo("UT2/PD6/src/SECUENCIA.txt");
        TArbolTrie arbol = new TArbolTrie();
        
        for(int i = 0; i <  secuencia.length; i++){
            String[] sliceAux = Arrays.copyOfRange(secuencia, i, secuencia.length);
            
        }
        
        // String[] devuelta = new String[secuencia.length()];
        // for(int i =0; i< secuencia.length(); i++){
        //     devuelta[i] = secuencia.charAt(i);
        // }
        // System.out.println(Arrays.toString(devuelta));

        // [0, secuencia.length] "SECUENCIA"
        // [1, secuencia.length] "ECUENCIA"
        // [2, secuencia.length] "CUENCIA"
        // [3, secuencia.length] "UENCIA"
        
        arbol.insertar(secuencia[0]);
        arbol.imprimir();
        System.out.println(secuencia[0]);

        // Encontrar las ocurrencias de un determinado patrón en una determinada secuencia.

    }
}
