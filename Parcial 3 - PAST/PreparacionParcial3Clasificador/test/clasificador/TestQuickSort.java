package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestQuickSort {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
    @Test
    public void testOrdenarPorQuickSortBasico() {
        System.out.println("ordenarPorQuickSortBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorQuickSort(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorQuickSortNulo() {
        System.out.println("ordenarPorQuickSortNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorQuickSort(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorQuickSortRepetidos() {
        System.out.println("ordenarPorQuickSortRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorQuickSort(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorQuickSortNegativos() {
        System.out.println("ordenarPorQuickSortNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorQuickSort(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorQuickSortArray() {
        System.out.println("ordenarPorQuickSortArray");
        int[] datosParaClasificar = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorQuickSort(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorQuickSortDescBasico() {
        System.out.println("ordenarPorQuickSortDescBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorQuickSortDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
   
     @Test
    public void testOrdenarPorQuickSortDescNegativos() {
        System.out.println("ordenarPorQuickSortDescNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorQuickSortDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorQuickSortDescArray() {
        System.out.println("ordenarPorQuickSortDescArray");
        int[] datosParaClasificar = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorQuickSortDescendente(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testEncuentraPivote_3args_1() {
        System.out.println("encuentraPivote");
        int izquierda = 10;
        int derecha = 8;
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int expResult = 10;
        int result = instance.encuentraPivote(izquierda, derecha, entrada);
        assertEquals(expResult, result);
    }

    @Test
    public void testEncuentraPivote_int_intArr() {
        System.out.println("encuentraPivote2");
        int izquierda = 0;
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int expResult = 0;
        int result = instance.encuentraPivote(izquierda, entrada);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEncuentraPivote_int_intArr2() {
        System.out.println("encuentraPivote2");
        int izquierda = 0;
        int[] entrada = {7,10,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int expResult = 1;
        int result = instance.encuentraPivote(izquierda, entrada);
        assertEquals(expResult, result);
    }

    @Test
    public void testEncuentraPivote_intArr_int() {
        System.out.println("encuentraPivoteDerecha");
        int[] entrada = {7,10,1,5,3,2,0,8};
        int derecha = 7;
        TClasificador instance = new TClasificador();
        int expResult = 7;
        int result = instance.encuentraPivote(entrada, derecha);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEncuentraPivote_intArr_int2() {
        System.out.println("encuentraPivoteDerecha2");
        int[] entrada = {7,10,1,5,3,2,8,0};
        int derecha = 7;
        TClasificador instance = new TClasificador();
        int expResult = 6;
        int result = instance.encuentraPivote(entrada, derecha);
        assertEquals(expResult, result);
    }

    @Test
    public void testEncuentraPivote_3args_2() {
        System.out.println("encuentraPivote");
        int[] entrada = {7,10,1,5,3,2,8,0};
        int izq = 0;
        int der = 7;
        TClasificador instance = new TClasificador();
        int expResult = 3;
        int result = instance.encuentraPivote(entrada, izq, der);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorQuickSortDescNulo() {
        System.out.println("ordenarPorQuickSortDescNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorQuickSortDescendente(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
}
