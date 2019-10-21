package preparacion2parcial;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
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

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                if (vertAdy.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacente);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacente);
                    vertAdy.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacente);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;

    }

    public void bea(Collection<TVertice> visitados) {
        this.setVisitado(true);
        LinkedList<TVertice> retorno = new LinkedList<>();
        visitados.add(this);
        retorno.add(this);
        while (!(retorno.isEmpty())) {
            TVertice aux = retorno.pop();
            LinkedList<TAdyacencia> adyacentes = aux.getAdyacentes();
            for (TAdyacencia ad : adyacentes) {
                TVertice destino = ad.getDestino();
                if (!destino.getVisitado()) {
                    destino.setVisitado(true);
                    visitados.add(destino);
                    retorno.add(destino);
                }
            }

        }
    }

    public void setNumBP(int numBP) {
        this.numBP = numBP;
    }

    public int getNumBP() {
        return this.numBP;
    }

    public int getNumBajo() {
        return this.numBajo;
    }

    public void setNumBajo(int numBajo) {
        this.numBajo = numBajo;
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

    public int numBacon1(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        Queue<TVertice> cola = new LinkedList<>();
        cola.add(this);
        if (etiqueta.equals("Kevin_Bacon")) {
            setBacon(0);
            return getBacon();
        }
        int numNuevo = 0;
        while (!cola.isEmpty()) {
            TVertice x = cola.remove();
            setBacon(numNuevo);
            for (TAdyacencia ady : (LinkedList<TAdyacencia>) x.adyacentes) {
                if (!ady.getDestino().visitado) {
                    ady.getDestino().setBacon(x.getBacon() + 1);
                    ady.getDestino().setVisitado(true);
                    visitados.add(ady.getDestino());
                    cola.add(ady.getDestino());
                    if (ady.getDestino().etiqueta.equals("Kevin_Bacon")) {
                        return ady.getDestino().getBacon();
                    }
                }
            }
            numNuevo += 1;
        }
        return -1;
    }
    
    
    public void beaBacon(Collection<TVertice> visitados) {
        this.setVisitado(true);
        LinkedList<TVertice> retorno = new LinkedList<>();
        retorno.add(this);
        while (!(retorno.isEmpty())) {
            TVertice aux = retorno.pop();
            LinkedList<TAdyacencia> adyacentes = aux.getAdyacentes();
            for (TAdyacencia ad : adyacentes) {
                TVertice destino = ad.getDestino();
                if (!destino.getVisitado()) {
                    destino.setVisitado(true);
                    destino.setBacon(aux.getBacon()+1);
                    visitados.add(destino);
                    retorno.add(destino);
                }
            }

        }
    }  
    public boolean tieneCiclo(TCamino camino) {
        this.setVisitado(true);
        LinkedList<TAdyacencia> lista = this.adyacentes;
        TAdyacencia destino = null;
        for(TAdyacencia adyacente : lista){
            destino = adyacente;
            if(!adyacente.getDestino().getVisitado()){
                camino.agregarAdyacencia(adyacente);
                
                return adyacente.getDestino().tieneCiclo(camino);
            }
            else{
                if(camino.getOtrosVertices().contains(adyacente.getEtiqueta())){
                    camino.agregarAdyacencia(adyacente);
                    return true;
                }
            }
        }
        this.setVisitado(false);
        if(destino!=null){
            camino.eliminarAdyacencia(destino);
        }
        return false;
    }
    
    public void ordenTopologico(LinkedList<TVertice> camino) {
        this.setVisitado(true);
        LinkedList<TAdyacencia> listaAdyacentes = this.getAdyacentes();
        if (listaAdyacentes.size()>=0){
            for(TAdyacencia ady: listaAdyacentes){
                if(!ady.getDestino().getVisitado()){
                    ady.getDestino().ordenTopologico(camino);
                }
            }
            camino.add(this);
        }
    }
    public void imprimirTopologico(LinkedList<TVertice> camino){
        String oTopologico = "";
        if(camino!=null){  
            for(TVertice v: camino){
                oTopologico = v.getEtiqueta() + " - " + oTopologico;
            }
            System.out.println(oTopologico);           
        }
    }
    
    public void ordenPreviaturas(){
        if (!this.getVisitado()){
            this.setVisitado(true);
            LinkedList<TAdyacencia> listaAdyacentes = this.getAdyacentes();
            if(listaAdyacentes!=null && listaAdyacentes.size()>0){
                System.out.println("Previas de "+this.getEtiqueta().toString().trim()+":");
                for(TAdyacencia a : listaAdyacentes){
                    if(a.getCosto()>0){
                        System.out.println("    ---> "+a.getDestino().getEtiqueta().toString().trim());
                    }else{
                        if(listaAdyacentes.size()<=1){
                            System.out.println("    ---> No tiene previas");
                        }
                    }
                }
                for(TAdyacencia a : listaAdyacentes){
                    if(a.getCosto()>0){
                        a.getDestino().ordenPreviaturas();
                    }
                }
            }
        }
    }
    
}
