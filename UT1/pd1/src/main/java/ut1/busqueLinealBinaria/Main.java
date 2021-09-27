package ut1.busqueLinealBinaria;

import java.util.Random;

public class Main {

    /**
     * Desarrollar, en lenguaje JAVA, programa que implemente los métodos de búsqueda lineal y 
búsqueda binaria sobre un vector de elementos con claves enteras, ordenado en forma 
ascendente. 
Estos métodos deberán recibir por parámetro el vector de valores (enteros) y el valor a buscar 
en dicho vector. 
Deberán indicarse, para cada algoritmo, la cantidad total de comparaciones realizadas.
En la sección de la UT1 de la webasignatura se encuentran dos ejemplos de colecciones de 
valores, en archivos de texto (un valor por línea) que pueden ser utilizados para comparar los 
métodos de búsqueda.
Se dese realizar una breve investigación sobre el comportamiento comparativo de estos 
métodos, indicando promedios de comparaciones para búsquedas exitosas y no exitosas.
Se sugiere para esto correr el programa una cierta cantidad de veces, para claves de búsqueda 
diferentes (éstas podrían ser generadas aleatoriamente – entre los rangos del conjunto de 
datos - y almacenadas en un vector auxiliar), y calcular entonces los promedios solicitados.
     */
    public static void main(String[] args) {
        String[] result = ManejadorArchivosGenerico.leerArchivo("UT1/pd1/numeritos.csv", false);
        // for (String res : result) {
        // System.out.println(res + "\n");
        // }
        int[] resultInt = StringToIntegerArray(result);

        //Busqueda exitosas
        binarySearch(resultInt, 99);
        if (binarySearchRecursive(99, resultInt, 0, resultInt.length - 1) != -1) {
            System.out.println('\n' + "Se encontró mediante la Busqueda Binaria Recursiva");
        }
        linearSearch(resultInt, 99);
        System.out.println("-------------------------------------------------------------------");
        //Busqueda no exitosas
        binarySearch(resultInt, 1199);
        if (binarySearchRecursive(1199, resultInt, 0, resultInt.length - 1) != -1) {
            System.out.println('\n' + "Se encontró mediante la Busqueda Binaria Recursiva");
        } else {
            System.out.println('\n' + "No se encontró mediante la Busqueda Binaria Recursiva");
        }
        linearSearch(resultInt, 1199);
        System.out.println("-------------------------------------------------------------------");
        //Busquedas exitosas
        for(Integer num : resultInt){
            binarySearch(resultInt, num);
            System.out.println('\n');
            linearSearch(resultInt, num);
        }
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
                System.out.printf("Busqueda Binaria Iterativa: " + number + " fue encontrado en la posición %d %n "
                        + " con una cantidad de comparaciones = " + comparaciones + " ", middle);
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
            if (first > last) {
                comparaciones++;
                System.out.println("Busqueda Binaria Iterativa: " + number + " is not present in the list.\n" + " con una cantidad de comparaciones = "
                        + comparaciones);
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
                System.out.println("Busqueda Lineal: Se encontró el número " + key +" en la posición " + i + " luego de " + comparaciones + " comparaciónes");
                break;
            } else {
                System.out.println("Busqueda Lineal: El número " + key +" no se encuentra con la comparación Nro: " + (comparaciones+1));
            }
            comparaciones++;

        }

    }
}
