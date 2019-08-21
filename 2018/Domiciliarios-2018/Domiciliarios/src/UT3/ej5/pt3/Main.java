package UT3.ej5.pt3;


import java.util.Collection;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/UT2/ej7/abonados.txt");
        for (String linea : palabrasclave) {
            
            String[] aux = linea.split(",");
            TAbonado abonado = new TAbonado(aux[1],aux[0]);
            trie.insertar(abonado);
        }
        
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        Collection<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        
        String[] aux = new String[ab.size()];
        int i = 0;
        for (Object persona : ab)
        {
            aux[i] = persona.toString();
            i++;
        }
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        ManejadorArchivosGenerico.escribirArchivo("src/UT2/ej7/salida.txt",aux);
        
        
    }
}