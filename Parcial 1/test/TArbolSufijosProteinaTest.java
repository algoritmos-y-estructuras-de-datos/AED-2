import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de TArbolSufijosProteinaTest
 * @author Bruno Cattáneo &lt;c@ttaneo.uy&gt;
 */
public class TArbolSufijosProteinaTest {
    
    TArbolSufijosProteina arbolVacio, arbolCadena;
    
    @Before
    public void setUp() {
        arbolVacio = new TArbolSufijosProteina();
        arbolCadena = new TArbolSufijosProteina();
        arbolCadena.insertar("TESTST", 0);
        arbolCadena.insertar("ESTST", 1);
        arbolCadena.insertar("STST", 2);
        arbolCadena.insertar("STST", 3);
        arbolCadena.insertar("TST", 4);
        arbolCadena.insertar("ST", 5);
        arbolCadena.insertar("T", 6);
    }

    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron_arbolVacio() {
        assertTrue(arbolVacio.encontrarPatron("TEST").isEmpty());
    }
    
    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron_arbolRetornaElementos() {
        assertFalse(arbolCadena.encontrarPatron("TEST").isEmpty());
    }
    
    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron_encuentroUnSufijo() {
        assertFalse(arbolCadena.encontrarPatron("TEST").isEmpty());
        assertEquals(arbolCadena.encontrarPatron("TEST").get(0), new Integer(0));
    }
    
    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron_encuentroDosSufijos() {
        assertFalse(arbolCadena.encontrarPatron("ST").isEmpty());
        assertEquals(arbolCadena.encontrarPatron("ST").get(0), new Integer(5));
        assertEquals(arbolCadena.encontrarPatron("ST").get(1), new Integer(3));
    }
    
    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron_encuentroTresSufijos() {
        assertFalse(arbolCadena.encontrarPatron("T").isEmpty());
        assertEquals(arbolCadena.encontrarPatron("T").get(0), new Integer(6));
        assertEquals(arbolCadena.encontrarPatron("T").get(1), new Integer(4));
        assertEquals(arbolCadena.encontrarPatron("T").get(2), new Integer(0));
    }
    
    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron_noEncuentroSufijos() {
        assertTrue(arbolCadena.encontrarPatron("MAL").isEmpty());
    }
    
}