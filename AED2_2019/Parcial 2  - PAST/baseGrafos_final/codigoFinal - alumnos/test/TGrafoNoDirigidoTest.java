/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author usuario
 */
public class TGrafoNoDirigidoTest {
    
    private TVertice a;
    private TVertice b;
    private TVertice c;
    private TVertice d;
    private TVertice e;
    private TVertice f;
    private TVertice g;
    private TVertice h;
    private TGrafoNoDirigido gd2;
    private TGrafoNoDirigido gd3;
     private TGrafoNoDirigido gdvacio;

    @Before
    public void setUp() {
        gd2 = new TGrafoNoDirigido(Arrays.asList(new TVertice("A"), new TVertice("B"), new TVertice("C"), new TVertice("D"), new TVertice("E"), new TVertice("F"), new TVertice("G"), new TVertice("H")), new LinkedList<>());
        a = gd2.getVertices().get("A");
        b = gd2.getVertices().get("B");
        c = gd2.getVertices().get("C");
        d = gd2.getVertices().get("D");
        e = gd2.getVertices().get("E");
        f = gd2.getVertices().get("F");
        g = gd2.getVertices().get("G");
        h = gd2.getVertices().get("E");

        gdvacio = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
    }

    

    /**
     * Test of imprimirEtiquetas method, of class TGrafoNoDirigido.
     */
    

    /**
     * Test of Prim method, of class TGrafoNoDirigido.
     */
    @Test
    public void testPrim() {
        System.out.println("Prim");
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

        aristas.add(new TArista("A", "B", 50));
        aristas.add(new TArista("A", "C", 200));
        aristas.add(new TArista("B", "D", 10));
        aristas.add(new TArista("C", "D", 30));
        TGrafoNoDirigido gd2 = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido gd3 = gd2.Prim();
        
        int expResult = 90;
        int result = gd3.costoTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testPrim_Vacio() {
        System.out.println("Prim Vacio");
        TGrafoNoDirigido gd3 = gdvacio.Prim();
        
        int expResult = 0;
        int result = gd3.costoTotal();
        assertEquals(expResult, result);
    }
    /**
     * Test of Kruskal method, of class TGrafoNoDirigido.
     */
    @Test
    public void testKruskal() {
        System.out.println("Kruskal");
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        aristas.add(new TArista("A", "B", 50));
        aristas.add(new TArista("A", "C", 200));
        aristas.add(new TArista("B", "D", 10));
        aristas.add(new TArista("C", "D", 30));
        TGrafoNoDirigido gd2 = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido gd3 = gd2.Kruskal();
        
        int expResult = 90;
        int result = gd3.costoTotal();
        assertEquals(expResult, result);
    }
    @Test
    public void testKruskal_Vacio() {
        System.out.println("Kruskal Vacio");
        TGrafoNoDirigido gd3 = gdvacio.Kruskal();
        
        int expResult = 0;
        int result = gd3.costoTotal();
        assertEquals(expResult, result);
    }
    @Test
    public void testPuntoArticulacion_Denso() {
        System.out.println("PuntoArticulacion de grafo denso");
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);
        vertices.add(h);

        aristas.add(new TArista("D", "B", 200));
        aristas.add(new TArista("D", "A", 200));
        aristas.add(new TArista("D", "C", 200));
        aristas.add(new TArista("A", "B", 200));
        aristas.add(new TArista("A", "C", 200));
        aristas.add(new TArista("C", "B", 200));
        aristas.add(new TArista("D", "E", 200));
        aristas.add(new TArista("D", "F", 200));
        aristas.add(new TArista("F", "G", 200));
        aristas.add(new TArista("F", "H", 200));
        aristas.add(new TArista("G", "H", 200));
        TGrafoNoDirigido gd2 = new TGrafoNoDirigido(vertices, aristas);
        List<TVertice> gd3 = gd2.puntosDeArticulacion();
        String res = "";
        for(TVertice vert : gd3){
            res+=vert.getEtiqueta();
        }
        String expResult = "FD";
        assertEquals(expResult, res);
    }
    @Test
    public void testPuntoArticulacion_PocoDenso() {
        System.out.println("PuntoArticulacion de grafo poco denso");
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);
        vertices.add(h);

        aristas.add(new TArista("D", "A", 200));
        aristas.add(new TArista("A", "B", 200));
        aristas.add(new TArista("A", "C", 200));
        aristas.add(new TArista("C", "B", 200));
        aristas.add(new TArista("D", "E", 200));
        aristas.add(new TArista("E", "A", 200));
        TGrafoNoDirigido gd2 = new TGrafoNoDirigido(vertices, aristas);
        List<TVertice> gd3 = gd2.puntosDeArticulacion();
        String res = "";
        for(TVertice vert : gd3){
            res+=vert.getEtiqueta();
        }
        String expResult = "A";
        assertEquals(expResult, res);
    }
    
    @Test
    public void puntosDeArticulacionVacion() {
        assertTrue(gdvacio.puntosDeArticulacion().isEmpty());
    }


    @Test
    public void puntosDeArticulacionGrafoConexo() {
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("E", "A", 0));
        aristas.add(new TArista("E", "B", 0));
        aristas.add(new TArista("E", "D", 0));
        aristas.add(new TArista("C", "B", 0));
        gd3 = new TGrafoNoDirigido(gd2.getVertices().values(), aristas);
        a = gd3.getVertices().get("A");
        b = gd3.getVertices().get("B");
        c = gd3.getVertices().get("C");
        d = gd3.getVertices().get("D");
        e = gd3.getVertices().get("E");

        List<TVertice> puntos = gd3.puntosDeArticulacion();
        assertEquals(2, puntos.size());
        assertTrue(puntos.contains(e));
        assertTrue(puntos.contains(b));

    }

    @Test
    public void puntosDeArticulacionDosComponentes() {
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("E", "A", 0));
        aristas.add(new TArista("E", "B", 0));
        aristas.add(new TArista("E", "D", 0));
        aristas.add(new TArista("C", "B", 0));

        aristas.add(new TArista("F", "G", 0));
        aristas.add(new TArista("G", "H", 0));

        gd3 = new TGrafoNoDirigido(Arrays.asList(a, b, c, d, e, new TVertice("F"), new TVertice("G"), new TVertice("H")), aristas);

        List<TVertice> puntos = gd3.puntosDeArticulacion();
        assertEquals(3, puntos.size());
        assertTrue(puntos.contains(gd3.getVertices().get("G")));
        assertTrue(puntos.contains(gd3.getVertices().get("E")));
        assertTrue(puntos.contains(gd3.getVertices().get("B")));
}
    
}
