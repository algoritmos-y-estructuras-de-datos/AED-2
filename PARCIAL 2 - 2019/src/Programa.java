
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cargar grafo aerolínea con aeropuertos y vuelos
        TGrafoAerolinea aerolinea = (TGrafoAerolinea) UtilGrafos.cargarGrafo(
                "src/aeropuertos.txt",
                "src/vuelos.txt",
                false, TGrafoAerolinea.class);

        String elOrigen = "A";
        String elDestino = "J";

        // Obtener el itinerario con menos escalas entre elOrigen y elDestino;
        LinkedList<TVertice> lasEscalas = aerolinea.menosEscalas(elOrigen, elDestino);
        /*
        mostrar las escalas y listar en archivo de salida 
         */
        System.out.println();

        System.out.println("itinerario mejor para vuelo entre " + elOrigen + " y " + elDestino + ": ");
        for (TVertice v : lasEscalas) {

            System.out.println(v.getEtiqueta());

        }
    }
}
