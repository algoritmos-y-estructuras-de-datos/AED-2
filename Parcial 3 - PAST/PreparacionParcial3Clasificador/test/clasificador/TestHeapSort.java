package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestHeapSort {
    
     public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
     
    @Test
    public void testOrdenarPorHeapSortBasico() {
        System.out.println("ordenarPorHeapSortBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorHeapSort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorHeapSortNulo() {
        System.out.println("ordenarPorHeapSortNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorHeapSort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorHeapSortRepetidos() {
        System.out.println("ordenarPorHeapSortRepetidos");
        int[] entrada = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorHeapSort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testOrdenarPorHeapSortNegativos() {
        System.out.println("ordenarPorHeapSortNegativos");
        int[] entrada = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorHeapSort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorHeapSortArray() {
        System.out.println("ordenarPorHeapSortArray");
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorHeapSort(entrada);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorHeapSortDescBasico() {
        System.out.println("ordenarPorHeapSortDescBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorHeapSortDescendente(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorHeapSortDescNulo() {
        System.out.println("ordenarPorHeapSortDescNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorHeapSortDescendente(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
     @Test
    public void testOrdenarPorHeapSortDescNegativos() {
        System.out.println("ordenarPorHeapSortDescNegativos");
        int[] entrada = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorHeapSortDescendente(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorHeapSortDescArray() {
        System.out.println("ordenarPorHeapSortDescArray");
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult =  {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorHeapSortDescendente(entrada);
        assertArrayEquals(expResult, result);
    }


}
