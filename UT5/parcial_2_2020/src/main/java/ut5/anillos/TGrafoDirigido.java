package ut5.anillos;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    private int[][] predecesores;


    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    public int[][] getPred(){
        return this.predecesores;
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
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
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
        }
        return getVertices().containsKey(nombreVertice);
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
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
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    @Override
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
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        // Desvisitar los vértices.
        desvisitarVertices();
        // Lista de vértices visitados.
        LinkedList<TVertice> visitados = new LinkedList<>();
        // Obtenemos el vértice a partir de la etiqueta del vértice dado.
        TVertice verticeAux = this.vertices.get(vertice.getEtiqueta());
        // Hacemos BPF y retornamos la lista de visitados.
        verticeAux.bpf(visitados);
        return visitados;
    }


    /**
     * BPF del grafo, a partir del primer vértice, para todos los vertices
     */
    @Override
    public Collection<TVertice> bpf() {
        Collection<TVertice> listaBpf = new LinkedList<>();

        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : vertices.values()) {
                if (!vertV.getVisitado()) {
                    vertV.bpf(listaBpf);
                }
            }
        }
        return listaBpf;
    }

    //Bpf a partir de una etiqueta dada
    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        TVertice verticeAux = vertices.get(etiquetaOrigen);
        verticeAux.bpf(visitados);
        return visitados;
    }

     /**
     *
     */
    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    @Override
    // Devuelve la etiqueta del vertice que es centro del grafo.
    public Comparable centroDelGrafo() {
        Comparable aRetornar = Double.MAX_VALUE;
        Comparable etiquetaCentro = "";

        for (Comparable etiquetaAux : vertices.keySet()) {
            if (obtenerExcentricidad(etiquetaAux).compareTo(aRetornar) < 0) {
                aRetornar = obtenerExcentricidad(etiquetaAux);
                etiquetaCentro = etiquetaAux;
            }
        }
        return etiquetaCentro;
    }

    @Override
    public Double[][] floyd() {

        Double[][] matrizCos = UtilGrafos.obtenerMatrizCostos(this.getVertices());
        this.predecesores = new int[matrizCos.length][matrizCos.length];

        int i, j, k;

        for (k = 0; k < matrizCos.length; k++) {
            for (i = 0; i < matrizCos.length; i++) {
                for (j = 0; j < matrizCos.length; j++) {
                    if (matrizCos[i][k] + matrizCos[k][j] < matrizCos[i][j]) {
                        matrizCos[i][j] = matrizCos[i][k] + matrizCos[k][j];
                        predecesores[i][j] = k;
                    }
                }
            }
        }
        return matrizCos;
    }

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
        Double[][] A = UtilGrafos.obtenerMatrizCostos(vertices);
        boolean[][] B = new boolean[vertices.size()][vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                B[i][j] = (A[i][j] != Double.MAX_VALUE);
            }
        }

        for (int k = 0; k < vertices.size(); k++) {
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    if (!B[i][j]) {
                        B[i][j] = B[i][k] && B[k][j];
                    }
                }
            }
        }
        return B;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = null;
        TVertice v = buscarVertice(etiquetaOrigen);
        if (v != null) {
            todosLosCaminos = new TCaminos();
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos); 
        }
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
        boolean res = false;
        for (TVertice verticeAux : this.vertices.values()) {
            LinkedList<Comparable> caminos = new LinkedList<>();
            res = verticeAux.tieneCiclo(caminos);
            if (res) {
                return res;
            }
        }
        return res;
    }

    @Override
    public LinkedList<TVertice> unOrdenTopologico(){
        if(!this.tieneCiclo()){
            this.desvisitarVertices();
            LinkedList<TVertice> camino = new LinkedList();
            for(TVertice v: vertices.values()){
                if(!v.getVisitado()){
                    v.unOrdenTopologico(camino);
                }
            }
            return camino;
        }
        System.out.println("Tiene ciclos");
        return null;
    }
    
    public void imprimirTopologico(LinkedList<TVertice> camino){
        String oTopologico = "";
        if(camino!=null){
            
        for(TVertice v: camino){
            oTopologico = v.getEtiqueta() + oTopologico;
        }
        System.out.println(oTopologico);            
        }
    }

    
}
