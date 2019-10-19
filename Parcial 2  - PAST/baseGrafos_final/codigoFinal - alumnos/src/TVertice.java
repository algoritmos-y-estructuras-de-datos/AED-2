
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TVertice implements IVertice{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Object datos;
    public int cfuerte;
    
    //datos para encontrar punto articulacion
    private int numero_bpf;
    private int bajo;
    
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
        for(TAdyacencia adyacencia: this.getAdyacentes()){
            TVertice destino = adyacencia.getDestino();
            if(!destino.getVisitado()){
                //System.out.println(adyacencia.getCosto());
                if(destino.getEtiqueta().compareTo(etVertDest) == 0){
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    //System.out.println(caminoPrevio.getCostoTotal() +"-"+adyacencia.getCosto());
                    copia.setCostoTotal(caminoPrevio.getCostoTotal()+adyacencia.getCosto());
                    
                    todosLosCaminos.getCaminos().add(copia);
                }else{
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
    public boolean tieneCiclo(TCamino camino) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                camino.agregarAdyacencia(adyacente);
                if(vertAdy.tieneCiclo(camino)){
                    //System.out.println(camino.imprimirEtiquetas());
                    return true;
                }
                camino.eliminarAdyacencia(adyacente);
                
            }else{
                return camino.existeVertice(vertAdy);
            }
        }
        return false;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        Deque<TVertice> porVisitar = new LinkedList<>();

        porVisitar.push(this);
        this.setVisitado(true);

        while (!porVisitar.isEmpty()) {
            TVertice v = porVisitar.pop();

            visitados.add(v);

            for (TAdyacencia a : v.getAdyacentes()) {
                TVertice destino = a.getDestino();
                if (!destino.getVisitado()) {
                    porVisitar.add(destino);
                    destino.setVisitado(true);
                }
            }
}
    }

   /*
    NUEVAS FUNCIONES
    */
    
    public void ordenTopologico(LinkedList<TVertice> camino) {
        this.setVisitado(true);
        for(TAdyacencia ady: this.getAdyacentes()){
            if(!ady.getDestino().getVisitado()){
                ady.getDestino().ordenTopologico(camino);
            }
        }
        camino.add(this);
        
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
     public void puntosDeArticulacion(List<TVertice> vertices, int[] num, Comparable padre) {
        this.numero_bpf = num[0];
        int bajoC = this.numero_bpf;
        int hijos = 0;
        this.visitado = true;

        boolean esArt = false;

        for (TAdyacencia adyacente : adyacentes) {
            TVertice destino = adyacente.getDestino();
            if (!destino.getVisitado()) {
                hijos += 1;
                num[0] = num[0]+1;
                destino.puntosDeArticulacion(vertices, num, this.getEtiqueta());
                if (destino.bajo < bajoC) {
                    bajoC = destino.bajo;
                }
                if (destino.bajo >= this.numero_bpf) {
                    esArt = true;
                }
            } else {
                if ((padre == null || destino.getEtiqueta().compareTo(padre) != 0) && destino.numero_bpf < bajoC) {
                        bajoC = destino.numero_bpf;
                }
            }
        }
        this.bajo = bajoC;

        if (this.numero_bpf == 1) {
            if (hijos > 1) {
                vertices.add(this);
            }
        } else {
            if (esArt) {
                vertices.add(this);
            }
        }
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
}
