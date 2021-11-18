package ut5.preparcial;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

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

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
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
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    // Encuentra el destino.
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }

            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> verticesVisitados) {
        this.setVisitado(true);
        verticesVisitados.add(this.getEtiqueta());
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            if (!adyacencia.getDestino().getVisitado()) {
                if (adyacencia.getDestino().tieneCiclo(verticesVisitados)) {
                    return true;
                }
            } else {
                if (verticesVisitados.contains(adyacencia.getEtiqueta())) {
                    return true;
                }
            }
            verticesVisitados.remove(adyacencia);
        }
        return false;
    }

    public void unOrdenTopologico(LinkedList<TVertice> camino) {
        this.setVisitado(true);
        for (TAdyacencia ady : this.getAdyacentes()) {
            if (!ady.getDestino().getVisitado()) {
                ady.getDestino().unOrdenTopologico(camino);
            }
        }
        camino.add(this);

    }

    public void bea(Collection<TVertice> visitados) {
        // this.setVisitado(true);
        // LinkedList<TVertice> retorno = new LinkedList<>();
        // visitados.add(this);
        // retorno.add(this);
        // while (!(retorno.isEmpty())) {
        // TVertice aux = retorno.removeFirst();
        // LinkedList<TAdyacencia> adyacentes = aux.getAdyacentes();
        // for (TAdyacencia ad : adyacentes) {
        // TVertice destino = ad.getDestino();
        // if (!destino.getVisitado()) {
        // destino.setVisitado(true);
        // visitados.add(destino);
        // retorno.add(destino);
        // }
        // }

        // }
        Deque<TVertice> porVisitar = new LinkedList<>();

        porVisitar.push(this);
        this.setVisitado(true);
        LinkedList<TAdyacencia> adyacentes;
        while (!porVisitar.isEmpty()) {
            TVertice v = porVisitar.pop();
            adyacentes = v.getAdyacentes();
            visitados.add(v);

            for (TAdyacencia a : adyacentes) {
                TVertice destino = a.getDestino();
                if (!destino.getVisitado()) {
                    porVisitar.add(destino);
                    destino.setVisitado(true);
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
                this.setNumBajo(Integer.min(this.getNumBajo(),
                        Integer.min(hijo.getNumBajo(), Integer.min(hijo.getNumBP(), this.getNumBP()))));
            }
            if (this.getNumBP() == 1 && contHijo >= 2 && !puntosArt.contains(this)) {
                puntosArt.add(this);
            } else if (this.getNumBP() != 1 && hijo.getNumBajo() >= this.getNumBP() && !puntosArt.contains(this)) {
                puntosArt.add(this);
            }
        }

    }
}
