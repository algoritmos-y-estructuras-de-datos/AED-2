
import java.util.Random;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] result = ManejadorArchivosGenerico.leerArchivo("src/numeritos.csv", false);
        for (String res : result) {
            System.out.println(res + "\n");
        }
        int[] resultInt = StringToIntegerArray(result);

        binarySearch(resultInt, 99);

        if (binarySearchRecursive(99, resultInt, 0, resultInt.length - 1) != -1) {
            System.out.println("se encontró binary recursive");
        }

        linearSearch(resultInt, 99);
    }

    public static int[] StringToIntegerArray(String[] str) {
        int size = str.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    public static void binarySearch(int[] input, int number) {
        int first = 0;
        int last = input.length - 1;
        int middle = (first + last) / 2;
        int comparaciones = 0;
        while (first <= last) {
            if (input[middle] < number) {
                comparaciones++;
                first = middle + 1;
            } else if (input[middle] == number) {
                comparaciones++;
                System.out.printf(number + " found at location %d %n binaryIterative" + "Con una cantidad de comparaciones = " + comparaciones
                        + "\n", middle);
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
            if (first > last) {
                comparaciones++;
                System.out.println(number + " is not present in the list.\n" + "Con una cantidad de comparaciones = " + comparaciones);
            }
        }
    }

    public static int binarySearchRecursive(int search, int[] array, int start, int end) {

        int middle = (start + end) / 2;

        if (end < start) {
            return -1;
        }

        if (search < array[middle]) {
            return binarySearchRecursive(search, array, start, middle - 1);
        }

        if (search > array[middle]) {
            return binarySearchRecursive(search, array, middle + 1, end);
        }

        if (search == array[middle]) {
            return middle;
        }

        return -1;
    }

    public static void linearSearch(int[] arr, int key) {
        int comparaciones = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Se encontró en la posición " + i + " luego de " + comparaciones + " comparaciónes");
                break;
            }
            comparaciones++;
        }
        System.out.println("El número no se encuentra");;
    }
}
