package ut4ta2;

import ut4pd5.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class TGrafoDirigido  implements IGrafoDirigido {

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

    public void desvisitarVertices() {
        for (Map.Entry<Comparable, TVertice> m : vertices.entrySet()) {
            m.getValue().setVisitado(false);
        }
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

    @Override
    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double[][] floyd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
        public boolean esConexo(){
        for(TVertice a : this.vertices.values()){
            Collection<Comparable> res=bpf(a.getEtiqueta());
            if(res.containsAll(this.vertices.keySet())){
                return true;
            }
        }
        return false;
    }
        
        public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();
        this.desvisitarVertices();
        TVertice origen = vertices.get(etiquetaOrigen);
        if (origen != null) {
            origen.bpf(listaBpf);
        }
        return listaBpf;
    }
        
          public void caminoCritico(Comparable origen, Comparable destino){
        if(!this.tieneCiclo()){
            this.desvisitarVertices();
            TCaminos caminos = this.todosLosCaminos(origen, destino);
            TVertice vOrigen = this.buscarVertice(origen);
            vOrigen.caminoCritico(caminos);
        }
        else{
            System.out.println("ATENCIÓN: El grafo tiene ciclos. Finaliza el proceso de caminoCritico().");
        }
    }  

    private TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
       TCaminos todosLosCaminos = new TCaminos();
        TVertice ori = buscarVertice(etiquetaOrigen);
        TVertice des = buscarVertice(etiquetaDestino);
        if (ori!=null && des!=null) {
            TCamino caminoPrevio = new TCamino(ori);
            ori.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }else{
            if (ori==null)
                System.out.println("Origen no existe");
            else
                System.out.println("Destino no existe");
        }
        return null;
    }
}