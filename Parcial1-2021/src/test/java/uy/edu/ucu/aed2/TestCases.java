package uy.edu.ucu.aed2;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.*;

public class TestCases {

    public TestCases() {
    }

    TArbolTrie aprobar;
    int[] posiciones;

    @Before
    public void setUp() {
        aprobar = new TArbolTrie();
        posiciones = new int[2];
    }

    @Test
    public void primerTest() {
        // Encuentro patron
        posiciones[0] = 1;
        posiciones[1] = 14;
        aprobar.insertar("10100001", posiciones);

        LinkedList<Integer> pos = aprobar.encontrarPatron("101");

        assertEquals((int) pos.getFirst(), posiciones[0]);
    }

    @Test
    public void segundoTest() {
        // Busco patron que no existe
        posiciones[0] = 1;
        posiciones[1] = 14;
        aprobar.insertar("10100001", posiciones);

        LinkedList<Integer> pos = aprobar.encontrarPatron("9");

        assertEquals(pos.size(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void testExcepcion() {
        aprobar.encontrarPatron("A");
    }

}
