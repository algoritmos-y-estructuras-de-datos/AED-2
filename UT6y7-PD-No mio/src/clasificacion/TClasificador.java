package clasificacion;

import java.util.ArrayList;
import java.util.Random;

public class TClasificador implements IClasificador {
    
    public static final int ALEATORIO = 1;
    public static final int DESCENDENTE = 2;
    public static final int ASCENDENTE = 3;
    
    public static final int MAXIMO_CUENTA = 30000;
    
    public static final long TIEMPO_RESOLUCION = 10000000;

    public static void main(String args[]) {
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        TClasificador tc = new TClasificador();
        int[] vectorAleatorio, vectorAscendente, vectorDescendente;
        
        long tiempo;
        int[] tamanios = new int[]{300, 10000, 30000};
        for (int tamanio : tamanios) {
            System.out.println("");
            System.out.println("Tamaño = " + tamanio);
            
            vectorAleatorio = gdg.generarDatosAleatorios(tamanio);
            vectorAscendente = gdg.generarDatosAscendentes(tamanio);
            vectorDescendente = gdg.generarDatosDescendentes(tamanio);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_INSERCION, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo INSERCIÓN aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_INSERCION, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo INSERCIÓN ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_INSERCION, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo INSERCIÓN descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SHELL, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo SHELL aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SHELL, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo SHELL ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SHELL, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo SHELL descendente: " + tiempo);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_QUICKSORT, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo QUICKSORT aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_QUICKSORT, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo QUICKSORT ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_QUICKSORT, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo QUICKSORT descendente: " + tiempo);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BURBUJA aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BURBUJA ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BURBUJA descendente: " + tiempo);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA_MEJORADO, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BURBUJA MEJORADO aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA_MEJORADO, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BURBUJA MEJORADO ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BURBUJA_MEJORADO, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BURBUJA MEJORADO descendente: " + tiempo);

            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_HEAPSORT, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo HEAPSORT aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_HEAPSORT, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo HEAPSORT ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_HEAPSORT, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo HEAPSORT descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SELECCION, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo SELECCION aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SELECCION, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo SELECCION ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_SELECCION, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo SELECCION descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BINSORT, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BINSORT aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BINSORT, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BINSORT ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_BINSORT, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo BINSORT descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_RADIXSORT, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo RADIXSORT aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_RADIXSORT, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo RADIXSORT ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_RADIXSORT, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo RADIXSORT descendente: " + tiempo);
            
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_CUENTA, ALEATORIO, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo CUENTA aleatorio: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_CUENTA, ASCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo CUENTA ascendente: " + tiempo);
            tiempo = tc.medirAlgoritmo(METODO_CLASIFICACION_CUENTA, DESCENDENTE, tamanio, vectorAleatorio, vectorAscendente, vectorDescendente);
            System.out.println("tiempo CUENTA descendente: " + tiempo);
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
            case METODO_CLASIFICACION_INSERCION_INVERSO:
                return ordenarPorInsercionInverso(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL_INVERSO:
                return ordenarPorShellInverso(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA_INVERSO:
                return ordenarPorBurbujaInverso(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA_MEJORADO:
                return ordenarPorBurbujaMejorado(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT_INVERSO:
                return ordenarPorQuickSortInverso(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT_INVERSO:
                return ordenarPorHeapSortInverso(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCION:
                return ordenarPorSeleccion(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCION_INVERSO:
                return ordenarPorSeleccionInverso(datosParaClasificar);
            // Otros algoritmos....
            case METODO_CLASIFICACION_BINSORT:
                return ordenarPorBinsort(datosParaClasificar);
            case METODO_CLASIFICACION_RADIXSORT:
                return ordenarPorRadixsort(datosParaClasificar);
            case METODO_CLASIFICACION_CUENTA:
                return ordenarPorCuenta(datosParaClasificar);
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
                if (cascara) {
                    return ordenarPorBurbujaMejoradoCascara(datosParaClasificar);
                } else {
                    return ordenarPorBurbujaMejorado(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BINSORT:
                if (cascara) {
                    return ordenarPorBinsortCascara(datosParaClasificar);
                } else {
                    return ordenarPorBinsort(datosParaClasificar);
                }
            case METODO_CLASIFICACION_RADIXSORT:
                if (cascara) {
                    return ordenarPorRadixsortCascara(datosParaClasificar);
                } else {
                    return ordenarPorRadixsort(datosParaClasificar);
                }
            case METODO_CLASIFICACION_CUENTA:
                if (cascara) {
                    return ordenarPorCuenta(datosParaClasificar);
                } else {
                    return ordenarPorCuentaCascara(datosParaClasificar);
                }
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
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while ((j >= 0) && (datosParaClasificar[j + inc] < datosParaClasificar[j])) {
                        intercambiar(datosParaClasificar, j, j + inc);
                        j = j - inc;
                    }
                }
            }
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorShellInverso(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    //while ((j >= 0) && (datosParaClasificar[j + inc] < datosParaClasificar[j])) {
                    while ((j >= 0) && (datosParaClasificar[j] < datosParaClasificar[j + inc])) {
                        intercambiar(datosParaClasificar, j, j + inc);
                        j = j - inc;
                    }
                }
            }
        }
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
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }
    
    protected int[] ordenarPorInsercionInverso(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                //while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                while ((j >= 0) && (datosParaClasificar[j] < datosParaClasificar[j + 1])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
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

    public int[] ordenarPorBurbuja(int[] datosParaClasificar) {
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
    
    public int[] ordenarPorBurbujaInverso(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                    //if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    if (datosParaClasificar[j - 1] < datosParaClasificar[j]) {
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
    
    protected int[] ordenarPorBurbujaMejoradoCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }
    
    @Override
    public int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        //quickSort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorQuicksortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }
    
    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote = encuentraPivote(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++;
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) {
                quicksort(entrada, i, izquierda - 1);
            }
            if (izquierda < j) {
                quicksort(entrada, izquierda, j);
            }
        }
    }
    
    protected int[] ordenarPorQuickSortInverso(int[] datosParaClasificar) {
        //quickSort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        quicksortInverso(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }
    
    private void quicksortInverso(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote = encuentraPivote(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            //while (izquierda <= derecha) {
            while (izquierda < derecha) {
                //while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                while ((entrada[izquierda] > pivote) && (izquierda < j)) {
                    izquierda++;
                }

                //while ((pivote < entrada[derecha]) && (derecha > i)) {
                while ((pivote > entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) {
                //quicksort(entrada, i, izquierda - 1);
                quicksortInverso(entrada, i, derecha);
            }
            if (izquierda < j) {
                quicksortInverso(entrada, izquierda, j);
            }
        }
    }
    
//    private void quickSort(int[] arreglo, int bajo, int alto) {
//        if (bajo < alto + 1) {
//            int p = particion(arreglo, bajo, alto);
//            quickSort(arreglo, bajo, p - 1);
//            quickSort(arreglo, p + 1, alto);
//        }
//    }
    
//    private int particion(int[] arreglo, int bajo, int alto) {
//        intercambiar(arreglo, bajo, obtenerPivote(bajo, alto));
//        //intercambiar(arreglo, bajo, obtenerPivote(arreglo, bajo, alto));
//        int borde = bajo + 1;
//        for (int i = borde; i <= alto; i++) {
//            if (arreglo[i] < arreglo[bajo]) {
//                intercambiar(arreglo, i, borde);
//                borde++;
//            }
//        }
//        intercambiar(arreglo, bajo, borde - 1);
//        return borde - 1;
//    }
    
    private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
        return (derecha-izquierda)/2+izquierda;
        //return ((izquierda + derecha) / 2);
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
    
    protected int[] ordenarPorSeleccionInverso(int[] datosParaClasificar) {
        int tope = datosParaClasificar.length - 1;
        int indMin;
        
        //for (int i = 0; i <= tope; i++) {
        for (int i = tope; i >= 0; i--) { // recorro de forma inversa
            //indMin = obtenerMinimo(datosParaClasificar, i, tope);
            indMin = obtenerMinimo(datosParaClasificar, 0, i);
            // Sólo intercambio si son distintos índices
            if (indMin != i)
                intercambiar(datosParaClasificar, i, indMin);
        }
        
        return datosParaClasificar;
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
    
    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) {
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }
    
    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { 
                    if (datosParaClasificar[r] > datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else {
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
    
    //protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
    public int[] ordenarPorHeapSortInverso(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeapInverso(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeapInverso(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorHeapSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }

    private void armaHeapInverso(int[] datosParaClasificar, int primero, int ultimo) {
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
        return ordenarPorCuenta(datosParaClasificar, MAXIMO_CUENTA);
    }
    
    public int[] ordenarPorCuenta(int[] datosParaClasificar, int maximo) {
        int[] cuenta = new int[maximo + 1];
        for (int i = 0; i < datosParaClasificar.length; i++) {
            cuenta[datosParaClasificar[i]]++;
        }
        for (int i = 1; i < maximo + 1; i++) {
            cuenta[i] += cuenta[i - 1];
        }
        int[] salida = new int[datosParaClasificar.length];
        for (int i = datosParaClasificar.length - 1; i >= 0; i--) {
            int j = cuenta[datosParaClasificar[i]] - 1;
            salida[j] = datosParaClasificar[i];
            cuenta[datosParaClasificar[i]]--;
        }
        return salida;
    }
    
    protected int[] ordenarPorCuentaCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }
    
    protected int[] ordenarPorBinsort(int[] datosParaClasificar) {
        int max = maximo(datosParaClasificar);
        int cifrasMax = numeroDeCifras(max);
        return binsort(datosParaClasificar, cifrasMax, false);
    }
    
    protected int[] ordenarPorBinsortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;
    }

    private int[] binsort(int[] datosParaClasificar, int cifrasMax, boolean radix) {
        ArrayList<Integer>[] urnas = new ArrayList[10];
        for (int i = 0; i < urnas.length; i++) {
            urnas[i] = new ArrayList<>();
        }
        for (int i = 0; i < datosParaClasificar.length; i++) {
            urnas[digitoEnPosicion(datosParaClasificar[i], cifrasMax)].add(datosParaClasificar[i]);
        }
        int ultimaPosicion = 0;
        for (int i = 0; i < 10; i++) {
            Integer[] urna = urnas[i].toArray(new Integer[urnas[i].size()]);
            int[] urnaOrdenada = new int[urna.length];
            for (int k = 0; k < urna.length; k++) {
                urnaOrdenada[k] = urna[k];
            }
            if (!radix) {
                urnaOrdenada = ordenarPorInsercion(urnaOrdenada);
            }
            urnas[i].clear();
            for (int j = 0; j < urnaOrdenada.length; j++) {
                datosParaClasificar[ultimaPosicion] = urnaOrdenada[j];
                ultimaPosicion++;
            }
        }
        return datosParaClasificar;
    }
    
    private int digitoEnPosicion(int n, int pos) {
        int a = n % (int) Math.pow(10, pos);
        int x = (int) Math.pow(10, pos - 1);
        if (a < x) {
            return 0;
        }
        while (a >= 10) {
            a = a/10;
        }
        return a;
    }
    
    private int maximo(int[] datos) {
        int max = Integer.MIN_VALUE;
        for (int i : datos) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    
    private int numeroDeCifras(int i) {
        return (int) (Math.log10(i) + 1);
    }
    
    protected int[] ordenarPorRadixsort(int[] datosParaClasificar) {
        int max = maximo(datosParaClasificar);
        int cifrasMax = numeroDeCifras(max);
        for (int i = 1; i <= cifrasMax; i++) {
            datosParaClasificar = binsort(datosParaClasificar, i, true);
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorRadixsortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
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
    
    //public long medirAlgoritmo(int algoritmo, int tipoOrden, int tamanio) {
    public long medirAlgoritmo(int algoritmo, int tipoOrden, int tamanio, int[] vectorAleatorio, int[] vectorAscendente, int[] vectorDescendente) {
        int[] vectorOriginal, resultado;
        
        // Tipo de vectores generados
        switch (tipoOrden) {
            case ALEATORIO:
                //vectorOriginal = gen.generarDatosAleatorios(tamanio);
                vectorOriginal = vectorAleatorio.clone();
                break;
            case ASCENDENTE:
                //vectorOriginal = gen.generarDatosAscendentes(tamanio);
                vectorOriginal = vectorAscendente.clone();
                break;
            case DESCENDENTE:
                //vectorOriginal = gen.generarDatosDescendentes(tamanio);
                vectorOriginal = vectorDescendente.clone();
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
        // Tipo de vectores generados
        switch (tipoOrden) {
            case ALEATORIO:
                //vectorOriginal = gen.generarDatosAleatorios(tamanio);
                vectorOriginal = vectorAleatorio.clone();
                break;
            case ASCENDENTE:
                //vectorOriginal = gen.generarDatosAscendentes(tamanio);
                vectorOriginal = vectorAscendente.clone();
                break;
            case DESCENDENTE:
                //vectorOriginal = gen.generarDatosDescendentes(tamanio);
                vectorOriginal = vectorDescendente.clone();
                break;
            default:
                return -1;
        }
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