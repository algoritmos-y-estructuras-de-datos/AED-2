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
public class ShellSort {

    public void sort(int[] a) {
        int inner, outer, temp;
        int interval = 1;
        while (interval <= a.length / 3) {
            interval = interval * 3 + 1;
            while (interval > 0) {
                for (outer = interval; outer < a.length; outer++) {
                    temp = a[outer];
                    inner = outer;
                    while (inner > interval - 1 && a[inner - interval] >= temp) {
                        a[inner] = a[inner - interval];
                        inner -= interval;
                    }
                    a[inner] = temp;
                }

            }
            interval = (interval - 1) / 3;
        }
    }

}
