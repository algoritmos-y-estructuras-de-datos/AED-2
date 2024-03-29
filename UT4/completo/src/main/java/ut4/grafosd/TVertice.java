package ut4.grafosd;

import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    public int cfuerte;

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

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }

    public void bpf(Collection<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacentes : this.adyacentes) {
            TVertice destino = adyacentes.getDestino();
            if (!destino.getVisitado()) {
                destino.bpf(visitados);
            }
        }
    }

    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        this.setVisitado(true);
        camino.add(this.getEtiqueta());
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            if (!adyacencia.getDestino().getVisitado()) {

                if (adyacencia.getDestino().tieneCiclo(camino)) {
                    return true;
                }
            } else {
                if (camino.contains(adyacencia.getEtiqueta())) {
                    return true;
                }
            }
            camino.remove(adyacencia);
        }
        return false;
    }

    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
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

    public void unOrdenTopologico(LinkedList<TVertice> camino) {
        this.setVisitado(true);
        LinkedList<TAdyacencia> listaAdyacentes = this.getAdyacentes();
        if (listaAdyacentes.size() >= 0) {
            for (TAdyacencia ady : listaAdyacentes) {
                if (!ady.getDestino().getVisitado()) {
                    ady.getDestino().unOrdenTopologico(camino);
                }
            }
            camino.add(this);
        }
    }

    public void componentesFuertes(Collection<TVertice> visitados, int[] contador) {
        LinkedList<Comparable> todosVertices = new LinkedList<>();
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.componentesFuertes(visitados, contador);
            }
        }
        this.cfuerte = contador[0];
        contador[0]++;
    }

    public void bpfPostOrden(LinkedList<TVertice> visitados) {
        visitado = true;
        for (IAdyacencia adyacente : adyacentes) {
            if (!adyacente.getDestino().getVisitado()) {
                adyacente.getDestino().bpfPostOrden(visitados);
            }
        }
        visitados.addFirst(this);
    }

    public void caminoCritico(TCaminos caminos) {
        Double costoMaximo = 0.0;
        TCamino caminoCritico = null;
        for (TCamino camino : caminos.getCaminos()) {
            if (camino.getCostoTotal() > costoMaximo) {
                costoMaximo = camino.getCostoTotal();
                caminoCritico = camino;
            }
        }
        if (caminoCritico != null) {
            System.out.println("CAMINO CRÍTICO: '" + caminoCritico.imprimirEtiquetas()
                    + "'\nCOSTO TOTAL: " + caminoCritico.getCostoTotal());
        } else {
            System.out.println("ATENCIÓN: No existe un camino crítico.");
        }
        int i = 1;
        for (TCamino camino : caminos.getCaminos()) {
            if (camino != caminoCritico) {
                System.out.println("");
                System.out.println("CAMINO CON HOLGURA " + i + "\n" + camino.imprimirEtiquetas()
                        + "\nCOSTO DEL CAMINO HOLGADO: " + camino.getCostoTotal() + " - HOLGURA: "
                        + (caminoCritico.getCostoTotal() - camino.getCostoTotal()));
                i += 1;
            }
        }
    }

}
