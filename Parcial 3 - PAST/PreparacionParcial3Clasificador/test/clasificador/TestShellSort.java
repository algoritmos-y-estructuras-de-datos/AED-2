package clasificador;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestShellSort {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
    @Test
    public void testOrdenarPorShellBasico() {
        System.out.println("ordenarPorShellBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] resultado = instance.ordenarPorShell(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(resultado);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorShellNulo() {
        System.out.println("ordenarPorShellNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] resultado = instance.ordenarPorShell(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(resultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellRepetidos() {
        System.out.println("ordenarPorShellRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] resultado = instance.ordenarPorShell(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(resultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellNegativos() {
        System.out.println("ordenarPorShellNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] resultado = instance.ordenarPorShell(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(resultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellArray() {
        System.out.println("ordenarPorShellArray");
        int[] datosParaClasificar ={10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorShell(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellDescBasico() {
        System.out.println("ordenarPorShellDescBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorShellDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellDescNegativos() {
        System.out.println("ordenarPorShellDescNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorShellDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellDescNulo() {
        System.out.println("ordenarPorShellDescNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] resultado = instance.ordenarPorShellDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(resultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorShellDescArray() {
        System.out.println("ordenarPorShellDescArray");
        int[] datosParaClasificar ={10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorShellDescendente(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
}
