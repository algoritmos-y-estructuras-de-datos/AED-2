
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static void binsort(int[] A) {
        List[] B = new LinkedList[9 + 1];
        Object item;
        for (int i = 0; i <= 9; i++) {
            B[i] = new LinkedList();
        }
        for (int i = 0; i < A.length; i++) {
            B[A[i]].add(new Integer(A[i]));
        }
        int pos = 0;
        for (int i = 0; i <= 9; i++) {
            for (B[i].moveToStart; (item = B[i].getValue()) != null; B[i].next()) {
                A[pos++] = (Integer) item;
            }
        }
    }
}

}
