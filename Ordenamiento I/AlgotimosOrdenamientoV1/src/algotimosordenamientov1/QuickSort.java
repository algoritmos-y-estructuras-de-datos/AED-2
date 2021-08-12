/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algotimosordenamientov1;

/**
 *
 * @author LUCAS
 */
public class QuickSort {

    public int particion(int[] array, int l, int j) {
        int pivot = array[l];
        int paredI = l;
        for (int i = l + 1; i <= j; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[paredI];
                array[paredI] = temp;
                paredI = paredI + 1;
            }
        }
        int tempo = pivot;
        pivot = array[paredI];
        array[paredI] = tempo;
        return paredI;
    }

    public void sort(int[] arr, int low, int h) {
        if (low < h) {
            int j = particion(arr, low, h);
            sort(arr, 0, j);
            sort(arr, j + 1, h);
        }
    }

}
