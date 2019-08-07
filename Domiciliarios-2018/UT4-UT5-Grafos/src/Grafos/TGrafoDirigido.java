package Grafos;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    

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
        Collection<TVertice> res = new ArrayList<>();
        vertice.bpf(res);
        return res;
    }

    

    @Override
    public boolean tieneCiclo(TCamino camino) {
        for(TVertice v : vertices.values()){
            if(!v.getVisitado()){
                boolean tieneCiclo = v.tieneCiclo(camino);
                if(tieneCiclo){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Collection<TVertice> bpf() {
        Collection<TVertice> visitados = new ArrayList<>();
        for(TVertice v : vertices.values()){
            if(!v.getVisitado()){
                v.bpf(visitados);                
            }
        }
        desvisitarVertices();
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        TVertice v = vertices.get(etiquetaOrigen);
        Collection<TVertice> visitados = new ArrayList<>();
        v.bpf(visitados);
        return visitados;
    }

    @Override
    public Comparable centroDelGrafo() {
        double menorExcentricidad = Double.MAX_VALUE;
        Comparable etiquetaCentro = "";
        for(TVertice v : vertices.values()){
            double excentricidad =  (double) obtenerExcentricidad(v.getEtiqueta());
            if(excentricidad < menorExcentricidad){
                menorExcentricidad = excentricidad;
                etiquetaCentro = v.getEtiqueta();
            }
        }
        desvisitarVertices();
        return etiquetaCentro;
    }

    
    @Override
    public Double[][] floyd() {        
        Double[][] A = UtilGrafos.obtenerMatrizCostos(vertices);
                
        for(int k = 0; k < vertices.size(); k++){
           for(int i = 0; i < vertices.size(); i++){
                for(int j = 0; j < vertices.size(); j++){                  
                    if(A[i][k] + A[k][j] < A[i][j]){
                        A[i][j] = A[i][k] + A[k][j];
                    }                        
                }
            } 
        }       
        return A;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double mayorCostoValor = -1.0d;
        Double[][] A = floyd();
        
        Object[] etiquetasVertices = vertices.keySet().toArray();
        int fila;
        for(fila = 0; fila < etiquetasVertices.length; fila++){
            
            if (etiquetasVertices[fila] == etiquetaVertice) {
                break;
            }
        }        
        for (int columna = 0; columna < vertices.size(); columna++) {
            if (A[fila][columna] > mayorCostoValor) {
                mayorCostoValor = A[fila][columna];
            }
        }        
        
       desvisitarVertices();
       return mayorCostoValor;
    }   

    @Override
    public boolean[][] warshall() {
        Double[][] A = UtilGrafos.obtenerMatrizCostos(vertices);
        boolean[][] B = new boolean[vertices.size()][vertices.size()];
        
        for (int i = 0; i < vertices.size(); i++){
            for(int j = 0; j < vertices.size(); j++){
                B[i][j] = A[i][j] != Double.MAX_VALUE;
            }
        }
        
        for(int k = 0; k < vertices.size(); k++){
           for(int i = 0; i < vertices.size(); i++){
                for(int j = 0; j < vertices.size(); j++){                  
                    if(!B[i][j]){
                        B[i][j] = B[i][k] && B[k][j];
                    }                        
                }
            } 
        }       
        return B;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice origen = this.vertices.get(etiquetaOrigen);
        if(origen != null){
            TCaminos caminos = new TCaminos();
            TCamino caminoTemporal = new TCamino(origen);
            origen.todosLosCaminos(etiquetaDestino, caminoTemporal, caminos);
            this.desvisitarVertices();
            return caminos;
        }
        return null;
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        TVertice v = vertices.get(etiquetaOrigen);
        if(v!=null){
            TCamino camino = new TCamino(v);
            boolean resultado = v.tieneCiclo(camino);
            desvisitarVertices();
            return resultado;
        } else {
            return false;
        }
    }

    @Override
    public boolean tieneCiclo() {
        if(vertices.isEmpty()){
            return false;
        }
        TVertice v = vertices.values().iterator().next();
        TCamino camino = new TCamino(v);
        boolean resultado = v.tieneCiclo(camino);
        desvisitarVertices();
        return resultado;
    }

    @Override
    public Collection<TVertice> bea() {
        TVertice v = vertices.values().iterator().next();
        Collection<TVertice> visitados = new ArrayList<>();
        v.bea(visitados);
        desvisitarVertices();
        return visitados;
    }

    public boolean esConexo(){
        TVertice a =this.vertices.values().iterator().next();
        Collection<TVertice> res=bpf(a.getEtiqueta());
        return res.containsAll(this.vertices.values());
    }
    /*
    public Collection<TArista> arcosClasificados () {   
        LinkedList<TVertice> todosVertices = new LinkedList<>(vertices.values());
        LinkedList<TVertice> misVertices = new LinkedList<>();
        LinkedList<TVertice> aux = new LinkedList<>();
        LinkedList<TArista> lista = new LinkedList<>();
        int [] contador = new int[1];
        TVertice vertice = todosVertices.getFirst();
        while (!misVertices.containsAll(todosVertices)) {
            contador[0] = 0;
            this.desvisitarVertices();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);  
            vertice = aux.getFirst();
            lista.addAll(vertice.clasificacionArcosND(contador,misVertices));
        }
        //System.out.println();
        return lista;
    }
   
    public Collection<TVertice> puntosArticulacion () {
        LinkedList<TVertice> todosVertices = new LinkedList<>(vertices.values());
        LinkedList<TVertice> misVertices = new LinkedList<>();
        LinkedList<TVertice> aux = new LinkedList<>();
        LinkedList<TVertice> lista = new LinkedList<>();
        int [] contador = new int[1];
        TVertice vertice = todosVertices.getFirst();
        while (!misVertices.containsAll(todosVertices)) {
            contador[0] = 0;
            this.desvisitarVertices();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);
            vertice = aux.getFirst();
            lista.addAll(vertice.puntosArticulacion(contador));
            this.desvisitarVertices();
            vertice.bpfVertices(misVertices);
        }
        //System.out.println();
        return lista;
    }*/
}
