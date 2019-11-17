package parcialProducto;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Instanciar productos del ecommerce leyendo del archivo.
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/parcialProducto/flipkart-ecommerce-sample.csv", true);
        int i = 0;
        int j = 0;
        TProduct[] productos = new TProduct[lineas.length];
        for(String linea : lineas) {
            try {
                TProduct producto = new TProduct(linea);
                if (producto.isValid()) {                    
                    productos[i] = producto;
                    i += 1;
                    
                    // Agregar el producto a una colección del tipo apropiado.
                    
                }
                // IMPORTANTE, MI COMPUTADORA NO TIENE LA MEMORIA SUFICIENTE PARA BANCARSE LOS
                //40000 DATOS ASI QUE LO LIMITÉ A 10000 DONDE MAS O MENOS NO PUEDE CARGAR MAS
                if (i == 10000){ 
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
            j++;
        } 
        // IMPORTANTE, SEPARÉ EN DOS SENTENCIAS LA CARGA DE DATOS POR LA MEMORIA DE MI COMPUTADORA.
        while (j<lineas.length){
            try {
                TProduct producto = new TProduct(lineas[i]);
                if (producto.isValid()) {                    
                    productos[i] = producto;
                    i += 1;                    
                    // Agregar el producto a una colección del tipo apropiado.                    
                }
                
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
            j++;
        }
        System.out.println("Se cargaron " + i + " productos");    
        
        
        
        // Limpio los espacios null del array
        TProduct[] misProductosClean = new TProduct[i];
        i = 0;
        for (TProduct producto : productos){
            if (producto!=null){
                misProductosClean[i] = producto;
                i++;
            }
        }
        TClasificadorProductos clasif = new TClasificadorProductos();
        TProduct[] misProductosDescendente = clasif.clasificar(misProductosClean,1);
        String[] codigos = new String[misProductosDescendente.length];
        System.out.println("------------PRODUCTOS ORDENADOS DE FORMA DESCENDENTE -----------------");
        int s = 0;
        for (TProduct p : misProductosDescendente){
            System.out.println("Su código es: "+ p.getid());
            codigos[s] = p.getid();
            s++;
        }
        ManejadorArchivosGenerico.escribirArchivo("src/parcialProducto/productos_ordenados.txt", codigos);
        // Escribir los resultados al archivo "salida.txt"
        // Emitir un archivo de salida, "salida.txt" con la lista de productos ordenados por la propiedad indicada en el pizarrón.
    }
}
