package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestInsercion {
    
     public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
     
     @Test
    public void testOrdenarPorInsercionBasico() {
        System.out.println("ordenarPorInsercionBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorInsercion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testOrdenarPorInsercionNulo() {
        System.out.println("ordenarPorInsercionNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResult = instance.ordenarPorInsercion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorInsercionRepetidos() {
        System.out.println("ordenarPorInsercionRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorInsercion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorInsercionNegativos() {
        System.out.println("ordenarPorInsercionNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorInsercion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorInsercionArray() {
        System.out.println("ordenarPorInsercionArray");
        int[] datosParaClasificar = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorInsercion(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
     
    @Test
    public void testOrdenarPorInsercionDescBasico() {
        System.out.println("ordenarPorInsercionDescBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorInsercionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testOrdenarPorInsercionDescNulo() {
        System.out.println("ordenarPorInsercionDescNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResult = instance.ordenarPorInsercionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorInsercionDescRepetidos() {
        System.out.println("ordenarPorInsercionDescRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorInsercionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorInsercionDescNegativos() {
        System.out.println("ordenarPorInsercionDescNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorInsercionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }  

    @Test
    public void testOrdenarPorInsercionDescArray() {
        System.out.println("ordenarPorInsercionDescArray");
        int[] datosParaClasificar = {10,7,1,5,3,2,0,8};;
        TClasificador instance = new TClasificador();
        int[] expResult = {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorInsercionDescendente(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
}
