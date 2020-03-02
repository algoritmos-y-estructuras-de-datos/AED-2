/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificador;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meki
 */
public class TClasificadorTest {
    
    public TClasificadorTest() {
    }

       public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }

    @Test
    public void testOrdenadoAscendente() {
        System.out.println("ordenadoAscendente");
        int[] datos = {1,2,3,4,5,6,7,8,9};
        TClasificador instance = new TClasificador();
        String expResult = "SI. Conjunto ordenado ascendentemente";
        String result = instance.ordenadoAscendente(datos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMalOrdenadoAscendente() {
        System.out.println("ordenadoAscendente");
        int[] datos = {1,2,4,3,5,6,7,8,9};
        TClasificador instance = new TClasificador();
        String expResult = "NO. Conjunto desordenado entre los valores 4 y 3";
        String result = instance.ordenadoAscendente(datos);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenadoAscendente2() {
        System.out.println("ordenadoAscendente2");
        int[] datos = {1,2,3,4 ,5,6,7,8,9};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        boolean result = instance.ordenadoAscendenteBoolean(datos);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testMalOrdenadoAscendente2() {
        System.out.println("ordenadoAscendente2");
        int[] datos = {1,2,4,3,5,6,7,9,8};
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        boolean result = instance.ordenadoAscendenteBoolean(datos);
        assertEquals(expResult, result);
    }


    @Test
    public void testOrdenadoDescendente() {
        System.out.println("ordenadoDescendente");
        int[] datos = {9,8,7,6,5,4,3,2,1};
        TClasificador instance = new TClasificador();
        String expResult = "SI. Conjunto ordenado descendentemente";
        String result = instance.ordenadoDescendente(datos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMalOrdenadoDescendente() {
        System.out.println("ordenadoDescendente");
        int[] datos = {9,8,7,6,5,4,3,2,10};
        TClasificador instance = new TClasificador();
        String expResult = "NO. Conjunto desordenado entre los valores 2 y 10";
        String result = instance.ordenadoDescendente(datos);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrdenadoDescendente2() {
        System.out.println("ordenadoDescendente2");
        int[] datos = {9,8,7,6,5,4,3,2,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        boolean result = instance.ordenadoDescendenteBoolean(datos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMalOrdenadoDescendente2() {
        System.out.println("ordenadoDescendente2");
        int[] datos = {9,8,7,6,5,3,4,2,1};
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        boolean result = instance.ordenadoDescendenteBoolean(datos);
        assertEquals(expResult, result);
    }
    
}
