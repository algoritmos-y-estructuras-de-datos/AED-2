/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author  HijoDHomero
 */
public class TGrafoAerolineaTest {
    

    @Before
    public void setUp() {
   
    }
    
    /**
     * Test of listarContactos method, of class TGrafoNoDirigido.
     * devuelve una Collection<TVertice>
     */
    @Test
    public void testMenosEscalas() {
        System.out.println("MenosEscalas");
        String nombreActor = "A";
        LinkedList<TVertice> aeropuerto = new LinkedList<>();
        aeropuerto.add(new TVertice("A"));
        aeropuerto.add(new TVertice("B"));
        TGrafoAerolinea instance = new TGrafoAerolinea(aeropuerto, new LinkedList<>());
        LinkedList<TVertice> expResult = new LinkedList<>();
        LinkedList<TVertice> result = instance.menosEscalas("A", "EL FIN DEL MUNDO ESTA CERCA");
        assertTrue(result.size()==0);
        assertEquals(expResult.size(), result.size());
    }
    
    /**
     * Test of listarContactos method, of class TGrafoNoDirigido.
     * devuelve una Collection<TVertice>
     */
    @Test
    public void testMenosEscalas1() {
        System.out.println("MenosEscalas1");
        String nombreActor = "A";
        LinkedList<TVertice> aeropuerto = new LinkedList<>();
        aeropuerto.add(new TVertice("A"));
        aeropuerto.add(new TVertice("B"));
        TGrafoAerolinea instance = new TGrafoAerolinea(aeropuerto, new LinkedList<>());
        LinkedList<TVertice> expResult = new LinkedList<>();
        expResult.add(new TVertice("A"));
        LinkedList<TVertice> result = instance.menosEscalas("A", "A");
        assertTrue(result.size()==1);
        assertEquals(expResult.get(0).getEtiqueta(), result.get(0).getEtiqueta());
        assertEquals(expResult.size(), result.size());
    }
    
    /**
     * Test of listarContactos method, of class TGrafoNoDirigido.
     * devuelve una Collection<TVertice>
     */
    @Test
    public void testMenosEscalas2() {
        System.out.println("MenosEscalas2");
        LinkedList<TVertice> contactos = new LinkedList<>();
        contactos.add(new TVertice("A"));
        contactos.add(new TVertice("B"));
        LinkedList<TArista> conexiones = new LinkedList<>();
        conexiones.add(new TArista("A","B",1));
        TGrafoAerolinea instance = new TGrafoAerolinea(contactos, conexiones);
        LinkedList<TVertice> expResult = new LinkedList<>();
        expResult.add(new TVertice("A"));
        expResult.add(new TVertice("B"));
        LinkedList<TVertice> result = instance.menosEscalas("A", "B");
        assertEquals(expResult.get(0).getEtiqueta(), result.get(0).getEtiqueta());
        assertEquals(expResult.size(), result.size());
    }
    
        
    /**
     * Test of listarContactos method, of class TGrafoNoDirigido.
     * devuelve una Collection<TVertice>
     */
    @Test
    public void testMenosEscalas3() {
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
       
        TGrafoAerolinea gnd = new TGrafoAerolinea(vertices, aristas);     
        LinkedList<TVertice> result = gnd.menosEscalas("A", "E");
        LinkedList<TVertice> expResult = new LinkedList<>() ;
        expResult.add(new TVertice("A"));
        expResult.add(new TVertice("D"));
        expResult.add(new TVertice("E"));
       assertTrue(result.size()==3);
       assertEquals(expResult.get(0).getEtiqueta(), result.get(0).getEtiqueta());
       assertEquals(expResult.get(1).getEtiqueta(), result.get(1).getEtiqueta());
       assertEquals(expResult.get(2).getEtiqueta(), result.get(2).getEtiqueta());
    }
    
}
