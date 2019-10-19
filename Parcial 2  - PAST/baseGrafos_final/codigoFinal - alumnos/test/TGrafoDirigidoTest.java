/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author usuario
 */
public class TGrafoDirigidoTest {
    
   private TVertice verA;
    private TVertice verB;
    private TVertice verC;
    private TVertice verD;
    private TVertice verE;
    private TGrafoDirigido grafoTest;
    private TGrafoDirigido grafoVacio;

    @Before
    public void setUp() {
        grafoTest = new TGrafoDirigido(Arrays.asList(new TVertice("A"), new TVertice("B"), new TVertice("C"), new TVertice("D"), new TVertice("E")), new LinkedList<>());
        verA = grafoTest.getVertices().get("A");
        verB = grafoTest.getVertices().get("B");
        verC = grafoTest.getVertices().get("C");
        verD = grafoTest.getVertices().get("D");
        verE = grafoTest.getVertices().get("E");

        grafoVacio = new TGrafoDirigido(new LinkedList<>(), new LinkedList<>());
    }

    @Test
    public void floyd() {
        List<TVertice> vertices = new LinkedList<>();
        vertices.add(verA);
        vertices.add(verB);
        vertices.add(verC);
        vertices.add(verD);
        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 5));
        aristas.add(new TArista("A", "D", 10));
        aristas.add(new TArista("B", "C", 3));
        aristas.add(new TArista("C", "D", 1));

        TGrafoDirigido grafo = new TGrafoDirigido(Collections.unmodifiableList(vertices), aristas);

        assertEquals(grafo.floyd(),
                new double[][]{
                        new double[]{-1.0, 5.0, 8.0, 9.0},
                        new double[]{Double.MAX_VALUE, -1.0, 3.0, 4.0},
                        new double[]{Double.MAX_VALUE, Double.MAX_VALUE, -1.0, 1.0},
                        new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, -1.0}});


        aristas = new LinkedList<>();
        aristas.add(new TArista("B", "A", 4));
        aristas.add(new TArista("A", "C", -2));
        aristas.add(new TArista("C", "D", 2));
        aristas.add(new TArista("D", "B", -1));

        grafo = new TGrafoDirigido(Collections.unmodifiableList(vertices), aristas);

        assertEquals(
                new double[][]{
                        new double[]{-1, -1, -2, 0},
                        new double[]{4, -1, 2, 4},
                        new double[]{5, 1, -1, 2},
                        new double[]{3, -1, 1, -1}},
                grafo.floyd());

        aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 200));
        aristas.add(new TArista("A", "C", 350));
        aristas.add(new TArista("B", "C", 100));
        aristas.add(new TArista("B", "D", 200));
        aristas.add(new TArista("C", "D", 400));
        aristas.add(new TArista("D", "A", 100));

        grafo = new TGrafoDirigido(Collections.unmodifiableList(vertices), aristas);

        assertEquals(
                new double[][]{
                        new double[]{-1, 200, 300, 400},
                        new double[]{300, -1, 100, 200},
                        new double[]{500, 700, -1, 400},
                        new double[]{100, 300, 400, -1}},
                grafo.floyd());
    }
    @Test
    public void warshallGrafoVacio() {
        TGrafoDirigido grafoVacio2 = new TGrafoDirigido(new LinkedList<>(), new LinkedList<>());
        assertEquals(grafoVacio2.warshall(), new boolean[][]{});
    }

    @Test
    public void warshallGrafoSinArco() {
        assertEquals(new boolean[][]{
                new boolean[]{true, false, false, false, false},
                new boolean[]{false, true, false, false, false},
                new boolean[]{false, false, true, false, false},
                new boolean[]{false, false, false, true, false},
                new boolean[]{false, false, false, false, true},
        }, grafoTest.warshall());
    }

    @Test
    public void warshallGrafoPocoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 5));
        grafoTest.insertarArista(new TArista("A", "D", 10));
        grafoTest.insertarArista(new TArista("B", "C", 3));
        grafoTest.insertarArista(new TArista("C", "D", 1));

        assertEquals(new boolean[][]{
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{false, true, true, true, false},
                        new boolean[]{false, false, true, true, false},
                        new boolean[]{false, false, false, true, false},
                        new boolean[]{false, false, false, false, true}},
                grafoTest.warshall());
    }

    @Test
    public void warshallGrafoConexo() {
        grafoTest.insertarArista(new TArista("B", "A", 4));
        grafoTest.insertarArista(new TArista("A", "C", -2));
        grafoTest.insertarArista(new TArista("C", "D", 2));
        grafoTest.insertarArista(new TArista("D", "B", -1));

        boolean[][] warshall = grafoTest.warshall();

        System.out.println(Arrays.deepToString(warshall));

        assertEquals(
                new boolean[][]{
                        new boolean[]{true, false, true, true, false},
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{false, true, true, true, false},
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{false, false, false, false, true}},
                warshall);
}

    @Test
    public void warshallGrafoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 200));
        grafoTest.insertarArista(new TArista("A", "C", 350));
        grafoTest.insertarArista(new TArista("B", "C", 100));
        grafoTest.insertarArista(new TArista("B", "D", 200));
        grafoTest.insertarArista(new TArista("C", "D", 400));
        grafoTest.insertarArista(new TArista("D", "A", 100));

        assertEquals(
                new boolean[][]{
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{true, true, true, true, false},
                        new boolean[]{false, false, false, false, true}},
                grafoTest.warshall());

    }
    @Test
    public void testTodosLosCaminos() {
        System.out.println("todosLosCaminos");
        StringBuilder sb = new StringBuilder();
        sb.append("Origen: " + "A" +" -> " + "B"+" -> " + "D"+"\n");
        sb.append("Origen: " + "A" +" -> " + "C"+" -> " + "D"+"\n");
        Comparable etiquetaOrigen = "A";
        Comparable etiquetaDestino = "D";
        
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        TVertice a = new TVertice("A");
        TVertice b = new TVertice("B");
        TVertice c = new TVertice("C");
        TVertice d = new TVertice("D");
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        aristas.add(new TArista("A", "B", 50));
        aristas.add(new TArista("A", "C", 200));
        aristas.add(new TArista("B", "D", 10));
        aristas.add(new TArista("C", "D", 30));
        
        TGrafoDirigido gd2 = new TGrafoDirigido(vertices, aristas);
        String expResult = sb.toString();
        String result = gd2.todosLosCaminos(etiquetaOrigen, etiquetaDestino).imprimirCaminos();
        assertEquals(expResult, result);
    }

    /**
     * Test of tieneCiclo method, of class TGrafoDirigido.
     */
    @Test
    public void testTieneCiclo_ConArcoR() {
        System.out.println("tieneCiclo arco Retroceso (ciclo)");
        
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        TVertice a = new TVertice("A");
        TVertice b = new TVertice("B");
        TVertice c = new TVertice("C");
        TVertice d = new TVertice("D");
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        aristas.add(new TArista("A", "B", 50));
        aristas.add(new TArista("B", "C", 200));
        aristas.add(new TArista("C", "A", 30));
        
        TGrafoDirigido gd2 = new TGrafoDirigido(vertices, aristas);
        boolean expResult = true;
        boolean result = gd2.tieneCiclo();
        assertEquals(expResult, result);
    }
    @Test
    public void testTieneCiclo_ConArcoA() {
        System.out.println("tieneCiclo arco Avance");
        
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        TVertice a = new TVertice("A");
        TVertice b = new TVertice("B");
        TVertice c = new TVertice("C");
        TVertice d = new TVertice("D");
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        aristas.add(new TArista("A", "B", 50));
        aristas.add(new TArista("B", "C", 200));
        aristas.add(new TArista("A", "C", 200));
        
        TGrafoDirigido gd2 = new TGrafoDirigido(vertices, aristas);
        boolean expResult = false;
        boolean result = gd2.tieneCiclo();
        assertEquals(expResult, result);
    }
    @Test
    public void centroDelGrafoVacio() {
        assertNull(grafoVacio.centroDelGrafo());
    }

    @Test
    public void centroDelGrafoSinArco() {
        assertNull(grafoTest.centroDelGrafo());
    }

    @Test
    public void centroDelGrafoChico() {
        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC), new LinkedList<>());
        grafoTest.insertarArista(new TArista("A", "B", 20));
        grafoTest.insertarArista(new TArista("C", "B", 40));
        grafoTest.insertarArista(new TArista("A", "C", 10));
        assertEquals("B", grafoTest.centroDelGrafo());
    }

    @Test
    public void centroDelGrafoPocoDenso() {
        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC, verD), new LinkedList<>());
        grafoTest.insertarArista(new TArista("B", "A", 4));
        grafoTest.insertarArista(new TArista("A", "C", -2));
        grafoTest.insertarArista(new TArista("C", "D", 2));
        grafoTest.insertarArista(new TArista("D", "B", -1));

        assertEquals("B", grafoTest.centroDelGrafo());
    }
    @Test
    public void centroDelGrafoDenso() {
        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC, verD), new LinkedList<>());
        grafoTest.insertarArista(new TArista("A", "B", 200));
        grafoTest.insertarArista(new TArista("A", "C", 350));
        grafoTest.insertarArista(new TArista("B", "C", 100));
        grafoTest.insertarArista(new TArista("B", "D", 200));
        grafoTest.insertarArista(new TArista("C", "D", 400));
        grafoTest.insertarArista(new TArista("D", "A", 100));

        assertEquals("C", grafoTest.centroDelGrafo());
    }
    
    @Test
    public void todosLosCaminosGrafoVacio() {
        assertTrue(grafoVacio.todosLosCaminos("A", "B").getCaminos().isEmpty());
        assertTrue(grafoVacio.todosLosCaminos("XXX", "YYY").getCaminos().isEmpty());
    }

    @Test
    public void todosLosCaminosReflexivo() {
        assertTrue(grafoTest.todosLosCaminos("A", "A").getCaminos().isEmpty());
        assertTrue(grafoTest.todosLosCaminos("C", "C").getCaminos().isEmpty());

        grafoTest.insertarArista(new TArista("A", "B", 10));
        grafoTest.insertarArista(new TArista("B", "A", 8));
        grafoTest.insertarArista(new TArista("B", "C", 5));
        grafoTest.insertarArista(new TArista("C", "A", 1));

        TCaminos caminosAA = grafoTest.todosLosCaminos("A", "A");
        assertEquals(0, caminosAA.getCaminos().size()); // No se consideran los ciclos
    }

    @Test
    public void todosLosCaminosGrafoSinArco() {
        assertTrue(grafoTest.todosLosCaminos("A", "B").getCaminos().isEmpty());
        assertTrue(grafoTest.todosLosCaminos("A", "C").getCaminos().isEmpty());
        assertTrue(grafoTest.todosLosCaminos("A", "D").getCaminos().isEmpty());
        assertTrue(grafoTest.todosLosCaminos("A", "E").getCaminos().isEmpty());
    }

    @Test
    public void todosLosCaminosGrafoPocoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 10));
        grafoTest.insertarArista(new TArista("B", "A", 8));
        grafoTest.insertarArista(new TArista("B", "C", 5));
        grafoTest.insertarArista(new TArista("C", "A", 1));

        TCaminos caminosAA = grafoTest.todosLosCaminos("B", "A");
        assertEquals(2, caminosAA.getCaminos().size());

        TCamino[] caminosAAPar = caminosAA.getCaminos().toArray(new TCamino[]{});
        TCamino caminoCorto = caminosAAPar[0];
        assertEquals(8, (double) caminoCorto.getCostoTotal(), 0);
        assertEquals(verB.getEtiqueta(), caminoCorto.getOrigen().getEtiqueta());
        assertEquals(Arrays.asList("A"), caminoCorto.getOtrosVertices());

        TCamino caminoLargo = caminosAAPar[1];
        assertEquals(6, (double) caminoLargo.getCostoTotal(), 0);
        assertEquals(verB.getEtiqueta(), caminoLargo.getOrigen().getEtiqueta());
        assertEquals(Arrays.asList("C", "A"), caminoLargo.getOtrosVertices());
    }
    @Test
    public void tieneCicloGrafoVacio() {
        assertFalse(grafoVacio.tieneCiclo());
    }

    @Test
    public void tieneCicloGrafoSinArco() {
        assertFalse(grafoTest.tieneCiclo());
    }

    @Test
    public void tieneCicloGrafoAciclico() {
        grafoTest.insertarArista(new TArista("A", "B", 5));
        grafoTest.insertarArista(new TArista("A", "D", 10));
        grafoTest.insertarArista(new TArista("B", "C", 3));
        grafoTest.insertarArista(new TArista("C", "D", 1));
        assertFalse(grafoTest.tieneCiclo());

        grafoTest.insertarArista(new TArista("C", "A", 0));
        assertTrue(grafoTest.tieneCiclo());
    }

    @Test
    public void tieneCicloGrafoCircular() {
        grafoTest.insertarArista(new TArista("A", "B", 5));
        grafoTest.insertarArista(new TArista("B", "C", 3));
        grafoTest.insertarArista(new TArista("C", "D", 1));
        grafoTest.insertarArista(new TArista("D", "E", 1));
        grafoTest.insertarArista(new TArista("E", "A", 1));
        assertTrue(grafoTest.tieneCiclo());
    }

    @Test
    public void tieneCicloGrafooPocoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 1));
        assertFalse(grafoTest.tieneCiclo());
        grafoTest.insertarArista(new TArista("B", "D", 1));
        assertFalse(grafoTest.tieneCiclo());
        grafoTest.insertarArista(new TArista("C", "E", 1));
        assertFalse(grafoTest.tieneCiclo());
        grafoTest.insertarArista(new TArista("D", "C", 1));
        assertFalse(grafoTest.tieneCiclo());
        grafoTest.insertarArista(new TArista("E", "A", 1));
        assertTrue(grafoTest.tieneCiclo());
    }
     @Test
    public void esConexoVacio() {
        assertTrue(grafoVacio.esConexo());
    }

    @Test
    public void esConexoSinArcos() {
        assertFalse(grafoTest.esConexo());
    }

    @Test
    public void esConexoDosNodos() {
        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB), new LinkedList<>());
        grafoTest.insertarArista(new TArista("A", "B", 1));

        assertFalse(grafoTest.esConexo());
        grafoTest.insertarArista(new TArista("B", "A", 1));
        assertTrue(grafoTest.esConexo());
    }

    @Test
    public void esConexoComponenteYUno() {
        grafoTest.insertarArista(new TArista("A", "B", 1));
        grafoTest.insertarArista(new TArista("B", "D", 1));
        grafoTest.insertarArista(new TArista("D", "E", 1));
        grafoTest.insertarArista(new TArista("E", "A", 1));
        assertFalse(grafoTest.esConexo());

        grafoTest.insertarArista(new TArista("D", "C", 1));
        assertFalse(grafoTest.esConexo());

        grafoTest.insertarArista(new TArista("C", "A", 1));
        assertTrue(grafoTest.esConexo());

    }
    @Test
    public void caminoCriticoGrafoVacio() {
        assertNull(grafoVacio.caminoCritico("A", "A"));
        assertNull(grafoVacio.caminoCritico("A", "B"));
    }

    @Test
    public void caminoCriticoGrafoSinArcos() {
        assertNull(grafoTest.caminoCritico("A", "A"));
        assertNull(grafoTest.caminoCritico("A", "B"));
    }

    @Test
    public void caminoCriticoGrafoConCiclo() {
        grafoTest.insertarArista(new TArista("A", "B", 10));
        grafoTest.insertarArista(new TArista("B", "C", 8));
        TCamino caminoCritico = grafoTest.caminoCritico("A", "C");
        assertNotNull(caminoCritico);
        assertEquals(18, caminoCritico.getCostoTotal(), 0);

        grafoTest.insertarArista(new TArista("B","A", 0));
        assertNull(grafoTest.caminoCritico("A", "C"));

    }

    @Test
    public void caminoCriticoGrafoChico() {
        grafoTest.insertarArista(new TArista("A", "B", 10));
        grafoTest.insertarArista(new TArista("A", "C", 9));
        grafoTest.insertarArista(new TArista("B", "D", 8));
        grafoTest.insertarArista(new TArista("C", "D", 7));
        grafoTest.insertarArista(new TArista("C", "E", 4));
        grafoTest.insertarArista(new TArista("D", "E", 14));

        TCamino caminoCritico = grafoTest.caminoCritico("A", "E");
        assertNotNull(caminoCritico);

        assertEquals(32, caminoCritico.getCostoTotal(), 0);
        assertEquals(verA.getEtiqueta(), caminoCritico.getOrigen().getEtiqueta());
        assertEquals(Arrays.asList("B", "D", "E"), caminoCritico.getOtrosVertices());
    }
    @Test
    public void beaGrafoVacio() {
        assertEquals(Collections.emptyList(), grafoVacio.bea());
        assertEquals(Collections.emptyList(), grafoVacio.bea(verA));
        assertEquals(Collections.emptyList(), grafoVacio.bea("A"));

        assertEquals(Collections.emptyList(), grafoVacio.bea((TVertice) null));
        assertEquals(Collections.emptyList(), grafoVacio.bea((Comparable) null));
        assertEquals(Collections.emptyList(), grafoVacio.bea("XXXXX"));
    }

    @Test
    public void beaGrafoSinArco() {
        assertEquals(Arrays.asList(verA, verB, verC, verD, verE), grafoTest.bea());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA), grafoTest.bea(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB), grafoTest.bea(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA), grafoTest.bea("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB), grafoTest.bea("B"));
        grafoTest.desvisitarVertices();

        assertEquals(Collections.emptyList(), grafoTest.bea((TVertice) null));
        grafoTest.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoTest.bea((Comparable) null));
        grafoTest.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoTest.bea("XXXXX"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void beaGrafoPocoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));

        assertEquals(Arrays.asList(verA, verB, verC, verD, verE), grafoTest.bea());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC), grafoTest.bea(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verC), grafoTest.bea(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC), grafoTest.bea("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bea("D"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void beaGrafoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("A", "D", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));

        assertEquals(Arrays.asList(verA, verB, verD, verC, verE), grafoTest.bea());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verD, verC), grafoTest.bea("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verC), grafoTest.bea(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verD, verC), grafoTest.bea("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bea("D"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void beaGrafoDensoConDosCaminos() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("A", "D", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));
        grafoTest.insertarArista(new TArista("B", "D", 0));

        assertEquals(Arrays.asList(verA, verB, verD, verC, verE), grafoTest.bea());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verD, verC), grafoTest.bea(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verC, verD), grafoTest.bea(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verD, verC), grafoTest.bea("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bea("D"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void beaGrafoConcentrico() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("A", "C", 0));
        grafoTest.insertarArista(new TArista("B", "E", 0));
        grafoTest.insertarArista(new TArista("C", "D", 0));
        grafoTest.insertarArista(new TArista("C", "E", 0));
        assertEquals(Arrays.asList(verA, verB, verC, verE, verD), grafoTest.bea());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC, verE, verD), grafoTest.bea(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verE), grafoTest.bea(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verC, verD, verE), grafoTest.bea(verC));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC, verE, verD), grafoTest.bea("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bea("D"));
        grafoTest.desvisitarVertices();
}
    @Test
    public void bpfGrafoVacio() {
        assertEquals(Collections.emptyList(), grafoVacio.bpf());
        grafoVacio.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoVacio.bpf(verA));
        grafoVacio.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoVacio.bpf("A"));
        grafoVacio.desvisitarVertices();

        assertEquals(Collections.emptyList(), grafoVacio.bpf((TVertice) null));
        grafoVacio.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoVacio.bpf((Comparable) null));
        grafoVacio.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoVacio.bpf("XXXXX"));
        grafoVacio.desvisitarVertices();
    }

    @Test
    public void bpfGrafoSinArco() {
        List<TVertice> vertices = new LinkedList<>();
        vertices.add(verA);
        vertices.add(verB);
        //grafoTest = new TGrafoDirigido(vertices, new LinkedList<>());

        assertEquals(Arrays.asList(verA, verB, verC, verD, verE), grafoTest.bpf());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA), grafoTest.bpf(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB), grafoTest.bpf(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA), grafoTest.bpf("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB), grafoTest.bpf("B"));
        grafoTest.desvisitarVertices();

        assertEquals(Collections.emptyList(), grafoTest.bpf((TVertice) null));
        grafoTest.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoTest.bpf((Comparable) null));
        grafoTest.desvisitarVertices();
        assertEquals(Collections.emptyList(), grafoTest.bpf("XXXXX"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void bpfGrafoPocoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));

        assertEquals(Arrays.asList(verA, verB, verC, verD, verE), grafoTest.bpf());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC), grafoTest.bpf(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verC), grafoTest.bpf(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC), grafoTest.bpf("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bpf("D"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void bpfGrafoDenso() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("A", "D", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));

        assertEquals(Arrays.asList(verA, verB, verC, verD, verE), grafoTest.bpf());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC, verD), grafoTest.bpf(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verC), grafoTest.bpf(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC, verD), grafoTest.bpf("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bpf("D"));
        grafoTest.desvisitarVertices();
    }

    @Test
    public void bpfGrafoDensoConDosCaminos() {
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("A", "D", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));
        grafoTest.insertarArista(new TArista("B", "D", 0));

        assertEquals(Arrays.asList(verA, verB, verC, verD, verE), grafoTest.bpf());
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC, verD), grafoTest.bpf(verA));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verB, verC, verD), grafoTest.bpf(verB));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verA, verB, verC, verD), grafoTest.bpf("A"));
        grafoTest.desvisitarVertices();
        assertEquals(Arrays.asList(verD), grafoTest.bpf("D"));
        grafoTest.desvisitarVertices();

    }
    @Test
    public void ordenacionTopologicaGrafoVacio() {
        assertTrue(grafoVacio.ordenTopologico().isEmpty());
    }

    @Test
    public void ordenacionTopologicaGrafoChico() {
        grafoTest.insertarArista(new TArista("A", "B", 10));
        grafoTest.insertarArista(new TArista("A", "C", 9));
        grafoTest.insertarArista(new TArista("B", "D", 8));
        grafoTest.insertarArista(new TArista("C", "D", 7));
        grafoTest.insertarArista(new TArista("C", "E", 4));
        grafoTest.insertarArista(new TArista("D", "E", 14));

        assertEquals(Arrays.asList(verE, verD, verB, verC, verA), grafoTest.ordenTopologico());

    }
    @Test
    public void componentesConexosGrafoVacio() {
        assertTrue(grafoVacio.componentesConexos().isEmpty());
    }

    @Test
    public void componentesConexosGrafoChico() {
        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC, verD), new LinkedList<>());
        grafoTest.insertarArista(new TArista("A", "B", 0));
        grafoTest.insertarArista(new TArista("A", "D", 0));
        grafoTest.insertarArista(new TArista("B", "C", 0));
        grafoTest.insertarArista(new TArista("C", "A", 0));
        grafoTest.insertarArista(new TArista("C", "D", 0));

        Collection<Collection<TVertice>> componentesConexos = grafoTest.componentesConexos();
        assertEquals(2, componentesConexos.size());
        Iterator<Collection<TVertice>> iter = componentesConexos.iterator();

        Collection<Comparable> comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(3, comp.size());
        assertTrue(comp.contains("A"));
        assertTrue(comp.contains("B"));
        assertTrue(comp.contains("C"));

        comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(1, comp.size());
        assertTrue(comp.contains("D"));

    }

    @Test
    public void componentesConexosGrafoDenso() {
        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC, verD, verE, new TVertice("F")), new LinkedList<>());
        grafoTest.insertarArista(new TArista("A", "B", 3));
        grafoTest.insertarArista(new TArista("A", "D", 3));
        grafoTest.insertarArista(new TArista("A", "F", 3));

        grafoTest.insertarArista(new TArista("B", "C", 3));
        grafoTest.insertarArista(new TArista("C", "D", 3));
    }

    @Test
    public void componentesConexosDosComponentes() {

        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("B", "E", 1));
        aristas.add(new TArista("C", "B", 1));

        aristas.add(new TArista("E", "A", 1));
        aristas.add(new TArista("E", "C", 1));

        aristas.add(new TArista("F", "H", 1));
        aristas.add(new TArista("H", "G", 1));
        aristas.add(new TArista("G", "D", 1));
        aristas.add(new TArista("D", "F", 1));

        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC, verD, verE, new TVertice("F"), new TVertice("G"), new TVertice("H")), aristas);

        Collection<Collection<TVertice>> componentesConexos = grafoTest.componentesConexos();
        assertEquals(2, componentesConexos.size());
        Iterator<Collection<TVertice>> iter = componentesConexos.iterator();

        Collection<Comparable> comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(4, comp.size());
        assertTrue(comp.contains("D"));
        assertTrue(comp.contains("F"));
        assertTrue(comp.contains("G"));
        assertTrue(comp.contains("H"));

        comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(4, comp.size());
        assertTrue(comp.contains("A"));
        assertTrue(comp.contains("B"));
        assertTrue(comp.contains("C"));
        assertTrue(comp.contains("E"));
    }

    @Test
    public void componentesConexosDosNodos() {
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 1));

        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB), aristas);

        Collection<Collection<TVertice>> componentesConexos = grafoTest.componentesConexos();
        assertEquals(2, componentesConexos.size());
        Iterator<Collection<TVertice>> iter = componentesConexos.iterator();

        Collection<Comparable> comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(1, comp.size());
        assertTrue(comp.contains("A"));

        comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(1, comp.size());
        assertTrue(comp.contains("B"));

    }

    @Test
    public void componentesConexosCuatroNodos() {
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("C", "D", 1));
        aristas.add(new TArista("B", "A", 1));
        aristas.add(new TArista("B", "D", 1));

        grafoTest = new TGrafoDirigido(Arrays.asList(verA, verB, verC, verD), aristas);

        Collection<Collection<TVertice>> componentesConexos = grafoTest.componentesConexos();
        assertEquals(4, componentesConexos.size());
        Iterator<Collection<TVertice>> iter = componentesConexos.iterator();

        assertEquals(Arrays.asList("B"), iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList()));
        assertEquals(Arrays.asList("A"), iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList()));
        assertEquals(Arrays.asList("C"), iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList()));
        assertEquals(Arrays.asList("D"), iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList()));
    }

    @Test
    public void componentesConexosCuatroNodosTresGrups() {
        grafoTest.insertarArista(new TArista("A", "C", 1));
        grafoTest.insertarArista(new TArista("A", "E", 1));
        grafoTest.insertarArista(new TArista("B", "A", 1));
        grafoTest.insertarArista(new TArista("B", "D", 1));
        grafoTest.insertarArista(new TArista("C", "D", 1));
        grafoTest.insertarArista(new TArista("E", "B", 1));

        Collection<Collection<TVertice>> componentesConexos = grafoTest.componentesConexos();
        assertEquals(3, componentesConexos.size());
        Iterator<Collection<TVertice>> iter = componentesConexos.iterator();

        Collection<Comparable> comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(3, comp.size());
        assertTrue(comp.contains("A"));
        assertTrue(comp.contains("B"));
        assertTrue(comp.contains("E"));

        comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(1, comp.size());
        assertTrue(comp.contains("C"));

        comp = iter.next().stream().map(TVertice::getEtiqueta).collect(Collectors.toList());
        assertEquals(1, comp.size());
        assertTrue(comp.contains("D"));
}
}
