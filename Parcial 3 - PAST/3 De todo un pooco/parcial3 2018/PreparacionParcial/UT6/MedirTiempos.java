/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT6;

/**
 *
 * @author usuario
 */
import java.util.Arrays;

/**
 * @author Lucas Lois <lucas.lois@correo.ucu.edu.uy>
 */
public class MedirTiempos {
    public static final int ORDEN_ALEATORIO = 0;
    public static final int ORDEN_DESC = 1;
    public static final int ORDEN_ASC = 2;
    private final TClasificador clasificador = new TClasificador();

    public static void main(String[] args) {
        MedirTiempos medir = new MedirTiempos();
        System.out.println("METODO_CLASIFICACION_INSERCION");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_INSERCION);
        System.out.println("METODO_CLASIFICACION_SHELL");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_SHELL);
        System.out.println("METODO_CLASIFICACION_BURBUJA");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_BURBUJA);
        System.out.println("METODO_CLASIFICACION_QUICKSORT");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_QUICKSORT);
        System.out.println("METODO_CLASIFICACION_SELECCION");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_SELECCION);
        System.out.println("METODO_CLASIFICACION_HEAPSORT");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_HEAP);
        System.out.println("METODO_CLASIFICACION_RADIXSORT");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_RADIX);
        System.out.println("METODO_CLASIFICACION_BINSORT");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_BINSORT);
        System.out.println("METODO_CLASIFICACION_SHAKER");
        medir.medirTiempos(TClasificador.METODO_CLASIFICACION_SHAKER);
    }

    public long tiempoMedioAlgoritmo(int tipoOrden, int T, long tiemporesolucion, int algoritmo) {
        int[] vectorOriginal = generarVector(T, tipoOrden);

        long t1 = System.nanoTime();
        long total = 0;
        int cantLlamadas = 0;

        while (total < tiemporesolucion) {
            cantLlamadas++;

            int[] datosCopia = Arrays.copyOf(vectorOriginal, T);

            clasificador.clasificar(datosCopia, algoritmo, true);
            long t2 = System.nanoTime();
            total = t2 - t1;
        }

        long tiempoMedioAlgoritmoBase = total / cantLlamadas;

        t1 = System.nanoTime();
        total = 0;
        cantLlamadas = 0;
        while (total < tiemporesolucion) {
            cantLlamadas++;

            int[] datosCopia = Arrays.copyOf(vectorOriginal, T);

            clasificador.clasificar(datosCopia, algoritmo, false);
            long t2 = System.nanoTime();
            total = t2 - t1;
        }

        long tiempoMedioCascara = total / cantLlamadas;

        return tiempoMedioAlgoritmoBase - tiempoMedioCascara;

    }

    public void medirTiempos(int algoritmo) {
        medirTiempoEnOrden(algoritmo, ORDEN_ASC);
        medirTiempoEnOrden(algoritmo, ORDEN_DESC);
        medirTiempoEnOrden(algoritmo, ORDEN_ALEATORIO);
    }

    private void medirTiempoEnOrden(int algoritmo, int orden) {
        long t1 = tiempoMedioAlgoritmo(orden, 300, 1000000000, algoritmo);
        long t2 = tiempoMedioAlgoritmo(orden, 3000, 1000000000, algoritmo);
        long t3 = tiempoMedioAlgoritmo(orden, 30000, 1000000000, algoritmo);
        System.out.printf("%d\t%d\t%d\n", t1, t2, t3);
    }

    private int[] generarVector(int tamanio, int tipoOrden) {
        GeneradorDatosGenericos gnd = new GeneradorDatosGenericos(tamanio);
        switch (tipoOrden) {
            case ORDEN_ASC:
                return gnd.generarDatosAscendentes();
            case ORDEN_DESC:
                return gnd.generarDatosDescendentes();
            default:
                return gnd.generarDatosAleatorios();
        }
    }

}