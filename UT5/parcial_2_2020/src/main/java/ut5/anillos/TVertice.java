package ut5.anillos;

import java.beans.Visibility;
import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice, IVerticeContagio {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int distanciaContacto = 0;
    private int numBp = 1;
    private int numBajo = Integer.MAX_VALUE;
    public int numBacon = 0; // ERA PRIVATE PERO LO HICE PUBLICO PARA VERLO

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
        // contadorEnlace = 0;
    }

    public void setNumBp(int newBp) {
        this.numBp = newBp;
    }

    public int getNumBp() {
        return this.numBp;
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

    public void listarContactos(Collection<TVertice> visitados, int maxSaltos) {
        this.setVisitado(true);
        for (TAdyacencia adyacentes : this.adyacentes) {
            if (!adyacentes.getDestino().getVisitado()) {
                adyacentes.getDestino().numBacon = this.numBacon + 1;
                if (adyacentes.getDestino().numBacon <= maxSaltos) {
                    visitados.add(adyacentes.getDestino());
                    adyacentes.getDestino().listarContactos(visitados, maxSaltos);
                }

            }
        }
    }

    public void anillosDeProbablesContagiados(HashMap<TVertice, Integer> visitados, int maxSaltos) {
        this.setVisitado(true);
        for (TAdyacencia adyacentes : this.adyacentes) {
            if (!adyacentes.getDestino().getVisitado()) {
                adyacentes.getDestino().numBacon = this.numBacon + 1;
                if (adyacentes.getDestino().numBacon <= maxSaltos) {
                    visitados.put(adyacentes.getDestino(), numBacon);
                    adyacentes.getDestino().anillosDeProbablesContagiados(visitados, maxSaltos);
                }

            }
        }
    }

    @Override
    public void puntosArt(Collection<TVertice> puntos, int[] cont) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean conectadoCon(TVertice destino) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                if (vertAdy.getEtiqueta().equals(destino.getEtiqueta())) {
                    return true;
                } else {
                    boolean tmp = adyacente.getDestino().conectadoCon(destino);
                    if (tmp)
                        return true;
                }

            }
        }
        return false;
    }

    @Override
    public void obtenerAnillos(TAnillosContagio losAnillos, int maxDistancia) {
        this.setVisitado(true);
        for (TAdyacencia adyacentes : this.adyacentes) {
            if (!adyacentes.getDestino().getVisitado()) {
                adyacentes.getDestino().numBacon = this.numBacon + 1;
                if (adyacentes.getDestino().numBacon <= maxDistancia) {
                    losAnillos.agregarContagio(numBacon, (String) adyacentes.getDestino().getEtiqueta());
                    adyacentes.getDestino().obtenerAnillos(losAnillos, maxDistancia);
                }

            }
        }
    }

    // #Referencia
    public void obtenerAnillosEntreDos(TAnillosContagio visitados, int minSaltos, int maxSaltos) {
        this.setVisitado(true);
        for (TAdyacencia adyacentes : this.adyacentes) {
            if (!adyacentes.getDestino().getVisitado()) {
                adyacentes.getDestino().numBacon = this.numBacon + 1;
                if (adyacentes.getDestino().numBacon <= maxSaltos && adyacentes.getDestino().numBacon > minSaltos) {
                    visitados.agregarContagio(numBacon, (String) adyacentes.getDestino().getEtiqueta());
                }
                adyacentes.getDestino().obtenerAnillosEntreDos(visitados, minSaltos, maxSaltos);

            }
        }
    }

}
