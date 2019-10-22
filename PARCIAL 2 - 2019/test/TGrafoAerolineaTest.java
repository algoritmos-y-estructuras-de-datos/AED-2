/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class TGrafoAerolineaTest {
    
    public TGrafoAerolineaTest() {
    }

    /**
     * Test of menosEscalas method, of class TGrafoAerolinea.
     */
    @Test
    public void testMenosEscalas() {
        Comparable origen = "A";
        Comparable destino = "J";
        Collection<TVertice> vert = new LinkedList<>();
        vert.add(new TVertice("A"));
        vert.add(new TVertice("J"));
        Collection<TArista> ari = new LinkedList<>();
        ari.add(new TArista("A","J",1));
        TGrafoAerolinea instance = new TGrafoAerolinea(vert,ari);
        int expResult = 1;
        int result = instance.menosEscalas(origen, destino).size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMenosEscalas2() {
        Comparable origen = "A";
        Comparable destino = "J";
        Collection<TVertice> vert = new LinkedList<>();
        vert.add(new TVertice("A"));
        vert.add(new TVertice("J"));
        vert.add(new TVertice("B"));
        Collection<TArista> ari = new LinkedList<>();
        ari.add(new TArista("A","B",1));
        ari.add(new TArista("B","J",1));
        TGrafoAerolinea instance = new TGrafoAerolinea(vert,ari);
        int expResult = 2;
        int result = instance.menosEscalas(origen, destino).size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMenosEscalas3() {
        Comparable origen = "A";
        Comparable destino = "J";
        Collection<TVertice> vert = new LinkedList<>();
        vert.add(new TVertice("A"));
        vert.add(new TVertice("J"));
        vert.add(new TVertice("B"));
        vert.add(new TVertice("H"));
        Collection<TArista> ari = new LinkedList<>();
        ari.add(new TArista("A","B",1));
        ari.add(new TArista("B","H",1));
        TGrafoAerolinea instance = new TGrafoAerolinea(vert,ari);
        int expResult = 0;
        int result = instance.menosEscalas(origen, destino).size();
        assertEquals(expResult, result);
    }
    
}
