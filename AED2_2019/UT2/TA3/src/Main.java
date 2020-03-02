
import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    private static final String RUTA_PALABRAS_DESORDENADAS = "src/listado-general_desordenado.txt";
    private static final String RUTA_PALABRAS_BUSCAR = "src/listado-general_palabrasBuscar.txt";

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo(RUTA_PALABRAS_DESORDENADAS);
        //String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo(RUTA_PALABRAS_BUSCAR);
        String[] palabrasBuscar = new String[]{"cas"};
        for (String p : palabrasclave) {
            // insertar la palabra p en el trie
            trie.insertar(p);
            // insertar la palabra p en el linkedList
            linkedList.add(p);
            // insertar la palabra p en el arrayList
            arrayList.add(p);
            // insertar la palabra p en el hashMap
            hashMap.put(p, null);
            // insertar la palabra p en el treeMap
            treeMap.put(p, null);
        }

        Medible[] medibles = new Medible[3];

        int i = 0;
        /*medibles[i++] = new MedicionBuscarLinkedList(linkedList);
        medibles[i++] = new MedicionBuscarArrayList(arrayList);
        medibles[i++] = new MedicionBuscarTrie(trie);
        medibles[i++] = new MedicionBuscarHashMap(hashMap);
        medibles[i++] = new MedicionBuscarTreeMap(treeMap);*/
        medibles[i++] = new MedicionPredecirLinkedList(linkedList);
        medibles[i++] = new MedicionPredecirTrie(trie);
        medibles[i++] = new MedicionPredecirHashMap(hashMap);

        Medicion mi;

        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[medibles.length + 1];
        i = 0;
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucion().toString() + "," + mi.getMemoria().toString();
        }

        ManejadorArchivosGenerico.escribirArchivo("./src/salida.csv", lineas);

    }

}
