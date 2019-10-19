/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;;

import UT05.*;
import static java.lang.Double.MAX_VALUE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import static java.lang.Double.MAX_VALUE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {
    
    public int[][] predecesor;
    
    public HashMap<Comparable, TVertice> vertices; //lista de v�rtices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        if(vertices!=null && aristas!=null){
            for (TVertice vertice : vertices) {
                insertarVertice(vertice.getEtiqueta(),vertice.duracion);
            }
            for (TArista arista : aristas) {
                insertarAdyacencia(arista.getEtiquetaOrigen(),
                        arista.getEtiquetaDestino(), arista.getCosto());
            }
        }
    }
    
    public TGrafoDirigido(){
        this.vertices = new HashMap();
    }

    /**
     * M�todo encargado de eliminar una adyacencia dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     */
    public boolean eliminarAdyacencia(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * M�todo encargado de eliminar un v�rtice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     */
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            vertices.remove(nombreVertice);
            return vertices.containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * M�todo encargado de verificar la existencia de una adyacencia. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeAdyacencia(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * M�todo encargado de verificar la existencia de un v�rtice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta) != null;
    }

    /**
     * M�todo encargado de verificar buscar un v�rtice dentro del grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta);
    }

    /**
     * M�todo encargado de insertar una adyacencia en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la adyacencia sea
     * v�lida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por par�metros son v�lidas.- 2) Los v�rtices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una adyacencia ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarAdyacencia(Comparable etiquetaOrigen, Comparable etiquetaDestino, Double costo) {
        if ((etiquetaOrigen != null) && (etiquetaDestino != null) && (costo != null)) {
            TVertice vertOrigen = buscarVertice(etiquetaOrigen);
            TVertice vertDestino = buscarVertice(etiquetaDestino);
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(costo, vertDestino);
            }
        }
        return false;
    }

    /**
     * M�todo encargado de insertar un v�rtice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta,int duracion) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta,duracion);
            vertices.put(unaEtiqueta, vert);
            return vertices.containsKey(unaEtiqueta);
        }
        return false;
    }

 
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.vertices);
        return mapOrdenado.keySet().toArray();
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
                if(A1[columna]>excentricidad){
                    excentricidad=A1[columna];
                }
            }
            if(excentricidad<excMin){
                excMin=excentricidad;
                vertMin=v;
            }
            columna++;
        }
        return vertMin;
    }

    @Override
    public boolean contieneCiclos() {
        LinkedList<Comparable> camino = new LinkedList();
        for(TVertice v: vertices.values()){
            if(!v.getVisitado() & v.tieneCiclos(camino)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Double[][] floyd() {
        Double [][] floyd = UtilGrafos.obtenerMatrizCostos(vertices);
        for(int i=0; i<floyd.length; i++){
            for(int j=0; j<floyd.length; j++){
                if(floyd[i][j] < 0 && i!=j){
                    return null;
                }
                if(i==j){
                    floyd[i][j] = 0.0;
                }
            }
        }
        int [][] predecesores = new int[floyd.length][floyd.length];
        for (int k=0; k<floyd.length; k++){
            for (int i=0; i<floyd.length; i++){
                for (int j=0; j<floyd.length; j++){
                    if(i!=j && i!=k && k!=j){
                        if (floyd[i][k]!= Double.MAX_VALUE && floyd[k][j]!=Double.MAX_VALUE){
                            if (floyd[i][k] + floyd[k][j] < floyd[i][j]){
                                floyd[i][j] = floyd[i][k] + floyd[k][j];
                                predecesores[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
        return floyd;   
    }
    

    @Override
    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] A = this.floyd();
        int columna =0;
        for (Comparable v : vertices.keySet()) {
            if(v.equals(etiquetaVertice)){
                break;
            }
            else{
                columna++;
            }
        }
        Double max = Double.MIN_VALUE;
        for (Double[] A1 : A) {
            if(A1[columna] > max){
                max=A1[columna];
            }
        }
        return max;
    }

    @Override
    //ANDA
    public Boolean[][] warshall() {
 int i,j,k;
    
    Double[][] matrizCosto=UtilGrafos.obtenerMatrizCostos(vertices);
    int[][] matrizCaminos=new int[matrizCosto.length][matrizCosto.length];
    Boolean[][] A=new Boolean[matrizCosto.length][matrizCosto.length];

    
        for(i=0;i<matrizCosto.length;i++){
        for(j=0;j<matrizCosto.length;j++){
            if(i==j){
                A[i][j]=false;
            }
            else{
                A[i][j]=matrizCaminos[i][j]!=Double.MAX_VALUE;
            }
        }
    }
    
    for(i=0;i<matrizCosto.length;i++){
        for(j=0;j<matrizCosto.length;j++){
            for(k=0;k<matrizCosto.length;k++){
                    if(!A[i][j]){
                        A[i][j]=A[i][k]&& A[k][j];
                }
            }
        }
    }
    predecesor=matrizCaminos;
    return A;
    }
    
    public void bpf(){
        Collection visitados = new LinkedList<LinkedList>();
        for(Map.Entry<Comparable,TVertice> v: vertices.entrySet()){
            if(!v.getValue().getVisitado()){
                visitados.add(this.bpf(v.getKey()));
            }
        }
        System.out.println(visitados);
        
    }
    
    @Override
    public Collection bpf(Comparable verticeOrigen){
        Collection visitados = new LinkedList();
        vertices.get(verticeOrigen).bpf(visitados);
        return visitados;
    }
     
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if(v != null){
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }
    
    public boolean tieneCiclos(){
        LinkedList<Comparable> camino = new LinkedList();
        for(TVertice v: vertices.values()){
            if(!v.getVisitado() & v.tieneCiclos(camino)){
                return true;
            }
        }
        return false;
    }
    
    public LinkedList<TVertice> ordenTopologico(){
        if(!tieneCiclos()){
            this.restablecer();
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
            oTopologico = v.getEtiqueta() + oTopologico;
        }
        System.out.println(oTopologico);            
        }
    }
    //para todo TVertice la var visitado se vuelve false
    public void restablecer(){
        for(TVertice v: vertices.values()){
            v.setVisitado(false);
        }
    }
    //Invierte la dirección de las flechitas 
    public IGrafoDirigido invertirGrafo(){
        TGrafoDirigido gd = new TGrafoDirigido();
        for(TVertice v: vertices.values()){
            gd.insertarVertice(v.getEtiqueta(),v.duracion);
        }
        for(TVertice v: gd.vertices.values()){
            for(TAdyacencia ady: v.getAdyacentes()){
                gd.insertarAdyacencia(ady.getEtiqueta(), v.getEtiqueta(), ady.getCosto());
            }
        }
        return gd;
    }

    public ArrayList<Double> dijkstra(Comparable origen) {
        LinkedList<Comparable> todosLosV = new LinkedList<>(vertices.keySet());
        todosLosV.remove(origen);
        LinkedList<Comparable> verticesL = new LinkedList<>(vertices.keySet());
        verticesL.remove(origen);
        
        ArrayList<TVertice> S = new ArrayList<>();
        ArrayList<Double> D = new ArrayList<>();
        ArrayList<TVertice> P = new ArrayList<>();

        S.add(this.vertices.get(origen));
        verticesL.remove(origen);

        TVertice orig = this.vertices.get(origen);
        for (Comparable i : verticesL) {
            D.add(orig.costoAunaAdy(i));
        }
        ArrayList<Double> ant = new ArrayList<>();
        int n = 0;
        while (verticesL.size() > 0 && n < this.vertices.size()) {
            n++;
            TVertice w = elegirMinimo(todosLosV, D, ant);
            ant.add(orig.costoAOtroVertice(todosLosV, D, w.getEtiqueta()));
            S.add(w);
            verticesL.remove(w.getEtiqueta());
            for (Comparable v : verticesL) {
                Double cOW = orig.costoAOtroVertice(todosLosV, D, w.getEtiqueta());
                Double cWV = w.costoAunaAdy(v);
                Double cOV = orig.costoAOtroVertice(todosLosV, D, v);
                if (cOW + cWV < cOV) {
                    D.set(todosLosV.indexOf(v), cOW + cWV);
                    P.add(w);
                }
            }
        }

        return D;
    }
    
    private TVertice elegirMinimo(LinkedList<Comparable> vertices, ArrayList<Double> D, ArrayList<Double> anteriores) {
        Double costo = Double.MAX_VALUE;
        int pos = 0;
        for (int i = 0; i < D.size(); i++) {
            if (D.get(i) < costo && !anteriores.contains(D.get(i))) {
                costo = D.get(i);
                pos = i;
            }
        }
        return this.vertices.get(vertices.get(pos));
    }
    
    public LinkedList<LinkedList<TVertice>> componentesFuertes() {
        LinkedList<TVertice> todosVertices = new LinkedList<>(vertices.values());
        LinkedList<TVertice> misVertices = new LinkedList<>();
        LinkedList<TVertice> aux = new LinkedList<>();
        int [] contador = new int[1];
        contador[0] = 0;
        TVertice vertice = todosVertices.getFirst();
        while (!misVertices.containsAll(todosVertices)) {
            this.restablecer();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);
            vertice = aux.getFirst();
            vertice.componentesFuertes(misVertices, contador);
        }
        
        LinkedList<TArista> listaAristas = new LinkedList<>();
        for (Iterator it = this.listaAristas().iterator(); it.hasNext();) {
            TArista arst = (TArista) it.next();
            listaAristas.add(new TArista(arst.etiquetaDestino, arst.etiquetaOrigen, arst.costo));
        }
        TGrafoDirigido auxiliar = new TGrafoDirigido(todosVertices, listaAristas);
        misVertices.clear();
        aux.clear();
        todosVertices.clear();
        todosVertices.addAll(auxiliar.vertices.values());
        LinkedList<TVertice> misVertices2 = new LinkedList<>();
        LinkedList<LinkedList<TVertice>> componentes = new LinkedList<>();
        while (!misVertices.containsAll(todosVertices)) {
            auxiliar.restablecer();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);
            vertice = this.masFuerte(aux);
            misVertices2 = new LinkedList<>();
            vertice.bpfVertices(misVertices2);
            misVertices.addAll(misVertices2);
            componentes.add(misVertices2);
        }
        return componentes;
    }
    
    /**
     * Método para saber el vértice con el mayor número en el recorrido para componentes fuertes
     * @param vertices Lista de vértices con componente fuerte
     * @return Vertice con número de componente fuerte más grande
     */
    public TVertice masFuerte (LinkedList<TVertice> vertices) {
        TVertice mayor = vertices.getFirst();
        for (TVertice ver : vertices) {
            if (ver.cfuerte> mayor.cfuerte) {
                mayor = ver;
            }
        }
        return mayor;
    }
    
    public LinkedList listaAristas () {
        LinkedList<TArista> lista = new LinkedList<>();
        for (TVertice ver : vertices.values()) {
            for (TAdyacencia ady : ver.getAdyacentes())
                lista.add(new TArista(ver.getEtiqueta(), ady.getDestino().getEtiqueta(), ady.getCosto()));
        }
       return lista;
    }
    
    /**
     * Determina si V es ancestro de W.
     * @param v
     * @param w
     * @return 
     */
    public boolean esAncestro(TVertice v,TVertice w){
        if(((v.num_bp )<= w.num_bp )){
            return w.num_bp  <= v.num_bp+ v.getAdyacentes().size();
        }
        return false;
    }
    
    public HashMap<Comparable,TArista>[] clasificarAristas(){
        restablecer();
        int[] numero={0};
        HashMap<Comparable,TArista>[] contenedor = new HashMap[4];
        HashMap<Comparable,TArista> arbol,avance,retroceso,cruzado;
        contenedor[0]=arbol=new HashMap();
        contenedor[1]=avance =new HashMap();
        contenedor[2]=retroceso=new HashMap();
        contenedor[3]=cruzado=new HashMap();
        
        for(Entry<Comparable,TVertice> v: vertices.entrySet()){
            if(!v.getValue().getVisitado()){
                numero[0]++;
                v.getValue().clasificarAristas(numero,contenedor);
            }
        }
        return contenedor;
    }
    
    public TCaminos caminoCritico(){
        TCaminos caminos = null;
        if(!tieneCiclos()){
            this.restablecer();
            caminos = todosLosCaminos("Ingreso", "Graduacion");
            TCamino caminoMaximo = null;
            double pMaximo = Integer.MIN_VALUE;
            for (TCamino camino : caminos.getCaminos()) {
                double aux = 0;
                for (TVertice vertice : camino.getOtrosVertices()) {
                    aux += vertice.duracion;
                    
                }
                camino.costoTotal=aux;
                if (aux>pMaximo) {
                    if ((caminoMaximo!=null)&&caminoMaximo.critico) {
                        caminoMaximo.critico = false;
                    }
                    caminoMaximo = camino;
                    pMaximo = aux;
                    caminoMaximo.critico = true;
                }
            }
        }
        return caminos;
    }
}
