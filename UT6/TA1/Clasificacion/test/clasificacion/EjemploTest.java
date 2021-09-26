package clasificacion;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EjemploTest {

    private int[] vectorPrueba;
    //private int tamanio = 30000;
    private int tamanio = 10000;
    private IClasificador tc;

    @Before
    public void init() {
        IGeneradorDatos gen = new GeneradorDatosGenericos();
        //vectorPrueba = gen.generarDatosAleatorios();
        vectorPrueba = gen.generarDatosAleatorios(tamanio);
        tc = new TClasificador();
    }

    @Test
    public void testInserDirec() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }

    @Test
    public void testShell() {
	int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SHELL);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }

    @Test
    public void testBurbuja() {
	int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    public void testBurbujaMejorado() {
	int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA_MEJORADO);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }

    @Test
    //public void testQuiksort() {
    public void testQuicksort() {
        //
        // Complete el test aqu�:
        //
    }

}
