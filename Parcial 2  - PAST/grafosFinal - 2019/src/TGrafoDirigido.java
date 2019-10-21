
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    protected TAristas aristas;

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
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
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
            return getVertices().containsKey(nombreVertice);
        }
        return false;
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
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                //getLasAristas().add(arista);
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

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
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
        if (vertice == null || vertice.getVisitado()) {
            return new LinkedList<>();
        }
        vertice = vertices.get(vertice.getEtiqueta());
        Collection<TVertice> col = new LinkedList<>();
        if (vertice != null) {
            vertice.bpf(col);
        }
        return col;
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        ArrayList<Comparable> formando = new ArrayList<>(camino.getOtrosVertices().size() + 1);
        formando.add(camino.getOrigen().getEtiqueta());
        for (Comparable vertice : camino.getOtrosVertices()) {
            if (formando.contains(vertice)) {
                return true;
            }
            formando.add(vertice);
        }
        return false;
    }

    @Override
    public Collection<TVertice> bpf() {
        desvisitarVertices();
        Collection<TVertice> visitados = new LinkedList<TVertice>();
        Collection<TVertice> verticesAVisitar = this.vertices.values();
        if (verticesAVisitar != null) {
            for (TVertice v : verticesAVisitar) {
                if (!v.getVisitado()) {
                    v.bpf(visitados);
                }
            }
        }
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        Collection<TVertice> visitados = new LinkedList<TVertice>();
        TVertice vertice = vertices.get(etiquetaOrigen);
        if (vertice != null) {
            vertice.bpf(visitados);
        }
        return visitados;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double[][] A = this.floyd();
        Double excMin = Double.MAX_VALUE;
        int columna = 0;
        Comparable vertMin = null;
        for (Comparable v : vertices.keySet()) {
            Double excentricidad = Double.MIN_VALUE;
            for (Double[] A1 : A) {
                if (A1[columna] > excentricidad) {
                    excentricidad = A1[columna];
                }
            }
            if (excentricidad < excMin) {
                excMin = excentricidad;
                vertMin = v;
            }
            columna++;
        }
        return vertMin;
    }

    @Override
    public Double[][] floyd() {
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
        //floyd = a;
        return a;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] A = this.floyd();
        int columna = 0;
        for (Comparable v : vertices.keySet()) {
            if (v.equals(etiquetaVertice)) {
                break;
            } else {
                columna++;
            }
        }
        Double max = Double.MIN_VALUE;
        for (Double[] A1 : A) {
            if (A1[columna] > max) {
                max = A1[columna];
            }
        }
        return max;
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TVertice origen = this.vertices.get(etiquetaOrigen);
        TVertice destino = this.vertices.get(etiquetaDestino);

        TCaminos todosLosCaminos = new TCaminos();

        if (origen == null || destino == null) {
            return todosLosCaminos;
        }

        TCamino caminoPrevio = new TCamino(origen);

        origen.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tieneCiclo() {
        return false;
    }

    public boolean contineAristasNegativas() {
        for (TArista arista : aristas.getAristas()) {
            if (arista.getCosto() < 0) {
                return true;
            }
        }
        return false;
    }

    public Double[] dijkstra(Comparable verticeInicial) {
        if (contineAristasNegativas()) {
            System.out.println("El grafo contiene aristas negativas");
            return null;
        } else if (!vertices.containsKey(verticeInicial)) {
            System.out.println("El vértice de inicio no se encuentra en el grafo");
            return null;
        } else {
            Double[] distMin = new Double[vertices.size()];
            Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(vertices);

            LinkedList<TVertice> vertVmenosS = new LinkedList<>();
            vertVmenosS.addAll(vertices.values());

            Object[] listaEtiquetas = vertices.keySet().toArray();
            int indiceInicial = 0;
            for (int i = 0; i < listaEtiquetas.length; i++) {
                if (verticeInicial.compareTo((Comparable) listaEtiquetas[i]) == 0) {
                    indiceInicial = i;
                }
            }
            for (int i = 0; i < matrizCostos.length; i++) {
                if (i != indiceInicial) {
                    distMin[i] = matrizCostos[indiceInicial][i];
                } else {
                    distMin[i] = -1.0;
                }
            }
            vertVmenosS.remove(indiceInicial);

            while (vertVmenosS.isEmpty() != true) {
                double min = Double.MAX_VALUE;
                int indiceV = indiceInicial;
                for (int i = 0; i < matrizCostos.length; i++) {
                    Comparable etiquetaBuscada = (Comparable) vertices.keySet().toArray()[i];
                    if (i != indiceInicial && vertVmenosS.contains(vertices.get(etiquetaBuscada))) {
                        if (min >= distMin[i]) {
                            min = distMin[i];
                            indiceV = i;
                        }
                    }
                }
                Comparable etiquetaVertice = (Comparable) vertices.keySet().toArray()[indiceV];
                for (int i = 0; i < matrizCostos.length; i++) {
                    if (i != indiceInicial && i != indiceV) {
                        if (distMin[i] > distMin[indiceV] + matrizCostos[indiceV][i]) {
                            distMin[i] = distMin[indiceV] + matrizCostos[indiceV][i];
                        }
                    }
                }
                vertVmenosS.remove(vertices.get(etiquetaVertice));
            }
            return distMin;
        }

    }

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
