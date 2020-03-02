/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author usuario
 */
public class TClasificadorTest {
    
    TClasificador clasificador;

    @Before
    public void setUp() {
        this.clasificador = new TClasificador();
    }
    @Test
    public void testOrdenarPorHeapSortInvertidoUnicoElem() {
        Comparable[] a = new Comparable[]{8};
        clasificador.clasificar(a, TClasificador.METODO_CLASIFICACION_HEAP, true);
        assertArrayEquals(new Comparable[]{8}, a);
    }

    @Test
    public void testOrdenarPorHeapSortInvertidoDosElem() {
        Comparable[] a = new Comparable[]{8, 2};
        clasificador.clasificar(a, TClasificador.METODO_CLASIFICACION_HEAP, true);
        assertArrayEquals(new Comparable[]{8, 2}, a);
    }
    @Test
    public void testOrdenarPorHeapSortInvertidoAleatorio() {
        Comparable[] a = new Comparable[]{2, 6, 1, 3, 9, 4};
        clasificador.clasificar(a, TClasificador.METODO_CLASIFICACION_HEAP, true);
        for(Comparable num : a){
            System.out.println(num);
        }
        assertArrayEquals(new Comparable[]{9, 6, 4, 3, 2, 1}, a);
    }
    @Test
    public void testOrdenarPorHeapSortInvertidoAleatorioConLetras() {
        Comparable[] a = new Comparable[]{"a","f","z","c"};
        clasificador.clasificar(a, TClasificador.METODO_CLASIFICACION_HEAP, true);
        assertArrayEquals(new Comparable[]{"z","f","c","a"}, a);
    }
    @Test
    public void testOrdenarPorHeapSortInvertidoConDuplicados() {
        Comparable[] a = new Comparable[]{5, 2, 8, 2, 5, 1};
        clasificador.clasificar(a, TClasificador.METODO_CLASIFICACION_HEAP, true);
        assertArrayEquals(new Comparable[]{8, 5, 5, 2, 2, 1}, a);
    }
    @Test
    public void testOrdenarPorHeapSortInvertidoGrande() {
        Comparable[] a = new GeneradorDatosGenericos(10000).generarDatosAleatorios();
        clasificador.clasificar(a, TClasificador.METODO_CLASIFICACION_HEAP, true);
        assertOrdenado(a);
    }
    public void assertOrdenado(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable elem = a[i];
            if (a[i-1].compareTo(a[i]) < 0) {
                fail("Vector no ordenado");
            }
        }
    }
    
}
