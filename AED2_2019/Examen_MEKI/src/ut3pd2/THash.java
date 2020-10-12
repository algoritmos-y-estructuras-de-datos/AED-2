/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd2;

/**
 *
 * @author Meki
 */
public class THash {
    //cantidad comparaciones promedio de todas las busquedas realizadas
 public int[] cantidadPromedioBusquedaExito;   
 public int[] cantidadPromedioBusquedaSinExito;   
 public int[] cantidadPromedioInserccionesExito;
    /**
     * Acumuladores para cada busqueda realizada. Sirve para saber cuantas comparaciones se realizan y se suman a la cantidad
     * promedio de busquedas tanto con exito o sin exito.
     */
 
 private int acumuladoresBusquedaExito;
 private int acumuladoresBusquedaSinExito;
 private int acumuladorInserccion;
 
 // Su utilidad es para saber la cantidad de comparaciones que se realizan al insertar.
 private int tamanio;
 
 /**
  * TABLA HASH
  */
 
 private int[] tabla;
 
 public THash(int tamanio){
     this.tamanio = tamanio;
     tabla = new int[tamanio];
     this.cantidadPromedioBusquedaExito = new int[1];
     this.cantidadPromedioBusquedaSinExito = new int[1];
     this.cantidadPromedioInserccionesExito = new int[1];
 }
 
 //Funcion de hash que devuelve la ubicacion de una determinada clave en la tabla hash.
 public int funcionHashing(int clave){
     return clave % tamanio;
 }
 
 /**
     * Metodo insertar de la tabla hash. Obtiene la ubicacion de la clave a insertar en la tabla, y si no hay colisiones
     * en la misma inserta, si las hay entonces sigue recorriendo hasta que encuentro un lugar libre. Si no encuentro lugar
     * libre la insercion es infructuosa. En todos los casos de devuelve como resultado la cantidad de comparaciones realizadas.
     * @param unaClave clave a insertar.
     * @return  cantidad de comparaciones realizadas
     */
 
    public int insertar(int clave) {
        this.acumuladorInserccion = 1;
        int Ho = this.funcionHashing(clave);
        int tamanioMax = tamanio - 1;
        int Hi = Ho;
        while (tabla[Hi] > 0) {
            Hi++;
            if (Hi >= tamanioMax) { //estoy en el final, debo pasar al inicio...
                Hi = 0;
            }
            if (Ho == Hi) { // ya di la vuelta entera..
                return acumuladorInserccion;
            }
            this.acumuladorInserccion++;
        }
        tabla[Hi] = clave;
        this.cantidadPromedioInserccionesExito[0] += this.acumuladorInserccion;

        return acumuladorInserccion;

    }
    
        public boolean insertarAux(int unaClave){
        this.acumuladorInserccion = 1;
        int Ho =this.funcionHashing(unaClave);   //Ho es el resultado de la funcion hashing..
        int tamañoMaximo = tamanio -1;
        int Hi = Ho;
        while(tabla[Hi] > 0){
            
            Hi++;            
            if( Hi >= tamañoMaximo){        //estoy en el final, debo pasar al inicio...
                Hi = 0;
            }   
            if( Ho == Hi){ // ya di la vuelta entera..
                return false; 
            }
            this.acumuladorInserccion++;
                     
        }
        //Si encontre un lugar vacio... inserto
       
        tabla[Hi] = unaClave;
        this.cantidadPromedioInserccionesExito[0]+= this.acumuladorInserccion;
        return true;
    }
        
    /**
     * Metodo buscar de la tabla hash. Obtiene la ubicacion de la clave a
     * insertar en la tabla y busca en esa ubicacion. Si el elemento se
     * encuentra en esa posicion simplemente devolvemos la cantidad de
     * comparaciones que se realizaron. En caso contrario se sigue recorriendo
     * posicion por posicion del array hasta encontrar el elemento o hasta dar
     * una vuelta entera a la tabla.
     *
     * @param unaClave clave a buscar
     * @return cantidad de comparaciones realizadas.
     */
    public int buscar(int unaClave) {
        int tamañoMaximo = tamanio - 1;
        int contadorBusqueda = 1;
        int Ho = this.funcionHashing(unaClave);
        int Hi = Ho;
        while (tabla[Hi] > 0) {

            if (tabla[Hi] == unaClave) {
                this.cantidadPromedioBusquedaExito[0] += contadorBusqueda;
                //System.out.println("Se encontro la clave : " + unaClave + " con un total de " + acumuladorBusquedaExito + " comparaciones.");
                return contadorBusqueda;
            }
            Hi++;
            if (Hi >= tamañoMaximo) {
                Hi = 0;
            }

            if (Hi == Ho) { //di la vuelta entera
                this.cantidadPromedioBusquedaSinExito[0] += contadorBusqueda;
                System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladoresBusquedaSinExito + " comparaciones.");
                return contadorBusqueda;
            }
            contadorBusqueda++;
        }
        // si encuentro un espacio vacio entonces la clave no se encuentra. Esto se debe a que cuando insertamos, si hay una colision
        // entonces seguimos recorriendo hasta encontrar un espacio vacio, NUNCA se saltea un espacio, por lo tanto es imposible que 
        // este despues de este espacio el elemento a buscar.

        this.cantidadPromedioBusquedaSinExito[0] += contadorBusqueda;
        //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");           
        return this.acumuladoresBusquedaSinExito;
    }
    
     /**
     * Metodo identico a buscar anterior pero devuelve true si se encuentra o falso en caso contrario
     * @param unaClave clave a buscar
     * @return true si se encuentra, falso en caso contrario
     */
    public boolean buscarAux (int unaClave){
        int tamañoMaximo = tamanio - 1;
        int contadorBusqueda = 1;
        int Ho = this.funcionHashing(unaClave);
        int Hi = Ho;
        while(tabla[Hi] > 0){
            
            if(tabla[Hi] == unaClave){
                this.cantidadPromedioBusquedaExito[0] += contadorBusqueda;
//                System.out.println("Se encontro la clave : " + unaClave + " con un total de " + acumuladorBusquedaExito + " comparaciones.");
                return true;
            }
            Hi++;
            if(Hi >= tamañoMaximo){
                Hi = 0;
            }
            
            if(Hi == Ho){ //di la vuelta entera
                this.cantidadPromedioBusquedaSinExito[0] += contadorBusqueda;
                //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");
                return false;
            }
            contadorBusqueda++;
            
        }
        // si encuentro un espacio vacio entonces la clave no se encuentra. Esto se debe a que cuando insertamos, si hay una colision
        // entonces seguimos recorriendo hasta encontrar un espacio vacio, NUNCA se saltea un espacio, por lo tanto es imposible que 
        // este despues de este espacio el elemento a buscar.
        
        this.cantidadPromedioBusquedaSinExito[0] += contadorBusqueda;
        //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");           
        return false;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamaño) {
        this.tamanio = tamaño;
    }
 
}    
     
    





