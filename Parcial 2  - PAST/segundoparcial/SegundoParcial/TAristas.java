package SegundoParcial;

import UT05.*;
import java.util.Collection;
import java.util.LinkedList;

public class TAristas {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    private LinkedList<TArista> aristas; // = new {IMPLEMENTACION DE COLLECTION DESEADA}
    
    //meti linked porque me pinto...
    public TAristas(Collection<TArista> aristas){
        this.aristas = new LinkedList<>(aristas);
    }
    
    public TAristas(){
        this.aristas=new LinkedList();
    }
    
    public LinkedList<TArista> getAristas(){
        return aristas;
    }
    /**
     * Busca dentro de la lista de aristas una arista que conecte a 
     * etOrigen con etDestino
     * @param etOrigen
     * @param etDestino
     * @return 
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        TArista miArista = null;
        for (TArista arista : aristas) {
            //meti el if para que me controle la arista en ambos sentidos, es raro 
            //ya que no las carga dobles automaticamente
            if((arista.etiquetaOrigen.equals(etOrigen) && arista.etiquetaDestino.equals(etDestino))
                    || (arista.etiquetaOrigen.equals(etDestino) && arista.etiquetaDestino.equals(etOrigen))){
                miArista = arista;
            }
        }
        return miArista;
    }

    /**
     * Busca la arista de menor costo que conecte a cualquier nodo de
     * VerticesU con cualquier otro de VerticesV y cuyo costo sea el minimo
     * @param VerticesU - Lista de vertices U
     * @param VerticesV - Lista de vertices V
     * @return 
     */
    public TArista buscarMin(Collection<TVertice> VerticesU, Collection<TVertice> VerticesV) {
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
        //TODO: ---------COMPLETAR ALGORITMO--------
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
            return null;
        }
        StringBuilder salida = new StringBuilder();
        for (TArista arista : aristas) {            
            salida.append(arista.getEtiquetaOrigen() + " - " + arista.getEtiquetaDestino() + " - " + arista.getCosto() + "\n");
        }
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        return salida.toString();

    }

    /**
     * Inserta la arista al final de la coleccion de aristas
     * @param tArista 
     */
    public void insertarAlFinal(TArista tArista) {
        aristas.addLast(tArista);
    }

}
