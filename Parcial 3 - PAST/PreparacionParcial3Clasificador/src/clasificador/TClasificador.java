package clasificador;

import java.util.LinkedList;

public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_SELECCION = 5;
    public static final int METODO_CLASIFICACION_HEAP = 6;
    public static final int METODO_CLASIFICACION_DISTRIBUCION = 7;
    public static final int METODO_CLASIFICACION_RADIX = 8;
    public static final int METODO_CLASIFICACION_BINSORT = 9;
    public static final int METODO_CLASIFICACION_BINSORT_REPETIDOS = 10;

    /**
     * Punto de entrada al clasificador
     *
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
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
            case METODO_CLASIFICACION_DISTRIBUCION:
                return ordenarPorCuentaPorDistrubucion(datosParaClasificar);
            case METODO_CLASIFICACION_RADIX:
                return ordenarPorRadixsort(datosParaClasificar);
            case METODO_CLASIFICACION_BINSORT:
                return ordenarPorBinsort(datosParaClasificar);
            case METODO_CLASIFICACION_BINSORT_REPETIDOS:
                return ordenarPorBinsortRepetidos(datosParaClasificar);
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
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean noCascara, boolean reves) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                if (reves) {
                    return ordenarPorInsercionDescendente(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorInsercion(datosParaClasificar);
                } else {
                    return ordenarPorInsercionCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_SHELL:
                if (reves) {
                    return ordenarPorShellDescendente(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorShell(datosParaClasificar);
                } else {
                    return ordenarPorShellCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BURBUJA:
                if (reves) {
                    return ordenarPorBurbujaDescendente(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorBurbuja(datosParaClasificar);
                } else {
                    return ordenarPorBurbujaCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_QUICKSORT:
                if (reves) {
                    return ordenarPorQuickSortDescendente(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorQuickSort(datosParaClasificar);
                } else {
                    return ordenarPorQuickSortCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_SELECCION:
                if (reves) {
                    return ordenarPorSeleccionDescendente(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorSeleccion(datosParaClasificar);
                } else {
                    return ordenarPorSeleccionCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_HEAP:
                if (reves) {
                    return ordenarPorHeapSortDescendente(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorHeapSort(datosParaClasificar);
                } else {
                    return ordenarPorHeapSortCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_DISTRIBUCION:
                if (reves) {
                    return ordenarPorCuentaPorDistrubucionDesc(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorCuentaPorDistrubucion(datosParaClasificar);
                } else {
                    return ordenarPorDistribucionCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_RADIX:
                if (reves) {
                    return ordenarPorRadixsortDesc(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorRadixsort(datosParaClasificar);
                } else {
                    return ordenarPorRadixCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BINSORT:
                if (reves) {
                    return ordenarPorBinsortDesc(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorBinsort(datosParaClasificar);
                } else {
                    return ordenarPorBinsortCascara(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BINSORT_REPETIDOS:
                if (reves) {
                    return ordenarPorBinsortRepetidosDesc(datosParaClasificar);
                }
                if (noCascara) {
                    return ordenarPorBinsortRepetidos(datosParaClasificar);
                } else {
                    return ordenarPorBinsortRepetidosCascara(datosParaClasificar);
                }
            default:
                System.err.println("ESTO NO DEBERIA PASAR....");
                break;
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorInsercionCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorBurbujaCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorShellCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorSeleccionCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorHeapSortCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorDistribucionCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorRadixCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorBinsortCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    private int[] ordenarPorBinsortRepetidosCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }

    protected int[] ordenarPorQuickSortCascara(int[] datosParaClasificar) {
        quicksortCascara(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }

    private void quicksortCascara(int[] entrada, int i, int j) {
        return;
    }

    public int[] copiar(int[] entrada) {
        int[] salida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            salida[i] = entrada[i];
        }
        return salida;
    }

    private void intercambiar(int[] datos, int pos1, int pos2) {
        int aux = datos[pos2];
        datos[pos2] = datos[pos1];
        datos[pos1] = aux;
    }

    public void imprimirSort(int[] entrada) {
        for (int i = 0; i < entrada.length; i++) {
            System.out.print(entrada[i] + " ");
        }
    }

    public String[] arrayIntToString(int[] entrada) {
        String[] salida = new String[1];
        String txt = "";
        for (int j = 0; j < entrada.length; j++) {
            txt += String.valueOf(entrada[j]) + " ";
        }
        salida[0] = txt;
        return salida;
    }

    /**
     * Método utilizado por QuickSort para encontrar el pivote. Se considera el
     * mayor de los extremos del array
     *
     * @param izquierda
     * @param derecha
     * @param entrada
     * @return
     */
    public int encuentraPivote(int izquierda, int derecha, int[] entrada) {
        return Integer.max(izquierda, derecha);
    }

    /**
     * Método utilizado por QuickSort para encontrar el pivote. Se considera el
     * mayor de los primeros 2 elementos del array
     *
     * @param izquierda
     * @param entrada
     * @return
     */
    public int encuentraPivote(int izquierda, int[] entrada) {
        if (entrada[izquierda] > entrada[izquierda + 1]) {
            return izquierda;
        } else {
            return izquierda + 1;
        }
    }

    /**
     * Método utilizado por QuickSort para encontrar el pivote. Se considera el
     * mayor de los ultimos 2 elementos del array
     *
     * @param derecha
     * @param entrada
     * @return
     */
    public int encuentraPivote(int[] entrada, int derecha) {
        if (entrada[derecha] > entrada[derecha - 1]) {
            return derecha;
        } else {
            return derecha - 1;
        }
    }

    /**
     * Método utilizado por QuickSort para encontrar el pivote. Se considera el
     * mayor de los ultimos 2 elementos del array
     *
     * @param entrada
     * @return
     */
    public int encuentraPivote(int[] entrada, int izq, int der) {
        return (izq + der) / 2;
    }

    //QUICKSORT
    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        int[] contador = new int[1];
        contador[0] = 0;
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, contador);
        return datosParaClasificar;
    }

    protected int[] ordenarPorQuickSortDescendente(int[] datosParaClasificar) {
        int[] contador = new int[1];
        contador[0] = 0;
        quicksortDescendente(datosParaClasificar, 0, datosParaClasificar.length - 1, contador);
        return datosParaClasificar;
    }

    private void quicksort(int[] entrada, int i, int j, int[] contador) {
        contador[0] += 1;
        //if (contador[0]<=12000){
        int izquierda = i;
        int derecha = j;
        //int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
        int posicionPivote = encuentraPivote(entrada, i, j);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            //System.out.println("pivote: "+pivote);
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++;
                }
                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);
                    izquierda++;
                    derecha--;
                }
            }
            if (i < derecha) {
                quicksort(entrada, i, derecha, contador);
            }
            if (izquierda < j) {
                quicksort(entrada, izquierda, j, contador);
            }
        }
        //}
    }

    private void quicksortDescendente(int[] entrada, int i, int j, int[] contador) {
        contador[0] += 1;
        //if (contador[0]<=12000){
        int izquierda = i;
        int derecha = j;
        //int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
        int posicionPivote = encuentraPivote(entrada, i, j);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            //System.out.println("pivote: "+pivote);
            while (izquierda <= derecha) {
                //Ignora todos los números mayores al pivote
                while ((entrada[izquierda] > pivote) && (izquierda < j)) {
                    izquierda++;
                }
                //Ignora todos los numeros menores al pivote
                while ((pivote > entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);
                    izquierda++;
                    derecha--;
                }
            }
            if (i < derecha) {
                quicksortDescendente(entrada, i, derecha, contador);
            }
            if (izquierda < j) {
                quicksortDescendente(entrada, izquierda, j, contador);
            }
        }
        //}
    }

    //SHELLSORT
    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {

            inc = incrementos[posIncrementoActual]; //h
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    int aux = datosParaClasificar[i];
                    j = i - inc;
                    while (j >= 0 && aux < datosParaClasificar[j]) {
                        intercambiar(datosParaClasificar, j, j + inc);
                        j = j - inc;
                    }
                    datosParaClasificar[j + inc] = aux;
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorShellDescendente(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {

            inc = incrementos[posIncrementoActual]; //h
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    int aux = datosParaClasificar[i];
                    j = i - inc;
                    while (j >= 0 && aux > datosParaClasificar[j]) {
                        intercambiar(datosParaClasificar, j, j + inc);
                        j = j - inc;
                    }
                    datosParaClasificar[j + inc] = aux;

                }
            }
        }

        return datosParaClasificar;
    }

    //ORDENAMIENTO POR INSERCION
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
                datosParaClasificar[j + 1] = aux;
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
                datosParaClasificar[j + 1] = aux;
            }
            return datosParaClasificar;
        }
        return null;
    }

    //BUBBLESORT
    protected int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                //Cambié i+1 a i porque el array empieza en 0.
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j, j - 1);
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorBurbujaDescendente(int[] datosParaClasificar) {
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                //Cambié i+1 a i porque el array empieza en 0.
                if (datosParaClasificar[j] > datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j, j - 1);
                }
            }
        }
        return datosParaClasificar;
    }

    //ORDENAMIENTO POR SELECCION
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

    //HEAPSORT
    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);

        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorHeapSortDescendente(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeapDescendente(datosParaClasificar, i, datosParaClasificar.length - 1);
        }

        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeapDescendente(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { //r tiene un hijo solo
                    if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r] < datosParaClasificar[2 * r + 1]) {
                        posicionIntercambio = 2 * r + 1;
                    } else {
                        posicionIntercambio = 2 * r;
                    }
                    if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }

    private void armaHeapDescendente(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { //r tiene un hijo solo
                    if (datosParaClasificar[r] > datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r] > datosParaClasificar[2 * r + 1]) {
                        posicionIntercambio = 2 * r + 1;
                    } else {
                        posicionIntercambio = 2 * r;
                    }
                    if (datosParaClasificar[r] > datosParaClasificar[posicionIntercambio]) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }

    public String ordenadoAscendente(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i] > datos[i + 1]) {
                return "NO. Conjunto desordenado entre los valores " + datos[i] + " y " + datos[i + 1];
            }
        }
        return "SI. Conjunto ordenado ascendentemente";
    }

    public boolean ordenadoAscendenteBoolean(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i] > datos[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public String ordenadoDescendente(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i] < datos[i + 1]) {
                return "NO. Conjunto desordenado entre los valores " + datos[i] + " y " + datos[i + 1];
            }
        }
        return "SI. Conjunto ordenado descendentemente";
    }

    public boolean ordenadoDescendenteBoolean(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i] < datos[i + 1]) {
                return false;
            }
        }
        return true;
    }

    ////////////////////////////////SUPER MEGA DESPEGADOS: CUENTAS POR DISTRIBUCION
    public int[] ordenarPorCuentaPorDistrubucion(int[] datosParaClasificar) {
        int u = this.getMin(datosParaClasificar);
        int v = this.getMax(datosParaClasificar);
        //System.out.println("Min: "+u + " - Max: "+v);

        int[] R = this.copiar(datosParaClasificar);
        int[] S = new int[R.length];
        if (v != -1 && u != Integer.MAX_VALUE) {
            int[] cuenta = new int[v + 1];

            //Inicializo el vector de cuentas
            for (int i = u; i <= v; i++) {
                cuenta[i] = 0;
            }

            //Actualizo el vector de cuentas con las ocurrencias de cada valor
            for (int j = 0; j < R.length; j++) {
                cuenta[R[j]] += 1;
            }

            //Cuenta la distribución final de los elementos
            for (int i = 1; i <= v; i++) {
                cuenta[i] = cuenta[i] + cuenta[i - 1];
            }

            //Verifico el contenido de R
            for (int i = 0; i < R.length; i++) {
                //System.out.println("Valor="+R[i]+" - Pos: "+i);
            }
            //System.out.println("");

            //Verifico que el verctor CUENTA este correcto con cada valor hasta su posicion
            for (int a = 0; a < cuenta.length; a++) {
                //System.out.println("Cuenta: "+cuenta[a]+" - Pos: "+a);
            }

            //Inserta los valores en el array de salida
            for (int h = R.length - 1; h >= 0; h--) {
                int i = cuenta[R[h]];
                S[i - 1] = R[h];
                cuenta[R[h]] = i - 1;
            }
        }
        return S;
    }

    public int[] ordenarPorCuentaPorDistrubucionDesc(int[] datosParaClasificar) {
        int u = this.getMin(datosParaClasificar);
        int v = this.getMax(datosParaClasificar);
        //System.out.println("Min: "+u + " - Max: "+v);

        int[] R = this.copiar(datosParaClasificar);
        int[] S = new int[R.length];
        if (v != -1 && u != Integer.MAX_VALUE) {
            int[] cuenta = new int[v + 1];

            //Inicializo el vector de cuentas
            for (int i = u; i <= v; i++) {
                cuenta[i] = 0;
            }

            //Actualizo el vector de cuentas con las ocurrencias de cada valor
            for (int j = 0; j < R.length; j++) {
                cuenta[R[j]] += 1;
            }

            //Cuenta la distribución final de los elementos
            for (int i = v - 1; i >= 0; i--) {
                cuenta[i] = cuenta[i] + cuenta[i + 1];
            }

            //Verifico el contenido de R
            for (int i = 0; i < R.length; i++) {
                // System.out.println("Valor=" + R[i] + " - Pos: " + i);
            }
            //System.out.println("");

            //Verifico que el verctor CUENTA este correcto con cada valor hasta su posicion
            for (int a = 0; a < cuenta.length; a++) {
                //System.out.println("Cuenta: " + cuenta[a] + " - Pos: " + a);
            }

            //Inserta los valores en el array de salida
            for (int h = R.length - 1; h >= 0; h--) {
                int i = cuenta[R[h]];
                S[i - 1] = R[h];
                cuenta[R[h]] = i - 1;
            }
        }
        return S;
    }

    private int getMin(int[] entrada) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < entrada.length; j++) {
            if (entrada[j] < min) {
                min = entrada[j];
            }
        }
        return min;
    }

    private int getMax(int[] entrada) {
        int max = -1;
        for (int j = 0; j < entrada.length; j++) {
            if (entrada[j] > max) {
                max = entrada[j];
            }
        }
        return max;
    }

    ////////////////////////////////SUPER MEGA DESPEGADOS: CUENTAS POR DISTRIBUCION CON CHAR
    public char[] ordenarPorCuentaPorDistrubucionChars(char[] datosParaClasificar) {
        int N = datosParaClasificar.length;
        char[] R = this.copiar(datosParaClasificar);
        char[] S = new char[N];
        int[] cuenta = new int[256];

        //Inicializo el vector de cuentas
        for (int i = 0; i < 256; i++) {
            cuenta[i] = 0;
        }

        //Actualizo el vector de cuentas con las ocurrencias de cada valor
        for (int j = 0; j < N; j++) {
            cuenta[R[j]] += 1;
        }

        //Cuenta la distribución final de los elementos
        for (int i = 1; i < 256; i++) {
            cuenta[i] = cuenta[i] + cuenta[i - 1];
        }

        //Inserta los valores en el array de salida
        for (int h = N - 1; h >= 0; h--) {
            int i = cuenta[R[h]];
            S[i - 1] = R[h];
            cuenta[R[h]] = i - 1;
        }
        return S;
    }

    public char[] ordenarPorCuentaPorDistrubucionCharsDesc(char[] datosParaClasificar) {
        int N = datosParaClasificar.length;
        char[] R = this.copiar(datosParaClasificar);
        char[] S = new char[N];
        int[] cuenta = new int[256];

        //Inicializo el vector de cuentas
        for (int i = 0; i < 256; i++) {
            cuenta[i] = 0;
        }

        //Actualizo el vector de cuentas con las ocurrencias de cada valor
        for (int j = 0; j < N; j++) {
            cuenta[R[j]] += 1;
        }

        //Cuenta la distribución final de los elementos
        for (int i = 254; i >= 0; i--) {
            cuenta[i] = cuenta[i] + cuenta[i + 1];
        }

        //Inserta los valores en el array de salida
        for (int h = N - 1; h >= 0; h--) {
            int i = cuenta[R[h]];
            S[i - 1] = R[h];
            cuenta[R[h]] = i - 1;
        }
        return S;
    }

    public char[] copiar(char[] entrada) {
        char[] salida = new char[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            salida[i] = entrada[i];
        }
        return salida;
    }
    ////////////////////////////////SUPER MEGA DESPEGADOS: RADIX SORT

    public int[] ordenarPorRadixsort(int[] datosParaClasificar) {
        Integer max = datosParaClasificar[0];
        for (int i = 1; i < datosParaClasificar.length; i++) {
            if (datosParaClasificar[i] > max) {               //me quedo con el de mayor digitos
                max = datosParaClasificar[i];
            }
        }
        int digitos = max.toString().length();

        for (int i = digitos - 1; i >= 0; i--) {
            LinkedList[] vector = new LinkedList[10];         //vector de listas de 0 a 9
            for (int m = 0; m < vector.length; m++) {
                vector[m] = new LinkedList();
            }
            for (int j = 0; j < datosParaClasificar.length; j++) { //recorro todo el vector
                String lugarEnUrna = String.valueOf(datosParaClasificar[j]);
                while (lugarEnUrna.length() < digitos) {
                    lugarEnUrna = "0" + lugarEnUrna;
                }
                char var = lugarEnUrna.toCharArray()[i];
                Integer varInt = Integer.parseInt(var + "");
                vector[varInt].add(datosParaClasificar[j]);
            }
            //concatenamos la lista, armamos datos para clasificar ordenado 
            int cont = 0;
            for (int h = 0; h < vector.length; h++) {
                for (int k = 0; k < vector[h].size(); k++) {
                    datosParaClasificar[cont] = (Integer) vector[h].get(k);
                    cont++;
                }
            }
        }
        return datosParaClasificar;
    }

    public int[] ordenarPorRadixsortDesc(int[] datosParaClasificar) {
        //Identifico la cantidad de claves a recorrer
        Integer max = datosParaClasificar[0];
        for (int i = 1; i < datosParaClasificar.length; i++) {
            if (datosParaClasificar[i] > max) {               //me quedo con el de mayor digitos
                max = datosParaClasificar[i];
            }
        }
        int digitos = max.toString().length();

        //Recorro las claves desde el dígito menos significativo hacia el más significativo
        for (int i = digitos - 1; i >= 0; i--) {
            LinkedList[] vector = new LinkedList[10];         //vector de listas de 0 a 9
            for (int m = 0; m < vector.length; m++) {
                vector[m] = new LinkedList();
            }
            for (int j = 0; j < datosParaClasificar.length; j++) { //recorro todo el vector
                String lugarEnUrna = String.valueOf(datosParaClasificar[j]);
                while (lugarEnUrna.length() < digitos) {
                    lugarEnUrna = "0" + lugarEnUrna;
                }
                char var = lugarEnUrna.toCharArray()[i];
                Integer varInt = Integer.parseInt(var + "");
                vector[varInt].add(datosParaClasificar[j]);
            }
            //concatenamos la lista, armamos datos para clasificar ordenado
            int cont = 0;
            for (int h = vector.length - 1; h >= 0; h--) {
                for (int k = 0; k < vector[h].size(); k++) {
                    datosParaClasificar[cont] = (Integer) vector[h].get(k);
                    cont++;
                }
            }
        }
        return datosParaClasificar;
    }

    ////////////////////////////////SUPER MEGA DESPEGADOS: BINSORT
    public int[] ordenarPorBinsort(int[] datos) {
        if (datos != null) {
            int max = this.getMax(datos);
            //LinkedList<Integer> lista = new LinkedList<>();
            int[] vector = new int[max + 1];
            for (int i = 0; i <= max; i++) {
                vector[i] = -1;
            }
            for (int i = 0; i < datos.length; i++) {
                vector[datos[i]] = datos[i];
            }
            //Solo si necesitamos una lista con los elementos ordenados
            //SINO NO VA
            //        for(int i=0;i<vector.length;i++){
            //            if (datos[i]>-1){
            //                lista.add(datos[i]);
            //            }
            //        }
            return vector;
        }
        return null;
    }

    public int[] ordenarPorBinsortDesc(int[] datos) {
        int max = this.getMax(datos);
        int[] vector = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            vector[i] = -1;
        }
        int N = max + 1;
        for (int i = datos.length - 1; i >= 0; i--) {
            if (datos[i] > -1) {
                int posInvertida = N - datos[i] - 1;
                //System.out.println("N="+N+" - datos[i]="+datos[i]+" - posInvertida="+posInvertida);
                vector[posInvertida] = datos[i];
            }
        }
        return vector;
    }

    public int[] ordenarPorBinsortRepetidos(int[] datos) {
        int max = this.getMax(datos);
        int[] vector = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            vector[i] = -1;
        }
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > -1) {
                System.out.println("datos[i]=" + datos[i] + " - i=" + i);
                vector[datos[i]] += 1;
            }
        }
        return vector;
    }

    public int[] ordenarPorBinsortRepetidosDesc(int[] datos) {
        int max = this.getMax(datos);
        int[] vector = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            vector[i] = -1;
        }
        int N = max + 1;
        for (int i = datos.length - 1; i >= 0; i--) {
            if (datos[i] > -1) {
                int posInvertida = N - datos[i] - 1;
                //System.out.println("N="+N+" - datos[i]="+datos[i]+" - posInvertida="+posInvertida);
                vector[posInvertida] += 1;
            }
        }
        return vector;
    }

    public String[] arrayIntToStringBinsort(int[] entrada) {
        String[] salida = new String[1];
        String txt = "";
        for (int j = 0; j < entrada.length; j++) {
            if (entrada[j] > -1) {
                //System.out.println(s);
                txt += String.valueOf(entrada[j]) + " ";
            }
        }
        salida[0] = txt;
        return salida;
    }

    public String[] arrayIntToStringBinsortRepetidos(int[] entrada) {
        String[] salida = new String[1];
        String txt = "";
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] != -1) {
                if (entrada[i] > 0) {
                    for (int j = entrada[i]; j >= 0; j--) {
                        txt += i + " ";
                    }
                } else {
                    txt += i + " ";
                }
            }
        }
        salida[0] = txt;
        return salida;
    }

    public String[] arrayIntToStringBinsortRepetidosDesc(int[] entrada) {
        String[] salida = new String[1];
        String txt = "";
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] != -1) {
                int posInvertida = entrada.length - i - 1;
                if (entrada[i] > 0) {
                    for (int j = entrada[i]; j >= 0; j--) {
                        txt += posInvertida + " ";
                    }
                } else {
                    txt += posInvertida + " ";
                }

                //System.out.println("\nentrada[i]="+entrada[i]+" - posInvertida="+posInvertida+" - i="+i);
            }
        }
        salida[0] = txt;
        return salida;
    }

    public void imprimirBinsortRepetidos(int[] entrada) {
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] != -1) {
                if (entrada[i] > 0) {
                    for (int j = entrada[i]; j >= 0; j--) {
                        System.out.print(i + " ");
                    }
                } else {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public void imprimirBinsortRepetidosDesc(int[] entrada) {
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] != -1) {
                int posInvertida = entrada.length - i - 1;
                if (entrada[i] > 0) {
                    for (int j = entrada[i]; j >= 0; j--) {
                        System.out.print(posInvertida + " ");
                    }
                } else {
                    System.out.print(posInvertida + " ");
                }

                //System.out.println("\nentrada[i]="+entrada[i]+" - posInvertida="+posInvertida+" - i="+i);
            }
        }
    }

    public void imprimirBinsort(int[] entrada) {
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] > -1) {
                System.out.print(entrada[i] + " ");
            }
        }
    }
    
    public String ordenadoAscendenteBinSort(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i]>datos[i+1] && datos[i]!=-1 && datos[i+1]!=-1){
                return  "NO. Conjunto desordenado entre los valores "+datos[i] +" y "+ datos[i+1];
            }
        }
        return "SI. Conjunto ordenado ascendentemente";
    }
    public String ordenadoDescendenteBinSort(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i]<datos[i+1] && datos[i]!=-1 && datos[i+1]!=-1){
                return  "NO. Conjunto desordenado entre los valores "+datos[i] +" y "+ datos[i+1];
            }
        }
        return "SI. Conjunto ordenado descendentemente.";
    }
    
    public String ordenadoDescendenteBinSortRepetidos(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            int posInvertida = datos.length -i -1;
            if(posInvertida<posInvertida+1){
                return  "NO. Conjunto desordenado entre los valores "+posInvertida +" y "+ posInvertida+1;
            }
        }
        return "SI. Conjunto ordenado descendentemente.";
    }
}
