package clasificacion;

public class TClasificador implements IClasificador {

    public static void main(String args[]) {
        IClasificador clasif = new TClasificador();
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.println(resAleatorio[i] + " ");
        }
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < vectorAscendente.length; i++) {
            System.out.println(resAscendente[i] + " ");
        }
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.println(resDescendente[i] + " ");
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
            case METODO_CLASIFICACION_BURBUJA_MEJORADO:
                return ordenarPorBurbujaMejorado(datosParaClasificar);
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
                        j--;
                    }
                }
            }
        }
        System.out.println("Comparaciones shell: " + comparaciones);
        return datosParaClasificar;
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
            System.out.println("Comparaciones inserción: " + comparaciones);
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
        // Implementar m�todo aqu�
        return null;
    }

    @Override
    public int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
    }

    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
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
                System.out.println(String.format("%d (índice %d) >= %d (índice %d)", datosParaVerificar[i], i, datosParaVerificar[i + 1], (i + 1)));
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

}
