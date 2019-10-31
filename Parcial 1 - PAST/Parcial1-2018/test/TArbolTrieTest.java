/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mati
 */
public class TArbolTrieTest {
    
    public TArbolTrieTest() {
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
     * Test of buscarDispositivos method, of class TArbolTrie.
     */
    @Test
    public void testBuscarDispositivos() {
        System.out.println("buscarDispositivos");
        String mascaraSubRed = "033";
        TArbolTrie instance = new TArbolTrie();
        Collection<TDispositivo> resultado = instance.buscarDispositivos(mascaraSubRed);
        // Caso vacio
        assertEquals(resultado, null);
        
        
        TArbolTrie instance2 = new TArbolTrie();
        TDispositivo dispositivo = new TDispositivo("010.123.234.133", "Juan perez", "");
        instance2.insertar(dispositivo);
        Collection<TDispositivo> resultado2 = instance2.buscarDispositivos(mascaraSubRed);
        // Caso largo 1 sin resultados
        assertEquals(resultado2.isEmpty(), true);
        
        
        TArbolTrie instance3 = new TArbolTrie();
        TDispositivo dispositivo2 = new TDispositivo("010.123.244.133", "Juan perez", "");
        TDispositivo dispositivo3 = new TDispositivo("010.123.214.133", "Juan perez", "");
        TDispositivo dispositivo4 = new TDispositivo("010.113.234.133", "Juan perez", "");
        TDispositivo dispositivo5 = new TDispositivo("010.193.234.133", "Juan perez", "");
        TDispositivo dispositivo6 = new TDispositivo("010.023.234.133", "Juan perez", "");
        instance3.insertar(dispositivo2);
        instance3.insertar(dispositivo3);
        instance3.insertar(dispositivo4);
        instance3.insertar(dispositivo5);
        instance3.insertar(dispositivo6);
        Collection<TDispositivo> resultado3 = instance3.buscarDispositivos(mascaraSubRed);
        // Caso largo mayor que 1 sin resultados
        assertEquals(resultado3.isEmpty(), true);
        
        
        TArbolTrie instance4 = new TArbolTrie();
        TDispositivo dispositivo7 = new TDispositivo("010.123.244.133", "Juan perez", "");
        TDispositivo dispositivo8 = new TDispositivo("010.123.214.133", "Juan perez", "");
        TDispositivo dispositivo9 = new TDispositivo("033.113.234.133", "Juan perez", "");
        TDispositivo dispositivo10 = new TDispositivo("010.193.234.133", "Juan perez", "");
        TDispositivo dispositivo11 = new TDispositivo("010.023.234.133", "Juan perez", "");
        instance4.insertar(dispositivo7);
        instance4.insertar(dispositivo8);
        instance4.insertar(dispositivo9);
        instance4.insertar(dispositivo10);
        instance4.insertar(dispositivo11);
        Collection<TDispositivo> resultado4 = instance4.buscarDispositivos(mascaraSubRed);
        // Caso un solo resultado
        assertEquals(resultado4.size(), 1);
        
        
        TArbolTrie instance5 = new TArbolTrie();
        TDispositivo dispositivo12 = new TDispositivo("010.123.244.133", "Juan perez", "");
        TDispositivo dispositivo13 = new TDispositivo("033.123.214.133", "Juan perez", "");
        TDispositivo dispositivo14 = new TDispositivo("033.199.234.133", "Juan perez", "");
        TDispositivo dispositivo15 = new TDispositivo("010.193.234.133", "Juan perez", "");
        TDispositivo dispositivo16 = new TDispositivo("033.023.234.133", "Juan perez", "");
        instance5.insertar(dispositivo12);
        instance5.insertar(dispositivo13);
        instance5.insertar(dispositivo14);
        instance5.insertar(dispositivo15);
        instance5.insertar(dispositivo16);
        Collection<TDispositivo> resultado5 = instance5.buscarDispositivos(mascaraSubRed);
        // Caso mas de un resultado
        assertEquals(resultado5.size(), 3);
    }

    
}
