
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList<TVertice> aeropuertos= new LinkedList<>();
        LinkedList<TArista> vuelos= new LinkedList<>();
        
        String[] lineasV = ManejadorArchivosGenerico.leerArchivo("./src/aeropuertos.txt", false);
        for (String linea : lineasV) {
            String verticeEtiqueta = linea.trim();
            aeropuertos.add(new TVertice(verticeEtiqueta));
        }

        String[] lineasA = ManejadorArchivosGenerico.leerArchivo("./src/vuelos.txt", false);
        for (String linea : lineasA) {
            String[] datos = linea.split(",");
            if (datos.length != 3) {
                System.out.printf("ERROR al leer arista: '%s'\n", linea);
                continue;
            }
            String etiquetaOrigen = datos[0];
            String etiquetaDestino = datos[1];
            int costo = Integer.valueOf(datos[2]);
            
            vuelos.add(new TArista(etiquetaOrigen, etiquetaDestino, costo));
       
        }
        //cargar grafo aerolínea con aeropuertos y vuelos

        
       TGrafoAerolinea aerolinea = new TGrafoAerolinea(aeropuertos,vuelos); 
        
        String elOrigen = "A";
        String elDestino = "J";
        
        // obtener el itinerario con menos escalas entre elOrigen y elDestino;
         LinkedList<TVertice> lasEscalas = aerolinea.menosEscalas(elOrigen, elDestino);
        
       
        
        /*
        mostrar las escalas y listar en archivo de salida 
        */
        
      
        
        //System.out.println();
        String[] lineas= new String[lasEscalas.size()];
        int i=0;
        System.out.println("itinerario mejor para vuelo entre "+ elOrigen+ " y "+ elDestino +": ");
        for (TVertice v : lasEscalas) {
            System.out.println(v.getEtiqueta());
            lineas[i]= v.getEtiqueta().toString();
            i++;
        }
        ManejadorArchivosGenerico.escribirArchivo("./src/escalas.txt", lineas);

        
    }
}
   

