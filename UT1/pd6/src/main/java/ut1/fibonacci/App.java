package ut1.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Fibonacci TOP-DOWN:" + fiboTopDown(12,0));
        System.out.println("Fibonacci BOTTOM-UP:" + fiboBottomUp(12));
    }

    public static Integer fiboTopDown(int n, int contador) {
        Map<Integer, Integer> memo = new HashMap<>();
        if (n <= 2) {
            memo.put(n, 1);
            return memo.get(n);

        } else {
            memo.put(n, fiboTopDown(n - 1,contador) + fiboTopDown(n - 2,contador));
            contador++;
            System.out.println("Cantidad de invocaciones:" + contador);
            return memo.get(n);
        }
    }
    public static Integer fiboBottomUp(int n) {
        if(n==0){
            return 0;
        } else {
            int fibAnterior = 0;
            int fibActual = 1;
            for(int i = 0;i<n-1;i++){
                int fibNuevo = fibActual+fibAnterior;
                fibAnterior=fibActual;
                fibActual=fibNuevo;
            }
            return fibActual;
        }
    }
}
