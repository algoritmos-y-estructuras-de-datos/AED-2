package clasificator;

public class TClasificador {
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_SELECCION = 5;
    public static final int METODO_CLASIFICACION_HEAP = 6;
    
    /**
     * Punto de entrada al clasificador
     * 
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
            switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                    return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                    return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                    return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                    return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCION:
                    return ordenarPorSeleccion(datosParaClasificar);
            case METODO_CLASIFICACION_HEAP:
                    return ordenarPorHeapSort(datosParaClasificar);
            default:
                    System.err.println("Este codigo no deberia haberse ejecutado");
                    break;
            }
            return datosParaClasificar;
    }
    
    /**
     * Punto de entrada al clasificador
     * 
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @param noCascara
     * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean noCascara, boolean reves) {
        switch (metodoClasificacion) {
        case METODO_CLASIFICACION_INSERCION:         
            if (reves)
                return ordenarPorInsercionDescendente(datosParaClasificar);
            if (noCascara)
                return ordenarPorInsercion(datosParaClasificar);
            else
                return ordenarPorInsercionDummy(datosParaClasificar);
        case METODO_CLASIFICACION_SHELL:
            if (reves)
                return ordenarPorShellDescendente(datosParaClasificar);            
            if (noCascara)
                return ordenarPorShell(datosParaClasificar);
            else
                return ordenarPorShellDummy(datosParaClasificar);
        case METODO_CLASIFICACION_BURBUJA:
            if (reves)
                return ordenarPorBurbujaDescendente(datosParaClasificar);
            if (noCascara)
                return ordenarPorBurbuja(datosParaClasificar);
            else 
                return ordenarPorBurbujaDummy(datosParaClasificar);
        case METODO_CLASIFICACION_QUICKSORT:
            if (reves)
                return ordenarPorQuickSortDescendente(datosParaClasificar);
            if (noCascara)
                return ordenarPorQuickSort(datosParaClasificar);
            else 
                return ordenarPorQuickSortDummy(datosParaClasificar);
        case METODO_CLASIFICACION_SELECCION:
            if (reves)
                return ordenarPorSeleccionDescendente(datosParaClasificar);
            if (noCascara)
                return ordenarPorSeleccion(datosParaClasificar);
            else
                return ordenarPorSeleccionDummy(datosParaClasificar);
        case METODO_CLASIFICACION_HEAP:
            if (reves)
                return ordenarPorHeapSortDescendente(datosParaClasificar);
            if(noCascara)
                return ordenarPorHeapSort(datosParaClasificar);
            else
                return ordenarPorHeapSortDummy(datosParaClasificar);
        default:
                System.err.println("ESTO NO DEBERIA PASAR....");
                break;
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorInsercionDummy(int[] datosParaClasificar){
        return datosParaClasificar;
    }
    
    private int[] ordenarPorBurbujaDummy(int[] datosParaClasificar) {
        return datosParaClasificar;
    }
    
    private int[] ordenarPorShellDummy(int[] datosParaClasificar) {
        return datosParaClasificar;
    }
    
    private void quicksortDummy(int[] entrada, int i, int j) {
        return;
    }
    
    protected int[] ordenarPorQuickSortDummy(int[] datosParaClasificar) {
            quicksortDummy(datosParaClasificar, 0, datosParaClasificar.length - 1);
            return datosParaClasificar;
    }
    
    public static int[] copiar(int[] entrada){
        int[] salida = new int[entrada.length];
        for(int i = 0; i< entrada.length ; i++){
            salida[i] = entrada[i];
        }
        return salida;
    }
    
    private void intercambiar(int[] datos, int pos1, int pos2) {
            int aux = datos[pos2];
            datos[pos2] = datos[pos1];
            datos[pos1] = aux;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        int [] contador = new int[1];
        contador[0] = 0;
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1,contador);
        return datosParaClasificar;
    }

   
    /**
     * Método utilizado por QuickSort para encontrar el pivote.
     * Se considera el mayor de los extremos del array
     * @param izquierda
     * @param derecha
     * @param entrada
     * @return 
     */
    public int encuentraPivote(int izquierda,int derecha,int[] entrada){
        return Integer.max(izquierda,derecha);
    }
    
    /**
     * Método utilizado por QuickSort para encontrar el pivote.
     * Se considera el mayor de los primeros 2 elementos del array
     * @param izquierda
     * @param entrada
     * @return 
     */
    public int encuentraPivote(int izquierda,int[] entrada){
        if (entrada[izquierda]>entrada[izquierda+1])
            return izquierda;
        else
            return izquierda+1;
    }
    /**
     * Método utilizado por QuickSort para encontrar el pivote.
     * Se considera el mayor de los ultimos 2 elementos del array
     * @param derecha
     * @param entrada
     * @return 
     */
    public int encuentraPivote(int[] entrada,int derecha){
        if (entrada[derecha]>entrada[derecha-1])
            return derecha;
        else
            return derecha-1;
    }
    
    /**
     * Método utilizado por QuickSort para encontrar el pivote.
     * Se considera el mayor de los ultimos 2 elementos del array
     * @param entrada
     * @return 
     */
    public int encuentraPivote(int[] entrada,int izq , int der){
        return (izq+der)/2;
    }
    
    private void quicksort(int[] entrada, int i, int j, int[] contador) {
        contador[0]+=1;
        //if (contador[0]<=12000){
            int izquierda = i;
            int derecha = j;
            //int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
            int posicionPivote = encuentraPivote(entrada,i,j); 
            if (posicionPivote >= 0){
                int pivote = entrada[posicionPivote];
                //System.out.println("pivote: "+pivote);
                while (izquierda <= derecha){
                    while ((entrada[izquierda] < pivote) && (izquierda < j))
                        izquierda++;
                    while ((pivote < entrada[derecha]) && (derecha > i))
                        derecha--;

                    if (izquierda <= derecha) {
                        intercambiar(entrada, izquierda, derecha); 
                        izquierda++;
                        derecha--;
                    }
                }
                if (i < derecha)
                    quicksort(entrada, i, derecha, contador);
                if (izquierda < j)
                    quicksort(entrada, izquierda, j, contador);
            }
        //}
    }
     protected int[] ordenarPorQuickSortDescendente(int[] datosParaClasificar) {
        int [] contador = new int[1];
        contador[0] = 0;
        quicksortDescendente(datosParaClasificar, 0, datosParaClasificar.length - 1,contador);
        return datosParaClasificar;
    }
     private void quicksortDescendente(int[] entrada, int i, int j, int[] contador) {
        contador[0]+=1;
        //if (contador[0]<=12000){
            int izquierda = i;
            int derecha = j;
            //int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
            int posicionPivote = encuentraPivote(entrada,i,j); 
            if (posicionPivote >= 0){
                int pivote = entrada[posicionPivote];
                //System.out.println("pivote: "+pivote);
                while (izquierda <= derecha){
                    //Ignora todos los números mayores al pivote
                    while ((entrada[izquierda] > pivote) && (izquierda < j))
                        izquierda++;
                    //Ignora todos los numeros menores al pivote
                    while ((pivote > entrada[derecha]) && (derecha > i))
                        derecha--;

                    if (izquierda <= derecha) {
                        intercambiar(entrada, izquierda, derecha); 
                        izquierda++;
                        derecha--;
                    }
                }
                if (i < derecha)
                    quicksortDescendente(entrada, i, derecha, contador);
                if (izquierda < j)
                    quicksortDescendente(entrada, izquierda, j, contador);
            }
        //}
    }
    
    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
            int j, inc;
            int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

            for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {

                    inc = incrementos[posIncrementoActual]; //h
                    if (inc < (datosParaClasificar.length / 2)) {
                            for (int i = inc; i < datosParaClasificar.length; i++) {
                                    int aux = datosParaClasificar[i];
                                    j = i - inc;
                                    while (j >= 0 && aux < datosParaClasificar[j]) {                                            
                                            intercambiar(datosParaClasificar, j, j + inc);
                                            j = j-inc;                                            
                                    }
                                    datosParaClasificar[j+inc] = aux;
                            }
                    }
            }
            return datosParaClasificar;
    }
    
    private int[] ordenarPorShellDescendente(int[] datosParaClasificar) {
            int j, inc;
            int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

            for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {

                    inc = incrementos[posIncrementoActual]; //h
                    if (inc < (datosParaClasificar.length / 2)) {
                            for (int i = inc; i < datosParaClasificar.length; i++) {
                                    int aux = datosParaClasificar[i];
                                    j = i - inc;
                                    while (j >= 0 && aux > datosParaClasificar[j]) {
                                            intercambiar(datosParaClasificar, j, j + inc);
                                            j = j-inc;
                                    }
                                    datosParaClasificar[j+inc] = aux;
                           
                            }
                    }
            }
            
            return datosParaClasificar;
    }


    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
            if (datosParaClasificar != null) {
                //Cambié int i = 2 a int i = 1 porque el array empieza en 0.
                    for (int i = 1; i < datosParaClasificar.length; i++) {
                            int aux = datosParaClasificar[i];
                            int j = i - 1;
                            while ((j >= 0) && (aux < datosParaClasificar[j])) {
                                    intercambiar(datosParaClasificar, j, j + 1);
                                    j--;
                            }
                            datosParaClasificar[j+1] = aux;
                    }
                    return datosParaClasificar;
            }
            return null;
    }
    protected int[] ordenarPorInsercionDescendente(int[] datosParaClasificar) {
            if (datosParaClasificar != null) {
                //Cambié int i = 2 a int i = 1 porque el array empieza en 0.
                    for (int i = 1; i < datosParaClasificar.length; i++) {
                            int aux = datosParaClasificar[i];
                            int j = i - 1;
                            while ((j >= 0) && (aux > datosParaClasificar[j])) {
                                    intercambiar(datosParaClasificar, j, j + 1);
                                    j--;
                            }
                            datosParaClasificar[j+1] = aux;
                    }
                    return datosParaClasificar;
            }
            return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {		
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i < n; i++) {
                    for (int j = n; j > i; j--) {    
                       //Cambié i+1 a i porque el array empieza en 0.
                            if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                                    intercambiar(datosParaClasificar, j, j-1);
                            }
                    }
            }
            return datosParaClasificar;
    }
    private int[] ordenarPorBurbujaDescendente(int[] datosParaClasificar) {		
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i < n; i++) {
                    for (int j = n; j > i; j--) {    
                       //Cambié i+1 a i porque el array empieza en 0.
                            if (datosParaClasificar[j] > datosParaClasificar[j - 1]) {
                                    intercambiar(datosParaClasificar, j, j-1);
                            }
                    }
            }
            return datosParaClasificar;
    }
    
    protected int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int indiceMenor = i;
            int claveMenor = datosParaClasificar[i];
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < claveMenor) {
                    indiceMenor = j;
                    claveMenor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceMenor);
        }
        return datosParaClasificar;
    }
    protected int[] ordenarPorSeleccionDescendente(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int indiceMenor = i;
            int claveMayor = datosParaClasificar[i];
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] > claveMayor) {
                    indiceMenor = j;
                    claveMayor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceMenor);
        }
        return datosParaClasificar;
    }
    
    private int[] ordenarPorSeleccionDummy(int[] datosParaClasificar) {
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i  >= 1; i--) {   
            intercambiar(datosParaClasificar,0,i);
            armaHeap(datosParaClasificar, 0, i-1);
            
        }
        return datosParaClasificar;
    }
    protected int[] ordenarPorHeapSortDescendente(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeapDescendente(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        
        for (int i = datosParaClasificar.length - 1; i  >= 1; i--) { 
            intercambiar(datosParaClasificar,0,i);
            armaHeapDescendente(datosParaClasificar, 0, i-1);
        }
        return datosParaClasificar;
    }
    
    private int[] ordenarPorHeapSortDummy(int[] datosParaClasificar){
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                if (ultimo == 2*r){ //r tiene un hijo solo
                    if (datosParaClasificar[r] < datosParaClasificar[r*2]){
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2*r] < datosParaClasificar[2*r + 1]){
                            posicionIntercambio = 2 * r +1;
                    } else {
                            posicionIntercambio = 2 * r;
                    }
                    if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]){
                            intercambiar(datosParaClasificar,r,posicionIntercambio);
                            r = posicionIntercambio;
                    } else {
                            r = ultimo;
                    }
                }
            }			
        }
    }
    private void armaHeapDescendente(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                if (ultimo == 2*r){ //r tiene un hijo solo
                    if (datosParaClasificar[r] > datosParaClasificar[r*2]){
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else { //r tiene 2 hijos
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
