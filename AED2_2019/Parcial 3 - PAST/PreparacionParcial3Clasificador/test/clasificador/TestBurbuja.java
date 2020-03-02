package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static clasificador.TClasificador.METODO_CLASIFICACION_BURBUJA;


public class TestBurbuja {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
    @Test
    public void testOrdenarPorBurbujaBasico() {
        System.out.println("ordenarPorBurbujaBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorBurbuja(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorBurbujaNulo() {
        System.out.println("ordenarPorBurbujaNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResult = instance.ordenarPorBurbuja(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBurbujaRepetidos() {
        System.out.println("ordenarPorBurbujaRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorBurbuja(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBurbujaNegativos() {
        System.out.println("ordenarPorBurbujaNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorBurbuja(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testOrdenarPorBurbujaArray() {
        System.out.println("ordenarPorBurbujaArray");
        int[] datosParaClasificar ={10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorBurbuja(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBurbujaDescBasico() {
        System.out.println("ordenarPorBurbujaDescBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorBurbujaDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testOrdenarPorBurbujaDescNulo() {
        System.out.println("ordenarPorBurbujaDescNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResult = instance.ordenarPorBurbujaDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBurbujaDescRepetidos() {
        System.out.println("ordenarPorBurbujaDescRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorBurbujaDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBurbujaDescNegativos() {
        System.out.println("ordenarPorBurbujaDescNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResult = instance.ordenarPorBurbujaDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResult);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorBurbujaDescArray() {
        System.out.println("ordenarPorBurbujaDescArray");
        int[] datosParaClasificar =  {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorBurbujaDescendente(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }

}
