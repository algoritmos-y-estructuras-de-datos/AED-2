package ut5.routers;

import ut5.routers.UtilGrafos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {


    // @Before
    // public void setUp() {

    // redFragil = (TGrafoConexionesRed) UtilGrafos.cargarGrafo(
    // "UT5/extra_criticos/src/main/java/ut5/routers/routers.txt",
    // "UT5/extra_criticos/src/main/java/ut5/routers/conexiones.txt",
    // false,
    // TGrafoConexionesRed.class);
    // }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void routersCriticosDesdeOrigen1Test() {
        TGrafoConexionesRed redFragil = (TGrafoConexionesRed) UtilGrafos.cargarGrafo(
                "C:/AED2/AED-2/UT5/extra_criticos/src/main/java/ut5/routers/routers.txt",
                "C:/AED2/AED-2/UT5/extra_criticos/src/main/java/ut5/routers/conexiones.txt",
                false,
                TGrafoConexionesRed.class);
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R2");
        int actual = routersCriticos.size();
        int expected = 2;
        assertEquals("El tamaño obtenido no es correcto", expected, actual);
    }

    @Test
    public void routersCriticosDesdeOrigen2Test() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R5");
        int actual = routersCriticos.size();
        int expected = 2;
        assertEquals("El tamaño obtenido no es correcto", expected, actual);
    }
}
