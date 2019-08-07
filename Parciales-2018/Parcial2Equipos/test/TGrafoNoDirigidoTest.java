/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
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
public class TGrafoNoDirigidoTest {
    
    public TGrafoNoDirigidoTest() {
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
     * Test of listarContactos method, of class TGrafoNoDirigido.
     */
    @Test
    public void testListarContactos() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));
        vertices.add(new TVertice("E"));
        
        
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("A", "D", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("B", "D", 1));
        aristas.add(new TArista("C", "D", 1));
        aristas.add(new TArista("D", "E", 1));
        aristas.add(new TArista("E", "B", 1));
       
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
         
        System.out.println("listarContactos");
        String nombreActor = "A";
        int maxSaltos = 1;
        TGrafoNoDirigido instance = gnd;
        int expResult = 3;
        int result = instance.listarContactos(nombreActor, maxSaltos).size();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testListarContactos2() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));
        vertices.add(new TVertice("E"));
        
        
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
       
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
         
        System.out.println("listarContactos");
        String nombreActor = "A";
        int maxSaltos = 1;
        TGrafoNoDirigido instance = gnd;
        int expResult = 2;
        int result = instance.listarContactos(nombreActor, maxSaltos).size();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testListarContactos3() {
        Collection<TVertice> vertices = new ArrayList<>();
        
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));
        vertices.add(new TVertice("E"));
        
        
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
       
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
         
        System.out.println("listarContactos");
        String nombreActor = "A";
        int maxSaltos = 1;
        TGrafoNoDirigido instance = gnd;
        int expResult = 0;
        int result = instance.listarContactos(nombreActor, maxSaltos).size();
        assertEquals(expResult, result);
        
    }
}
