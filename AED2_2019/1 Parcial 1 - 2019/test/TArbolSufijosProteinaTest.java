/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class TArbolSufijosProteinaTest {
    
    public TArbolSufijosProteinaTest() {
    }

    /**
     * Test of encontrarPatron method, of class TArbolSufijosProteina.
     */
    @Test
    public void testEncontrarPatron() {
        System.out.println("encontrarPatron");
        String patron = "";
        TArbolSufijosProteina instance = new TArbolSufijosProteina();
        LinkedList<Integer> expResult = null;
        LinkedList<Integer> result = instance.encontrarPatron(patron);
        assertEquals(expResult, result);
    }
}
