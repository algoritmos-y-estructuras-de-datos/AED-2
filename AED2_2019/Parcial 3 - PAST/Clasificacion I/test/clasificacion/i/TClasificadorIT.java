/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacion.i;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TClasificadorIT {
    private TClasificador clasif = new TClasificador();
    
    public TClasificadorIT() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of ordenarPorCuentasPorDistribucion method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorCuentasPorDistribucion() {
        System.out.println("ordenarPorCuentasPorDistribucion");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorCuentasPorDistribucion(datosParaClasificar);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=3;
        datosParaClasificar[2]=8;
        datosParaClasificar[3]=0;
        datosParaClasificar[4]=2;
        esperado=new int[5];
        esperado[0]=0;
        esperado[1]=2;
        esperado[2]=3;
        esperado[3]=5;
        esperado[4]=8;
        result=clasif.ordenarPorCuentasPorDistribucion(datosParaClasificar);
        assertArrayEquals(esperado, result);

    }
    /**
     * Test of ordenarPorBinsort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorShell() {
        System.out.println("ordenarPorShell");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorShell(datosParaClasificar);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=28;
        datosParaClasificar[2]=54;
        datosParaClasificar[3]=7;
        datosParaClasificar[4]=82;
        esperado=new int[5];
        esperado[0]=5;
        esperado[1]=7;
        esperado[2]=28;
        esperado[3]=54;
        esperado[4]=82;
        result=clasif.ordenarPorShell(datosParaClasificar);
        assertArrayEquals(esperado, result);
    }
    
    /**
     * Test of ordenarPorBinsort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorBurbuja() {
        System.out.println("ordenarPorBurbuja");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorBurbuja(datosParaClasificar);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=28;
        datosParaClasificar[2]=54;
        datosParaClasificar[3]=7;
        datosParaClasificar[4]=82;
        esperado=new int[5];
        esperado[0]=5;
        esperado[1]=7;
        esperado[2]=28;
        esperado[3]=54;
        esperado[4]=82;
        result=clasif.ordenarPorBurbuja(datosParaClasificar);
        assertArrayEquals(esperado, result);
    }

    /**
     * Test of ordenarPorBinsort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorBinsort() {
        System.out.println("ordenarPorBinsort");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.binsort(datosParaClasificar,5);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=28;
        datosParaClasificar[2]=54;
        datosParaClasificar[3]=7;
        datosParaClasificar[4]=82;
        esperado=new int[5];
        esperado[0]=5;
        esperado[1]=7;
        esperado[2]=28;
        esperado[3]=54;
        esperado[4]=82;
        result=clasif.ordenarPorInsercion(datosParaClasificar);
        assertArrayEquals(esperado, result);
    }

    /**
     * Test of ordenarPorInsercion method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorInsercion() {
        System.out.println("ordenarPorInsercion");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorInsercion(datosParaClasificar);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=3;
        datosParaClasificar[2]=8;
        datosParaClasificar[3]=0;
        datosParaClasificar[4]=2;
        esperado=new int[5];
        esperado[0]=0;
        esperado[1]=2;
        esperado[2]=3;
        esperado[3]=5;
        esperado[4]=8;
        result=clasif.ordenarPorInsercion(datosParaClasificar);
        assertArrayEquals(esperado, result);
    }

    /**
     * Test of estaOrdenado method, of class TClasificador.
     */
    @Test
    public void testEstaOrdenado() {
        System.out.println("estaOrdenado");
        TClasificador h = new TClasificador();
        int[] datosParaClasificar = new int[1];
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=8;
        datosParaClasificar[2]=9;
        datosParaClasificar[3]=12;
        datosParaClasificar[4]=25;
        Boolean expResult = true;
        Boolean result = h.ordenado(datosParaClasificar);
        assertEquals(expResult, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=8;
        datosParaClasificar[2]=98;
        datosParaClasificar[3]=12;
        datosParaClasificar[4]=25;
        expResult = false;
        result = TClasificador.ordenado(datosParaClasificar);
        assertEquals(expResult, result);
    }

    /**
     * Test of ordenarPorQuickSort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorQuickSort() {
        System.out.println("ordenarPorQuickSort");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorQuickSort(datosParaClasificar);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        
        System.out.println("---------------------------------------");
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=3;
        datosParaClasificar[2]=0;
        datosParaClasificar[3]=2;
        datosParaClasificar[4]=6;
        esperado=new int[5];
        esperado[0]=0;
        esperado[1]=2;
        esperado[2]=3;
        esperado[3]=5;
        esperado[4]=6;
        result=clasif.ordenarPorQuickSort(datosParaClasificar);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        assertArrayEquals(esperado, result);    }



    /**
     * Test of ordenarPorSeleccion method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorSeleccion() {
        System.out.println("ordenarPorSeleccion");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorSeleccionDirecta(datosParaClasificar);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=3;
        datosParaClasificar[2]=8;
        datosParaClasificar[3]=0;
        datosParaClasificar[4]=2;
        esperado=new int[5];
        esperado[0]=0;
        esperado[1]=2;
        esperado[2]=3;
        esperado[3]=5;
        esperado[4]=8;
        result=clasif.ordenarPorSeleccionDirecta(datosParaClasificar);
        assertArrayEquals(esperado, result);
    }

    /**
     * Test of ordenarPorHeapSort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorHeapSort() {
        System.out.println("ordenarPorHeapSort");
        System.out.println("ordenarPorInsercion");
        int[] datosParaClasificar = new int[1];
        int[] esperado = new int[1];
        int[] result = clasif.ordenarPorHeapSort(datosParaClasificar);
        assertArrayEquals(esperado, result);
        datosParaClasificar= new int[5];
        datosParaClasificar[0]=5;
        datosParaClasificar[1]=3;
        datosParaClasificar[2]=8;
        datosParaClasificar[3]=0;
        datosParaClasificar[4]=2;
        esperado=new int[5];
        esperado[0]=0;
        esperado[1]=2;
        esperado[2]=3;
        esperado[3]=5;
        esperado[4]=8;
        result=clasif.ordenarPorHeapSort(datosParaClasificar);
        assertArrayEquals(esperado, result);
    }


    
}
