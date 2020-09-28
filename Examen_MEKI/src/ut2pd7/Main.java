package ut2pd7;

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
        TArbolTrie arbolito = new TArbolTrie();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String [] abonados = ManejadorArchivosGenerico.leerArchivo("src/ut2pd7/abonados.txt");
        
        for (String abonado : abonados) {
            
            String aInsertar [] = abonado.split(",");
            TAbonado unAbo = new TAbonado(aInsertar[1], aInsertar[0]);
            arbolito.insertarAbonado(unAbo);
            
            
        }
        
        
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        Collection<TAbonado> ab = arbolito.buscarTelefonos(codigoPais, codigoArea);  //pbtengo los abonados

        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        List <TAbonado> lista = new ArrayList<>();  //los meto en una lista para ordenarolos despues con el sort
        for (TAbonado ab1 : ab) {
            lista.add(ab1);
            
        }
        
        Collections.sort(lista); //los ordeno por el nombre que es comparable

        String[] resultados = new String[lista.size()];
        int i= 0;

        for (TAbonado abo : lista){  //agrego los valores ordenados en una string
            
            resultados[i] = "nombre: "+abo.getNombre()+" numero: "+ abo.getTelefono();
            i++;
            
        }

        ManejadorArchivosGenerico.escribirArchivo("src/ut2pd7/salidaOrdenados.txt",resultados); //escribo resultado
        
    }
}