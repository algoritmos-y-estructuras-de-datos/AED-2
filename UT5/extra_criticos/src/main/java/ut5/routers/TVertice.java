package ut5.routers;

import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private TVertice predecesor;
    public Integer numBp = 0;
    public Integer numBajo = 0;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public Integer getNumBP(){
        return numBp;
    }

    public Integer getNumBajo(){
        return numBajo;
    }

    public void setNumBajo(Integer numBajo){
        this.numBajo = numBajo;
    }

    public void getNumBP(Integer numBp){
        this.numBp = numBp;
    }

    /**
     * @return the predecesor
     */
    public TVertice getPredecesor() {
        return predecesor;
    }

    /**
     * @param predecesor the predecesor to set
     */
    public void setPredecesor(TVertice predecesor) {
        this.predecesor = predecesor;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
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

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    public void numerarBP(LinkedList<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);
        getAdyacentes().forEach((adyacencia) -> {
            TVertice hijo = adyacencia.getDestino();
            if (!hijo.getVisitado()) {
                hijo.setNumBP(visitados.getLast().getNumBP() + 1);
                hijo.setNumBajo(visitados.getLast().getNumBajo() + 1);
                hijo.numerarBP(visitados);

            }
        });
    }

    private void setNumBP(int nuevoBp) {
        this.numBp = nuevoBp;
    }

    public void routersCriticos(TVertice padre, LinkedList<TVertice> puntosArt) {
        setVisitado(true);
        int contHijo = 0;
        for (TAdyacencia tAdyacencia : getAdyacentes()) {
            TVertice hijo = tAdyacencia.getDestino();
            if (!hijo.getVisitado()) {
                hijo.routersCriticos(this, puntosArt);
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

    public void puntoArticulacion(LinkedList<TVertice> puntos, int[] cont) {
        cont[0]++;
        this.setVisitado(true);
        this.numBp = cont[0];
        this.numBajo = cont[0];
        LinkedList<TVertice> hijos = new LinkedList<>();
        for (TAdyacencia adyAux : this.adyacentes) {
            TVertice adyacente = adyAux.getDestino();
            if (!adyacente.visitado) {
                adyacente.puntoArticulacion(puntos, cont);
                hijos.add(adyacente);
                this.numBajo = Math.min(this.numBajo, adyacente.numBajo);
            } else {
                this.numBajo = Math.min(this.numBajo, adyacente.numBp);
            }
        }
        if (this.numBp > 1) {
            for (TVertice hijo : hijos) {
                if (hijo.numBajo >= this.numBp) {
                    puntos.add(this);
                }
            }
        } else if (hijos.size() > 1) {
            puntos.add(this);
        }
    }


    
}
