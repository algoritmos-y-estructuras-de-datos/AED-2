package clasificacion;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EjemploTest {

    private int[] vectorPrueba;
    private int[] vectorAsc;
    private int[] vectorDesc;
    private int tamanio = 30000;
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
    public void testInserDirecInverso() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testInserDirecInverso_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testInserDirecInverso_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
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
    public void testShellInverso() {
	int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SHELL_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testShellInverso_ascendente() {
	int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_SHELL_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testShellInverso_descendente() {
	int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_SHELL_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
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
    
    @Test
    public void testBurbujaInverso() {
	int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testBurbujaInverso_ascendente() {
	int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testBurbujaInverso_descendente() {
	int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
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
    public void testQuicksortInverso() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testQuicksortInverso_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testQuicksortInverso_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
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
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testHeapsort_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testHeapsort_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testHeapsortInverso() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testHeapsortInverso_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testHeapsortInverso_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT_INVERSO);
        
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
    
    @Test
    public void testSeleccionInverso() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testSeleccionInverso_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testSeleccionInverso_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION_INVERSO);
        
        assertTrue(tc.estaOrdenadoInverso(vectorResultado));
    }
    
    @Test
    public void testBinsort() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BINSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testBinsort_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_BINSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testBinsort_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_BINSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testRadixsort() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_RADIXSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testRadixsort_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_RADIXSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testRadixsort_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_RADIXSORT);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testCuenta() {
        int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_CUENTA);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testCuenta_ascendente() {
        int[] vectorResultado = tc.clasificar(vectorAsc.clone(),
                IClasificador.METODO_CLASIFICACION_CUENTA);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }
    
    @Test
    public void testCuenta_descendente() {
        int[] vectorResultado = tc.clasificar(vectorDesc.clone(),
                IClasificador.METODO_CLASIFICACION_CUENTA);
        
        assertTrue(tc.estaOrdenado(vectorResultado));
    }

}