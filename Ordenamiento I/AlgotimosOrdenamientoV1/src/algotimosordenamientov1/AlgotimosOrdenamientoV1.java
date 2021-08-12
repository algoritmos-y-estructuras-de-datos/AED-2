/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algotimosordenamientov1;

import java.util.Arrays;

/**
 *
 * @author LUCAS
 */
public class AlgotimosOrdenamientoV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] elArray = {2,9,7,4};
        QuickSort sorter = new QuickSort();
        sorter.sort(elArray, 0, elArray.length-1);
        System.out.println(Arrays.toString(elArray));
    }
    
}
