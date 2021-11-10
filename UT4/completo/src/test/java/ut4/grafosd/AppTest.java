package ut4.grafosd;

import static org.junit.Assert.assertTrue;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    public AppTest(){

    }

    TGrafoDirigido grafoPrueba;
    TGrafoDirigido grafoNulo;
    
    @Before
    public void setUp(){
        grafoPrueba = (TGrafoDirigido) UtilGrafos.cargarGrafo("UT4/completo/src/main/java/ut4/grafosd/aeropuertos_2.txt", "UT4/completo/src/main/java/ut4/grafosd/conexionesPrueba.txt",
                false, TGrafoDirigido.class);

        grafoNulo = null;
    }

    @Test
    public void testBPF() {
        boolean tieneEtiqueta = false; 
        for(TVertice vertAux : grafoPrueba.bpf()){
            if(vertAux.getEtiqueta().compareTo("Flores") == 0){
                tieneEtiqueta = true;
            }
        }
        assertTrue(tieneEtiqueta);
    }

    @Test(expected = NullPointerException.class) //Desde una etiqueta origen que no existe, esperamos NullPointer
    public void testBPFEtiquetaOrigen() {
        TVertice etiquetaOrigen = new TVertice("Hola");        
        assertTrue("Funciona correctamente",grafoPrueba.bpf(etiquetaOrigen).contains(etiquetaOrigen));
    }

    @Test
    public void testBPFEtiquetaNoEncontrada() {
        TVertice etiquetaOrigen = new TVertice("Hola");        
        assertTrue("Funciona correctamente",grafoPrueba.bpf(etiquetaOrigen).contains(etiquetaOrigen));
        
    }

    @Test
    public void testCentroDelGrafo() {
        grafoPrueba.centroDelGrafo();
        assertTrue(true);
    }

    @Test(expected = NullPointerException.class) //Para un grafo nulo, si se intenta obtener el centro de un grafo = null, se espera null
    public void testCentroDelGrafoNulo() {
        grafoNulo.centroDelGrafo();
        assertTrue(true);
    }

    @Test
    public void testFloyd() {
        grafoNulo.floyd();
        assertTrue(true);
    }

    @Test
    public void testTieneCiclo() {
        assertTrue("Funciona correctamente",grafoPrueba.tieneCiclo());
    }

    @Test
    public void testNoTieneCiclo() {
        grafoNulo.tieneCiclo();
        //assertEquals(true,false);
    }

    @Test
    public void testTodosLosCaminos() {
        
        Comparable etiquetaOrigen = "";
        Comparable etiquetaDestino = "";
        grafoNulo.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        assertTrue(true);
    }

    @Test
    public void testTodosLosCaminosFail() {
        Comparable etiquetaOrigen = "";
        Comparable etiquetaDestino = "";
        grafoNulo.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        assertTrue(true);
    }

    @Test
    public void testOrdenTopo() {
        grafoNulo.unOrdenTopologico();
        assertTrue(true);
    }

    @Test
    public void testWarshall() {
        grafoNulo.warshall();
        assertTrue(false);
    }

    
}
