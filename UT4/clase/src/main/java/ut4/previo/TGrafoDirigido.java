package ut4.previo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En caso
     * de no existir la adyacencia, retorna falso. En caso de que las etiquetas sean
     * invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     *         contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto costo),
     * dado su vertice origen y destino.- Para que la arista sea valida, se deben
     * cumplir los siguientes casos: 1) Las etiquetas pasadas por parametros son
     * v�lidas.- 2) Los vertices (origen y destino) existen dentro del grafo.- 3) No
     * es posible ingresar una arista ya existente (miso origen y mismo destino,
     * aunque el costo sea diferente).- 4) El costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta especificada
     * como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }



    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Comparable aRetornar = Double.MAX_VALUE;

        for (Comparable etiquetaAux : vertices.keySet()){
           if(obtenerExcentricidad(etiquetaAux).compareTo(aRetornar) < 0){
                aRetornar = obtenerExcentricidad(etiquetaAux);
           }

        }
        return aRetornar;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizCos = UtilGrafos.obtenerMatrizCostos(this.getVertices());
        int i, j, k;

        for (k = 0; k < matrizCos.length; k++) {
            for (i = 0; i < matrizCos.length; i++) {
                for (j = 0; j < matrizCos.length; j++) {
                    if (matrizCos[i][k] + matrizCos[k][j] < matrizCos[i][j]) {
                        matrizCos[i][j] = matrizCos[i][k] + matrizCos[k][j];
                    }
                }
            }
        }
        return matrizCos;
    }

    //Segunda obra maestra del badass
    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double mayorValor = 0d;
        Double[][] matrizFloyd = floyd();
        Object[] etiquetas = vertices.keySet().toArray();
        int j, col;

        for (col = 0; col < etiquetas.length; col++) {
            if (etiquetas[col].equals(etiquetaVertice)) {
                for (j = 0; j < etiquetas.length; j++) {
                    if (matrizFloyd[j][col] > mayorValor) {
                        mayorValor = matrizFloyd[j][col];
                    }
                }
            }
        }
        
        return mayorValor;
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
        }
        return getVertices().containsKey(nombreVertice);
        // retur false;
    }

    public Collection<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        TVertice verticeAux = vertices.get(vertice.getEtiqueta());
        verticeAux.bpf(visitados);
        return visitados;
    }

    public void desvisitarVertices() {
        for (TVertice verticeAux : vertices.values()) {
            verticeAux.setVisitado(false);
        }
    }

    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        TVertice verticeAux = vertices.get(etiquetaOrigen);
        verticeAux.bpf(visitados);
        return visitados;
    }

    public Collection<TVertice> bpf() {
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

}
