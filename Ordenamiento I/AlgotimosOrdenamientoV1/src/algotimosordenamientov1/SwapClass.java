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
public class SwapClass {
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = j;
        a[j] = temp;
    }
}
