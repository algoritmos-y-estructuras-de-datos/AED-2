
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<TVertice> aeropuertos= new LinkedList<>();
        LinkedList<TArista> vuelos= new LinkedList<>();
        
        String[] lineasV = ManejadorArchivosGenerico.leerArchivo("./src/aeropuertos_3.txt", false);
        for (String linea : lineasV) {
            String verticeEtiqueta = linea.trim();
            aeropuertos.add(new TVertice(verticeEtiqueta));
        }

        String[] lineasA = ManejadorArchivosGenerico.leerArchivo("./src/vuelos_3.txt", false);
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
        
        String elOrigen = "J";
        String elDestino = "T";
        
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
        

        System.out.println("RED ELÉCTRICA");
        TGrafoRedElectrica redElectrica = (TGrafoRedElectrica) UtilGrafos.cargarGrafo("./src/barrio.txt", "./src/distancias.txt",
                false, TGrafoRedElectrica.class);
        
        lineas = new String[2];
        
        redElectrica.desvisitarVertices();
        
        // Prim
        double costoPrim = 0;
        Iterator it = redElectrica.mejorRedElectrica().iterator();
        while (it.hasNext()) {
            costoPrim += ((TArista)it.next()).getCosto();
        }
        lineas[0] = "Costo total con Prim: " + costoPrim;
        
        // Kruskal
        double costoKruskal = 0;
        it = redElectrica.mejorRedElectrica_kruskal().iterator();
        while (it.hasNext()) {
            costoKruskal += ((TArista)it.next()).getCosto();
        }
        lineas[1] = "Costo total con Kruskal: " + costoKruskal;
        ManejadorArchivosGenerico.escribirArchivo("./src/redelectrica.txt", lineas);
        
        /*
        cargar grafo con casas y distancias
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        */
        
        
        
    }
}
