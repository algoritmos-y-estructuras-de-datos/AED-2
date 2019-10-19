
import java.util.Collection;

import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    private LinkedList<TArista> aristas  = new LinkedList<TArista>();

    
    public TAristas(Collection<TArista> aristas){
        //this.aristas = new LinkedList<>(aristas);
        this.aristas = (LinkedList<TArista>) aristas;
        //System.out.println(aristas.size());
    }
    
    public TAristas(){
        this.aristas=new LinkedList();
    }
    /**
     * Busca dentro de la lista de aristas una arista que conecte a etOrigen con
     * etDestino
     *
     * @param etOrigen
     * @param etDestino
     * @return
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        TArista tempArista;
        for (TArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                return laa;
            }
        }

        return null;
    }

    /**
     * Busca la arista de menor costo que conecte a cualquier nodo de VerticesU
     * con cualquier otro de VerticesV y cuyo costo sea el minimo
     *
     * @param VerticesU - Lista de vertices U
     * @param VerticesV - Lista de vertices V
     * @return
     */
    public TArista buscarMin(Collection<TVertice> VerticesU, Collection<TVertice> VerticesV) {
        //Cambie Collection<Comparable> a Collection<TVertice>
        TArista tempArista = null;
        TArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;
        
        for(TVertice u : VerticesU){
            for(TVertice v : VerticesV){
                tempArista = buscar(u.getEtiqueta(), v.getEtiqueta());
                if(tempArista != null && tempArista.getCosto() < costoMin){
                    tAMin = tempArista;
                    costoMin = tAMin.getCosto();
                }
            }
        }
        //---------COMPLETAR ALGORITMO--------
        // para todo u en Vertices U
        // para todo v en Vertices V
        // tA =buscar (u, v)
        // si tA <> null y tA.costo < costoMin entonces
        // tAMin = tA y costoMin = tA.costo
        // fin para todo v
        // fin para todo u
        // devolver tAMin
        return tAMin;
    }

    public String imprimirEtiquetas() {
        if (aristas.isEmpty()) {
            return "";
        }
        String salida = "";
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        for(TArista ta : aristas){
            salida=salida+ta.getEtiquetaOrigen()+"-"+ta.getEtiquetaDestino()+"-"+ta.getCosto()+"\n";
        }
        return salida;
    }

    void insertarAmbosSentidos(Collection<TArista> aristas) {
        TArista tempArista;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
        //System.out.println(this.aristas.size());
    }
    public LinkedList<TArista> getAristas(){
        return aristas;
    }
    public void insertarAlFinal(TArista tArista) {
        aristas.addLast(tArista);
    }

}
