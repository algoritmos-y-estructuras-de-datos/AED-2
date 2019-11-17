package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCuentas {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
     @Test
    public void testOrdenarPorCuentasBasico() {
        System.out.println("ordenarPorCuentasBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorCuentaPorDistrubucion(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorCuentasNulo() {
        System.out.println("ordenarPorCuentasNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorCuentaPorDistrubucion(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorCuentasRepetidos() {
        System.out.println("ordenarPorCuentasRepetidos");
        int[] entrada = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorCuentaPorDistrubucion(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorCuentasArray() {
        System.out.println("ordenarPorCuentasArray");
        int[] entrada =  {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result=instance.ordenarPorCuentaPorDistrubucion(entrada);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorCuentasDescBasico() {
        System.out.println("ordenarPorCuentasDescBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorCuentaPorDistrubucionDesc(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorCuentasDescNulo() {
        System.out.println("ordenarPorCuentasDescNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorCuentaPorDistrubucionDesc(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorCuentasDescArray() {
        System.out.println("ordenarPorCuentasDescArray");
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult =  {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorCuentaPorDistrubucionDesc(entrada);
        assertArrayEquals(expResult, result);
    }

}
