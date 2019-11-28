/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class TOrdenadorTest {

    private TOrdenador or;

    /**
     * Test of heapSort method, of class TOrdenador.
     */
    @Test
    public void testHeapSort() {
        Comparable[] datos = new Comparable[3];
        datos[0] = 1;
        datos[1] = 33;
        datos[2] = 5;
        datos[3] = 10;
        Comparable[] vectorResultado = or.heapSort(datos);
        assertTrue(or.estaOrdenado(vectorResultado));

    }
}
