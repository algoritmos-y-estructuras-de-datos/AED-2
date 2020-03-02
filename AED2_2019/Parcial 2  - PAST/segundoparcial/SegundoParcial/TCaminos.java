/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import UT05.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class TCaminos {
    private Collection<TCamino> caminos;
    
    public TCaminos(){
        caminos = new LinkedList<TCamino>();
    } // inicializar la colección de caminos (vacía)
    public void imprimir () {
        for(TCamino camino: caminos){
            String a = (String)camino.getOrigen().getEtiqueta();
            for(TVertice etiqueta: camino.getOtrosVertices()){
                a+="-"+ etiqueta.getEtiqueta();
            }
            if (camino.critico){
                System.out.println("Este es el Camino Crítico: ");
            }
            System.out.println(a);
            System.out.println("Costo: "+ camino.costoTotal);
        }
            
    } 
    
    public void agregarCamino(TCamino camino){
        if(!caminos.contains(camino)){
            caminos.add(camino);
        }
    }
    
    public Collection<TCamino> getCaminos(){
        return caminos;
    }
    
}
