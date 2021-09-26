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
public class InsertionSort {
    public void sort(int[] a){
        for(int i = 1;i<a.length;i++){
            //int buffer = a[i];
            for(int j = i;j>0;j--){
                if(a[i]<a[i-1]){
                    SwapClass.swap(a, i, j-1);
                }
            }
        } 
    }
}
