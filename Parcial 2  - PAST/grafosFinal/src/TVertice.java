
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    public int bp;
    public int bajo;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
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
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
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
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                //System.out.println(adyacencia.getCosto());
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    //System.out.println(caminoPrevio.getCostoTotal() +"-"+adyacencia.getCosto());
                    copia.setCostoTotal(caminoPrevio.getCostoTotal() + adyacencia.getCosto());

                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    TCamino caminoPrevio2 = caminoPrevio.copiar();
                    caminoPrevio2.agregarAdyacencia(adyacencia);
                    //caminoPrevio2.setCostoTotal(caminoPrevio2.getCostoTotal()+adyacencia.getCosto());
                    //System.out.println("a"+caminoPrevio2.getCostoTotal());
                    destino.todosLosCaminos(etVertDest, caminoPrevio2, todosLosCaminos);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> C = new LinkedList<>();
        this.setVisitado(true);
        C.add(this);
        visitados.add(this);

        while (!C.isEmpty()) {
            TVertice x = C.poll();
            // for (TAdyacencia y :  x.getAdyacentes()) {
            for (TAdyacencia y : (List<TAdyacencia>) x.getAdyacentes()) {
                if (!y.getDestino().getVisitado()) {
                    y.getDestino().setVisitado(true);
                    C.add(y.getDestino());
                    visitados.add(y.getDestino());
                }
            }
        }
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
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        this.setVisitado(true);
        for (TAdyacencia ady : this.getAdyacentes()) {
            if (!this.getVisitado()) {
                camino.add(this.getEtiqueta());
                if (ady.getDestino().tieneCiclo(camino)) {
                    return true;
                }
                camino.remove(this.getEtiqueta());
            } else {
                if (camino.contains(this.getEtiqueta())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void obtenerArticulaciones(Collection<TVertice> verticesArt, int[] bp, int bpAnt, Collection<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);
        int hijos = 0;

        bp[0]++;
        this.bp = bp[0];
        this.bajo = bp[0];

        for (TAdyacencia adyacente : this.getAdyacentes()) {
            TVertice ady = adyacente.getDestino();
            if (!ady.getVisitado()) {
                hijos++;
                ady.obtenerArticulaciones(verticesArt, bp, this.bp, visitados);
                this.bajo = Math.min(ady.bajo, this.bp);
                // Punto de articulación. Descarto raíz
                if (ady.bajo >= this.bp && this.bp > 1) {
                    System.out.println("NO RAIZ: " + this.etiqueta + " " + this.bp + " " + this.bp);
                    verticesArt.add(this);
                }
            } else {
                // Evito visitar al padre
                if (!(ady.bp == bpAnt)) {
                    if (this.bajo > ady.bp) {
                        this.bajo = ady.bp;
                    }
                }
            }
        }
        // Agrego raíz a puntos de art.
        if (hijos > 1 && this.bp == 1) {
            System.out.println("RAIZ: " + this.etiqueta + " " + this.bp + " " + this.bp);
            verticesArt.add(this);
        }
    }

    public void ordenTopologico(LinkedList<TVertice> camino) {
        this.setVisitado(true);
        for (TAdyacencia ady : this.getAdyacentes()) {
            if (!ady.getDestino().getVisitado()) {
                ady.getDestino().ordenTopologico(camino);
            }
        }
        camino.add(this);

    }

}
