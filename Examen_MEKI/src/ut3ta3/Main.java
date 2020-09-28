package ut3ta3;


import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        LinkedListPredict linkedList = new LinkedListPredict();
        ArrayList arrayList = new ArrayList();
        HashMapPredict hashMap = new HashMapPredict();
        TreeMap treeMap = new TreeMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("./src/listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
            // insertar la palabra p en el trie
            trie.insertar(p);
            // insertar la palabra p en el linkedList
            linkedList.add(p);
            // insertar la palabra p en el arrayList
            arrayList.add(p);
            // insertar la palabra p en el hashMap
            hashMap.put(p, p);
            // insertar la palabra p en el treeMap
            treeMap.put(p, p);
        }

        Medible[] medibles = new Medible[5];
        

        int i = 0;
        medibles[i++] = new MedicionBuscarLinkedList(linkedList);
        medibles[i++] = new MedicionBuscarArrayList(arrayList);
        medibles[i++] = new MedicionBuscarTrie(trie);
        medibles[i++] = new MedicionBuscarHashMap(hashMap);
        medibles[i++] = new MedicionBuscarTreeMap(treeMap);
        Medicion mi;
        i = 0;
        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[6];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucion().toString() + "," + mi.getMemoria().toString();
        }

        ManejadorArchivosGenerico.escribirArchivo("./src/salida.csv", lineas);
        i = 0;
        Medible[] medibles2= new Medible[3];
        Medicion mi2;
        medibles2[i++] = new MedicionPredecirLinkedList(linkedList);
        medibles2[i++] = new MedicionPredecirHashMap(hashMap);
        medibles2[i++] = new MedicionPredecirTrie(trie);
        i = 0;
        String[] lista = {"cas"};
        Object[] params2 = {REPETICIONES,lista};
        lineas = new String[4];
        lineas[i++] = "algoritmo;tiempo;memoria";
        for (Medible m : medibles2) {
            mi2 = m.medir(params2);
            mi2.print();
            Double tiempo= mi2.getTiempoEjecucion()*(Math.pow(10,(-6)));
            Double memoria = (mi2.getMemoria()/(Math.pow(1024, 2)));
            lineas[i++] = mi2.getTexto() + ";" + tiempo.toString() + ";" + memoria.toString();
        }
        ManejadorArchivosGenerico.escribirArchivo("./src/salida2.csv", lineas);
    }
}
