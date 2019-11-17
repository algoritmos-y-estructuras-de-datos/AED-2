package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRadixSort {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
     @Test
    public void testOrdenarPorRadixSortBasico() {
        System.out.println("ordenarPorRadixSortBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorRadixsort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorRadixSortNulo() {
        System.out.println("ordenarPorRadixSortNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorRadixsort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorRadixSortRepetidos() {
        System.out.println("ordenarPorRadixSortRepetidos");
        int[] entrada = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorRadixsort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorRadixSortArray() {
        System.out.println("ordenarPorRadixSortArray");
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorRadixsort(entrada);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorRadixSortDescBasico() {
        System.out.println("ordenarPorRadixSortDescBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorRadixsortDesc(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorRadixSortDescNulo() {
        System.out.println("ordenarPorRadixSortDescNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorRadixsortDesc(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorRadixSortDescArray() {
        System.out.println("ordenarPorRadixSortDescArray");
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult =  {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorRadixsortDesc(entrada);
        assertArrayEquals(expResult, result);
    }

}
