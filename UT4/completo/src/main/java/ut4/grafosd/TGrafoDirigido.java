package ut4.grafosd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

    /*
     * Se agrega como atributo matriz predecesores y costos controlando mediante una
     * bandera si las matrices corresponden al grafo actual. Esto para evitar
     * utilizar metodos como floyd que presentan un orden cubico innecesariamente.
     */
    private int[][] predecesores;
    private int[][] costos;
    private boolean grafoActualizado;
    private Double[][] floyd;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    public int[][] getPred() {
        return this.predecesores;
    }

    public int[][] getCostos() {
        return this.costos;
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
    /**
     * Vertice que no esta excesivamente lejos de ninguna de las localizaciones Es
     * el vertice o conjunto de vertices que tienen la minima excentricidad
     * 
     * @return vertice centro del grafo
     */
    public Comparable centroDelGrafo() {
        Comparable aRetornar = Double.MAX_VALUE;

        for (Comparable etiquetaAux : vertices.keySet()) {
            if (obtenerExcentricidad(etiquetaAux).compareTo(aRetornar) < 0) {
                aRetornar = obtenerExcentricidad(etiquetaAux);
            }

        }
        return aRetornar;
    }

    // Esto lo modifiqué yo porque el nuestro es un culo, hay que ver porqué
    public Comparable centroDelGrafo2() {
        Double[][] floydTemp = this.floyd2();
        Comparable centro = 0.0;
        Comparable etiquetaCentro = "";
        Set<Comparable> etiquetas = this.vertices.keySet();
        Comparable[] arrayEtiquetas = new Comparable[floydTemp.length];
        arrayEtiquetas = etiquetas.toArray(arrayEtiquetas);
        Comparable[] excentricidades = new Comparable[floydTemp.length];
        for (int i = 0; i < arrayEtiquetas.length; i++) {
            Comparable exTemp = obtenerExcentricidad2(arrayEtiquetas[i]);
            excentricidades[i] = exTemp;
        }
        centro = excentricidades[0];
        etiquetaCentro = arrayEtiquetas[0];
        for (int i = 0; i < excentricidades.length; i++) {
            Comparable candidato = excentricidades[i];
            if (candidato.compareTo(centro) < 0) {
                centro = candidato;
                etiquetaCentro = arrayEtiquetas[i];
            }
        }
        return "Centro del grafo " + centro + " Etiqueta: " + etiquetaCentro;
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
                        this.predecesores[i][j] = k;
                    }
                }
            }
        }
        return matrizCos;
    }

    // Esto lo cambié yo porque el ejercicio de la pd1 me fallaba, tenemos que ver
    // porqué
    public Double[][] floyd2() {
        int tamano = vertices.size();
        Double[][] a = new Double[tamano][tamano];
        Double[][] p = new Double[tamano][tamano];
        Double[][] c = UtilGrafos.obtenerMatrizCostos(vertices);

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                p[i][j] = 0.0;
                a[i][j] = c[i][j];
            }
        }
        for (int k = 0; k < tamano; k++) {
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    if ((a[i][k] + a[k][j]) < a[i][j]) {
                        a[i][j] = a[i][k] + a[k][j];
                        p[i][j] = k + 0.0;

                    }
                }
            }
        }
        floyd = a;
        return a;
    }

    // Segunda obra maestra del badass
    @Override
    /**
     * Excentricidad de un vertice, es la distancia de este al vertice mas alejado
     * de si mismo El mayor de los caminos mas cortos partiendo desde un vertice
     * 
     * @return distancia al vertice mas lejano
     */
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double mayorValor = 0d;
        Double[][] matrizFloyd = floyd2();
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

    // Esto lo modifiqué yo porque el nuestro no funcionaba, hay que ver porqué
    public Comparable obtenerExcentricidad2(Comparable etiquetaVertice) {
        Double[][] floydTemp = this.floyd2();
        Set<Comparable> etiquetasDeVertices = this.vertices.keySet();
        Comparable[] array = new Comparable[floydTemp.length];
        array = etiquetasDeVertices.toArray(array);
        int numeroColumna = 0;
        for (int c = 0; c < array.length; c++) {

            if (array[c] == etiquetaVertice) {
                numeroColumna = c;
                break;
            }

        }
        Double excentricidad = 0.0;
        for (int i = 0; i < floyd.length; i++) {
            if (floyd[i][numeroColumna] > excentricidad) {
                if (floyd[i][numeroColumna] < Double.MAX_VALUE) {
                    if (floyd[i][numeroColumna] > 0.0) {

                        excentricidad = floyd[i][numeroColumna];
                    }

                }

            }
        }
        return excentricidad;
    }

    // Excentricidad colecciones
    // public Comparable obtenerExcentricidadColeccion(Comparable etiquetaVertice) {
    // Double[][] floydTemp = this.floyd();
    // Set<Comparable> etiquetasDeVertices = this.vertices.keySet();
    // Comparable[] array = new Comparable[floydTemp.length];
    // array = etiquetasDeVertices.toArray(array);
    // int numeroColumna = 0;
    // for (int c = 0; c < array.length; c++) {

    // if(array[c] == etiquetaVertice){
    // numeroColumna = c;
    // break;
    // }

    // }
    // Double excentricidad = 0.0;
    // for (int i = 0; i < floyd.length; i++) {
    // if(floyd[i][numeroColumna] > excentricidad){
    // if (floyd[i][numeroColumna] < Double.MAX_VALUE){
    // if (floyd[i][numeroColumna] > 0.0) {

    // excentricidad = floyd[i][numeroColumna];
    // }

    // }

    // }
    // }
    // return excentricidad;
    // }

    /**
     * Maximo de las excentricidades
     * 
     * @return
     */
    public Double diametro() {
        return null;
    }

    /**
     * Minimo de las excentricidades
     * 
     * @return
     */
    public Double radio() {
        return null;
    }

    /**
     * Cerradura transitiva de un grafo se define como el grafo que tiene un uno si
     * hay un camino entre vertice y vertice
     * 
     * @return
     */
    public boolean[][] cerraduraTransitiva() {
        Double[][] matrizCos = UtilGrafos.obtenerMatrizCostos(this.getVertices());
        boolean[][] Ctransitiva = new boolean[matrizCos.length][matrizCos.length];

        int i, j;
        for (i = 0; i < matrizCos.length; i++) {
            for (j = 0; j < matrizCos.length; j++) {
                if (matrizCos[i][j] != 0) {
                    Ctransitiva[i][j] = true;
                }
            }
        }
        return Ctransitiva;
    }

    @Override
    /**
     * El algoritmo de Warshall es un ejemplo de algoritmo booleano. A partir de una
     * tabla inicial compuesta de 0`s (no hay correspondencia inicial en el grafo) y
     * 1`s (hay una correspondencia, llamase “flecha”, entre nodos), obtiene una
     * nueva matriz denominada “Matriz de Clausura Transitiva” en la que se muestran
     * todas las posibles uniones entre nodos, directa o indirectamente. Es decir,
     * si de “A” a “B” no hay una “flecha”, es posible que si haya de “A” a “C” y
     * luego de “C” a “B”. Luego, este resultado se verá volcado en la matriz final.
     * 
     * Creo que esto mismo es la cerradura transitiva.
     */
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
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
        }
        return getVertices().containsKey(nombreVertice);
        // retur false;
    }

    /**
     * La busqueda en profunidad se trata de una busqueda que consiste en ir
     * expandiendo cada uno de los vertices de forma recursiva (de padre a hijo)
     * cuando ya no quedan nodos en ese camino regresa al predecesor se va
     * repitiendo con cada uno de los vecinos del nodo
     * 
     * @param vertice
     * @return
     */
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

    /*
     * Poscondicion orden topologica: Grafo incambiado, por eso hay que crear un
     * neuvo grafo con las aristas invertidas, esto ya esta en TArista. Luego en vez
     * de agregar en el principio como bpf, es agregarlos al final para la salida
     * topologica
     */
    public LinkedList<TVertice> unOrdenTopologico() {
        if (!tieneCiclo()) {
            this.desvisitarVertices();
            LinkedList<TVertice> camino = new LinkedList();
            for (TVertice v : vertices.values()) {
                if (!v.getVisitado()) {
                    v.unOrdenTopologico(camino);
                }
            }
            return camino;
        }
        System.out.println("Tiene ciclos");
        return null;
    }

    public void imprimirTopologico(LinkedList<TVertice> camino) {
        String oTopologico = "";
        if (camino != null) {
            for (TVertice v : camino) {
                oTopologico = v.getEtiqueta() + " - " + oTopologico;
            }
            System.out.println(oTopologico);
        }
    }

    public int devuelvePos(Comparable unaEtiqueta) {
        if (this.vertices.containsKey(unaEtiqueta)) {
            int pos = 0;
            for (TVertice verticeAux : this.vertices.values()) {
                if (verticeAux.getEtiqueta().compareTo(unaEtiqueta) == 0) {
                    return pos;
                }
                pos++;
            }
        }
        return -1;
    }

    public boolean hayContectividad(Comparable ciudadOrigen, Comparable ciudadDestino) {
        int posOrigen = devuelvePos(ciudadOrigen);
        int posDestino = devuelvePos(ciudadDestino);
        boolean[][] matrizWarshall = warshall();

        if (posOrigen != -1 && posDestino != -1) {
            return matrizWarshall[posOrigen][posDestino];
        }
        return false;
    }

    /**
     * Este algoritmo retorna true si el grafo es conexo o false en caso contrario
     * 
     * @return
     */
    public boolean esConexo() {
        for (TVertice a : this.vertices.values()) {
            Collection<TVertice> res = bpf(a.getEtiqueta());
            if (res.containsAll(this.vertices.keySet())) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<TVertice> componentesConexos() {
        // https://programmerclick.com/article/33691890301/
        throw new UnsupportedOperationException("No esta programada aún");
    }

    /**
     * Tremenda obra maestra, que en base a todos los caminos te dice si existe alguno de tamanio 1
     * Esto es analogo a tener un true en la matriz de warshallo
     * @param origen
     * @param destino
     * @return
     */
    public boolean hayConexion(Comparable origen, Comparable destino) {
        TCaminos caminolas = this.todosLosCaminos(origen, destino);
        for (TCamino camino : caminolas.getCaminos()) {
            if (camino.getOtrosVertices().size() != 1) {
                continue;
            }
            return true;
        }
        return false;
    }
}
