package SegundoParcial;

import UT05.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    public int num_bp;
    public int duracion;
    
    public int cfuerte;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta, int duracion) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        this.duracion=duracion;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    public TVertice primerAdyacente() {
        try{
            return this.adyacentes.getFirst().getDestino();
        }catch(NoSuchElementException e){
            System.out.println("No Elementos"+" "+this.getEtiqueta());
        }
        return null;
        
    }

    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    private TAdyacencia buscarAdyacencia(Comparable etiqueta) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiqueta) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public void bpf(Collection visitados) {
        this.setVisitado(true);
        visitados.add(this.getEtiqueta());
        TVertice w = this.primerAdyacente();
        while(w!=null){
            if(!w.getVisitado()){
                w.bpf(visitados);
            }
            w=this.siguienteAdyacente(w);
        }
    }
    
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for(TAdyacencia adyacencia : this.getAdyacentes()) {
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
        /*if(caminoPrevio.getOtrosVertices().size()>0){
            caminoPrevio.getOtrosVertices().removeLast();
        }*/
        
        this.setVisitado(false);
        return todosLosCaminos;
    }
    
    public boolean tieneCiclos(LinkedList<Comparable> camino){
        boolean esCiclo = false;
        this.setVisitado(true);
        camino.add(etiqueta);
        for(TAdyacencia ady: this.getAdyacentes()){
            if(camino.contains(ady.getEtiqueta())){
                return true;
            }
            esCiclo = ady.getDestino().tieneCiclos(camino);
        }
        if(camino.size()>0){
            camino.removeLast();
        }
        return esCiclo;
        
    }

    public void ordenTopologico(LinkedList<TVertice> camino) {
        this.setVisitado(true);
        for(TAdyacencia ady: this.getAdyacentes()){
            if(!ady.getDestino().getVisitado()){
                ady.getDestino().ordenTopologico(camino);
            }
        }
        camino.add(this);
        
    }
    
    public Double costoAunaAdy(Comparable etiquetaVertice){
        for(TAdyacencia ady : this.adyacentes){
            if(ady.getEtiqueta().equals(etiquetaVertice))
                return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }
     public Double costoAOtroVertice(LinkedList<Comparable> vertices, ArrayList<Double> D, Comparable etiquetaVertice){
        return D.get(vertices.indexOf(etiquetaVertice));
    }
     
     public void bpfVertices(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpfVertices(visitados);
            }
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

    void clasificarAristas(int[] numero, HashMap<Comparable, TArista>[] contenedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
