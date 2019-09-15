
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();
        
        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        
        String[] abonados = ManejadorArchivosGenerico.leerArchivo("src/prueba.txt");
        for (int i=0; i< abonados.length ; i++) {
            String[] linea = abonados[i].split(",");
            trie.insertar(new TAbonado(linea[1],linea[0]));
        }
        //trie.insertar(new TAbonado("SORAYA CASTELLS MURIEL","59895695218"));
        String codigoPais = "598" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "94" ;// utilizar el indicado en el archivo "codigos.txt"
        Collection<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        ArrayList<String> abonadosSalida = new ArrayList<String>();
        System.out.println(ab.isEmpty());
        for(TAbonado abo:ab){
            abonadosSalida.add(abo.getNombre()+","+abo.getTelefono());
        }
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt", abonadosSalida.toArray (new String [0]));
    }
}