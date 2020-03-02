/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TClasificadorTest {
    private TClasificador clasif = new TClasificador();
    public TClasificadorTest() {
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
     * Test of ordenarPorBinsort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorShell() {
        System.out.println("ordenarPorShell");
        Comparable[] result ;
        Comparable[] esperado;
        
        result= new Comparable[5];
        result[0]=5;
        result[1]=28;
        result[2]=54;
        result[3]=7;
        result[4]=82;
        esperado=new Comparable[5];
        esperado[0]=5;
        esperado[1]=7;
        esperado[2]=28;
        esperado[3]=54;
        esperado[4]=82;
        clasif.ordenarPorShell(result);
        assertArrayEquals(esperado, result);
    }
    
   
    @Test
    public void testOrdenarPorShell2() {
        System.out.println("ordenarPorShell");
        Comparable[] result = new Comparable[1];
        Comparable[] esperado = new Comparable[1];
        clasif.ordenarPorShell(result);
        assertArrayEquals(esperado, result);}
}
