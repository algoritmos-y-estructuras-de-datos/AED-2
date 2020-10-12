/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta4;

import ut5ta3.*;
import ut5pd1.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
class TCamino implements ICamino{
    
    private final TVertice origen;
    private Collection<Comparable> otrosVertices;
    private Double costoTotal = 0.0d;
    
    public TCamino(TVertice v){
        this.origen = v;
        this.otrosVertices = new LinkedList();
                
        }
    
    public void imprimirEtiquetasConsola(){
        System.out.println(imprimirEtiquetas());
    }
    
    
    @Override
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            setCostoTotal((Double) getCostoTotal() + ((Number) adyacenciaActual.getCosto()).doubleValue());
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }
    
    @Override
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
       if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            setCostoTotal((Double) getCostoTotal() - ((Number) adyacenciaActual.getCosto()).doubleValue());
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public TVertice getOrigen() {
        return origen;
    }

    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    public void setOtrosVertices(Collection<Comparable> otrosVertices) {
        this.otrosVertices = otrosVertices;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public TCamino copiar() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCostoTotal(this.costoTotal);
        return copia;
    }

   
    @Override
    public String imprimirEtiquetas() {
        StringBuffer resultado = new StringBuffer(this.getOrigen().getEtiqueta().toString()+"-");
        otrosVertices.forEach((vertice) -> {resultado.append(vertice.toString()+"-");});
        resultado.append(" COSTO TOTAL: "+costoTotal.toString());
        return resultado.toString();
    }
}
