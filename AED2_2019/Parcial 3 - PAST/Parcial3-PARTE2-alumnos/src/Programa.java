
import java.util.LinkedList;
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
        LinkedList<TProduct> objetos = new LinkedList();
        for(String linea : lineas) {
            try {
                TProduct producto = new TProduct(linea);
                Comparable clave = producto.getID();
                if (producto.isValid()) {
                    i += 1;
                    objetos.add(producto);
                    // Agregar el producto a una colección del tipo apropiado.
                    
                }
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Se cargaron " + i + " productos");
        /*TProduct[] productos = new TProduct[i];
        for(int n=0; n<i; n++){
            productos[n]=objetos.get(n);
        }*/
        Comparable[] datosOrdenar = new Comparable[objetos.size()];
        int cont = 0;
        for(TProduct p : objetos ){
            datosOrdenar[cont] = p.getID();
            cont ++;
        }
        
        TClasificador c = new TClasificador();
        
        Comparable[] res =  c.ordenarPorHeapSort(datosOrdenar, true);
        
        
        
        String[] datosEscribir = new String[i];
        for(int n =0 ; n<i ; n++){
            Comparable codigo = res[n];
            TProduct p = c.buscarLinkedList(objetos, (String) codigo);
            datosEscribir[n] = p.getID() + " " + p.getNombre();
            
        }
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", datosEscribir);
        
        //System.out.println(res[0]);
        // Escribir los resultados al archivo "salida.txt"
        // Emitir un archivo de salida, "salida.txt" con la lista de productos ordenados por la propiedad indicada en el pizarrón.
    }
    
}
