/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
     
    
    public static final int METODO_CLASIFICACION_QUICKSORT = 1;
    public static final int METODO_CLASIFICACION_HEAP = 2;


    /**
     * Punto de entrada al clasificador
     * 
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
     */
    public Comparable[] clasificar(Comparable[] datosParaClasificar, int metodoClasificacion, boolean ordenar) {
            switch (metodoClasificacion) {
            case METODO_CLASIFICACION_HEAP:
                return ordenarPorHeapSort(datosParaClasificar, ordenar);
            
            default:
                    System.err.println("Este codigo no deberia haberse ejecutado");
                    break;
            }
            return datosParaClasificar;
    }

    private void intercambiar(Comparable[] vector, int pos1, int pos2) {
            Comparable temp = vector[pos2];
            vector[pos2] = vector[pos1];
            vector[pos1] = temp;
    }


    

    public boolean estaOrdenado(int[] vector){
        for(int i=0; i<vector.length-1; i++){
            if(vector[i] > vector[i+1]){
                return false;
            }
        }
        return true;
    }

    
    
    protected Comparable[] ordenarPorHeapSort(Comparable[] datosParaClasificar, boolean ordenar) {
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
    
    private void armaHeap(Comparable[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo){
            int r = primero;
            while(r <= ultimo / 2){
                    if (ultimo == 2*r){ //r tiene un hijo solo
                                    if (datosParaClasificar[r].compareTo(datosParaClasificar[r*2])<0){
                                            intercambiar(datosParaClasificar, r, 2 * r);
                                    }
                                    r = ultimo;
                    } else { //r tiene 2 hijos
                            int posicionIntercambio = 0;
                            if (datosParaClasificar[2*r].compareTo(datosParaClasificar[2*r + 1]) > 0){
                                    posicionIntercambio = 2 * r +1;
                            } else {
                                    posicionIntercambio = 2 * r;
                            }
                            if (datosParaClasificar[r].compareTo(datosParaClasificar[posicionIntercambio])  > 0){
                                    intercambiar(datosParaClasificar,r,posicionIntercambio);
                                    r = posicionIntercambio;
                            } else {
                                    r = ultimo;
                            }
                    }
            }			
        }
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
    
    
    /*private int[] ordenarPorHeapInv(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) {
            armaHeapInv(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeapInv(datosParaClasificar, 0, i - 1);
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
    }*/
    public static TProduct buscarLinkedList(LinkedList<TProduct> lista, String cod){
        for(TProduct p : lista){
            if(p.getID().equals(cod)){
                return p;
            }
        }
        return null;
    }
    public static void main(String args[]) {
        
     }

}
