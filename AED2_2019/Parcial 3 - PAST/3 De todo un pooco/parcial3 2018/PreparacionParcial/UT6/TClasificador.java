/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author estudiante.fit
 */
public class TClasificador {
     
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_HEAP = 5;
    public static final int METODO_CLASIFICACION_SELECCION = 6;
    public static final int METODO_CLASIFICACION_BINSORT = 7;
    public static final int METODO_CLASIFICACION_CUENTA = 8;
    public static final int METODO_CLASIFICACION_RADIX = 9;
    public static final int METODO_CLASIFICACION_BINSORT_TRIVIAL = 10;
    public static final int METODO_CLASIFICACION_SHAKER = 11;


    /**
     * Punto de entrada al clasificador
     * 
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean ordenar) {
            switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                    return ordenarPorInsercion(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_SHELL:
                    return ordenarPorShell(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_BURBUJA:
                    return ordenarPorBurbuja(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_QUICKSORT:
                    //return ordenarPorQuickSort(0, datosParaClasificar.length-1, datosParaClasificar);
                quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, ordenar);
                return datosParaClasificar;
            case METODO_CLASIFICACION_HEAP:
                return ordenarPorHeapSort(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_SELECCION:
                return ordenarPorSeleccion(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_BINSORT:
                return ordenarPorBucketSort(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_CUENTA:
                return ordenarPorCuenta(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_RADIX:
                return ordenarPorRadixSort(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_BINSORT_TRIVIAL:
                return ordenarPorBinsortTrivial(datosParaClasificar, ordenar);
            case METODO_CLASIFICACION_SHAKER:
                return ordenarPorShaker(datosParaClasificar, ordenar);
            default:
                    System.err.println("Este codigo no deberia haberse ejecutado");
                    break;
            }
            return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
            int temp = vector[pos2];
            vector[pos2] = vector[pos1];
            vector[pos1] = temp;
    }


    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar,  boolean ordenar) {
        if(ordenar){
            int j;
            int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 2, 1 };
        
            for (int inc : incrementos) {
                    if (inc < (datosParaClasificar.length / 2)) {
                            for (int i = inc; i < datosParaClasificar.length; i++) {
                                    int aux = datosParaClasificar[i];
                                    j = i;
                                    while (j >= inc && aux < datosParaClasificar[j - inc]) {
                                        //intercambiar(datosParaClasificar, j, j + inc);
                                        datosParaClasificar[j] = datosParaClasificar[j - inc];
                                        j -= inc;                
                                    }
                                datosParaClasificar[j] = aux;
                            }
                    }
            }
            return datosParaClasificar;
        }
        return null;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar,  boolean ordenar) {
        if(ordenar){
            if (datosParaClasificar != null) {
                    for (int i = 1; i < datosParaClasificar.length; i++) {
                            int j = i - 1;
                            while ((j >= 0) && (datosParaClasificar[j] > datosParaClasificar[j+1])) {
                                    intercambiar(datosParaClasificar, j, j + 1);
                                    j--;
                            }
                    }
                    return datosParaClasificar;
            }
            return null;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar,  boolean ordenar) {
        if(ordenar){
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                    for (int j = n; j >= (i + 1); j--) {
                            if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                                    intercambiar(datosParaClasificar, j - 1, j);
                            }
                    }
            }
            return datosParaClasificar;
        }
        return null;
    }

    public boolean estaOrdenado(int[] vector){
        for(int i=0; i<vector.length-1; i++){
            if(vector[i] > vector[i+1]){
                return false;
            }
        }
        return true;
    }
/*
    int particionar(int izq, int der, int[] vector){
        int i = izq;
        int j = der;
        int pivote = vector[(i + j)/2];
        int aux;
            while (i <= j) {
                while (vector[i] < pivote){
                    i++;
                }
                while (vector[j] > pivote){
                    j--;
                }
                if (i <= j) {
                    aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                    i++; 
                    j--;
                }
            }
            return i;
    }
    
    private int[] ordenarPorQuickSort(int izq, int der, int[] vector) {
        int indice = particionar(izq, der, vector);
        if (izq < indice -1) {
            ordenarPorQuickSort(izq, indice - 1, vector);
        }
        if (indice < der ){
            ordenarPorQuickSort(indice, der, vector);
        }
        return vector;
    }
*/
    
    private int encuentraPivote(int izquierda, int derecha,int[] entrada){
        if(izquierda >= derecha){
            return -1;
        }
        return (entrada[izquierda]+entrada[derecha])/2;
    }
    
    private void quicksort(int[] entrada, int i, int j,  boolean ordenar) {
        if(ordenar){
            int izquierda = i;
            int derecha = j;

            int pivote = encuentraPivote(izquierda,derecha,entrada); 
            if (pivote >= 0){
                    while (izquierda <= derecha) {
                            while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                                    izquierda++; 
                            }

                            while ((pivote < entrada[derecha]) && (derecha > i)) {
                                    derecha--; 
                            }

                            if (izquierda <= derecha) {
                                    intercambiar(entrada, izquierda, derecha); 
                                    izquierda++;
                                    derecha--;
                            }
                    }

                    if (i < j){
                       quicksort(entrada, i, izquierda -1, ordenar); 
                       quicksort(entrada, izquierda, j, ordenar); 
                    }
            }
        }
    }
    
    protected int[] ordenarPorHeapSort(int[] datosParaClasificar, boolean ordenar) {
        if(ordenar){
            for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
                armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
            }
            for (int i = datosParaClasificar.length - 1; i  >= 1; i--) {
                    intercambiar(datosParaClasificar,0,i);
                    armaHeap(datosParaClasificar, 0, i-1);
            }
            return datosParaClasificar;
        }
        return null;
    }
    
    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                    if (ultimo == 2*r){ //r tiene un hijo solo
                                    if (datosParaClasificar[r] < datosParaClasificar[r*2]){
                                            intercambiar(datosParaClasificar, r, 2 * r);
                                    }
                                    r = ultimo;
                    } else { //r tiene 2 hijos
                            int posicionIntercambio = 0;
                            if (datosParaClasificar[2*r] < datosParaClasificar[2*r + 1]){
                                    posicionIntercambio = 2 * r +1;
                            } else {
                                    posicionIntercambio = 2 * r;
                            }
                            if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]){
                                    intercambiar(datosParaClasificar,r,posicionIntercambio);
                                    r = posicionIntercambio;
                            } else {
                                    r = ultimo;
                            }
                    }
            }			
        }
    }
    protected int[] ordenarPorSeleccion(int[] datosParaClasificar, boolean ordenar) {   
        if(ordenar){
            for (int i = 0; i < datosParaClasificar.length - 1; i++) {    
                int indiceMenor = i;    
                int claveMenor = datosParaClasificar[i];  
                for (int j = i + 1; j < datosParaClasificar.length; j++) {
                    if (datosParaClasificar[j] < claveMenor) {
                        indiceMenor = j;      
                        claveMenor = datosParaClasificar[j];    
                    }    
                }    
                intercambiar(datosParaClasificar, i, indiceMenor);  
            }   
        }
        return datosParaClasificar; 
    }
    
    int[] ordenarPorBucketSort(int[] datosParaClasificar, boolean ordenar) 
    { 
        if(ordenar){
            // 1) Create n empty buckets 
            ArrayList<LinkedList<Integer>> bins = new ArrayList<>(5);
            int[] maxmin = this.maxmin(datosParaClasificar);
            int max = maxmin[0];
            int min = maxmin[1];

            for(int i=0; i<=this.DMS_2(max, min);i++){
                bins.add(new LinkedList<>());
            }

            for (int d : datosParaClasificar) {
                bins.get(this.DMS_2(d, min)).add(d);
            }
            int j = 0;
            for (LinkedList<Integer> bin : bins) {
                int[] nums = new int[bin.size()];
                int i = 0;
                for (Integer m : bin) {
                    nums[i] = m;
                    i++;
                }
                nums = ordenarPorSeleccion(nums, true);
                for (int num : nums) {
                    datosParaClasificar[j] = num;
                    j++;
                }
            }
        }
        return datosParaClasificar;
        
    } 
    public int DMS_2(int x, int min) {
        String xx = String.valueOf(x);
        String yy = String.valueOf(min);
        String zeroes = new String(new char[yy.length()-1]).replace("\0", "0");
        String op = "1"+zeroes;
        int modul = Integer.valueOf(op);
        return x/modul;
      }
    public int[] maxmin(int[] datos){
        int[] array = new int[2];
        array[0]=Integer.MIN_VALUE;
        array[1]=Integer.MAX_VALUE;
        for(int n : datos){
            if(n>array[0]){
                array[0]=n;
            }
            if(n<array[1]){
                array[1]=n;
            }
        }
        return array;
    }
    
    private int[] ordenarPorCuenta(int[] datosParaClasificar, boolean ordenar) {
        if(ordenar){
            int[] maxmin = this.maxmin(datosParaClasificar);
            int max = maxmin[0];

            int[] cuenta = new int[max+1]; // Digitos del 0 al 99
            int[] salida = new int[datosParaClasificar.length];

            for (int j = 0; j < datosParaClasificar.length; j++) {
                cuenta[datosParaClasificar[j]]++;
            }
            for (int i = 1; i < cuenta.length; i++) {
                cuenta[i] += cuenta[i - 1];
            }
            int i;
            for (int j = datosParaClasificar.length - 1; j >= 0; j--) {
                i = cuenta[datosParaClasificar[j]];
                salida[i - 1] = datosParaClasificar[j];
                cuenta[datosParaClasificar[j]]--;
            }
            return salida;
        }
        return datosParaClasificar;
    }
    private int[] ordenarPorRadixSort(int[] datosParaClasificar, boolean ordenar) {

        LinkedList<Integer> datos = new LinkedList<>();
        for (int d : datosParaClasificar) {
            datos.addLast(d);
        }

        ArrayList<LinkedList<Integer>> urnas = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            urnas.add(new LinkedList<>());
        }

        for (int k = 1; k < 1000; k *= 10) { // Claves de 000 a 999 son 3 campos
            while (!datos.isEmpty()) {
                int R = datos.removeFirst();

                // Digito k-ésimo
                int kth = (R / k) % 10;

                urnas.get(kth).addLast(R);
            }

            for (LinkedList<Integer> urna : urnas) {
                datos.addAll(urna);
                urna.clear();
            }

        }

        int i = 0;
        while (!datos.isEmpty()) {
            datosParaClasificar[i] = datos.removeFirst();
            i++;
        }

        return datosParaClasificar;
    }
    private int[] ordenarPorBinsortTrivial(int[] datosParaClasificar, boolean ordenar) {
        for (int i = 0; i < datosParaClasificar.length; i++) {
            while (datosParaClasificar[i] != i) {
                intercambiar(datosParaClasificar, i, datosParaClasificar[i]);
            }
        }
        return datosParaClasificar;
    }
    

    private void armaHeapInv(int[] datos, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (2 * r + 1 <= ultimo) {
                if (ultimo == 2 * r + 1) {
                    if (datos[2 * r + 1] < datos[r]) {
                        intercambiar(datos, r, 2 * r + 1);
                    }
                    break;
                } else {
                    int izq = 2 * r + 1;
                    int der = 2 * r + 2;
                    int hijoMenor = datos[izq] < datos[der] ? izq : der;
                    if (datos[hijoMenor] < datos[r]) {
                        intercambiar(datos, r, hijoMenor);
                        r = hijoMenor;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    private int[] ordenarPorShaker(int[] datosParaClasificar, boolean ordenar) {
        if(ordenar){
            int Izq = 0;
            int Der = datosParaClasificar.length - 1;

            boolean intercambio;
            do {
                // Derecha a izquierda
                intercambio = false;
                for (int j = Der; j >= (Izq + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        intercambiar(datosParaClasificar, j - 1, j);
                        intercambio = true;
                    }
                }
                Izq++;
                if (!intercambio) {
                    break;
                }

                // Izquierda a derecha
                intercambio = false;
                for (int j = Izq; j <= Der - 1; j++) {
                    if (datosParaClasificar[j] > datosParaClasificar[j + 1]) {
                        intercambiar(datosParaClasificar, j + 1, j);
                        intercambio = true;
                    }
                }
                Der--;
            } while (intercambio);
        }
        return datosParaClasificar;

    }
    public static void main(String args[]) {
        
     }

}
