/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class THash implements IHash {
    int[] promBusquedaExito;
    int[] promBusquedaSinExito;
    int[] promInserciones;
    int acumuladorBE;
    int acumuladorBSE;
    int acumuladorI;
    int tamano;
    @Override
    public int funcionHashing(int clave) {
        return clave%tamano;
    }

    @Override
    public int insertar(int clave) {
        this.acumuladorI = 1;
        int ho = this.funcionHashing(clave);
        int tamanioMax = tamano-1;
        int hi = ho;
        int tabla[tamanioMax] = new tabla[];
        while(tabla[hi] > 0){
            
        }
    }
    
}
