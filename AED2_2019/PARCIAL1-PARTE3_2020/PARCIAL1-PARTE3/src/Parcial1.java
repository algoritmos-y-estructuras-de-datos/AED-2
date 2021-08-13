
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Parcial1 {

    public static void main(String[] args) {

        Map<Producto, Integer> elAlmacen = new HashMap<>();
        
        String[] array = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        for (String i : array){
            elAlmacen.put(k, Integer.SIZE);
        }
        /*
        
        Seleccionar una estructura de datos apropiada para satisfacer las 
        funcionalidades requeridas, y cargarla con los datos provistos 
        (archivo “productosCompras.txt”). 
        SE DEBERÁN UTILIZAR PARA ESTO LAS CLASES E INTERFASES DISPONIBLES EN LA API DE COLECCIONES DE JAVA.  
         */

 /* Dados los  códigos de producto indicados en el 
        pizarrón imprimir por consola las existencias en el stock 
        y ESCRIBIR ESTE VALOR EN EL ARCHIVO “RESPUESTAS.DOCX”)
         */
        int codProducto1 = 1473;// indicado en el pizarron
        int codProducto2 = 1306;// indicado en el pizarron
        int codProducto3 = 1111;// indicado en el pizarron
        int[] codigos = {1111, 1306, 1473};
        for (Map.Entry<Producto, Integer> entry : elAlmacen.entrySet()) {
            for (Integer i : codigos) {
                if (entry.getKey().getCodigo() == i) {
                    System.out.println(entry.getValue());
                }
            }
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }// buscar en el almacen
        //     mostrar por consola el valor del stock
        // repetir para todso los codigos de producto indicados

        /*Emitir un archivo “listado.txt” con el listado de stock requerido,  
 ordenado por código de producto en forma ascendente, con el formato: 
CODPRODUCTO, CANTIDAD (en cada línea)
         */
        coleccionparalistar<Producto> elListado = elAlmacen. 

... (); // UTILIZAR LA COLLECTION MAS APROPIADA PARA ESTO
    
  
// EMITIR EL ARCHIVO 
    
    }
}
