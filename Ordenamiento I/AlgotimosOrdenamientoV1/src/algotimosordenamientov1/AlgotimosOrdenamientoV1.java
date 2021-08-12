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
        int[] elArrayQ = {2, 9, 188, 7, 4};
        QuickSort sorterQ = new QuickSort();
        sorterQ.sort(elArrayQ, 0, elArrayQ.length - 1);
        System.out.println("Sorted with QUICKSORT: " + Arrays.toString(elArrayQ));
        int[] elArrayB = {2, 19, 7, 4};
        BubbleSort sorterB = new BubbleSort();
        sorterB.sort(elArrayB);
        System.out.println("Sorted with BUBBLESORT: " + Arrays.toString(elArrayB));
        int[] elArrayS = {2, 19, 7, 4,12,34,55,66,77,1,900,876,64566};
        ShellSort sorterS = new ShellSort();
        sorterS.sort(elArrayS);
        System.out.println("Sorted with SHELLSORT: " + Arrays.toString(elArrayS));
        /*int[] elArrayI = {2, 19, 7, 4};
        InsertionSort sorterI = new InsertionSortt();
        sorterI.sort(elArrayI);
        System.out.println("Sorted with INSERTIONSORT: " + Arrays.toString(elArrayI));*/
    }

}
