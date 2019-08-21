package Grafos;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice implements IVertice{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Object datos;

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    @Override
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    @Override
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
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
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
    public Object getDatos() {
        return datos; 
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacentes : this.adyacentes) {
            if (!adyacentes.getDestino().getVisitado()) {
                adyacentes.getDestino().bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        setVisitado(true);  
        for (TAdyacencia adyacente : adyacentes) {
           TVertice vertAdy = adyacente.getDestino();
           if (!vertAdy.getVisitado()) {
               caminoPrevio.agregarAdyacencia(adyacente);
               if(vertAdy.getEtiqueta().equals(etVertDest)){                   
                   todosLosCaminos.getCaminos().add(caminoPrevio.copiar());
               }else {
                   adyacente.getDestino().todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
               }
               caminoPrevio.eliminarAdyacencia(adyacente);
           }
        }
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        this.setVisitado(true);
        for (TAdyacencia w : this.getAdyacentes()) {
            if (!w.getDestino().getVisitado()) {
                camino.agregarAdyacencia(w);
                if (w.getDestino().tieneCiclo(camino)){
                    return true;
                }
            } else {
                if (camino.tieneVertice(w.getDestino())) {
                    return true;
                }
            }
            camino.eliminarAdyacencia(w);
        }
        return false;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> C = new LinkedList<>();
        this.setVisitado(true);    
        C.add(this);
        visitados.add(this);
        
        while (!C.isEmpty()) {
            TVertice x = C.poll();            
            for (TAdyacencia y : x.adyacentes) {
                if (!y.getDestino().getVisitado()) {
                    y.getDestino().setVisitado(true);
                    C.add(y.getDestino());
                    visitados.add(y.getDestino());
                }
            }
        }        
    }

    @Override
    public String toString() {
        return etiqueta.toString();
    }

}
