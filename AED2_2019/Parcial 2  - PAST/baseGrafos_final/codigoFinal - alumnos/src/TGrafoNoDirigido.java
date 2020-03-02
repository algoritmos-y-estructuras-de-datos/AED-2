
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(){
        super(null,null);
        this.lasAristas = new TAristas(new TreeSet<>());
    }
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
       super(vertices, aristas);     
      lasAristas.insertarAmbosSentidos(aristas);
        
       
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }
    public TAristas getLasAristas() {
        /*System.out.println(lasAristas.isEmpty());
        System.out.println(lasAristas.imprimirEtiquetas());*/
        //System.out.println(lasAristas.size());
        return lasAristas;
    }
    public String imprimirEtiquetas() {
        if (this.getLasAristas().isEmpty()) {
            return "";
        }
        String salida = "";
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        for(TArista ta : this.getLasAristas()){
            salida=salida+ta.getEtiquetaOrigen()+"-"+ta.getEtiquetaDestino()+"-"+ta.getCosto()+"\n";
        }
        return salida;
    }
 
    public void cargarArista(Comparable etiquetaOrigen,Comparable etiquetaDestino, Double costo) {
        lasAristas.insertarAlFinal(new TArista(etiquetaOrigen, etiquetaDestino,costo));
        lasAristas.insertarAlFinal(new TArista(etiquetaDestino, etiquetaOrigen,costo)); // para que no falle la busqueda del min y destino
        insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
    }
   

    @Override
    public TGrafoNoDirigido Prim() {
        int costoPrim = 0;
        if (this.getVertices().size() == 0) {
            return new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        } else if (this.lasAristas.size() < this.getVertices().size() - 1) {
            return null;
        }
        TreeMap<Comparable, TVertice> VerticesU = new TreeMap<>();
        TreeMap<Comparable, TVertice> VerticesV = new TreeMap<Comparable, TVertice>(this.getVertices());
        TreeSet<TAristas> AristasAAM = new TreeSet<TAristas>();
        TArista tempArista;
//        TGrafoNoDirigido nuevoGrafo = new TGrafoNoDirigido();
        if (this.getVertices().isEmpty()) {
            return null;
        }
        LinkedList<TArista> aristasElegidas = new LinkedList<>();
        // agarra al primero de vertivesV
        Map.Entry<Comparable, TVertice> tempV = VerticesV.firstEntry();
            VerticesV.pollFirstEntry();
            VerticesU.put(tempV.getKey(),tempV.getValue());
        
        while (!VerticesV.isEmpty()) {
            //metodo de TAristas que ayuda
            TArista arista = lasAristas.buscarMin(VerticesU.values(), VerticesV.values());
            costoPrim += arista.getCosto(); 
            //saca la arista de v y la pone en u
            TVertice vert = VerticesV.remove(arista.getEtiquetaDestino());
            if(vert==null){
                vert = VerticesV.remove(arista.getEtiquetaOrigen());
            }
            //pone en el u, y va creando el nuevo grafo, pero ahora carga las aristas dobles, esta bastante extraño
            VerticesU.put(vert.getEtiqueta(),vert);
            aristasElegidas.add(arista);
            //nuevoGrafo.cargarArista(arista.getEtiquetaOrigen(), arista.getEtiquetaDestino(), arista.getCosto());
            
            //nuevoGrafo.insertarVertice(vert);
        }

        System.out.println("costo AAM: " + costoPrim);

		//A partir de la lista de vertices VerticesU y las aristas en AristasAAM armar el grafo nuevoGrafo y retornarlo
        //---------COMPLETAR ALGORITMO--------
        
        this.desvisitarVertices();
        return new TGrafoNoDirigido(this.getVertices().values(), aristasElegidas);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        int costoTotal= 0;
        if (this.getVertices().size() == 0) {
            return new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        } else if (this.lasAristas.size() < this.getVertices().size() - 1) {
            return null;
        }
        PriorityQueue<TArista> aristasEnOrden = new PriorityQueue<>(lasAristas.size(), Comparator.comparingDouble(TArista::getCosto));
        TGrafoNoDirigido aam = new TGrafoNoDirigido(this.getVertices().values(), new LinkedList<>());

        HashMap<Comparable, Comparable> padre = new HashMap<>(this.getVertices().size());
        for (Comparable et : this.getVertices().keySet()) {
            padre.put(et, et);
        }
        aristasEnOrden.addAll(lasAristas);
        LinkedList<TArista> aristasElegidas = new LinkedList<>();
        while (!aristasEnOrden.isEmpty()) {
            TArista arista = aristasEnOrden.remove();
            Comparable raizOrigen = nodoSinPadre(padre, arista.etiquetaOrigen);
            Comparable raizDestino  = nodoSinPadre(padre, arista.etiquetaDestino);
            if (raizOrigen.compareTo(raizDestino) == 0) {
                continue;
            } else {
                //System.out.println(arista.getCosto());
                costoTotal+=arista.getCosto();
                aristasElegidas.add(arista);
                padre.put(raizDestino, raizOrigen);
            }

            if (aristasElegidas.size() == this.getVertices().size() - 1) {
                System.out.println("Costo total : "+costoTotal);
                this.desvisitarVertices();
                return new TGrafoNoDirigido(this.getVertices().values(), aristasElegidas); // FINISHED
            }
        }
        return null;


    }
    public int costoTotal(){
        if (this.getLasAristas().isEmpty()) {
            return 0;
        }
        int salida = 0;
        int cont=0;
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        for(TArista ta : this.getLasAristas()){
            if(cont%2==0){
                salida+=ta.getCosto();
            }
            cont++;
        }
        return salida;
    }
    private Comparable nodoSinPadre(Map<Comparable, Comparable> padre, Comparable vertice) {
        while (padre.get(vertice).compareTo(vertice) != 0) {
            vertice = padre.get(vertice);
        }
        return vertice;
    }
    
    public boolean insertarAdyacencia(Comparable etiquetaOrigen,Comparable etiquetaDestino, Double costo) {
        return (super.insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo) && super.insertarAdyacencia(etiquetaDestino, etiquetaOrigen, costo));
    }
    
     public List<TVertice> puntosDeArticulacion() {
        List<TVertice> puntos = new LinkedList<>();

        for (TVertice v : getVertices().values()) {
            if (!v.getVisitado()) {
                v.puntosDeArticulacion(puntos, new int[]{1}, null);
            }
        }

        return puntos;
}
    
    
    
}
