package clasificacion;

public interface IClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_INSERCION_INVERSO = 12;
    
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_SHELL_INVERSO = 13;
    
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_BURBUJA_INVERSO = 14;
    public static final int METODO_CLASIFICACION_BURBUJA_MEJORADO = 7;
    
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_QUICKSORT_INVERSO = 15;
    
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;
    public static final int METODO_CLASIFICACION_HEAPSORT_INVERSO = 8;
    
    public static final int METODO_CLASIFICACION_SELECCION = 6;
    public static final int METODO_CLASIFICACION_SELECCION_INVERSO = 16;
    
    // Otros
    public static final int METODO_CLASIFICACION_BINSORT = 9;
    public static final int METODO_CLASIFICACION_RADIXSORT = 10;
    public static final int METODO_CLASIFICACION_CUENTA = 11;

    /**
     * Punto de entrada al clasificador. Se le debe pasar en el primer argumento
     * el conjunto de datos a ordenar (array de int) y en el segundo, el
     * algoritmo de ordenaci�n a utilizar. Por ejemplo. clasificar(new
     * int{3,2,1},IClasificador.METODO_CLASIFICACION_INSERCION).
     *
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public abstract int[] clasificar(int[] datosParaClasificar,
            int metodoClasificacion);

    public abstract int[] ordenarPorSeleccion(int[] datosParaClasificar);

    /**
     * @param datosParaClasificar
     * @return
     */
    public abstract int[] ordenarPorHeapSort(int[] datosParaClasificar);

    /**
     * @param datosParaClasificar
     * @return
     */
    public abstract int[] ordenarPorQuickSort(int[] datosParaClasificar);

    /**
     * @param datosParaClasificar
     * @return
     */
    public abstract int[] ordenarPorShell(int[] datosParaClasificar);

    /**
     * @param datosParaClasificar
     * @return
     */
    public abstract int[] ordenarPorInsercion(int[] datosParaClasificar);

    /**
     * @param datosParaClasificar
     * @return
     */
    public abstract int[] ordenarPorCuenta(int[] datosParaClasificar);
    
    /**
     * Determina si un vector está ordenado
     * @param datosParaVerificar
     * @return true si está ordenado
     */
    public abstract boolean estaOrdenado(int[] datosParaVerificar);
    
    /**
     * Determina si un vector está ordenado de forma inversa
     * @param datosParaVerificar
     * @return true si está ordenado
     */
    public abstract boolean estaOrdenadoInverso(int[] datosParaVerificar);
    
    /**
     * Determina si un vector está ordenado y no tiene elementos repetidos
     * @param datosParaVerificar
     * @return true si está ordenado
     */
    public abstract boolean estaOrdenadoSinRepetidos(int[] datosParaVerificar);

}