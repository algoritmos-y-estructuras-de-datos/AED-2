/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Homero
 */
public class TGrafoRedElectricaTest {
        
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Prim method, of class TGrafoNoDirigido.
     */
    @Test
    public void testMejorRedElectrica1() {
        System.out.println("MejorRedElectrica1");
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        TVertice a = new TVertice("A");
        TVertice b = new TVertice("B");
        TVertice c = new TVertice("C");
        TVertice d = new TVertice("D");
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        
        TArista t0 = new TArista("A", "B", 50);
        TArista t1 = new TArista("A", "C", 200);
        TArista t2 = new TArista("B", "D", 10);
        TArista t3 = new TArista("C", "D", 30);

        aristas.add(t0);
        aristas.add(t1);
        aristas.add(t2);
        aristas.add(t3);
        TGrafoRedElectrica gd2 = new TGrafoRedElectrica(vertices, aristas);
        LinkedList<TArista> result= gd2.mejorRedElectrica();
        
        LinkedList<TArista> expResult = new LinkedList<>() ;
        expResult.add(t2);
        aristas.add(t3);
        aristas.add(t0);
        assertEquals(expResult.size(), result.size());
        assertTrue(result.size()==3);
        assertEquals(expResult.contains(t2), result.contains(t2));
        assertEquals(expResult.contains(t3), result.contains(t3));
        assertEquals(expResult.contains(t0), result.contains(t0));
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testMejorRedElectrica_Vacio() {
        System.out.println("testMejorRedElectrica_Vacio");
        LinkedList<TVertice> vertices = new LinkedList<>();
        LinkedList<TArista> aristas = new LinkedList<>();
        TGrafoRedElectrica gd3 = new TGrafoRedElectrica(vertices,aristas); 
        LinkedList<TArista> result = gd3.mejorRedElectrica();
        LinkedList<TArista> expResult = new LinkedList<>();
        assertTrue(result.size()==0);
        assertEquals(expResult.size(), result.size());
    }
    
}