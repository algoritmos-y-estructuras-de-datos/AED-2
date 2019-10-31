
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class InsertionSort {
    
    // using Array
    public static int[] insertionSort(int[] list) {
        int i, j, key, temp;
        for (i = 1; i < list.length; i++) {
            key = list[i];
            j = i - 1;
            while (j >= 0 && key < list[j]) {
                temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                j--;
            }
        }
        return list;
    }

    // using ArrayList
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        int i, j, key, temp;
        for (i = 1; i < list.size(); i++) {
            key = list.get(i);
            j = i - 1;
            while (j >= 0 && key < list.get(j)) {
                temp = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, temp);
                j--;
            }
        }
        return list;
    }
}
