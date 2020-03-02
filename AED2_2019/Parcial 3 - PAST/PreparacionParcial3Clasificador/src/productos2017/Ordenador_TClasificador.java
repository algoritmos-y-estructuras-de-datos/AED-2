package productos2017;
import java.util.ArrayList;
public class Ordenador_TClasificador {
    public static void main(String[] args) {
        ArrayList<TProducto> lista = new ArrayList();
        TClasificadorProducto clasif = new TClasificadorProducto();
        String[] listadoStock = ManejadorArchivosGenerico.leerArchivo("src/productos2017/datos_productos.txt", false);
        for(String linea : listadoStock){
            //System.out.println(linea);
            if(linea.split(",").length==4){
                long cod = Long.parseLong(linea.split(",")[0]);
                String des = linea.split(",")[1];
                double precio = Double.parseDouble(linea.split(",")[2]);
                int cant = Integer.parseInt(linea.split(",")[3]);
                
                //Si existe, sumo la cantidad. Sino lo agrego a la lista
                TProducto aux = TProducto.existeProducto(lista, cod);
                if(aux==null){
                    aux = new TProducto(cod,des,precio,cant);
                    lista.add(aux);
                }else{
                    int c = aux.getCantidad() + cant;
                    aux.setCantidad(c);
                }
            }
        }
        System.out.println();
        
        //VERIFICACION DE CARGA - Imprimo la lista de stock
//        for(TProducto p : lista){
//            System.out.println("Codigo: "+p.getCodigo()+ " - Descripcion: "+p.getDescripcion()+ " - Cantidad: "+p.getCantidad());
//        }
//        System.out.println("TAMAÑO LISTA="+lista.size());

        //Agrego todo el stock a un array de productos
        TProducto[] productos = new TProducto[lista.size()];
        int a=0;
        for(TProducto p : lista){
            productos[a] = p;
            a++;
        }
        
        //ORDEN ASCENDENTE
        boolean ordenAscendente = true;
        TProducto[] listaAsc = clasif.ordenarPorHeapSort(productos,ordenAscendente);
//        for(TProducto p : listaAsc){
//            System.out.println("cod:"+p.getCodigo());
//        }
        System.out.println("+++ ORDEN ASCENDENTE +++");
        System.out.println("    - El conjunto está ordenado ASCENDENTE?\n    ===> "+clasif.ordenadoAscendente(listaAsc));
        String[] salida = clasif.arrayCodProductoToString(listaAsc);
        ManejadorArchivosGenerico.escribirArchivo("src/productos2017/salidaHeapsort.txt", salida,false);
        System.out.println();
        
        //EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        String[] salida2 = clasif.genSalida(listaAsc, 501);
        
        // escribir el archivo de salida con los datos ordenados en forma ascendente
        //Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        ManejadorArchivosGenerico.escribirArchivo("src/productos2017/salidaNombresAscendente.txt", salida2,false);        

        //ORDEN DESCENDENTE
        System.out.println("\n\n");
        System.out.println("+++ ORDEN DESCENDENTE +++");
        ordenAscendente = false;
        TProducto[] listaDesc = clasif.ordenarPorHeapSort(productos,ordenAscendente);
        System.out.println("    - El conjunto está ordenado DESCENDENTE?\n    ===> "+clasif.ordenadoDescendente(listaDesc));
        System.out.println();
        //String[] salida3 = clasif.arrayCodProductoToString(listaDesc);
        // EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        String[] salida4 = clasif.genSalida(listaDesc, 301);
        
        // escribir el archivo de salida con los datos ordenados en forma descendente
        // Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        ManejadorArchivosGenerico.escribirArchivo("src/productos2017/salidaNombresDescendente.txt", salida4,false);
    }
}
