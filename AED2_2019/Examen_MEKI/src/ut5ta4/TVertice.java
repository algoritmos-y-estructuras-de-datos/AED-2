/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta4;

/**
 *
 * @author Meki
 */
 

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private Object datosDuracion;
    private int bacon = Integer.MAX_VALUE;
    private int numBP = 1;
    private int numBajo = Integer.MAX_VALUE;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        datos = null;
        datosDuracion = null;
    }
      public TVertice(String verticeString, int duracion) {
        etiqueta = verticeString;
        datosDuracion = duracion;    
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public int getBacon() {
        return bacon;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public Object getDatosDuracion() {
        return datosDuracion;
    }

    public void setDatosDuracion(Object datosDuracion) {
        this.datosDuracion = datosDuracion;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }


    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public T getDatos() {
        return datos;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    
    
     public void bpf(Collection<Comparable> visitados) {
        setVisitado(true);
        visitados.add(this.getEtiqueta());
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }
    
     public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                if(vertAdy.getEtiqueta().compareTo(etVertDest)==0){
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacente);
                    todosLosCaminos.getCaminos().add(copia);
                }
                else{
                    caminoPrevio.agregarAdyacencia(adyacente);
                    vertAdy.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacente);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
        
    }
//
//    public void bea(Collection<TVertice> etiquetas) {
//         this.setVisitado(true);
//        LinkedList<TVertice> retorno = new LinkedList<>();
//        etiquetas.add(this);
//        retorno.add(this);
//        while (!(retorno.isEmpty())) {
//            TVertice aux = retorno.pop();
//            LinkedList<TAdyacencia> adyacentes = aux.getAdyacentes();
//            for (TAdyacencia ad : adyacentes) {
//                TVertice destino = ad.getDestino();
//                if (!destino.getVisitado()) {
//                    destino.setVisitado(true);
//                    etiquetas.add(destino);
//                    retorno.add(destino);
//                }
//            }
//
//        }
//    }
    public void setNumBajo(int numBajo) {
        this.numBajo = numBajo;
    }
    
     public int getNumBP() {
        return this.numBP;
    }

    public int getNumBajo() {
        return this.numBajo;
    }
    
      public void setNumBP(int numBP) {
        this.numBP = numBP;
    }
    
    public void numerarBP(LinkedList<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);
//         getAdyacentes().forEach((adyacencia) -> {
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice hijo = adyacencia.getDestino();
            if (!hijo.getVisitado()) {
                hijo.setNumBP(visitados.getLast().getNumBP() + 1);
                hijo.setNumBajo(visitados.getLast().getNumBajo() + 1);
                hijo.numerarBP(visitados);

            }
        }

    }

     
     
         public void puntosArticulacion(TVertice padre, LinkedList<TVertice> puntosArt) {
        setVisitado(true);
        int contHijo = 0;
        for (TAdyacencia tAdyacencia : getAdyacentes()) {
            TVertice hijo = tAdyacencia.getDestino();
            if (!hijo.getVisitado()) {
                hijo.puntosArticulacion(this, puntosArt);
                contHijo++;
            }
            if (hijo != padre && hijo.getVisitado()) {
                this.setNumBajo(Integer.min(this.getNumBajo(), Integer.min(hijo.getNumBajo(), Integer.min(hijo.getNumBP(), this.getNumBP()))));
            }
            if (this.getNumBP() == 1 && contHijo >= 2 && !puntosArt.contains(this)) {
                puntosArt.add(this);
            } else if (this.getNumBP() != 1 && hijo.getNumBajo() >= this.getNumBP() && !puntosArt.contains(this)) {
                puntosArt.add(this);
            }
        }

    }

    }