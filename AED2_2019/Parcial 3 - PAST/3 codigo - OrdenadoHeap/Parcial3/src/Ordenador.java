
import java.util.LinkedList;


public class Ordenador {
    
    private void intercambiar(long[] vector, int pos1, int pos2) {
        long temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }
    
    public long[] ordenarPorHeapSort(long[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar,0,i);
            armaHeap(datosParaClasificar, 0, i-1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(long[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                if (ultimo == 2*r){ //r tiene un hijo solo
                    if (datosParaClasificar[r] > datosParaClasificar[r*2]){
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else { 
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2*r] > datosParaClasificar[2*r + 1]){
                            posicionIntercambio = 2 * r +1;
                    } else {
                            posicionIntercambio = 2 * r;
                    }
                    if (datosParaClasificar[r] > datosParaClasificar[posicionIntercambio]){
                            intercambiar(datosParaClasificar,r,posicionIntercambio);
                            r = posicionIntercambio;
                    } else {
                            r = ultimo;
                    }
                }
            }			
        }
    }
    
    protected long[] ordenarPorHeapSort(long[] datosParaClasificar, boolean orden) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1, orden);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar,0,i);
            armaHeap(datosParaClasificar, 0, i-1, orden);
        }
        return datosParaClasificar;
    }
    
    // true = ascendente
    // false = descendente
    private void armaHeap(long[] datosParaClasificar, int primero, int ultimo, boolean orden) {
        if(orden){
            if (primero < ultimo){
                int r = primero;
                while(r <= ultimo / 2){
                    if (ultimo == 2*r){ //r tiene un hijo solo
                        if (datosParaClasificar[r] > datosParaClasificar[r*2]){
                            intercambiar(datosParaClasificar, r, 2 * r);
                        }
                        r = ultimo;
                    } else { 
                        int posicionIntercambio = 0;
                        if (datosParaClasificar[2*r] > datosParaClasificar[2*r + 1]){
                                posicionIntercambio = 2 * r+1;
                        } else {
                                posicionIntercambio = 2 * r;
                        }
                        if (datosParaClasificar[r] > datosParaClasificar[posicionIntercambio]){
                                intercambiar(datosParaClasificar,r,posicionIntercambio);
                                r = posicionIntercambio;
                        } else {
                                r = ultimo;
                        }
                    }
                }			
            }
        }
        else{
            if (primero < ultimo){
                int r = primero;
                while(r <= ultimo / 2){
                    if (ultimo == 2*r){ //r tiene un hijo solo
                        if (datosParaClasificar[r] > datosParaClasificar[r*2]){
                            intercambiar(datosParaClasificar, r, 2 * r);
                        }
                        r = ultimo;
                    } else { 
                        int posicionIntercambio = 0;
                        if (datosParaClasificar[2*r] > datosParaClasificar[2*r + 1]){
                                posicionIntercambio = 2 * r +1;
                        } else {
                                posicionIntercambio = 2 * r;
                        }
                        if (datosParaClasificar[r] > datosParaClasificar[posicionIntercambio]){
                                intercambiar(datosParaClasificar,r,posicionIntercambio);
                                r = posicionIntercambio;
                        } else {
                                r = ultimo;
                        }
                    }
                }			
            }
        }
    }
    
    public static IProducto buscarLinkedList(LinkedList<IProducto> lista, long cod){
        for(IProducto p : lista){
            if(p.getCodigo() == cod){
                return p;
            }
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        // cargar los datos utilizando el Manejador de Archivos
        // utilizar la clase TProducto
        
        LinkedList<IProducto> objetos = new LinkedList();
        
        String[] datos = ManejadorArchivosGenerico.leerArchivo("src/datos_productos.txt", true);
        for(String linea : datos){
            String[] renglon = linea.split(",");
            if(renglon.length == 4){
                long codigo = Long.valueOf(renglon[0]);
                String descripcion = renglon[1];
                double precio = Double.valueOf(renglon[2]);
                int cantidad = Integer.valueOf(renglon[3]);
                IProducto p = new TProducto(codigo,descripcion,precio,cantidad);
                objetos.add(p);
            }
        }
        
        //System.out.println(objetos.size());
        
        
        
        
        long[] datosOrdenar = new long[objetos.size()];
        int cont = 0;
        for(IProducto p : objetos ){
            datosOrdenar[cont] = p.getCodigo();
            cont ++;
        }
        
        Ordenador c = new Ordenador();

        
        // Ordenar en forma ascendente
        
        // EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        // escribir el archivo de salida con los datos ordenados en forma ascendente, 
             
        long[] res =  c.ordenarPorHeapSort(datosOrdenar, true);
        
        /*for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }*/
        
        
        for(int i =0 ; i<500 ; i++){
            long codigo = res[i];
            IProducto p = Ordenador.buscarLinkedList(objetos, codigo);
            System.out.println(p.getCantidad());
        }
        
        
        String[] datosEscribir = new String[500];
        for(int i =0 ; i<500 ; i++){
            long codigo = res[i];
            IProducto p = Ordenador.buscarLinkedList(objetos, codigo);
            System.out.println(p.getCantidad());
            datosEscribir[i] = p.getCodigo() + " | " + p.valor();
            
        }
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", datosEscribir);
        
        //Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        for(int i =0 ; i<500 ; i++){
            long codigo = res[i];
            IProducto p = Ordenador.buscarLinkedList(objetos, codigo);
            System.out.println(p.getCantidad());
        }
        
        
        System.out.println("");
        // Ordenar en forma descendente
        // EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        // escribir el archivo de salida con los datos ordenados en forma descendente
        // Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        
        
        
        long[] res2 =  c.ordenarPorHeapSort(datosOrdenar, false);
        
        /*for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }*/
        String[] datosEscribir2 = new String[500];
        for(int i =0 ; i<300 ; i++){
            long codigo = res2[i];
            IProducto p = Ordenador.buscarLinkedList(objetos, codigo);
            System.out.println(p.getCantidad());
            datosEscribir2[i] = p.getCodigo() + " | " + p.valor();
        }
        ManejadorArchivosGenerico.escribirArchivo("src/salida2.txt", datosEscribir2);
        
        
        
        

    }
}
