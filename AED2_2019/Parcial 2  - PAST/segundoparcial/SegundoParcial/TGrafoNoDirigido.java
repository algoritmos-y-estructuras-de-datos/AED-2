package SegundoParcial;

import UT05.*;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class TGrafoNoDirigido extends TGrafoDirigido {

    private TAristas aristas;

    // creo el treeSet de aristas porque sino se rompe el programa con el puntero en null
    public TGrafoNoDirigido(){
        super(null,null);
        this.aristas = new TAristas(new TreeSet<>());
    }
    
    // el TAristas por lo que entendi son las aristas que se duplican, y las cuales
    // usamos para el prim, chancho muy chancho...
    // Cambie lo de collection por una linkedlist asi guarda las aristas y las devuelve en el orden que insertamos
    // En especial para los metodos de bea y bpf, para que no nos pase lo que ocurrio en clase :S
    public TGrafoNoDirigido(TAristas aristas, LinkedList<TVertice> vertices, LinkedList<TArista> aristass) {
        super(vertices, aristass);
        this.aristas =  (TAristas) aristas;
        
    }

    public TAristas getAristas(){
        return aristas;
    }
    
    public void cargarArista(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Double costo) {
        aristas.insertarAlFinal(new TArista(etiquetaOrigen, etiquetaDestino,
                costo));
        aristas.insertarAlFinal(new TArista(etiquetaDestino, etiquetaOrigen,
                costo)); // para que no falle la busqueda del min y destino
        insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
    }

    
	// este procedimiento de PRIM usa la lista de aristas expl�cita para
    // resolver. Por claridad y seguridad, se arman listas de v�rtices para
    // trabajar,
    // "VerticesU" y "VerticesV", de forma de hacerlo lo m�s parecido posible al
    // seudoc�digo abstracto.
    // al final devuelve un nuevo grafo no dirigido que es el �rbol abarcador de
    // costo m�nimo obtenido.
    public TGrafoNoDirigido Prim() {
        // devuelve un nuevo grafo, que es el Arbol Abarcador de Costo M�nimo
        int costoPrim = 0;
    // puse treeMap porque me ayuda en un casteo que metia, es tree porque asi saco 
        // al primero de VerticeV para ponerlo en el U , el aristasAAM no le encontre uso
        
        TreeMap<Comparable, TVertice> VerticesU = new TreeMap<>();
        TreeMap<Comparable, TVertice> VerticesV = new TreeMap<Comparable, TVertice>(vertices);
        TreeSet<TAristas> AristasAAM = new TreeSet<TAristas>();
        TArista tempArista;
        TGrafoNoDirigido nuevoGrafo = new TGrafoNoDirigido();
        if (vertices.isEmpty()) {
            return null;
        }
        
        // agarra al primero de vertivesV
        Map.Entry<Comparable, TVertice> tempV = VerticesV.firstEntry();
        
        // armar la lista VerticesV de trabajo
        // saca al primero de verticesV y lo pone en el U
        // lo hubiera hecho mas prolijo pero trate de borrar lo menos posible de lo q ya venia
            VerticesV.pollFirstEntry();
            VerticesU.put(tempV.getKey(),tempV.getValue());
        
        //---------COMPLETAR ALGORITMO--------
		
		// pasar el primero de V a U
		
        while (!VerticesV.isEmpty()) {
            //metodo de TAristas que ayuda
            TArista arista = aristas.buscarMin(VerticesU.values(), VerticesV.values());
            //costo del arbol
            costoPrim += arista.getCosto(); 
            //saca la arista de v y la pone en u
            TVertice vert = VerticesV.remove(arista.getEtiquetaDestino());
            //tuve que meter este if porque no me tomaba el tema de las aristas al revez
            //quedo chancho, lo se
            if(vert==null){
                vert = VerticesV.remove(arista.getEtiquetaOrigen());
            }
            //pone en el u, y va creando el nuevo grafo, pero ahora carga las aristas dobles, esta bastante extraño
            VerticesU.put(vert.getEtiqueta(),vert);
            nuevoGrafo.cargarArista(arista.getEtiquetaOrigen(), arista.getEtiquetaDestino(), arista.getCosto());
            // elegir una arista de costo minimo que vaya de U a V, agregarla a
            // la lista de aristas del AAM, quitar el v�rtice v de V y agregarlo
            // a U
            //---------COMPLETAR ALGORITMO--------
        }

        System.out.println("costo AAM: " + costoPrim);

		//A partir de la lista de vertices VerticesU y las aristas en AristasAAM armar el grafo nuevoGrafo y retornarlo
        //---------COMPLETAR ALGORITMO--------
        this.restablecer();
        return nuevoGrafo;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean insertarAdyacencia(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Double costo) {
        return (super
                .insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo) && super
                .insertarAdyacencia(etiquetaDestino, etiquetaOrigen, costo));
    }
    
    /**
     * Bea visita los vértices conectados a v usando búsqueda en amplitud.
     * @param etiqueta Recibe la etiqueta del vértice que será su origen.
     * @return Devuelve en un conjunto ordenado de vertices pertenecientes al arbol abarcador de v.
     */
    public Collection<Comparable> bea(Comparable etiqueta){
        LinkedList<Comparable> bea = new LinkedList<>(); //Hice esta chanchada para poder usar el bea para ambos
                                                         //Metodos, entonces el bea interno no reestablece
                                                         //Asi se puede usar para el bea gral, y no vuelve a visitar
                                                         //A todos los vertices que ya visito como previo pio
        if(vertices.containsKey(etiqueta)){
            bea= (LinkedList<Comparable>) beaInterno(etiqueta);
        }
        this.restablecer();
        return bea;
    }
    
    public Collection<Comparable> beaInterno(Comparable etiqueta){
        //Busco el vértice en el map de vertices según etiqueta
                TVertice origen=this.vertices.get(etiqueta);
        //Verifico que exista el vértice.
        if (origen==null){
            return null;
        }
        TVertice aux;                                           //Se usará luego
        LinkedList<Comparable> bosque=new LinkedList();               //Acá se guardan las etiquetas de los vértices
        Queue<TVertice> cola=new ArrayDeque();                  /*La cola va a guardar los vértices pendientes 
                                                                a visitar sus adyacentes*/
        origen.setVisitado(true);                               //visito el vertice actual.
        cola.add(origen);                                       //Agrego a la cola
        bosque.add(etiqueta);                                   //Agrego la etiqueta al bosque.
        while(!cola.isEmpty()){
            aux=cola.remove();                                  //Saco el primer elemento
            for (TAdyacencia ady : aux.getAdyacentes()) {
                TVertice ver = ady.getDestino();
                if(!ver.getVisitado()){
                    ver.setVisitado(true);                      //Lo visito
                    cola.add(ver);                              //Agrego a la cola
                    bosque.add(ver.getEtiqueta());              //Agrego la etiqueta al bosque
                }
            }
        }        
        //POR LAS DUDAS SINÓ DESPUÉS NO NOS ANDA NADA XD
        return bosque;
    }
    
    public Collection<Comparable> bea(){
        LinkedList<Comparable> bosque=new LinkedList(); 
        for (TVertice v : vertices.values()) {  //Por esta linea devuelve lo que quiere al final del bea
                                                //O sea, esta correcto pero los vertices estan guardados
                                                //En un Hashmap, por ende guarda como quiere
                                                //Por eso devuelve los vertices ordenados alfabeticamente en el bea gral
                                                //Cuando en el archivo puede que los vertices esten en otro orden
            if(!v.getVisitado()){
                bosque.addAll(beaInterno(v.getEtiqueta()));
            }
        }
        restablecer();
        return bosque;
    }
    
    
    /**
     * se utiliza para saber si es conexo.
     * @return devuelve Verdadero si el grafo es conexo.
     */
    public boolean esConexo(){
        boolean resultado=false;
        TreeMap<Comparable,TVertice> ver=new TreeMap(vertices);
        Map.Entry<Comparable,TVertice> v= ver.pollFirstEntry();
            //Si un vértice tiene n-1 aristas, siendo n la cantidad de vértices ya está.
            if (v.getValue().getAdyacentes().size()==vertices.size()-1){
                return true;
            }
            Collection beaV=this.bea(v.getKey());
            Collection beaGen=this.bea();
            resultado=beaV.containsAll(beaGen);
        return resultado;
    }

    /**
     * encuentra el arbol abarcador de costo minimo. 
     * PD: mas chancho que la copa america ganada por chile...
     * Emprolijar esto plssss, el orden de ejecucion se debe ir de tema
     * @return devuelve el árbol abarcador de costo minimo.
     */
    public TGrafoNoDirigido kruskal(){
        //Aca guardo los componentes conexos
        LinkedList<HashMap<Comparable,TVertice>> componentes = new LinkedList<>();
        //Creo el grafo que devuelvo
        TGrafoNoDirigido grafo = new TGrafoNoDirigido();
        //Creo los componentes conexos individuales
        for (Map.Entry<Comparable, TVertice> entrySet : vertices.entrySet()) {
            HashMap<Comparable,TVertice> comp = new HashMap<>();
            comp.put(entrySet.getKey(),entrySet.getValue());
            componentes.add(comp);
        }
        //Aca arranca la magia donde voy disminuyendo componentes
        while(componentes.size() > 1){
            //Inicializo variables
            TArista aristaMin = null;
            Double costMin = Double.MAX_VALUE;
            //noVale variable de control, para saber si la arista tiene sus vertices en el mismo componente
            Boolean noVale = false;
            //Recorro todas las aristas magicas
            for (TArista ari  : aristas.getAristas()) {
                //Aca la comparo con el minimo guardado daaa
                if(ari.getCosto()<costMin){
                    //Recorro los componentes y me fijo si la arista esta con sus vertices
                    //en el mismo componente conexo
                    for (HashMap<Comparable,TVertice> componente : componentes) {
                        if (componente.containsKey(ari.getEtiquetaOrigen()) && 
                                componente.containsKey(ari.getEtiquetaDestino())) {
                            noVale=true;
                        }
                    }
                    //Si no tiene los vertices en el mismo componente la hago mi arista minima momentanea
                    if(!noVale){
                        aristaMin = ari;
                        costMin = ari.getCosto();
                    }                    
                }
                //reestablesco el noVale e.e
                noVale=false;
            }
            //despues de este bucle consegui mi arista minima, asi que la cargo
            // y luego combino los 2 componentes conexos de sus vertices
            grafo.cargarArista(aristaMin.getEtiquetaOrigen(), aristaMin.getEtiquetaDestino(),
                    aristaMin.getCosto());
            //variables auxiliares
            HashMap<Comparable, TVertice> aux = null;
            HashMap<Comparable, TVertice> aux2 = null; 
            //recorro los componentes y saco donde estan los vertices, MEJORAR ESTO PLS
            //quise arreglarlo y dejarlo recorriendo solo una vez los componentes
            // para que recorra solo al ppio pero lo rompi 
            for (HashMap<Comparable, TVertice> componente : componentes) {
                if(componente.containsKey(aristaMin.getEtiquetaOrigen())){
                    aux = componente;
                }
                if(componente.containsKey(aristaMin.getEtiquetaDestino())){
                    aux2 = componente;
                }
            }
            //pongo todos los vertices en un componente y elimino el otro
            aux.putAll(aux2);
            componentes.remove(aux2);
        }
        return grafo;
    }
    
    /**
     * Encuentra los vertices tales que si se desconectan el grafo se divide
     * @return devuelve una lista de los vertices que son puntos de articulación.
     */
    public Collection<TVertice> puntosArticulacion(){
        return new HashSet<TVertice>();
    }
    
    
    /**
     * algoritmo alternativo para el método de kruskal, no tocar.
     * @return el grafo.
     */
    public TGrafoNoDirigido kruskalImp(){
       TAristas F =new TAristas();
       do{
               /*elegir una arista de costo minimo tal que no esté en F ni haya sido elegida
               Si la arista no conecta dos verices del mismo componenete entonces agregarla a F;*/
               
       }while(F.getAristas().size()==vertices.size()-1);
       return null;
    }
    
}
