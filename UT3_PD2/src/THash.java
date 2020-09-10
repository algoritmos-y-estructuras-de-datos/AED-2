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
        while(tabla[hi] > 0){
            hi++;
            if(hi>=tamanioMax){
                hi = 0;
            }
            if(hi==ho){
                return acumuladorI;
            }
            this.acumuladorI++;
        }
        tabla[hi]=clave;
        this.promInserciones[0] += this.acumuladorI;
        return acumuladorI;
    }

    @Override
    public int buscar(int clave) {
        int tamanioMax = tamano-1;
        int contadorBusqueda = 1;
        int ho = this.funcionHashing(clave);
        int hi = ho;
        while(tabla[hi]>0){
            if(tabla[hi]==clave){
                this.promBusquedaSinExito[0]+= contadorBusqueda;
                return contadorBusqueda;
            }
            hi++;
            if(hi>+tamanioMax){
                hi=0;
            }
            if(hi==ho){
                this.promBusquedaSinExito[0]+= contadorBusqueda;
                return contadorBusqueda;
            }
            contadorBusqueda++;
        }
        this.promBusquedaSinExito[0]+=contadorBusqueda;
        return this.acumuladorBSE;
    }
    
}
