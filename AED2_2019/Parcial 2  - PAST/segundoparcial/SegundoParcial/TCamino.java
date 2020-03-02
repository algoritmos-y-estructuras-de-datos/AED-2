/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import UT05.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class TCamino {
    private TVertice origen;
    public boolean critico;
    public LinkedList<TVertice> otrosVertices; // ATENCIÓN: PONER LA CLASE CONCRETA QUE
     // SEA MÁS APROPIADA
    public Double costoTotal;
    
    public TCamino(TVertice v){
        this.origen = v;
        this.otrosVertices = new LinkedList<TVertice>();
        this.costoTotal = 0.0;
        this.critico = false;
    }
    
    /*private void ImprimirEtiquetas(){ }; // IMPLEMENTAR
    private String ImprimirEtiquetas(){
        return null;
        }// IMPLEMENTAR*/
    
    public TVertice getOrigen(){
        return origen;
    }
    
    public LinkedList<TVertice> getOtrosVertices(){
        return otrosVertices;
    }
    
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal = costoTotal + ((Number)adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.add(adyacenciaActual.getDestino());
        }
        return false;
    }
    
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (otrosVertices.contains(adyacenciaActual.getDestino())) {
            costoTotal = costoTotal - ((Number)adyacenciaActual.getCosto()).doubleValue();
            return (otrosVertices.remove(adyacenciaActual.getDestino()));
        }
        return false;
    }
    private void setCosto(double unCosto){
        costoTotal = unCosto;
    }
    public TCamino copiar(){
        TCamino copia = new TCamino(origen);
        //copia.getOrigen().getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        return copia;
    }
    
}
