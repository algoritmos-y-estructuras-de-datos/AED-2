package ut4pd3;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
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

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
 vectorVertices sean inv�lidas, retorna falso.
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
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     */
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
 vectorVertices pasadas por par�metro deben ser v�lidas.
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
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
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
 costo), dado su vertice origen y destino.- Para que la arista sea
 valida, se deben cumplir los siguientes casos: 1) Las vectorVertices pasadas
 por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
 dentro del grafo.- 3) No es posible ingresar una arista ya existente
 (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
 costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
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
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    
   
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
        Double[][] floydTemp = this.floyd();
        Set<Comparable> etiquetasDeVertices = this.vertices.keySet();              
        Comparable[] array = new Comparable[floydTemp.length];
        array = etiquetasDeVertices.toArray(array);             
        int numeroColumna = 0;
        for (int c = 0; c < array.length; c++) {
            
            if(array[c] == etiquetaVertice){
                numeroColumna = c;
                break;
            }
            
        }
        Double excentricidad = 0.0;
        for (int i = 0; i < floyd.length; i++) {
            if(floyd[i][numeroColumna] > excentricidad){
                if (floyd[i][numeroColumna] < Double.MAX_VALUE){
                    if (floyd[i][numeroColumna] > 0.0) {
                      
                        excentricidad = floyd[i][numeroColumna];
                    }
                    
                }
                
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
        etiquetaCentro = arrayEtiquetas[0];
        for (int i = 0; i < excentricidades.length; i++) {
            Comparable candidato = excentricidades[i];
                if(candidato.compareTo(centro) <0){
                   centro = candidato;
                   etiquetaCentro = arrayEtiquetas[i];
                } 
        }
     return "Centro del grafo "+centro +" Etiqueta: "+ etiquetaCentro;
    }
    
    /**
     * LOS SIGUIENTES DOS METODOS SON LOS QUE ESTAN EN LOS PSEUDOGODICOS DE LAS CUADERNOLAS, 
     * SON MAS SENCILLOS PERO SON LO QUE SE REALIZARON EN LA CLASE.
     * @param etiquetaVertice
     * @return 
     */
    
     public Comparable obtenerExcentricidad2(Comparable etiquetaVertice) {
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

    public Comparable centroDelGrafo2() {
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
            etiquetaCentro = arrayEtiquetas[0];
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
}
