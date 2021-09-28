package uy.edu.ucu.aed2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // INSTANCIAR UN TRIE

        // LEER LA CADENA DE AMINOACIDOS DESDE EL ARCHIVO
        //./src/main/java/uy/edu/ucu/aed2/mensaje.txt
        String[] secuencia = ManejadorArchivosGenerico.leerArchivo("./src/main/java/uy/edu/ucu/aed2/mensaje.txt");
        TArbolTrie arbol = new TArbolTrie();
        char[] devuelta = new char[secuencia[0].length()];

        for (int i = 0; i < secuencia[0].length(); i++) {
            devuelta[i] = secuencia[0].charAt(i);
        }

        for (int x = 0; x < devuelta.length; x++) {
            char[] sliceAux = Arrays.copyOfRange(devuelta, x, devuelta.length); 
            String proxSufijo = "";

            for (int i = 0; i < sliceAux.length; i++) {
                proxSufijo += sliceAux[i];
            }
            int[] elArray = new int[2];
            elArray[0] = x;
            elArray[1] = devuelta.length;

            arbol.insertar(proxSufijo, elArray);

        }
        // GENERAR TODOS LOS SUFIJOS E INSERTARLOS EN EL TRIE, CUIDANDO DE REGISTRAR LA
        // POSICIÓN
        // DE INICIO DE CADA UNO

        // INVOCAR A trie.encontrarPatron("110101") Y escribir los resultados en el
        // archivo
        // SALIDA.TXT
        LinkedList<Integer> ab = arbol.encontrarPatron("110101");
        String[] lineaPaEscribir = new String[ab.size()];
         for(int i = 0; i < ab.size(); i++){
            lineaPaEscribir[i] = (""+ab.get(i));
            System.out.println(ab.get(i));
         }
         ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/salida.txt", lineaPaEscribir);

        // INVOCAR A trie.encontrarPatron("110101") Y agregar los resultados en el
        // archivo
        // SALIDA.TXT
        LinkedList<Integer> ab2 = arbol.encontrarPatron("1101011");
        String[] lineaPaEscribir2 = new String[ab.size()];
         for(int i = 0; i < ab.size(); i++){
            lineaPaEscribir2[i] = (""+ab2.get(i));
            System.out.println(ab2.get(i));
         }
         ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/salida.txt", lineaPaEscribir);

    }
}
