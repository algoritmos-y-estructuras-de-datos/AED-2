package ut4.grafosd;

import static org.junit.Assert.*;
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
        grafoPrueba = (TGrafoDirigido) UtilGrafos.cargarGrafo("C:/Source/AED-2/UT4/completo/src/main/java/ut4/grafosd/aeropuertos_2.txt", "C:/Source/AED-2/UT4/completo/src/main/java/ut4/grafosd/conexionesPrueba.txt",
                false, TGrafoDirigido.class);

        grafoNulo = null;
    }

    @Test //Me aseguro que la etiqueta correspondiente exista en la coleccion que devuelve bpf
    public void testBPF() {
        boolean tieneEtiqueta = false; 
        for(TVertice vertAux : grafoPrueba.bpf()){
            if(vertAux.getEtiqueta().compareTo("Flores") == 0){
                tieneEtiqueta = true;
            }
        }
        assertTrue(tieneEtiqueta);
    }


    @Test // El tamaño del BPF coincide con el tamaño del Mapa de Vertices
    public void testBPFTamanio(){
        assertTrue("El tamaño del BPF no coincide con el tamaño del Mapa de Vertices", grafoPrueba.getVertices().size() == grafoPrueba.bpf().size());
    }


    @Test
    public void testCentroDelGrafo() {
        Double expectedCenter = 550d;
        assertTrue(grafoPrueba.centroDelGrafo().compareTo(expectedCenter) == 0);
        
    }

    @Test(expected = NullPointerException.class) //Para un grafo nulo, si se intenta obtener el centro de un grafo = null, se espera null
    public void testCentroDelGrafoNulo() {
        grafoNulo.centroDelGrafo();
    }

    @Test //Verifico que el costo entre dos vertices es el que espero luego de floyd
    public void testFloyd() {
        Double[][] matrizCos = grafoPrueba.floyd();
        Double expected = 200.0;
        Double actual = matrizCos[2][1];
        assertEquals(expected,actual);
    }

    @Test // Verifico si el grafo tiene un ciclo
    public void testTieneCiclo() {
        assertTrue("El grafo no tiene ciclos",grafoPrueba.tieneCiclo());
    }

    @Test
    public void testNoTieneCiclo() {
        grafoNulo.tieneCiclo();
        //assertEquals(true,false);
    }

    @Test
    public void testTodosLosCaminos() {
        
        Comparable etiquetaOrigen = "Flores";
        Comparable etiquetaDestino = "Montevideo";
        TCaminos actualCaminos = grafoPrueba.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        TCamino costoActual = actualCaminos.caminoMayorCosto();
        Double actual = costoActual.getCostoTotal();
        Double expected = 100.0;
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class) //Si se envian como parametros etiquetas que no existen, se obtiene nullpointer
    public void testTodosLosCaminosFail() {
        Comparable etiquetaOrigen = "Prueba";
        Comparable etiquetaDestino = "Prueba2";
        grafoNulo.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
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
