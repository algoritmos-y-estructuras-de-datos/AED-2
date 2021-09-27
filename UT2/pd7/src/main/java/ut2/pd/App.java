package ut2.pd;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("C:/Source/AED-2/UT2/pd7/src/main/java/ut2/pd/abonados.txt");

        for(String telefono : lineas){
            String[] datos = telefono.split(",");
            TAbonado abonadoAux = new TAbonado(datos[1].trim(),datos[0].trim());
            trieAbonados.insertar(abonadoAux);
        }

        System.out.println();


         String codigoPais = "598" ; // utilizar el indicado en el archivo "codigos.txt"
         String codigoArea = "93" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        Collections.sort(ab);
         System.out.println(ab.size());
         System.out.println(ab.getFirst().getNombre());
         
         // crear el archivo "salida.txt", con los abonados (1 por linea)
         String[] lineaPaEscribir = new String[ab.size()];
         for(int i = 0; i < ab.size(); i++){
            lineaPaEscribir[i] = ("Nombre: " + ab.get(i).getNombre() + " | Telefono: " + ab.get(i).getTelefono());
         }
         ManejadorArchivosGenerico.escribirArchivo("salida.txt", lineaPaEscribir);
         
         // correspondientes al pais y area 
         // imprimir Nombre y teléfono, 
         // ordenados alfabeticamente por nombre
    }
}
