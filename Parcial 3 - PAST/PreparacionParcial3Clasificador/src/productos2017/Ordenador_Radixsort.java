package productos2017;
import java.util.ArrayList;
import java.util.LinkedList;
public class Ordenador_Radixsort {
    
    public static TProducto[] ordenarPorRadixsort(TProducto[] datosParaClasificar, boolean ascendente){
        TProducto max = datosParaClasificar[0];
        for(int i = 1; i < datosParaClasificar.length; i++){
            if(datosParaClasificar[i].getCodigo() > max.getCodigo()){               //me quedo con el de mayor digitos
                max = datosParaClasificar[i];
            }
        }
        int digitos = String.valueOf(max.getCodigo()).length();
        
        for(int i = digitos -1 ; i >= 0; i--){
            LinkedList<TProducto>[] vector = new LinkedList[10];         //vector de listas de 0 a 9
            for(int m = 0; m < vector.length; m++){
                vector[m] = new LinkedList();
            }
            for(int j = 0; j < datosParaClasificar.length; j++){ //recorro todo el vector
                String lugarEnUrna = String.valueOf(datosParaClasificar[j].getCodigo());
                while(lugarEnUrna.length() < digitos ){
                    lugarEnUrna="0"+lugarEnUrna;
                }
                char var = lugarEnUrna.toCharArray()[i];
                Integer varInt = Integer.parseInt(var+"");
                vector[varInt].add(datosParaClasificar[j]);
            }
            //concatenamos la lista, armamos datos para clasificar ordenado 
            int cont= 0;
            if(ascendente){
                for(int h = 0; h < vector.length; h++){
                    for(int k = 0; k < vector[h].size(); k++){
                        datosParaClasificar[cont] = vector[h].get(k);
                        cont++;
                    }
                }
            }else{
                for(int h = vector.length-1; h>=0 ; h--){
                    for(int k = 0; k < vector[h].size(); k++){
                        datosParaClasificar[cont] = vector[h].get(k);
                        cont++;
                    }
                }
            }
        }
        return datosParaClasificar;
    }
    
    public static String ordenadoAscendente(TProducto[] datos){
        for(int i = 0; i< datos.length-1; i++){
            if(datos[i].getCodigo()>datos[i+1].getCodigo()){
                return  "NO. Conjunto desordenado entre los valores "+datos[i].getCodigo() +" y "+ datos[i+1].getCodigo();
            }
        }
        return "SI. Conjunto ordenado ascendentemente";
    }
    
    public static String ordenadoDescendente(TProducto[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i].getCodigo() < datos[i+1].getCodigo()){
                return  "NO. Conjunto desordenado entre los valores "+datos[i].getCodigo() +" y "+ datos[i+1].getCodigo();
            }
        }
        return "SI. Conjunto ordenado descendentemente";
    }
    
    public static String[] arrayCodProductoToString(TProducto[] entrada){
        String[] salida = new String[entrada.length];
        String txt = "";
        for (int j=0;j<entrada.length;j++){
            salida[j]= String.valueOf(entrada[j].getCodigo());
        }
        return salida;
    }
    
    public static TProducto[] copiar(TProducto[] entrada){
        TProducto[] salida = new TProducto[entrada.length];
        for(int i = 0; i<entrada.length ; i++){
            salida[i] = new TProducto(entrada[i].getCodigo(),entrada[i].getDescripcion(),entrada[i].getPrecio(),entrada[i].getCantidad());
        }
        return salida;
    }
    
    public static void intercambiar(TProducto[] datos, int pos1, int pos2) {
        TProducto aux = datos[pos2];
        datos[pos2] = datos[pos1];
        datos[pos1] = aux;
    }
    
    public static String[] genSalida(TProducto[] lista, int tam){
        int cant=0;
        double totalStk=0.0;
        String txt="";
        String[] salida = new String[tam];
        for(TProducto p : lista){
            if(p!=null){
                if (cant<tam-1){
                    totalStk+=p.valor();
                    int lin = cant+1;
                    txt="("+lin+") Codigo="+p.getCodigo()+ " - Valor="+p.valor();
                    System.out.println(txt);
                    salida[cant]=txt;
                }
                cant+=1;
            }
        }
        salida[tam-1]="======>>> VALOR TOTAL STOCK REDONDEADO $"+Math.rint(totalStk);
        System.out.println("======>>> VALOR TOTAL STOCK REDONDEADO $"+Math.rint(totalStk));
        return salida;
    }
    
    public static void main(String[] args) {
        ArrayList<TProducto> lista = new ArrayList();
        String[] listadoStock = ManejadorArchivosGenerico.leerArchivo("src/clasificaciones_2017/datos_productos.txt", false);
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
        TProducto[] listaAsc = ordenarPorRadixsort(productos,ordenAscendente);
//        for(TProducto p : listaAsc){
//            System.out.println("cod:"+p.getCodigo());
//        }
        System.out.println("+++ ORDEN ASCENDENTE +++");
        System.out.println("    - El conjunto está ordenado ASCENDENTE?\n    ===> "+ordenadoAscendente(listaAsc));
        String[] salida = arrayCodProductoToString(listaAsc);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones_2017/salidaHeapsort.txt", salida,false);
        System.out.println();
        
        //EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        String[] salida2 = genSalida(listaAsc, 501);
        
        // escribir el archivo de salida con los datos ordenados en forma ascendente
        //Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones_2017/salidaNombresAscendente.txt", salida2,false);        

        //ORDEN DESCENDENTE
        System.out.println("\n\n");
        System.out.println("+++ ORDEN DESCENDENTE +++");
        ordenAscendente = false;
        TProducto[] listaDesc = ordenarPorRadixsort(productos,ordenAscendente);
        System.out.println("    - El conjunto está ordenado DESCENDENTE?\n    ===> "+ordenadoDescendente(listaDesc));
        System.out.println();
        //String[] salida3 = clasif.arrayCodProductoToString(listaDesc);
        // EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        String[] salida4 = genSalida(listaDesc, 301);
        
        // escribir el archivo de salida con los datos ordenados en forma descendente
        // Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones_2017/salidaNombresDescendente.txt", salida4,false);
    }
}
