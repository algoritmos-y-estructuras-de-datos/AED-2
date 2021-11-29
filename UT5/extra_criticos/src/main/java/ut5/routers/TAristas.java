package ut5.routers;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    // private Collection<TArista> aristas = new LinkedList<TArista>();

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
        TArista tempArista;
        TArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;

        for (Comparable u : VerticesU) {
            for (Comparable v : VerticesV) {
                tempArista = buscar(u, v);
                if (tempArista != null) {
                    if (tempArista.getCosto() < costoMin) {
                        costoMin = tempArista.getCosto();
                        tAMin = tempArista;
                    }
                }
            }
        }
        return tAMin;
    }

    public String imprimirEtiquetas() {
        if (this.isEmpty()) {
            //return null;
            return "";
        }
        //StringBuilder salida = new StringBuilder();
        String salida = "";
        // siguiente formato:
        // ORIGEN - DESTINO - COSTO
        for(TArista ta : this){
            salida=salida+ta.getEtiquetaOrigen()+"-"+ta.getEtiquetaDestino()+"-"+ta.getCosto()+"\n";
        }
        return salida.toString();
    }

    void insertarAmbosSentidos(Collection<TArista> aristas) {
        TArista tempArista;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }

    public LinkedList<TArista> obtenerAristasOrdenadasPorCosto() {
        LinkedList<TArista> res = new LinkedList<>(this);
        res.sort(new Comparator<TArista>() {
            @Override
            public int compare(TArista o1, TArista o2) {
                if (o1.costo < o2.costo) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return res;
    }

}
