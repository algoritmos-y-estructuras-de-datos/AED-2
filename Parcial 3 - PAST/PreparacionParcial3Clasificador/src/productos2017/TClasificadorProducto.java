package productos2017;

public class TClasificadorProducto {
    public String ordenadoAscendente(TProducto[] datos){
        for(int i = 0; i< datos.length-1; i++){
            if(datos[i].getCodigo()>datos[i+1].getCodigo()){
                return  "NO. Conjunto desordenado entre los valores "+datos[i].getCodigo() +" y "+ datos[i+1].getCodigo();
            }
        }
        return "SI. Conjunto ordenado ascendentemente";
    }
    
    public String ordenadoDescendente(TProducto[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i].getCodigo() < datos[i+1].getCodigo()){
                return  "NO. Conjunto desordenado entre los valores "+datos[i].getCodigo() +" y "+ datos[i+1].getCodigo();
            }
        }
        return "SI. Conjunto ordenado descendentemente";
    }
    
    public String[] arrayCodProductoToString(TProducto[] entrada){
        String[] salida = new String[entrada.length];
        String txt = "";
        for (int j=0;j<entrada.length;j++){
            salida[j]= String.valueOf(entrada[j].getCodigo());
        }
        return salida;
    }
    
    public TProducto[] copiar(TProducto[] entrada){
        TProducto[] salida = new TProducto[entrada.length];
        for(int i = 0; i<entrada.length ; i++){
            salida[i] = new TProducto(entrada[i].getCodigo(),entrada[i].getDescripcion(),entrada[i].getPrecio(),entrada[i].getCantidad());
        }
        return salida;
    }
    
    public void intercambiar(TProducto[] datos, int pos1, int pos2) {
        TProducto aux = datos[pos2];
        datos[pos2] = datos[pos1];
        datos[pos1] = aux;
    }
    
    public TProducto[] ordenarPorHeapSort(TProducto[] entrada, boolean ascendente){
        TProducto[] datosParaClasificar = this.copiar(entrada);
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1,ascendente);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {//se modifico linea
            intercambiar(datosParaClasificar,0,i);
            armaHeap(datosParaClasificar, 0, i-1,ascendente);
        }
        return datosParaClasificar;
    }
    
    public void armaHeap(TProducto[] datosParaClasificar, int primero, int ultimo, boolean ascendente) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                if (ultimo == 2*r){ //r tiene un hijo solo
                    if ((datosParaClasificar[r].getCodigo() < datosParaClasificar[r*2].getCodigo() && ascendente) ||
                        (datosParaClasificar[r].getCodigo() > datosParaClasificar[r*2].getCodigo() && !ascendente)){ // se modifico linea
                        
                        intercambiar(datosParaClasificar, r, r*2);
                        r = 2*r ;
                    } else {
                        r = ultimo;
                    }
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if ((datosParaClasificar[2*r].getCodigo() > datosParaClasificar[2*r + 1].getCodigo() && ascendente) ||
                        (datosParaClasificar[2*r].getCodigo() < datosParaClasificar[2*r + 1].getCodigo() && !ascendente)){
                        
                        posicionIntercambio = 2 * r;
                    } else {
                        posicionIntercambio = 2 * r + 1;
                    }
                    if ((datosParaClasificar[r].getCodigo() < datosParaClasificar[posicionIntercambio].getCodigo() && ascendente) ||
                        (datosParaClasificar[r].getCodigo() > datosParaClasificar[posicionIntercambio].getCodigo() && !ascendente)){
                        intercambiar(datosParaClasificar,r,posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }
    
    public String[] genSalida(TProducto[] lista, int tam){
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
}
