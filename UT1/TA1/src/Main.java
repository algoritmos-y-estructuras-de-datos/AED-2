/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import static java.util.Arrays.binarySearch;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = new int[]{23, 43, 31, 12};
        int number = 12;
        Arrays.sort(list);
        System.out.printf("Binary Search %d in integer array %s %n", number, Arrays.toString(list));
        System.out.println("Location of the number: " + binarySearchRecursive(12, list, 0, list.length - 1));
        System.out.printf("Binary Search %d in integer array %s %n", 43, Arrays.toString(list));
        binarySearch(list, 43);
        list = new int[]{123, 243, 331, 1298};
        number = 331;
        Arrays.sort(list);
        System.out.printf("Binary Search %d in integer array %s %n", number, Arrays.toString(list));
        binarySearch(list, 331);
        System.out.printf("Binary Search %d in integer array %s %n", 331, Arrays.toString(list));
        binarySearch(list, 1333);
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
                System.out.printf(number + " found at location %d %n" + "Con una cantidad de comparaciones = " + comparaciones
                        + "\n", middle);
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
            if (first > last) {
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

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
