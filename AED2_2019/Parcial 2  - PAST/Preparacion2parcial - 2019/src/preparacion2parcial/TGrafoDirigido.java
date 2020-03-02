package preparacion2parcial;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Ernesto
 */
public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // vertices del grafo.-
    private Double[][] floyd;
    protected TAristas aristas;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        this.aristas = new TAristas();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }
    public TAristas getAristas() {
        return aristas;
    }  

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
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
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
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
    public TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
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
     if (!existeVertice(unaEtiqueta)) {
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
                    if((a[i][k]+a[k][j])< a[i][j]){
                        a[i][j] = a[i][k]+a[k][j];
                        p[i][j] = k+0.0;
                
                    }
                }
            }
        }
        floyd = a;
        return a;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        //Calculamos la matriz de Floyd
        Double[][] c = this.floyd();       
        int columnaVertice = 0;
        int contador = 0;
        for(Comparable key: vertices.keySet()){
            if(key.equals(etiquetaVertice)){
                columnaVertice = contador;
                break;
            }            
            contador += 1;            
        }        
        double excentricidad = 0;
        for(int i=0; i<c.length; i++){
            if(c[i][columnaVertice] > excentricidad){
                excentricidad = c[i][columnaVertice];
            }
        }
        return excentricidad;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double[][] floydTemp = this.floyd();
        Comparable centro = 0.0;
        Comparable etiquetaCentro ="";
        Set<Comparable> etiquetas = this.vertices.keySet();
        Comparable[] arrayEtiquetas = new Comparable[floydTemp.length];
        arrayEtiquetas = etiquetas.toArray(arrayEtiquetas);
        Comparable[] excentricidades = new Comparable[floydTemp.length];
            for (int i = 0; i < arrayEtiquetas.length; i++) {
                Comparable exTemp = obtenerExcentricidad(arrayEtiquetas[i]);
                excentricidades[i] = exTemp;
            }
            centro = excentricidades[0];
            for (int i = 0; i < excentricidades.length; i++) {
                Comparable candidato = excentricidades[i];
                    if(candidato.compareTo(centro) <0){
                       centro = candidato;
                       etiquetaCentro = arrayEtiquetas[i];
                    } 
            }
         return "Centro del grafo "+centro +" Etiqueta: "+ etiquetaCentro;
    }
    
    @Override
    public boolean[][] warshall() {
        Double[][] a = UtilGrafos.obtenerMatrizCostos(vertices);
        boolean[][] c = new boolean[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i][j] = false;
                if( i != j && a[i][j] != Double.MAX_VALUE)
                    c[i][j] = true;              
            }         
        }
        for (int k = 0; k < c.length; k++) {
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!c[i][j]) {
                            c[i][j] = c[i][k] && c[k][j];
                        }
                    }
                }
            }
        }
        return c;
    }

    @Override
    public Collection<TVertice> bpf() {
        desvisitarVertices();
        LinkedList<TVertice> resultado = new LinkedList<>();
        for (TVertice aux : vertices.values()) {
            if(!aux.getVisitado()){
                aux.bpf(resultado);
            }
            
        }
        return resultado;
////        vertices.entrySet().stream().map((m) -> m.getValue()).filter((aux) -> (!aux.getVisitado())).forEachOrdered((aux) -> {
////            aux.bpf(resultado);
//        });
//        return resultado;
    }


    
    
    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> resultado = new LinkedList<>();
        if (vertices.containsKey(etiquetaOrigen)) {
            vertices.get(etiquetaOrigen).bpf(resultado);
        }
        return resultado;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        LinkedList<TVertice> exit = new LinkedList<>();
        if (vertices.containsKey(vertice.getEtiqueta())) {
            vertice.bpf(exit);
        }
        return exit;

    }

    @Override
    public void desvisitarVertices() {
        for (Map.Entry<Comparable, TVertice> m : vertices.entrySet()) {
            m.getValue().setVisitado(false);
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        this.desvisitarVertices();
        TVertice v = buscarVertice(etiquetaOrigen);
        if(v!=null)
        {
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
       
       
    }

    @Override
    public Double[] dijkstra(Comparable verticeInicial) {
        if (contineAristasNegativas()){
            System.out.println("El grafo contiene aristas negativas");
            return null;
        }else if(!vertices.containsKey(verticeInicial)){
            System.out.println("El vértice de inicio no se encuentra en el grafo");
            return null;
        }else{
            Double[] distMin = new Double[vertices.size()];            
            Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(vertices);
            
            LinkedList<TVertice> vertVmenosS = new LinkedList<>();
            vertVmenosS.addAll(vertices.values());
            
            Object[] listaEtiquetas = vertices.keySet().toArray();
            int indiceInicial = 0;
            for (int i = 0; i < listaEtiquetas.length; i++) {
                if (verticeInicial.compareTo((Comparable)listaEtiquetas[i]) == 0){
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
    
    public boolean contineAristasNegativas(){
        for(TArista arista : aristas.getAristas()){
            if (arista.getCosto()< 0){
                return true;
            }
        }
        return false;
    }
    
    public boolean tieneCiclo() {
        desvisitarVertices();
        boolean res = false;
        
        for (TVertice vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                TCamino camino = new TCamino(vertV);
                res = vertV.tieneCiclo(camino);
                if(res){
                    camino.imprimirEtiquetasConsola();
                    return true;
                }
            }
        }
        return res;
    }
    
    
    public LinkedList<TVertice> ordenTopologico(){
        if(!tieneCiclo()){
            this.desvisitarVertices();
            LinkedList<TVertice> camino = new LinkedList();
            for(TVertice v: vertices.values()){
                if(!v.getVisitado()){
                    v.ordenTopologico(camino);
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
                oTopologico = v.getEtiqueta() + " - " + oTopologico;
            }
            System.out.println(oTopologico);           
        }
    }
    
    public void ordenPreviaturas(TVertice origen){
        if(origen!=null){
            TVertice ori = this.buscarVertice(origen.getEtiqueta());
            if(ori!=null){
                if(!this.tieneCiclo()){
                    this.desvisitarVertices();
                    ori.ordenPreviaturas();
                }else{
                    System.out.println("El grafo tiene ciclos.");
                }
            }else{
                System.out.println("El vertice '"+origen.getEtiqueta().toString().trim()+"' NO pertenece al grafo.");
            }
        }else{
            System.out.println("El vertice Origen dado es nulo.");
        }
    }
    


    
}
