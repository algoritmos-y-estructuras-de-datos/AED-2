/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author joaqu
 */
public class OrdenadorTest {
    
    public OrdenadorTest() {
        
        
    }
    
    Ordenador r;
    
    @Before
    public void before(){
        r = new Ordenador();
    }
    
    
    @Test
    public void testOrdenarPorHeapSort() {
        long[] asc = {1,2,3,4};
        long[] desc = {9,8,7,5};
        long[] aletorio = {88,75,156,7};
        
        long[] asc2 = {1,2,3,4};
        long[] desc2 = {9,8,7,5};
        long[] aletorio2 = {88,75,156,7};
        
        long[] result = r.ordenarPorHeapSort(asc, true);
        long[] result2 = r.ordenarPorHeapSort(desc, true);
        long[] result3 = r.ordenarPorHeapSort(aletorio, true);
        
        long[] result4 = r.ordenarPorHeapSort(asc2, false);
        long[] result5 = r.ordenarPorHeapSort(desc2, false);
        long[] result6 = r.ordenarPorHeapSort(aletorio2, false);
        
        long[] expResult = {1,2,3,4};
        long[] expResult2 = {5,7,8,9};
        long[] expResult3 = {7,75,88,156};
        
        long[] expResult4 = {4,3,2,1};
        long[] expResult5 = {9,8,7,5};
        long[] expResult6 = {156,88,75,7};
        
        
//        assertArrayEquals(expResult, result);
//        assertArrayEquals(expResult2, result2);
//        assertArrayEquals(expResult3, result3);
        assertArrayEquals(expResult4, result4);
        assertArrayEquals(expResult5, result5);
        assertArrayEquals(expResult6, result6);
    }

   
    
}
