/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author estudiante.fit
 */
public class GeneradorDatosGenericos {
    private static int TAMANIO_MAX = 300;
    public GeneradorDatosGenericos(){
    }
    public GeneradorDatosGenericos(int cant){
        TAMANIO_MAX=cant;
    }
    public void setTamanioMax(int num){
        TAMANIO_MAX=num;
    }
    public Comparable[] generarDatosAleatorios() {
        Random rnd = new Random();
        Comparable[] datosGenerados = new Comparable[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        for (int i = 0; i < datosGenerados.length; i++) {
                int j = rnd.nextInt(TAMANIO_MAX);
                while(datosUtilizados[j]){
                        j = (j + 1) % TAMANIO_MAX;
                }
                datosGenerados[j] = i;
                datosUtilizados[j] = true;
        }
        return datosGenerados;
    }
	
    public int[] generarDatosAscendentes() {
            int [] copiaAscendente = new int[TAMANIO_MAX];
            for (int i = 0; i < TAMANIO_MAX; i++) {
                    copiaAscendente[i] = i;
            }
            return copiaAscendente;
    }
	
    public int[] generarDatosDescendentes() {
            int [] copiaDescendente = new int[TAMANIO_MAX];
            for (int i = 0; i < TAMANIO_MAX; i++) {
                    copiaDescendente[i] = TAMANIO_MAX - i;
            }
            return copiaDescendente;
    }   
}
