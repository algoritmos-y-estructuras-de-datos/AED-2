import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Cattáneo &lt;c@ttaneo.uy&gt;
 */
public class TGrafoAerolineaTest {
   
    private TGrafoAerolinea grafoTest;
    private TGrafoAerolinea grafoVacio;
    
    @Before
    public void setUp() {
        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 5));
        aristas.add(new TArista("A", "D", 10));
        aristas.add(new TArista("B", "C", 3));
        aristas.add(new TArista("C", "D", 1));
        aristas.add(new TArista("E", "D", 1));
        grafoTest = new TGrafoAerolinea(Arrays.asList(new TVertice("A"), new TVertice("B"), new TVertice("C"), new TVertice("D"), new TVertice("E")), aristas);
        grafoVacio = new TGrafoAerolinea(new LinkedList<>(), new LinkedList<>());
    }

    /**
     * Test of menosEscalas method, of class TGrafoAerolinea.
     */
    @org.junit.Test
    public void testMenosEscalas_grafoVacio() {
        assertEquals(new LinkedList<TVertice>(), grafoVacio.menosEscalas("A", "B"));
    }
    
    /**
     * Test of menosEscalas method, of class TGrafoAerolinea.
     */
    @org.junit.Test
    public void testMenosEscalas_grafoBien_unaEscala() {
        assertEquals(2, grafoTest.menosEscalas("A", "D").size());
        assertEquals("A", grafoTest.menosEscalas("A", "D").get(0).getEtiqueta());
        assertEquals("D", grafoTest.menosEscalas("A", "D").get(1).getEtiqueta());
    }
    
    /**
     * Test of menosEscalas method, of class TGrafoAerolinea.
     */
    @org.junit.Test
    public void testMenosEscalas_grafoBien_dosEscalas() {
        assertEquals(3, grafoTest.menosEscalas("B", "D").size());
        assertEquals("B", grafoTest.menosEscalas("B", "D").get(0).getEtiqueta());
        assertEquals("C", grafoTest.menosEscalas("B", "D").get(1).getEtiqueta());
        assertEquals("D", grafoTest.menosEscalas("B", "D").get(2).getEtiqueta());
    }
    
    /**
     * Test of menosEscalas method, of class TGrafoAerolinea.
     */
    @org.junit.Test
    public void testMenosEscalas_grafoBien_sinDestino() {
        assertEquals(new LinkedList<TVertice>(), grafoVacio.menosEscalas("A", "Z"));
    }
    
    /**
     * Test of menosEscalas method, of class TGrafoAerolinea.
     */
    @org.junit.Test
    public void testMenosEscalas_grafoBien_sinOrigen() {
        assertEquals(new LinkedList<TVertice>(), grafoVacio.menosEscalas("Z", "D"));
    }
    
}
