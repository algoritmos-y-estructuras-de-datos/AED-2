
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Instanciar autos del ecommerce leyendo del archivo.
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/autos.csv", true);
        int i = 0;
        LinkedList<Automovil> autos = new LinkedList<Automovil>();
        for (String linea : lineas) {
            try {
                Automovil car = new Automovil(linea);
                if (car.isValid()) {
                    i += 1;
                    // Agregar el auto a una colección del tipo apropiado.
                    autos.add(car);

                }
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Se cargaron " + i + " autos");

        // Escribir los resultados al archivo indicado, con el formato establecido
        Comparable[] datosAOrdenar = new Comparable[autos.size()];
        int cont = 0;
        for (Automovil p : autos) {
            datosAOrdenar[cont] = p.getID();
            cont++;
        }

        TOrdenador c = new TOrdenador();

        Comparable[] res = c.heapSort(datosAOrdenar);

        String[] datosEscribir = new String[i];
        for (int n = 0; n < i; n++) {
            Comparable id = res[n];
            Automovil p = TOrdenador.buscar(autos, (String) id);
            datosEscribir[n] = p.getID() + ","
                    + p.getPrecio() + ","
                    + p.getCombustible() + ","
                    + p.getPuertas() + ","
                    + p.getTipo() + ","
                    + p.getCilindros() + ","
                    + p.getRPM();

        }
        ManejadorArchivosGenerico.escribirArchivo("src/informe_autos.txt", datosEscribir);

    }
}
