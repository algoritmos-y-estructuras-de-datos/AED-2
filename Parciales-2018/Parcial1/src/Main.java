

import java.util.Collection;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS DISPOSITIVOS PARTIR DEL ARCHIVO DISPOSITIVOS.TXT
       String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/dispositivos.txt");
        for (String linea : palabrasclave) {
            
            String[] aux = linea.split(",");
            TDispositivo disp = new TDispositivo(aux[0],aux[1]);
            trie.insertar(disp);
        } 
        
        String subRed = "089" ; // utilizar el indicado en el archivo "subredes.txt"
        
        Collection<TDispositivo> dispositivos = trie.buscarDispositivos(subRed);
        
        System.out.println(dispositivos.size());
        // crear el archivo "salida.txt", con los dispositivos(1 por linea) 
        // correspondientes a la subred indicada
        // imprimir Nombre y dirección de  IP, 
        String[] aux = new String[dispositivos.size()];
        int i = 0;
        for (Object dispositivo : dispositivos)
        {
            aux[i] = dispositivo.toString();
            i++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt",aux);
        
    }
}