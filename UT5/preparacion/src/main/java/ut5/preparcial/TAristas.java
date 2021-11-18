package ut5.preparcial;
import java.util.Collection;

import java.util.LinkedList;
import java.util.function.DoubleUnaryOperator;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    
    private Collection<TArista> aristas  = new LinkedList<TArista>();

    /**
     * Busca dentro de la lista de aristas una arista que conecte a etOrigen con
     * etDestino
     *
     * @param etOrigen
     * @param etDestino
     * @return
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        
        TArista result = null;
        for(TArista aristaAux : this){
            if(aristaAux.etiquetaOrigen.compareTo(etOrigen) == 0 && aristaAux.etiquetaDestino.compareTo(etDestino) == 0){
                result = aristaAux;
                break;
            }
        }
        return result;
    }

    /**
     * Busca la arista de menor costo que conecte a cualquier nodo de VerticesU
     * con cualquier otro de VerticesV y cuyo costo sea el minimo
     *
     * @param VerticesU - Lista de vertices U
     * @param VerticesV - Lista de vertices V
     * @return
     */
    public TArista buscarMin(Collection<Comparable> VerticesU, Collection<Comparable> VerticesV) {

        //---------COMPLETAR ALGORITMO--------
        // para todo u en Vertices U
        // para todo v en Vertices V
        // tA =buscar (u, v)
        // si tA <> null y tA.costo < costoMin entonces
        // tAMin = tA y costoMin = tA.costo
        // fin para todo v
        // fin para todo u
        // devolver tAMin
        TArista tAMin = null;
        double costoMin = Double.MAX_VALUE;

        for(Comparable u : VerticesU){
            for(Comparable v: VerticesV){
                TArista tA = buscar(u, v);
                if(tA != null && tA.costo < costoMin){
                    costoMin = tA.costo;
                    tAMin = tA;
                }
            }
        }
        return tAMin;
    }

    /**
     * Imprime las etiquetas ORIGEN - DESTINO - COSTO.
     */
    public String imprimirEtiquetas() {

        if (this.isEmpty()) {
            return null;
        }
        StringBuilder salida = new StringBuilder();
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        String linea = "";
        for (TArista arista : this.aristas) {
            linea = arista.getEtiquetaOrigen() + SEPARADOR_ELEMENTOS_IMPRESOS + arista.getEtiquetaDestino() + SEPARADOR_ELEMENTOS_IMPRESOS + arista.getCosto();
            salida.append(linea);
        }
        return salida.toString();
    }

    public void insertarAmbosSentidos(Collection<TArista> aristas) {
        if (aristas == null) return;
        //TArista tempArista;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }

}
