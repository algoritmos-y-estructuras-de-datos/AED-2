import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        // 1) Declarar un vector estático en el “main” con unas pocas (no más de 5)
        // claves enteras, desordenadas

        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        /*int[] cosoI = generador.generarDatosAleatorios(20);
        System.out.println("Desordenado INSERCION: " + Arrays.toString(cosoI));
        int[] cosoS = generador.generarDatosAleatorios(20);
        System.out.println("Desordenado SHELLSORT: " + Arrays.toString(cosoS));
        int[] cosoB = generador.generarDatosAleatorios(20);
        System.out.println("Desordenado BUBBLE: " + Arrays.toString(cosoB));
        // int[] cosoSC = generador.generarDatosAleatorios(20);
        int[] cosoSS = generador.generarDatosAleatorios(20);
        System.out.println("Desordenado SELECCION: " + Arrays.toString(cosoSS));*/
        int[] cosoSC = { 1, 2, 5, 7, 8, 1 };
        System.out.println("Desordenado CUENTA: " + Arrays.toString(cosoSC));
        System.out.println("---------------------------------------------------------------");

        // 2) Probar la ejecución del método “clasificar” del TClasificador, para
        // invocar el método Inserción Directa.
        /*
         * 3) Observar el resultado emitido por consola. 4) Encontrar y reparar los
         * eventuales errores en el método “OrdenarPorInsercion” 5) Volver a ejecutar, y
         * verificar el orden de la salida mediante la ejecución de un método
         * “estaOrdenado” que tome como parámetro el vector resultante de la ordenación.
         */
        TClasificador clasificador = new TClasificador();
        /*
         * // Selection // Encapsulado en cascara long t1 = System.nanoTime(); long
         * total = 0; int cantLlamadas = 0; while (total < 1) { cantLlamadas++;
         * clasificador.clasificar(cosoSS, 9); long t2 = System.nanoTime(); total = t2 -
         * t1; } long tiempoMedio = total/cantLlamadas; //Tiempo que lleva ejecutar el
         * algoritmo una vez //Ahora hay que descontar el tiempo de las cascaras
         * 
         * 
         * 
         * 
         * 
         * System.out.println("Ordenado SELECCION: " + Arrays.toString(cosoSS));
         * System.out.println("Valido ordenacion SELECCION: " +
         * clasificador.estaOrdenado(cosoSS));
         * 
         * clasificador.clasificar(cosoI, 1); System.out.println("Ordenado INSERCION: "
         * + Arrays.toString(cosoI)); System.out.println("Valido ordenacion INSERCION: "
         * + clasificador.estaOrdenado(cosoI)); // Shellsort
         * clasificador.clasificar(cosoS, 2); System.out.println("Ordenado SHELL: " +
         * Arrays.toString(cosoS)); System.out.println("Valido ordenacion SHELL: " +
         * clasificador.estaOrdenado(cosoS)); // Bubbble clasificador.clasificar(cosoB,
         * 3); System.out.println("Ordenado BUBBLE: " + Arrays.toString(cosoB));
         * System.out.println("Valido ordenacion BUBBLE: " +
         * clasificador.estaOrdenado(cosoB)); // Selection
         */
        int[] salida = clasificador.ordenarPorCuenta(cosoSC);
        clasificador.clasificar(cosoSC, 5);
        System.out.println("Ordenado CUENTA: " + Arrays.toString(salida));
        System.out.println("Valido ordenacion CUENTA: " + clasificador.estaOrdenado(cosoSC));
        /*
         * 6) Probar la ejecución con vectores con datos ascendentes, descendentes y
         * aleatorios. Desarrollar casos de test para verificar el correcto
         * funcionamiento. 7) ¿cuál es el tiempo de ejecución para cada tipo de vector
         * (tamaño y orden)? 8) Repetir los pasos 1 a 7 para los métodos Shellsort y
         * Burbuja. NOTA: SE SUGIERE UTILIZAR CONJUNTOS DE DATOS PEQUEÑOS PARA REALIZAR
         * LAS PRIMERAS PRUEBAS. DOCUMENTAR LO OBSERVADO EN CADA UNO DE LOS PUNTOS
         * INDICADOS EN UN DOCUMENTO Y SUBIRLO A LA TAREA CORRESPONDIENTE.
         */
    }
    /*
     * EJERCICIO 1 1) ¿cómo se genera un vector monótonamente ascendente? R: Se
     * comienza de la posición 0 del vector y mediante un contador en aumento se van
     * completando los datos hasta llegar al tamaño maximo 2) ¿cómo se genera un
     * vector monótonamente descendente? R: Se comienza de la posición 0 y se va
     * restando un contador al tamañno maximo hasta llegar al tamaño máximo definido
     * 3) ¿cómo se genera un vector con valores aleatorios? ¿pueden existir claves
     * repetidas? ¿cuál es el orden del tiempo de ejecución de este método? R: Se
     * van generando número y completando el array hasta llegar a tamaño máximo,
     * para controlar que no existan repetidos, se mantiene otro vector de booleans
     * donde se va completando con true, si el datos es efectivamente asignado al
     * vector con datos. Este metodo tiene un tiempo de ejecución O(N^2) puesto que
     * ambos loops deberán recorrer los vectores completamente. 4) ¿cuántos
     * elementos contiene el vector de datos generado?¿cómo se puede modificar esta
     * clase para que la cantidad de elementos del vector sea parametrizable? R:
     * 32000, ya es parametrizable. 5) ¿cómo podemos verificar que un conjunto está
     * ordenado? ¿cuál sería el orden del tiempo de ejecución de un algoritmo que lo
     * haga? R: Si se verifica que un elemento es mayor o menor que el primer
     * elemento del array dependiendo de si el orden es ascendente o desc, se puede
     * verificar que está ordenado y tendría como minimo O(N)
     */
}
