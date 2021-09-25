package clasificacion;

import java.util.Random;

public class GeneradorDatosGenericos implements IGeneradorDatos {

    /** Tamaño máximo por defecto */
    //private static int TAMANIO_MAX = 32000;
    private static final int TAMANIO_MAX = 32000;
    
    @Override
    public int[] generarDatosAleatorios(int tamanioMax) {
        Random rnd = new Random();
        int[] datosGenerados = new int[tamanioMax];
        boolean[] datosUtilizados = new boolean[tamanioMax];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(tamanioMax);
            while (datosUtilizados[j]) {
                j = (j + 1) % tamanioMax;
            }
            //datosGenerados[j] = i;
            datosGenerados[j] = i + 1;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    @Override
    public int[] generarDatosAleatorios() {
        return generarDatosAleatorios(TAMANIO_MAX);
    }
    
    @Override
    public int[] generarDatosAscendentes(int tamanioMax) {
        int[] copiaAscendente = new int[tamanioMax];
        for (int i = 0; i < tamanioMax; i++) {
            //copiaAscendente[i] = i;
            copiaAscendente[i] = i + 1;
        }
        return copiaAscendente;
    }

    @Override
    public int[] generarDatosAscendentes() {
        return generarDatosAscendentes(TAMANIO_MAX);
    }

    @Override
    public int[] generarDatosDescendentes(int tamanioMax) {
        int[] copiaDescendente = new int[tamanioMax];
        for (int i = 0; i < tamanioMax; i++) {
            copiaDescendente[i] = tamanioMax - i;
        }
        return copiaDescendente;
    }
    
    @Override
    public int[] generarDatosDescendentes() {
        return generarDatosDescendentes(TAMANIO_MAX);
    }

}
