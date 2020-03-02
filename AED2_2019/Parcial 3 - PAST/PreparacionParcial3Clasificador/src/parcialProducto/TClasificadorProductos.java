package parcialProducto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agustin
 */
public class TClasificadorProductos {
    //MÉTODO QUICKSORT ES MÉTODO 1
    //MÉTODO HEAPSORT ES MÉTODO 2
    public TProduct[] clasificar(TProduct[] datosParaClasificar, int metodo) {  
        if (metodo ==1){
            return ordenarPorQuickSortDescendente(datosParaClasificar);
        }
        if (metodo == 2){
            return ordenarPorHeapSortDescendente(datosParaClasificar);
        }
        return ordenarPorQuickSortDescendente(datosParaClasificar);
        
                      
    }
    
    private void intercambiar(TProduct[] datos, int pos1, int pos2) {
            TProduct aux = datos[pos2];
            datos[pos2] = datos[pos1];
            datos[pos1] = aux;
    }
    public int encuentraPivote(TProduct[] entrada,int izq , int der){
        return (izq+der)/2;
    }
    protected TProduct[] ordenarPorQuickSortDescendente(TProduct[] datosParaClasificar) {
        if (datosParaClasificar.length >0){
            quicksortDescendente(datosParaClasificar, 0, datosParaClasificar.length - 1);
        }        
        return datosParaClasificar;
    }
     private void quicksortDescendente(TProduct[] entrada, int i, int j) {

            int izquierda = i;
            int derecha = j; 
            int posicionPivote = encuentraPivote(entrada,i,j); 
            if (posicionPivote >= 0){
                String pivote = entrada[posicionPivote].getid();
                //System.out.println("pivote: "+pivote);
                while (izquierda <= derecha){
                    //Ignora todos los números mayores al pivote
                    while ((entrada[izquierda].getid().compareTo(pivote) > 0) && (izquierda < j))
                        izquierda++;
                    //Ignora todos los numeros menores al pivote
                    while ((pivote.compareTo(entrada[derecha].getid()) > 0) && (derecha > i))
                        derecha--;

                    if (izquierda <= derecha) {
                        intercambiar(entrada, izquierda, derecha); 
                        izquierda++;
                        derecha--;
                    }
                }
                if (i < derecha)
                    quicksortDescendente(entrada, i, derecha);
                if (izquierda < j)
                    quicksortDescendente(entrada, izquierda, j);
            }
        //}
    }
     public boolean ordenadoDescendente(TProduct[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i].compareTo(datos[i+1])<0){
                return  false;
            }
        }
        return true;
    }
     
     protected TProduct[] ordenarPorHeapSortDescendente(TProduct[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeapDescendente(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        
        for (int i = datosParaClasificar.length - 1; i  >= 1; i--) { 
            intercambiar(datosParaClasificar,0,i);
            armaHeapDescendente(datosParaClasificar, 0, i-1);
        }
        return datosParaClasificar;
    }
     private void armaHeapDescendente(TProduct[] productos, int primero, int ultimo) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                if (ultimo == 2*r){ //r tiene un hijo solo
                    if (productos[r].getid().compareTo(productos[r*2].getid())>0){
                        intercambiar(productos, r, 2 * r);
                    }
                    r = ultimo;
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (productos[2*r].getid().compareTo(productos[2*r + 1].getid())>0){
                            posicionIntercambio = 2 * r +1;
                    } else {
                            posicionIntercambio = 2 * r;
                    }
                    if (productos[r].getid().compareTo(productos[posicionIntercambio].getid())>0){
                            intercambiar(productos,r,posicionIntercambio);
                            r = posicionIntercambio;
                    } else {
                            r = ultimo;
                    }
                }
            }			
        }
    }
    
}
