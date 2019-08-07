
import java.util.Collection;
import java.util.LinkedList;

public class TVertice implements IVertice, IVerticeKevinBacon {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private int numBacon = 0;
    private Object datos;

    public int getNumBacon() {
        return numBacon;
    }

    /**
     * @param numBacon the numBacon to set
     */
    public void setNumBacon(int numBacon) {
        this.numBacon = numBacon;
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void listarContactos(Collection<TVertice> visitados, int maxSaltos) {
        this.setVisitado(true);
        visitados.add(this);
        this.numBacon++;
        for (TAdyacencia adyacentes : this.adyacentes) {
            if (!adyacentes.getDestino().getVisitado()) {
                adyacentes.getDestino().numBacon=this.numBacon;
                visitados.add(adyacentes.getDestino());
                if (adyacentes.getDestino().getNumBacon() < maxSaltos){
                adyacentes.getDestino().listarContactos(visitados, maxSaltos);}
            }
        }
    }

    
   
    
}
