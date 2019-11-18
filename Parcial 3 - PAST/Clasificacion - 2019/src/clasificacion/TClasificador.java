package clasificacion;

import java.util.Random;

public class TClasificador implements IClasificador {
    
    public static final int ALEATORIO = 1;
    public static final int DESCENDENTE = 2;
    public static final int ASCENDENTE = 3;
    
    public static final long TIEMPO_RESOLUCION = 10000000;

    public static void main(String args[]) {
        IClasificador clasif = new TClasificador();
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        
        /*
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            //System.out.println(resAleatorio[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resAleatorio));
        
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < vectorAscendente.length; i++) {
            //System.out.println(resAscendente[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resAscendente));
        
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
            //System.out.println(resDescendente[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resDescendente));
        */
        
        /*
        int[] vectorAleatorio = gdg.generarDatosAleatorios(300);
        int[] vectorAscendente = gdg.generarDatosAscendentes(300);
        int[] vectorDescendente = gdg.generarDatosDescendentes(300);
        
        int[] vectorAleatorio2 = gdg.generarDatosAleatorios(10000);
        int[] vectorAscendente2 = gdg.generarDatosAscendentes(10000);
        int[] vectorDescendente2 = gdg.generarDatosDescendentes(10000);
        
        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            //System.out.println(resAleatorio[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resAleatorio));
        
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < vectorAscendente.length; i++) {
            //System.out.println(resAscendente[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resAscendente));
        
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
            //System.out.println(resDescendente[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resDescendente));
        
        // Los de 10000...
        
        int[] resAleatorio2 = clasif.clasificar(vectorAleatorio2,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio2.length; i++) {
            //System.out.println(resAleatorio2[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resAleatorio2));
        
        int[] resAscendente2 = clasif.clasificar(vectorAscendente2,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < vectorAscendente2.length; i++) {
            //System.out.println(resAscendente2[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resAscendente2));
        
        int[] resDescendente2 = clasif.clasificar(vectorDescendente2,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente2.length; i++) {
            //System.out.println(resDescendente2[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(resDescendente2));
        */
        
        /*
        System.out.println(obtenerMinimo(new int[]{4, 3, 1, 5, 6, 4}));
        System.out.println(obtenerMinimo(new int[]{4, 3, 1, 5, 6, 4}, 0, 1));
        System.out.println(obtenerMinimo(new int[]{4, 3, 1, 5, 6, 4}, 3, 5));
        */
        
        //System.exit(0);
        
        long tiempo;
        TClasificador tc = new TClasificador();
        int[] tamanios = new int[]{300, 10000, 30000};
        for (int tamanio : tamanios) {
            System.out.println("");
            System.out.println("Tamaño = " + tamanio);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_INSERCION, ALEATORIO, tamanio);
            System.out.println("tiempo INSERCIÓN aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_INSERCION, ASCENDENTE, tamanio);
            System.out.println("tiempo INSERCIÓN ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_INSERCION, DESCENDENTE, tamanio);
            System.out.println("tiempo INSERCIÓN descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SHELL, ALEATORIO, tamanio);
            System.out.println("tiempo SHELL aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SHELL, ASCENDENTE, tamanio);
            System.out.println("tiempo SHELL ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SHELL, DESCENDENTE, tamanio);
            System.out.println("tiempo SHELL descendente: " + tiempo);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_QUICKSORT, ALEATORIO, tamanio);
            System.out.println("tiempo QUICKSORT aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_QUICKSORT, ASCENDENTE, tamanio);
            System.out.println("tiempo QUICKSORT ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_QUICKSORT, DESCENDENTE, tamanio);
            System.out.println("tiempo QUICKSORT descendente: " + tiempo);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA, ALEATORIO, tamanio);
            System.out.println("tiempo BURBUJA aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA, ASCENDENTE, tamanio);
            System.out.println("tiempo BURBUJA ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA, DESCENDENTE, tamanio);
            System.out.println("tiempo BURBUJA descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_HEAPSORT, ALEATORIO, tamanio);
            System.out.println("tiempo HEAPSORT aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_HEAPSORT, ASCENDENTE, tamanio);
            System.out.println("tiempo HEAPSORT ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_HEAPSORT, DESCENDENTE, tamanio);
            System.out.println("tiempo HEAPSORT descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SELECCION, ALEATORIO, tamanio);
            System.out.println("tiempo SELECCION aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SELECCION, ASCENDENTE, tamanio);
            System.out.println("tiempo SELECCION ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SELECCION, DESCENDENTE, tamanio);
            System.out.println("tiempo SELECCION descendente: " + tiempo);
        }
    }

    /**
     * Punto de entrada al clasificador
     *
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    @Override
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
            case METODO_CLASIFICACION_BURBUJA_MEJORADO:
                return ordenarPorBurbujaMejorado(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCION:
                return ordenarPorSeleccion(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }
    
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                if (cascara) {
                    return ordenarPorInsercionCascara(datosParaClasificar);
                } else {
                    return ordenarPorInsercion(datosParaClasificar);
                }
            case METODO_CLASIFICACION_SHELL:
                if (cascara) {
                    return ordenarPorShellCascara(datosParaClasificar);
                } else {
                    return ordenarPorShell(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BURBUJA:
                if (cascara) {
                    return ordenarPorBurbujaCascara(datosParaClasificar);
                } else {
                    return ordenarPorBurbuja(datosParaClasificar);
                }
            case METODO_CLASIFICACION_QUICKSORT:
                if (cascara) {
                    return ordenarPorQuicksortCascara(datosParaClasificar);
                } else {
                    return ordenarPorQuickSort(datosParaClasificar);
                }
            case METODO_CLASIFICACION_HEAPSORT:
                if (cascara) {
                    return ordenarPorHeapSortCascara(datosParaClasificar);
                } else {
                    return ordenarPorHeapSort(datosParaClasificar);
                }
            case METODO_CLASIFICACION_SELECCION:
                if (cascara) {
                    return ordenarPorSeleccionCascara(datosParaClasificar);
                } else {
                    return ordenarPorSeleccion(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BURBUJA_MEJORADO:
                System.err.println("Agregar...");
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    @Override
    public int[] ordenarPorShell(int[] datosParaClasificar) {
        //int j, inc;
        int j, inc, comparaciones;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};
        
        comparaciones = 0;

        //for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) { // ERROR 1
        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    //while ((j >= 0) && (datosParaClasificar[j + inc] > datosParaClasificar[j])) {
                    while ((j >= 0) && (datosParaClasificar[j + inc] < datosParaClasificar[j])) {
                        comparaciones++;
                        intercambiar(datosParaClasificar, j, j + inc);
                        //j = j--;
                        //j--;
                        j = j - inc;
                    }
                }
            }
        }
        //System.out.println("Comparaciones shell: " + comparaciones);
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorShellCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    @Override
    public int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            int comparaciones = 0;
            //for (int i = 2; i < datosParaClasificar.length; i++) { // error que tenía el algoritmo
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                //while ((j >= 0) && (datosParaClasificar[j + 1] > datosParaClasificar[j])) {
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    comparaciones++;
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            //System.out.println("Comparaciones inserción: " + comparaciones);
            return datosParaClasificar;
        }
        return null;
    }
       
    protected int[] ordenarPorInsercionCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        //datosParaClasificar = null; // ???????
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        intercambiar(datosParaClasificar, j - 1, j);
                    }
                }
            }
            return datosParaClasificar;
        }
        return null;
    }
    
    protected int[] ordenarPorBurbujaCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }
    
    private int[] ordenarPorBurbujaMejorado(int[] datosParaClasificar) {
        //datosParaClasificar = null;
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                boolean huboIntercambio = false;
                for (int j = n; j >= (i + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        huboIntercambio = true;
                        intercambiar(datosParaClasificar, j - 1, j);
                    }
                }
                if (!huboIntercambio) break;
            }
            return datosParaClasificar;
        }
        return null;
    }
    
    @Override
    public int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quickSort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorQuicksortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }
    
    private void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto + 1) {
            int p = particion(arreglo, bajo, alto);
            quickSort(arreglo, bajo, p - 1);
            quickSort(arreglo, p + 1, alto);
        }
    }
    
    private int particion(int[] arreglo, int bajo, int alto) {
        intercambiar(arreglo, bajo, obtenerPivote(bajo, alto));
        //intercambiar(arreglo, bajo, obtenerPivote(arreglo, bajo, alto));
        int borde = bajo + 1;
        for (int i = borde; i <= alto; i++) {
            if (arreglo[i] < arreglo[bajo]) {
                intercambiar(arreglo, i, borde);
                borde++;
            }
        }
        intercambiar(arreglo, bajo, borde - 1);
        return borde - 1;
    }
    
    //private int obtenerPivote(int[] arreglo, int bajo, int alto) {
    private int obtenerPivote(int bajo, int alto) {
        Random rand = new Random();
        return rand.nextInt((alto - bajo) + 1) + bajo;

        /*
        // Usando "median of three"
        int centro = (bajo + alto) / 2;

        if (arreglo[bajo] > arreglo[centro]) {
            intercambiar(arreglo, bajo, centro);
        }

        if (arreglo[bajo] > arreglo[alto]) {
            intercambiar(arreglo, bajo, alto);
        }

        if (arreglo[centro] > arreglo[alto]) {
            intercambiar(arreglo, centro, alto);
        }

        intercambiar(arreglo, centro, alto - 1);
        return arreglo[alto - 1];
        */
    }

    @Override
    public int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        int tope = datosParaClasificar.length - 1;
        int indMin;
        
        for (int i = 0; i <= tope; i++) {
            indMin = obtenerMinimo(datosParaClasificar, i, tope);
            // Sólo intercambio si son distintos índices
            if (indMin != i)
                intercambiar(datosParaClasificar, i, indMin);
        }
        
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorSeleccionCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }
    
    /**
     * Retorna índice del valor mínimo de un arreglo
     * @param arreglo
     * @return índice del valor mínimo
     */
    public static int obtenerMinimo(int[] arreglo) {
        return obtenerMinimo(arreglo, 0, arreglo.length - 1);
    }
    
    /**
     * Retorna índice del valor mínimo de un arreglo
     * @param arreglo
     * @param izq índice izquierda
     * @param der índice derecha
     * @return índice del valor mínimo
     */
    public static int obtenerMinimo(int[] arreglo, int izq, int der) {
        int indice = izq;
        int valor = arreglo[izq];
        
        if (izq > der)
            return -1;
        
        for (int i = izq; i <= der; i++) {
            if (arreglo[i] < valor) {
                indice = i;
                valor = arreglo[i];
            }
        }
        
        return indice;
    }

//    @Override
//    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
//        // Implementar m�todo aqu�
//        return null;
//    }
    
    //protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorHeapSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            //while (r <= ultimo / 2) {
            while (r <= Math.floorDiv(ultimo - 1, 2)) {
                if (ultimo == (2 * r + 1)) { //r tiene un hijo solo
                    //if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
                    if (datosParaClasificar[r] > datosParaClasificar[r * 2 + 1]) {
                        intercambiar(datosParaClasificar, r, 2 * r + 1);
                        //r = 2;
                    }
                    //} else {
                    r = ultimo;
                    //}
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r + 1] > datosParaClasificar[2 * r + 2]) {
                        posicionIntercambio = 2 * r + 2;
                    } else {
                        posicionIntercambio = 2 * r + 1;
                    }
                    //if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
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

    @Override
    public int[] ordenarPorCuenta(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    @Override
    public boolean estaOrdenado(int[] datosParaVerificar) {
        for (int i = 0; i < datosParaVerificar.length - 1; i++) {
            if (datosParaVerificar[i] > datosParaVerificar[i + 1]) {
                System.out.println(String.format("%d (índice %d) > %d (índice %d)", datosParaVerificar[i], i, datosParaVerificar[i + 1], (i + 1)));
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean estaOrdenadoInverso(int[] datosParaVerificar) {
        for (int i = 0; i < datosParaVerificar.length - 1; i++) {
            if (datosParaVerificar[i] < datosParaVerificar[i + 1]) {
                System.out.println(String.format("%d (índice %d) < %d (índice %d)", datosParaVerificar[i], i, datosParaVerificar[i + 1], (i + 1)));
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean estaOrdenadoSinRepetidos(int[] datosParaVerificar) {
        for (int i = 0; i < datosParaVerificar.length - 1; i++) {
            if (datosParaVerificar[i] >= datosParaVerificar[i + 1]) {
                System.out.println(String.format("%d (índice %d) >= %d (índice %d)", datosParaVerificar[i], i, datosParaVerificar[i + 1], (i + 1)));
                return false;
            }
        }
        return true;
    }
    
    public long medirAlgoritmo(int algoritmo, int tipoOrden, int tamanio) {
        IGeneradorDatos gen = new GeneradorDatosGenericos();
        int[] vectorOriginal, resultado;
        
        // Tipo de vectores generados
        switch (tipoOrden) {
            case ALEATORIO:
                vectorOriginal = gen.generarDatosAleatorios(tamanio);
                break;
            case ASCENDENTE:
                vectorOriginal = gen.generarDatosAscendentes(tamanio);
                break;
            case DESCENDENTE:
                vectorOriginal = gen.generarDatosDescendentes(tamanio);
                break;
            default:
                return -1;
        }
        
        // con el generador de datos aleatorios, para el tamaño T, en orden “tipoOrden”
        //ascendente, descendente o aleatorio)
        long t1 = System.nanoTime();
        long total = 0;
        int cantLlamadas = 0;
        while (total < TIEMPO_RESOLUCION) {
            // cuidado con las unidades que retornan las funciones
            cantLlamadas++;
            int[] datosCopia = vectorOriginal.clone();
            // tenemos que trabajar siempre con los mismos datos
            resultado = this.clasificar(datosCopia, algoritmo, false);
            //long t2 = System.nanoTime();
            total = System.nanoTime() - t1;
        }
        long tiempoMedioAlgoritmoBase = total/cantLlamadas;
        // lo que lleva ejecutar 1 vez el algoritmo, para ese conjunto de datos
        // ahora tenemos que calcular cuánto se fue en las “cáscaras” y descontarlo
        vectorOriginal = gen.generarDatosAscendentes(tamanio);
        // con el generador de datos aleatorios, para el tamaño T, en orden “tipoOrden”
        //ascendente, descendente o aleatorio)
        
        t1 = System.nanoTime();
        total = 0;
        cantLlamadas = 0;
        while (total < TIEMPO_RESOLUCION) {
            // cuidado con las unidades que retornan las funciones
            cantLlamadas++;
            int[] datosCopia = vectorOriginal.clone();
            resultado = this.clasificar(datosCopia, algoritmo, true);
            // EJECUTA LAS LLAMADAS AL MÉTODO (“vacias”)
            //long t2 = System.nanoTime();
            total = System.nanoTime() - t1;
        }
        long tiempoMedioCascara = total/cantLlamadas;
        
        // lo que lleva ejecutar 1 vez la infraestructura del algoritmo, para ese
        // conjunto de datos
        long tiempoMedioAlgoritmo = tiempoMedioAlgoritmoBase - tiempoMedioCascara;
        return tiempoMedioAlgoritmo;
    }
}