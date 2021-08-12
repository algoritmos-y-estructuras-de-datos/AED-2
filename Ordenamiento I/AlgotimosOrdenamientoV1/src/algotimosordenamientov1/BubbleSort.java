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
public class BubbleSort {
    public void sort(int[] a){
        for(int i = 0; i<a.length;i++){
            for(int j = 1;j<a.length;j++){
                if(a[i]<a[j-1]){
                    SwapClass.swap(a, j, j-1);
                }
            }
        }
    }
}
