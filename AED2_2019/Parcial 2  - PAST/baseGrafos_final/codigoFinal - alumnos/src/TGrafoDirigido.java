
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    private Double[][] matrizFloyd = null;
    private Integer[][] matrizFloydCamino = null;
private boolean[][] matrizWarshall = null;
    /*
    Agregue una condicion if para controlar el ingreso de parametros nulos
    */
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        if(vertices!=null && aristas!=null){
            for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
            for (TArista arista : aristas) {
                insertarArista(arista);
            }
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
        if(verticesAVisitar != null){
            for(TVertice v: verticesAVisitar){
                if(!v.getVisitado()){
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
        if(vertice != null){
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
    public Double[][] floyd() {
        Object[] etVertices = this.vertices.keySet().toArray();

        this.matrizFloyd = UtilGrafos.obtenerMatrizCostos(vertices);
        this.matrizFloydCamino = new Integer[matrizFloyd.length][matrizFloyd.length];

        // Inicializa la matriz de camino
        for (int i = 0; i < matrizFloyd.length; i++) {
            for (int j = 0; j < matrizFloyd.length; j++) {
                if (matrizFloyd[i][j] != Double.MAX_VALUE) {
                    matrizFloydCamino[i][j] = j;
                } else {
                    matrizFloydCamino[i][j] = null;
                }
            }
        }


        for (int k = 0; k < matrizFloyd.length; k++) {
            for (int i = 0; i < matrizFloyd.length; i++) {
                for (int j = 0; j < matrizFloyd.length; j++) {
                    if (i != j && i != k && k != j) {
                        double conEscala = matrizFloyd[i][k] + matrizFloyd[k][j];
                        if (conEscala < matrizFloyd[i][j]) {
                            matrizFloyd[i][j] = conEscala;
                            matrizFloydCamino[i][j] = matrizFloydCamino[i][k];
                        }
                    }
                }
            }
        }

    return matrizFloyd;
}

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
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
        return max;    }

    @Override
    public boolean[][] warshall() {
        Double[][] mCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        this.matrizWarshall = new boolean[mCostos.length][mCostos.length];

        for (int i = 0; i < mCostos.length; i++) {
            for (int j = 0; j < mCostos.length; j++) {
                this.matrizWarshall[i][j] = mCostos[i][j] != Double.MAX_VALUE;
            }
        }


        for (int i = 0; i < matrizWarshall.length; i++) {
            for (int j = 0; j < matrizWarshall.length; j++) {
                for (int k = 0; k < matrizWarshall.length; k++) {
                    if (i != j && i != k && k != j) {
                        boolean conEscala = matrizWarshall[i][k] && matrizWarshall[k][j];
                        matrizWarshall[i][j] = matrizWarshall[i][j] || conEscala;

                    }
                }
            }
        }

    return matrizWarshall;
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
        desvisitarVertices();
        Collection<TVertice> verticesAVisitar = this.vertices.values();
        if(verticesAVisitar != null){
            for(TVertice v: verticesAVisitar){
                TCamino camino = new TCamino(v);
                if(v.tieneCiclo(camino)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
        Collection<TVertice> verticesAVisitar = this.vertices.values();
        if(verticesAVisitar != null){
            for(TVertice v: verticesAVisitar){
                TCamino camino = new TCamino(v);
                if(v.tieneCiclo(camino)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Collection<TVertice> bea() {
        Collection<TVertice> col = new LinkedList<>();
        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(col);
            }
        }
        return col;
    }
    public Collection<TVertice> bea(TVertice vertice) {
        if (vertice == null || vertice.getVisitado()) {
            return new LinkedList<>();
        }
        return this.bea(vertice.getEtiqueta());
    }

    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        TVertice vertice = vertices.get(etiquetaOrigen);
        Collection<TVertice> col = new LinkedList<>();
        if (vertice != null) {
            vertice.bea(col);
        }
        return col;
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
    
    /*
    NUEVAS FUNCIONES
    */
    public LinkedList<TVertice> ordenTopologico(){
        if(!this.tieneCiclo()){
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
            oTopologico = v.getEtiqueta() + oTopologico;
        }
        System.out.println(oTopologico);            
        }
    }
    
    public LinkedList<LinkedList<TVertice>> componentesFuertes() {
        LinkedList<TVertice> todosVertices = new LinkedList<>(vertices.values());
        LinkedList<TVertice> misVertices = new LinkedList<>();
        LinkedList<TVertice> aux = new LinkedList<>();
        int [] contador = new int[1];
        contador[0] = 0;
        TVertice vertice = todosVertices.getFirst();
        while (!misVertices.containsAll(todosVertices)) {
            this.desvisitarVertices();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);
            vertice = aux.getFirst();
            vertice.componentesFuertes(misVertices, contador);
        }
        
        LinkedList<TArista> listaAristas = new LinkedList<>();
        for (Iterator it = listaAristas().iterator(); it.hasNext();) {
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
            auxiliar.desvisitarVertices();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);
            vertice = this.masFuerte(aux);
            misVertices2 = new LinkedList<>();
            vertice.bpf(misVertices2);
            misVertices.addAll(misVertices2);
            componentes.add(misVertices2);
        }
        return componentes;
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
   
    public boolean esConexo() {
        for (TVertice vertice : vertices.values()) {
            desvisitarVertices();
            Collection<TVertice> vxs = new HashSet<>();
            vertice.bpf(vxs);
            if (vertices.size() > vxs.size()) {
                return false;
            }
        }
        return true;
    }
    public TCamino caminoCritico(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        
        if(!tieneCiclo()){
            double max = 0;
            TCamino camino = null;
            TCaminos lista = todosLosCaminos(etiquetaOrigen, etiquetaDestino);
            for(TCamino c: lista.getCaminos()){
                if(max < c.getCostoTotal()){
                    max = c.getCostoTotal();
                    camino = c.copiar();
                    //System.out.println(max);
                    camino.setCostoTotal(camino.getCostoTotal()+(max-camino.getCostoTotal()));
                }
            }
            return camino;
        }
        return null;
    }
     public Collection<Collection<TVertice>> componentesConexos() {
        Collection<Collection<TVertice>> componentes = new LinkedList<>();

        Collection<TVertice> bpfTotal = this.bpfPostOrden();

        TGrafoDirigido grafoInverso = this.grafoOpuesto();
        LinkedList<TVertice> arbol = new LinkedList<>();
        for (TVertice vertice : bpfTotal) {
            TVertice vEnOpuesto = grafoInverso.getVertices().get(vertice.getEtiqueta());
            if (!vEnOpuesto.getVisitado()) {
                vEnOpuesto.setVisitado(true);
                vEnOpuesto.bpf(arbol);
                componentes.add(arbol);
                arbol = new LinkedList<>();
            }
        }
        return componentes;
    }
     private TGrafoDirigido grafoOpuesto() {
        List<TArista> aristas = new LinkedList<>();
        for (TVertice v : vertices.values()) {
            for (TAdyacencia adyacente : v.getAdyacentes()) {
                aristas.add(new TArista(adyacente.getEtiqueta(), v.getEtiqueta(), adyacente.getCosto()));
            }
        }
        return new TGrafoDirigido(this.getVertices().values(), aristas);
}
    private Collection<TVertice> bpfPostOrden() {
        LinkedList<TVertice> col = new LinkedList<>();
        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpfPostOrden(col);
            }
        }
        return col;
}
}
