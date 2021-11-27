package ut4.pd7;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Tarea datos;

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
    }

    public TVertice(Comparable unaEtiqueta, Tarea losdatos) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        datos = losdatos;
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

    public Tarea getDatos() {
        return datos;
    }

    

    /**
     * @param datos the datos to set
     */
    public void setDatos(Tarea datos) {
        this.datos = datos;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        setVisitado(true);
        camino.add(etiqueta);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice verticeAux = adyacente.getDestino();
            if (!verticeAux.getVisitado()) {
                if (verticeAux.tieneCiclo(camino)) {
                    return true;
                }
            } else {
                if (camino.contains(verticeAux.getEtiqueta())) {
                    return true;

                }
            }
        }
        setVisitado(false);
        return false;
    }

    void ordenParcial(LinkedList<Tarea> tareas) {
        this.setVisitado(true);
         LinkedList<TAdyacencia> listaAdyacentes = this.getAdyacentes();
         if (listaAdyacentes.size()>=0){
             for(TAdyacencia ady: listaAdyacentes){
                 if(!ady.getDestino().getVisitado()){
                     ady.getDestino().ordenParcial(tareas);
                 }
             }
             tareas.add(this.datos);
         }
     }

}
