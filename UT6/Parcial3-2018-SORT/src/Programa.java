
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Instanciar productos del ecommerce leyendo del archivo.
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/flipkart-ecommerce-sample.csv", true);
        int i = 0;
        HashMap<String,TProduct> productos = new HashMap();
        for(String linea : lineas) {
            try {
                TProduct producto = new TProduct(linea);
                if (producto.isValid()) {
                    i += 1;
                    productos.put(producto.getUniq_id(), producto);
                }
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Se cargaron " + i + " productos");
        
        TClasificador clasif = new TClasificador();
        
        Comparable[] v1 = new Comparable[productos.size()];
        i=0;
        for(String a : productos.keySet()){v1[i]=a;i++;}
        
        System.out.println(clasif.ordenado(v1));
        clasif.ordenarPorShell(v1);
        System.out.println(clasif.ordenado(v1));
        
        String[] aux = new String[productos.size()];
        i = 0;
        for (Comparable pro : v1)
        {
            aux[i] = pro.toString() +" "+ productos.get(pro).getName();
            i++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("./src/productos_ordenados.txt",aux);
        // Escribir los resultados al archivo "salida.txt"
        // Emitir un archivo de salida, "salida.txt" con la lista de productos ordenados por la propiedad indicada en el pizarrón.
    }
}
