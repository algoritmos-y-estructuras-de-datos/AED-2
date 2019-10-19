/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estudiante.fit
 */
public class TGrafoNoDirigidoTest2 {
    
    public TGrafoNoDirigidoTest2() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    TGrafoNoDirigido gnd;
    
    @Before
    public void setUp() {
        //Se inicializa un grafo con 5 actores. 
        //A1 trabajó con todos.
        //A2 trabajó solo con A1
        //A3 trabajó con A4
        //A4 trabajó con A5
        
        ArrayList<TVertice> vertices = new ArrayList<>();
        
        vertices.add( new TVertice("A1"));
        vertices.add( new TVertice("A2"));
        vertices.add( new TVertice("A3"));
        vertices.add( new TVertice("A4"));
        vertices.add( new TVertice("A5"));
        
        ArrayList<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A1", "A2", 0));
        aristas.add(new TArista("A1", "A2", 0));
        aristas.add(new TArista("A1", "A3", 0));
        aristas.add(new TArista("A1", "A4", 0));
        aristas.add(new TArista("A1", "A5", 0));
        aristas.add(new TArista("A3", "A4", 0));
        aristas.add(new TArista("A4", "A5", 0));   
        
        gnd = new TGrafoNoDirigido(vertices, aristas);
    }
    
    @After
    public void tearDown() {
    }
   
    /**
     * Pruebas encontrar solo los actores que trabajaron juntos en alguna pelicula
     */
    @Test
    public void testListarContactosSoloConocidosA1() {
        System.out.println("testListarContactosSoloConocidos");
        String nombreActor = "A1";
        int maxSaltos = 1;
        TGrafoNoDirigido instance = gnd;
        
        Collection<TVertice> result = instance.listarContactos(nombreActor, maxSaltos);
        assertEquals(4, result.size());
        //Chequear el numero de bacon
        assertEquals(1, result.iterator().next().getNumBacon());

    }
    
    @Test
    public void testListarContactosSoloConocidosA2() {
        System.out.println("testListarContactosSoloConocidos");
        String nombreActor = "A2";
        int maxSaltos = 1;
        TGrafoNoDirigido instance = gnd;
        
        Collection<TVertice> result = instance.listarContactos(nombreActor, maxSaltos);
        assertEquals(1, result.size());
        //Chequear el numero de bacon
        assertEquals(1, result.iterator().next().getNumBacon());

    }
    
    /**
     * Devuelve maximo 2 salto. Por tanto son todos porque A1 trabajo con todos
     */
    @Test
    public void testListarContactosConocidoDeConocido() {
        System.out.println("testListarContactosSoloConocidos");
        String nombreActor = "A2";
        int maxSaltos = 2;
        TGrafoNoDirigido instance = gnd;
        
        Collection<TVertice> result = instance.listarContactos(nombreActor, maxSaltos);
        assertEquals(4, result.size());
        //Chequear el numero de bacon
        Iterator<TVertice> it = result.iterator();
        assertEquals(1, it.next().getNumBacon());
        assertEquals(2, it.next().getNumBacon());
    }
    
}
