package ut4.grafosd;

import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author diego maradona
 */
public class TCaminos implements ICaminos{
    
    private Collection<TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }
    
    public String imprimirCaminos(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append(camino.imprimirEtiquetas()+"\n");
        }
        return sb.toString();
    }

    public void imprimirCaminosConsola(){
        System.out.println(imprimirCaminos());
    }

    public Collection<TCamino> getCaminos() {
        return caminos;
    }




    /*

     IMPLEMENTAR CAMINO MENOR Y MAYOR COSTO CON COLLECTIONS


    */
    @Override
    public TCamino caminoMayorCosto(){
        TCamino mayorCostoCamino = null;
        double mayorCosto = 0;
        for(TCamino caminoAux : this.caminos){
            if(caminoAux.getCostoTotal() > mayorCosto){
                mayorCostoCamino = caminoAux;
                mayorCosto = caminoAux.getCostoTotal();
            }
        }       
        return mayorCostoCamino;
    }

    
    @Override
    public TCamino caminoMenorCosto(){
        TCamino menorCostoCamino = null;
        double menorCosto = Double.MAX_VALUE;
        for(TCamino caminoAux : this.caminos){
            if(caminoAux.getCostoTotal() < menorCosto){
                menorCostoCamino = caminoAux;
                menorCosto = caminoAux.getCostoTotal();
            }
        }
        return menorCostoCamino;
    }
        
}
