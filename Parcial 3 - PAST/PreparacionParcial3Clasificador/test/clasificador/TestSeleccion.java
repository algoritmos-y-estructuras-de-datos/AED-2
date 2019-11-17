package clasificador;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSeleccion {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
    @Test
    public void testOrdenarPorSeleccionBasico() {
        System.out.println("ordenarPorSeleccionBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorSeleccion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorSeleccionNulo(){
        System.out.println("ordenarPorSeleccionNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorSeleccion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorSeleccionRepetidos(){
        System.out.println("ordenarPorSeleccionRepetidos");
        int[] datosParaClasificar = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorSeleccion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorSeleccionNegativos(){
        System.out.println("ordenarPorSeleccionNegativos");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorSeleccion(datosParaClasificar);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testOrdenarPorSeleccionArray(){
        System.out.println("ordenarPorSeleccionArray");
        int[] datosParaClasificar = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {0,1,2,3,5,7,8,10};
        int[] result = instance.ordenarPorSeleccion(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testOrdenarPorSeleccionDescBasico(){
        System.out.println("ordenarPorSeleccionDescBasico");
        int[] datosParaClasificar = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorSeleccionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorSeleccionDescNegativo(){
        System.out.println("ordenarPorSeleccionDescNegativo");
        int[] datosParaClasificar = {-1,-10,-5,-3,-4,-20,-21,0,1,40,11};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorSeleccionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testOrdenarPorSeleccionDescNulo(){
        System.out.println("ordenarPorSeleccionDescNulo");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorSeleccionDescendente(datosParaClasificar);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorSeleccionDescArray() {
        System.out.println("ordenarPorSeleccionDescArray");
        int[] datosParaClasificar = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        int[] expResult = {10,8,7,5,3,2,1,0};
        int[] result = instance.ordenarPorSeleccionDescendente(datosParaClasificar);
        assertArrayEquals(expResult, result);
    }

    
}
