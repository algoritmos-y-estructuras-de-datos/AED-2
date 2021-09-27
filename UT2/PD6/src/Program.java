import java.lang.reflect.Array;
import java.util.Arrays;

/*
Se desea determinar la ocurrencia de cierto marcador genómico (patrón) en una secuencia de ADN determinada. 
La secuencia en cuestión se encuentra adjunta en el documento “secuencia.txt”
En este caso, el “alfabeto” correspondiente al problema tiene los siguientes caracteres: “a”, “c”, “g” y “t”
Se debe:
1- Desarrollar un programa java que, partiendo de la estructura diseñada en el Ejercicio 1:
• A partir de la secuencia, construya todos los sufijos correspondientes
• Inserte todas las cadenas resultantes en un trie
• Indique las posiciones en que aparecen los siguientes fragmentos (marcadores, patrones) en la secuencia de 
ADN:
a. ccta
b. ggtca
c. aacc
*/


public class Program {
    public static void main(String[] args) {
        String[] secuencia = ManejadorArchivosGenerico.leerArchivo("src/SECUENCIA.txt",false);
        TArbolTrie arbol = new TArbolTrie();
        char[] devuelta = new char[secuencia[0].length()];
        
        for(int i =0; i< secuencia[0].length(); i++){
            devuelta[i] = secuencia[0].charAt(i);
        }

        for(int x = 0; x < devuelta.length; x++){
            char[] sliceAux = Arrays.copyOfRange(devuelta, x, devuelta.length); // Hacemos un slice del array Devuelta[] para obtener los sufijos.
            String proxSufijo = ""; 
            
            for(int i = 0; i< sliceAux.length; i++){
                proxSufijo += sliceAux[i];
            }
            // System.out.println(proxSufijo);
            int[] posEnArray = new int[2];
            posEnArray[0] = x;
            posEnArray[1] = devuelta.length;

            arbol.insertar(proxSufijo, posEnArray);


        }
        // na
        // na = [0,1]
        // na = [5,6]

        
        //nacionaltupapa
        //naltupapa
        
        // arbol.imprimir();
        System.out.println(arbol.predecir("ccta"));
        System.out.println(arbol.predecir("ggtca"));
        System.out.println(arbol.predecir("aacct"));

        // Encontrar las ocurrencias de un determinado patrón en una determinada secuencia.

    }
}
