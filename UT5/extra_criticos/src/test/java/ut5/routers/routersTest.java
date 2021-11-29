package ut5.routers;

import ut5.routers.UtilGrafos;
import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.*;

public class routersTest {
    
    TGrafoConexionesRed redFragil;
    TGrafoConexionesRed redFragilNula;
    
    @Before
    public void setUp() {

    redFragil = (TGrafoConexionesRed) UtilGrafos.cargarGrafo(
    "C:/AED2/AED-2/UT5/extra_criticos/src/main/java/ut5/routers/routers.txt",
    "C:/AED2/AED-2/UT5/extra_criticos/src/main/java/ut5/routers/conexiones.txt",
    false,
    TGrafoConexionesRed.class);

    redFragilNula = null;


    }

    @Test
    public void testCriticosOkDesdeOrigen1() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R2");
        int actual = routersCriticos.size();
        int expected = 2;
        assertEquals("El tamaño obtenido no es correcto", expected, actual);
    }

    @Test
    public void testCriticosOkDesdeOrigen2() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R1");
        int actual = routersCriticos.size();
        int expected = 2;
        assertEquals("El tamaño obtenido no es correcto", expected, actual);
    }

    @Test //Se busca como origen un routter que no existe, por lo cual los routers criticos devueltos son 0
    public void testCriticosOkDesdeOrigen3() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R");
        int actual = routersCriticos.size();
        int expected = 0;
        assertEquals("El tamaño obtenido no es correcto", expected, actual);
    }

    @Test
    public void testCriticosOkDesdeOrigenNulo() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario(null);
        int actual = routersCriticos.size();
        int expected = 0;
        assertEquals("El tamaño obtenido no es correcto", expected, actual);
    }

    @Test (expected = NullPointerException.class) //Si se intenta ejecutar el metodo sobre un grafo nulo se obtiene una excepcion
    public void testCriticosFalloDesdeOrigen() {
        LinkedList<TVertice> routersCriticos = redFragilNula.routersCriticos2Secundario("R1");
    }

    @Test
    public void testCriticosOkControl1() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R1");
        LinkedList<Comparable> etiquetas = new LinkedList<>();
        for(TVertice v : routersCriticos){
            etiquetas.add(v.getEtiqueta());
        }
        Comparable expected = "R5";
        assertTrue("El router obtenido no es correcto", etiquetas.contains(expected));
    }

    @Test
    public void testCriticosOkControl2() {
        LinkedList<TVertice> routersCriticos = redFragil.routersCriticos2Secundario("R1");
        LinkedList<Comparable> etiquetas = new LinkedList<>();
        for(TVertice v : routersCriticos){
            etiquetas.add(v.getEtiqueta());
        }
        Comparable expected = "R1";
        assertTrue("El router obtenido no es correcto", etiquetas.contains(expected));
    }


}
