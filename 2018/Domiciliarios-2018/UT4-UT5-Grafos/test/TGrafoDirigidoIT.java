/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Grafos.TVertice;
import Grafos.TArista;
import Grafos.TCamino;
import Grafos.TCaminos;
import Grafos.TGrafoDirigido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TGrafoDirigidoIT {
    
    TGrafoDirigido gnd;
    
    public TGrafoDirigidoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 3));
        aristas.add(new TArista("A", "C", 2));
        this.gnd = new TGrafoDirigido(vertices,aristas);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of bpf method, of class TGrafoDirigido.
     */
    @Test
    public void testBpfVacio() {
        System.out.println("bpf");
        
        Collection<TVertice> vertices = new ArrayList<>();
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Collection<TVertice> result = instance.bpf();
        
        assertTrue(result.isEmpty());
    }
    
    /**
     * Test of bpf method, of class TGrafoDirigido.
     */
    @Test
    public void testBpfUnico() {
        System.out.println("bpf");
        
        int expResult = 1;
        Collection<TVertice> vertices = new ArrayList<>();
        TVertice a = new TVertice("A");
        vertices.add(a);
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Collection<TVertice> result = instance.bpf();
        for(TVertice v : result){
            assertTrue(v.getEtiqueta().equals("A"));
            break;
        }
        
        assertEquals(expResult, result.size());
    }
    
    /**
     * Test of bpf method, of class TGrafoDirigido.
     */
    @Test
    public void testBpfDosNoConectados() {
        System.out.println("bpf");
        
        int expResult = 2;
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Collection<TVertice> result = instance.bpf();
        Collection<Comparable> comparables = new ArrayList();
        comparables.add("A");
        comparables.add("B");
        for(TVertice v : result){
            assertTrue(comparables.contains(v.getEtiqueta()));
        }
        assertEquals(expResult, result.size());
    }
    /**
     * Test of bpf method, of class TGrafoDirigido.
     */
    @Test
    public void testBpfTresNoConectados() {
        System.out.println("bpf");
        
        int expResult = 3;
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Collection<TVertice> result = instance.bpf();
        Collection<Comparable> comparables = new ArrayList();
        comparables.add("A");
        comparables.add("B");
        comparables.add("C");
        for(TVertice v : result){
            assertTrue(comparables.contains(v.getEtiqueta()));
        }
        assertEquals(expResult, result.size());
    }



    /**
     * Test of centroDelGrafo method, of class TGrafoDirigido.
     */
    @Test
    public void testCentroDelGrafoVacio() {
        Collection<TVertice> vertices = new ArrayList<>();
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Comparable result = instance.centroDelGrafo();
        assertEquals("", result);
    }
    
    /**
     * Test of centroDelGrafo method, of class TGrafoDirigido.
     */
    @Test
    public void testCentroDelGrafoUnico() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Comparable result = instance.centroDelGrafo();
        assertEquals("A", result);
    }
    
    
    /**
     * Test of centroDelGrafo method, of class TGrafoDirigido.
     */
    @Test
    public void testCentroDelGrafoDos() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A","B",1));
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Comparable result = instance.centroDelGrafo();
        assertEquals("A", result);
    }
    
     /**
     * Test of centroDelGrafo method, of class TGrafoDirigido.
     */
    @Test
    public void testCentroDelGrafoDosAlRevez() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("B","A",1));
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Comparable result = instance.centroDelGrafo();
        assertEquals("B", result);
    }
    
     /**
     * Test of centroDelGrafo method, of class TGrafoDirigido.
     */
    @Test
    public void testCentroDelGrafo3() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("B","A",1));
        aristas.add(new TArista("B","C",1));
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        
        Comparable result = instance.centroDelGrafo();
        assertEquals("B", result);
    }


    /**
     * Test of floyd method, of class TGrafoDirigido.
     */
    @Test
    public void testFloyd() {
        System.out.println("floyd");
        Double[][] result = gnd.floyd();
        //y,x
        assertTrue(result[0][0]==0.0);
        assertTrue(result[0][1]==1.0);
        assertTrue(result[0][2]==2.0);
        assertTrue(result[1][0]==Double.MAX_VALUE);
        assertTrue(result[1][1]==0.0);
        assertTrue(result[1][2]==3.0);
        assertTrue(result[2][0]==Double.MAX_VALUE);
        assertTrue(result[2][1]==Double.MAX_VALUE);
        assertTrue(result[2][2]==0.0);
    }

    /**
     * Test of obtenerExcentricidad method, of class TGrafoDirigido.
     */
    @Test
    public void testObtenerExcentricidad() {
        System.out.println("obtenerExcentricidad");
        Comparable result = gnd.obtenerExcentricidad("A");
        
        Comparable result1 = gnd.obtenerExcentricidad("B");
        
        Comparable result2 = gnd.obtenerExcentricidad("C");
        
        assertTrue(Double.parseDouble(result.toString())==2.0);
        assertTrue(Double.parseDouble(result1.toString())==Double.MAX_VALUE);
        assertTrue(Double.parseDouble(result2.toString())==Double.MAX_VALUE);
    }

    /**
     * Test of warshall method, of class TGrafoDirigido.
     */
    @Test
    public void testWarshall() {
        boolean[][] result = gnd.warshall();
        //y,x
        assertTrue(result[0][0]);
        assertTrue(result[0][1]);
        assertTrue(result[0][2]);
        assertFalse(result[1][0]);
        assertTrue(result[1][1]);
        assertTrue(result[1][2]);
        assertFalse(result[2][0]);
        assertFalse(result[2][1]);
        assertTrue(result[2][2]);
    }

    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminosDesdeAaC() {
        System.out.println("todosLosCaminos");
        TCaminos result = gnd.todosLosCaminos("A", "C");
        Collection<String> caminos = new ArrayList();
        caminos.add("A,B,C,");
        caminos.add("A,C,");
        for(TCamino c : result.getCaminos()){
            String actual="";
            actual+=c.getOrigen().getEtiqueta()+",";
            for (Comparable adyacente : c.getOtrosVertices()) {
                actual+=adyacente+",";
            }
            assertTrue(caminos.contains(actual));
        }
    }
    
    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminosDesdeAaB() {
        System.out.println("todosLosCaminos");
        TCaminos result = gnd.todosLosCaminos("A", "B");
        Collection<String> caminos = new ArrayList();
        caminos.add("A,B,");
        for(TCamino c : result.getCaminos()){
            String actual="";
            actual+=c.getOrigen().getEtiqueta()+",";
            for (Comparable adyacente : c.getOtrosVertices()) {
                actual+=adyacente+",";
            }
            assertTrue(caminos.contains(actual));
        }
    }
    
    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminosDesdeBaA() {
        System.out.println("todosLosCaminos");
        TCaminos result = gnd.todosLosCaminos("B", "A");
        assertTrue(result.getCaminos().isEmpty());
    }

    /**
     * Test of tieneCiclo method, of class TGrafoDirigido.
     */
    @Test
    public void testTieneCicloDosConCiclo() {
        System.out.println("tieneCiclo eeee");
        
        boolean expResult = true;
        
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "A", 1));
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        boolean result = instance.tieneCiclo();
        
        assertEquals(expResult, result);
    }
    @Test
    public void testTieneCicloDosSinCiclo() {
        System.out.println("tieneCiclo");
        
        boolean expResult = false;
        
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        boolean result = instance.tieneCiclo();
        
        assertEquals(expResult, result);
    }
    @Test
    public void testTieneCicloUno() {
        System.out.println("tieneCiclo");
        
        boolean expResult = false;
        
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        boolean result = instance.tieneCiclo();
        
        assertEquals(expResult, result);
    }
    @Test
    public void testTieneCicloVacio() {
        System.out.println("tieneCiclo");
        
        boolean expResult = false;
        
        Collection<TVertice> vertices = new ArrayList<>();
        Collection<TArista> aristas = new ArrayList<>();
        
        TGrafoDirigido instance = new TGrafoDirigido(vertices, aristas);
        boolean result = instance.tieneCiclo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of bea method, of class TGrafoDirigido.
     */
    @Test
    public void testBea() {
        System.out.println("bea");
        Collection<TVertice> result = gnd.bea();
        for(TVertice v : result){
            assertTrue(gnd.getVertices().containsKey(v.getEtiqueta()));
        }
        assertTrue(result.size()==gnd.getVertices().size());
    }
    
}
