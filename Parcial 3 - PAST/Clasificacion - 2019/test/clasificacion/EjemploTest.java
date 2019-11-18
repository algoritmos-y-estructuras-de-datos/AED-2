package clasificacion;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EjemploTest {

    private int[] vectorPrueba;
    private int[] vectorAsc;
    private int[] vectorDesc;
    private int tamanio = 10000;
    private IClasificador tc;
    private TClasificadorConErrores tcMal;

    @Before
    public void init() {
        IGeneradorDatos gen = new GeneradorDatosGenericos();
        //vectorPrueba = gen.generarDatosAleatorios();
        vectorPrueba = gen.generarDatosAleatorios(tamanio);
        vectorAsc = gen.generarDatosAscendentes(tamanio);
        vectorDesc = gen.generarDatosDescendentes(tamanio);
        tc = new TClasificador();
        tcMal = new TClasificadorConErrores();
    }

    @Test
    public void testInserDirec() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    public void testInserDirec_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    public void testInserDirec_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
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
    public void testShell_ascendente() {
	int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_SHELL);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    public void testShell_descendente() {
	int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
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
    public void testBurbuja_ascendente() {
	int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    public void testBurbuja_descendente() {
	int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    /*
    @Test
    public void testBurbujaMejorado() {
	int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA_MEJORADO);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    */

    @Test
    //public void testQuiksort() {
    public void testQuicksort() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    //public void testQuiksort() {
    public void testQuicksort_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    //public void testQuiksort() {
    public void testQuicksort_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    //public void testQuiksort() {
    public void testQuicksortMal() {
        int[] vectorResultado = tcMal.clasificar(vectorPrueba.clone(),
                TClasificadorConErrores.METODO_CLASIFICACION_QUICKSORT);
        
        assertTrue(tc.estaOrdenadoSinRepetidos(vectorResultado));
    }
    
    @Test
    public void testHeapsort() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testHeapsort_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testHeapsort_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testSeleccion() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testSeleccion_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testSeleccion_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }

}